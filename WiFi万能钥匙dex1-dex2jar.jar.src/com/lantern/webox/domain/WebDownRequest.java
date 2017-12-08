package com.lantern.webox.domain;

public class WebDownRequest
{
  private String contentDisposition;
  private long contentLength;
  private String cookies;
  private String filename;
  private String mimetype;
  private String url;
  private String userAgent;
  
  public String getContentDisposition()
  {
    return this.contentDisposition;
  }
  
  public long getContentLength()
  {
    return this.contentLength;
  }
  
  public String getCookies()
  {
    return this.cookies;
  }
  
  public String getFilename()
  {
    return this.filename;
  }
  
  public String getMimetype()
  {
    return this.mimetype;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public String getUserAgent()
  {
    return this.userAgent;
  }
  
  public void setContentDisposition(String paramString)
  {
    this.contentDisposition = paramString;
  }
  
  public void setContentLength(long paramLong)
  {
    this.contentLength = paramLong;
  }
  
  public void setCookies(String paramString)
  {
    this.cookies = paramString;
  }
  
  public void setFilename(String paramString)
  {
    this.filename = paramString;
  }
  
  public void setMimetype(String paramString)
  {
    this.mimetype = paramString;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
  
  public void setUserAgent(String paramString)
  {
    this.userAgent = paramString;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/domain/WebDownRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */