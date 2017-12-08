package com.lantern.notification;

import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import com.bluefay.b.h;
import com.bluefay.d.a;
import com.qihoo.util.StubApp1053578832;

public class NotificationMonitor
  extends NotificationListenerService
{
  static
  {
    StubApp1053578832.interface11(35);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    h.a("OK");
    return super.onBind(paramIntent);
  }
  
  public void onCreate()
  {
    super.onCreate();
    h.a("OK");
  }
  
  public void onNotificationPosted(StatusBarNotification paramStatusBarNotification)
  {
    h.a("post:" + paramStatusBarNotification, new Object[0]);
    paramStatusBarNotification = Message.obtain();
    paramStatusBarNotification.what = 128901;
    a.dispatch(paramStatusBarNotification);
  }
  
  public void onNotificationRemoved(StatusBarNotification paramStatusBarNotification)
  {
    h.a("remove:" + paramStatusBarNotification, new Object[0]);
    paramStatusBarNotification = Message.obtain();
    paramStatusBarNotification.what = 128902;
    a.dispatch(paramStatusBarNotification);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/notification/NotificationMonitor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */