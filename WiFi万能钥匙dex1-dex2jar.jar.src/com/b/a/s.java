package com.b.a;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class s
  extends z
  implements Iterable<z>
{
  private final List<z> a = new ArrayList();
  
  public final int a()
  {
    return this.a.size();
  }
  
  public final z a(int paramInt)
  {
    return (z)this.a.get(paramInt);
  }
  
  public final void a(z paramz)
  {
    Object localObject = paramz;
    if (paramz == null) {
      localObject = ab.a();
    }
    this.a.add(localObject);
  }
  
  protected final void a(Appendable paramAppendable, h paramh)
  {
    paramAppendable.append('[');
    Iterator localIterator = this.a.iterator();
    int i = 1;
    if (localIterator.hasNext())
    {
      z localz = (z)localIterator.next();
      if (i != 0) {
        i = 0;
      }
      for (;;)
      {
        localz.a(paramAppendable, paramh);
        break;
        paramAppendable.append(',');
      }
    }
    paramAppendable.append(']');
  }
  
  public final Number b()
  {
    if (this.a.size() == 1) {
      return ((z)this.a.get(0)).b();
    }
    throw new IllegalStateException();
  }
  
  public final String c()
  {
    if (this.a.size() == 1) {
      return ((z)this.a.get(0)).c();
    }
    throw new IllegalStateException();
  }
  
  public final double d()
  {
    if (this.a.size() == 1) {
      return ((z)this.a.get(0)).d();
    }
    throw new IllegalStateException();
  }
  
  public final BigDecimal e()
  {
    if (this.a.size() == 1) {
      return ((z)this.a.get(0)).e();
    }
    throw new IllegalStateException();
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject == this) || (((paramObject instanceof s)) && (((s)paramObject).a.equals(this.a)))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final BigInteger f()
  {
    if (this.a.size() == 1) {
      return ((z)this.a.get(0)).f();
    }
    throw new IllegalStateException();
  }
  
  public final float g()
  {
    if (this.a.size() == 1) {
      return ((z)this.a.get(0)).g();
    }
    throw new IllegalStateException();
  }
  
  public final long h()
  {
    if (this.a.size() == 1) {
      return ((z)this.a.get(0)).h();
    }
    throw new IllegalStateException();
  }
  
  public final int hashCode()
  {
    return this.a.hashCode();
  }
  
  public final int i()
  {
    if (this.a.size() == 1) {
      return ((z)this.a.get(0)).i();
    }
    throw new IllegalStateException();
  }
  
  public final Iterator<z> iterator()
  {
    return this.a.iterator();
  }
  
  public final byte j()
  {
    if (this.a.size() == 1) {
      return ((z)this.a.get(0)).j();
    }
    throw new IllegalStateException();
  }
  
  public final char k()
  {
    if (this.a.size() == 1) {
      return ((z)this.a.get(0)).k();
    }
    throw new IllegalStateException();
  }
  
  public final short l()
  {
    if (this.a.size() == 1) {
      return ((z)this.a.get(0)).l();
    }
    throw new IllegalStateException();
  }
  
  public final boolean m()
  {
    if (this.a.size() == 1) {
      return ((z)this.a.get(0)).m();
    }
    throw new IllegalStateException();
  }
  
  final Object n()
  {
    if (this.a.size() == 1) {
      return ((z)this.a.get(0)).n();
    }
    throw new IllegalStateException();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/a/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */