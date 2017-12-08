package com.linksure.apservice.ui.common.preview;

import com.linksure.apservice.utils.i;

public final class c
  implements a.a
{
  int a;
  long b;
  String c;
  String d;
  String e;
  private com.linksure.apservice.a.d f;
  private a.b g;
  private int h;
  
  public c(a.b paramb, com.linksure.apservice.a.d paramd)
  {
    this.g = ((a.b)i.a(a.b.class, paramb));
    this.f = paramd;
  }
  
  public final void a()
  {
    i.a(this.g).a();
    int i = this.h;
    if (i == 3) {
      this.g.c();
    }
    for (;;)
    {
      return;
      if (i == 0)
      {
        this.g.a(this.c);
        this.g.a(this.b);
      }
      else if (i == 2)
      {
        this.g.b(this.e);
        this.g.o_();
      }
      else if (i == 1)
      {
        this.g.n_();
        this.g.c_(this.a);
      }
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    this.c = paramString1;
    this.d = paramString2;
    if (paramString2 != null)
    {
      this.e = this.f.a(this.d);
      if (this.e == null) {
        this.f.a(paramString2, new d(this));
      }
      if (this.e == null) {
        break label77;
      }
      this.h = 2;
    }
    for (;;)
    {
      return;
      this.e = paramString1;
      break;
      label77:
      if (this.d != null) {
        this.h = 0;
      } else {
        this.h = 3;
      }
    }
  }
  
  public final void b()
  {
    i.a(this.g).b();
  }
  
  public final void c()
  {
    this.g.c(this.e);
    this.g.c();
    this.h = 3;
  }
  
  public final void d()
  {
    this.h = 1;
    this.a = 0;
    this.g.n_();
    this.g.c_(0);
    this.f.a(this.d, new e(this));
  }
  
  public final void e()
  {
    this.h = 0;
    this.g.a(this.b);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/common/preview/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */