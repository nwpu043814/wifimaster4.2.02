package com.lantern.wifiseccheck.protocol;

public class SslCertResult
{
  private String hostCert;
  private String url;
  
  public SslCertResult() {}
  
  public SslCertResult(String paramString1, String paramString2)
  {
    this.url = paramString1;
    this.hostCert = paramString2;
  }
  
  public String getHostCert()
  {
    return this.hostCert;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public void setHostCert(String paramString)
  {
    this.hostCert = paramString;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
  
  public String toString()
  {
    return this.url + "||" + this.hostCert;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/protocol/SslCertResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */