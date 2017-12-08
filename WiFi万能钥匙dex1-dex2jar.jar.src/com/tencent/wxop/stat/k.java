package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.a.d;
import com.tencent.wxop.stat.a.h;
import com.tencent.wxop.stat.b.b;
import java.util.Map;

final class k
  implements Runnable
{
  k(Context paramContext, String paramString, f paramf) {}
  
  public final void run()
  {
    for (;;)
    {
      try
      {
        e.p(this.e);
      }
      catch (Throwable localThrowable)
      {
        Object localObject2;
        e.K().b(localThrowable);
        e.a(this.e, localThrowable);
        continue;
        b localb = e.K();
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>("Starttime for PageID:");
        localb.d(this.b + " not found, lost onResume()?");
        continue;
      }
      synchronized (e.M())
      {
        localObject2 = (Long)e.M().remove(this.b);
        if (localObject2 != null)
        {
          localObject2 = Long.valueOf((System.currentTimeMillis() - ((Long)localObject2).longValue()) / 1000L);
          ??? = localObject2;
          if (((Long)localObject2).longValue() <= 0L) {
            ??? = Long.valueOf(1L);
          }
          Object localObject4 = e.O();
          localObject2 = localObject4;
          if (localObject4 != null)
          {
            localObject2 = localObject4;
            if (((String)localObject4).equals(this.b) == true) {
              localObject2 = "-";
            }
          }
          localObject4 = new com/tencent/wxop/stat/a/h;
          ((h)localObject4).<init>(this.e, (String)localObject2, this.b, e.a(this.e, false, this.bM), (Long)???, this.bM);
          if (!this.b.equals(e.N())) {
            e.K().warn("Invalid invocation since previous onResume on diff page.");
          }
          ??? = new com/tencent/wxop/stat/p;
          ((p)???).<init>((d)localObject4);
          ((p)???).ah();
          e.r(this.b);
          return;
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/wxop/stat/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */