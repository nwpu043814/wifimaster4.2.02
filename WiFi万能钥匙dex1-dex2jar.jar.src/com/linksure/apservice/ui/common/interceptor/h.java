package com.linksure.apservice.ui.common.interceptor;

import android.util.Log;
import com.linksure.apservice.a.d.a.b;
import com.linksure.apservice.a.g;

public class h
  implements a.a
{
  private com.linksure.apservice.a.a a;
  private g b;
  private a.b c;
  private boolean d = true;
  private boolean e = true;
  private boolean f = true;
  private com.linksure.apservice.b.a g;
  
  public h(a.b paramb, g paramg, com.linksure.apservice.a.a parama)
  {
    this.c = ((a.b)com.linksure.apservice.utils.i.a(a.b.class, paramb));
    this.b = paramg;
    this.a = parama;
  }
  
  public void a()
  {
    com.linksure.apservice.utils.i.a(this.c).a();
  }
  
  public final boolean a(com.linksure.apservice.b.a parama)
  {
    boolean bool = true;
    Log.e("--->", "interceptor:" + parama);
    this.g = parama;
    if ((this.d) && (!this.b.b())) {
      this.c.j_();
    }
    for (;;)
    {
      return bool;
      if ((this.f) && (parama != null) && (parama.f)) {
        this.c.k_();
      } else if ((this.e) && (parama != null) && (!parama.e)) {
        this.c.c();
      } else {
        bool = false;
      }
    }
  }
  
  public final boolean a(Exception paramException)
  {
    boolean bool = false;
    if (!(paramException instanceof b)) {}
    for (;;)
    {
      return bool;
      if (((b)paramException).a() == 3009)
      {
        this.c.d();
        bool = true;
      }
    }
  }
  
  public void b()
  {
    com.linksure.apservice.utils.i.a(this.c).b();
  }
  
  public void e()
  {
    if (this.g == null) {
      Log.e("--->", "fatal err aps is null");
    }
    for (;;)
    {
      return;
      this.c.e();
      this.a.a(this.g.k, new i(this));
    }
  }
  
  public final void f()
  {
    this.d = true;
    this.e = false;
    this.f = true;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/common/interceptor/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */