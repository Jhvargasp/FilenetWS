/**
 * SearchDocRq.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mx.com.metlife.filenet.cews.WSDLFile;

public class SearchDocRq  implements java.io.Serializable {
    private byte[] objectStore;

    private byte[] user;

    private byte[] password;

    private byte[] docClass;

    private byte[] queryCondition;

    private byte[] path;

    public SearchDocRq() {
    }

    public SearchDocRq(
           byte[] objectStore,
           byte[] user,
           byte[] password,
           byte[] docClass,
           byte[] queryCondition,
           byte[] path) {
           this.objectStore = objectStore;
           this.user = user;
           this.password = password;
           this.docClass = docClass;
           this.queryCondition = queryCondition;
           this.path = path;
    }


    /**
     * Gets the objectStore value for this SearchDocRq.
     * 
     * @return objectStore
     */
    public byte[] getObjectStore() {
        return objectStore;
    }


    /**
     * Sets the objectStore value for this SearchDocRq.
     * 
     * @param objectStore
     */
    public void setObjectStore(byte[] objectStore) {
        this.objectStore = objectStore;
    }


    /**
     * Gets the user value for this SearchDocRq.
     * 
     * @return user
     */
    public byte[] getUser() {
        return user;
    }


    /**
     * Sets the user value for this SearchDocRq.
     * 
     * @param user
     */
    public void setUser(byte[] user) {
        this.user = user;
    }


    /**
     * Gets the password value for this SearchDocRq.
     * 
     * @return password
     */
    public byte[] getPassword() {
        return password;
    }


    /**
     * Sets the password value for this SearchDocRq.
     * 
     * @param password
     */
    public void setPassword(byte[] password) {
        this.password = password;
    }


    /**
     * Gets the docClass value for this SearchDocRq.
     * 
     * @return docClass
     */
    public byte[] getDocClass() {
        return docClass;
    }


    /**
     * Sets the docClass value for this SearchDocRq.
     * 
     * @param docClass
     */
    public void setDocClass(byte[] docClass) {
        this.docClass = docClass;
    }


    /**
     * Gets the queryCondition value for this SearchDocRq.
     * 
     * @return queryCondition
     */
    public byte[] getQueryCondition() {
        return queryCondition;
    }


    /**
     * Sets the queryCondition value for this SearchDocRq.
     * 
     * @param queryCondition
     */
    public void setQueryCondition(byte[] queryCondition) {
        this.queryCondition = queryCondition;
    }


    /**
     * Gets the path value for this SearchDocRq.
     * 
     * @return path
     */
    public byte[] getPath() {
        return path;
    }


    /**
     * Sets the path value for this SearchDocRq.
     * 
     * @param path
     */
    public void setPath(byte[] path) {
        this.path = path;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SearchDocRq)) return false;
        SearchDocRq other = (SearchDocRq) obj;
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
            ((this.user==null && other.getUser()==null) || 
             (this.user!=null &&
              java.util.Arrays.equals(this.user, other.getUser()))) &&
            ((this.password==null && other.getPassword()==null) || 
             (this.password!=null &&
              java.util.Arrays.equals(this.password, other.getPassword()))) &&
            ((this.docClass==null && other.getDocClass()==null) || 
             (this.docClass!=null &&
              java.util.Arrays.equals(this.docClass, other.getDocClass()))) &&
            ((this.queryCondition==null && other.getQueryCondition()==null) || 
             (this.queryCondition!=null &&
              java.util.Arrays.equals(this.queryCondition, other.getQueryCondition()))) &&
            ((this.path==null && other.getPath()==null) || 
             (this.path!=null &&
              java.util.Arrays.equals(this.path, other.getPath())));
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
        if (getUser() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getUser());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getUser(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPassword() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPassword());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPassword(), i);
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
        if (getQueryCondition() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getQueryCondition());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getQueryCondition(), i);
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SearchDocRq.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", ">SearchDocRq"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("objectStore");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ObjectStore"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user");
        elemField.setXmlName(new javax.xml.namespace.QName("", "User"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("password");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Password"));
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
        elemField.setFieldName("queryCondition");
        elemField.setXmlName(new javax.xml.namespace.QName("", "QueryCondition"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("path");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Path"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
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
