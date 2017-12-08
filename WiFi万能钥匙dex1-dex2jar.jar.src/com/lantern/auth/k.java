package com.lantern.auth;

import com.lantern.core.h;
import com.lantern.core.model.g;
import com.lantern.core.o;
import com.lantern.core.p;

final class k
  implements com.bluefay.b.a
{
  k(i parami) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    paramString = (com.lantern.auth.b.a)paramObject;
    if (paramInt == 1)
    {
      p.g(i.b(this.a), paramString.a);
      paramObject = new g();
      ((g)paramObject).a = paramString.d;
      ((g)paramObject).b = paramString.c;
      ((g)paramObject).c = com.bluefay.a.c.d(i.b(this.a));
      ((g)paramObject).d = paramString.e;
      ((g)paramObject).g = paramString.f;
      ((g)paramObject).h = paramString.g;
      com.lantern.core.c.getServer().a((g)paramObject);
      h.b();
      i.a(this.a, 1);
    }
    for (;;)
    {
      return;
      i.a(this.a, 0);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */