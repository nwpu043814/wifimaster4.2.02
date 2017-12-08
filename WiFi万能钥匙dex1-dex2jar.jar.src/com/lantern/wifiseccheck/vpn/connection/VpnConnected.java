package com.lantern.wifiseccheck.vpn.connection;

import com.lantern.wifiseccheck.LogUtils;
import com.lantern.wifiseccheck.WifiUtils;
import com.lantern.wifiseccheck.vpn.data.GlobalPreference;
import com.lantern.wifiseccheck.vpn.data.SVPNStorage;
import com.lantern.wifiseccheck.vpn.entity.SVPNDetailEvent;
import com.lantern.wifiseccheck.vpn.entity.SVPNMainEvent;
import com.lantern.wifiseccheck.vpn.utils.VpnUtils;

public class VpnConnected
  extends ConnectionState
{
  private int netType = -1;
  
  public ConnectionState connectivityChangeReceived(int paramInt)
  {
    LogUtils.d("CONN", "ConnectivityChangeReceived() with netType " + paramInt + " " + getClass().getSimpleName());
    firstHeartBeat();
    Object localObject = SVPNStorage.getTopMainEvent();
    GlobalPreference.getInstance(VpnUtils.getInstance().getApp()).getLong("vpn_connected_life", 0L);
    if (isSameNetType((SVPNMainEvent)localObject, paramInt)) {
      if (paramInt == 1)
      {
        this.netType = 1;
        localObject = WifiUtils.getAPMacAddress(ConnectionManager.getInstance().getService());
        LogUtils.d("CONN", "currentMac is " + (String)localObject + " last apmac is " + lastApMac);
        if (localObject == null) {
          LogUtils.d("CONN", "ConnectivityChangeReceived: isConnected == true BUT CAN NOT get MAC! Ignored");
        }
      }
    }
    for (;;)
    {
      return this;
      if (!((String)localObject).equals(lastApMac))
      {
        LogUtils.d("CONN", "ConnectivityChangeReceived() with wifi connected|different mac.");
        lastApMac = (String)localObject;
        LogUtils.d("CONN", "ConnectivityChangeReceived: StartTestInternet in state:" + getClass().getSimpleName());
        setStable(false);
        LogUtils.d("CONN", "connectivityChangeReceived() in state: VpnConnected");
        getLastVpnSsid();
        WifiUtils.getWifiName(ConnectionManager.getInstance().getService());
        firstHeartBeat();
        setStable(true);
        ConnectionManager.getInstance().planNotifyUI(2000L);
      }
      else
      {
        LogUtils.d("CONN", "ConnectivityChangeReceived() with wifi connected|same mac.");
        continue;
        LogUtils.d("CONN", "VpnConnectedReceived() same TYPE_MOBILE");
        this.netType = 0;
        setStable(true);
        continue;
        if (paramInt == 1)
        {
          localObject = WifiUtils.getWifiName(ConnectionManager.getInstance().getService());
          lastApMac = WifiUtils.getAPMacAddress(ConnectionManager.getInstance().getService());
          setLastVpnSsid((String)localObject);
          this.netType = 1;
        }
        else
        {
          this.netType = 0;
        }
      }
    }
  }
  
  public void detailEventHappened(SVPNDetailEvent paramSVPNDetailEvent)
  {
    LogUtils.d("CONN", "detailEventHappened() with event: " + paramSVPNDetailEvent.getSummary());
    SVPNStorage.insertEntityToDB(paramSVPNDetailEvent);
  }
  
  public void heartBeat()
  {
    LogUtils.d("CONN", "heartBeat() at : " + System.currentTimeMillis());
    GlobalPreference.getInstance(VpnUtils.getInstance().getApp()).setLong("vpn_connected_life", System.currentTimeMillis());
  }
  
  public ConnectionState refresh()
  {
    setStable(false);
    ConnectionManager.getInstance().planNotifyUI();
    Object localObject = this;
    if (this.netType == 1) {
      localObject = new WifiConnected();
    }
    return (ConnectionState)localObject;
  }
  
  public void setNetType(int paramInt)
  {
    this.netType = paramInt;
  }
  
  public int toInt()
  {
    if (this.netType == 1) {}
    for (int i = 3;; i = 4) {
      return i;
    }
  }
  
  public ConnectionState vpnDisConnectedReceived()
  {
    super.vpnDisConnectedReceived();
    WifiConnected localWifiConnected = new WifiConnected();
    LogUtils.d("CONN", "vpnDisConnectedReceived() with netType " + this.netType + " " + getClass().getSimpleName());
    setStable(true);
    ConnectionManager.getInstance().planNotifyUI(3000L);
    return localWifiConnected;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/vpn/connection/VpnConnected.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */