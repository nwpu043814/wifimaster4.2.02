package com.alipay.android.a.a.a;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public final class d
  implements InvocationHandler
{
  protected o a;
  protected Class b;
  protected e c;
  
  public d(o paramo, Class paramClass, e parame)
  {
    this.a = paramo;
    this.b = paramClass;
    this.c = parame;
  }
  
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    return this.c.a(paramMethod, paramArrayOfObject);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/android/a/a/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */