/**
 * WSDLFile_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mx.com.metlife.filenet.cews.WSDLFile;

public class WSDLFile_ServiceLocator extends org.apache.axis.client.Service implements mx.com.metlife.filenet.cews.WSDLFile.WSDLFile_Service {

    public WSDLFile_ServiceLocator() {
    }


    public WSDLFile_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WSDLFile_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WSDLFileSOAP
    private java.lang.String WSDLFileSOAP_address = "http://localhost:8080/FilenetWS/services/WSDLFileSOAP";

    public java.lang.String getWSDLFileSOAPAddress() {
        return WSDLFileSOAP_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WSDLFileSOAPWSDDServiceName = "WSDLFileSOAP";

    public java.lang.String getWSDLFileSOAPWSDDServiceName() {
        return WSDLFileSOAPWSDDServiceName;
    }

    public void setWSDLFileSOAPWSDDServiceName(java.lang.String name) {
        WSDLFileSOAPWSDDServiceName = name;
    }

    public mx.com.metlife.filenet.cews.WSDLFile.WSDLFile_PortType getWSDLFileSOAP() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WSDLFileSOAP_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWSDLFileSOAP(endpoint);
    }

    public mx.com.metlife.filenet.cews.WSDLFile.WSDLFile_PortType getWSDLFileSOAP(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            mx.com.metlife.filenet.cews.WSDLFile.WSDLFileSOAPStub _stub = new mx.com.metlife.filenet.cews.WSDLFile.WSDLFileSOAPStub(portAddress, this);
            _stub.setPortName(getWSDLFileSOAPWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWSDLFileSOAPEndpointAddress(java.lang.String address) {
        WSDLFileSOAP_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (mx.com.metlife.filenet.cews.WSDLFile.WSDLFile_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                mx.com.metlife.filenet.cews.WSDLFile.WSDLFileSOAPStub _stub = new mx.com.metlife.filenet.cews.WSDLFile.WSDLFileSOAPStub(new java.net.URL(WSDLFileSOAP_address), this);
                _stub.setPortName(getWSDLFileSOAPWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("WSDLFileSOAP".equals(inputPortName)) {
            return getWSDLFileSOAP();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", "WSDLFile");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", "WSDLFileSOAP"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WSDLFileSOAP".equals(portName)) {
            setWSDLFileSOAPEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
