package com.lantern.launcher.task;

import com.lantern.core.c;
import com.lantern.wifitools.a.h;

final class d
  implements Runnable
{
  d(b paramb) {}
  
  public final void run()
  {
    if (h.a(c.getAppContext())) {}
    try
    {
      b.a(this.a, false);
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


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/launcher/task/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */