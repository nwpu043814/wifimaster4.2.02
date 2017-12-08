package com.linksure.apservice.ui.apslist.recommend;

import android.content.Context;
import com.linksure.apservice.a.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class f
  extends com.linksure.apservice.ui.common.interceptor.h
  implements a.a
{
  c a;
  private com.linksure.apservice.a.g b;
  private com.linksure.apservice.a.a c;
  private a.b d;
  private List<com.linksure.apservice.b.a> e = new ArrayList();
  
  public f(Context paramContext, a.b paramb, com.linksure.apservice.a.a parama, com.linksure.apservice.a.g paramg)
  {
    super(paramb, paramg, parama);
    this.d = ((a.b)com.linksure.apservice.utils.i.a(a.b.class, paramb));
    this.c = parama;
    this.b = paramg;
    this.a = com.linksure.apservice.a.i.f(paramContext);
  }
  
  public final void a()
  {
    super.a();
    com.linksure.apservice.utils.i.a(this.d).a();
    if ((this.e != null) && (!this.e.isEmpty())) {
      this.d.a(this.e);
    }
  }
  
  public final void a(String paramString)
  {
    Iterator localIterator = this.e.iterator();
    com.linksure.apservice.b.a locala;
    while (localIterator.hasNext())
    {
      locala = (com.linksure.apservice.b.a)localIterator.next();
      if (locala.k.equals(paramString)) {
        if ((locala != null) && (!a(locala))) {
          break label58;
        }
      }
    }
    for (;;)
    {
      return;
      locala = null;
      break;
      label58:
      this.d.e();
      this.c.a(paramString, new h(this, locala, paramString));
    }
  }
  
  public final void b()
  {
    super.b();
    com.linksure.apservice.utils.i.a(this.d).b();
  }
  
  public final void c()
  {
    this.a.a(new i(this));
    f();
  }
  
  public final void d()
  {
    this.d.b(true);
    this.c.a(new g(this));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/apslist/recommend/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */