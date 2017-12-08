package com.lantern.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Message;

final class i
  extends BroadcastReceiver
{
  i(h paramh) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    com.bluefay.b.h.a(paramContext);
    Message localMessage = Message.obtain();
    localMessage.obj = paramIntent;
    if ("android.net.wifi.WIFI_STATE_CHANGED".equals(paramContext)) {
      localMessage.what = 128001;
    }
    for (;;)
    {
      if (localMessage.what > 0) {
        c.dispatch(localMessage);
      }
      return;
      if ("android.net.wifi.SCAN_RESULTS".equals(paramContext)) {
        localMessage.what = 128002;
      } else if ("android.net.wifi.NETWORK_IDS_CHANGED".equals(paramContext)) {
        localMessage.what = 128003;
      } else if ("android.net.wifi.supplicant.STATE_CHANGE".equals(paramContext)) {
        localMessage.what = 128004;
      } else if ("android.net.wifi.STATE_CHANGE".equals(paramContext)) {
        localMessage.what = 128005;
      } else if ("android.net.wifi.RSSI_CHANGED".equals(paramContext)) {
        localMessage.what = 128006;
      } else if ("android.intent.action.SCREEN_OFF".equals(paramContext)) {
        localMessage.what = 128200;
      } else if ("android.intent.action.SCREEN_ON".equals(paramContext)) {
        localMessage.what = 128201;
      } else if ("android.intent.action.USER_PRESENT".equals(paramContext)) {
        localMessage.what = 128205;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */