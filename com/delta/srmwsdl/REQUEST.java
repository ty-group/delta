/**
 * REQUEST.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.delta.srmwsdl;

public class REQUEST  implements java.io.Serializable {
    private com.delta.srmwsdl.REQUESTHEADER HEADER;

    private com.delta.srmwsdl.REQUESTCONTEXT CONTEXT;

    public REQUEST() {
    }

    public REQUEST(
           com.delta.srmwsdl.REQUESTHEADER HEADER,
           com.delta.srmwsdl.REQUESTCONTEXT CONTEXT) {
           this.HEADER = HEADER;
           this.CONTEXT = CONTEXT;
    }


    /**
     * Gets the HEADER value for this REQUEST.
     * 
     * @return HEADER
     */
    public com.delta.srmwsdl.REQUESTHEADER getHEADER() {
        return HEADER;
    }


    /**
     * Sets the HEADER value for this REQUEST.
     * 
     * @param HEADER
     */
    public void setHEADER(com.delta.srmwsdl.REQUESTHEADER HEADER) {
        this.HEADER = HEADER;
    }


    /**
     * Gets the CONTEXT value for this REQUEST.
     * 
     * @return CONTEXT
     */
    public com.delta.srmwsdl.REQUESTCONTEXT getCONTEXT() {
        return CONTEXT;
    }


    /**
     * Sets the CONTEXT value for this REQUEST.
     * 
     * @param CONTEXT
     */
    public void setCONTEXT(com.delta.srmwsdl.REQUESTCONTEXT CONTEXT) {
        this.CONTEXT = CONTEXT;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof REQUEST)) return false;
        REQUEST other = (REQUEST) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.HEADER==null && other.getHEADER()==null) || 
             (this.HEADER!=null &&
              this.HEADER.equals(other.getHEADER()))) &&
            ((this.CONTEXT==null && other.getCONTEXT()==null) || 
             (this.CONTEXT!=null &&
              this.CONTEXT.equals(other.getCONTEXT())));
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
        if (getHEADER() != null) {
            _hashCode += getHEADER().hashCode();
        }
        if (getCONTEXT() != null) {
            _hashCode += getCONTEXT().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(REQUEST.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.aurora-framework.org/schema", ">REQUEST"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("HEADER");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aurora-framework.org/schema", "HEADER"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.aurora-framework.org/schema", ">>REQUEST>HEADER"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CONTEXT");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aurora-framework.org/schema", "CONTEXT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.aurora-framework.org/schema", ">>REQUEST>CONTEXT"));
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
