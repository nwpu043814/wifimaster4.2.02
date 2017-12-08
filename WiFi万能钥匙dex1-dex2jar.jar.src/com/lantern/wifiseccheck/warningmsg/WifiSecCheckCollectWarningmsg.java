package com.lantern.wifiseccheck.warningmsg;

import java.util.HashMap;
import java.util.Map;

public class WifiSecCheckCollectWarningmsg
{
  private Map<String, String> sslExtraDetails = new HashMap();
  private Map<String, String> webExtraDetails = new HashMap();
  
  public Map<String, String> getSslExtraDetails()
  {
    return this.sslExtraDetails;
  }
  
  public Map<String, String> getWebExtraDetails()
  {
    return this.webExtraDetails;
  }
  
  public void setSslExtraDetails(Map<String, String> paramMap)
  {
    this.sslExtraDetails = paramMap;
  }
  
  public void setWebExtraDetails(Map<String, String> paramMap)
  {
    this.webExtraDetails = paramMap;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/warningmsg/WifiSecCheckCollectWarningmsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */