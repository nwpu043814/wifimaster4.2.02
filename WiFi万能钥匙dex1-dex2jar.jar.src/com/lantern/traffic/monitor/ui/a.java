package com.lantern.traffic.monitor.ui;

import android.os.Handler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

final class a
  extends Thread
{
  a(TrafficMonitorActivity paramTrafficMonitorActivity) {}
  
  public final void run()
  {
    TrafficMonitorActivity.a(this.a, com.lantern.traffic.monitor.b.a.a(TrafficMonitorActivity.a(this.a)));
    List localList = TrafficMonitorActivity.b(this.a).c();
    for (int i = 0; i < localList.size(); i++)
    {
      com.lantern.traffic.monitor.c.a locala = (com.lantern.traffic.monitor.c.a)localList.get(i);
      HashMap localHashMap = new HashMap();
      localHashMap.put("appName", locala.a());
      localHashMap.put("appPackageName", locala.b());
      localHashMap.put("startTime", locala.l());
      localHashMap.put("icon", TrafficMonitorActivity.a(this.a, locala.b()));
      TrafficMonitorActivity.c(this.a).add(localHashMap);
      TrafficMonitorActivity.b(this.a).a(locala.b(), locala.a(), 0L, 0L);
    }
    TrafficMonitorActivity.d(this.a).sendEmptyMessage(0);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/traffic/monitor/ui/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */