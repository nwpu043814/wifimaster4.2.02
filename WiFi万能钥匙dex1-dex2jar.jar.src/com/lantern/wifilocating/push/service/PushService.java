package com.lantern.wifilocating.push.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import com.lantern.wifilocating.push.f.a.a.a;
import com.lantern.wifilocating.push.f.f;
import com.lantern.wifilocating.push.util.b;
import com.qihoo.util.StubApp1053578832;

public class PushService
  extends Service
{
  private static Context a;
  
  static
  {
    StubApp1053578832.interface11(64);
  }
  
  public static Context a()
  {
    return a;
  }
  
  private static void c()
  {
    f.a(new com.lantern.wifilocating.push.f.a.a(a.a.i));
    Process.killProcess(Process.myPid());
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    a = getApplicationContext();
    super.onCreate();
    b.c("PushService onCreate……");
    com.lantern.wifilocating.push.a.a.a(a);
    com.lantern.wifilocating.push.g.a.a.a().b();
    f.a(new a(this));
  }
  
  public void onDestroy()
  {
    f.a(new com.lantern.wifilocating.push.f.a.a(a.a.i));
    b.c("Push Service onDestroy");
    super.onDestroy();
    c();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (f.a().a(paramIntent))
    {
      com.lantern.wifilocating.push.g.b.a.a();
      com.lantern.wifilocating.push.c.b.a.a();
    }
    for (paramInt1 = 1;; paramInt1 = super.onStartCommand(paramIntent, paramInt1, paramInt2))
    {
      return paramInt1;
      c();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/service/PushService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */