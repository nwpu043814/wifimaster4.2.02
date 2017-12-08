package com.lantern.safecommand.service;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.lantern.safecommand.aidl.IVpnServiceCallback;

class BaseVpnService$2
  implements Runnable
{
  BaseVpnService$2(BaseVpnService paramBaseVpnService) {}
  
  public void run()
  {
    int i = this.this$0.mCallbackList.beginBroadcast();
    while (i > 0)
    {
      i--;
      try
      {
        ((IVpnServiceCallback)this.this$0.mCallbackList.getBroadcastItem(i)).refreshConnectionStateDone();
      }
      catch (RemoteException localRemoteException)
      {
        localRemoteException.printStackTrace();
      }
    }
    this.this$0.mCallbackList.finishBroadcast();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/safecommand/service/BaseVpnService$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */