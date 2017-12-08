package com.lantern.launcher.ui;

import com.bluefay.b.h;
import com.lantern.core.c;
import com.lantern.core.o;
import com.lantern.core.p;
import com.lantern.core.t;

final class e
  implements com.bluefay.b.a
{
  e(MainActivityICS paramMainActivityICS) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return;
      paramString = (com.lantern.c.a.a)paramObject;
      if (paramString.a)
      {
        p.a(this.a, paramString.d);
        p.m(this.a, c.getServer().b());
        h.a("updateInfo size:" + paramString.i);
        h.a("updateInfo version:" + paramString.f);
        h.a("updateInfo md5:" + paramString.h);
        h.a("updateInfo path:" + paramString.g);
        if ((t.e(this.a)) && (paramString.b))
        {
          if (!this.a.c()) {
            com.lantern.c.a.a(this.a).a(this.a, paramString, "upsi_y", "upappw_n");
          }
          com.lantern.analytics.a.e().onEvent("upsi");
        }
      }
      for (;;)
      {
        p.g(this.a);
        break;
        h.a("has no update");
      }
      h.a("none wifi");
      continue;
      h.a("time out");
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/launcher/ui/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */