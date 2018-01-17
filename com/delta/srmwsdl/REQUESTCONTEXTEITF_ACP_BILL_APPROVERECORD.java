/**
 * REQUESTCONTEXTEITF_ACP_BILL_APPROVERECORD.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.delta.srmwsdl;

public class REQUESTCONTEXTEITF_ACP_BILL_APPROVERECORD  implements java.io.Serializable {
    private java.lang.String BILL_NUMBER;

    private java.lang.String BILL_STATUS;

    public REQUESTCONTEXTEITF_ACP_BILL_APPROVERECORD() {
    }

    public REQUESTCONTEXTEITF_ACP_BILL_APPROVERECORD(
           java.lang.String BILL_NUMBER,
           java.lang.String BILL_STATUS) {
           this.BILL_NUMBER = BILL_NUMBER;
           this.BILL_STATUS = BILL_STATUS;
    }


    /**
     * Gets the BILL_NUMBER value for this REQUESTCONTEXTEITF_ACP_BILL_APPROVERECORD.
     * 
     * @return BILL_NUMBER
     */
    public java.lang.String getBILL_NUMBER() {
        return BILL_NUMBER;
    }


    /**
     * Sets the BILL_NUMBER value for this REQUESTCONTEXTEITF_ACP_BILL_APPROVERECORD.
     * 
     * @param BILL_NUMBER
     */
    public void setBILL_NUMBER(java.lang.String BILL_NUMBER) {
        this.BILL_NUMBER = BILL_NUMBER;
    }


    /**
     * Gets the BILL_STATUS value for this REQUESTCONTEXTEITF_ACP_BILL_APPROVERECORD.
     * 
     * @return BILL_STATUS
     */
    public java.lang.String getBILL_STATUS() {
        return BILL_STATUS;
    }


    /**
     * Sets the BILL_STATUS value for this REQUESTCONTEXTEITF_ACP_BILL_APPROVERECORD.
     * 
     * @param BILL_STATUS
     */
    public void setBILL_STATUS(java.lang.String BILL_STATUS) {
        this.BILL_STATUS = BILL_STATUS;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof REQUESTCONTEXTEITF_ACP_BILL_APPROVERECORD)) return false;
        REQUESTCONTEXTEITF_ACP_BILL_APPROVERECORD other = (REQUESTCONTEXTEITF_ACP_BILL_APPROVERECORD) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.BILL_NUMBER==null && other.getBILL_NUMBER()==null) || 
             (this.BILL_NUMBER!=null &&
              this.BILL_NUMBER.equals(other.getBILL_NUMBER()))) &&
            ((this.BILL_STATUS==null && other.getBILL_STATUS()==null) || 
             (this.BILL_STATUS!=null &&
              this.BILL_STATUS.equals(other.getBILL_STATUS())));
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
        if (getBILL_NUMBER() != null) {
            _hashCode += getBILL_NUMBER().hashCode();
        }
        if (getBILL_STATUS() != null) {
            _hashCode += getBILL_STATUS().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(REQUESTCONTEXTEITF_ACP_BILL_APPROVERECORD.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.aurora-framework.org/schema", ">>>>REQUEST>CONTEXT>EITF_ACP_BILL_APPROVE>RECORD"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BILL_NUMBER");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aurora-framework.org/schema", "BILL_NUMBER"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BILL_STATUS");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aurora-framework.org/schema", "BILL_STATUS"));
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
