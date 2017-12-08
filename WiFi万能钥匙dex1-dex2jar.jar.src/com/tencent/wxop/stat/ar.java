package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.a.a;

final class ar
  implements Runnable
{
  ar(Context paramContext, com.tencent.wxop.stat.a.b paramb) {}
  
  public final void run()
  {
    try
    {
      a locala = new com/tencent/wxop/stat/a/a;
      locala.<init>(this.e, e.a(this.e, false, this.bN), this.jdField_do.a, this.bN);
      locala.ab().bm = this.jdField_do.bm;
      p localp = new com/tencent/wxop/stat/p;
      localp.<init>(locala);
      localp.ah();
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


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/wxop/stat/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */