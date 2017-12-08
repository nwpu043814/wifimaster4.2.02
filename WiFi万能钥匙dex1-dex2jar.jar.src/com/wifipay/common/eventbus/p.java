package com.wifipay.common.eventbus;

final class p
{
  final Object a;
  final m b;
  volatile boolean c;
  
  p(Object paramObject, m paramm)
  {
    this.a = paramObject;
    this.b = paramm;
    this.c = true;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof p))
    {
      paramObject = (p)paramObject;
      bool1 = bool2;
      if (this.a == ((p)paramObject).a)
      {
        bool1 = bool2;
        if (this.b.equals(((p)paramObject).b)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public final int hashCode()
  {
    return this.a.hashCode() + this.b.f.hashCode();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/common/eventbus/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */