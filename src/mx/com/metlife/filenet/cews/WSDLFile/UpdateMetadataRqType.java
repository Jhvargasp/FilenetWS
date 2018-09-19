/**
 * UpdateMetadataRqType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mx.com.metlife.filenet.cews.WSDLFile;

public class UpdateMetadataRqType  implements java.io.Serializable {
    private java.lang.String objectStore;

    private java.lang.String docClass;

    private java.lang.String queryCondition;

    private java.lang.String path;

    private mx.com.metlife.filenet.cews.WSDLFile.MetadataStr[] propertiesStr;

    private java.lang.String[] GUIDs;

    private java.lang.String tipoConsulta;

    private java.lang.String user;

    private java.lang.String password;

    public UpdateMetadataRqType() {
    }

    public UpdateMetadataRqType(
           java.lang.String objectStore,
           java.lang.String docClass,
           java.lang.String queryCondition,
           java.lang.String path,
           mx.com.metlife.filenet.cews.WSDLFile.MetadataStr[] propertiesStr,
           java.lang.String[] GUIDs,
           java.lang.String tipoConsulta,
           java.lang.String user,
           java.lang.String password) {
           this.objectStore = objectStore;
           this.docClass = docClass;
           this.queryCondition = queryCondition;
           this.path = path;
           this.propertiesStr = propertiesStr;
           this.GUIDs = GUIDs;
           this.tipoConsulta = tipoConsulta;
           this.user = user;
           this.password = password;
    }


    /**
     * Gets the objectStore value for this UpdateMetadataRqType.
     * 
     * @return objectStore
     */
    public java.lang.String getObjectStore() {
        return objectStore;
    }


    /**
     * Sets the objectStore value for this UpdateMetadataRqType.
     * 
     * @param objectStore
     */
    public void setObjectStore(java.lang.String objectStore) {
        this.objectStore = objectStore;
    }


    /**
     * Gets the docClass value for this UpdateMetadataRqType.
     * 
     * @return docClass
     */
    public java.lang.String getDocClass() {
        return docClass;
    }


    /**
     * Sets the docClass value for this UpdateMetadataRqType.
     * 
     * @param docClass
     */
    public void setDocClass(java.lang.String docClass) {
        this.docClass = docClass;
    }


    /**
     * Gets the queryCondition value for this UpdateMetadataRqType.
     * 
     * @return queryCondition
     */
    public java.lang.String getQueryCondition() {
        return queryCondition;
    }


    /**
     * Sets the queryCondition value for this UpdateMetadataRqType.
     * 
     * @param queryCondition
     */
    public void setQueryCondition(java.lang.String queryCondition) {
        this.queryCondition = queryCondition;
    }


    /**
     * Gets the path value for this UpdateMetadataRqType.
     * 
     * @return path
     */
    public java.lang.String getPath() {
        return path;
    }


    /**
     * Sets the path value for this UpdateMetadataRqType.
     * 
     * @param path
     */
    public void setPath(java.lang.String path) {
        this.path = path;
    }


    /**
     * Gets the propertiesStr value for this UpdateMetadataRqType.
     * 
     * @return propertiesStr
     */
    public mx.com.metlife.filenet.cews.WSDLFile.MetadataStr[] getPropertiesStr() {
        return propertiesStr;
    }


    /**
     * Sets the propertiesStr value for this UpdateMetadataRqType.
     * 
     * @param propertiesStr
     */
    public void setPropertiesStr(mx.com.metlife.filenet.cews.WSDLFile.MetadataStr[] propertiesStr) {
        this.propertiesStr = propertiesStr;
    }


    /**
     * Gets the GUIDs value for this UpdateMetadataRqType.
     * 
     * @return GUIDs
     */
    public java.lang.String[] getGUIDs() {
        return GUIDs;
    }


    /**
     * Sets the GUIDs value for this UpdateMetadataRqType.
     * 
     * @param GUIDs
     */
    public void setGUIDs(java.lang.String[] GUIDs) {
        this.GUIDs = GUIDs;
    }


    /**
     * Gets the tipoConsulta value for this UpdateMetadataRqType.
     * 
     * @return tipoConsulta
     */
    public java.lang.String getTipoConsulta() {
        return tipoConsulta;
    }


    /**
     * Sets the tipoConsulta value for this UpdateMetadataRqType.
     * 
     * @param tipoConsulta
     */
    public void setTipoConsulta(java.lang.String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }


    /**
     * Gets the user value for this UpdateMetadataRqType.
     * 
     * @return user
     */
    public java.lang.String getUser() {
        return user;
    }


    /**
     * Sets the user value for this UpdateMetadataRqType.
     * 
     * @param user
     */
    public void setUser(java.lang.String user) {
        this.user = user;
    }


    /**
     * Gets the password value for this UpdateMetadataRqType.
     * 
     * @return password
     */
    public java.lang.String getPassword() {
        return password;
    }


    /**
     * Sets the password value for this UpdateMetadataRqType.
     * 
     * @param password
     */
    public void setPassword(java.lang.String password) {
        this.password = password;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UpdateMetadataRqType)) return false;
        UpdateMetadataRqType other = (UpdateMetadataRqType) obj;
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
              this.objectStore.equals(other.getObjectStore()))) &&
            ((this.docClass==null && other.getDocClass()==null) || 
             (this.docClass!=null &&
              this.docClass.equals(other.getDocClass()))) &&
            ((this.queryCondition==null && other.getQueryCondition()==null) || 
             (this.queryCondition!=null &&
              this.queryCondition.equals(other.getQueryCondition()))) &&
            ((this.path==null && other.getPath()==null) || 
             (this.path!=null &&
              this.path.equals(other.getPath()))) &&
            ((this.propertiesStr==null && other.getPropertiesStr()==null) || 
             (this.propertiesStr!=null &&
              java.util.Arrays.equals(this.propertiesStr, other.getPropertiesStr()))) &&
            ((this.GUIDs==null && other.getGUIDs()==null) || 
             (this.GUIDs!=null &&
              java.util.Arrays.equals(this.GUIDs, other.getGUIDs()))) &&
            ((this.tipoConsulta==null && other.getTipoConsulta()==null) || 
             (this.tipoConsulta!=null &&
              this.tipoConsulta.equals(other.getTipoConsulta()))) &&
            ((this.user==null && other.getUser()==null) || 
             (this.user!=null &&
              this.user.equals(other.getUser()))) &&
            ((this.password==null && other.getPassword()==null) || 
             (this.password!=null &&
              this.password.equals(other.getPassword())));
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
            _hashCode += getObjectStore().hashCode();
        }
        if (getDocClass() != null) {
            _hashCode += getDocClass().hashCode();
        }
        if (getQueryCondition() != null) {
            _hashCode += getQueryCondition().hashCode();
        }
        if (getPath() != null) {
            _hashCode += getPath().hashCode();
        }
        if (getPropertiesStr() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPropertiesStr());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPropertiesStr(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getGUIDs() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGUIDs());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGUIDs(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTipoConsulta() != null) {
            _hashCode += getTipoConsulta().hashCode();
        }
        if (getUser() != null) {
            _hashCode += getUser().hashCode();
        }
        if (getPassword() != null) {
            _hashCode += getPassword().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UpdateMetadataRqType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", "UpdateMetadataRqType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("objectStore");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ObjectStore"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("docClass");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DocClass"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("queryCondition");
        elemField.setXmlName(new javax.xml.namespace.QName("", "QueryCondition"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("path");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Path"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("propertiesStr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PropertiesStr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", "MetadataStr"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "MetadataStr"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("GUIDs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "GUIDs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "GUID"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoConsulta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "TipoConsulta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user");
        elemField.setXmlName(new javax.xml.namespace.QName("", "User"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("password");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Password"));
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
