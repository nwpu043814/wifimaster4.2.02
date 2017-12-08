package com.linksure.apservice.utils;

import com.linksure.apservice.c.b;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public final class i<T>
  implements InvocationHandler
{
  private boolean a;
  private WeakReference<T> b;
  
  private i(T paramT)
  {
    this.b = new WeakReference(paramT);
  }
  
  public static <T extends b> T a(Class<? extends b> paramClass, T paramT)
  {
    ClassLoader localClassLoader = paramClass.getClassLoader();
    paramT = new i(paramT);
    return (b)Proxy.newProxyInstance(localClassLoader, new Class[] { paramClass }, paramT);
  }
  
  public static i a(Object paramObject)
  {
    return (i)Proxy.getInvocationHandler(paramObject);
  }
  
  public final void a()
  {
    this.a = true;
  }
  
  public final void b()
  {
    this.a = false;
  }
  
  public final Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    if ((this.a) && (this.b.get() != null)) {}
    for (paramObject = paramMethod.invoke(this.b.get(), paramArrayOfObject);; paramObject = null) {
      return paramObject;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/utils/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */