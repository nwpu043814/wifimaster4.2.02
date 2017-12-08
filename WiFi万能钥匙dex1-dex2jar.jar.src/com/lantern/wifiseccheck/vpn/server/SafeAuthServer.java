package com.lantern.wifiseccheck.vpn.server;

import com.lantern.wifiseccheck.protocol.AppBaseAttr;
import com.lantern.wifiseccheck.protocol.AuthProtocolResult;

public abstract class SafeAuthServer
{
  private final SafeAuthServerImpl m_impl = new SafeAuthServerImpl(this);
  
  public void request(String paramString1, String paramString2)
  {
    this.m_impl.request(paramString1, paramString2);
  }
  
  protected abstract void requestCb(AuthProtocolResult paramAuthProtocolResult);
  
  public SafeAuthServer setAdContentVer(double paramDouble)
  {
    this.m_impl.setAdContentVer(paramDouble);
    return this;
  }
  
  public SafeAuthServer setAppVersion(int paramInt)
  {
    this.m_impl.setAppVersion(paramInt);
    return this;
  }
  
  public SafeAuthServer setBaseAttr(AppBaseAttr paramAppBaseAttr)
  {
    this.m_impl.setBaseAttr(paramAppBaseAttr);
    return this;
  }
  
  public SafeAuthServer setChannel(String paramString)
  {
    this.m_impl.setChannel(paramString);
    return this;
  }
  
  public SafeAuthServer setClientDnsHelperVer(double paramDouble)
  {
    this.m_impl.setClientDnsHelperVer(paramDouble);
    return this;
  }
  
  public SafeAuthServer setDisallowedApplicationVer(double paramDouble)
  {
    this.m_impl.setDisallowedApplicationVer(paramDouble);
    return this;
  }
  
  public SafeAuthServer setRequestServerAddr(String paramString)
  {
    this.m_impl.setRequestServerAddr(paramString);
    return this;
  }
  
  public SafeAuthServer setVpnRuleVer(double paramDouble)
  {
    this.m_impl.setVpnRule(paramDouble);
    return this;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/vpn/server/SafeAuthServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */