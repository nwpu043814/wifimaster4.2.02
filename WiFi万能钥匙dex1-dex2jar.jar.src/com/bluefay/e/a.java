package com.bluefay.e;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Message;
import com.bluefay.b.h;
import java.lang.reflect.Field;

public class a
  extends Service
{
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public void onCreate()
  {
    super.onCreate();
    h.a("MsgService onCreate");
    int i;
    if (Build.VERSION.SDK_INT >= 18) {
      i = 1;
    }
    for (;;)
    {
      Notification localNotification;
      if (i == 0) {
        localNotification = new Notification();
      }
      try
      {
        localNotification.getClass().getField("priority").setInt(localNotification, -2);
        localNotification.flags = 64;
        startForeground(32769, localNotification);
        return;
        i = 0;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          h.c(localException.toString());
        }
      }
    }
  }
  
  public void onDestroy()
  {
    h.a("MsgService onDestroy");
    super.onDestroy();
  }
  
  public void onLowMemory()
  {
    h.a("MsgService onLowMemory");
    super.onLowMemory();
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    h.b("intent:%s,flags:%d,startId:%d", new Object[] { paramIntent, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    Message localMessage;
    if (paramIntent != null)
    {
      localMessage = (Message)paramIntent.getParcelableExtra("msg");
      if (localMessage != null)
      {
        if (!paramIntent.getBooleanExtra("thread", false)) {
          break label64;
        }
        com.bluefay.d.a.dispatchThreadMessage(localMessage);
      }
    }
    for (;;)
    {
      return 1;
      label64:
      com.bluefay.d.a.dispatch(localMessage);
    }
  }
  
  public void onTrimMemory(int paramInt)
  {
    h.a("MsgService onTrimMemory level:" + paramInt);
    super.onTrimMemory(paramInt);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */