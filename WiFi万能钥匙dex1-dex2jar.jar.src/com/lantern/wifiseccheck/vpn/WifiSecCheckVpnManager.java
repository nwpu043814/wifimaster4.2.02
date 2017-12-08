package com.lantern.wifiseccheck.vpn;

import android.content.Context;
import android.content.Intent;
import com.lantern.e.a.b;

public class WifiSecCheckVpnManager
{
  private static final String TAG = "WifiSecCheckVpnManager";
  private static WifiSecCheckVpnManager instance;
  
  public static WifiSecCheckVpnManager getInstance()
  {
    try
    {
      if (instance == null)
      {
        WifiSecCheckVpnManager localWifiSecCheckVpnManager = new com/lantern/wifiseccheck/vpn/WifiSecCheckVpnManager;
        localWifiSecCheckVpnManager.<init>();
        instance = localWifiSecCheckVpnManager;
      }
      return instance;
    }
    finally {}
  }
  
  public void init(Context paramContext) {}
  
  public void startSdkActivity(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, b.class);
    localIntent.addFlags(268435456);
    paramContext.startActivity(localIntent);
    new Thread(new WifiSecCheckVpnManager.1(this, paramContext)).start();
  }
  
  public static abstract class StartVpnListener
  {
    public String getAppId()
    {
      return null;
    }
    
    public String getConnChanid()
    {
      return null;
    }
    
    public abstract String getDhid();
    
    public abstract String getUhid();
    
    public abstract Integer getWifiCheckScore();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/vpn/WifiSecCheckVpnManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */