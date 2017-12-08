package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.a.f;
import com.tencent.wxop.stat.b.b;

final class ap
  implements Runnable
{
  ap(Context paramContext, Throwable paramThrowable) {}
  
  public final void run()
  {
    try
    {
      if (!c.l()) {}
      for (;;)
      {
        return;
        com.tencent.wxop.stat.a.c localc = new com/tencent/wxop/stat/a/c;
        localc.<init>(this.e, e.a(this.e, false, null), this.dn, f.bw);
        p localp = new com/tencent/wxop/stat/p;
        localp.<init>(localc);
        localp.ah();
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        e.K().d("reportSdkSelfException error: " + localThrowable);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/wxop/stat/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */