package com.lantern.wifitools.a;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public abstract class c
{
  public static a a = new d();
  public static b b = new e();
  public static b c = new f();
  
  public static Object a(Method paramMethod, Object paramObject, Object... paramVarArgs)
  {
    try
    {
      paramMethod = paramMethod.invoke(paramObject, paramVarArgs);
      return paramMethod;
    }
    catch (Exception paramMethod)
    {
      if ((paramMethod instanceof NoSuchMethodException)) {
        throw new IllegalStateException("Method not found: " + paramMethod.getMessage());
      }
      if ((paramMethod instanceof IllegalAccessException)) {
        throw new IllegalStateException("Could not access method: " + paramMethod.getMessage());
      }
      if ((paramMethod instanceof InvocationTargetException))
      {
        paramObject = ((InvocationTargetException)paramMethod).getTargetException();
        if ((paramObject instanceof RuntimeException)) {
          throw ((RuntimeException)paramObject);
        }
        if ((paramObject instanceof Error)) {
          throw ((Error)paramObject);
        }
        a((Throwable)paramObject);
      }
      if ((paramMethod instanceof RuntimeException)) {
        throw ((RuntimeException)paramMethod);
      }
      a(paramMethod);
      throw new IllegalStateException("Should never get here");
    }
  }
  
  public static Method a(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    a.a(paramClass, "Class must not be null");
    a.a(paramString, "Method name must not be null");
    Method[] arrayOfMethod;
    label29:
    int i;
    label36:
    Method localMethod;
    if (paramClass != null) {
      if (paramClass.isInterface())
      {
        arrayOfMethod = paramClass.getMethods();
        int j = arrayOfMethod.length;
        i = 0;
        if (i >= j) {
          break label92;
        }
        localMethod = arrayOfMethod[i];
        if ((!paramString.equals(localMethod.getName())) || (!Arrays.equals(paramVarArgs, localMethod.getParameterTypes()))) {
          break label86;
        }
      }
    }
    for (paramClass = localMethod;; paramClass = null)
    {
      return paramClass;
      arrayOfMethod = paramClass.getDeclaredMethods();
      break label29;
      label86:
      i++;
      break label36;
      label92:
      paramClass = paramClass.getSuperclass();
      break;
    }
  }
  
  private static void a(Throwable paramThrowable)
  {
    throw new IllegalStateException("Unexpected exception thrown", paramThrowable);
  }
  
  public static abstract interface a {}
  
  public static abstract interface b {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */