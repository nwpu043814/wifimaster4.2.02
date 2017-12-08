package com.lantern.traffic.monitor.d;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ContentValues;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.widget.RemoteViews;
import com.bluefay.b.h;
import com.lantern.core.config.TrafficMonitorConfig;
import com.lantern.core.config.TrafficMonitorConfig.MonApp;
import com.lantern.core.config.d;
import com.lantern.core.p;
import com.lantern.settings.R.drawable;
import com.lantern.settings.R.id;
import com.lantern.settings.R.layout;
import com.lantern.traffic.monitor.ui.TrafficMonitorActivity;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class a
  extends Service
{
  public static NotificationManager a = null;
  private static final String c = a.class.getSimpleName();
  private static final SimpleDateFormat d = new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault());
  TrafficMonitorConfig b;
  private a e = new a();
  private List<com.lantern.traffic.monitor.c.a> f = null;
  private com.lantern.traffic.monitor.b.a g;
  private ConnectivityManager h;
  private HandlerThread i = null;
  private Handler j;
  private boolean k = false;
  private boolean l = false;
  private Runnable m = new b(this);
  
  private void a(String paramString1, String paramString2)
  {
    h.a("initNotification", new Object[] { paramString1 });
    Notification localNotification = new Notification(R.drawable.traffic_notification_title, paramString1, System.currentTimeMillis());
    localNotification.contentView = new RemoteViews(getPackageName(), R.layout.traffic_notification_monitor);
    localNotification.contentView.setTextViewText(R.id.act_traffic_app_name_tv, paramString1);
    paramString1 = new Intent(this, TrafficMonitorActivity.class);
    localNotification.flags |= 0x10;
    localNotification.contentIntent = PendingIntent.getActivity(this, 0, paramString1, 268435456);
    paramString1 = (NotificationManager)getSystemService("notification");
    a = paramString1;
    paramString1.notify(18, localNotification);
    com.lantern.analytics.a.e().onEvent("m701_" + paramString2);
  }
  
  private String[] a(int paramInt)
  {
    String[] arrayOfString = new String[2];
    Object localObject1 = "0";
    Object localObject2 = "0";
    Object localObject3 = new File("/proc/uid_stat/").list();
    if ((localObject3 != null) && (!Arrays.asList((Object[])localObject3).contains(String.valueOf(paramInt))))
    {
      arrayOfString[0] = "0";
      arrayOfString[1] = "0";
    }
    for (;;)
    {
      return arrayOfString;
      localObject3 = new File("/proc/uid_stat/" + String.valueOf(paramInt));
      Object localObject6 = new File((File)localObject3, "tcp_rcv");
      Object localObject5 = new File((File)localObject3, "tcp_snd");
      Object localObject4 = localObject2;
      localObject3 = localObject1;
      try
      {
        BufferedReader localBufferedReader = new java/io/BufferedReader;
        localObject4 = localObject2;
        localObject3 = localObject1;
        FileReader localFileReader = new java/io/FileReader;
        localObject4 = localObject2;
        localObject3 = localObject1;
        localFileReader.<init>((File)localObject6);
        localObject4 = localObject2;
        localObject3 = localObject1;
        localBufferedReader.<init>(localFileReader);
        localObject4 = localObject2;
        localObject3 = localObject1;
        localObject6 = new java/io/BufferedReader;
        localObject4 = localObject2;
        localObject3 = localObject1;
        localFileReader = new java/io/FileReader;
        localObject4 = localObject2;
        localObject3 = localObject1;
        localFileReader.<init>((File)localObject5);
        localObject4 = localObject2;
        localObject3 = localObject1;
        ((BufferedReader)localObject6).<init>(localFileReader);
        localObject4 = localObject2;
        localObject3 = localObject1;
        localObject5 = localBufferedReader.readLine();
        if (localObject5 != null) {
          localObject1 = localObject5;
        }
        localObject4 = localObject2;
        localObject3 = localObject1;
        localObject5 = ((BufferedReader)localObject6).readLine();
        if (localObject5 != null) {
          localObject2 = localObject5;
        }
        arrayOfString[0] = localObject1;
        arrayOfString[1] = localObject2;
      }
      catch (IOException localIOException)
      {
        arrayOfString[0] = localObject3;
        arrayOfString[1] = localObject4;
        this.k = false;
      }
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    h.a("onBind", new Object[0]);
    return this.e;
  }
  
  public void onCreate()
  {
    super.onCreate();
    h.a("onCreate", new Object[0]);
    this.g = com.lantern.traffic.monitor.b.a.a(this);
    this.h = ((ConnectivityManager)getSystemService("connectivity"));
    if (Build.VERSION.RELEASE.equals("4.3")) {
      this.k = true;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    h.a("onDestroy", new Object[0]);
    if (this.i != null)
    {
      this.i.quit();
      this.i = null;
    }
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    super.onStart(paramIntent, paramInt);
    this.b = ((TrafficMonitorConfig)d.a(this).a(TrafficMonitorConfig.class));
    if ((this.i == null) && (this.b != null) && (this.b.d() != null) && (this.b.d().size() > 0))
    {
      long l1 = this.b.b();
      if (p.a("traconfig", 0L) < l1)
      {
        paramIntent = this.b.d();
        p.b("traconfig", l1);
        this.g.a();
        if (a != null) {
          a.cancel(18);
        }
        paramIntent = paramIntent.iterator();
        while (paramIntent.hasNext())
        {
          TrafficMonitorConfig.MonApp localMonApp = (TrafficMonitorConfig.MonApp)paramIntent.next();
          try
          {
            String str = com.lantern.traffic.monitor.a.b.a().a(localMonApp.getPkgName()).trim();
            if (!str.equals("com.snda.wifilocating"))
            {
              ContentValues localContentValues = new android/content/ContentValues;
              localContentValues.<init>();
              localContentValues.put("PACKAGENAME", str);
              localContentValues.put("STATTIME", Long.valueOf(d.parse(localMonApp.getStartTime()).getTime() / 1000L));
              localContentValues.put("ENDTIME", Long.valueOf(d.parse(localMonApp.getEndTime()).getTime() / 1000L));
              localContentValues.put("SNOTETR", Long.valueOf(localMonApp.getMinTraffic()));
              localContentValues.put("APPNAME", "");
              localContentValues.put("WARNTIMES", Integer.valueOf(localMonApp.getWarnTimes()));
              localContentValues.put("FREQUENCY", Long.valueOf(localMonApp.getInterval()));
              localContentValues.put("SHOWTIMES", Integer.valueOf(0));
              localContentValues.put("CNOTETR", Integer.valueOf(0));
              localContentValues.put("NOTETIME", Long.valueOf(d.parse(localMonApp.getStartTime()).getTime() / 1000L));
              localContentValues.put("NOTETTYPE", Integer.valueOf(0));
              localContentValues.put("USETIME", Integer.valueOf(0));
              this.g.a(localContentValues);
            }
          }
          catch (Exception localException) {}
        }
      }
      this.i = new HandlerThread("TrafficThread", 10);
      this.i.start();
      this.j = new Handler(this.i.getLooper());
      this.j.postDelayed(this.m, 60000L);
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if ((this.j != null) && (paramIntent != null) && (paramIntent.getAction() != null) && ((paramIntent.getAction().equals("android.intent.action.BOOT_COMPLETED")) || (paramIntent.getAction().equals("android.intent.action.ACTION_SHUTDOWN")))) {
      this.g.a(1);
    }
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    h.a("onUnbind", new Object[0]);
    return super.onUnbind(paramIntent);
  }
  
  public final class a
    extends Binder
  {
    public a() {}
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/traffic/monitor/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */