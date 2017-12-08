package com.b.a;

import com.b.a.b.b;
import java.lang.reflect.Array;
import java.lang.reflect.Type;

final class t<T>
  extends w<T>
{
  t(s params, Type paramType, av paramav, m paramm, au paramau, ay<x<?>> paramay, u paramu)
  {
    super(params, paramType, paramav, paramm, paramau, paramay, paramu);
  }
  
  protected final T a()
  {
    if (!(this.f instanceof s)) {
      throw new ae("Expecting array found: " + this.f);
    }
    Object localObject = this.f.p();
    if (b.d(this.g)) {}
    for (localObject = this.c.a(b.e(this.g), ((s)localObject).a());; localObject = this.c.a(b.b(this.g))) {
      return (T)localObject;
    }
  }
  
  public final void a(l paraml, Type paramType, Object paramObject)
  {
    throw new ae("Expecting array but found array field " + paraml.a() + ": " + paramObject);
  }
  
  public final void a(Object paramObject)
  {
    throw new ae("Expecting array but found object: " + paramObject);
  }
  
  public final void a(Object paramObject, Type paramType)
  {
    if (!(this.f instanceof s)) {
      throw new ae("Expecting array found: " + this.f);
    }
    s locals = this.f.p();
    int i = 0;
    if (i < locals.a())
    {
      Object localObject = locals.a(i);
      if ((localObject == null) || ((localObject instanceof ab))) {
        localObject = null;
      }
      for (;;)
      {
        Array.set(paramObject, i, localObject);
        i++;
        break;
        if ((localObject instanceof ac))
        {
          localObject = a(b.e(paramType), (z)localObject);
        }
        else if ((localObject instanceof s))
        {
          localObject = a(b.e(paramType), ((z)localObject).p());
        }
        else
        {
          if (!(localObject instanceof ag)) {
            break label169;
          }
          localObject = a(b.e(paramType), ((z)localObject).q());
        }
      }
      label169:
      throw new IllegalStateException();
    }
  }
  
  public final void b(l paraml, Type paramType, Object paramObject)
  {
    throw new ae("Expecting array but found object field " + paraml.a() + ": " + paramObject);
  }
  
  public final void b(Object paramObject)
  {
    throw new ae("Type information is unavailable, and the target is not a primitive: " + this.f);
  }
  
  public final boolean c(l paraml, Type paramType, Object paramObject)
  {
    throw new ae("Expecting array but found field " + paraml.a() + ": " + paramObject);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/a/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */