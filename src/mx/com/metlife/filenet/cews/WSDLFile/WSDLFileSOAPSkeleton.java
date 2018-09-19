/**
 * WSDLFileSOAPSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mx.com.metlife.filenet.cews.WSDLFile;

public class WSDLFileSOAPSkeleton implements mx.com.metlife.filenet.cews.WSDLFile.WSDLFile_PortType, org.apache.axis.wsdl.Skeleton {
    private mx.com.metlife.filenet.cews.WSDLFile.WSDLFile_PortType impl;
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
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", "SearchDocRq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", ">SearchDocRq"), mx.com.metlife.filenet.cews.WSDLFile.SearchDocRq.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("searchDocuments", _params, new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", "SearchDocRs"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", ">SearchDocRs"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "searchDocuments"));
        _oper.setSoapAction("http://cews.filenet.metlife.com.mx/WSDLFile/Operation");
        _myOperationsList.add(_oper);
        if (_myOperations.get("searchDocuments") == null) {
            _myOperations.put("searchDocuments", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("searchDocuments")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", "GetDocRq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", ">GetDocRq"), mx.com.metlife.filenet.cews.WSDLFile.GetDocRq.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getDocument", _params, new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", "GetDocRs"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", ">GetDocRs"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "getDocument"));
        _oper.setSoapAction("http://cews.filenet.metlife.com.mx/WSDLFile/Operation1");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getDocument") == null) {
            _myOperations.put("getDocument", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getDocument")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", "InsertDocRq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", ">InsertDocRq"), mx.com.metlife.filenet.cews.WSDLFile.InsertDocRq.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("insertDocument", _params, new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", "InsertDocRs"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", ">InsertDocRs"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "insertDocument"));
        _oper.setSoapAction("http://cews.filenet.metlife.com.mx/WSDLFile/Operation2");
        _myOperationsList.add(_oper);
        if (_myOperations.get("insertDocument") == null) {
            _myOperations.put("insertDocument", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("insertDocument")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", "UpdateMetadataRq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", ">UpdateMetadataRq"), mx.com.metlife.filenet.cews.WSDLFile.UpdateMetadataRq.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("updateDocs", _params, new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", "UpdateMetadataRs"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", ">UpdateMetadataRs"));
        _oper.setElementQName(new javax.xml.namespace.QName("", "UpdateDocs"));
        _oper.setSoapAction("http://cews.filenet.metlife.com.mx/WSDLFile/Operation3");
        _myOperationsList.add(_oper);
        if (_myOperations.get("updateDocs") == null) {
            _myOperations.put("updateDocs", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("updateDocs")).add(_oper);
    }

    public WSDLFileSOAPSkeleton() {
        this.impl = new mx.com.metlife.filenet.cews.WSDLFile.WSDLFileSOAPImpl();
    }

    public WSDLFileSOAPSkeleton(mx.com.metlife.filenet.cews.WSDLFile.WSDLFile_PortType impl) {
        this.impl = impl;
    }
    public mx.com.metlife.filenet.cews.WSDLFile.SearchDocRs searchDocuments(mx.com.metlife.filenet.cews.WSDLFile.SearchDocRq parameters) throws java.rmi.RemoteException
    {
        mx.com.metlife.filenet.cews.WSDLFile.SearchDocRs ret = impl.searchDocuments(parameters);
        return ret;
    }

    public mx.com.metlife.filenet.cews.WSDLFile.GetDocRs getDocument(mx.com.metlife.filenet.cews.WSDLFile.GetDocRq parameters) throws java.rmi.RemoteException
    {
        mx.com.metlife.filenet.cews.WSDLFile.GetDocRs ret = impl.getDocument(parameters);
        return ret;
    }

    public mx.com.metlife.filenet.cews.WSDLFile.InsertDocRs insertDocument(mx.com.metlife.filenet.cews.WSDLFile.InsertDocRq parameters) throws java.rmi.RemoteException
    {
        mx.com.metlife.filenet.cews.WSDLFile.InsertDocRs ret = impl.insertDocument(parameters);
        return ret;
    }

    public mx.com.metlife.filenet.cews.WSDLFile.UpdateMetadataRs updateDocs(mx.com.metlife.filenet.cews.WSDLFile.UpdateMetadataRq parameters) throws java.rmi.RemoteException
    {
        mx.com.metlife.filenet.cews.WSDLFile.UpdateMetadataRs ret = impl.updateDocs(parameters);
        return ret;
    }

}
