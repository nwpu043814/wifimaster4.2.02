package com.linksure.apservice.a.a.b;

import com.lantern.core.o;
import com.linksure.apservice.a.a.c.d.a;
import com.linksure.apservice.a.a.c.d.b;
import com.linksure.apservice.a.a.c.e.a;
import com.linksure.apservice.a.a.c.e.b;
import com.linksure.apservice.a.a.c.f.a;
import com.linksure.apservice.a.a.c.f.b;
import com.linksure.apservice.a.a.c.g.a;
import com.linksure.apservice.a.a.c.g.b;
import com.linksure.apservice.a.a.c.h.a;
import com.linksure.apservice.a.a.c.h.b;
import com.linksure.apservice.a.a.c.j.a;
import com.linksure.apservice.a.a.c.j.b;
import com.linksure.apservice.a.a.c.l.a;
import com.linksure.apservice.a.a.c.l.b;
import com.linksure.apservice.a.a.c.m.a;
import com.linksure.apservice.a.a.c.m.b;
import com.linksure.apservice.a.a.c.n.a;
import com.linksure.apservice.a.a.c.n.b;
import com.linksure.apservice.a.a.c.q.a;
import com.linksure.apservice.a.a.c.q.b;
import java.util.Collections;
import java.util.List;

public final class a
  implements com.linksure.apservice.a.a.a
{
  private com.linksure.apservice.a.a.a.b a;
  private o b;
  
  public a(com.linksure.apservice.a.a.a.b paramb, o paramo)
  {
    this.b = paramo;
    this.a = paramb;
  }
  
  public final com.linksure.apservice.a.d.a a(String paramString)
  {
    paramString = new g.a(paramString);
    paramString.a(this.b.s());
    paramString = (g.b)this.a.a(paramString, g.b.class);
    if (((paramString.a == 0) || (paramString.a == 3001)) && (paramString.c != null)) {
      return (com.linksure.apservice.a.d.a)paramString.c;
    }
    throw new com.linksure.apservice.a.d.a.b(paramString.a, paramString.b);
  }
  
  public final List<com.linksure.apservice.a.d.b> a()
  {
    Object localObject = new d.a();
    ((com.linksure.apservice.a.a.c.a)localObject).a(this.b.s());
    localObject = (d.b)this.a.a((com.linksure.apservice.a.a.a.c)localObject, d.b.class);
    if (((d.b)localObject).a == 0)
    {
      if (((d.b)localObject).c == null) {}
      for (localObject = Collections.EMPTY_LIST;; localObject = (List)((d.b)localObject).c) {
        return (List<com.linksure.apservice.a.d.b>)localObject;
      }
    }
    throw new com.linksure.apservice.a.d.a.b(((d.b)localObject).b);
  }
  
  public final List<com.linksure.apservice.a.d.c> a(String paramString, int paramInt1, int paramInt2)
  {
    paramString = new e.a(paramString, paramInt1, paramInt2);
    paramString.a(this.b.s());
    paramString = (e.b)this.a.a(paramString, e.b.class);
    if (paramString.a == 0)
    {
      if (paramString.c == null) {}
      for (paramString = Collections.EMPTY_LIST;; paramString = (List)paramString.c) {
        return paramString;
      }
    }
    throw new com.linksure.apservice.a.d.a.b(paramString.a, paramString.b);
  }
  
  public final void a(String paramString1, int paramInt, String paramString2)
  {
    paramString1 = new f.a(paramString1, paramInt, paramString2);
    paramString1.a(this.b.s());
    paramString1 = (f.b)this.a.a(paramString1, f.b.class);
    if (paramString1.a == 0) {
      return;
    }
    throw new com.linksure.apservice.a.d.a.c(paramString1.a, paramString1.b);
  }
  
  public final List<com.linksure.apservice.a.d.a> b()
  {
    Object localObject = new j.a();
    ((com.linksure.apservice.a.a.c.a)localObject).a(this.b.s());
    localObject = (j.b)this.a.a((com.linksure.apservice.a.a.a.c)localObject, j.b.class);
    if (((j.b)localObject).a == 0)
    {
      if (((j.b)localObject).c == null) {}
      for (localObject = Collections.EMPTY_LIST;; localObject = (List)((j.b)localObject).c) {
        return (List<com.linksure.apservice.a.d.a>)localObject;
      }
    }
    throw new com.linksure.apservice.a.d.a.b(((j.b)localObject).a, ((j.b)localObject).b);
  }
  
  public final List<com.linksure.apservice.a.d.a> b(String paramString, int paramInt1, int paramInt2)
  {
    paramString = new n.a(paramString, paramInt1, paramInt2);
    paramString.a(this.b.s());
    paramString = (n.b)this.a.a(paramString, n.b.class);
    if (paramString.a == 0)
    {
      if (paramString.c == null) {}
      for (paramString = Collections.EMPTY_LIST;; paramString = (List)paramString.c) {
        return paramString;
      }
    }
    throw new com.linksure.apservice.a.d.a.b(paramString.a, paramString.b);
  }
  
  public final boolean b(String paramString)
  {
    paramString = new q.a(paramString);
    paramString.a(this.b.s());
    paramString = (q.b)this.a.a(paramString, q.b.class);
    if (paramString.a == 0) {
      return true;
    }
    throw new com.linksure.apservice.a.d.a.b(paramString.a, paramString.b);
  }
  
  public final com.linksure.apservice.a.d.a c(String paramString)
  {
    paramString = new h.a(paramString);
    paramString.a(this.b.s());
    paramString = (h.b)this.a.a(paramString, h.b.class);
    if (paramString.a == 0) {
      return (com.linksure.apservice.a.d.a)paramString.c;
    }
    throw new com.linksure.apservice.a.d.a.b(paramString.a, paramString.b);
  }
  
  public final List<com.linksure.apservice.a.d.a> c()
  {
    Object localObject = new m.a();
    ((com.linksure.apservice.a.a.c.a)localObject).a(this.b.s());
    localObject = (m.b)this.a.a((com.linksure.apservice.a.a.a.c)localObject, m.b.class);
    if (((m.b)localObject).a == 0)
    {
      if (((m.b)localObject).c == null) {}
      for (localObject = Collections.EMPTY_LIST;; localObject = (List)((m.b)localObject).c) {
        return (List<com.linksure.apservice.a.d.a>)localObject;
      }
    }
    throw new com.linksure.apservice.a.d.a.b(((m.b)localObject).a, ((m.b)localObject).b);
  }
  
  public final double d(String paramString)
  {
    paramString = new l.a(paramString);
    paramString.a(this.b.s());
    paramString = (l.b)this.a.a(paramString, l.b.class);
    if (paramString.a == 0) {
      return ((Double)paramString.c).doubleValue();
    }
    throw new com.linksure.apservice.a.d.a.c(paramString.b);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/a/a/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */