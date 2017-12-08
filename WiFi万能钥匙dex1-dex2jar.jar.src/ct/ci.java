package ct;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.List;

final class ci
  extends BroadcastReceiver
{
  private volatile boolean a;
  private final bi b;
  private final WifiManager c;
  private long d;
  private long e;
  private int f;
  private boolean g;
  private final Handler h;
  private final bt i;
  private final bt j;
  private final Runnable k;
  
  public ci(bi parambi)
  {
    this.b = parambi;
    this.c = parambi.b();
    this.i = new bt();
    this.j = new bt();
    this.h = new Handler(Looper.getMainLooper());
    this.k = new ci.1(this);
  }
  
  private void a(long paramLong)
  {
    Handler localHandler = this.h;
    Runnable localRunnable = this.k;
    localHandler.removeCallbacks(localRunnable);
    localHandler.postDelayed(localRunnable, paramLong);
  }
  
  private boolean c()
  {
    boolean bool1;
    if (!dh.b(this.b)) {
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      boolean bool2 = dh.a(this.c);
      bool1 = bool2;
      if (bool2)
      {
        this.e = System.currentTimeMillis();
        bool1 = bool2;
      }
    }
  }
  
  private void d()
  {
    Object localObject = this.i.a(this.j).a();
    long l = this.d;
    this.c.getWifiState();
    localObject = new co((List)localObject, l);
    this.b.c(localObject);
    if (dh.a) {
      e();
    }
  }
  
  private void e()
  {
    int m = 1;
    int n = this.c.getWifiState();
    if (n == 3) {
      a(0L);
    }
    for (;;)
    {
      Message localMessage = new Message();
      localMessage.what = 12999;
      localMessage.arg1 = 12001;
      localMessage.arg2 = m;
      this.b.c(localMessage);
      return;
      if (n == 1)
      {
        m = 0;
        this.i.b();
        this.j.b();
        this.b.c(co.a);
      }
      else
      {
        m = -1;
      }
    }
  }
  
  public final void a()
  {
    if (!this.a) {}
    for (;;)
    {
      return;
      this.a = false;
      this.h.removeCallbacks(this.k);
      try
      {
        this.b.a.unregisterReceiver(this);
        this.i.b();
        this.j.b();
        this.f = 0;
        this.e = 0L;
        this.d = 0L;
        b.a.a("TxWifiProvider", "shutdown: state=[shutdown]");
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  public final void a(Handler paramHandler)
  {
    if (this.a) {}
    for (;;)
    {
      return;
      this.a = true;
      this.g = false;
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
      localIntentFilter.addAction("android.net.wifi.SCAN_RESULTS");
      try
      {
        this.b.a.registerReceiver(this, localIntentFilter, null, paramHandler);
        a(0L);
        b.a.a("TxWifiProvider", "startup: state=[start]");
      }
      catch (Exception paramHandler)
      {
        for (;;)
        {
          b.a.a("TxWifiProvider", "listenWifiState: failed", paramHandler);
        }
      }
    }
  }
  
  public final int b()
  {
    if (c()) {}
    for (int m = 0;; m = 1) {
      return m;
    }
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    int i1 = 0;
    if (paramIntent == null) {}
    do
    {
      return;
      paramContext = paramIntent.getAction();
      b.a.a("TxWifiProvider", "onReceive " + paramContext);
      if ("android.net.wifi.WIFI_STATE_CHANGED".equals(paramContext)) {
        e();
      }
    } while ((!"android.net.wifi.WIFI_STATE_CHANGED".equals(paramContext)) && (!"android.net.wifi.SCAN_RESULTS".equals(paramContext)));
    paramContext = cj.a(dh.b(this.c));
    this.d = System.currentTimeMillis();
    int m;
    label155:
    int n;
    if (this.f == 0)
    {
      this.j.b();
      this.i.b();
      paramIntent = this.i;
      paramIntent.b();
      paramIntent.a(this.e);
      paramIntent.b(this.d);
      paramIntent.a(paramContext);
      m = i1;
      if (this.g)
      {
        if (paramIntent.c() >= 7) {
          break label210;
        }
        m = 1;
        if ((m == 0) || (!c())) {
          break label215;
        }
        n = 1;
        label169:
        m = i1;
        if (n != 0) {
          m = 1;
        }
      }
      if (m != 0) {
        this.f = 1;
      }
    }
    for (;;)
    {
      this.g = true;
      a(this.b.h().m);
      break;
      label210:
      m = 0;
      break label155;
      label215:
      n = 0;
      break label169;
      d();
      continue;
      this.f = 0;
      paramIntent = this.j;
      paramIntent.b();
      paramIntent.a(this.e);
      paramIntent.b(this.d);
      paramIntent.a(paramContext);
      d();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/ci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */