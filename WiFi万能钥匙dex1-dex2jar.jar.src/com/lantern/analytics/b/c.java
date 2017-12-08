package com.lantern.analytics.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import com.bluefay.b.h;
import com.lantern.core.g.u;

final class c
  extends BroadcastReceiver
{
  c(b paramb) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    h.a(paramContext);
    if ("android.net.wifi.STATE_CHANGE".equals(paramContext))
    {
      paramContext = (NetworkInfo)paramIntent.getParcelableExtra("networkInfo");
      paramIntent = paramContext.getDetailedState();
      h.a("detailstate:" + paramIntent, new Object[0]);
      if (paramIntent != NetworkInfo.DetailedState.CONNECTED) {
        break label80;
      }
      paramContext = u.a(paramContext.getExtraInfo());
      this.a.a(paramContext);
    }
    for (;;)
    {
      return;
      label80:
      paramContext = NetworkInfo.DetailedState.DISCONNECTED;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/analytics/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */