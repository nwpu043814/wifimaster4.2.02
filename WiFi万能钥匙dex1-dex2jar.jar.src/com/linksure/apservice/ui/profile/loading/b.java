package com.linksure.apservice.ui.profile.loading;

import com.linksure.apservice.a.a;
import com.linksure.apservice.utils.i;

public final class b
  implements a.a
{
  a a;
  a.b b;
  int c = 0;
  
  public b(a.b paramb, a parama)
  {
    this.b = ((a.b)i.a(a.b.class, paramb));
    this.a = parama;
  }
  
  public final void a()
  {
    i.a(this.b).a();
    c();
  }
  
  public final void a(String paramString)
  {
    this.c = 0;
    c();
    this.a.a(true, paramString, new c(this));
  }
  
  public final void b()
  {
    i.a(this.b).b();
  }
  
  final void c()
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
        this.b.a(false);
        this.b.b(false);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/profile/loading/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */