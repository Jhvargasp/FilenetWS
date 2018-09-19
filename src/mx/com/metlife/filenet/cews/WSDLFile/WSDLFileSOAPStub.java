/**
 * WSDLFileSOAPStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mx.com.metlife.filenet.cews.WSDLFile;

public class WSDLFileSOAPStub extends org.apache.axis.client.Stub implements mx.com.metlife.filenet.cews.WSDLFile.WSDLFile_PortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[4];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("searchDocuments");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", "SearchDocRq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", ">SearchDocRq"), mx.com.metlife.filenet.cews.WSDLFile.SearchDocRq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", ">SearchDocRs"));
        oper.setReturnClass(mx.com.metlife.filenet.cews.WSDLFile.SearchDocRs.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", "SearchDocRs"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getDocument");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", "GetDocRq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", ">GetDocRq"), mx.com.metlife.filenet.cews.WSDLFile.GetDocRq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", ">GetDocRs"));
        oper.setReturnClass(mx.com.metlife.filenet.cews.WSDLFile.GetDocRs.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", "GetDocRs"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("insertDocument");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", "InsertDocRq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", ">InsertDocRq"), mx.com.metlife.filenet.cews.WSDLFile.InsertDocRq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", ">InsertDocRs"));
        oper.setReturnClass(mx.com.metlife.filenet.cews.WSDLFile.InsertDocRs.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", "InsertDocRs"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("UpdateDocs");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", "UpdateMetadataRq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", ">UpdateMetadataRq"), mx.com.metlife.filenet.cews.WSDLFile.UpdateMetadataRq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", ">UpdateMetadataRs"));
        oper.setReturnClass(mx.com.metlife.filenet.cews.WSDLFile.UpdateMetadataRs.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", "UpdateMetadataRs"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

    }

    public WSDLFileSOAPStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public WSDLFileSOAPStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public WSDLFileSOAPStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", ">GetDocRq");
            cachedSerQNames.add(qName);
            cls = mx.com.metlife.filenet.cews.WSDLFile.GetDocRq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", ">GetDocRs");
            cachedSerQNames.add(qName);
            cls = mx.com.metlife.filenet.cews.WSDLFile.GetDocRs.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", ">InsertDocRq");
            cachedSerQNames.add(qName);
            cls = mx.com.metlife.filenet.cews.WSDLFile.InsertDocRq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", ">InsertDocRs");
            cachedSerQNames.add(qName);
            cls = mx.com.metlife.filenet.cews.WSDLFile.InsertDocRs.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", ">SearchDocRq");
            cachedSerQNames.add(qName);
            cls = mx.com.metlife.filenet.cews.WSDLFile.SearchDocRq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", ">SearchDocRs");
            cachedSerQNames.add(qName);
            cls = mx.com.metlife.filenet.cews.WSDLFile.SearchDocRs.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", ">UpdateMetadataRq");
            cachedSerQNames.add(qName);
            cls = mx.com.metlife.filenet.cews.WSDLFile.UpdateMetadataRq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", ">UpdateMetadataRs");
            cachedSerQNames.add(qName);
            cls = mx.com.metlife.filenet.cews.WSDLFile.UpdateMetadataRs.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", "DocError");
            cachedSerQNames.add(qName);
            cls = mx.com.metlife.filenet.cews.WSDLFile.DocError.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", "DocsError");
            cachedSerQNames.add(qName);
            cls = mx.com.metlife.filenet.cews.WSDLFile.DocsError.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", "Document");
            cachedSerQNames.add(qName);
            cls = mx.com.metlife.filenet.cews.WSDLFile.Metadata[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", "Metadata");
            qName2 = new javax.xml.namespace.QName("", "Metadata");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", "Documents");
            cachedSerQNames.add(qName);
            cls = mx.com.metlife.filenet.cews.WSDLFile.Metadata[][].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", "Document");
            qName2 = new javax.xml.namespace.QName("", "Document");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", "File");
            cachedSerQNames.add(qName);
            cls = mx.com.metlife.filenet.cews.WSDLFile.File.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", "GUIDs");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string");
            qName2 = new javax.xml.namespace.QName("", "GUID");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", "Metadata");
            cachedSerQNames.add(qName);
            cls = mx.com.metlife.filenet.cews.WSDLFile.Metadata.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", "MetadataStr");
            cachedSerQNames.add(qName);
            cls = mx.com.metlife.filenet.cews.WSDLFile.MetadataStr.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", "PropertiesStr");
            cachedSerQNames.add(qName);
            cls = mx.com.metlife.filenet.cews.WSDLFile.MetadataStr[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", "MetadataStr");
            qName2 = new javax.xml.namespace.QName("", "MetadataStr");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", "Security");
            cachedSerQNames.add(qName);
            cls = mx.com.metlife.filenet.cews.WSDLFile.Security.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", "SecurityGroup");
            cachedSerQNames.add(qName);
            cls = mx.com.metlife.filenet.cews.WSDLFile.Security[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", "Security");
            qName2 = new javax.xml.namespace.QName("", "Security");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", "UpdateMetadataRqType");
            cachedSerQNames.add(qName);
            cls = mx.com.metlife.filenet.cews.WSDLFile.UpdateMetadataRqType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://cews.filenet.metlife.com.mx/WSDLFile/", "UpdateMetadataRsType");
            cachedSerQNames.add(qName);
            cls = mx.com.metlife.filenet.cews.WSDLFile.UpdateMetadataRsType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public mx.com.metlife.filenet.cews.WSDLFile.SearchDocRs searchDocuments(mx.com.metlife.filenet.cews.WSDLFile.SearchDocRq parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://cews.filenet.metlife.com.mx/WSDLFile/Operation");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "searchDocuments"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (mx.com.metlife.filenet.cews.WSDLFile.SearchDocRs) _resp;
            } catch (java.lang.Exception _exception) {
                return (mx.com.metlife.filenet.cews.WSDLFile.SearchDocRs) org.apache.axis.utils.JavaUtils.convert(_resp, mx.com.metlife.filenet.cews.WSDLFile.SearchDocRs.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public mx.com.metlife.filenet.cews.WSDLFile.GetDocRs getDocument(mx.com.metlife.filenet.cews.WSDLFile.GetDocRq parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://cews.filenet.metlife.com.mx/WSDLFile/Operation1");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getDocument"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (mx.com.metlife.filenet.cews.WSDLFile.GetDocRs) _resp;
            } catch (java.lang.Exception _exception) {
                return (mx.com.metlife.filenet.cews.WSDLFile.GetDocRs) org.apache.axis.utils.JavaUtils.convert(_resp, mx.com.metlife.filenet.cews.WSDLFile.GetDocRs.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public mx.com.metlife.filenet.cews.WSDLFile.InsertDocRs insertDocument(mx.com.metlife.filenet.cews.WSDLFile.InsertDocRq parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://cews.filenet.metlife.com.mx/WSDLFile/Operation2");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "insertDocument"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (mx.com.metlife.filenet.cews.WSDLFile.InsertDocRs) _resp;
            } catch (java.lang.Exception _exception) {
                return (mx.com.metlife.filenet.cews.WSDLFile.InsertDocRs) org.apache.axis.utils.JavaUtils.convert(_resp, mx.com.metlife.filenet.cews.WSDLFile.InsertDocRs.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public mx.com.metlife.filenet.cews.WSDLFile.UpdateMetadataRs updateDocs(mx.com.metlife.filenet.cews.WSDLFile.UpdateMetadataRq parameters) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://cews.filenet.metlife.com.mx/WSDLFile/Operation3");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "UpdateDocs"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {parameters});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (mx.com.metlife.filenet.cews.WSDLFile.UpdateMetadataRs) _resp;
            } catch (java.lang.Exception _exception) {
                return (mx.com.metlife.filenet.cews.WSDLFile.UpdateMetadataRs) org.apache.axis.utils.JavaUtils.convert(_resp, mx.com.metlife.filenet.cews.WSDLFile.UpdateMetadataRs.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
