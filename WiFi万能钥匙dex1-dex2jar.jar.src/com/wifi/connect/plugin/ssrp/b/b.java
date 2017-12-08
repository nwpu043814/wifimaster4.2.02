package com.wifi.connect.plugin.ssrp.b;

import com.bluefay.b.h;
import com.lantern.core.g.r;
import com.lantern.core.g.r.a;

final class b
  implements com.bluefay.b.a
{
  b(a parama) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    if (paramInt == 1)
    {
      a.a(this.a).a(1, paramString, null);
      a.b(this.a).b = System.currentTimeMillis();
      a.b(this.a).j = 1;
      a.b(this.a).e = a.c(this.a);
    }
    for (;;)
    {
      try
      {
        a.b(this.a).a();
        return;
      }
      catch (Exception paramString)
      {
        h.a(paramString);
        continue;
      }
      if (paramInt == 0)
      {
        if (a.d(this.a) != null) {
          a.e(this.a).b(a.d(this.a), new c(this));
        }
        if ((a.f(this.a) == 1) && (a.e(this.a) != null))
        {
          a.g(this.a);
          a.a(this.a, new r(a.h(this.a)));
          a.a(this.a, a.e(this.a), a.i(this.a));
        }
        else
        {
          a.a(this.a).a(0, paramString, null);
          a.b(this.a).j = 0;
          a.b(this.a).b = System.currentTimeMillis();
          a.b(this.a).f = a.f(this.a);
          paramInt = 10000;
          if ((paramObject instanceof r.a)) {
            paramInt = ((r.a)paramObject).a;
          }
          a.b(this.a).m = String.valueOf(paramInt);
          a.b(this.a).e = a.c(this.a);
          try
          {
            a.b(this.a).a();
          }
          catch (Exception paramString)
          {
            h.a(paramString);
          }
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/ssrp/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */