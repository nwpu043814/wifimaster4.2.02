package com.wifi.connect.b;

import android.app.NotificationManager;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.text.TextUtils;
import android.view.WindowManager;
import com.bluefay.b.h;
import com.bluefay.d.b;
import com.lantern.core.c;
import com.lantern.core.config.d;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public final class al
{
  private Context a;
  private final int b = 100;
  private final int c = 101;
  private final int d = 102;
  private WifiManager e;
  private NotificationManager f = null;
  private int g = 593;
  private AtomicInteger h = null;
  private WindowManager i;
  private String j;
  private int[] k = { 128200, 128205, 128005, 128001, 128001, 128030, 128100, 128204 };
  private b l = new am(this, this.k);
  private int m = 0;
  private Handler n = new an(this);
  
  public al(Context paramContext)
  {
    this.a = paramContext;
    c.getInstance();
    c.addListener(this.l);
    this.e = ((WifiManager)paramContext.getSystemService("wifi"));
    this.f = ((NotificationManager)this.a.getSystemService("notification"));
    this.i = ((WindowManager)this.a.getSystemService("window"));
  }
  
  private int b()
  {
    i2 = 60;
    for (;;)
    {
      try
      {
        localObject = d.a(this.a).a("nearbyappop");
        if (localObject == null) {
          continue;
        }
        localObject = ((JSONObject)localObject).optString("rt");
        i1 = i2;
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          i1 = Integer.parseInt((String)localObject);
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        h.a(localException);
        int i1 = i2;
        continue;
      }
      i2 = i1;
      if (i1 < 30) {
        i2 = 30;
      }
      return i2;
      localObject = null;
    }
  }
  
  private void c()
  {
    if (this.f != null)
    {
      h.a("nearby removeNotify", new Object[0]);
      this.f.cancel(this.g);
      this.m = 0;
      this.n.removeCallbacksAndMessages(null);
    }
  }
  
  public final void a()
  {
    c();
    c.getInstance();
    c.removeListener(this.l);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/b/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */