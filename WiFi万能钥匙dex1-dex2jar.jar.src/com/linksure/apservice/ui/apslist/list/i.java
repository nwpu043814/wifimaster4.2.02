package com.linksure.apservice.ui.apslist.list;

import android.content.Context;
import com.linksure.apservice.a.c;
import com.linksure.apservice.a.f;
import java.util.Comparator;
import java.util.List;

public final class i
  implements a.a
{
  private static Comparator<com.linksure.apservice.b.a> f = new l();
  com.linksure.apservice.a.a a;
  f b;
  c c;
  a.b d;
  List<com.linksure.apservice.b.a> e = null;
  
  public i(Context paramContext, a.b paramb, com.linksure.apservice.a.a parama, f paramf)
  {
    this.d = ((a.b)com.linksure.apservice.utils.i.a(a.b.class, paramb));
    this.a = parama;
    this.b = paramf;
    this.c = com.linksure.apservice.a.i.f(paramContext);
  }
  
  public final void a()
  {
    com.linksure.apservice.utils.i.a(this.d).a();
  }
  
  public final void a(com.linksure.apservice.b.a parama)
  {
    this.d.a(parama);
    this.b.b(parama.k);
    this.a.a(parama.k);
  }
  
  public final void b()
  {
    com.linksure.apservice.utils.i.a(this.d).b();
  }
  
  public final void b(com.linksure.apservice.b.a parama)
  {
    this.d.b(parama);
  }
  
  public final void c()
  {
    this.a.a(true, new n(this));
    this.c.a(new o(this));
  }
  
  public final void c(com.linksure.apservice.b.a parama)
  {
    this.d.a(true);
    this.a.b(parama.k, new k(this));
  }
  
  public final void d()
  {
    this.a.a(true, new j(this));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/apslist/list/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */