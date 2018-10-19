/**
 * WSDLFileSOAPImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mx.com.metlife.filenet.cews.WSDLFile;

import mx.com.metlife.filenet.cews.service.Util;

public class WSDLFileSOAPImpl implements mx.com.metlife.filenet.cews.WSDLFile.WSDLFile_PortType{
    public mx.com.metlife.filenet.cews.WSDLFile.SearchDocRs searchDocuments(mx.com.metlife.filenet.cews.WSDLFile.SearchDocRq parameters) throws java.rmi.RemoteException {
        return new Util().executeSearch(parameters);
    }

    public mx.com.metlife.filenet.cews.WSDLFile.GetDocRs getDocument(mx.com.metlife.filenet.cews.WSDLFile.GetDocRq parameters) throws java.rmi.RemoteException {
    	return new Util().executeGetDocument(parameters);
    }

    public mx.com.metlife.filenet.cews.WSDLFile.InsertDocRs insertDocument(mx.com.metlife.filenet.cews.WSDLFile.InsertDocRq parameters) throws java.rmi.RemoteException {
    	return new Util().executeInsert(parameters);
    }

    public mx.com.metlife.filenet.cews.WSDLFile.UpdateMetadataRs updateDocs(mx.com.metlife.filenet.cews.WSDLFile.UpdateMetadataRq parameters) throws java.rmi.RemoteException {
    	return new Util().executeUpdate(parameters);
    }

}
