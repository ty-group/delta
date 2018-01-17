/**
 * EnvelopeBodyREQUESTCONTEXTEITF_PUR_REQ_HEADERS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.delta.cgsqwsdl;

public class EnvelopeBodyREQUESTCONTEXTEITF_PUR_REQ_HEADERS  implements java.io.Serializable {
    private com.delta.cgsqwsdl.EnvelopeBodyREQUESTCONTEXTEITF_PUR_REQ_HEADERSRECORD RECORD;

    public EnvelopeBodyREQUESTCONTEXTEITF_PUR_REQ_HEADERS() {
    }

    public EnvelopeBodyREQUESTCONTEXTEITF_PUR_REQ_HEADERS(
           com.delta.cgsqwsdl.EnvelopeBodyREQUESTCONTEXTEITF_PUR_REQ_HEADERSRECORD RECORD) {
           this.RECORD = RECORD;
    }


    /**
     * Gets the RECORD value for this EnvelopeBodyREQUESTCONTEXTEITF_PUR_REQ_HEADERS.
     * 
     * @return RECORD
     */
    public com.delta.cgsqwsdl.EnvelopeBodyREQUESTCONTEXTEITF_PUR_REQ_HEADERSRECORD getRECORD() {
        return RECORD;
    }


    /**
     * Sets the RECORD value for this EnvelopeBodyREQUESTCONTEXTEITF_PUR_REQ_HEADERS.
     * 
     * @param RECORD
     */
    public void setRECORD(com.delta.cgsqwsdl.EnvelopeBodyREQUESTCONTEXTEITF_PUR_REQ_HEADERSRECORD RECORD) {
        this.RECORD = RECORD;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EnvelopeBodyREQUESTCONTEXTEITF_PUR_REQ_HEADERS)) return false;
        EnvelopeBodyREQUESTCONTEXTEITF_PUR_REQ_HEADERS other = (EnvelopeBodyREQUESTCONTEXTEITF_PUR_REQ_HEADERS) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.RECORD==null && other.getRECORD()==null) || 
             (this.RECORD!=null &&
              this.RECORD.equals(other.getRECORD())));
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
        if (getRECORD() != null) {
            _hashCode += getRECORD().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EnvelopeBodyREQUESTCONTEXTEITF_PUR_REQ_HEADERS.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/envelope/", ">>>>>Envelope>Body>REQUEST>CONTEXT>EITF_PUR_REQ_HEADERS"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("RECORD");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/envelope/", "RECORD"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/envelope/", ">>>>>>Envelope>Body>REQUEST>CONTEXT>EITF_PUR_REQ_HEADERS>RECORD"));
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
