/**
 * DocsError.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mx.com.metlife.filenet.cews.WSDLFile;

public class DocsError  implements java.io.Serializable {
    private mx.com.metlife.filenet.cews.WSDLFile.DocError docError;

    public DocsError() {
    }

    public DocsError(
           mx.com.metlife.filenet.cews.WSDLFile.DocError docError) {
           this.docError = docError;
    }


    /**
     * Gets the docError value for this DocsError.
     * 
     * @return docError
     */
    public mx.com.metlife.filenet.cews.WSDLFile.DocError getDocError() {
        return docError;
    }


    /**
     * Sets the docError value for this DocsError.
     * 
     * @param docError
     */
    public void setDocError(mx.com.metlife.filenet.cews.WSDLFile.DocError docError) {
        this.docError = docError;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DocsError)) return false;
        DocsError other = (DocsError) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.docError==null && other.getDocError()==null) || 
             (this.docError!=null &&
              this.docError.equals(other.getDocError())));
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
        if (getDocError() != null) {
            _hashCode += getDocError().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DocsError.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", "DocsError"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("docError");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DocError"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", "DocError"));
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
