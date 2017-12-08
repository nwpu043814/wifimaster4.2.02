package com.b.a;

import java.lang.reflect.Constructor;

final class e
{
  private static final Constructor<a> a = ;
  private final c<Class<?>, Constructor<?>> b;
  
  public e()
  {
    this(200);
  }
  
  public e(int paramInt)
  {
    this.b = new an(paramInt);
  }
  
  private static final Constructor<a> a()
  {
    try
    {
      Constructor localConstructor = b(a.class);
      return localConstructor;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
  }
  
  private static <T> Constructor<T> b(Class<T> paramClass)
  {
    try
    {
      paramClass = paramClass.getDeclaredConstructor(new Class[0]);
      paramClass.setAccessible(true);
      return paramClass;
    }
    catch (Exception paramClass)
    {
      for (;;)
      {
        paramClass = null;
      }
    }
  }
  
  public final <T> T a(Class<T> paramClass)
  {
    Constructor localConstructor = (Constructor)this.b.a(paramClass);
    if (localConstructor != null)
    {
      paramClass = localConstructor;
      if (localConstructor == a) {
        paramClass = null;
      }
      if (paramClass == null) {
        break label87;
      }
    }
    label87:
    for (paramClass = paramClass.newInstance(new Object[0]);; paramClass = null)
    {
      return paramClass;
      localConstructor = b(paramClass);
      if (localConstructor != null)
      {
        this.b.a(paramClass, localConstructor);
        paramClass = localConstructor;
        break;
      }
      this.b.a(paramClass, a);
      paramClass = localConstructor;
      break;
    }
  }
  
  private static final class a {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */