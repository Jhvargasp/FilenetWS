/**
 * WSDLFileValidaSOAPImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mx.com.metlife.filenet.cews.WSDLFileValida;

import mx.com.metlife.filenet.cews.service.Util;

public class WSDLFileValidaSOAPImpl implements mx.com.metlife.filenet.cews.WSDLFileValida.WSDLFileValida_PortType{
    public mx.com.metlife.filenet.cews.WSDLFileValida.InsertDocRs insertDocumentValida(mx.com.metlife.filenet.cews.WSDLFileValida.InsertDocRq parameters) throws java.rmi.RemoteException {
    	return new Util().executeInsertValida(parameters);
    }

}
