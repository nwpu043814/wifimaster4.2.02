package com.linksure.apservice.a.a;

import android.content.Context;
import com.lantern.core.o;
import com.linksure.apservice.a.a.a.a.b.a;

public final class b
{
  private static com.linksure.apservice.a.a.a.b a;
  private static f b = null;
  private static g c = null;
  
  public static a a(Context paramContext)
  {
    return new com.linksure.apservice.a.a.b.a(f(paramContext), com.lantern.core.c.getServer());
  }
  
  public static g a()
  {
    if (c == null) {
      c = new com.linksure.apservice.a.a.b.f();
    }
    return c;
  }
  
  public static e b(Context paramContext)
  {
    return new com.linksure.apservice.a.a.b.d(f(paramContext), com.lantern.core.c.getServer());
  }
  
  public static c c(Context paramContext)
  {
    return new com.linksure.apservice.a.a.b.b(f(paramContext), com.lantern.core.c.getServer());
  }
  
  public static d d(Context paramContext)
  {
    return new com.linksure.apservice.a.a.b.c(f(paramContext), com.lantern.core.c.getServer());
  }
  
  public static f e(Context paramContext)
  {
    if (b == null)
    {
      o localo = com.lantern.core.c.getServer();
      b.a locala = new b.a();
      locala.c(localo.k());
      locala.a("a").g(localo.l()).h(localo.m());
      locala.b("m").i(localo.n());
      locala.d(localo.g());
      locala.e(com.linksure.apservice.a.f.e.a(paramContext));
      locala.f("wk_0004");
      b = new com.linksure.apservice.a.a.b.e(new com.linksure.apservice.a.a.a.a.a(locala.a()), com.lantern.core.c.getServer());
    }
    return b;
  }
  
  private static com.linksure.apservice.a.a.a.b f(Context paramContext)
  {
    if (a == null)
    {
      o localo = com.lantern.core.c.getServer();
      b.a locala = new b.a();
      locala.c(localo.k());
      locala.a("a").g(localo.l()).h(localo.m());
      locala.b("m").i(localo.n());
      locala.d(localo.g());
      locala.e(com.linksure.apservice.a.f.e.a(paramContext));
      a = new com.linksure.apservice.a.a.a.a.a(locala.a());
    }
    return a;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */