package com.b.a;

import com.b.a.b.a;
import java.lang.reflect.Type;

abstract class w<T>
  implements av.a
{
  protected final av a;
  protected final m b;
  protected final au c;
  protected final ay<x<?>> d;
  protected T e;
  protected final z f;
  protected final Type g;
  protected final u h;
  protected boolean i;
  
  w(z paramz, Type paramType, av paramav, m paramm, au paramau, ay<x<?>> paramay, u paramu)
  {
    this.g = paramType;
    this.a = paramav;
    this.b = paramm;
    this.c = paramau;
    this.d = paramay;
    this.f = ((z)a.a(paramz));
    this.h = paramu;
    this.i = false;
  }
  
  private Object a(Type paramType, w<?> paramw)
  {
    this.a.a(new aw(null, paramType, false), paramw);
    return paramw.b();
  }
  
  protected abstract T a();
  
  protected final Object a(z paramz, ax<x<?>, aw> paramax)
  {
    if ((paramz == null) || ((paramz instanceof ab))) {}
    Type localType;
    for (paramz = null;; paramz = ((x)paramax.a).a(paramz, localType, this.h))
    {
      return paramz;
      localType = ((aw)paramax.b).a;
    }
  }
  
  final Object a(Type paramType, s params)
  {
    return a(paramType, new t(params.p(), paramType, this.a, this.b, this.c, this.d, this.h));
  }
  
  final Object a(Type paramType, z paramz)
  {
    return a(paramType, new ad(paramz, paramType, this.a, this.b, this.c, this.d, this.h));
  }
  
  public final void a(aw paramaw) {}
  
  public final T b()
  {
    if (!this.i)
    {
      this.e = a();
      this.i = true;
    }
    return (T)this.e;
  }
  
  public final void b(aw paramaw) {}
  
  public final boolean c(aw paramaw)
  {
    boolean bool = true;
    paramaw = paramaw.a(this.d);
    if (paramaw == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      this.e = a(this.f, paramaw);
      this.i = true;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/a/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */