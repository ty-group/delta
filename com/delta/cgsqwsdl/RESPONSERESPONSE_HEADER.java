/**
 * RESPONSERESPONSE_HEADER.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.delta.cgsqwsdl;

public class RESPONSERESPONSE_HEADER  implements java.io.Serializable {
    private java.lang.String RESPONSE_STATUS;

    private java.lang.String RESPONSE_MESSAGE;

    public RESPONSERESPONSE_HEADER() {
    }

    public RESPONSERESPONSE_HEADER(
           java.lang.String RESPONSE_STATUS,
           java.lang.String RESPONSE_MESSAGE) {
           this.RESPONSE_STATUS = RESPONSE_STATUS;
           this.RESPONSE_MESSAGE = RESPONSE_MESSAGE;
    }


    /**
     * Gets the RESPONSE_STATUS value for this RESPONSERESPONSE_HEADER.
     * 
     * @return RESPONSE_STATUS
     */
    public java.lang.String getRESPONSE_STATUS() {
        return RESPONSE_STATUS;
    }


    /**
     * Sets the RESPONSE_STATUS value for this RESPONSERESPONSE_HEADER.
     * 
     * @param RESPONSE_STATUS
     */
    public void setRESPONSE_STATUS(java.lang.String RESPONSE_STATUS) {
        this.RESPONSE_STATUS = RESPONSE_STATUS;
    }


    /**
     * Gets the RESPONSE_MESSAGE value for this RESPONSERESPONSE_HEADER.
     * 
     * @return RESPONSE_MESSAGE
     */
    public java.lang.String getRESPONSE_MESSAGE() {
        return RESPONSE_MESSAGE;
    }


    /**
     * Sets the RESPONSE_MESSAGE value for this RESPONSERESPONSE_HEADER.
     * 
     * @param RESPONSE_MESSAGE
     */
    public void setRESPONSE_MESSAGE(java.lang.String RESPONSE_MESSAGE) {
        this.RESPONSE_MESSAGE = RESPONSE_MESSAGE;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RESPONSERESPONSE_HEADER)) return false;
        RESPONSERESPONSE_HEADER other = (RESPONSERESPONSE_HEADER) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.RESPONSE_STATUS==null && other.getRESPONSE_STATUS()==null) || 
             (this.RESPONSE_STATUS!=null &&
              this.RESPONSE_STATUS.equals(other.getRESPONSE_STATUS()))) &&
            ((this.RESPONSE_MESSAGE==null && other.getRESPONSE_MESSAGE()==null) || 
             (this.RESPONSE_MESSAGE!=null &&
              this.RESPONSE_MESSAGE.equals(other.getRESPONSE_MESSAGE())));
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
        if (getRESPONSE_STATUS() != null) {
            _hashCode += getRESPONSE_STATUS().hashCode();
        }
        if (getRESPONSE_MESSAGE() != null) {
            _hashCode += getRESPONSE_MESSAGE().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RESPONSERESPONSE_HEADER.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/envelope/", ">>RESPONSE>RESPONSE_HEADER"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("RESPONSE_STATUS");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/envelope/", "RESPONSE_STATUS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("RESPONSE_MESSAGE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/envelope/", "RESPONSE_MESSAGE"));
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
