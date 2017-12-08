package com.lantern.webox.c;

import java.lang.reflect.Method;

public final class d
{
  public static Object a(Object paramObject, Class<?> paramClass, String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    try
    {
      paramClass = paramClass.getDeclaredMethod(paramString, paramArrayOfClass);
      paramClass.setAccessible(true);
      paramObject = paramClass.invoke(paramObject, paramArrayOfObject);
      return paramObject;
    }
    catch (Exception paramObject)
    {
      throw new RuntimeException((Throwable)paramObject);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */