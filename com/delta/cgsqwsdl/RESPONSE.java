/**
 * RESPONSE.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.delta.cgsqwsdl;

public class RESPONSE  implements java.io.Serializable {
    private com.delta.cgsqwsdl.RESPONSERESPONSE_HEADER RESPONSE_HEADER;

    private java.lang.String success;  // attribute

    public RESPONSE() {
    }

    public RESPONSE(
           com.delta.cgsqwsdl.RESPONSERESPONSE_HEADER RESPONSE_HEADER,
           java.lang.String success) {
           this.RESPONSE_HEADER = RESPONSE_HEADER;
           this.success = success;
    }


    /**
     * Gets the RESPONSE_HEADER value for this RESPONSE.
     * 
     * @return RESPONSE_HEADER
     */
    public com.delta.cgsqwsdl.RESPONSERESPONSE_HEADER getRESPONSE_HEADER() {
        return RESPONSE_HEADER;
    }


    /**
     * Sets the RESPONSE_HEADER value for this RESPONSE.
     * 
     * @param RESPONSE_HEADER
     */
    public void setRESPONSE_HEADER(com.delta.cgsqwsdl.RESPONSERESPONSE_HEADER RESPONSE_HEADER) {
        this.RESPONSE_HEADER = RESPONSE_HEADER;
    }


    /**
     * Gets the success value for this RESPONSE.
     * 
     * @return success
     */
    public java.lang.String getSuccess() {
        return success;
    }


    /**
     * Sets the success value for this RESPONSE.
     * 
     * @param success
     */
    public void setSuccess(java.lang.String success) {
        this.success = success;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RESPONSE)) return false;
        RESPONSE other = (RESPONSE) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.RESPONSE_HEADER==null && other.getRESPONSE_HEADER()==null) || 
             (this.RESPONSE_HEADER!=null &&
              this.RESPONSE_HEADER.equals(other.getRESPONSE_HEADER()))) &&
            ((this.success==null && other.getSuccess()==null) || 
             (this.success!=null &&
              this.success.equals(other.getSuccess())));
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
        if (getRESPONSE_HEADER() != null) {
            _hashCode += getRESPONSE_HEADER().hashCode();
        }
        if (getSuccess() != null) {
            _hashCode += getSuccess().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RESPONSE.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/envelope/", ">RESPONSE"));
        org.apache.axis.description.AttributeDesc attrField = new org.apache.axis.description.AttributeDesc();
        attrField.setFieldName("success");
        attrField.setXmlName(new javax.xml.namespace.QName("", "success"));
        attrField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        typeDesc.addFieldDesc(attrField);
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("RESPONSE_HEADER");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/envelope/", "RESPONSE_HEADER"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/envelope/", ">>RESPONSE>RESPONSE_HEADER"));
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
