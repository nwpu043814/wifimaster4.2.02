package com.b.a;

import java.lang.reflect.Type;

final class ad<T>
  extends w<T>
{
  ad(z paramz, Type paramType, av paramav, m paramm, au paramau, ay<x<?>> paramay, u paramu)
  {
    super(paramz, paramType, paramav, paramm, paramau, paramay, paramu);
  }
  
  private String a(l paraml)
  {
    return this.b.a(paraml);
  }
  
  protected final T a()
  {
    return (T)this.c.a(this.g);
  }
  
  public final void a(l paraml, Type paramType, Object paramObject)
  {
    try
    {
      if (!(this.f instanceof ac))
      {
        paramType = new com/b/a/ae;
        paraml = new java/lang/StringBuilder;
        paraml.<init>("Expecting object found: ");
        paramType.<init>(this.f);
        throw paramType;
      }
    }
    catch (IllegalAccessException paraml)
    {
      throw new RuntimeException(paraml);
    }
    s locals = (s)this.f.o().a(a(paraml));
    if (locals != null) {
      paraml.a(paramObject, a(paramType, locals));
    }
    for (;;)
    {
      return;
      paraml.a(paramObject, null);
    }
  }
  
  public final void a(Object paramObject) {}
  
  public final void a(Object paramObject, Type paramType)
  {
    throw new ae("Expecting object but found array: " + paramObject);
  }
  
  public final void b(l paraml, Type paramType, Object paramObject)
  {
    try
    {
      if (!(this.f instanceof ac))
      {
        paramType = new com/b/a/ae;
        paraml = new java/lang/StringBuilder;
        paraml.<init>("Expecting object found: ");
        paramType.<init>(this.f);
        throw paramType;
      }
    }
    catch (IllegalAccessException paraml)
    {
      throw new RuntimeException(paraml);
    }
    z localz = this.f.o().a(a(paraml));
    if (localz != null) {
      paraml.a(paramObject, a(paramType, localz));
    }
    for (;;)
    {
      return;
      paraml.a(paramObject, null);
    }
  }
  
  public final void b(Object paramObject)
  {
    if (!(this.f instanceof ag)) {
      throw new ae("Type information is unavailable, and the target object is not a primitive: " + this.f);
    }
    this.e = this.f.q().n();
  }
  
  public final boolean c(l paraml, Type paramType, Object paramObject)
  {
    boolean bool2 = true;
    try
    {
      localObject = a(paraml);
      if (!(this.f instanceof ac))
      {
        paraml = new com/b/a/ae;
        paramType = new java/lang/StringBuilder;
        paramType.<init>("Expecting object found: ");
        paraml.<init>(this.f);
        throw paraml;
      }
    }
    catch (IllegalAccessException paraml)
    {
      throw new RuntimeException();
    }
    Object localObject = this.f.o().a((String)localObject);
    boolean bool3 = az.a(paramType);
    boolean bool1;
    if (localObject == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      if ((localObject instanceof ab))
      {
        bool1 = bool2;
        if (!bool3)
        {
          paraml.a(paramObject, null);
          bool1 = bool2;
        }
      }
      else
      {
        aw localaw = new com/b/a/aw;
        localaw.<init>(null, paramType, false);
        paramType = localaw.a(this.d);
        if (paramType == null)
        {
          bool1 = false;
        }
        else
        {
          paramType = a((z)localObject, paramType);
          if (paramType == null)
          {
            bool1 = bool2;
            if (bool3) {}
          }
          else
          {
            paraml.a(paramObject, paramType);
            bool1 = bool2;
          }
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/a/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */