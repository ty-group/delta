/**
 * REQUESTCONTEXT.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.aurora_framework.www.schema;

public class REQUESTCONTEXT  implements java.io.Serializable {
    private org.aurora_framework.www.schema.REQUESTCONTEXTEITF_PUR_CON_APPROVE EITF_PUR_CON_APPROVE;

    public REQUESTCONTEXT() {
    }

    public REQUESTCONTEXT(
           org.aurora_framework.www.schema.REQUESTCONTEXTEITF_PUR_CON_APPROVE EITF_PUR_CON_APPROVE) {
           this.EITF_PUR_CON_APPROVE = EITF_PUR_CON_APPROVE;
    }


    /**
     * Gets the EITF_PUR_CON_APPROVE value for this REQUESTCONTEXT.
     * 
     * @return EITF_PUR_CON_APPROVE
     */
    public org.aurora_framework.www.schema.REQUESTCONTEXTEITF_PUR_CON_APPROVE getEITF_PUR_CON_APPROVE() {
        return EITF_PUR_CON_APPROVE;
    }


    /**
     * Sets the EITF_PUR_CON_APPROVE value for this REQUESTCONTEXT.
     * 
     * @param EITF_PUR_CON_APPROVE
     */
    public void setEITF_PUR_CON_APPROVE(org.aurora_framework.www.schema.REQUESTCONTEXTEITF_PUR_CON_APPROVE EITF_PUR_CON_APPROVE) {
        this.EITF_PUR_CON_APPROVE = EITF_PUR_CON_APPROVE;
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
            ((this.EITF_PUR_CON_APPROVE==null && other.getEITF_PUR_CON_APPROVE()==null) || 
             (this.EITF_PUR_CON_APPROVE!=null &&
              this.EITF_PUR_CON_APPROVE.equals(other.getEITF_PUR_CON_APPROVE())));
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
        if (getEITF_PUR_CON_APPROVE() != null) {
            _hashCode += getEITF_PUR_CON_APPROVE().hashCode();
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
        elemField.setFieldName("EITF_PUR_CON_APPROVE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aurora-framework.org/schema", "EITF_PUR_CON_APPROVE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.aurora-framework.org/schema", ">>>REQUEST>CONTEXT>EITF_PUR_CON_APPROVE"));
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
