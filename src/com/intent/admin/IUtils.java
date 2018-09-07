package com.intent.admin;

import java.util.List;

public abstract interface IUtils
{
  public abstract List query(String paramString)
    throws Exception;
  
  public abstract int execute(String paramString)
    throws Exception;
  
  public abstract List query(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3)
    throws Exception;
  
  public abstract int delete(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
    throws Exception;
  
  public abstract int update(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3, Object[] paramArrayOfObject)
    throws Exception;
  
  public abstract Object insert(String paramString, String[] paramArrayOfString, Object[] paramArrayOfObject)
    throws Exception;
}
