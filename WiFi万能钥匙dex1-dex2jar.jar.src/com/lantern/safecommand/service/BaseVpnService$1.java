package com.lantern.safecommand.service;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.lantern.safecommand.aidl.ConnectionStateNotify;
import com.lantern.safecommand.aidl.IVpnServiceCallback;
import com.lantern.wifiseccheck.LogUtils;

class BaseVpnService$1
  implements Runnable
{
  BaseVpnService$1(BaseVpnService paramBaseVpnService, ConnectionStateNotify paramConnectionStateNotify) {}
  
  public void run()
  {
    LogUtils.d("BaseVpnService", "send state " + this.val$connectionState.getSsid() + "|" + this.val$connectionState.getState());
    int i = this.this$0.mCallbackList.beginBroadcast();
    while (i > 0)
    {
      i--;
      try
      {
        ((IVpnServiceCallback)this.this$0.mCallbackList.getBroadcastItem(i)).onStateChanged(this.val$connectionState);
      }
      catch (RemoteException localRemoteException)
      {
        localRemoteException.printStackTrace();
      }
    }
    this.this$0.mCallbackList.finishBroadcast();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/safecommand/service/BaseVpnService$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */