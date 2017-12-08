package com.lantern.auth;

import com.bluefay.b.h;
import com.lantern.core.o;
import com.lantern.core.p;

final class f
  implements com.bluefay.b.a
{
  f(a parama) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    paramString = (com.lantern.auth.b.a)paramObject;
    h.a("Uplink", new Object[] { paramString });
    if (paramInt == 1)
    {
      p.g(a.e(this.a), paramString.a);
      paramObject = new com.lantern.core.model.g();
      ((com.lantern.core.model.g)paramObject).a = paramString.d;
      ((com.lantern.core.model.g)paramObject).b = paramString.c;
      ((com.lantern.core.model.g)paramObject).c = com.bluefay.a.c.d(a.e(this.a));
      ((com.lantern.core.model.g)paramObject).d = paramString.e;
      ((com.lantern.core.model.g)paramObject).g = paramString.f;
      ((com.lantern.core.model.g)paramObject).h = paramString.g;
      com.lantern.core.c.getServer().a((com.lantern.core.model.g)paramObject);
      com.lantern.analytics.a.e().onEvent("auth_auto", g.a("1", "success", null));
      com.lantern.analytics.a.e().onEvent("LoginOn", g.a("app_auto", "5", "1", com.lantern.core.c.getServer().k()));
      a.a(this.a, 1, paramObject);
    }
    for (;;)
    {
      a.a(this.a);
      return;
      h.c("uplink register failed");
      a.a(this.a, 0, null);
      com.lantern.analytics.a.e().onEvent("auth_auto", g.a("1", "failed", null));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */