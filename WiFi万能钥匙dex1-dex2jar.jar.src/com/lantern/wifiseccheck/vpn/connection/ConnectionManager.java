package com.lantern.wifiseccheck.vpn.connection;

import com.lantern.safecommand.aidl.ConnectionStateNotify;
import com.lantern.safecommand.service.SafeVpnService;
import com.lantern.safecommand.service.SafeVpnService.StartVpnParam;
import com.lantern.wifiseccheck.LogUtils;
import com.lantern.wifiseccheck.WifiUtils;
import com.lantern.wifiseccheck.vpn.entity.SVPNDetailEvent;
import com.lantern.wifiseccheck.vpn.utils.VpnUtils;

public class ConnectionManager
  implements VpnConnectorObserver
{
  protected static final long CONN_DELAY_TIME = 2000L;
  protected static final long DIS_CONN_DELAY_TIME = 3000L;
  private static final String TAG = "CONN";
  private static ConnectionManager instance = new ConnectionManager();
  private static int lastNotifyFailedCode = -1;
  private static String lastNotifySSID = "";
  private static int lastNotifyUiCode = -1;
  private String internetTestUrl = null;
  private boolean isTestingInternet = false;
  public String lastTestSSID = null;
  private boolean refreshStateOngoing = false;
  private SafeVpnService service = null;
  private ConnectionState state = null;
  
  private void changeState(ConnectionState paramConnectionState)
  {
    if (paramConnectionState == null) {
      LogUtils.e("CONN", "change state to null from state: " + this.state.getClass().getSimpleName());
    }
    this.state = paramConnectionState;
  }
  
  private void finishRefreshState()
  {
    LogUtils.d("CONN", "Refresh job DONE!");
    this.refreshStateOngoing = false;
    this.service.refreshStateDone();
  }
  
  public static ConnectionManager getInstance()
  {
    return instance;
  }
  
  public void connectivityChangeReceived(int paramInt)
  {
    if (paramInt != 1) {
      this.isTestingInternet = false;
    }
    for (;;)
    {
      changeState(this.state.connectivityChangeReceived(paramInt));
      return;
      String str = WifiUtils.getWifiName(getService());
      LogUtils.d("CONN", "isVPNStarted() " + isVPNStarted() + " same ssid " + WifiUtils.isTheSameSSID(this.lastTestSSID, str));
      if (!isVPNStarted()) {
        WifiUtils.isTheSameSSID(this.lastTestSSID, str);
      }
    }
  }
  
  public void detailEventHappend(SVPNDetailEvent paramSVPNDetailEvent)
  {
    this.state.detailEventHappened(paramSVPNDetailEvent);
  }
  
  public String getLastVpnSSID()
  {
    if (this.state != null) {}
    for (String str = this.state.getLastVpnSsid();; str = null) {
      return str;
    }
  }
  
  public SafeVpnService getService()
  {
    return this.service;
  }
  
  public void init(SafeVpnService paramSafeVpnService, String paramString)
  {
    this.service = paramSafeVpnService;
    this.internetTestUrl = paramString;
    instance.state = new WifiConnected();
    instance.state = instance.state.init();
    VpnUtils.getInstance().setService(paramSafeVpnService);
    VpnConnector.getInstance().init(paramSafeVpnService);
    new HeartThread(null).start();
  }
  
  public void internetStateChanged(boolean paramBoolean)
  {
    changeState(this.state.internetStateChanged(paramBoolean));
    this.isTestingInternet = false;
  }
  
  public boolean isStateStable()
  {
    return this.state.isStable();
  }
  
  public boolean isVPNStarted()
  {
    return VpnConnector.getInstance().isVPNStarted();
  }
  
  public void notifyUI()
  {
    int i = VpnConnector.getInstance().getVpnErrCode();
    LogUtils.d("CONN", "notify UI with [ssid:" + WifiUtils.getWifiName(this.service) + "|state:|VPN Error Code:" + VpnConnector.getInstance().getVpnErrCode() + "]");
    ConnectionStateNotify localConnectionStateNotify = new ConnectionStateNotify();
    localConnectionStateNotify.setSsid(WifiUtils.getWifiName(this.service));
    localConnectionStateNotify.setVpnErrCode(i);
    lastNotifyFailedCode = i;
    this.service.changeState(localConnectionStateNotify);
    lastNotifySSID = WifiUtils.getWifiName(this.service);
    this.service.removeMessage(10);
    this.service.sendMessageToSelf(10, 0, 0, null, 5000L);
    if (this.refreshStateOngoing) {
      finishRefreshState();
    }
  }
  
  public void planNotifyUI()
  {
    planNotifyUI(0L);
  }
  
  public void planNotifyUI(long paramLong)
  {
    LogUtils.d("CONN", "send planNotifyUI message with delay " + paramLong + " millis.");
    this.service.removeMessage(27);
    this.service.sendMessageToSelf(27, 0, 0, null, paramLong);
  }
  
  public boolean prepareVpn()
  {
    return VpnConnector.getInstance().prepare();
  }
  
  public void refreshState()
  {
    LogUtils.d("CONN", "Refresh job START!");
    this.refreshStateOngoing = true;
    lastNotifyUiCode = -1;
    if (this.state.isStable())
    {
      notifyUI();
      changeState(this.state.refresh());
      if (this.state.isStable()) {
        notifyUI();
      }
    }
  }
  
  public void startVpn(SafeVpnService.StartVpnParam paramStartVpnParam)
  {
    if (!VpnConnector.getInstance().startVpn(paramStartVpnParam)) {
      changeState(this.state.vpnDisConnectedReceived());
    }
    for (;;)
    {
      return;
      vpnConnectedReceived();
    }
  }
  
  public void stopVpn(boolean paramBoolean)
  {
    VpnConnector.getInstance().stopVpn(paramBoolean);
  }
  
  public void uiReinited()
  {
    lastNotifyUiCode = -1;
  }
  
  public void vpnConnected()
  {
    changeState(this.state.vpnConnectedReceived());
  }
  
  public void vpnConnectedReceived()
  {
    VpnConnector.getInstance().VpnConnected();
  }
  
  public void vpnDisconnected()
  {
    changeState(this.state.vpnDisConnectedReceived());
  }
  
  public void vpnTestTimeout()
  {
    VpnConnector.getInstance().VpnTestTimeout();
  }
  
  private class HeartThread
    extends Thread
  {
    private HeartThread() {}
    
    public void run()
    {
      for (;;)
      {
        ConnectionManager.this.state.heartBeat();
        try
        {
          Thread.sleep(60000L);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/vpn/connection/ConnectionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */