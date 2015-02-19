package idv.hsiehpinghan.hbaseassistant.entity;

import idv.hsiehpinghan.datetimeutility.utility.DateUtility;
import idv.hsiehpinghan.hbaseassistant.entity.TestTable.DailyFamily;
import idv.hsiehpinghan.hbaseassistant.entity.TestTable.FinancialReportFamily;
import idv.hsiehpinghan.hbaseassistant.entity.TestTable.InfoFamily;
import idv.hsiehpinghan.hbaseassistant.entity.TestTable.MonthlyFamily;
import idv.hsiehpinghan.hbaseassistant.entity.TestTable.RowKey;
import idv.hsiehpinghan.hbaseassistant.entity.TestTable.XbrlInstanceFamily;
import idv.hsiehpinghan.hbaseassistant.enumeration.Enumeration;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestTableTest {
	private Date ver = DateUtility.getDate(2015, 2, 3);
	private String elementId = "elementId";
	private String stockCode = "stockCode";
	private BigInteger operatingIncomeOfCurrentMonth = new BigInteger("3");
	private String unitType = "unitType";
	private Date date = DateUtility.getDate(2015, 2, 3);
	private BigDecimal closingConditionOfOpeningPrice = new BigDecimal("6.6");
	private BigDecimal operatingIncomeOfDifferentPercent = new BigDecimal("7.7");
	private BigInteger closingConditionOfStockAmount = new BigInteger("8");
	private String operatingIncomeOfComment = "operatingIncomeOfComment";
	private String string = "string";
	private BigDecimal value = new BigDecimal("11.11");
	private int month = 12;
	private int year = 13;
	private Enumeration enumeration = null;
	private Date instant = DateUtility.getDate(2015, 2, 3);

	@Test
	public void bytesConvert() {
		TestTable entity = new TestTable();
		testRowKey(entity);
		testInfoFamily(entity);
		testXbrlInstanceFamily(entity);
		testFinancialReportFamily(entity);
		testMonthlyFamily(entity);
		testDailyFamily(entity);
	}

	private void testRowKey(TestTable entity) {
		RowKey key = entity.new RowKey(stockCode, entity);
		Assert.assertEquals(stockCode, key.getStockCode());
	}

	private void testInfoFamily(TestTable entity) {
		generateInfoFamilyContent(entity);
		assertInfoFamily(entity);
	}

	private void generateInfoFamilyContent(TestTable entity) {
		InfoFamily fam = entity.getInfoFamily();
		fam.setEnumeration(ver, enumeration);
		fam.setString(ver, string);
	}

	private void assertInfoFamily(TestTable entity) {
		InfoFamily fam = entity.getInfoFamily();
		Assert.assertEquals(enumeration, fam.getEnumeration());
		Assert.assertEquals(string, fam.getString());
	}

	private void testXbrlInstanceFamily(TestTable entity) {
		generateXbrlInstanceFamilyContent(entity);
		assertXbrlInstanceFamily(entity);
	}

	private void generateXbrlInstanceFamilyContent(TestTable entity) {
		XbrlInstanceFamily fam = entity.getXbrlInstanceFamily();
	}

	private void assertXbrlInstanceFamily(TestTable entity) {
		XbrlInstanceFamily fam = entity.getXbrlInstanceFamily();
	}

	private void testFinancialReportFamily(TestTable entity) {
		generateFinancialReportFamilyContent(entity);
		assertFinancialReportFamily(entity);
	}

	private void generateFinancialReportFamilyContent(TestTable entity) {
		FinancialReportFamily fam = entity.getFinancialReportFamily();
	}

	private void assertFinancialReportFamily(TestTable entity) {
		FinancialReportFamily fam = entity.getFinancialReportFamily();
	}

	private void testMonthlyFamily(TestTable entity) {
		generateMonthlyFamilyContent(entity);
		assertMonthlyFamily(entity);
	}

	private void generateMonthlyFamilyContent(TestTable entity) {
		MonthlyFamily fam = entity.getMonthlyFamily();
		fam.setOperatingIncomeOfCurrentMonth(year, month, ver,
				operatingIncomeOfCurrentMonth);
		fam.setOperatingIncomeOfDifferentPercent(year, month, ver,
				operatingIncomeOfDifferentPercent);
		fam.setOperatingIncomeOfComment(year, month, ver,
				operatingIncomeOfComment);
	}

	private void assertMonthlyFamily(TestTable entity) {
		MonthlyFamily fam = entity.getMonthlyFamily();
		Assert.assertEquals(operatingIncomeOfCurrentMonth,
				fam.getOperatingIncomeOfCurrentMonth(year, month));
		Assert.assertEquals(operatingIncomeOfDifferentPercent,
				fam.getOperatingIncomeOfDifferentPercent(year, month));
		Assert.assertEquals(operatingIncomeOfComment,
				fam.getOperatingIncomeOfComment(year, month));
	}

	private void testDailyFamily(TestTable entity) {
		generateDailyFamilyContent(entity);
		assertDailyFamily(entity);
	}

	private void generateDailyFamilyContent(TestTable entity) {
		DailyFamily fam = entity.getDailyFamily();
		fam.setClosingConditionOfOpeningPrice(date, ver,
				closingConditionOfOpeningPrice);
		fam.setClosingConditionOfStockAmount(date, ver,
				closingConditionOfStockAmount);
	}

	private void assertDailyFamily(TestTable entity) {
		DailyFamily fam = entity.getDailyFamily();
		Assert.assertEquals(closingConditionOfOpeningPrice,
				fam.getClosingConditionOfOpeningPrice(date));
		Assert.assertEquals(closingConditionOfStockAmount,
				fam.getClosingConditionOfStockAmount(date));
	}
}
