/**
 * EnvelopeBodyREQUEST.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.delta.cgsqwsdl;

public class EnvelopeBodyREQUEST  implements java.io.Serializable {
    private com.delta.cgsqwsdl.EnvelopeBodyREQUESTHEADER HEADER;

    private com.delta.cgsqwsdl.EnvelopeBodyREQUESTCONTEXT CONTEXT;

    public EnvelopeBodyREQUEST() {
    }

    public EnvelopeBodyREQUEST(
           com.delta.cgsqwsdl.EnvelopeBodyREQUESTHEADER HEADER,
           com.delta.cgsqwsdl.EnvelopeBodyREQUESTCONTEXT CONTEXT) {
           this.HEADER = HEADER;
           this.CONTEXT = CONTEXT;
    }


    /**
     * Gets the HEADER value for this EnvelopeBodyREQUEST.
     * 
     * @return HEADER
     */
    public com.delta.cgsqwsdl.EnvelopeBodyREQUESTHEADER getHEADER() {
        return HEADER;
    }


    /**
     * Sets the HEADER value for this EnvelopeBodyREQUEST.
     * 
     * @param HEADER
     */
    public void setHEADER(com.delta.cgsqwsdl.EnvelopeBodyREQUESTHEADER HEADER) {
        this.HEADER = HEADER;
    }


    /**
     * Gets the CONTEXT value for this EnvelopeBodyREQUEST.
     * 
     * @return CONTEXT
     */
    public com.delta.cgsqwsdl.EnvelopeBodyREQUESTCONTEXT getCONTEXT() {
        return CONTEXT;
    }


    /**
     * Sets the CONTEXT value for this EnvelopeBodyREQUEST.
     * 
     * @param CONTEXT
     */
    public void setCONTEXT(com.delta.cgsqwsdl.EnvelopeBodyREQUESTCONTEXT CONTEXT) {
        this.CONTEXT = CONTEXT;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EnvelopeBodyREQUEST)) return false;
        EnvelopeBodyREQUEST other = (EnvelopeBodyREQUEST) obj;
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
        new org.apache.axis.description.TypeDesc(EnvelopeBodyREQUEST.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/envelope/", ">>>Envelope>Body>REQUEST"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("HEADER");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/envelope/", "HEADER"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/envelope/", ">>>>Envelope>Body>REQUEST>HEADER"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CONTEXT");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/envelope/", "CONTEXT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/envelope/", ">>>>Envelope>Body>REQUEST>CONTEXT"));
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
