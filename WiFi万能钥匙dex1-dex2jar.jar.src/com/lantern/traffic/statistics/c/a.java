package com.lantern.traffic.statistics.c;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.TrafficStats;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a
{
  public static a c;
  private static ConcurrentHashMap<String, com.lantern.traffic.statistics.b.c> g = new ConcurrentHashMap();
  public long a = 0L;
  public com.lantern.traffic.statistics.b.d b = com.lantern.traffic.statistics.b.d.c;
  private Handler d;
  private Runnable e;
  private long f = 0L;
  
  public static a a()
  {
    if (c == null) {
      c = new a();
    }
    return c;
  }
  
  public static void f()
  {
    Object localObject2 = com.lantern.traffic.statistics.a.a.a();
    Object localObject1;
    if ((localObject2 != null) && (!((Map)localObject2).isEmpty()))
    {
      localObject1 = new JSONArray();
      localObject2 = ((Map)localObject2).values().iterator();
      while (((Iterator)localObject2).hasNext()) {
        try
        {
          com.lantern.traffic.statistics.b.a locala = (com.lantern.traffic.statistics.b.a)((Iterator)localObject2).next();
          JSONObject localJSONObject = new org/json/JSONObject;
          localJSONObject.<init>();
          localJSONObject.put("pkg", locala.a());
          localJSONObject.put("st", String.valueOf(locala.h()));
          localJSONObject.put("et", String.valueOf(locala.i()));
          localJSONObject.put("swt", String.valueOf(locala.b()));
          localJSONObject.put("rwt", String.valueOf(locala.c()));
          localJSONObject.put("sct", String.valueOf(locala.d()));
          localJSONObject.put("rct", String.valueOf(locala.e()));
          localJSONObject.put("sut", String.valueOf(locala.f()));
          localJSONObject.put("rut", String.valueOf(locala.g()));
          ((JSONArray)localObject1).put(localJSONObject);
        }
        catch (Throwable localThrowable2) {}
      }
    }
    try
    {
      com.lantern.analytics.a.e().b("005010", (JSONArray)localObject1);
      localObject2 = com.lantern.traffic.statistics.a.c.a(com.lantern.core.c.getInstance()).getWritableDatabase();
      localObject1 = new android/content/ContentValues;
      ((ContentValues)localObject1).<init>();
      ((ContentValues)localObject1).put("is_report", Integer.valueOf(1));
      ((ContentValues)localObject1).put("report_time", Long.valueOf(System.currentTimeMillis()));
      ((SQLiteDatabase)localObject2).update("traffic_statistics_table", (ContentValues)localObject1, "is_report = ? ", new String[] { "0" });
      return;
    }
    catch (Throwable localThrowable1)
    {
      for (;;) {}
    }
  }
  
  public static void g() {}
  
  public final void a(Context paramContext)
  {
    AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
    Object localObject = new Intent("wifi.intent.action.TRAFFIC_STATISTICS_RECEIVER");
    ((Intent)localObject).setPackage(paramContext.getPackageName());
    paramContext = PendingIntent.getBroadcast(paramContext, 31299, (Intent)localObject, 134217728);
    localAlarmManager.cancel(paramContext);
    localObject = Calendar.getInstance();
    ((Calendar)localObject).add(10, 1);
    ((Calendar)localObject).set(12, 0);
    ((Calendar)localObject).set(13, 0);
    localAlarmManager.setRepeating(0, ((Calendar)localObject).getTimeInMillis(), 3600000L, paramContext);
    new f(this).start();
  }
  
  public final void b()
  {
    Object localObject = (ConnectivityManager)com.lantern.core.c.getInstance().getSystemService("connectivity");
    if (localObject != null)
    {
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if ((localObject != null) && (((NetworkInfo)localObject).isConnected()))
      {
        if (((NetworkInfo)localObject).getType() != 1) {
          break label59;
        }
        if (this.b != com.lantern.traffic.statistics.b.d.a) {
          this.b = com.lantern.traffic.statistics.b.d.a;
        }
      }
    }
    for (;;)
    {
      return;
      label59:
      if (this.b != com.lantern.traffic.statistics.b.d.b) {
        this.b = com.lantern.traffic.statistics.b.d.b;
      }
    }
  }
  
  public final Runnable c()
  {
    if (this.e == null) {
      this.e = new b(this);
    }
    return this.e;
  }
  
  public final void d()
  {
    int i = com.lantern.core.f.a().b("min_time");
    long l;
    if (i <= 0)
    {
      l = 300000L;
      if (SystemClock.elapsedRealtime() - this.f >= l) {
        break label38;
      }
    }
    for (;;)
    {
      return;
      l = i;
      break;
      label38:
      this.f = SystemClock.elapsedRealtime();
      NetworkInfo localNetworkInfo = ((ConnectivityManager)com.lantern.core.c.getInstance().getSystemService("connectivity")).getActiveNetworkInfo();
      if ((localNetworkInfo != null) && (localNetworkInfo.isConnected())) {
        new d(this).start();
      } else {
        new e(this).start();
      }
    }
  }
  
  public final Handler e()
  {
    if (this.d == null) {
      this.d = new Handler(Looper.getMainLooper());
    }
    return this.d;
  }
  
  public final void h()
  {
    Object localObject1;
    int i;
    if (SystemClock.elapsedRealtime() - this.a < 30000L)
    {
      localObject1 = ((ConnectivityManager)com.lantern.core.c.getInstance().getSystemService("connectivity")).getActiveNetworkInfo();
      if (localObject1 == null) {
        i = 1;
      }
      while (i != 0)
      {
        return;
        if ((localObject1 != null) && (((NetworkInfo)localObject1).isConnected()))
        {
          if ((((NetworkInfo)localObject1).getType() == 1) && (this.b == com.lantern.traffic.statistics.b.d.a))
          {
            i = 1;
            continue;
          }
          if ((((NetworkInfo)localObject1).getType() != 1) && (this.b == com.lantern.traffic.statistics.b.d.b))
          {
            i = 1;
            continue;
          }
        }
        i = 0;
      }
    }
    label150:
    label405:
    label410:
    label415:
    label531:
    label629:
    label840:
    label842:
    label856:
    label859:
    for (;;)
    {
      PackageInfo localPackageInfo;
      String str;
      long l2;
      long l1;
      try
      {
        PackageManager localPackageManager = com.lantern.core.c.getInstance().getPackageManager();
        localObject1 = localPackageManager.getInstalledPackages(0);
        if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
          break label842;
        }
        Iterator localIterator = ((List)localObject1).iterator();
        if (!localIterator.hasNext()) {
          break label842;
        }
        localPackageInfo = (PackageInfo)localIterator.next();
        if ((localPackageInfo.applicationInfo.flags & 0x1) != 0)
        {
          i = 1;
          if (i != 0) {
            continue;
          }
          if ((localPackageInfo.applicationInfo.flags & 0x80) == 0) {
            break label405;
          }
          i = 1;
          if ((i != 0) || (localPackageInfo.applicationInfo.uid < 10000)) {
            continue;
          }
          str = localPackageInfo.packageName;
          if (localPackageManager.checkPermission("android.permission.INTERNET", str) != 0) {
            break label410;
          }
          i = 1;
          if (i == 0) {
            continue;
          }
          l2 = TrafficStats.getUidRxBytes(localPackageInfo.applicationInfo.uid);
          l1 = TrafficStats.getUidTxBytes(localPackageInfo.applicationInfo.uid);
          if ((l2 != -1L) && (l1 != -1L) && (l2 >= 0L) && (l1 >= 0L)) {
            break label415;
          }
          localObject1 = null;
          if (localObject1 == null) {
            continue;
          }
          l2 = ((com.lantern.traffic.statistics.b.c)localObject1).g();
          l1 = ((com.lantern.traffic.statistics.b.c)localObject1).f();
          if ((l2 == 0L) && (l1 == 0L)) {
            continue;
          }
          localObject2 = (com.lantern.traffic.statistics.b.c)g.get(str);
          if (localObject2 != null) {
            break label856;
          }
          localObject2 = com.lantern.traffic.statistics.a.a.a(str);
          if (localObject2 != null) {
            break label531;
          }
          ((com.lantern.traffic.statistics.b.c)localObject1).a(com.lantern.traffic.statistics.a.a.a((com.lantern.traffic.statistics.b.c)localObject1));
          g.put(str, localObject1);
          continue;
        }
      }
      catch (Exception localException) {}
      i = 0;
      continue;
      i = 0;
      continue;
      i = 0;
      continue;
      com.lantern.traffic.statistics.b.c localc = new com/lantern/traffic/statistics/b/c;
      localc.<init>();
      Object localObject2 = Calendar.getInstance();
      localc.a(localPackageInfo.packageName);
      localc.a(com.lantern.traffic.statistics.b.b.a);
      localc.a(((Calendar)localObject2).get(1));
      localc.b(((Calendar)localObject2).get(2) + 1);
      localc.c(((Calendar)localObject2).get(5));
      localc.g(((Calendar)localObject2).getTimeInMillis());
      localc.e(l2);
      localc.d(l1);
      localc.c(l2);
      localc.b(l1);
      localc.a(this.b);
      continue;
      for (i = 1;; i = 0)
      {
        if (localObject2 == null) {
          break label859;
        }
        long l3 = ((com.lantern.traffic.statistics.b.c)localObject2).g();
        long l4 = ((com.lantern.traffic.statistics.b.c)localObject2).f();
        if (((com.lantern.traffic.statistics.b.c)localObject2).i() == com.lantern.traffic.statistics.b.b.b)
        {
          if ((l2 >= l3) && (l1 >= l4))
          {
            if ((l2 != l3) || (l1 != l4)) {
              break label629;
            }
            localc.c(0L);
            localc.b(0L);
          }
          for (;;)
          {
            localc.a(com.lantern.traffic.statistics.a.a.a(localc));
            g.put(str, localc);
            break;
            localc.c(l2 - l3);
            localc.b(l1 - l4);
          }
        }
        if ((l2 < l3) || (l1 < l4))
        {
          localc.a(com.lantern.traffic.statistics.a.a.a(localc));
          g.put(str, localc);
          ((com.lantern.traffic.statistics.b.c)localObject2).a(com.lantern.traffic.statistics.b.b.b);
          com.lantern.traffic.statistics.a.a.b((com.lantern.traffic.statistics.b.c)localObject2);
          break label150;
        }
        if ((l2 == l3) && (l1 == l4))
        {
          if (i == 0) {
            break label150;
          }
          g.put(str, localObject2);
          break label150;
        }
        localc.c(l2 - l3);
        localc.b(l1 - l4);
        localc.a(com.lantern.traffic.statistics.a.a.a(localc));
        g.put(str, localc);
        if ((localc.j() == ((com.lantern.traffic.statistics.b.c)localObject2).j()) && (localc.k() == ((com.lantern.traffic.statistics.b.c)localObject2).k()) && (localc.l() == ((com.lantern.traffic.statistics.b.c)localObject2).l())) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label840;
          }
          ((com.lantern.traffic.statistics.b.c)localObject2).a(com.lantern.traffic.statistics.b.b.b);
          com.lantern.traffic.statistics.a.a.b((com.lantern.traffic.statistics.b.c)localObject2);
          break;
        }
        break label150;
        this.a = SystemClock.elapsedRealtime();
        b();
        break;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/traffic/statistics/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */