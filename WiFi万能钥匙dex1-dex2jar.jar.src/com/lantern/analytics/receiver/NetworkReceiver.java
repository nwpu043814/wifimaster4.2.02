package com.lantern.analytics.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import com.bluefay.b.h;
import com.lantern.analytics.a;
import com.lantern.core.c;
import com.lantern.core.k;
import com.lantern.core.p;
import com.lantern.core.q;
import com.qihoo.util.StubApp1053578832;
import com.wifi.connect.service.MsgService;
import org.json.JSONException;
import org.json.JSONObject;

public class NetworkReceiver
  extends BroadcastReceiver
{
  static
  {
    StubApp1053578832.interface11(1);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    h.a(str);
    MsgService.a(paramContext);
    boolean bool;
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(str))
    {
      paramIntent = (NetworkInfo)paramIntent.getParcelableExtra("networkInfo");
      h.a("extra_network_info:%s", new Object[] { paramIntent });
      if ((paramIntent != null) && (paramIntent.isConnected())) {
        if (paramIntent.getType() == 1)
        {
          bool = c.getShareValue().d();
          paramIntent = new JSONObject();
        }
      }
    }
    for (;;)
    {
      try
      {
        paramIntent.put("wkflg", "true");
        paramIntent.put("wififlg", String.valueOf(bool));
        paramIntent.put("cts", String.valueOf(System.currentTimeMillis()));
        paramIntent.put("aid", k.g(paramContext));
        a.e().a("005001", paramIntent);
        return;
      }
      catch (JSONException paramContext)
      {
        h.a(paramContext);
        continue;
      }
      if (paramIntent.getType() == 0)
      {
        long l = p.a(paramContext, "sdk_common", "last_mobile_report_time", 0L);
        if (System.currentTimeMillis() - l > 21600000L)
        {
          p.b(paramContext, "sdk_common", "last_mobile_report_time", System.currentTimeMillis());
          bool = c.getShareValue().d();
          paramIntent = new JSONObject();
          try
          {
            paramIntent.put("wkflg", "false");
            paramIntent.put("wififlg", String.valueOf(bool));
            paramIntent.put("cts", String.valueOf(System.currentTimeMillis()));
            paramIntent.put("aid", k.g(paramContext));
            a.e().a("005001", paramIntent);
          }
          catch (JSONException paramContext)
          {
            h.a(paramContext);
          }
          continue;
          if ((paramIntent != null) && (paramIntent.getType() == 1) && (paramIntent.getType() == 1))
          {
            paramIntent.getState();
            paramContext = NetworkInfo.State.DISCONNECTED;
            continue;
            if ((!"android.intent.action.USER_PRESENT".equals(str)) && (!"android.intent.action.ACTION_POWER_CONNECTED".equals(str)) && (!"android.intent.action.ACTION_POWER_DISCONNECTED".equals(str))) {
              "android.intent.action.MEDIA_MOUNTED".equals(str);
            }
          }
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/analytics/receiver/NetworkReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */