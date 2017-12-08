package com.linksure.apservice.ui.apslist.loading;

import com.linksure.apservice.a.a;
import com.linksure.apservice.utils.i;

public final class b
  implements a.a
{
  a a;
  a.b b;
  int c = 0;
  boolean d = false;
  
  public b(a.b paramb, a parama)
  {
    this.b = ((a.b)i.a(a.b.class, paramb));
    this.a = parama;
  }
  
  public final void a()
  {
    i.a(this.b).a();
    d();
  }
  
  public final void b()
  {
    i.a(this.b).b();
  }
  
  public final void c()
  {
    if (this.a.b() > 0L) {
      this.b.i_();
    }
    this.c = 0;
    d();
    this.a.a(true, new c(this));
  }
  
  final void d()
  {
    if (this.c == 0)
    {
      this.b.a(true);
      this.b.b(false);
    }
    for (;;)
    {
      return;
      if (this.c == 1)
      {
        this.b.a(false);
        this.b.b(true);
      }
      else if (this.c == 2)
      {
        if (this.d) {
          this.b.i_();
        } else {
          this.b.h_();
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/apslist/loading/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */