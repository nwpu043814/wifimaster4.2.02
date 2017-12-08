package com.lantern.wifiseccheck;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;

class WifiSecCheckImpl$3
  extends BroadcastReceiver
{
  WifiSecCheckImpl$3(WifiSecCheckImpl paramWifiSecCheckImpl) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    LogUtils.d("WifiSecCheckImpl", "get net state action " + str);
    if (WifiSecCheckImpl.access$1800(this.this$0))
    {
      WifiSecCheckImpl.access$1802(this.this$0, false);
      LogUtils.d("WifiSecCheckImpl", "get net work state change and first ");
    }
    for (;;)
    {
      return;
      if ("android.net.wifi.STATE_CHANGE".equals(str))
      {
        paramContext = (NetworkInfo)paramIntent.getParcelableExtra("networkInfo");
        if (paramContext != null)
        {
          LogUtils.d("WifiSecCheckImpl", "get net work state change and state is " + paramContext.getState() + " type =" + paramContext.getTypeName());
          paramContext.getState();
          paramContext = NetworkInfo.State.CONNECTED;
        }
      }
      else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(str))
      {
        WifiUtils.isWifiConnected(paramContext);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/WifiSecCheckImpl$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */