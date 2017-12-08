package com.lantern.wifiseccheck.vpn.connection;

import com.lantern.wifiseccheck.LogUtils;
import com.lantern.wifiseccheck.WifiUtils;
import com.lantern.wifiseccheck.vpn.data.GlobalPreference;
import com.lantern.wifiseccheck.vpn.data.SVPNStorage;
import com.lantern.wifiseccheck.vpn.entity.SVPNMainEvent;
import com.lantern.wifiseccheck.vpn.utils.VpnUtils;

public class WifiConnected
  extends ConnectionState
{
  public ConnectionState connectivityChangeReceived(int paramInt)
  {
    Object localObject = null;
    if (VpnConnector.getInstance().isVPNStarted())
    {
      firstHeartBeat();
      localObject = SVPNStorage.getTopMainEvent();
      GlobalPreference.getInstance(VpnUtils.getInstance().getApp()).getLong("vpn_connected_life", 0L);
      if (!isSameNetType((SVPNMainEvent)localObject, paramInt)) {
        break label148;
      }
      if (paramInt != 1) {
        break label138;
      }
      localObject = WifiUtils.getAPMacAddress(ConnectionManager.getInstance().getService());
      if (((String)localObject).equals(lastApMac))
      {
        LogUtils.d("CONN", "ConnectivityChangeReceived: isConnected == true |same MAC, Ignored");
        localObject = new VpnConnected();
        ((VpnConnected)localObject).setNetType(paramInt);
        ConnectionManager.getInstance().planNotifyUI();
        return (ConnectionState)localObject;
      }
      lastApMac = (String)localObject;
      WifiUtils.getWifiName(ConnectionManager.getInstance().getService());
    }
    for (;;)
    {
      localObject = new VpnConnected();
      ((VpnConnected)localObject).setNetType(paramInt);
      ConnectionManager.getInstance().planNotifyUI();
      setStable(true);
      break;
      label138:
      LogUtils.d("CONN", "connectivityChangeReceived() same TYPE_MOBILE");
      continue;
      label148:
      if (paramInt == 1)
      {
        localObject = WifiUtils.getWifiName(ConnectionManager.getInstance().getService());
        lastApMac = WifiUtils.getAPMacAddress(ConnectionManager.getInstance().getService());
        setLastVpnSsid((String)localObject);
      }
    }
  }
  
  public void heartBeat()
  {
    if (VpnConnector.getInstance().isVPNStarted())
    {
      LogUtils.d("CONN", "heart beat at " + getClass().getSimpleName() + System.currentTimeMillis());
      GlobalPreference.getInstance(VpnUtils.getInstance().getApp()).setLong("vpn_connected_life", System.currentTimeMillis());
    }
  }
  
  public ConnectionState refresh()
  {
    setStable(false);
    if (VpnConnector.getInstance().isVPNStarted())
    {
      LogUtils.d("CONN", "UI back to front with VPN stared, try to reconnect VPN.");
      setStable(false);
    }
    for (;;)
    {
      return this;
      LogUtils.d("CONN", "UI back to front with VPN stoped, try to reconnect internet.");
      setStable(true);
      ConnectionManager.getInstance().planNotifyUI();
    }
  }
  
  public int toInt()
  {
    return 1;
  }
  
  public ConnectionState vpnConnectedReceived()
  {
    super.vpnConnectedReceived();
    SVPNStorage.getTopMainEvent();
    GlobalPreference.getInstance(VpnUtils.getInstance().getApp()).getLong("vpn_connected_life", 0L);
    lastApMac = WifiUtils.getAPMacAddress(ConnectionManager.getInstance().getService());
    WifiUtils.getWifiName(ConnectionManager.getInstance().getService());
    firstHeartBeat();
    setStable(true);
    ConnectionManager.getInstance().planNotifyUI();
    VpnConnected localVpnConnected = new VpnConnected();
    localVpnConnected.setNetType(1);
    LogUtils.d("CONN", "send state VpnConnected ");
    return localVpnConnected;
  }
  
  public ConnectionState vpnDisConnectedReceived()
  {
    super.vpnDisConnectedReceived();
    LogUtils.d("CONN", "received VpnDisConnectedReceived in state: " + getClass().getSimpleName());
    setStable(true);
    ConnectionManager.getInstance().planNotifyUI();
    return new WifiConnected();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/vpn/connection/WifiConnected.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */