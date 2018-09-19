/**
 * UpdateMetadataRsType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mx.com.metlife.filenet.cews.WSDLFile;

public class UpdateMetadataRsType  implements java.io.Serializable {
    private java.lang.String operationStatCd;

    private mx.com.metlife.filenet.cews.WSDLFile.DocsError[] docsError;

    private java.lang.String errStatDesc;

    public UpdateMetadataRsType() {
    }

    public UpdateMetadataRsType(
           java.lang.String operationStatCd,
           mx.com.metlife.filenet.cews.WSDLFile.DocsError[] docsError,
           java.lang.String errStatDesc) {
           this.operationStatCd = operationStatCd;
           this.docsError = docsError;
           this.errStatDesc = errStatDesc;
    }


    /**
     * Gets the operationStatCd value for this UpdateMetadataRsType.
     * 
     * @return operationStatCd
     */
    public java.lang.String getOperationStatCd() {
        return operationStatCd;
    }


    /**
     * Sets the operationStatCd value for this UpdateMetadataRsType.
     * 
     * @param operationStatCd
     */
    public void setOperationStatCd(java.lang.String operationStatCd) {
        this.operationStatCd = operationStatCd;
    }


    /**
     * Gets the docsError value for this UpdateMetadataRsType.
     * 
     * @return docsError
     */
    public mx.com.metlife.filenet.cews.WSDLFile.DocsError[] getDocsError() {
        return docsError;
    }


    /**
     * Sets the docsError value for this UpdateMetadataRsType.
     * 
     * @param docsError
     */
    public void setDocsError(mx.com.metlife.filenet.cews.WSDLFile.DocsError[] docsError) {
        this.docsError = docsError;
    }

    public mx.com.metlife.filenet.cews.WSDLFile.DocsError getDocsError(int i) {
        return this.docsError[i];
    }

    public void setDocsError(int i, mx.com.metlife.filenet.cews.WSDLFile.DocsError _value) {
        this.docsError[i] = _value;
    }


    /**
     * Gets the errStatDesc value for this UpdateMetadataRsType.
     * 
     * @return errStatDesc
     */
    public java.lang.String getErrStatDesc() {
        return errStatDesc;
    }


    /**
     * Sets the errStatDesc value for this UpdateMetadataRsType.
     * 
     * @param errStatDesc
     */
    public void setErrStatDesc(java.lang.String errStatDesc) {
        this.errStatDesc = errStatDesc;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UpdateMetadataRsType)) return false;
        UpdateMetadataRsType other = (UpdateMetadataRsType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.operationStatCd==null && other.getOperationStatCd()==null) || 
             (this.operationStatCd!=null &&
              this.operationStatCd.equals(other.getOperationStatCd()))) &&
            ((this.docsError==null && other.getDocsError()==null) || 
             (this.docsError!=null &&
              java.util.Arrays.equals(this.docsError, other.getDocsError()))) &&
            ((this.errStatDesc==null && other.getErrStatDesc()==null) || 
             (this.errStatDesc!=null &&
              this.errStatDesc.equals(other.getErrStatDesc())));
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
        if (getOperationStatCd() != null) {
            _hashCode += getOperationStatCd().hashCode();
        }
        if (getDocsError() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDocsError());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDocsError(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getErrStatDesc() != null) {
            _hashCode += getErrStatDesc().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UpdateMetadataRsType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", "UpdateMetadataRsType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operationStatCd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "OperationStatCd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("docsError");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DocsError"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", "DocsError"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errStatDesc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ErrStatDesc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
