package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.b.b;

final class i
  implements Runnable
{
  i(Context paramContext) {}
  
  public final void run()
  {
    try
    {
      Thread localThread = new java/lang/Thread;
      o localo = new com/tencent/wxop/stat/o;
      localo.<init>(this.e);
      localThread.<init>(localo, "NetworkMonitorTask");
      localThread.start();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        e.K().b(localThrowable);
        e.a(this.e, localThrowable);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/wxop/stat/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */