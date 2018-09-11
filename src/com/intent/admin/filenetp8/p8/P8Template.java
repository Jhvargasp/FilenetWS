package com.intent.admin.filenetp8.p8;

import com.filenet.wcm.api.BaseObject;
import com.filenet.wcm.api.BaseObjects;
import com.filenet.wcm.api.CustomObject;
import com.filenet.wcm.api.Folder;
import com.filenet.wcm.api.ObjectFactory;
import com.filenet.wcm.api.ObjectStore;
import com.filenet.wcm.api.ReadableMetadataObject;
import com.filenet.wcm.api.Search;
import com.filenet.wcm.api.Session;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//import org.jdom.JDOMException;

public class P8Template
{
  public static StringBuffer contentWcmApi = new StringBuffer(
    "RemoteServerUrl =http://localhost:8008/ApplicationEngine/xcmisasoap.dll")
    .append("\r\n")
    .append(
    "RemoteServerUploadUrl =http://localhost:8008/ApplicationEngine/doccontent.dll")
    .append("\r\n")
    .append(
    "RemoteServerDownloadUrl =http://localhost:8008/ApplicationEngine/doccontent.dll")
    .append("\r\n")
    .append("CredentialsProtection =Clear")
    .append("\r\n")
    .append(
    "CryptoKeyFile =E:\\Program Files\\FileNet\\Authentication\\CryptoKeyFile.properties")
    .append("\r\n")
    .append("CredentialsProtection/UserToken = Symmetric")
    .append("\r\n")
    .append(
    "CryptoKeyFile/UserToken =E:\\Program Files\\FileNet\\Authentication\\UTCryptoKeyFile.properties");
  private static Log log = LogFactory.getLog(P8Template.class);
  private Session sess;
  private Properties props;
  
  public void setSession(Session sess)
  {
    this.sess = sess;
  }
  
  public void saveObject(Object object) {}
  
  public static void deleteFolder(Folder folder)
  {
    Iterator it = folder.getContainees().iterator();
    while (it.hasNext())
    {
      BaseObject obj = (BaseObject)it.next();
      if (obj.getObjectType() == 2)
      {
        Folder tmp = (Folder)obj;
        deleteFolder(tmp);
      }
    }
    folder.delete();
  }
  
  public static void deleteObject(CustomObject obj)
  {
    obj.delete();
  }
  /*
  public List getObjectList(Class objectClass)
    throws Exception
  {
    List properties = methodNameAsPropName(objectClass);
    int type = Integer.parseInt(this.props.getProperty(objectClass.getName() + 
      ".p8"));
    
    ObjectStore store = ObjectFactory.getObjectStore("correspondencia2005", 
      this.sess);
    
    Iterator results = null;
    List ls = new LinkedList();
    while (results.hasNext())
    {
      Iterator it = ((List)results.next()).iterator();
      if (it.hasNext())
      {
        Data data = (Data)it.next();
        ReadableMetadataObject obj = (ReadableMetadataObject)store
          .getObject(type, data.getValue().toString());
        
        Iterator propertiesIterator = properties.iterator();
        Object instance = objectClass.newInstance();
        Method[] methods;
        int i;
        for (; propertiesIterator.hasNext(); i < methods.length)
        {
          String prop = propertiesIterator.next().toString();
          
          Object value = obj.getPropertyStringValue(
            this.props.getProperty(objectClass.getName() + "." + prop));
          
          methods = objectClass.getMethods();
          Object[] args = { value };
          i = 0; continue;
          String buffer = methods[i].getName();
          
          String lol = "set" + 
            Character.toUpperCase(prop.charAt(0)) + 
            prop.substring(1);
          if (buffer.startsWith(lol))
          {
            methods[i].invoke(instance, args);
            i = methods.length;
          }
          i++;
        }
        ls.add(instance);
      }
    }
    return ls;
  }
  */
  /*
  public static List getObjectsNoUsed(Session sess, String store, String query)
  {
    List results = null;
    
    StringBuffer xml = new StringBuffer(
      "<request><objectstores mergeoption=\"none\"><objectstore id=\"");
    xml.append(store);
    xml.append("\"/></objectstores><querystatement>");
    xml.append(query);
    xml
      .append("</querystatement><options maxrecords=\"99999\"/></request>");
    
    Search oSearch = ObjectFactory.getSearch(sess);
    String resultString = oSearch.executeXML(xml.toString());
    try
    {
      results = SearchUtils.searchAsCollection(resultString, false);
    }
    catch (JDOMException localJDOMException) {}catch (IOException localIOException) {}
    return results;
  }*/
  /*
  
  public static List getObjects(String className, String store, Session sess, String orderBy, String[] st)
  {
    List results = null;
    
    StringBuffer xml = new StringBuffer(
      "<request><objectstores mergeoption=\"none\"><objectstore id=\"");
    xml.append(store);
    xml.append("\"/></objectstores><querystatement>SELECT c.id ");
    if (st == null) {
      xml.append(", c." + orderBy);
    } else {
      for (int i = 0; i < st.length; i++)
      {
        if (i == 0) {
          xml.append(", c.");
        }
        xml.append(st[i]);
        if (i + 1 < st.length) {
          xml.append(", c.");
        }
      }
    }
    xml.append(" FROM  ");
    xml.append(className);
    xml.append(" c ");
    xml.append(" ORDER BY c.");
    xml.append(orderBy);
    xml.append("  ASC  ");
    xml
      .append("</querystatement><options maxrecords=\"99999\"/></request>");
    
    Search oSearch = ObjectFactory.getSearch(sess);
    String resultString = oSearch.executeXML(xml.toString());
    try
    {
      results = SearchUtils.searchAsCollection(resultString, false);
    }
    catch (JDOMException localJDOMException) {}catch (IOException localIOException) {}
    return results;
  }
  */
  /*
  public static List getObjects(String className, String store, Session sess, String orderBy, String[] st, String where)
  {
    List results = null;
    
    StringBuffer xml = new StringBuffer(
      "<request><objectstores mergeoption=\"none\"><objectstore id=\"");
    xml.append(store);
    xml.append("\"/></objectstores><querystatement>SELECT c.id ");
    if (st == null) {
      xml.append(", c." + orderBy);
    } else {
      for (int i = 0; i < st.length; i++)
      {
        if (i == 0) {
          xml.append(", c.");
        }
        xml.append(st[i]);
        if (i + 1 < st.length) {
          xml.append(", c.");
        }
      }
    }
    xml.append(" FROM  ");
    xml.append(className);
    xml.append(" c ");
    
    xml.append(" " + where + " ");
    
    xml.append(" ORDER BY c.");
    xml.append(orderBy);
    xml.append("  ASC  ");
    xml
      .append("</querystatement><options maxrecords=\"99999\"/></request>");
    
    Search oSearch = ObjectFactory.getSearch(sess);
    String resultString = null;
    try
    {
      if (log.isDebugEnabled()) {
        log.debug(xml.toString());
      }
      resultString = oSearch.executeXML(xml.toString());
    }
    catch (Exception Ex)
    {
      log.error(Ex);
    }
    if (resultString != null) {
      try
      {
        results = SearchUtils.searchAsCollection(resultString, false);
      }
      catch (JDOMException jdomEx)
      {
        log.error(jdomEx);
      }
      catch (IOException ioEx)
      {
        log.error(ioEx);
      }
    }
    return results;
  }
  
  public static List getObjects(Session sess, String xml)
  {
    List results = null;
    
    Search oSearch = ObjectFactory.getSearch(sess);
    String resultString = null;
    try
    {
      if (log.isDebugEnabled()) {
        log.debug(xml);
      }
      resultString = oSearch.executeXML(xml);
    }
    catch (Exception Ex)
    {
      log.error(Ex);
    }
    if (resultString != null) {
      try
      {
        results = SearchUtils.searchAsCollection(resultString, false);
      }
      catch (JDOMException jdomEx)
      {
        log.error(jdomEx);
      }
      catch (IOException ioEx)
      {
        log.error(ioEx);
      }
    }
    return results;
  }
  
  public List methodNameAsPropName(Class object)
  {
    Method[] methods = object.getMethods();
    List properties = new LinkedList();
    for (int i = 0; i < methods.length; i++) {
      if (methods[i].getName().startsWith("set"))
      {
        String methodName = methods[i].getName().substring(3);
        char[] tmp = methodName.toCharArray();
        tmp[0] = Character.toLowerCase(tmp[0]);
        methodName = new String(tmp);
        
        properties.add(methodName);
      }
    }
    return properties;
  }
  
  public Properties getProperties()
    throws Exception
  {
    InputStream in = new FileInputStream(new File(".").getCanonicalPath() + 
      "\\src\\mapping.properties");
    Properties p = new Properties();
    p.load(in);
    
    return p;
  }
  
  public void setProps(Properties props)
  {
    this.props = props;
  }*/
}
