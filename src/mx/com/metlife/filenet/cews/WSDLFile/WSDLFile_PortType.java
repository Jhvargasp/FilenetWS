/**
 * WSDLFile_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mx.com.metlife.filenet.cews.WSDLFile;

public interface WSDLFile_PortType extends java.rmi.Remote {
    public mx.com.metlife.filenet.cews.WSDLFile.SearchDocRs searchDocuments(mx.com.metlife.filenet.cews.WSDLFile.SearchDocRq parameters) throws java.rmi.RemoteException;
    public mx.com.metlife.filenet.cews.WSDLFile.GetDocRs getDocument(mx.com.metlife.filenet.cews.WSDLFile.GetDocRq parameters) throws java.rmi.RemoteException;
    public mx.com.metlife.filenet.cews.WSDLFile.InsertDocRs insertDocument(mx.com.metlife.filenet.cews.WSDLFile.InsertDocRq parameters) throws java.rmi.RemoteException;
    public mx.com.metlife.filenet.cews.WSDLFile.UpdateMetadataRs updateDocs(mx.com.metlife.filenet.cews.WSDLFile.UpdateMetadataRq parameters) throws java.rmi.RemoteException;
}
