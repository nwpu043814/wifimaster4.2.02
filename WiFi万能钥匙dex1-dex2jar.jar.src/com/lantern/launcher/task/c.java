package com.lantern.launcher.task;

import android.text.TextUtils;
import com.bluefay.b.h;

final class c
  implements Runnable
{
  c(b paramb) {}
  
  public final void run()
  {
    try
    {
      if (TextUtils.isEmpty(b.a(this.a))) {
        b.a(this.a, true);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.a("warlock816Exception:" + localException, new Object[0]);
        localException.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/launcher/task/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */