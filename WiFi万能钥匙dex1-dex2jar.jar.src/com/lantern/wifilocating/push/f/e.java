package com.lantern.wifilocating.push.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.lantern.wifilocating.push.c;
import com.lantern.wifilocating.push.receiver.a;
import com.lantern.wifilocating.push.service.PushService;
import com.lantern.wifilocating.push.util.j;

public class e
{
  private static e a;
  private boolean b = false;
  private BroadcastReceiver c = new a();
  
  public static e a()
  {
    if (a == null) {}
    try
    {
      if (a == null)
      {
        e locale = new com/lantern/wifilocating/push/f/e;
        locale.<init>();
        a = locale;
      }
      return a;
    }
    finally {}
  }
  
  public final void a(Context paramContext)
  {
    c.a(paramContext);
    if (this.b)
    {
      Intent localIntent = new Intent(paramContext, PushService.class);
      localIntent.putExtra("PUSH_START_TYPE", "PUSH_START_TYPE_KEEP_ALIVE");
      j.a(paramContext, localIntent, 1);
    }
  }
  
  public final void a(Context paramContext, com.lantern.wifilocating.push.e parame)
  {
    c.a(paramContext);
    int i;
    if (!this.b) {
      i = 1;
    }
    for (;;)
    {
      this.b = true;
      Object localObject = new Intent(paramContext, PushService.class);
      ((Intent)localObject).putExtra("ikpo", j.a(parame));
      ((Intent)localObject).putExtra("PUSH_START_TYPE", "PUSH_START_TYPE_START");
      j.a(paramContext, (Intent)localObject, 1);
      if (i != 0)
      {
        parame = new IntentFilter();
        parame.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        parame.addAction("com.lantern.wifilocating.push.action.HEARTBEAT");
        parame.addAction("com.lantern.wifilocating.push.action.SYNC");
        parame.addAction("com.lantern.push.ACTION_D");
        localObject = this.c;
      }
      try
      {
        paramContext.unregisterReceiver((BroadcastReceiver)localObject);
        j.a(paramContext, this.c, parame);
        return;
        i = 0;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  public final void b(Context paramContext)
  {
    c.a(paramContext);
    if (this.b)
    {
      Intent localIntent = new Intent(paramContext, PushService.class);
      localIntent.putExtra("PUSH_START_TYPE", "PUSH_START_TYPE_TOGGLE_FOREGROUND");
      j.a(paramContext, localIntent, 1);
    }
  }
  
  public final boolean b()
  {
    return this.b;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/f/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */