package com.alipay.android.a.a.a;

import java.lang.reflect.Proxy;

public final class c
{
  private o a;
  private e b;
  
  public c(o paramo)
  {
    this.a = paramo;
    this.b = new e(this);
  }
  
  public final o a()
  {
    return this.a;
  }
  
  public final Object a(Class paramClass)
  {
    ClassLoader localClassLoader = paramClass.getClassLoader();
    d locald = new d(this.a, paramClass, this.b);
    return Proxy.newProxyInstance(localClassLoader, new Class[] { paramClass }, locald);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/android/a/a/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */