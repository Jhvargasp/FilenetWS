/**
 * GetDocRq.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mx.com.metlife.filenet.cews.WSDLFile;

public class GetDocRq  implements java.io.Serializable {
    private byte[] objectStore;

    private byte[] user;

    private byte[] password;

    private byte[] GUID;

    public GetDocRq() {
    }

    public GetDocRq(
           byte[] objectStore,
           byte[] user,
           byte[] password,
           byte[] GUID) {
           this.objectStore = objectStore;
           this.user = user;
           this.password = password;
           this.GUID = GUID;
    }


    /**
     * Gets the objectStore value for this GetDocRq.
     * 
     * @return objectStore
     */
    public byte[] getObjectStore() {
        return objectStore;
    }


    /**
     * Sets the objectStore value for this GetDocRq.
     * 
     * @param objectStore
     */
    public void setObjectStore(byte[] objectStore) {
        this.objectStore = objectStore;
    }


    /**
     * Gets the user value for this GetDocRq.
     * 
     * @return user
     */
    public byte[] getUser() {
        return user;
    }


    /**
     * Sets the user value for this GetDocRq.
     * 
     * @param user
     */
    public void setUser(byte[] user) {
        this.user = user;
    }


    /**
     * Gets the password value for this GetDocRq.
     * 
     * @return password
     */
    public byte[] getPassword() {
        return password;
    }


    /**
     * Sets the password value for this GetDocRq.
     * 
     * @param password
     */
    public void setPassword(byte[] password) {
        this.password = password;
    }


    /**
     * Gets the GUID value for this GetDocRq.
     * 
     * @return GUID
     */
    public byte[] getGUID() {
        return GUID;
    }


    /**
     * Sets the GUID value for this GetDocRq.
     * 
     * @param GUID
     */
    public void setGUID(byte[] GUID) {
        this.GUID = GUID;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetDocRq)) return false;
        GetDocRq other = (GetDocRq) obj;
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
            ((this.GUID==null && other.getGUID()==null) || 
             (this.GUID!=null &&
              java.util.Arrays.equals(this.GUID, other.getGUID())));
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
        if (getGUID() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGUID());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGUID(), i);
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
        new org.apache.axis.description.TypeDesc(GetDocRq.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", ">GetDocRq"));
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
        elemField.setFieldName("GUID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "GUID"));
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
