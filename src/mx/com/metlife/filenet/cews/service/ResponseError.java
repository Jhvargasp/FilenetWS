package mx.com.metlife.filenet.cews.service;

public class ResponseError
{
  private String errCd = "";
  private String errStat = "";
  
  public String getErrCd()
  {
    return this.errCd;
  }
  
  public void setErrCd(String paramString)
  {
    this.errCd = paramString;
  }
  
  public String getErrStat()
  {
    return this.errStat;
  }
  
  public void setErrStat(String paramString)
  {
    this.errStat = paramString;
  }
}
