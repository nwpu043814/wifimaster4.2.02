package com.lantern.wifitools.a;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public final class b
{
  public static Object a(Object paramObject, String paramString)
  {
    int k = 0;
    a.a(paramObject, "[Assertion failed] - this argument is required; it must not be null");
    int i;
    int m;
    if (paramString.length() > 0)
    {
      j = 1;
      i = k;
      if (j != 0) {
        m = paramString.length();
      }
    }
    for (int j = 0;; j++)
    {
      i = k;
      if (j < m)
      {
        if (!Character.isWhitespace(paramString.charAt(j))) {
          i = 1;
        }
      }
      else
      {
        if (i != 0) {
          break label86;
        }
        throw new IllegalArgumentException("[Assertion failed] - this String argument must have text; it must not be null, empty, or blank");
        j = 0;
        break;
      }
    }
    label86:
    paramString = paramObject.getClass().getDeclaredField(paramString);
    paramString.setAccessible(true);
    return paramString.get(paramObject);
  }
  
  private static Field a(Class paramClass, String paramString)
  {
    if (paramClass != Object.class) {}
    for (;;)
    {
      try
      {
        Field localField = paramClass.getDeclaredField(paramString);
        paramClass = localField;
        return paramClass;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        paramClass = paramClass.getSuperclass();
      }
      break;
      paramClass = null;
    }
  }
  
  public static void a(Object paramObject1, String paramString, Object paramObject2)
  {
    Field localField = a(paramObject1.getClass(), paramString);
    if (localField == null) {
      throw new IllegalArgumentException("Could not find field [" + paramString + "] on target [" + paramObject1 + "]");
    }
    if ((!Modifier.isPublic(localField.getModifiers())) || (!Modifier.isPublic(localField.getDeclaringClass().getModifiers()))) {
      localField.setAccessible(true);
    }
    try
    {
      localField.set(paramObject1, paramObject2);
      return;
    }
    catch (IllegalAccessException paramObject1)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */