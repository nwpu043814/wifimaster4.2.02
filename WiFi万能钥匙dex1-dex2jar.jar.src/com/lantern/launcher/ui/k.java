package com.lantern.launcher.ui;

import com.bluefay.b.a;
import com.lantern.core.c;
import com.lantern.core.g.n;
import com.lantern.core.o;
import com.lantern.wifilocating.push.b;

final class k
  implements a
{
  k(MainActivityICS paramMainActivityICS) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    paramString = new com.lantern.wifilocating.push.f();
    paramObject = n.a();
    paramString.e(((com.lantern.core.model.f)paramObject).c);
    paramString.d(((com.lantern.core.model.f)paramObject).b);
    paramString.f(((com.lantern.core.model.f)paramObject).d);
    paramString.a(((com.lantern.core.model.f)paramObject).a);
    paramObject = c.getServer();
    paramString.b(((o)paramObject).b());
    paramString.c(((o)paramObject).c());
    paramString.g(((o)paramObject).g());
    paramString.h(((o)paramObject).h());
    b.a(this.a.getApplicationContext(), paramString);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/launcher/ui/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */