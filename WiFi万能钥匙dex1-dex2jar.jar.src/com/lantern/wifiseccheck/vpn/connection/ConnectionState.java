package com.lantern.wifiseccheck.vpn.connection;

import com.lantern.wifiseccheck.LogUtils;
import com.lantern.wifiseccheck.WifiUtils;
import com.lantern.wifiseccheck.vpn.data.GlobalPreference;
import com.lantern.wifiseccheck.vpn.entity.SVPNDetailEvent;
import com.lantern.wifiseccheck.vpn.entity.SVPNMainEvent;
import com.lantern.wifiseccheck.vpn.utils.VpnUtils;

public abstract class ConnectionState
{
  protected static final String TAG = "CONN";
  private static boolean isStable = false;
  protected static String lastApMac = null;
  protected static String lastIRApSsid = "";
  protected static String lastVpnSsid = null;
  
  public ConnectionState connectivityChangeReceived(int paramInt)
  {
    LogUtils.e("CONN", "Can NOT treat ConnectivityChange in state: " + getClass().getSimpleName() + "netType:" + paramInt);
    return this;
  }
  
  public void detailEventHappened(SVPNDetailEvent paramSVPNDetailEvent)
  {
    LogUtils.e("CONN", "Can NOT treat detailEventHappened in state: " + getClass().getSimpleName());
  }
  
  public void firstHeartBeat()
  {
    LogUtils.d("CONN", "firstHeartBeat() at : " + System.currentTimeMillis());
    GlobalPreference.getInstance(VpnUtils.getInstance().getApp()).setLong("vpn_connected_life", System.currentTimeMillis());
  }
  
  public String getLastVpnSsid()
  {
    return lastVpnSsid;
  }
  
  public void heartBeat()
  {
    LogUtils.d("CONN", "Heart Beat in state: " + getClass().getSimpleName() + " |do nothing.");
  }
  
  public ConnectionState init()
  {
    LogUtils.e("CONN", "Should NEVER init from state: " + getClass().getSimpleName());
    return this;
  }
  
  public ConnectionState internetStateChanged(boolean paramBoolean)
  {
    LogUtils.e("CONN", "Can NOT treat InternetStateChanged in state: " + getClass().getSimpleName());
    if (paramBoolean) {
      lastIRApSsid = WifiUtils.getWifiName(ConnectionManager.getInstance().getService());
    }
    for (;;)
    {
      return this;
      if (lastIRApSsid.equals(WifiUtils.getWifiName(ConnectionManager.getInstance().getService()))) {
        lastIRApSsid = "";
      }
    }
  }
  
  protected boolean isSameNetType(SVPNMainEvent paramSVPNMainEvent, int paramInt)
  {
    boolean bool = true;
    if ((paramSVPNMainEvent.getType() == 3) && (paramInt == 0)) {}
    for (;;)
    {
      return bool;
      if ((paramSVPNMainEvent.getType() != 1) || (paramInt != 1)) {
        bool = false;
      }
    }
  }
  
  public boolean isStable()
  {
    return isStable;
  }
  
  public ConnectionState refresh()
  {
    LogUtils.e("CONN", "Can NOT treat refresh in state: " + getClass().getSimpleName());
    return this;
  }
  
  public void setLastVpnSsid(String paramString)
  {
    LogUtils.d("CONN", "set lastVpnSsid = " + paramString);
    lastVpnSsid = paramString;
  }
  
  public void setStable(boolean paramBoolean)
  {
    if (paramBoolean) {
      LogUtils.d("CONN", "set state to Stable!");
    }
    for (;;)
    {
      isStable = paramBoolean;
      return;
      LogUtils.d("CONN", "set state to Un-Stable!");
    }
  }
  
  public abstract int toInt();
  
  public ConnectionState vpnConnectedReceived()
  {
    LogUtils.e("CONN", "Can NOT treat VpnConnected in state: " + getClass().getSimpleName());
    lastIRApSsid = WifiUtils.getWifiName(ConnectionManager.getInstance().getService());
    return this;
  }
  
  public ConnectionState vpnDisConnectedReceived()
  {
    LogUtils.e("CONN", "Can NOT treat VpnDisConnected in state: " + getClass().getSimpleName());
    if (lastIRApSsid.equals(WifiUtils.getWifiName(ConnectionManager.getInstance().getService()))) {
      lastIRApSsid = "";
    }
    return this;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/vpn/connection/ConnectionState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */