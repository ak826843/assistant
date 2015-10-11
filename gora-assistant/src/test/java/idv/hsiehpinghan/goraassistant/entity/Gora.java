/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package idv.hsiehpinghan.goraassistant.entity;  
@SuppressWarnings("all")
/** Gora doc. */
public class Gora extends org.apache.gora.persistency.impl.PersistentBase implements org.apache.avro.specific.SpecificRecord, org.apache.gora.persistency.Persistent {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Gora\",\"namespace\":\"idv.hsiehpinghan.goraassistant.entity\",\"doc\":\"Gora doc.\",\"fields\":[{\"name\":\"_boolean\",\"type\":\"boolean\",\"doc\":\"boolean doc\",\"default\":true,\"order\":\"ignore\"},{\"name\":\"_int\",\"type\":\"int\",\"doc\":\"int doc\",\"default\":1,\"order\":\"ignore\"},{\"name\":\"_long\",\"type\":\"long\",\"doc\":\"long doc\",\"default\":2,\"order\":\"ignore\"},{\"name\":\"_float\",\"type\":\"float\",\"doc\":\"float doc\",\"default\":1.1,\"order\":\"ignore\"},{\"name\":\"_double\",\"type\":\"double\",\"doc\":\"double doc\",\"default\":2.2,\"order\":\"ignore\"},{\"name\":\"_string\",\"type\":\"string\",\"doc\":\"string doc\",\"default\":\"string\",\"order\":\"ignore\"},{\"name\":\"_record\",\"type\":{\"type\":\"record\",\"name\":\"NestedRecord\",\"fields\":[{\"name\":\"_boolean\",\"type\":\"boolean\",\"doc\":\"boolean doc\",\"default\":true,\"order\":\"ignore\"},{\"name\":\"_int\",\"type\":\"int\",\"doc\":\"int doc\",\"default\":1,\"order\":\"ignore\"}]},\"doc\":\"record doc\",\"default\":{},\"order\":\"ignore\"},{\"name\":\"_enum\",\"type\":{\"type\":\"enum\",\"name\":\"Enumeration\",\"namespace\":\"idv.hsiehpinghan.goraassistant.enumeration\",\"doc\":\"Enumeration doc\",\"symbols\":[\"ENUM_0\",\"ENUM_1\",\"ENUM_2\"]},\"doc\":\"enum doc\",\"default\":\"ENUM_1\",\"order\":\"ignore\"}]}");

  /** Enum containing all data bean's fields. */
  public static enum Field {
    _BOOLEAN(0, "_boolean"),
    _INT(1, "_int"),
    _LONG(2, "_long"),
    _FLOAT(3, "_float"),
    _DOUBLE(4, "_double"),
    _STRING(5, "_string"),
    _RECORD(6, "_record"),
    _ENUM(7, "_enum"),
    ;
    /**
     * Field's index.
     */
    private int index;

    /**
     * Field's name.
     */
    private String name;

    /**
     * Field's constructor
     * @param index field's index.
     * @param name field's name.
     */
    Field(int index, String name) {this.index=index;this.name=name;}

    /**
     * Gets field's index.
     * @return int field's index.
     */
    public int getIndex() {return index;}

    /**
     * Gets field's name.
     * @return String field's name.
     */
    public String getName() {return name;}

    /**
     * Gets field's attributes to string.
     * @return String field's attributes to string.
     */
    public String toString() {return name;}
  };

  public static final String[] _ALL_FIELDS = {
  "_boolean",
  "_int",
  "_long",
  "_float",
  "_double",
  "_string",
  "_record",
  "_enum",
  };

  /**
   * Gets the total field count.
   * @return int field count
   */
  public int getFieldsCount() {
    return Gora._ALL_FIELDS.length;
  }

  /** boolean doc */
  private boolean _boolean;
  /** int doc */
  private int _int;
  /** long doc */
  private long _long;
  /** float doc */
  private float _float;
  /** double doc */
  private double _double;
  /** string doc */
  private java.lang.CharSequence _string;
  /** record doc */
  private idv.hsiehpinghan.goraassistant.entity.NestedRecord _record;
  /** enum doc */
  private idv.hsiehpinghan.goraassistant.enumeration.Enumeration _enum;
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return _boolean;
    case 1: return _int;
    case 2: return _long;
    case 3: return _float;
    case 4: return _double;
    case 5: return _string;
    case 6: return _record;
    case 7: return _enum;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value) {
    switch (field$) {
    case 0: _boolean = (java.lang.Boolean)(value); break;
    case 1: _int = (java.lang.Integer)(value); break;
    case 2: _long = (java.lang.Long)(value); break;
    case 3: _float = (java.lang.Float)(value); break;
    case 4: _double = (java.lang.Double)(value); break;
    case 5: _string = (java.lang.CharSequence)(value); break;
    case 6: _record = (idv.hsiehpinghan.goraassistant.entity.NestedRecord)(value); break;
    case 7: _enum = (idv.hsiehpinghan.goraassistant.enumeration.Enumeration)(value); break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the '_boolean' field.
   * boolean doc   */
  public java.lang.Boolean getBoolean$1() {
    return _boolean;
  }

  /**
   * Sets the value of the '_boolean' field.
   * boolean doc   * @param value the value to set.
   */
  public void setBoolean$1(java.lang.Boolean value) {
    this._boolean = value;
    setDirty(0);
  }
  
  /**
   * Checks the dirty status of the '_boolean' field. A field is dirty if it represents a change that has not yet been written to the database.
   * boolean doc   * @param value the value to set.
   */
  public boolean isBoolean$1Dirty(java.lang.Boolean value) {
    return isDirty(0);
  }

  /**
   * Gets the value of the '_int' field.
   * int doc   */
  public java.lang.Integer getInt$1() {
    return _int;
  }

  /**
   * Sets the value of the '_int' field.
   * int doc   * @param value the value to set.
   */
  public void setInt$1(java.lang.Integer value) {
    this._int = value;
    setDirty(1);
  }
  
  /**
   * Checks the dirty status of the '_int' field. A field is dirty if it represents a change that has not yet been written to the database.
   * int doc   * @param value the value to set.
   */
  public boolean isInt$1Dirty(java.lang.Integer value) {
    return isDirty(1);
  }

  /**
   * Gets the value of the '_long' field.
   * long doc   */
  public java.lang.Long getLong$1() {
    return _long;
  }

  /**
   * Sets the value of the '_long' field.
   * long doc   * @param value the value to set.
   */
  public void setLong$1(java.lang.Long value) {
    this._long = value;
    setDirty(2);
  }
  
  /**
   * Checks the dirty status of the '_long' field. A field is dirty if it represents a change that has not yet been written to the database.
   * long doc   * @param value the value to set.
   */
  public boolean isLong$1Dirty(java.lang.Long value) {
    return isDirty(2);
  }

  /**
   * Gets the value of the '_float' field.
   * float doc   */
  public java.lang.Float getFloat$1() {
    return _float;
  }

  /**
   * Sets the value of the '_float' field.
   * float doc   * @param value the value to set.
   */
  public void setFloat$1(java.lang.Float value) {
    this._float = value;
    setDirty(3);
  }
  
  /**
   * Checks the dirty status of the '_float' field. A field is dirty if it represents a change that has not yet been written to the database.
   * float doc   * @param value the value to set.
   */
  public boolean isFloat$1Dirty(java.lang.Float value) {
    return isDirty(3);
  }

  /**
   * Gets the value of the '_double' field.
   * double doc   */
  public java.lang.Double getDouble$1() {
    return _double;
  }

  /**
   * Sets the value of the '_double' field.
   * double doc   * @param value the value to set.
   */
  public void setDouble$1(java.lang.Double value) {
    this._double = value;
    setDirty(4);
  }
  
  /**
   * Checks the dirty status of the '_double' field. A field is dirty if it represents a change that has not yet been written to the database.
   * double doc   * @param value the value to set.
   */
  public boolean isDouble$1Dirty(java.lang.Double value) {
    return isDirty(4);
  }

  /**
   * Gets the value of the '_string' field.
   * string doc   */
  public java.lang.CharSequence getString$1() {
    return _string;
  }

  /**
   * Sets the value of the '_string' field.
   * string doc   * @param value the value to set.
   */
  public void setString$1(java.lang.CharSequence value) {
    this._string = value;
    setDirty(5);
  }
  
  /**
   * Checks the dirty status of the '_string' field. A field is dirty if it represents a change that has not yet been written to the database.
   * string doc   * @param value the value to set.
   */
  public boolean isString$1Dirty(java.lang.CharSequence value) {
    return isDirty(5);
  }

  /**
   * Gets the value of the '_record' field.
   * record doc   */
  public idv.hsiehpinghan.goraassistant.entity.NestedRecord getRecord$1() {
    return _record;
  }

  /**
   * Sets the value of the '_record' field.
   * record doc   * @param value the value to set.
   */
  public void setRecord$1(idv.hsiehpinghan.goraassistant.entity.NestedRecord value) {
    this._record = value;
    setDirty(6);
  }
  
  /**
   * Checks the dirty status of the '_record' field. A field is dirty if it represents a change that has not yet been written to the database.
   * record doc   * @param value the value to set.
   */
  public boolean isRecord$1Dirty(idv.hsiehpinghan.goraassistant.entity.NestedRecord value) {
    return isDirty(6);
  }

  /**
   * Gets the value of the '_enum' field.
   * enum doc   */
  public idv.hsiehpinghan.goraassistant.enumeration.Enumeration getEnum$1() {
    return _enum;
  }

  /**
   * Sets the value of the '_enum' field.
   * enum doc   * @param value the value to set.
   */
  public void setEnum$1(idv.hsiehpinghan.goraassistant.enumeration.Enumeration value) {
    this._enum = value;
    setDirty(7);
  }
  
  /**
   * Checks the dirty status of the '_enum' field. A field is dirty if it represents a change that has not yet been written to the database.
   * enum doc   * @param value the value to set.
   */
  public boolean isEnum$1Dirty(idv.hsiehpinghan.goraassistant.enumeration.Enumeration value) {
    return isDirty(7);
  }

  /** Creates a new Gora RecordBuilder */
  public static idv.hsiehpinghan.goraassistant.entity.Gora.Builder newBuilder() {
    return new idv.hsiehpinghan.goraassistant.entity.Gora.Builder();
  }
  
  /** Creates a new Gora RecordBuilder by copying an existing Builder */
  public static idv.hsiehpinghan.goraassistant.entity.Gora.Builder newBuilder(idv.hsiehpinghan.goraassistant.entity.Gora.Builder other) {
    return new idv.hsiehpinghan.goraassistant.entity.Gora.Builder(other);
  }
  
  /** Creates a new Gora RecordBuilder by copying an existing Gora instance */
  public static idv.hsiehpinghan.goraassistant.entity.Gora.Builder newBuilder(idv.hsiehpinghan.goraassistant.entity.Gora other) {
    return new idv.hsiehpinghan.goraassistant.entity.Gora.Builder(other);
  }
  
  private static java.nio.ByteBuffer deepCopyToReadOnlyBuffer(
      java.nio.ByteBuffer input) {
    java.nio.ByteBuffer copy = java.nio.ByteBuffer.allocate(input.capacity());
    int position = input.position();
    input.reset();
    int mark = input.position();
    int limit = input.limit();
    input.rewind();
    input.limit(input.capacity());
    copy.put(input);
    input.rewind();
    copy.rewind();
    input.position(mark);
    input.mark();
    copy.position(mark);
    copy.mark();
    input.position(position);
    copy.position(position);
    input.limit(limit);
    copy.limit(limit);
    return copy.asReadOnlyBuffer();
  }
  
  /**
   * RecordBuilder for Gora instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Gora>
    implements org.apache.avro.data.RecordBuilder<Gora> {

    private boolean _boolean;
    private int _int;
    private long _long;
    private float _float;
    private double _double;
    private java.lang.CharSequence _string;
    private idv.hsiehpinghan.goraassistant.entity.NestedRecord _record;
    private idv.hsiehpinghan.goraassistant.enumeration.Enumeration _enum;

    /** Creates a new Builder */
    private Builder() {
      super(idv.hsiehpinghan.goraassistant.entity.Gora.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(idv.hsiehpinghan.goraassistant.entity.Gora.Builder other) {
      super(other);
    }
    
    /** Creates a Builder by copying an existing Gora instance */
    private Builder(idv.hsiehpinghan.goraassistant.entity.Gora other) {
            super(idv.hsiehpinghan.goraassistant.entity.Gora.SCHEMA$);
      if (isValidValue(fields()[0], other._boolean)) {
        this._boolean = (java.lang.Boolean) data().deepCopy(fields()[0].schema(), other._boolean);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other._int)) {
        this._int = (java.lang.Integer) data().deepCopy(fields()[1].schema(), other._int);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other._long)) {
        this._long = (java.lang.Long) data().deepCopy(fields()[2].schema(), other._long);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other._float)) {
        this._float = (java.lang.Float) data().deepCopy(fields()[3].schema(), other._float);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other._double)) {
        this._double = (java.lang.Double) data().deepCopy(fields()[4].schema(), other._double);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other._string)) {
        this._string = (java.lang.CharSequence) data().deepCopy(fields()[5].schema(), other._string);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other._record)) {
        this._record = (idv.hsiehpinghan.goraassistant.entity.NestedRecord) data().deepCopy(fields()[6].schema(), other._record);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other._enum)) {
        this._enum = (idv.hsiehpinghan.goraassistant.enumeration.Enumeration) data().deepCopy(fields()[7].schema(), other._enum);
        fieldSetFlags()[7] = true;
      }
    }

    /** Gets the value of the '_boolean' field */
    public java.lang.Boolean getBoolean$1() {
      return _boolean;
    }
    
    /** Sets the value of the '_boolean' field */
    public idv.hsiehpinghan.goraassistant.entity.Gora.Builder setBoolean$1(boolean value) {
      validate(fields()[0], value);
      this._boolean = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the '_boolean' field has been set */
    public boolean hasBoolean$1() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the '_boolean' field */
    public idv.hsiehpinghan.goraassistant.entity.Gora.Builder clearBoolean$1() {
      fieldSetFlags()[0] = false;
      return this;
    }
    
    /** Gets the value of the '_int' field */
    public java.lang.Integer getInt$1() {
      return _int;
    }
    
    /** Sets the value of the '_int' field */
    public idv.hsiehpinghan.goraassistant.entity.Gora.Builder setInt$1(int value) {
      validate(fields()[1], value);
      this._int = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the '_int' field has been set */
    public boolean hasInt$1() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the '_int' field */
    public idv.hsiehpinghan.goraassistant.entity.Gora.Builder clearInt$1() {
      fieldSetFlags()[1] = false;
      return this;
    }
    
    /** Gets the value of the '_long' field */
    public java.lang.Long getLong$1() {
      return _long;
    }
    
    /** Sets the value of the '_long' field */
    public idv.hsiehpinghan.goraassistant.entity.Gora.Builder setLong$1(long value) {
      validate(fields()[2], value);
      this._long = value;
      fieldSetFlags()[2] = true;
      return this; 
    }
    
    /** Checks whether the '_long' field has been set */
    public boolean hasLong$1() {
      return fieldSetFlags()[2];
    }
    
    /** Clears the value of the '_long' field */
    public idv.hsiehpinghan.goraassistant.entity.Gora.Builder clearLong$1() {
      fieldSetFlags()[2] = false;
      return this;
    }
    
    /** Gets the value of the '_float' field */
    public java.lang.Float getFloat$1() {
      return _float;
    }
    
    /** Sets the value of the '_float' field */
    public idv.hsiehpinghan.goraassistant.entity.Gora.Builder setFloat$1(float value) {
      validate(fields()[3], value);
      this._float = value;
      fieldSetFlags()[3] = true;
      return this; 
    }
    
    /** Checks whether the '_float' field has been set */
    public boolean hasFloat$1() {
      return fieldSetFlags()[3];
    }
    
    /** Clears the value of the '_float' field */
    public idv.hsiehpinghan.goraassistant.entity.Gora.Builder clearFloat$1() {
      fieldSetFlags()[3] = false;
      return this;
    }
    
    /** Gets the value of the '_double' field */
    public java.lang.Double getDouble$1() {
      return _double;
    }
    
    /** Sets the value of the '_double' field */
    public idv.hsiehpinghan.goraassistant.entity.Gora.Builder setDouble$1(double value) {
      validate(fields()[4], value);
      this._double = value;
      fieldSetFlags()[4] = true;
      return this; 
    }
    
    /** Checks whether the '_double' field has been set */
    public boolean hasDouble$1() {
      return fieldSetFlags()[4];
    }
    
    /** Clears the value of the '_double' field */
    public idv.hsiehpinghan.goraassistant.entity.Gora.Builder clearDouble$1() {
      fieldSetFlags()[4] = false;
      return this;
    }
    
    /** Gets the value of the '_string' field */
    public java.lang.CharSequence getString$1() {
      return _string;
    }
    
    /** Sets the value of the '_string' field */
    public idv.hsiehpinghan.goraassistant.entity.Gora.Builder setString$1(java.lang.CharSequence value) {
      validate(fields()[5], value);
      this._string = value;
      fieldSetFlags()[5] = true;
      return this; 
    }
    
    /** Checks whether the '_string' field has been set */
    public boolean hasString$1() {
      return fieldSetFlags()[5];
    }
    
    /** Clears the value of the '_string' field */
    public idv.hsiehpinghan.goraassistant.entity.Gora.Builder clearString$1() {
      _string = null;
      fieldSetFlags()[5] = false;
      return this;
    }
    
    /** Gets the value of the '_record' field */
    public idv.hsiehpinghan.goraassistant.entity.NestedRecord getRecord$1() {
      return _record;
    }
    
    /** Sets the value of the '_record' field */
    public idv.hsiehpinghan.goraassistant.entity.Gora.Builder setRecord$1(idv.hsiehpinghan.goraassistant.entity.NestedRecord value) {
      validate(fields()[6], value);
      this._record = value;
      fieldSetFlags()[6] = true;
      return this; 
    }
    
    /** Checks whether the '_record' field has been set */
    public boolean hasRecord$1() {
      return fieldSetFlags()[6];
    }
    
    /** Clears the value of the '_record' field */
    public idv.hsiehpinghan.goraassistant.entity.Gora.Builder clearRecord$1() {
      _record = null;
      fieldSetFlags()[6] = false;
      return this;
    }
    
    /** Gets the value of the '_enum' field */
    public idv.hsiehpinghan.goraassistant.enumeration.Enumeration getEnum$1() {
      return _enum;
    }
    
    /** Sets the value of the '_enum' field */
    public idv.hsiehpinghan.goraassistant.entity.Gora.Builder setEnum$1(idv.hsiehpinghan.goraassistant.enumeration.Enumeration value) {
      validate(fields()[7], value);
      this._enum = value;
      fieldSetFlags()[7] = true;
      return this; 
    }
    
    /** Checks whether the '_enum' field has been set */
    public boolean hasEnum$1() {
      return fieldSetFlags()[7];
    }
    
    /** Clears the value of the '_enum' field */
    public idv.hsiehpinghan.goraassistant.entity.Gora.Builder clearEnum$1() {
      _enum = null;
      fieldSetFlags()[7] = false;
      return this;
    }
    
    @Override
    public Gora build() {
      try {
        Gora record = new Gora();
        record._boolean = fieldSetFlags()[0] ? this._boolean : (java.lang.Boolean) defaultValue(fields()[0]);
        record._int = fieldSetFlags()[1] ? this._int : (java.lang.Integer) defaultValue(fields()[1]);
        record._long = fieldSetFlags()[2] ? this._long : (java.lang.Long) defaultValue(fields()[2]);
        record._float = fieldSetFlags()[3] ? this._float : (java.lang.Float) defaultValue(fields()[3]);
        record._double = fieldSetFlags()[4] ? this._double : (java.lang.Double) defaultValue(fields()[4]);
        record._string = fieldSetFlags()[5] ? this._string : (java.lang.CharSequence) defaultValue(fields()[5]);
        record._record = fieldSetFlags()[6] ? this._record : (idv.hsiehpinghan.goraassistant.entity.NestedRecord) NestedRecord.newBuilder().build();
        record._enum = fieldSetFlags()[7] ? this._enum : (idv.hsiehpinghan.goraassistant.enumeration.Enumeration) defaultValue(fields()[7]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
  
  public Gora.Tombstone getTombstone(){
  	return TOMBSTONE;
  }

  public Gora newInstance(){
    return newBuilder().build();
  }

  private static final Tombstone TOMBSTONE = new Tombstone();
  
  public static final class Tombstone extends Gora implements org.apache.gora.persistency.Tombstone {
  
      private Tombstone() { }
  
	  		  /**
	   * Gets the value of the '_boolean' field.
	   * boolean doc	   */
	  public java.lang.Boolean getBoolean$1() {
	    throw new java.lang.UnsupportedOperationException("Get is not supported on tombstones");
	  }
	
	  /**
	   * Sets the value of the '_boolean' field.
	   * boolean doc	   * @param value the value to set.
	   */
	  public void setBoolean$1(java.lang.Boolean value) {
	    throw new java.lang.UnsupportedOperationException("Set is not supported on tombstones");
	  }
	  
	  /**
	   * Checks the dirty status of the '_boolean' field. A field is dirty if it represents a change that has not yet been written to the database.
	   * boolean doc	   * @param value the value to set.
	   */
	  public boolean isBoolean$1Dirty(java.lang.Boolean value) {
	    throw new java.lang.UnsupportedOperationException("IsDirty is not supported on tombstones");
	  }
	
				  /**
	   * Gets the value of the '_int' field.
	   * int doc	   */
	  public java.lang.Integer getInt$1() {
	    throw new java.lang.UnsupportedOperationException("Get is not supported on tombstones");
	  }
	
	  /**
	   * Sets the value of the '_int' field.
	   * int doc	   * @param value the value to set.
	   */
	  public void setInt$1(java.lang.Integer value) {
	    throw new java.lang.UnsupportedOperationException("Set is not supported on tombstones");
	  }
	  
	  /**
	   * Checks the dirty status of the '_int' field. A field is dirty if it represents a change that has not yet been written to the database.
	   * int doc	   * @param value the value to set.
	   */
	  public boolean isInt$1Dirty(java.lang.Integer value) {
	    throw new java.lang.UnsupportedOperationException("IsDirty is not supported on tombstones");
	  }
	
				  /**
	   * Gets the value of the '_long' field.
	   * long doc	   */
	  public java.lang.Long getLong$1() {
	    throw new java.lang.UnsupportedOperationException("Get is not supported on tombstones");
	  }
	
	  /**
	   * Sets the value of the '_long' field.
	   * long doc	   * @param value the value to set.
	   */
	  public void setLong$1(java.lang.Long value) {
	    throw new java.lang.UnsupportedOperationException("Set is not supported on tombstones");
	  }
	  
	  /**
	   * Checks the dirty status of the '_long' field. A field is dirty if it represents a change that has not yet been written to the database.
	   * long doc	   * @param value the value to set.
	   */
	  public boolean isLong$1Dirty(java.lang.Long value) {
	    throw new java.lang.UnsupportedOperationException("IsDirty is not supported on tombstones");
	  }
	
				  /**
	   * Gets the value of the '_float' field.
	   * float doc	   */
	  public java.lang.Float getFloat$1() {
	    throw new java.lang.UnsupportedOperationException("Get is not supported on tombstones");
	  }
	
	  /**
	   * Sets the value of the '_float' field.
	   * float doc	   * @param value the value to set.
	   */
	  public void setFloat$1(java.lang.Float value) {
	    throw new java.lang.UnsupportedOperationException("Set is not supported on tombstones");
	  }
	  
	  /**
	   * Checks the dirty status of the '_float' field. A field is dirty if it represents a change that has not yet been written to the database.
	   * float doc	   * @param value the value to set.
	   */
	  public boolean isFloat$1Dirty(java.lang.Float value) {
	    throw new java.lang.UnsupportedOperationException("IsDirty is not supported on tombstones");
	  }
	
				  /**
	   * Gets the value of the '_double' field.
	   * double doc	   */
	  public java.lang.Double getDouble$1() {
	    throw new java.lang.UnsupportedOperationException("Get is not supported on tombstones");
	  }
	
	  /**
	   * Sets the value of the '_double' field.
	   * double doc	   * @param value the value to set.
	   */
	  public void setDouble$1(java.lang.Double value) {
	    throw new java.lang.UnsupportedOperationException("Set is not supported on tombstones");
	  }
	  
	  /**
	   * Checks the dirty status of the '_double' field. A field is dirty if it represents a change that has not yet been written to the database.
	   * double doc	   * @param value the value to set.
	   */
	  public boolean isDouble$1Dirty(java.lang.Double value) {
	    throw new java.lang.UnsupportedOperationException("IsDirty is not supported on tombstones");
	  }
	
				  /**
	   * Gets the value of the '_string' field.
	   * string doc	   */
	  public java.lang.CharSequence getString$1() {
	    throw new java.lang.UnsupportedOperationException("Get is not supported on tombstones");
	  }
	
	  /**
	   * Sets the value of the '_string' field.
	   * string doc	   * @param value the value to set.
	   */
	  public void setString$1(java.lang.CharSequence value) {
	    throw new java.lang.UnsupportedOperationException("Set is not supported on tombstones");
	  }
	  
	  /**
	   * Checks the dirty status of the '_string' field. A field is dirty if it represents a change that has not yet been written to the database.
	   * string doc	   * @param value the value to set.
	   */
	  public boolean isString$1Dirty(java.lang.CharSequence value) {
	    throw new java.lang.UnsupportedOperationException("IsDirty is not supported on tombstones");
	  }
	
				  /**
	   * Gets the value of the '_record' field.
	   * record doc	   */
	  public idv.hsiehpinghan.goraassistant.entity.NestedRecord getRecord$1() {
	    throw new java.lang.UnsupportedOperationException("Get is not supported on tombstones");
	  }
	
	  /**
	   * Sets the value of the '_record' field.
	   * record doc	   * @param value the value to set.
	   */
	  public void setRecord$1(idv.hsiehpinghan.goraassistant.entity.NestedRecord value) {
	    throw new java.lang.UnsupportedOperationException("Set is not supported on tombstones");
	  }
	  
	  /**
	   * Checks the dirty status of the '_record' field. A field is dirty if it represents a change that has not yet been written to the database.
	   * record doc	   * @param value the value to set.
	   */
	  public boolean isRecord$1Dirty(idv.hsiehpinghan.goraassistant.entity.NestedRecord value) {
	    throw new java.lang.UnsupportedOperationException("IsDirty is not supported on tombstones");
	  }
	
				  /**
	   * Gets the value of the '_enum' field.
	   * enum doc	   */
	  public idv.hsiehpinghan.goraassistant.enumeration.Enumeration getEnum$1() {
	    throw new java.lang.UnsupportedOperationException("Get is not supported on tombstones");
	  }
	
	  /**
	   * Sets the value of the '_enum' field.
	   * enum doc	   * @param value the value to set.
	   */
	  public void setEnum$1(idv.hsiehpinghan.goraassistant.enumeration.Enumeration value) {
	    throw new java.lang.UnsupportedOperationException("Set is not supported on tombstones");
	  }
	  
	  /**
	   * Checks the dirty status of the '_enum' field. A field is dirty if it represents a change that has not yet been written to the database.
	   * enum doc	   * @param value the value to set.
	   */
	  public boolean isEnum$1Dirty(idv.hsiehpinghan.goraassistant.enumeration.Enumeration value) {
	    throw new java.lang.UnsupportedOperationException("IsDirty is not supported on tombstones");
	  }
	
		  
  }
  
}

