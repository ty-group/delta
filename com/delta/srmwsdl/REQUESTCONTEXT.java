/**
 * REQUESTCONTEXT.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.delta.srmwsdl;

public class REQUESTCONTEXT  implements java.io.Serializable {
    private com.delta.srmwsdl.REQUESTCONTEXTEITF_ACP_BILL_APPROVE EITF_ACP_BILL_APPROVE;

    public REQUESTCONTEXT() {
    }

    public REQUESTCONTEXT(
           com.delta.srmwsdl.REQUESTCONTEXTEITF_ACP_BILL_APPROVE EITF_ACP_BILL_APPROVE) {
           this.EITF_ACP_BILL_APPROVE = EITF_ACP_BILL_APPROVE;
    }


    /**
     * Gets the EITF_ACP_BILL_APPROVE value for this REQUESTCONTEXT.
     * 
     * @return EITF_ACP_BILL_APPROVE
     */
    public com.delta.srmwsdl.REQUESTCONTEXTEITF_ACP_BILL_APPROVE getEITF_ACP_BILL_APPROVE() {
        return EITF_ACP_BILL_APPROVE;
    }


    /**
     * Sets the EITF_ACP_BILL_APPROVE value for this REQUESTCONTEXT.
     * 
     * @param EITF_ACP_BILL_APPROVE
     */
    public void setEITF_ACP_BILL_APPROVE(com.delta.srmwsdl.REQUESTCONTEXTEITF_ACP_BILL_APPROVE EITF_ACP_BILL_APPROVE) {
        this.EITF_ACP_BILL_APPROVE = EITF_ACP_BILL_APPROVE;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof REQUESTCONTEXT)) return false;
        REQUESTCONTEXT other = (REQUESTCONTEXT) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.EITF_ACP_BILL_APPROVE==null && other.getEITF_ACP_BILL_APPROVE()==null) || 
             (this.EITF_ACP_BILL_APPROVE!=null &&
              this.EITF_ACP_BILL_APPROVE.equals(other.getEITF_ACP_BILL_APPROVE())));
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
        if (getEITF_ACP_BILL_APPROVE() != null) {
            _hashCode += getEITF_ACP_BILL_APPROVE().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(REQUESTCONTEXT.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.aurora-framework.org/schema", ">>REQUEST>CONTEXT"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("EITF_ACP_BILL_APPROVE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aurora-framework.org/schema", "EITF_ACP_BILL_APPROVE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.aurora-framework.org/schema", ">>>REQUEST>CONTEXT>EITF_ACP_BILL_APPROVE"));
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
