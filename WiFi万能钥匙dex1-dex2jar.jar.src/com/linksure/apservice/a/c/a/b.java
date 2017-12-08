package com.linksure.apservice.a.c.a;

import com.linksure.apservice.a.a.e;

public final class b
  implements a
{
  private com.linksure.apservice.a.b.c a;
  private com.linksure.apservice.a.a.f b;
  private e c;
  private com.linksure.apservice.a.b.d d;
  
  public b(com.linksure.apservice.a.b.c paramc, com.linksure.apservice.a.a.f paramf, e parame, com.linksure.apservice.a.b.d paramd)
  {
    this.a = paramc;
    this.b = paramf;
    this.c = parame;
    this.d = paramd;
  }
  
  private static String a(String paramString1, String paramString2)
  {
    return String.format("{thumb:\"%s\",origin:\"%s\"}", new Object[] { paramString1, paramString2 });
  }
  
  public final void a(long paramLong, a.a parama)
  {
    com.linksure.apservice.a.d.f localf = this.d.a(paramLong);
    parama.a(localf);
    com.linksure.apservice.a.f.b.b(new d(this, localf, parama));
  }
  
  public final void a(String paramString1, String paramString2, a.a parama)
  {
    try
    {
      String str = this.a.a(paramString2);
      com.linksure.apservice.a.d.f localf = new com.linksure.apservice.a.d.f();
      localf.f = 1;
      localf.c = 0;
      localf.b = 2;
      localf.d = a(str, paramString2);
      localf.e = paramString1;
      localf.g = System.currentTimeMillis();
      localf.a = this.d.a(localf);
      parama.a(localf);
      com.linksure.apservice.a.f.b.b(new c(this, localf, str, paramString1, paramString2, parama));
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        parama.a(paramString1);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/a/c/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */