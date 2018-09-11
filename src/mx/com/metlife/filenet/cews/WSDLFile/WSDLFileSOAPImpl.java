/**
 * WSDLFileSOAPImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mx.com.metlife.filenet.cews.WSDLFile;

import java.nio.charset.Charset;
import java.util.Arrays;

import mx.com.metlife.filenet.cews.service.Util;

public class WSDLFileSOAPImpl implements mx.com.metlife.filenet.cews.WSDLFile.WSDLFile_PortType {
	public mx.com.metlife.filenet.cews.WSDLFile.SearchDocRs searchDocuments(
			mx.com.metlife.filenet.cews.WSDLFile.SearchDocRq parameters) throws java.rmi.RemoteException {
		return new Util().executeSearch(parameters);
	}

	public mx.com.metlife.filenet.cews.WSDLFile.GetDocRs getDocument(
			mx.com.metlife.filenet.cews.WSDLFile.GetDocRq parameters) throws java.rmi.RemoteException {
		//return new Util().executeGetDocument(parameters);
		return null;
	}

	public mx.com.metlife.filenet.cews.WSDLFile.InsertDocRs insertDocument(
			mx.com.metlife.filenet.cews.WSDLFile.InsertDocRq parameters) throws java.rmi.RemoteException {
		//return new Util().executeInsert(parameters);
		return null;
	}
	
	public static void encode(String cad) {
		byte [] b=cad.getBytes();
		System.out.println("encode...."+cad);
		for (int i = 0; i < b.length; i++) {
			System.out.print((char)b[i]);
		}
	}
	
	// use to encode https://www.base64encode.org/
	public static void main(String[] args) {
		encode("Correspondencia2012");
		encode("ceadmind");
		encode("sistemas2012");
		encode("Document");
		encode("DocumentTitle like 'a%'");
		SearchDocRq paramSearchDocRq=new SearchDocRq("Correspondencia2012".getBytes(),"ceadmind".getBytes()
				,"sistemas2012".getBytes(),"Document".getBytes(),"DocumentTitle like 'a%' ".getBytes(),"".getBytes());
		//new Util().executeSearch(paramSearchDocRq);
	}

}
