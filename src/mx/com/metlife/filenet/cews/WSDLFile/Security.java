/**
 * Security.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mx.com.metlife.filenet.cews.WSDLFile;

public class Security  implements java.io.Serializable {
    private byte[] securityTarget;

    private byte[] securityPrincipal;

    private byte[] securityAccess;

    private byte[] securityAccessType;

    public Security() {
    }

    public Security(
           byte[] securityTarget,
           byte[] securityPrincipal,
           byte[] securityAccess,
           byte[] securityAccessType) {
           this.securityTarget = securityTarget;
           this.securityPrincipal = securityPrincipal;
           this.securityAccess = securityAccess;
           this.securityAccessType = securityAccessType;
    }


    /**
     * Gets the securityTarget value for this Security.
     * 
     * @return securityTarget
     */
    public byte[] getSecurityTarget() {
        return securityTarget;
    }


    /**
     * Sets the securityTarget value for this Security.
     * 
     * @param securityTarget
     */
    public void setSecurityTarget(byte[] securityTarget) {
        this.securityTarget = securityTarget;
    }


    /**
     * Gets the securityPrincipal value for this Security.
     * 
     * @return securityPrincipal
     */
    public byte[] getSecurityPrincipal() {
        return securityPrincipal;
    }


    /**
     * Sets the securityPrincipal value for this Security.
     * 
     * @param securityPrincipal
     */
    public void setSecurityPrincipal(byte[] securityPrincipal) {
        this.securityPrincipal = securityPrincipal;
    }


    /**
     * Gets the securityAccess value for this Security.
     * 
     * @return securityAccess
     */
    public byte[] getSecurityAccess() {
        return securityAccess;
    }


    /**
     * Sets the securityAccess value for this Security.
     * 
     * @param securityAccess
     */
    public void setSecurityAccess(byte[] securityAccess) {
        this.securityAccess = securityAccess;
    }


    /**
     * Gets the securityAccessType value for this Security.
     * 
     * @return securityAccessType
     */
    public byte[] getSecurityAccessType() {
        return securityAccessType;
    }


    /**
     * Sets the securityAccessType value for this Security.
     * 
     * @param securityAccessType
     */
    public void setSecurityAccessType(byte[] securityAccessType) {
        this.securityAccessType = securityAccessType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Security)) return false;
        Security other = (Security) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.securityTarget==null && other.getSecurityTarget()==null) || 
             (this.securityTarget!=null &&
              java.util.Arrays.equals(this.securityTarget, other.getSecurityTarget()))) &&
            ((this.securityPrincipal==null && other.getSecurityPrincipal()==null) || 
             (this.securityPrincipal!=null &&
              java.util.Arrays.equals(this.securityPrincipal, other.getSecurityPrincipal()))) &&
            ((this.securityAccess==null && other.getSecurityAccess()==null) || 
             (this.securityAccess!=null &&
              java.util.Arrays.equals(this.securityAccess, other.getSecurityAccess()))) &&
            ((this.securityAccessType==null && other.getSecurityAccessType()==null) || 
             (this.securityAccessType!=null &&
              java.util.Arrays.equals(this.securityAccessType, other.getSecurityAccessType())));
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
        if (getSecurityTarget() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSecurityTarget());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSecurityTarget(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSecurityPrincipal() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSecurityPrincipal());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSecurityPrincipal(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSecurityAccess() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSecurityAccess());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSecurityAccess(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSecurityAccessType() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSecurityAccessType());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSecurityAccessType(), i);
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
        new org.apache.axis.description.TypeDesc(Security.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", "Security"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("securityTarget");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SecurityTarget"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("securityPrincipal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SecurityPrincipal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("securityAccess");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SecurityAccess"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("securityAccessType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SecurityAccessType"));
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
