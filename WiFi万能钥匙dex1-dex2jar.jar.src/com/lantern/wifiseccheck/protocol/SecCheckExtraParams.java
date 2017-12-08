package com.lantern.wifiseccheck.protocol;

import java.util.List;
import java.util.Map;

public class SecCheckExtraParams
{
  private List<String> dnsCheckURL;
  private Map<String, List<String>> sslCheckURL;
  private Integer ver;
  private Map<String, String> webCheckURL;
  
  public List<String> getDnsCheckURL()
  {
    return this.dnsCheckURL;
  }
  
  public Map<String, List<String>> getSslCheckURL()
  {
    return this.sslCheckURL;
  }
  
  public Integer getVer()
  {
    return this.ver;
  }
  
  public Map<String, String> getWebCheckURL()
  {
    return this.webCheckURL;
  }
  
  public void setDnsCheckURL(List<String> paramList)
  {
    this.dnsCheckURL = paramList;
  }
  
  public void setSslCheckURL(Map<String, List<String>> paramMap)
  {
    this.sslCheckURL = paramMap;
  }
  
  public void setVer(Integer paramInteger)
  {
    this.ver = paramInteger;
  }
  
  public void setWebCheckURL(Map<String, String> paramMap)
  {
    this.webCheckURL = paramMap;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/protocol/SecCheckExtraParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */