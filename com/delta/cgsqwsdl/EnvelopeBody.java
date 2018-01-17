/**
 * EnvelopeBody.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.delta.cgsqwsdl;

public class EnvelopeBody  implements java.io.Serializable {
    private com.delta.cgsqwsdl.EnvelopeBodyREQUEST REQUEST;

    public EnvelopeBody() {
    }

    public EnvelopeBody(
           com.delta.cgsqwsdl.EnvelopeBodyREQUEST REQUEST) {
           this.REQUEST = REQUEST;
    }


    /**
     * Gets the REQUEST value for this EnvelopeBody.
     * 
     * @return REQUEST
     */
    public com.delta.cgsqwsdl.EnvelopeBodyREQUEST getREQUEST() {
        return REQUEST;
    }


    /**
     * Sets the REQUEST value for this EnvelopeBody.
     * 
     * @param REQUEST
     */
    public void setREQUEST(com.delta.cgsqwsdl.EnvelopeBodyREQUEST REQUEST) {
        this.REQUEST = REQUEST;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EnvelopeBody)) return false;
        EnvelopeBody other = (EnvelopeBody) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.REQUEST==null && other.getREQUEST()==null) || 
             (this.REQUEST!=null &&
              this.REQUEST.equals(other.getREQUEST())));
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
        if (getREQUEST() != null) {
            _hashCode += getREQUEST().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EnvelopeBody.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/envelope/", ">>Envelope>Body"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("REQUEST");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/envelope/", "REQUEST"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/envelope/", ">>>Envelope>Body>REQUEST"));
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
