package com.linksure.apservice.ui.profile.detail;

import com.linksure.apservice.a.g;
import com.linksure.apservice.ui.common.interceptor.h;
import com.linksure.apservice.utils.i;

public final class b
  extends h
  implements a.a
{
  private a.b a;
  private com.linksure.apservice.a.a b;
  private com.linksure.apservice.a.b c;
  private com.linksure.apservice.b.a d;
  
  public b(a.b paramb, g paramg, com.linksure.apservice.a.a parama, com.linksure.apservice.a.b paramb1)
  {
    super(paramb, paramg, parama);
    this.a = ((a.b)i.a(a.b.class, paramb));
    this.b = parama;
    this.c = paramb1;
    f();
  }
  
  public final void a()
  {
    super.a();
    i.a(this.a).a();
    this.a.a(this.d);
  }
  
  public final void a(boolean paramBoolean)
  {
    this.c.a(this.d.k, paramBoolean, new e(this, paramBoolean));
  }
  
  public final void b()
  {
    super.b();
    i.a(this.a).b();
  }
  
  public final void b(com.linksure.apservice.b.a parama)
  {
    this.d = parama;
  }
  
  public final void b(boolean paramBoolean)
  {
    this.c.b(this.d.k, paramBoolean, new f(this, paramBoolean));
  }
  
  public final void c()
  {
    this.a.a(true, false);
    this.b.b(this.d.k, new d(this));
    com.linksure.apservice.utils.b.c(this.d.k);
  }
  
  public final void e()
  {
    if (a(this.d)) {}
    for (;;)
    {
      return;
      this.a.a(true, true);
      this.b.a(this.d.k, new c(this));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/profile/detail/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */