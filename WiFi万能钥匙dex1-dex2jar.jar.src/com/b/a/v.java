package com.b.a;

import java.lang.reflect.Type;

final class v
  implements u
{
  private final av a;
  private final m b;
  private final ay<x<?>> c;
  private final aq d;
  
  v(av paramav, m paramm, ay<x<?>> paramay, aq paramaq)
  {
    this.a = paramav;
    this.b = paramm;
    this.c = paramay;
    this.d = paramaq;
  }
  
  final au a()
  {
    return this.d;
  }
  
  public final <T> T a(z paramz, Type paramType)
  {
    if ((paramz == null) || ((paramz instanceof ab))) {
      paramz = null;
    }
    for (;;)
    {
      return paramz;
      if ((paramz instanceof s))
      {
        paramz = new t(paramz.p(), paramType, this.a, this.b, this.d, this.c, this);
        this.a.a(new aw(null, paramType, true), paramz);
        paramz = paramz.b();
      }
      else if ((paramz instanceof ac))
      {
        paramz = new ad(paramz.o(), paramType, this.a, this.b, this.d, this.c, this);
        this.a.a(new aw(null, paramType, true), paramz);
        paramz = paramz.b();
      }
      else
      {
        if (!(paramz instanceof ag)) {
          break;
        }
        paramz = paramz.q();
        ad localad = new ad(paramz, paramType, this.a, this.b, this.d, this.c, this);
        this.a.a(new aw(paramz.n(), paramType, true), localad);
        paramz = localad.b();
      }
    }
    throw new ae("Failed parsing JSON source: " + paramz + " to Json");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/a/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */