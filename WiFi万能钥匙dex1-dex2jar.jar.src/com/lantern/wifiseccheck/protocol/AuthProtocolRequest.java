package com.lantern.wifiseccheck.protocol;

public class AuthProtocolRequest
{
  private double adContentVer;
  private double appversion;
  private AppBaseAttr baseAttr;
  private String channel;
  private double clientDnsHelperVer;
  private String dhid;
  private double disallowedApplicationVer;
  private String uhid;
  private double vpnRuleVer;
  
  public double getAdContentVer()
  {
    return this.adContentVer;
  }
  
  public double getAppversion()
  {
    return this.appversion;
  }
  
  public AppBaseAttr getBaseAttr()
  {
    return this.baseAttr;
  }
  
  public String getChannel()
  {
    return this.channel;
  }
  
  public double getClientDnsHelperVer()
  {
    return this.clientDnsHelperVer;
  }
  
  public String getDhid()
  {
    return this.dhid;
  }
  
  public double getDisallowedApplicationVer()
  {
    return this.disallowedApplicationVer;
  }
  
  public String getUhid()
  {
    return this.uhid;
  }
  
  public double getVpnRuleVer()
  {
    return this.vpnRuleVer;
  }
  
  public void setAdContentVer(double paramDouble)
  {
    this.adContentVer = paramDouble;
  }
  
  public void setAppversion(double paramDouble)
  {
    this.appversion = paramDouble;
  }
  
  public void setBaseAttr(AppBaseAttr paramAppBaseAttr)
  {
    this.baseAttr = paramAppBaseAttr;
  }
  
  public void setChannel(String paramString)
  {
    this.channel = paramString;
  }
  
  public void setClientDnsHelperVer(double paramDouble)
  {
    this.clientDnsHelperVer = paramDouble;
  }
  
  public void setDhid(String paramString)
  {
    this.dhid = paramString;
  }
  
  public void setDisallowedApplicationVer(double paramDouble)
  {
    this.disallowedApplicationVer = paramDouble;
  }
  
  public void setUhid(String paramString)
  {
    this.uhid = paramString;
  }
  
  public void setVpnRuleVer(double paramDouble)
  {
    this.vpnRuleVer = paramDouble;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/protocol/AuthProtocolRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */