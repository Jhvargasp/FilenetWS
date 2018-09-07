package com.intent.admin.filenetp8.p8;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;
import org.xml.sax.InputSource;

public class SearchUtils
{
  public static String getMimeType(String name)
  {
    name = name.toLowerCase();
    if (name.endsWith(".asc")) {
      return "text/plain";
    }
    if (name.endsWith(".avi")) {
      return "video/x-msvideo";
    }
    if (name.endsWith(".css")) {
      return "text/css";
    }
    if (name.endsWith(".doc")) {
      return "application/msword";
    }
    if (name.endsWith(".exe")) {
      return "application/octet-stream";
    }
    if (name.endsWith(".gif")) {
      return "image/gif";
    }
    if (name.endsWith(".gtar")) {
      return "application/x-gtar";
    }
    if (name.endsWith(".gz")) {
      return "application/x-gzip";
    }
    if (name.endsWith(".htm")) {
      return "text/html";
    }
    if (name.endsWith(".html")) {
      return "text/html";
    }
    if (name.endsWith(".jpe")) {
      return "image/jpeg";
    }
    if (name.endsWith(".jpeg")) {
      return "image/jpeg";
    }
    if (name.endsWith(".jpg")) {
      return "image/jpeg";
    }
    if (name.endsWith(".js")) {
      return "application/x-javascript";
    }
    if (name.endsWith(".mov")) {
      return "video/quicktime";
    }
    if (name.endsWith(".mp2")) {
      return "audio/mpeg";
    }
    if (name.endsWith(".mp3")) {
      return "audio/mpeg";
    }
    if (name.endsWith(".mpe")) {
      return "video/mpeg";
    }
    if (name.endsWith(".mpeg")) {
      return "video/mpeg";
    }
    if (name.endsWith(".mpg")) {
      return "video/mpeg";
    }
    if (name.endsWith(".mpga")) {
      return "audio/mpeg";
    }
    if (name.endsWith(".pdf")) {
      return "application/pdf";
    }
    if (name.endsWith(".png")) {
      return "image/png";
    }
    if (name.endsWith(".pot")) {
      return "application/mspowerpoint";
    }
    if (name.endsWith(".pps")) {
      return "application/mspowerpoint";
    }
    if (name.endsWith(".ppt")) {
      return "application/mspowerpoint";
    }
    if (name.endsWith(".ppz")) {
      return "application/mspowerpoint";
    }
    if (name.endsWith(".rtf")) {
      return "text/rtf";
    }
    if (name.endsWith(".rtx")) {
      return "text/richtext";
    }
    if (name.endsWith(".swf")) {
      return "application/x-shockwave-flash";
    }
    if (name.endsWith(".tif")) {
      return "image/tiff";
    }
    if (name.endsWith(".tiff")) {
      return "image/tiff";
    }
    if (name.endsWith(".txt")) {
      return "text/plain";
    }
    if (name.endsWith(".xls")) {
      return "application/vnd.ms-excel";
    }
    if (name.endsWith(".xml")) {
      return "text/xml";
    }
    if (name.endsWith(".zip")) {
      return "application/zip";
    }
    return "";
  }
  
  public static String getValue(String name, List row)
  {
    Iterator it = row.iterator();
    String st = null;
    while (it.hasNext())
    {
      Data data = (Data)it.next();
      if (data.getName().equals(name))
      {
        st = data.getValue().toString();
        break;
      }
    }
    return st;
  }
  
  public static List searchAsCollection(String xml, boolean linkProperty)
    throws JDOMException, IOException
  {
    InputSource input = new InputSource(new StringReader(xml));
    Document doc = new SAXBuilder().build(input);
    Element schema = doc.getRootElement();
    Namespace nsS = Namespace.getNamespace("s", 
      "uuid:BDC6E3F0-6DA3-11d1-A2A3-00AA00C14882");
    Namespace nsRS = Namespace.getNamespace("rs", 
      "urn:schemas-microsoft-com:rowset");
    
    Namespace nsDT = Namespace.getNamespace("dt", 
      "uuid:C2F41010-65B3-11d1-A29F-00AA00C14882");
    
    Namespace nsZ = Namespace.getNamespace("z", "#RowsetSchema");
    
    Hashtable baseObjects = new Hashtable();
    
    Iterator bases = schema.getChild("Schema", nsS).getChild("ElementType", 
      nsS).getChildren("AttributeType", nsS).iterator();
    int size = 0;
    String linkName = null;
    while (bases.hasNext())
    {
      Element base = (Element)bases.next();
      Data data = new Data();
      
      data.setName(base.getAttribute("name").getValue());
      data.setRsNumber(Integer.parseInt(
        base.getAttribute("number", nsRS).getValue()));
      data.setType(
        base.getChild("datatype", nsS).getAttribute("type", nsDT).getValue());
      
      baseObjects.put(data.getName(), data);
      if (!bases.hasNext()) {
        size = data.getRsNumber();
      }
      if ((linkProperty) && (data.getRsNumber() == 1)) {
        linkName = data.getName();
      }
    }
    Iterator rows = schema.getChild("data", nsRS).getChildren("row", nsZ)
      .iterator();
    
    List ls = new LinkedList();
    while (rows.hasNext())
    {
      Element row = (Element)rows.next();
      Enumeration en = baseObjects.keys();
      List cols = new ArrayList(size);
      String link = null;
      String tipo = null;
      while (en.hasMoreElements())
      {
        String name = en.nextElement().toString();
        if ((name.equals(linkName)) && (row.getAttribute(name) != null))
        {
          link = row.getAttribute(name).getValue();
        }
        else
        {
          Data data = ((Data)baseObjects.get(name)).autoClone();
          if (row.getAttribute(name) != null)
          {
            data.setValue(row.getAttribute(name).getValue());
            if (data.getRsNumber() == 2) {
              tipo = data.getValue().toString();
            }
          }
          else
          {
            data.setValue("");
          }
          data.setLink(link);
          data.setTipo(tipo);
          cols.add(data);
        }
      }
      Collections.sort(cols, new DataComparator());
      ls.add(cols);
    }
    return ls;
  }
}
