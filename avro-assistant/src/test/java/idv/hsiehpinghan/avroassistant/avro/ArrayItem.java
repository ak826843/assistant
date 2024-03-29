/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package idv.hsiehpinghan.avroassistant.avro;  
@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class ArrayItem extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"ArrayItem\",\"namespace\":\"idv.hsiehpinghan.avroassistant.avro\",\"fields\":[{\"name\":\"id\",\"type\":\"long\"},{\"name\":\"name\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
   private long id;
   private java.lang.CharSequence name;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>. 
   */
  public ArrayItem() {}

  /**
   * All-args constructor.
   */
  public ArrayItem(java.lang.Long id, java.lang.CharSequence name) {
    this.id = id;
    this.name = name;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return name;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.Long)value$; break;
    case 1: name = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'id' field.
   */
  public java.lang.Long getId() {
    return id;
  }

  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(java.lang.Long value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'name' field.
   */
  public java.lang.CharSequence getName() {
    return name;
  }

  /**
   * Sets the value of the 'name' field.
   * @param value the value to set.
   */
  public void setName(java.lang.CharSequence value) {
    this.name = value;
  }

  /** Creates a new ArrayItem RecordBuilder */
  public static idv.hsiehpinghan.avroassistant.avro.ArrayItem.Builder newBuilder() {
    return new idv.hsiehpinghan.avroassistant.avro.ArrayItem.Builder();
  }
  
  /** Creates a new ArrayItem RecordBuilder by copying an existing Builder */
  public static idv.hsiehpinghan.avroassistant.avro.ArrayItem.Builder newBuilder(idv.hsiehpinghan.avroassistant.avro.ArrayItem.Builder other) {
    return new idv.hsiehpinghan.avroassistant.avro.ArrayItem.Builder(other);
  }
  
  /** Creates a new ArrayItem RecordBuilder by copying an existing ArrayItem instance */
  public static idv.hsiehpinghan.avroassistant.avro.ArrayItem.Builder newBuilder(idv.hsiehpinghan.avroassistant.avro.ArrayItem other) {
    return new idv.hsiehpinghan.avroassistant.avro.ArrayItem.Builder(other);
  }
  
  /**
   * RecordBuilder for ArrayItem instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<ArrayItem>
    implements org.apache.avro.data.RecordBuilder<ArrayItem> {

    private long id;
    private java.lang.CharSequence name;

    /** Creates a new Builder */
    private Builder() {
      super(idv.hsiehpinghan.avroassistant.avro.ArrayItem.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(idv.hsiehpinghan.avroassistant.avro.ArrayItem.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.name)) {
        this.name = data().deepCopy(fields()[1].schema(), other.name);
        fieldSetFlags()[1] = true;
      }
    }
    
    /** Creates a Builder by copying an existing ArrayItem instance */
    private Builder(idv.hsiehpinghan.avroassistant.avro.ArrayItem other) {
            super(idv.hsiehpinghan.avroassistant.avro.ArrayItem.SCHEMA$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.name)) {
        this.name = data().deepCopy(fields()[1].schema(), other.name);
        fieldSetFlags()[1] = true;
      }
    }

    /** Gets the value of the 'id' field */
    public java.lang.Long getId() {
      return id;
    }
    
    /** Sets the value of the 'id' field */
    public idv.hsiehpinghan.avroassistant.avro.ArrayItem.Builder setId(long value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'id' field has been set */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'id' field */
    public idv.hsiehpinghan.avroassistant.avro.ArrayItem.Builder clearId() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'name' field */
    public java.lang.CharSequence getName() {
      return name;
    }
    
    /** Sets the value of the 'name' field */
    public idv.hsiehpinghan.avroassistant.avro.ArrayItem.Builder setName(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.name = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'name' field has been set */
    public boolean hasName() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'name' field */
    public idv.hsiehpinghan.avroassistant.avro.ArrayItem.Builder clearName() {
      name = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public ArrayItem build() {
      try {
        ArrayItem record = new ArrayItem();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.Long) defaultValue(fields()[0]);
        record.name = fieldSetFlags()[1] ? this.name : (java.lang.CharSequence) defaultValue(fields()[1]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
