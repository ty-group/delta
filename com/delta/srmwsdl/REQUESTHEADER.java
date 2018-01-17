/**
 * REQUESTHEADER.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.delta.srmwsdl;

public class REQUESTHEADER  implements java.io.Serializable {
    private java.lang.String BUSINESS_GROUP;

    private java.lang.String SYSTEM_CODE;

    private java.lang.String REQUEST_ID;

    private java.lang.String IF_CATE_CODE;

    private java.lang.String IF_CODE;

    private java.lang.String USER_NAME;

    private java.lang.String PASSWORD;

    private java.lang.String BATCH_NUM;

    private java.lang.String TOTAL_SEG_COUNT;

    private java.lang.String SEG_NUM;

    public REQUESTHEADER() {
    }

    public REQUESTHEADER(
           java.lang.String BUSINESS_GROUP,
           java.lang.String SYSTEM_CODE,
           java.lang.String REQUEST_ID,
           java.lang.String IF_CATE_CODE,
           java.lang.String IF_CODE,
           java.lang.String USER_NAME,
           java.lang.String PASSWORD,
           java.lang.String BATCH_NUM,
           java.lang.String TOTAL_SEG_COUNT,
           java.lang.String SEG_NUM) {
           this.BUSINESS_GROUP = BUSINESS_GROUP;
           this.SYSTEM_CODE = SYSTEM_CODE;
           this.REQUEST_ID = REQUEST_ID;
           this.IF_CATE_CODE = IF_CATE_CODE;
           this.IF_CODE = IF_CODE;
           this.USER_NAME = USER_NAME;
           this.PASSWORD = PASSWORD;
           this.BATCH_NUM = BATCH_NUM;
           this.TOTAL_SEG_COUNT = TOTAL_SEG_COUNT;
           this.SEG_NUM = SEG_NUM;
    }


    /**
     * Gets the BUSINESS_GROUP value for this REQUESTHEADER.
     * 
     * @return BUSINESS_GROUP
     */
    public java.lang.String getBUSINESS_GROUP() {
        return BUSINESS_GROUP;
    }


    /**
     * Sets the BUSINESS_GROUP value for this REQUESTHEADER.
     * 
     * @param BUSINESS_GROUP
     */
    public void setBUSINESS_GROUP(java.lang.String BUSINESS_GROUP) {
        this.BUSINESS_GROUP = BUSINESS_GROUP;
    }


    /**
     * Gets the SYSTEM_CODE value for this REQUESTHEADER.
     * 
     * @return SYSTEM_CODE
     */
    public java.lang.String getSYSTEM_CODE() {
        return SYSTEM_CODE;
    }


    /**
     * Sets the SYSTEM_CODE value for this REQUESTHEADER.
     * 
     * @param SYSTEM_CODE
     */
    public void setSYSTEM_CODE(java.lang.String SYSTEM_CODE) {
        this.SYSTEM_CODE = SYSTEM_CODE;
    }


    /**
     * Gets the REQUEST_ID value for this REQUESTHEADER.
     * 
     * @return REQUEST_ID
     */
    public java.lang.String getREQUEST_ID() {
        return REQUEST_ID;
    }


    /**
     * Sets the REQUEST_ID value for this REQUESTHEADER.
     * 
     * @param REQUEST_ID
     */
    public void setREQUEST_ID(java.lang.String REQUEST_ID) {
        this.REQUEST_ID = REQUEST_ID;
    }


    /**
     * Gets the IF_CATE_CODE value for this REQUESTHEADER.
     * 
     * @return IF_CATE_CODE
     */
    public java.lang.String getIF_CATE_CODE() {
        return IF_CATE_CODE;
    }


    /**
     * Sets the IF_CATE_CODE value for this REQUESTHEADER.
     * 
     * @param IF_CATE_CODE
     */
    public void setIF_CATE_CODE(java.lang.String IF_CATE_CODE) {
        this.IF_CATE_CODE = IF_CATE_CODE;
    }


    /**
     * Gets the IF_CODE value for this REQUESTHEADER.
     * 
     * @return IF_CODE
     */
    public java.lang.String getIF_CODE() {
        return IF_CODE;
    }


    /**
     * Sets the IF_CODE value for this REQUESTHEADER.
     * 
     * @param IF_CODE
     */
    public void setIF_CODE(java.lang.String IF_CODE) {
        this.IF_CODE = IF_CODE;
    }


    /**
     * Gets the USER_NAME value for this REQUESTHEADER.
     * 
     * @return USER_NAME
     */
    public java.lang.String getUSER_NAME() {
        return USER_NAME;
    }


    /**
     * Sets the USER_NAME value for this REQUESTHEADER.
     * 
     * @param USER_NAME
     */
    public void setUSER_NAME(java.lang.String USER_NAME) {
        this.USER_NAME = USER_NAME;
    }


    /**
     * Gets the PASSWORD value for this REQUESTHEADER.
     * 
     * @return PASSWORD
     */
    public java.lang.String getPASSWORD() {
        return PASSWORD;
    }


    /**
     * Sets the PASSWORD value for this REQUESTHEADER.
     * 
     * @param PASSWORD
     */
    public void setPASSWORD(java.lang.String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }


    /**
     * Gets the BATCH_NUM value for this REQUESTHEADER.
     * 
     * @return BATCH_NUM
     */
    public java.lang.String getBATCH_NUM() {
        return BATCH_NUM;
    }


    /**
     * Sets the BATCH_NUM value for this REQUESTHEADER.
     * 
     * @param BATCH_NUM
     */
    public void setBATCH_NUM(java.lang.String BATCH_NUM) {
        this.BATCH_NUM = BATCH_NUM;
    }


    /**
     * Gets the TOTAL_SEG_COUNT value for this REQUESTHEADER.
     * 
     * @return TOTAL_SEG_COUNT
     */
    public java.lang.String getTOTAL_SEG_COUNT() {
        return TOTAL_SEG_COUNT;
    }


    /**
     * Sets the TOTAL_SEG_COUNT value for this REQUESTHEADER.
     * 
     * @param TOTAL_SEG_COUNT
     */
    public void setTOTAL_SEG_COUNT(java.lang.String TOTAL_SEG_COUNT) {
        this.TOTAL_SEG_COUNT = TOTAL_SEG_COUNT;
    }


    /**
     * Gets the SEG_NUM value for this REQUESTHEADER.
     * 
     * @return SEG_NUM
     */
    public java.lang.String getSEG_NUM() {
        return SEG_NUM;
    }


    /**
     * Sets the SEG_NUM value for this REQUESTHEADER.
     * 
     * @param SEG_NUM
     */
    public void setSEG_NUM(java.lang.String SEG_NUM) {
        this.SEG_NUM = SEG_NUM;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof REQUESTHEADER)) return false;
        REQUESTHEADER other = (REQUESTHEADER) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.BUSINESS_GROUP==null && other.getBUSINESS_GROUP()==null) || 
             (this.BUSINESS_GROUP!=null &&
              this.BUSINESS_GROUP.equals(other.getBUSINESS_GROUP()))) &&
            ((this.SYSTEM_CODE==null && other.getSYSTEM_CODE()==null) || 
             (this.SYSTEM_CODE!=null &&
              this.SYSTEM_CODE.equals(other.getSYSTEM_CODE()))) &&
            ((this.REQUEST_ID==null && other.getREQUEST_ID()==null) || 
             (this.REQUEST_ID!=null &&
              this.REQUEST_ID.equals(other.getREQUEST_ID()))) &&
            ((this.IF_CATE_CODE==null && other.getIF_CATE_CODE()==null) || 
             (this.IF_CATE_CODE!=null &&
              this.IF_CATE_CODE.equals(other.getIF_CATE_CODE()))) &&
            ((this.IF_CODE==null && other.getIF_CODE()==null) || 
             (this.IF_CODE!=null &&
              this.IF_CODE.equals(other.getIF_CODE()))) &&
            ((this.USER_NAME==null && other.getUSER_NAME()==null) || 
             (this.USER_NAME!=null &&
              this.USER_NAME.equals(other.getUSER_NAME()))) &&
            ((this.PASSWORD==null && other.getPASSWORD()==null) || 
             (this.PASSWORD!=null &&
              this.PASSWORD.equals(other.getPASSWORD()))) &&
            ((this.BATCH_NUM==null && other.getBATCH_NUM()==null) || 
             (this.BATCH_NUM!=null &&
              this.BATCH_NUM.equals(other.getBATCH_NUM()))) &&
            ((this.TOTAL_SEG_COUNT==null && other.getTOTAL_SEG_COUNT()==null) || 
             (this.TOTAL_SEG_COUNT!=null &&
              this.TOTAL_SEG_COUNT.equals(other.getTOTAL_SEG_COUNT()))) &&
            ((this.SEG_NUM==null && other.getSEG_NUM()==null) || 
             (this.SEG_NUM!=null &&
              this.SEG_NUM.equals(other.getSEG_NUM())));
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
        if (getBUSINESS_GROUP() != null) {
            _hashCode += getBUSINESS_GROUP().hashCode();
        }
        if (getSYSTEM_CODE() != null) {
            _hashCode += getSYSTEM_CODE().hashCode();
        }
        if (getREQUEST_ID() != null) {
            _hashCode += getREQUEST_ID().hashCode();
        }
        if (getIF_CATE_CODE() != null) {
            _hashCode += getIF_CATE_CODE().hashCode();
        }
        if (getIF_CODE() != null) {
            _hashCode += getIF_CODE().hashCode();
        }
        if (getUSER_NAME() != null) {
            _hashCode += getUSER_NAME().hashCode();
        }
        if (getPASSWORD() != null) {
            _hashCode += getPASSWORD().hashCode();
        }
        if (getBATCH_NUM() != null) {
            _hashCode += getBATCH_NUM().hashCode();
        }
        if (getTOTAL_SEG_COUNT() != null) {
            _hashCode += getTOTAL_SEG_COUNT().hashCode();
        }
        if (getSEG_NUM() != null) {
            _hashCode += getSEG_NUM().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(REQUESTHEADER.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.aurora-framework.org/schema", ">>REQUEST>HEADER"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BUSINESS_GROUP");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aurora-framework.org/schema", "BUSINESS_GROUP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SYSTEM_CODE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aurora-framework.org/schema", "SYSTEM_CODE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("REQUEST_ID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aurora-framework.org/schema", "REQUEST_ID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IF_CATE_CODE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aurora-framework.org/schema", "IF_CATE_CODE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("IF_CODE");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aurora-framework.org/schema", "IF_CODE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("USER_NAME");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aurora-framework.org/schema", "USER_NAME"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PASSWORD");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aurora-framework.org/schema", "PASSWORD"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BATCH_NUM");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aurora-framework.org/schema", "BATCH_NUM"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("TOTAL_SEG_COUNT");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aurora-framework.org/schema", "TOTAL_SEG_COUNT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("SEG_NUM");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.aurora-framework.org/schema", "SEG_NUM"));
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
