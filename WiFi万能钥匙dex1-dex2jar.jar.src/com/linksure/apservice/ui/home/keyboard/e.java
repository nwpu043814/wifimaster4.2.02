package com.linksure.apservice.ui.home.keyboard;

import com.linksure.apservice.utils.b;
import com.linksure.apservice.utils.i;
import java.util.Collections;
import java.util.List;

public final class e
  extends com.linksure.apservice.ui.common.interceptor.h
  implements b.a
{
  private com.linksure.apservice.a.g a;
  private com.linksure.apservice.a.a b;
  private com.linksure.apservice.a.f c;
  private b.b d;
  private List<com.linksure.apservice.b.h> e = Collections.EMPTY_LIST;
  private com.linksure.apservice.b.a f;
  
  public e(b.b paramb, com.linksure.apservice.a.g paramg, com.linksure.apservice.a.a parama, com.linksure.apservice.a.f paramf)
  {
    super(paramb, paramg, parama);
    this.d = ((b.b)i.a(b.b.class, paramb));
    this.a = paramg;
    this.b = parama;
    this.c = paramf;
  }
  
  public final void a()
  {
    super.a();
    i.a(this.d).a();
    if ((this.e != null) && (!this.e.isEmpty())) {
      this.d.a(this.e);
    }
  }
  
  public final void a(com.linksure.apservice.b.a parama, List<com.linksure.apservice.b.h> paramList)
  {
    this.f = parama;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.e = paramList;
      this.d.a(paramList);
    }
  }
  
  public final void a(com.linksure.apservice.b.h paramh)
  {
    if (a(this.f)) {}
    for (;;)
    {
      return;
      if (paramh.a().isEmpty())
      {
        this.d.a_(paramh.d);
        b.a(this.f.k, paramh.b, -1);
      }
      else
      {
        this.d.a(paramh, paramh.a());
      }
    }
  }
  
  public final void a(String paramString)
  {
    if (a(this.f)) {
      this.d.b(paramString);
    }
    for (;;)
    {
      return;
      this.c.a(1, paramString, new f(this));
    }
  }
  
  public final void b()
  {
    super.b();
    i.a(this.d).b();
  }
  
  public final void b(com.linksure.apservice.b.h paramh)
  {
    if (a(this.f)) {}
    for (;;)
    {
      return;
      this.d.a_(paramh.d);
      b.a(this.f.k, paramh.a, paramh.b);
    }
  }
  
  public final void b(String paramString)
  {
    this.c.a(2, paramString, new g(this));
  }
  
  public final void c()
  {
    if (a(this.f)) {}
    for (;;)
    {
      return;
      this.d.q_();
    }
  }
  
  public final void d()
  {
    if (a(this.f)) {}
    for (;;)
    {
      return;
      this.d.h();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/home/keyboard/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */