/**
 * WSDLFileValida_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mx.com.metlife.filenet.cews.WSDLFileValida;

public class WSDLFileValida_ServiceLocator extends org.apache.axis.client.Service implements mx.com.metlife.filenet.cews.WSDLFileValida.WSDLFileValida_Service {

    public WSDLFileValida_ServiceLocator() {
    }


    public WSDLFileValida_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WSDLFileValida_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WSDLFile2SOAP
    private java.lang.String WSDLFile2SOAP_address = "http://localhost:8080/FilenetWS/services/WSDLFileValidaSOAP";

    public java.lang.String getWSDLFile2SOAPAddress() {
        return WSDLFile2SOAP_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WSDLFile2SOAPWSDDServiceName = "WSDLFile2SOAP";

    public java.lang.String getWSDLFile2SOAPWSDDServiceName() {
        return WSDLFile2SOAPWSDDServiceName;
    }

    public void setWSDLFile2SOAPWSDDServiceName(java.lang.String name) {
        WSDLFile2SOAPWSDDServiceName = name;
    }

    public mx.com.metlife.filenet.cews.WSDLFileValida.WSDLFileValida_PortType getWSDLFile2SOAP() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WSDLFile2SOAP_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWSDLFile2SOAP(endpoint);
    }

    public mx.com.metlife.filenet.cews.WSDLFileValida.WSDLFileValida_PortType getWSDLFile2SOAP(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            mx.com.metlife.filenet.cews.WSDLFileValida.WSDLFileValidaSOAPStub _stub = new mx.com.metlife.filenet.cews.WSDLFileValida.WSDLFileValidaSOAPStub(portAddress, this);
            _stub.setPortName(getWSDLFile2SOAPWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWSDLFile2SOAPEndpointAddress(java.lang.String address) {
        WSDLFile2SOAP_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (mx.com.metlife.filenet.cews.WSDLFileValida.WSDLFileValida_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                mx.com.metlife.filenet.cews.WSDLFileValida.WSDLFileValidaSOAPStub _stub = new mx.com.metlife.filenet.cews.WSDLFileValida.WSDLFileValidaSOAPStub(new java.net.URL(WSDLFile2SOAP_address), this);
                _stub.setPortName(getWSDLFile2SOAPWSDDServiceName());
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
        if ("WSDLFile2SOAP".equals(inputPortName)) {
            return getWSDLFile2SOAP();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFileValida/", "WSDLFileValida");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFileValida/", "WSDLFile2SOAP"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WSDLFile2SOAP".equals(portName)) {
            setWSDLFile2SOAPEndpointAddress(address);
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
