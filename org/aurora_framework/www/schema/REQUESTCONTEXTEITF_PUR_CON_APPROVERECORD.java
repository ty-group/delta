/**
 * REQUESTCONTEXTEITF_PUR_CON_APPROVERECORD.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.aurora_framework.www.schema;

public class REQUESTCONTEXTEITF_PUR_CON_APPROVERECORD  implements java.io.Serializable {
    private java.lang.String DOCUMENT_NUMBER;

    private java.lang.String CON_STATUS;

    public REQUESTCONTEXTEITF_PUR_CON_APPROVERECORD() {
    }

    public REQUESTCONTEXTEITF_PUR_CON_APPROVERECORD(
           java.lang.String DOCUMENT_NUMBER,
           java.lang.String CON_STATUS) {
           this.DOCUMENT_NUMBER = DOCUMENT_NUMBER;
           this.CON_STATUS = CON_STATUS;
    }


    /**
     * Gets the DOCUMENT_NUMBER value for this REQUESTCONTEXTEITF_PUR_CON_APPROVERECORD.
     * 
     * @return DOCUMENT_NUMBER
     */
    public java.lang.String getDOCUMENT_NUMBER() {
        return DOCUMENT_NUMBER;
    }


    /**
     * Sets the DOCUMENT_NUMBER value for this REQUESTCONTEXTEITF_PUR_CON_APPROVERECORD.
     * 
     * @param DOCUMENT_NUMBER
     */
    public void setDOCUMENT_NUMBER(java.lang.String DOCUMENT_NUMBER) {
        this.DOCUMENT_NUMBER = DOCUMENT_NUMBER;
    }


    /**
     * Gets the CON_STATUS value for this REQUESTCONTEXTEITF_PUR_CON_APPROVERECORD.
     * 
     * @return CON_STATUS
     */
    public java.lang.String getCON_STATUS() {
        return CON_STATUS;
    }


    /**
     * Sets the CON_STATUS value for this REQUESTCONTEXTEITF_PUR_CON_APPROVERECORD.
     * 
     * @param CON_STATUS
     */
    public void setCON_STATUS(java.lang.String CON_STATUS) {
        this.CON_STATUS = CON_STATUS;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof REQUESTCONTEXTEITF_PUR_CON_APPROVERECORD)) return false;
        REQUESTCONTEXTEITF_PUR_CON_APPROVERECORD other = (REQUESTCONTEXTEITF_PUR_CON_APPROVERECORD) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.DOCUMENT_NUMBER==null && other.getDOCUMENT_NUMBER()==null) || 
             (this.DOCUMENT_NUMBER!=null &&
              this.DOCUMENT_NUMBER.equals(other.getDOCUMENT_NUMBER()))) &&
            ((this.CON_STATUS==null && other.getCON_STATUS()==null) || 
             (this.CON_STATUS!=null &&
              this.CON_STATUS.equals(other.getCON_STATUS())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getDOCUMENT_NUMBER() != null) {
            _hashCode += getDOCUMENT_NUMBER().hashCode();
        }
        if (getCON_STATUS() != null) {
            _hashCode += getCON_STATUS().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(REQUESTCONTEXTEITF_PUR_CON_APPROVERECORD.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.aurora-framework.org/schema", ">>>>REQUEST>CONTEXT>EITF_PUR_CON_APPROVE>RECORD"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DOCUMENT_NUMBER");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aurora-framework.org/schema", "DOCUMENT_NUMBER"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CON_STATUS");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aurora-framework.org/schema", "CON_STATUS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
