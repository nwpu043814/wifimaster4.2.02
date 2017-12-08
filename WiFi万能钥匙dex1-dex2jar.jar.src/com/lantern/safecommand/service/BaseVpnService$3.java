package com.lantern.safecommand.service;

import android.os.RemoteCallbackList;
import com.lantern.safecommand.aidl.IVpnServiceCallback;
import com.lantern.safecommand.aidl.VpnServiceInterface.Stub;
import com.lantern.wifiseccheck.LogUtils;

class BaseVpnService$3
  extends VpnServiceInterface.Stub
{
  BaseVpnService$3(BaseVpnService paramBaseVpnService) {}
  
  public void refreshConnectionState()
  {
    this.this$0.sendMessage(31);
  }
  
  public void registerCallback(IVpnServiceCallback paramIVpnServiceCallback)
  {
    if (paramIVpnServiceCallback != null) {
      this.this$0.mCallbackList.register(paramIVpnServiceCallback);
    }
    this.this$0.sendMessage(26);
  }
  
  public void startVpn()
  {
    LogUtils.d("BaseVpnService", "start vpn from UI start");
    this.this$0.sendMessage(18);
  }
  
  public void stopVpn()
  {
    LogUtils.d("BaseVpnService", " stop vpn from ui start");
    this.this$0.sendMessage(19);
  }
  
  public void uiBackToFront()
  {
    this.this$0.sendMessage(30);
  }
  
  public void unregisterCallback(IVpnServiceCallback paramIVpnServiceCallback)
  {
    if (paramIVpnServiceCallback != null) {
      this.this$0.mCallbackList.unregister(paramIVpnServiceCallback);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/safecommand/service/BaseVpnService$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */