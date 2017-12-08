package com.lantern.traffic.monitor.ui;

import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;

final class c
  extends Handler
{
  c(TrafficMonitorActivity paramTrafficMonitorActivity) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if (TrafficMonitorActivity.c(this.a).size() <= 0) {
      this.a.finish();
    }
    for (;;)
    {
      return;
      TrafficMonitorActivity.e(this.a);
      TrafficMonitorActivity.f(this.a);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/traffic/monitor/ui/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */