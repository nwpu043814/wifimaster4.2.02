package com.lantern.e.a;

import android.os.Handler;
import android.os.Message;
import com.lantern.safecommand.aidl.ConnectionStateNotify;
import com.lantern.safecommand.aidl.IVpnServiceCallback.Stub;
import com.lantern.wifiseccheck.LogUtils;

final class c
  extends IVpnServiceCallback.Stub
{
  c(b paramb) {}
  
  public final void onStateChanged(ConnectionStateNotify paramConnectionStateNotify)
  {
    LogUtils.d("HomeSdkAct", "receive state from service " + paramConnectionStateNotify.getState() + " " + paramConnectionStateNotify.getSsid());
    Message localMessage = b.a(this.a).obtainMessage(3);
    localMessage.obj = paramConnectionStateNotify;
    b.a(this.a).sendMessage(localMessage);
  }
  
  public final void refreshConnectionStateDone()
  {
    LogUtils.d("HomeSdkAct", "refresh connection state finish");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/e/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */