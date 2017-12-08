package com.lantern.launcher.ui;

import android.app.Application;
import android.net.ConnectivityManager;
import com.bluefay.b.h;
import java.lang.reflect.Method;

final class i
  extends Thread
{
  i(MainActivityICS paramMainActivityICS) {}
  
  public final void run()
  {
    for (;;)
    {
      try
      {
        localConnectivityManager = (ConnectivityManager)this.a.getApplication().getSystemService("connectivity");
        localMethod = ConnectivityManager.class.getDeclaredMethod("setMobileDataEnabled", new Class[] { Boolean.TYPE });
        if (localMethod == null)
        {
          h.a("not found method setMobileDataEnabled");
          return;
        }
      }
      catch (Exception localException)
      {
        ConnectivityManager localConnectivityManager;
        Method localMethod;
        h.c("close mobile network failed!", new Object[] { localException.getMessage() });
        continue;
      }
      localMethod.invoke(localConnectivityManager, new Object[] { Boolean.valueOf(false) });
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/launcher/ui/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */