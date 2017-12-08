package com.lantern.auth.a;

import com.bluefay.b.h;
import com.lantern.auth.g;

final class b
  implements Runnable
{
  b(a parama) {}
  
  public final void run()
  {
    h.b(" dsLoginTimeout ");
    synchronized (this.a)
    {
      a.a(this.a);
      com.lantern.analytics.a.e().onEvent("umcdsto", g.a(a.b(this.a)));
      a.a(this.a, a.c(this.a));
      a.a(this.a, "1");
      a.a(this.a, 13, null, null, a.d(this.a));
      return;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */