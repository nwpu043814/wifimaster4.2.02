package com.lantern.dm.task;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

public final class f
  implements i
{
  private Context a;
  private NotificationManager b;
  
  public f(Context paramContext)
  {
    this.a = paramContext;
    this.b = ((NotificationManager)this.a.getSystemService("notification"));
  }
  
  public final long a()
  {
    return System.currentTimeMillis();
  }
  
  public final void a(long paramLong)
  {
    this.b.cancel((int)paramLong);
  }
  
  public final void a(Notification paramNotification)
  {
    this.b.notify(-2004318072, paramNotification);
  }
  
  public final void a(Intent paramIntent)
  {
    this.a.sendBroadcast(paramIntent);
  }
  
  public final void a(Thread paramThread)
  {
    paramThread.start();
  }
  
  public final boolean a(int paramInt, String paramString)
  {
    boolean bool = false;
    if (this.a.getPackageManager().getApplicationInfo(paramString, 0).uid == paramInt) {
      bool = true;
    }
    return bool;
  }
  
  public final Integer b()
  {
    Object localObject = (ConnectivityManager)this.a.getSystemService("connectivity");
    if (localObject == null) {
      localObject = null;
    }
    for (;;)
    {
      return (Integer)localObject;
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = Integer.valueOf(((NetworkInfo)localObject).getType());
      }
    }
  }
  
  public final boolean c()
  {
    boolean bool2 = false;
    Object localObject = (ConnectivityManager)this.a.getSystemService("connectivity");
    boolean bool1;
    if (localObject == null)
    {
      bool1 = bool2;
      return bool1;
    }
    localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    if ((localObject != null) && (((NetworkInfo)localObject).getType() == 0)) {}
    for (int i = 1;; i = 0)
    {
      localObject = (TelephonyManager)this.a.getSystemService("phone");
      bool1 = bool2;
      if (i == 0) {
        break;
      }
      bool1 = bool2;
      if (!((TelephonyManager)localObject).isNetworkRoaming()) {
        break;
      }
      bool1 = true;
      break;
    }
  }
  
  public final Long d()
  {
    return Long.valueOf(2147483648L);
  }
  
  public final Long e()
  {
    return Long.valueOf(1073741824L);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/dm/task/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */