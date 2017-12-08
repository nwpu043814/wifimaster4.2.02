package com.lantern.wifiseccheck.protocol;

public class WebMd5Result
{
  private String result;
  private String url;
  
  public WebMd5Result() {}
  
  public WebMd5Result(String paramString1, String paramString2)
  {
    this.url = paramString1;
    this.result = paramString2;
  }
  
  public String getResult()
  {
    return this.result;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public void setResult(String paramString)
  {
    this.result = paramString;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
  }
  
  public String toString()
  {
    return this.url + "||" + this.result;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/protocol/WebMd5Result.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */