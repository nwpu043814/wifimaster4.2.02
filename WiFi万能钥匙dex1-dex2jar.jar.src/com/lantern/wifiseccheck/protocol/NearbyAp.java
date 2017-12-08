package com.lantern.wifiseccheck.protocol;

public class NearbyAp
{
  private String bssid;
  private String ssid;
  
  public String getBssid()
  {
    return this.bssid;
  }
  
  public String getSsid()
  {
    return this.ssid;
  }
  
  public void setBssid(String paramString)
  {
    this.bssid = paramString;
  }
  
  public void setSsid(String paramString)
  {
    this.ssid = paramString;
  }
  
  public String toString()
  {
    return this.bssid + ":" + this.ssid;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/protocol/NearbyAp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */