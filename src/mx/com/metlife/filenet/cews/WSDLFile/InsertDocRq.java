/**
 * InsertDocRq.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mx.com.metlife.filenet.cews.WSDLFile;

public class InsertDocRq  implements java.io.Serializable {
    private byte[] objectStore;

    private byte[] docClass;

    private byte[] path;

    private byte[] duplicate;

    private mx.com.metlife.filenet.cews.WSDLFile.Security[] securityGrp;

    private mx.com.metlife.filenet.cews.WSDLFile.Metadata[] properties;

    private byte[] filenm;

    private byte[] content;

    public InsertDocRq() {
    }

    public InsertDocRq(
           byte[] objectStore,
           byte[] docClass,
           byte[] path,
           byte[] duplicate,
           mx.com.metlife.filenet.cews.WSDLFile.Security[] securityGrp,
           mx.com.metlife.filenet.cews.WSDLFile.Metadata[] properties,
           byte[] filenm,
           byte[] content) {
           this.objectStore = objectStore;
           this.docClass = docClass;
           this.path = path;
           this.duplicate = duplicate;
           this.securityGrp = securityGrp;
           this.properties = properties;
           this.filenm = filenm;
           this.content = content;
    }


    /**
     * Gets the objectStore value for this InsertDocRq.
     * 
     * @return objectStore
     */
    public byte[] getObjectStore() {
        return objectStore;
    }


    /**
     * Sets the objectStore value for this InsertDocRq.
     * 
     * @param objectStore
     */
    public void setObjectStore(byte[] objectStore) {
        this.objectStore = objectStore;
    }


    /**
     * Gets the docClass value for this InsertDocRq.
     * 
     * @return docClass
     */
    public byte[] getDocClass() {
        return docClass;
    }


    /**
     * Sets the docClass value for this InsertDocRq.
     * 
     * @param docClass
     */
    public void setDocClass(byte[] docClass) {
        this.docClass = docClass;
    }


    /**
     * Gets the path value for this InsertDocRq.
     * 
     * @return path
     */
    public byte[] getPath() {
        return path;
    }


    /**
     * Sets the path value for this InsertDocRq.
     * 
     * @param path
     */
    public void setPath(byte[] path) {
        this.path = path;
    }


    /**
     * Gets the duplicate value for this InsertDocRq.
     * 
     * @return duplicate
     */
    public byte[] getDuplicate() {
        return duplicate;
    }


    /**
     * Sets the duplicate value for this InsertDocRq.
     * 
     * @param duplicate
     */
    public void setDuplicate(byte[] duplicate) {
        this.duplicate = duplicate;
    }


    /**
     * Gets the securityGrp value for this InsertDocRq.
     * 
     * @return securityGrp
     */
    public mx.com.metlife.filenet.cews.WSDLFile.Security[] getSecurityGrp() {
        return securityGrp;
    }


    /**
     * Sets the securityGrp value for this InsertDocRq.
     * 
     * @param securityGrp
     */
    public void setSecurityGrp(mx.com.metlife.filenet.cews.WSDLFile.Security[] securityGrp) {
        this.securityGrp = securityGrp;
    }


    /**
     * Gets the properties value for this InsertDocRq.
     * 
     * @return properties
     */
    public mx.com.metlife.filenet.cews.WSDLFile.Metadata[] getProperties() {
        return properties;
    }


    /**
     * Sets the properties value for this InsertDocRq.
     * 
     * @param properties
     */
    public void setProperties(mx.com.metlife.filenet.cews.WSDLFile.Metadata[] properties) {
        this.properties = properties;
    }


    /**
     * Gets the filenm value for this InsertDocRq.
     * 
     * @return filenm
     */
    public byte[] getFilenm() {
        return filenm;
    }


    /**
     * Sets the filenm value for this InsertDocRq.
     * 
     * @param filenm
     */
    public void setFilenm(byte[] filenm) {
        this.filenm = filenm;
    }


    /**
     * Gets the content value for this InsertDocRq.
     * 
     * @return content
     */
    public byte[] getContent() {
        return content;
    }


    /**
     * Sets the content value for this InsertDocRq.
     * 
     * @param content
     */
    public void setContent(byte[] content) {
        this.content = content;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InsertDocRq)) return false;
        InsertDocRq other = (InsertDocRq) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.objectStore==null && other.getObjectStore()==null) || 
             (this.objectStore!=null &&
              java.util.Arrays.equals(this.objectStore, other.getObjectStore()))) &&
            ((this.docClass==null && other.getDocClass()==null) || 
             (this.docClass!=null &&
              java.util.Arrays.equals(this.docClass, other.getDocClass()))) &&
            ((this.path==null && other.getPath()==null) || 
             (this.path!=null &&
              java.util.Arrays.equals(this.path, other.getPath()))) &&
            ((this.duplicate==null && other.getDuplicate()==null) || 
             (this.duplicate!=null &&
              java.util.Arrays.equals(this.duplicate, other.getDuplicate()))) &&
            ((this.securityGrp==null && other.getSecurityGrp()==null) || 
             (this.securityGrp!=null &&
              java.util.Arrays.equals(this.securityGrp, other.getSecurityGrp()))) &&
            ((this.properties==null && other.getProperties()==null) || 
             (this.properties!=null &&
              java.util.Arrays.equals(this.properties, other.getProperties()))) &&
            ((this.filenm==null && other.getFilenm()==null) || 
             (this.filenm!=null &&
              java.util.Arrays.equals(this.filenm, other.getFilenm()))) &&
            ((this.content==null && other.getContent()==null) || 
             (this.content!=null &&
              java.util.Arrays.equals(this.content, other.getContent())));
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
        if (getObjectStore() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getObjectStore());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getObjectStore(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDocClass() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDocClass());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDocClass(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPath() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPath());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPath(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getDuplicate() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDuplicate());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDuplicate(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSecurityGrp() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSecurityGrp());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSecurityGrp(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getProperties() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getProperties());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getProperties(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFilenm() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFilenm());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFilenm(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getContent() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getContent());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getContent(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InsertDocRq.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", ">InsertDocRq"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("objectStore");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ObjectStore"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("docClass");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DocClass"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("path");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Path"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("duplicate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Duplicate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("securityGrp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SecurityGrp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", "Security"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "Security"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("properties");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Properties"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", "Metadata"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "Metadata"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("filenm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Filenm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("content");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Content"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
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
