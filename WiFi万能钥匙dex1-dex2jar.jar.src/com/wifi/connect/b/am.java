package com.wifi.connect.b;

import android.content.Intent;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Message;
import com.bluefay.a.a;
import com.bluefay.b.h;
import com.lantern.core.t;

final class am
  extends com.bluefay.d.b
{
  am(al paramal, int[] paramArrayOfInt)
  {
    super(paramArrayOfInt);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    h.a("handle what:" + i);
    switch (i)
    {
    case 128200: 
    default: 
    case 128205: 
    case 128005: 
      do
      {
        for (;;)
        {
          return;
          h.a("nearby MSG_WIFIKEY_SCREEN_ON  ", new Object[0]);
          al.a(this.a, com.lantern.core.b.c());
          if (("A".equals(al.a(this.a))) || ("B".equals(al.a(this.a)))) {
            if (t.h(al.b(this.a)))
            {
              h.a("nearby MSG_WIFIKEY_SCREEN_ON  nearby true", new Object[0]);
              al.c(this.a).removeCallbacks(null);
              paramMessage = Message.obtain();
              paramMessage.what = 100;
              al.c(this.a).sendMessageDelayed(paramMessage, 5000L);
            }
            else
            {
              h.a("nearby MSG_WIFIKEY_SCREEN_ON  nearby false", new Object[0]);
              al.c(this.a).removeCallbacks(null);
            }
          }
        }
        paramMessage = ((NetworkInfo)((Intent)paramMessage.obj).getParcelableExtra("networkInfo")).getDetailedState();
        if ((paramMessage != NetworkInfo.DetailedState.FAILED) && (paramMessage != NetworkInfo.DetailedState.DISCONNECTED)) {
          break;
        }
      } while (al.d(this.a).isWifiEnabled());
      h.a("nearby !mWifiManager.isWifiEnabled()", new Object[0]);
    }
    for (;;)
    {
      al.e(this.a);
      break;
      if ((paramMessage != NetworkInfo.DetailedState.CONNECTED) || (!a.a(al.b(this.a)))) {
        break;
      }
      h.a("nearby BLNetwork.isWifiNetwork(mContext)", new Object[0]);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/b/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */