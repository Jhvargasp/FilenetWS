/**
 * WSDLFileValidaSOAPSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mx.com.metlife.filenet.cews.WSDLFileValida;

public class WSDLFileValidaSOAPSkeleton implements mx.com.metlife.filenet.cews.WSDLFileValida.WSDLFileValida_PortType, org.apache.axis.wsdl.Skeleton {
    private mx.com.metlife.filenet.cews.WSDLFileValida.WSDLFileValida_PortType impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
    * Returns List of OperationDesc objects with this name
    */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List)_myOperations.get(methodName);
    }

    /**
    * Returns Collection of OperationDescs
    */
    public static java.util.Collection getOperationDescs() {
        return _myOperationsList;
    }

    static {
        org.apache.axis.description.OperationDesc _oper;
        org.apache.axis.description.FaultDesc _fault;
        org.apache.axis.description.ParameterDesc [] _params;
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFileValida/", "InsertDocRq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFileValida/", ">InsertDocRq"), mx.com.metlife.filenet.cews.WSDLFileValida.InsertDocRq.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("insertDocumentValida", _params, new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFileValida/", "InsertDocRs"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFileValida/", ">InsertDocRs"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "insertDocumentValida"));
        _oper.setSoapAction("http://cews.filenet.metlife.com.mx/WSDLFileValida/Operation2");
        _myOperationsList.add(_oper);
        if (_myOperations.get("insertDocumentValida") == null) {
            _myOperations.put("insertDocumentValida", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("insertDocumentValida")).add(_oper);
    }

    public WSDLFileValidaSOAPSkeleton() {
        this.impl = new mx.com.metlife.filenet.cews.WSDLFileValida.WSDLFileValidaSOAPImpl();
    }

    public WSDLFileValidaSOAPSkeleton(mx.com.metlife.filenet.cews.WSDLFileValida.WSDLFileValida_PortType impl) {
        this.impl = impl;
    }
    public mx.com.metlife.filenet.cews.WSDLFileValida.InsertDocRs insertDocumentValida(mx.com.metlife.filenet.cews.WSDLFileValida.InsertDocRq parameters) throws java.rmi.RemoteException
    {
        mx.com.metlife.filenet.cews.WSDLFileValida.InsertDocRs ret = impl.insertDocumentValida(parameters);
        return ret;
    }

}
