package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.b.b;

final class h
  implements Runnable
{
  h(Context paramContext) {}
  
  public final void run()
  {
    try
    {
      e.p(this.e);
      t.s(this.e).b(this.g);
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


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/wxop/stat/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */