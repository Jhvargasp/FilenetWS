/**
 * GetDocRs.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mx.com.metlife.filenet.cews.WSDLFile;

public class GetDocRs  implements java.io.Serializable {
    private java.lang.String operationStatCd;

    private java.lang.String errStatDesc;

    private mx.com.metlife.filenet.cews.WSDLFile.File file;

    public GetDocRs() {
    }

    public GetDocRs(
           java.lang.String operationStatCd,
           java.lang.String errStatDesc,
           mx.com.metlife.filenet.cews.WSDLFile.File file) {
           this.operationStatCd = operationStatCd;
           this.errStatDesc = errStatDesc;
           this.file = file;
    }


    /**
     * Gets the operationStatCd value for this GetDocRs.
     * 
     * @return operationStatCd
     */
    public java.lang.String getOperationStatCd() {
        return operationStatCd;
    }


    /**
     * Sets the operationStatCd value for this GetDocRs.
     * 
     * @param operationStatCd
     */
    public void setOperationStatCd(java.lang.String operationStatCd) {
        this.operationStatCd = operationStatCd;
    }


    /**
     * Gets the errStatDesc value for this GetDocRs.
     * 
     * @return errStatDesc
     */
    public java.lang.String getErrStatDesc() {
        return errStatDesc;
    }


    /**
     * Sets the errStatDesc value for this GetDocRs.
     * 
     * @param errStatDesc
     */
    public void setErrStatDesc(java.lang.String errStatDesc) {
        this.errStatDesc = errStatDesc;
    }


    /**
     * Gets the file value for this GetDocRs.
     * 
     * @return file
     */
    public mx.com.metlife.filenet.cews.WSDLFile.File getFile() {
        return file;
    }


    /**
     * Sets the file value for this GetDocRs.
     * 
     * @param file
     */
    public void setFile(mx.com.metlife.filenet.cews.WSDLFile.File file) {
        this.file = file;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetDocRs)) return false;
        GetDocRs other = (GetDocRs) obj;
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
            ((this.errStatDesc==null && other.getErrStatDesc()==null) || 
             (this.errStatDesc!=null &&
              this.errStatDesc.equals(other.getErrStatDesc()))) &&
            ((this.file==null && other.getFile()==null) || 
             (this.file!=null &&
              this.file.equals(other.getFile())));
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
        if (getErrStatDesc() != null) {
            _hashCode += getErrStatDesc().hashCode();
        }
        if (getFile() != null) {
            _hashCode += getFile().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetDocRs.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", ">GetDocRs"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operationStatCd");
        elemField.setXmlName(new javax.xml.namespace.QName("", "OperationStatCd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("errStatDesc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ErrStatDesc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("file");
        elemField.setXmlName(new javax.xml.namespace.QName("", "File"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", "File"));
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
