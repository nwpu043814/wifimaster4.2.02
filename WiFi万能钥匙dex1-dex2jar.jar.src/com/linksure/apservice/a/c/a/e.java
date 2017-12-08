package com.linksure.apservice.a.c.a;

import com.linksure.apservice.a.b.d;
import com.linksure.apservice.a.f.b;

public final class e
  implements a
{
  private com.linksure.apservice.a.a.e a;
  private d b;
  
  public e(com.linksure.apservice.a.a.e parame, d paramd)
  {
    this.a = parame;
    this.b = paramd;
  }
  
  public final void a(long paramLong, a.a parama)
  {
    com.linksure.apservice.a.d.f localf = this.b.a(paramLong);
    parama.a(localf);
    b.b(new g(this, localf, parama));
  }
  
  public final void a(String paramString1, String paramString2, a.a parama)
  {
    com.linksure.apservice.a.d.f localf = new com.linksure.apservice.a.d.f();
    localf.f = 1;
    localf.c = 0;
    localf.b = 1;
    localf.d = paramString2;
    localf.e = paramString1;
    localf.g = System.currentTimeMillis();
    localf.a = this.b.a(localf);
    parama.a(localf);
    b.b(new f(this, localf, parama));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/a/c/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */