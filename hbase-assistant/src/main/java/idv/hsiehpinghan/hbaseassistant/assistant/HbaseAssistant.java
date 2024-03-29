package idv.hsiehpinghan.hbaseassistant.assistant;

import idv.hsiehpinghan.hbaseassistant.abstractclass.HBaseColumnFamily;
import idv.hsiehpinghan.hbaseassistant.abstractclass.HBaseColumnQualifier;
import idv.hsiehpinghan.hbaseassistant.abstractclass.HBaseRowKey;
import idv.hsiehpinghan.hbaseassistant.abstractclass.HBaseTable;
import idv.hsiehpinghan.hbaseassistant.abstractclass.HBaseValue;
import idv.hsiehpinghan.hbaseassistant.enumeration.TableOperation;
import idv.hsiehpinghan.hbaseassistant.extension.HbaseTemplateExtension;
import idv.hsiehpinghan.hbaseassistant.property.HbaseAssistantProperty;
import idv.hsiehpinghan.objectutility.utility.ClassUtility;
import idv.hsiehpinghan.objectutility.utility.ObjectUtility;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeSet;

import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.KeyOnlyFilter;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.hadoop.hbase.TableCallback;
import org.springframework.stereotype.Component;

@Component
public class HbaseAssistant implements InitializingBean {
	private Logger logger = Logger.getLogger(this.getClass().getName());

	@Autowired
	private HBaseAdmin admin;
	@Autowired
	private HbaseTemplateExtension hbaseTemplate;
	@Autowired
	private HbaseAssistantProperty hbaseAssistantProperty;

	@Override
	public void afterPropertiesSet() throws Exception {
		TableOperation operation = TableOperation
				.valueOf(hbaseAssistantProperty.getTableOperation());
		if (TableOperation.NONE.equals(operation)) {
			return;
		}
		Class<?>[] entityClasses = ClassUtility.getAssignableClasses(
				"idv.hsiehpinghan", HBaseTable.class);
		createTables(entityClasses, operation);
	}

	/**
	 * Add a row.
	 * 
	 * @param entity
	 * @throws IllegalAccessException
	 */
	public void put(HBaseTable entity) throws IllegalAccessException {
		List<HBaseTable> entities = new ArrayList<HBaseTable>(1);
		entities.add(entity);
		put(entities);
	}

	/**
	 * Add multi-rows.
	 * 
	 * @param entities
	 * @throws IllegalAccessException
	 */
	public void put(List<? extends HBaseTable> entities)
			throws IllegalAccessException {
		int size = entities.size();
		if (size == 0) {
			return;
		}
		final List<Put> puts = new ArrayList<Put>();

		Class<?> cls = entities.get(0).getClass();
		String tableName = cls.getSimpleName();
		for (int i = 0; i < size; ++i) {
			HBaseTable entity = entities.get(i);
			// Get row key
			byte[] rowKey = getRowKey(entity).getBytes();
			final Put put = new Put(rowKey);
			puts.add(put);
			// Get column families
			List<Field> colFamFlds = getColumnFamilyFields(cls);
			for (Field famFld : colFamFlds) {
				String colFamNm = famFld.getName();
				Object colFamObj = ObjectUtility.readField(entity, colFamNm);
				if (colFamObj == null) {
					continue;
				}
				List<Field> qualMapFields = ObjectUtility
						.getFieldsByAssignableType(colFamObj.getClass(),
								Map.class);
				byte[] columnFamily = Bytes.toBytes(colFamNm);
				// Get qualifier and value
				for (Field qualMapField : qualMapFields) {
					@SuppressWarnings("unchecked")
					Map<HBaseColumnQualifier, Map<Date, HBaseValue>> qualMap = (Map<HBaseColumnQualifier, Map<Date, HBaseValue>>) ObjectUtility
							.readField(colFamObj, qualMapField.getName());
					if (qualMap == null) {
						continue;
					}
					for (Map.Entry<HBaseColumnQualifier, Map<Date, HBaseValue>> qualEntry : qualMap
							.entrySet()) {
						byte[] qualifier = qualEntry.getKey().getBytes();
						Map<Date, HBaseValue> verMap = qualEntry.getValue();
						for (Map.Entry<Date, HBaseValue> verEntry : verMap
								.entrySet()) {
							long version = verEntry.getKey().getTime();
							byte[] value = verEntry.getValue().getBytes();
							put.add(columnFamily, qualifier, version, value);
						}
					}
				}
			}
		}

		hbaseTemplate.execute(tableName, new TableCallback<Void>() {
			@Override
			public Void doInTable(HTableInterface tableItf) throws Throwable {
				tableItf.put(puts);
				return null;
			}
		});
	}

	/**
	 * Get Hbase entity.
	 * 
	 * @param rowKey
	 * @return
	 * @throws IllegalAccessException
	 * @throws IOException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public HBaseTable get(HBaseRowKey rowKey) throws IllegalAccessException,
			IOException, NoSuchMethodException, SecurityException,
			InstantiationException, IllegalArgumentException,
			InvocationTargetException {
		HBaseTable entity = rowKey.getEntity();
		get(entity, 1, null, null, null);
		return entity;
	}

	/**
	 * Get Hbase entity.
	 * 
	 * @param entity
	 * @param maxVersions
	 * @param minDate
	 * @param maxDate
	 * @param filter
	 * @throws IllegalAccessException
	 * @throws IOException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public void get(final HBaseTable entity, int maxVersions, Date minDate,
			Date maxDate, Filter filter) throws IllegalAccessException,
			IOException, NoSuchMethodException, SecurityException,
			InstantiationException, IllegalArgumentException,
			InvocationTargetException {
		final Get get = generateGet(entity, maxVersions, minDate, maxDate,
				filter);
		hbaseTemplate.execute(entity.getTableName(), new TableCallback<Void>() {
			@Override
			public Void doInTable(HTableInterface tableItf) throws Throwable {
				Result result = tableItf.get(get);
				generateColumFamilysContent(entity, result, false);
				return null;
			}
		});
	}

	/**
	 * Scan all records.
	 * 
	 * @param entityClass
	 * @return
	 */
	public TreeSet<HBaseTable> scan(Class<? extends HBaseTable> entityClass) {
		return scan(entityClass, null);
	}

	/**
	 * Scan records by filter.
	 * 
	 * @param entityClass
	 * @param filter
	 * @return
	 */
	public TreeSet<HBaseTable> scan(
			final Class<? extends HBaseTable> entityClass, final Filter filter) {
		String tableName = entityClass.getSimpleName();
		return hbaseTemplate.execute(tableName,
				new TableCallback<TreeSet<HBaseTable>>() {
					@Override
					public TreeSet<HBaseTable> doInTable(
							HTableInterface tableItf) throws Throwable {
						Scan scan = new Scan();
						if (filter != null) {
							scan.setFilter(filter);
						}
						ResultScanner scanner = tableItf.getScanner(scan);
						TreeSet<HBaseTable> entities = new TreeSet<HBaseTable>();
						for (Result rslt : scanner) {
							Object entityObj = ObjectUtility
									.createClassInstance(entityClass);
							HBaseTable newEntity = (HBaseTable) entityObj;
							generateRowKeyContent(newEntity, rslt, true);
							generateColumFamilysContent(newEntity, rslt, true);
							entities.add(newEntity);
						}
						return entities;
					}
				});
	}

	/**
	 * Get total row amount.
	 * 
	 * @param entityClass
	 * @return
	 */
	public int getRowAmount(final Class<? extends HBaseTable> entityClass) {
		return scan(entityClass, new KeyOnlyFilter()).size();
	}

	private void generateRowKey(HBaseTable entity)
			throws NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		HBaseRowKey rowKey = entity.getRowKey();
		if (rowKey != null) {
			return;
		}
		Class<?> rowKeyClass = getRowKeyField(entity).getType();
		ObjectUtility.createInnerClassInstance(entity, rowKeyClass, entity);
	}

	private void generateColumFamilys(HBaseTable entity)
			throws IllegalAccessException, NoSuchMethodException,
			SecurityException, InstantiationException,
			IllegalArgumentException, InvocationTargetException {
		List<Field> colFamFlds = getColumnFamilyFields(entity.getClass());
		for (Field famFld : colFamFlds) {
			String colFamNm = famFld.getName();
			Object colFamObj = ObjectUtility.readField(entity, colFamNm);
			if (colFamObj != null) {
				continue;
			}
			Class<?> colFamClass = famFld.getType();
			colFamObj = ObjectUtility.createInnerClassInstance(entity,
					colFamClass, entity);
			ObjectUtility.setField(entity, famFld, colFamObj);
		}
	}

	/**
	 * Drop table.
	 * 
	 * @param tableName
	 * @throws IOException
	 */
	public void dropTable(String tableName) throws IOException {
		if (admin.isTableEnabled(tableName)) {
			admin.disableTable(tableName);
		}
		admin.deleteTable(tableName);
	}

	/**
	 * Check if table exists.
	 * 
	 * @param tableName
	 * @return
	 * @throws IOException
	 */
	public boolean isTableExists(String tableName) throws IOException {
		return admin.tableExists(tableName);
	}

	/**
	 * Check if row exists.
	 * 
	 * @param rowKey
	 * @return
	 */
	public boolean exist(HBaseRowKey rowKey) {
		String tableName = rowKey.getTableName();
		final Get get = new Get(rowKey.getBytes());
		return hbaseTemplate.execute(tableName, new TableCallback<Boolean>() {
			@Override
			public Boolean doInTable(HTableInterface tableItf) throws Throwable {
				return tableItf.exists(get);
			}
		});
	}

	/**
	 * Create table.
	 * 
	 * @param clazz
	 * @throws IOException
	 */
	public void createTable(Class<?> clazz) throws IOException {
		String tableNm = clazz.getSimpleName();
		String[] colFamArr = getColumnFamilyNames(clazz);
		createTable(tableNm, colFamArr);
	}

	void createTable(String tableName, String[] columnFamilies)
			throws IOException {
		HTableDescriptor tDesc = new HTableDescriptor(
				TableName.valueOf(tableName));
		for (int i = 0; i < columnFamilies.length; i++) {
			HColumnDescriptor cDesc = new HColumnDescriptor(columnFamilies[i]);
			tDesc.addFamily(cDesc);
		}
		admin.createTable(tDesc);
		logger.info(tableName + " created.");
	}

	Get generateGet(HBaseTable entity, int maxVersions, Date minDate,
			Date maxDate, Filter filter) throws IllegalAccessException,
			IOException, NoSuchMethodException, SecurityException,
			InstantiationException, IllegalArgumentException,
			InvocationTargetException {
		Get get = new Get(entity.getRowKey().getBytes());
		List<Field> colFamFields = ObjectUtility.getFieldsByAssignableType(
				entity.getClass(), HBaseColumnFamily.class);
		boolean isAllFamNull = isAllColumnFamilyFieldNull(entity, colFamFields);
		for (Field famField : colFamFields) {
			String famName = convertToFiledName(famField);
			Object famObj = ObjectUtility.readField(entity, famName);
			if (famObj == null) {
				if (isAllFamNull == false) {
					continue;
				}
				famObj = ObjectUtility.createInnerClassInstance(entity,
						famField.getType(), entity);
				ObjectUtility.setField(entity, famField, famObj);
			}
			HBaseColumnFamily colFam = (HBaseColumnFamily) famObj;
			Set<Entry<HBaseColumnQualifier, NavigableMap<Date, HBaseValue>>> qualSet = colFam
					.getQualifierVersionValueSet();
			// If column family not set.
			if (qualSet.size() == 0) {
				get.addFamily(Bytes.toBytes(famName));
				continue;
			}
			for (Entry<HBaseColumnQualifier, NavigableMap<Date, HBaseValue>> entry : qualSet) {
				get.addColumn(Bytes.toBytes(famName), entry.getKey().getBytes());
			}
		}
		long minTimestamp = minDate == null ? 0 : minDate.getTime();
		long maxTimestamp = maxDate == null ? Long.MAX_VALUE : maxDate
				.getTime();
		get.setTimeRange(minTimestamp, maxTimestamp);
		if (filter != null) {
			get.setFilter(filter);
		}
		if (maxVersions == 0) {
			get.setMaxVersions();
		} else {
			get.setMaxVersions(maxVersions);
		}
		return get;
	}

	String[] getColumnFamilyNames(Class<?> cls) {
		List<Field> colFamFields = getColumnFamilyFields(cls);
		Set<String> colFamNms = convertToFiledNames(colFamFields);
		String[] strArr = new String[colFamNms.size()];
		colFamNms.toArray(strArr);
		return strArr;
	}

	HColumnDescriptor[] getColumnDescriptors(String tableName) {
		return hbaseTemplate.execute(tableName,
				new TableCallback<HColumnDescriptor[]>() {
					@Override
					public HColumnDescriptor[] doInTable(
							HTableInterface tableItf) throws Throwable {
						HColumnDescriptor[] colDescs = tableItf
								.getTableDescriptor().getColumnFamilies();
						return colDescs;
					}
				});
	}

	boolean isRowExists(final HBaseRowKey rowKey) {
		return hbaseTemplate.execute(rowKey.getTableName(),
				new TableCallback<Boolean>() {
					@Override
					public Boolean doInTable(HTableInterface tableItf)
							throws Throwable {
						Get get = new Get(rowKey.getBytes());
						return tableItf.exists(get);
					}
				});
	}

	void createTables(Class<?>[] classes, TableOperation operation)
			throws IOException {
		for (Class<?> clazz : classes) {
			String tableNm = clazz.getSimpleName();
			if (isTableExists(tableNm)) {
				switch (operation) {
				case ADD_NONEXISTS:
					continue;
				case DROP_CREATE:
					dropTable(tableNm);
					break;
				case NONE:
					continue;
				default:
					throw new RuntimeException("Not implements !!!");
				}
			}
			createTable(clazz);
		}
	}

	private boolean isAllColumnFamilyFieldNull(HBaseTable entity,
			List<Field> colFamFields) throws IllegalAccessException {
		for (Field famField : colFamFields) {
			Object famObj = ObjectUtility.readField(entity, famField.getName());
			if (famObj != null) {
				return false;
			}
		}
		return true;
	}

	private Set<String> convertToFiledNames(List<Field> colFamFields) {
		Set<String> set = new TreeSet<String>();
		for (Field f : colFamFields) {
			set.add(convertToFiledName(f));
		}
		return set;
	}

	private String convertToFiledName(Field colFamField) {
		return colFamField.getName();
	}

	private List<Field> getColumnFamilyFields(Class<?> cls) {
		return ObjectUtility.getFieldsByAssignableType(cls,
				HBaseColumnFamily.class);
	}

	private Field getRowKeyField(HBaseTable entity) {
		List<Field> rowKeyFileds = ObjectUtility.getFieldsByAssignableType(
				entity.getClass(), HBaseRowKey.class);
		int size = rowKeyFileds.size();
		if (size <= 0) {
			throw new RuntimeException(entity.getTableName()
					+ "'s row key not set !!!");
		} else if (size > 1) {
			throw new RuntimeException(entity.getTableName() + " set " + size
					+ " row keys !!!");
		}
		return rowKeyFileds.get(0);
	}

	private HBaseRowKey getRowKey(HBaseTable entity)
			throws IllegalAccessException {
		Field rowKeyField = getRowKeyField(entity);
		Object rowKeyObj = ObjectUtility.readField(entity,
				rowKeyField.getName());
		return (HBaseRowKey) rowKeyObj;
	}

	private void generateRowKeyContent(final HBaseTable entity, Result result,
			boolean ifNullCreateIt) throws NoSuchMethodException,
			SecurityException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		if (ifNullCreateIt) {
			generateRowKey(entity);
		}
		HBaseRowKey rowKey = entity.getRowKey();
		rowKey.setBytes(result.getRow());
	}

	private void generateColumFamilysContent(final HBaseTable entity,
			Result result, boolean ifNullCreateIt)
			throws IllegalAccessException, NoSuchMethodException,
			SecurityException, InstantiationException,
			IllegalArgumentException, InvocationTargetException {
		if (ifNullCreateIt) {
			generateColumFamilys(entity);
		}
		NavigableMap<byte[], NavigableMap<byte[], NavigableMap<Long, byte[]>>> map = result
				.getMap();
		if (map == null) {
			return;
		}
		// Set column family.
		for (Map.Entry<byte[], NavigableMap<byte[], NavigableMap<Long, byte[]>>> entry : map
				.entrySet()) {
			String colFamNm = Bytes.toString(entry.getKey());
			HBaseColumnFamily colFam = (HBaseColumnFamily) ObjectUtility
					.readField(entity, colFamNm);
			if (colFam == null) {
				continue;
			}
			NavigableMap<byte[], NavigableMap<Long, byte[]>> qualMap = entry
					.getValue();
			colFam.setMap(qualMap);
		}
	}

}
