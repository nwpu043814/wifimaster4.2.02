package com.wifipay.common.eventbus;

import java.lang.reflect.Method;

public class m
{
  final Method a;
  final ThreadMode b;
  final Class c;
  final int d;
  final boolean e;
  String f;
  
  public m(Method paramMethod, Class paramClass, ThreadMode paramThreadMode, int paramInt, boolean paramBoolean)
  {
    this.a = paramMethod;
    this.b = paramThreadMode;
    this.c = paramClass;
    this.d = paramInt;
    this.e = paramBoolean;
  }
  
  private void a()
  {
    try
    {
      if (this.f == null)
      {
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>(64);
        localStringBuilder.append(this.a.getDeclaringClass().getName());
        localStringBuilder.append('#').append(this.a.getName());
        localStringBuilder.append('(').append(this.c.getName());
        this.f = localStringBuilder.toString();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if (paramObject == this) {
      bool = true;
    }
    for (;;)
    {
      return bool;
      if ((paramObject instanceof m))
      {
        a();
        paramObject = (m)paramObject;
        ((m)paramObject).a();
        bool = this.f.equals(((m)paramObject).f);
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/common/eventbus/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */