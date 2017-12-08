package com.b.a;

import java.lang.reflect.Type;

final class ai
  implements ah
{
  private final av a;
  private final m b;
  private final ay<ak<?>> c;
  private final boolean d;
  private final ar e;
  
  ai(av paramav, m paramm, boolean paramBoolean, ay<ak<?>> paramay)
  {
    this.a = paramav;
    this.b = paramm;
    this.d = paramBoolean;
    this.c = paramay;
    this.e = new ar();
  }
  
  public final z a(Object paramObject, Type paramType)
  {
    return a(paramObject, paramType, true);
  }
  
  final z a(Object paramObject, Type paramType, boolean paramBoolean)
  {
    if (paramObject == null) {}
    aj localaj;
    for (paramObject = ab.a();; paramObject = localaj.a())
    {
      return (z)paramObject;
      localaj = new aj(this.a, this.b, this.d, this.c, this, this.e);
      this.a.a(new aw(paramObject, paramType, paramBoolean), localaj);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/a/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */