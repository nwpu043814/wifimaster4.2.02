package com.lantern.wifilocating.push.f;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.lantern.wifilocating.push.util.e;
import com.lantern.wifilocating.push.util.j;
import com.lantern.wifilocating.push.util.m;

public class f
{
  private static f a;
  private com.lantern.wifilocating.push.f.a.c b;
  private boolean c;
  private boolean d;
  private boolean e = true;
  private String f;
  private String g;
  private String h;
  private c i;
  private HandlerThread j = new HandlerThread("push_handler_thread");
  private com.lantern.wifilocating.push.f.a.b k = new com.lantern.wifilocating.push.f.a.b();
  private com.lantern.wifilocating.push.h.c l;
  private com.lantern.wifilocating.push.h.c m;
  private BroadcastReceiver n = new g(this);
  
  private f()
  {
    this.j.start();
    Object localObject2 = this.j.getLooper();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = Looper.getMainLooper();
    }
    this.i = new c((Looper)localObject1);
    this.l = new com.lantern.wifilocating.push.h.c();
    this.m = new com.lantern.wifilocating.push.h.c();
    this.b = new h(this);
    c(this.b);
    localObject1 = new IntentFilter();
    ((IntentFilter)localObject1).addAction("android.net.conn.CONNECTIVITY_CHANGE");
    ((IntentFilter)localObject1).addAction("android.intent.action.ACTION_POWER_CONNECTED");
    ((IntentFilter)localObject1).addAction("com.lantern.push.ACTION_D");
    ((IntentFilter)localObject1).addAction("android.intent.action.SCREEN_ON");
    d();
    ((IntentFilter)localObject1).addAction("com.lantern.wifilocating.push.action.SYNC");
    e();
    ((IntentFilter)localObject1).addAction("com.lantern.wifilocating.push.action.HEARTBEAT");
    localObject2 = com.lantern.wifilocating.push.c.a();
    BroadcastReceiver localBroadcastReceiver = this.n;
    try
    {
      ((Context)localObject2).unregisterReceiver(localBroadcastReceiver);
      if (((IntentFilter)localObject1).countActions() > 0) {
        j.a(com.lantern.wifilocating.push.c.a(), this.n, (IntentFilter)localObject1);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public static f a()
  {
    if (a == null) {}
    try
    {
      if (a == null)
      {
        f localf = new com/lantern/wifilocating/push/f/f;
        localf.<init>();
        a = localf;
      }
      return a;
    }
    finally {}
  }
  
  private void a(int paramInt)
  {
    this.i.removeMessages(1);
    Message localMessage = this.i.obtainMessage(1);
    localMessage.arg1 = paramInt;
    localMessage.sendToTarget();
  }
  
  public static void a(com.lantern.wifilocating.push.f.a.a parama)
  {
    a().b(parama);
  }
  
  public static void a(com.lantern.wifilocating.push.f.a.c paramc)
  {
    a().c(paramc);
  }
  
  private boolean a(String paramString, Intent paramIntent)
  {
    boolean bool = true;
    if (this.c) {
      return bool;
    }
    this.c = true;
    if (("PUSH_START_TYPE_OTHER".equals(paramString)) || ("PUSH_START_TYPE_SYSTEM_AUTO_RESTART_START".equals(paramString)) || ("PUSH_START_TYPE_KEEP_ALIVE".equals(paramString)) || ("PUSH_START_TYPE_TOGGLE_FOREGROUND".equals(paramString)) || ("PUSH_START_TYPE_NOTIFICATION_DISPATCH".equals(paramString)))
    {
      paramString = j.d(com.lantern.wifilocating.push.util.i.c(com.lantern.wifilocating.push.c.a()));
      if (paramString == null) {
        bool = false;
      }
    }
    else
    {
      for (;;)
      {
        if (bool)
        {
          com.lantern.wifilocating.push.e.a.a().b();
          a(1);
          f();
          label105:
          break;
          if ("PUSH_START_TYPE_START".equals(paramString))
          {
            paramString = paramIntent.getExtras();
            if ((paramString == null) || (!paramString.containsKey("ikpo")))
            {
              bool = false;
              continue;
            }
            paramString = j.d(paramIntent.getStringExtra("ikpo"));
          }
        }
      }
    }
    for (int i1 = 1;; i1 = 0)
    {
      if (paramString == null)
      {
        bool = false;
        break;
        bool = false;
        break;
      }
      if (paramString == null)
      {
        paramIntent = null;
        label178:
        if ((paramIntent == null) || (TextUtils.isEmpty(paramIntent.a)) || (TextUtils.isEmpty(paramIntent.g)) || (TextUtils.isEmpty(paramIntent.f)) || (TextUtils.isEmpty(paramIntent.h))) {
          break label346;
        }
      }
      label346:
      for (int i2 = 1;; i2 = 0)
      {
        if (i2 != 0) {
          break label352;
        }
        bool = false;
        break;
        paramIntent = new com.lantern.wifilocating.push.d.f();
        paramIntent.a = paramString.a();
        paramIntent.f = paramString.d();
        paramIntent.g = paramString.e();
        paramIntent.h = paramString.f();
        paramIntent.b = paramString.g();
        paramIntent.c = paramString.h();
        paramIntent.d = paramString.b();
        if (TextUtils.isEmpty(paramIntent.d)) {
          paramIntent.d = "default";
        }
        paramIntent.e = paramString.c();
        if (TextUtils.isEmpty(paramIntent.e)) {
          paramIntent.e = paramIntent.d;
        }
        break label178;
      }
      label352:
      Object localObject;
      if (TextUtils.isEmpty(paramIntent.b))
      {
        localObject = e.b(com.lantern.wifilocating.push.c.a(), paramIntent.a);
        paramIntent.b = ((String)localObject);
        paramString.g((String)localObject);
        i1 = 1;
      }
      if (TextUtils.isEmpty(paramIntent.b))
      {
        bool = false;
        break;
      }
      e.a(com.lantern.wifilocating.push.c.a(), paramIntent.b);
      paramIntent.i = String.valueOf(j.i(com.lantern.wifilocating.push.c.a()));
      paramIntent.j = j.h(com.lantern.wifilocating.push.c.a());
      paramIntent.k = this.f;
      paramIntent.l = this.g;
      paramIntent.m = this.h;
      if (i1 != 0)
      {
        localObject = com.lantern.wifilocating.push.c.a();
        if (paramString != null)
        {
          paramString = j.a(paramString);
          if (!TextUtils.isEmpty(paramString)) {
            com.lantern.wifilocating.push.util.i.c((Context)localObject, paramString);
          }
        }
      }
      com.lantern.wifilocating.push.util.d.a().a(paramIntent);
      bool = true;
      break;
      this.c = false;
      break label105;
    }
  }
  
  private void b(com.lantern.wifilocating.push.f.a.a parama)
  {
    this.i.post(new i(this, parama));
  }
  
  public static void b(com.lantern.wifilocating.push.f.a.c paramc)
  {
    a().k.b(paramc);
  }
  
  private void c(com.lantern.wifilocating.push.f.a.c paramc)
  {
    this.k.a(paramc);
  }
  
  private static void d()
  {
    Object localObject = new Intent("com.lantern.wifilocating.push.action.SYNC");
    ((Intent)localObject).setPackage(com.lantern.wifilocating.push.c.a().getPackageName());
    AlarmManager localAlarmManager = (AlarmManager)com.lantern.wifilocating.push.c.a().getSystemService("alarm");
    localObject = PendingIntent.getBroadcast(com.lantern.wifilocating.push.c.a(), 65793, (Intent)localObject, 134217728);
    localAlarmManager.cancel((PendingIntent)localObject);
    com.lantern.wifilocating.push.c.d locald = (com.lantern.wifilocating.push.c.d)com.lantern.wifilocating.push.c.b.a.a().a(com.lantern.wifilocating.push.c.d.class);
    if (locald.f())
    {
      long l1 = locald.g();
      m.a(localAlarmManager, SystemClock.elapsedRealtime() + l1, (PendingIntent)localObject);
      com.lantern.wifilocating.push.util.b.a("init sync timer~" + l1);
    }
  }
  
  private static void e()
  {
    Object localObject = new Intent("com.lantern.wifilocating.push.action.HEARTBEAT");
    ((Intent)localObject).setPackage(com.lantern.wifilocating.push.c.a().getPackageName());
    AlarmManager localAlarmManager = (AlarmManager)com.lantern.wifilocating.push.c.a().getSystemService("alarm");
    localObject = PendingIntent.getBroadcast(com.lantern.wifilocating.push.c.a(), 65824, (Intent)localObject, 134217728);
    localAlarmManager.cancel((PendingIntent)localObject);
    long l1 = ((com.lantern.wifilocating.push.c.a)com.lantern.wifilocating.push.c.b.a.a().a(com.lantern.wifilocating.push.c.a.class)).a();
    m.a(localAlarmManager, SystemClock.elapsedRealtime() + l1, (PendingIntent)localObject);
    com.lantern.wifilocating.push.util.b.a("init heartbeat timer~" + l1);
  }
  
  private void f()
  {
    this.i.removeMessages(3);
    this.i.obtainMessage(3).sendToTarget();
  }
  
  public final void a(Runnable paramRunnable)
  {
    if (this.i != null) {
      this.i.post(paramRunnable);
    }
  }
  
  public final boolean a(Intent paramIntent)
  {
    boolean bool = true;
    if (paramIntent == null) {
      bool = a("PUSH_START_TYPE_SYSTEM_AUTO_RESTART_START", paramIntent);
    }
    for (;;)
    {
      if ((bool) && (this.e))
      {
        this.e = false;
        com.lantern.wifilocating.push.a.a.c().a(false);
      }
      return bool;
      String str = paramIntent.getStringExtra("PUSH_START_TYPE");
      if ("PUSH_START_TYPE_START".equals(str))
      {
        bool = a(str, paramIntent);
      }
      else if ("PUSH_START_TYPE_KEEP_ALIVE".equals(str))
      {
        bool = a(str, paramIntent);
      }
      else if ("PUSH_START_TYPE_TOGGLE_FOREGROUND".equals(str))
      {
        bool = a(str, paramIntent);
        if (bool) {
          if (((com.lantern.wifilocating.push.c.d)com.lantern.wifilocating.push.c.b.a.a().a(com.lantern.wifilocating.push.c.d.class)).c()) {
            a(7);
          }
        }
      }
      else if ("PUSH_START_TYPE_NOTIFICATION_DISPATCH".equals(str))
      {
        bool = a(str, paramIntent);
        com.lantern.wifilocating.push.i.a.a(paramIntent);
      }
      else
      {
        a("PUSH_START_TYPE_OTHER", null);
      }
    }
  }
  
  public final c b()
  {
    return this.i;
  }
  
  public final void c()
  {
    this.i.removeMessages(4);
    this.i.obtainMessage(4).sendToTarget();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/f/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */