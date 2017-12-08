package com.lantern.core.e;

import android.text.TextUtils;
import com.bluefay.b.h;
import com.lantern.core.c;
import com.lantern.core.config.d;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public final class a
{
  private static ScheduledThreadPoolExecutor a;
  private static String b = "udp-dc.51y5.net";
  private static int c = 58089;
  private static long d = 60000L;
  
  public static void a()
  {
    h.a("startHeartBeat", new Object[0]);
    JSONObject localJSONObject = d.a(c.getAppContext()).a("heartbeat");
    if (localJSONObject != null)
    {
      String str = localJSONObject.optString("server");
      b = str;
      if (TextUtils.isEmpty(str)) {
        b = "udp-dc.51y5.net";
      }
      int i = localJSONObject.optInt("port");
      c = i;
      if (i <= 0) {
        c = 58089;
      }
      long l = localJSONObject.optLong("interval");
      d = l;
      if (l <= 0L) {
        d = 60000L;
      }
    }
    b();
    h.a("scheduleHeartBeat", new Object[0]);
    if ((a == null) || (a.isShutdown())) {
      a = new ScheduledThreadPoolExecutor(3);
    }
    a.scheduleAtFixedRate(new b(), d, d, TimeUnit.MILLISECONDS);
  }
  
  public static void b()
  {
    h.a("stopHeartBeat", new Object[0]);
    if ((a != null) && (!a.isShutdown())) {
      a.shutdown();
    }
    a = null;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */