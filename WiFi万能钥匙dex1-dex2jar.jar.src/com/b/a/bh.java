package com.b.a;

import java.lang.reflect.Method;

final class bh
  extends bf
{
  bh(Method paramMethod) {}
  
  public final <T> T a(Class<T> paramClass)
  {
    return (T)this.a.invoke(null, new Object[] { paramClass, Object.class });
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/a/bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */