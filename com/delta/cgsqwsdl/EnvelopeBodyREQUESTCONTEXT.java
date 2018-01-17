/**
 * EnvelopeBodyREQUESTCONTEXT.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.delta.cgsqwsdl;

public class EnvelopeBodyREQUESTCONTEXT  implements java.io.Serializable {
    private com.delta.cgsqwsdl.EnvelopeBodyREQUESTCONTEXTEITF_PUR_REQ_HEADERS EITF_PUR_REQ_HEADERS;

    public EnvelopeBodyREQUESTCONTEXT() {
    }

    public EnvelopeBodyREQUESTCONTEXT(
           com.delta.cgsqwsdl.EnvelopeBodyREQUESTCONTEXTEITF_PUR_REQ_HEADERS EITF_PUR_REQ_HEADERS) {
           this.EITF_PUR_REQ_HEADERS = EITF_PUR_REQ_HEADERS;
    }


    /**
     * Gets the EITF_PUR_REQ_HEADERS value for this EnvelopeBodyREQUESTCONTEXT.
     * 
     * @return EITF_PUR_REQ_HEADERS
     */
    public com.delta.cgsqwsdl.EnvelopeBodyREQUESTCONTEXTEITF_PUR_REQ_HEADERS getEITF_PUR_REQ_HEADERS() {
        return EITF_PUR_REQ_HEADERS;
    }


    /**
     * Sets the EITF_PUR_REQ_HEADERS value for this EnvelopeBodyREQUESTCONTEXT.
     * 
     * @param EITF_PUR_REQ_HEADERS
     */
    public void setEITF_PUR_REQ_HEADERS(com.delta.cgsqwsdl.EnvelopeBodyREQUESTCONTEXTEITF_PUR_REQ_HEADERS EITF_PUR_REQ_HEADERS) {
        this.EITF_PUR_REQ_HEADERS = EITF_PUR_REQ_HEADERS;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EnvelopeBodyREQUESTCONTEXT)) return false;
        EnvelopeBodyREQUESTCONTEXT other = (EnvelopeBodyREQUESTCONTEXT) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.EITF_PUR_REQ_HEADERS==null && other.getEITF_PUR_REQ_HEADERS()==null) || 
             (this.EITF_PUR_REQ_HEADERS!=null &&
              this.EITF_PUR_REQ_HEADERS.equals(other.getEITF_PUR_REQ_HEADERS())));
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
        if (getEITF_PUR_REQ_HEADERS() != null) {
            _hashCode += getEITF_PUR_REQ_HEADERS().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EnvelopeBodyREQUESTCONTEXT.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/envelope/", ">>>>Envelope>Body>REQUEST>CONTEXT"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("EITF_PUR_REQ_HEADERS");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/envelope/", "EITF_PUR_REQ_HEADERS"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/envelope/", ">>>>>Envelope>Body>REQUEST>CONTEXT>EITF_PUR_REQ_HEADERS"));
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
