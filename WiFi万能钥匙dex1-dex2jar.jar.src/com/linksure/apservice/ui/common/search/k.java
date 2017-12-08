package com.linksure.apservice.ui.common.search;

import android.text.TextUtils;
import com.linksure.apservice.a.g;
import com.linksure.apservice.ui.common.interceptor.h;
import com.linksure.apservice.utils.i;
import java.util.Iterator;
import java.util.List;

public final class k
  extends h
  implements a.a
{
  List<com.linksure.apservice.b.a> a;
  private com.linksure.apservice.a.a b;
  private String c;
  private final int d = 10;
  private int e = 1;
  private boolean f = false;
  private a.b g;
  
  public k(a.b paramb, g paramg, com.linksure.apservice.a.a parama)
  {
    super(paramb, paramg, parama);
    this.g = ((a.b)i.a(a.b.class, paramb));
    this.b = parama;
    f();
  }
  
  public final void a()
  {
    super.a();
    i.a(this.g).a();
    a(this.c);
  }
  
  public final void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      this.c = paramString;
      this.e = 1;
      this.f = false;
      this.b.a(paramString, this.e, new l(this));
    }
  }
  
  public final void b()
  {
    super.b();
    i.a(this.g).b();
  }
  
  public final void b(String paramString)
  {
    Iterator localIterator = this.a.iterator();
    com.linksure.apservice.b.a locala;
    while (localIterator.hasNext())
    {
      locala = (com.linksure.apservice.b.a)localIterator.next();
      if (paramString.equals(locala.k)) {
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
      this.g.b(true);
      this.b.a(paramString, new n(this, locala, paramString));
    }
  }
  
  public final void c()
  {
    if (this.f) {}
    for (;;)
    {
      return;
      this.g.a(true);
      com.linksure.apservice.a.a locala = this.b;
      String str = this.c;
      int i = this.e + 1;
      this.e = i;
      locala.a(str, i, new m(this));
    }
  }
  
  public final void d()
  {
    a(this.c);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/common/search/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */