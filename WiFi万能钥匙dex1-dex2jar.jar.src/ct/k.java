package ct;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemClock;

final class k
{
  private static k c = null;
  private long a = -1L;
  private int b = -1;
  private o d;
  private BroadcastReceiver e = new l(this);
  private BroadcastReceiver f = new n(this);
  
  public static k a()
  {
    try
    {
      if (c == null)
      {
        localk = new ct/k;
        localk.<init>();
        c = localk;
      }
      k localk = c;
      return localk;
    }
    finally {}
  }
  
  public final void a(o paramo)
  {
    this.d = paramo;
    paramo = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    p.a().registerReceiver(this.e, paramo);
    bb.b("AccessSchedulerTrigger", "startListenNetworkChange...");
    bb.b("AccessSchedulerTrigger", "try startAccessSchedulerTimer...");
    paramo = new IntentFilter("action.scheduler.access.trigger.timer");
    p.a().registerReceiver(this.f, paramo);
    paramo = (AlarmManager)p.a().getSystemService("alarm");
    if (paramo != null)
    {
      long l = SystemClock.elapsedRealtime();
      Intent localIntent = new Intent("action.scheduler.access.trigger.timer");
      paramo.setRepeating(3, l + 1800000L, 1800000L, PendingIntent.getBroadcast(p.a(), 0, localIntent, 0));
      bb.a("AccessSchedulerTrigger", "startAccessSchedulerTimer timer start...");
    }
  }
  
  public final void b()
  {
    if (this.d != null) {
      this.d.b();
    }
    for (;;)
    {
      return;
      bb.c("AccessSchedulerTrigger", "onAccessSchedulerTriggered not call for triggerlistener is null");
    }
  }
  
  final class a
    implements Runnable
  {
    private a() {}
    
    public final void run()
    {
      try
      {
        k.this.b();
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  final class b
    implements Runnable
  {
    private Context a;
    
    b(Context paramContext)
    {
      this.a = paramContext;
    }
    
    public final void run()
    {
      for (;;)
      {
        try
        {
          bb.a("AccessSchedulerTrigger", "Network changed");
          localNetworkInfo = ((ConnectivityManager)this.a.getSystemService("connectivity")).getActiveNetworkInfo();
          if (localNetworkInfo == null)
          {
            k.a(k.this, -1);
            bb.a("AccessSchedulerTrigger", "no active network now");
            ba.a(false);
            return;
          }
        }
        catch (Exception localException)
        {
          NetworkInfo localNetworkInfo;
          localException.printStackTrace();
          continue;
          k.a(k.this, -1);
          bb.a("AccessSchedulerTrigger", "network not available or not connected");
          ba.a(false);
          continue;
        }
        if ((!localNetworkInfo.isAvailable()) || (!localNetworkInfo.isConnected())) {
          continue;
        }
        ba.b();
        ba.a(true);
        ba.f();
        if (localNetworkInfo.getType() != k.b(k.this))
        {
          bb.a("AccessSchedulerTrigger", "onAccessSchedulerTriggered by network change");
          k.this.b();
          k.a(k.this, SystemClock.elapsedRealtime());
        }
        k.a(k.this, localNetworkInfo.getType());
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */