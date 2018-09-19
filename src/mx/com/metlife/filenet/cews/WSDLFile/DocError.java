/**
 * DocError.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mx.com.metlife.filenet.cews.WSDLFile;

public class DocError  implements java.io.Serializable {
    private java.lang.String GUID;

    private java.lang.String descError;

    public DocError() {
    }

    public DocError(
           java.lang.String GUID,
           java.lang.String descError) {
           this.GUID = GUID;
           this.descError = descError;
    }


    /**
     * Gets the GUID value for this DocError.
     * 
     * @return GUID
     */
    public java.lang.String getGUID() {
        return GUID;
    }


    /**
     * Sets the GUID value for this DocError.
     * 
     * @param GUID
     */
    public void setGUID(java.lang.String GUID) {
        this.GUID = GUID;
    }


    /**
     * Gets the descError value for this DocError.
     * 
     * @return descError
     */
    public java.lang.String getDescError() {
        return descError;
    }


    /**
     * Sets the descError value for this DocError.
     * 
     * @param descError
     */
    public void setDescError(java.lang.String descError) {
        this.descError = descError;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DocError)) return false;
        DocError other = (DocError) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.GUID==null && other.getGUID()==null) || 
             (this.GUID!=null &&
              this.GUID.equals(other.getGUID()))) &&
            ((this.descError==null && other.getDescError()==null) || 
             (this.descError!=null &&
              this.descError.equals(other.getDescError())));
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
        if (getGUID() != null) {
            _hashCode += getGUID().hashCode();
        }
        if (getDescError() != null) {
            _hashCode += getDescError().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DocError.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", "DocError"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("GUID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "GUID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descError");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DescError"));
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
