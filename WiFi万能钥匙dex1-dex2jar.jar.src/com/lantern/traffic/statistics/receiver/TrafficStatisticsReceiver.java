package com.lantern.traffic.statistics.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.lantern.traffic.statistics.c.a;
import com.qihoo.util.StubApp1053578832;

public class TrafficStatisticsReceiver
  extends BroadcastReceiver
{
  static
  {
    StubApp1053578832.interface11(59);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramIntent.getAction()))
    {
      a.a().e().removeCallbacks(a.a().c());
      a.a().e().postDelayed(a.a().c(), 5000L);
    }
    for (;;)
    {
      return;
      if ("android.intent.action.BOOT_COMPLETED".equals(paramContext)) {
        a.a().c().run();
      } else if ("android.intent.action.ACTION_SHUTDOWN".equals(paramContext)) {
        a.a().c().run();
      } else if ("wifi.intent.action.TRAFFIC_STATISTICS_RECEIVER".equals(paramContext)) {
        a.a().d();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/traffic/statistics/receiver/TrafficStatisticsReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */