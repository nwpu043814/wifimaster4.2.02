package com.lantern.wifiseccheck.vpn;

import android.content.Context;
import com.lantern.wifiseccheck.vpn.utils.UserUtils;

public class WifiSecCheckVpnImpl
{
  private static final String TAG = "StartVPNImpl";
  private static WifiSecCheckVpnImpl instance;
  private WifiSecCheckVpnManager.StartVpnListener mStartVpnListener;
  
  public static WifiSecCheckVpnImpl getInstance()
  {
    try
    {
      if (instance == null)
      {
        WifiSecCheckVpnImpl localWifiSecCheckVpnImpl = new com/lantern/wifiseccheck/vpn/WifiSecCheckVpnImpl;
        localWifiSecCheckVpnImpl.<init>();
        instance = localWifiSecCheckVpnImpl;
      }
      return instance;
    }
    finally {}
  }
  
  public WifiSecCheckVpnManager.StartVpnListener getmStartVpnListener()
  {
    return this.mStartVpnListener;
  }
  
  public void init(WifiSecCheckVpnManager.StartVpnListener paramStartVpnListener, Context paramContext)
  {
    this.mStartVpnListener = paramStartVpnListener;
    UserUtils.setDhid(paramStartVpnListener.getDhid(), paramContext);
    UserUtils.setUhid(paramStartVpnListener.getUhid(), paramContext);
  }
  
  public void setmStartVpnListener(WifiSecCheckVpnManager.StartVpnListener paramStartVpnListener)
  {
    this.mStartVpnListener = paramStartVpnListener;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/vpn/WifiSecCheckVpnImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */