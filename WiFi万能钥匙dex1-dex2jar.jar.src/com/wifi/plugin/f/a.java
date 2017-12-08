package com.wifi.plugin.f;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public final class a
{
  private final Object a;
  private final boolean b;
  
  private a(Class<?> paramClass)
  {
    this.a = paramClass;
    this.b = true;
  }
  
  private a(Object paramObject)
  {
    this.a = paramObject;
    this.b = false;
  }
  
  public static a a(Object paramObject)
  {
    return new a(paramObject);
  }
  
  public static a a(String paramString)
  {
    return new a(f(paramString));
  }
  
  /* Error */
  private static a a(Method paramMethod, Object paramObject, Object... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 39	com/wifi/plugin/f/a:a	(Ljava/lang/reflect/AccessibleObject;)Ljava/lang/reflect/AccessibleObject;
    //   4: pop
    //   5: aload_0
    //   6: invokevirtual 45	java/lang/reflect/Method:getReturnType	()Ljava/lang/Class;
    //   9: getstatic 51	java/lang/Void:TYPE	Ljava/lang/Class;
    //   12: if_acmpne +17 -> 29
    //   15: aload_0
    //   16: aload_1
    //   17: aload_2
    //   18: invokevirtual 55	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   21: pop
    //   22: aload_1
    //   23: invokestatic 57	com/wifi/plugin/f/a:a	(Ljava/lang/Object;)Lcom/wifi/plugin/f/a;
    //   26: astore_0
    //   27: aload_0
    //   28: areturn
    //   29: aload_0
    //   30: aload_1
    //   31: aload_2
    //   32: invokevirtual 55	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   35: invokestatic 57	com/wifi/plugin/f/a:a	(Ljava/lang/Object;)Lcom/wifi/plugin/f/a;
    //   38: astore_0
    //   39: goto -12 -> 27
    //   42: astore_0
    //   43: new 59	com/wifi/plugin/f/b
    //   46: dup
    //   47: aload_0
    //   48: invokespecial 62	com/wifi/plugin/f/b:<init>	(Ljava/lang/Throwable;)V
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	paramMethod	Method
    //   0	52	1	paramObject	Object
    //   0	52	2	paramVarArgs	Object[]
    // Exception table:
    //   from	to	target	type
    //   0	27	42	java/lang/Exception
    //   29	39	42	java/lang/Exception
  }
  
  private static Class<?> a(Class<?> paramClass)
  {
    Object localObject;
    if (paramClass == null) {
      localObject = null;
    }
    for (;;)
    {
      return (Class<?>)localObject;
      localObject = paramClass;
      if (paramClass.isPrimitive()) {
        if (Boolean.TYPE == paramClass)
        {
          localObject = Boolean.class;
        }
        else if (Integer.TYPE == paramClass)
        {
          localObject = Integer.class;
        }
        else if (Long.TYPE == paramClass)
        {
          localObject = Long.class;
        }
        else if (Short.TYPE == paramClass)
        {
          localObject = Short.class;
        }
        else if (Byte.TYPE == paramClass)
        {
          localObject = Byte.class;
        }
        else if (Double.TYPE == paramClass)
        {
          localObject = Double.class;
        }
        else if (Float.TYPE == paramClass)
        {
          localObject = Float.class;
        }
        else if (Character.TYPE == paramClass)
        {
          localObject = Character.class;
        }
        else
        {
          localObject = paramClass;
          if (Void.TYPE == paramClass) {
            localObject = Void.class;
          }
        }
      }
    }
  }
  
  private static <T extends AccessibleObject> T a(T paramT)
  {
    T ?;
    if (paramT == null) {
      ? = null;
    }
    for (;;)
    {
      return ?;
      if ((paramT instanceof Member))
      {
        Member localMember = (Member)paramT;
        if (Modifier.isPublic(localMember.getModifiers()))
        {
          ? = paramT;
          if (Modifier.isPublic(localMember.getDeclaringClass().getModifiers())) {
            continue;
          }
        }
      }
      ? = paramT;
      if (!paramT.isAccessible())
      {
        paramT.setAccessible(true);
        ? = paramT;
      }
    }
  }
  
  private Method a(String paramString, Class<?>[] paramArrayOfClass)
  {
    localObject = b();
    try
    {
      Method localMethod1 = ((Class)localObject).getMethod(paramString, paramArrayOfClass);
      paramString = localMethod1;
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      Class localClass;
      do
      {
        try
        {
          Method localMethod2 = ((Class)localObject).getDeclaredMethod(paramString, paramArrayOfClass);
          paramString = localMethod2;
        }
        catch (NoSuchMethodException localNoSuchMethodException2)
        {
          localClass = ((Class)localObject).getSuperclass();
          localObject = localClass;
        }
      } while (localClass != null);
      throw new NoSuchMethodException();
    }
    return paramString;
  }
  
  private static boolean a(Method paramMethod, String paramString, Class<?>[] paramArrayOfClass)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMethod.getName().equals(paramString))
    {
      paramMethod = paramMethod.getParameterTypes();
      if (paramMethod.length != paramArrayOfClass.length) {
        break label86;
      }
      i = 0;
      if (i < paramArrayOfClass.length) {
        break label54;
      }
    }
    label54:
    label86:
    for (int i = 1;; i = 0)
    {
      bool1 = bool2;
      if (i != 0) {
        bool1 = true;
      }
      return bool1;
      if ((paramArrayOfClass[i] == a.class) || (a(paramMethod[i]).isAssignableFrom(a(paramArrayOfClass[i]))))
      {
        i++;
        break;
      }
    }
  }
  
  private static Class<?>[] a(Object... paramVarArgs)
  {
    int i = 0;
    if (paramVarArgs == null) {}
    Class[] arrayOfClass;
    for (paramVarArgs = new Class[0];; paramVarArgs = arrayOfClass)
    {
      return paramVarArgs;
      arrayOfClass = new Class[paramVarArgs.length];
      if (i < paramVarArgs.length) {
        break;
      }
    }
    Object localObject = paramVarArgs[i];
    if (localObject == null) {}
    for (localObject = a.class;; localObject = localObject.getClass())
    {
      arrayOfClass[i] = localObject;
      i++;
      break;
    }
  }
  
  private Class<?> b()
  {
    if (this.b) {}
    for (Class localClass = (Class)this.a;; localClass = this.a.getClass()) {
      return localClass;
    }
  }
  
  private Method b(String paramString, Class<?>[] paramArrayOfClass)
  {
    Class localClass = b();
    Method[] arrayOfMethod = localClass.getMethods();
    int j = arrayOfMethod.length;
    int i = 0;
    Object localObject;
    if (i >= j)
    {
      localObject = localClass;
      label30:
      arrayOfMethod = ((Class)localObject).getDeclaredMethods();
      j = arrayOfMethod.length;
    }
    label168:
    for (i = 0;; i++)
    {
      if (i >= j)
      {
        localClass = ((Class)localObject).getSuperclass();
        localObject = localClass;
        if (localClass != null) {
          break label30;
        }
        throw new NoSuchMethodException("No similar method " + paramString + " with params " + Arrays.toString(paramArrayOfClass) + " could be found on type " + b() + ".");
        localObject = arrayOfMethod[i];
        if (!a((Method)localObject, paramString, paramArrayOfClass)) {}
      }
      for (paramString = (String)localObject;; paramString = localClass)
      {
        return paramString;
        i++;
        break;
        localClass = arrayOfMethod[i];
        if (!a(localClass, paramString, paramArrayOfClass)) {
          break label168;
        }
      }
    }
  }
  
  private a d(String paramString)
  {
    try
    {
      paramString = a(e(paramString).get(this.a));
      return paramString;
    }
    catch (Exception paramString)
    {
      throw new b(paramString);
    }
  }
  
  private Field e(String paramString)
  {
    Class localClass = b();
    Field localField;
    try
    {
      localField = localClass.getField(paramString);
      paramString = localField;
      return paramString;
    }
    catch (NoSuchFieldException localNoSuchFieldException2) {}
    for (;;)
    {
      try
      {
        localField = (Field)a(localClass.getDeclaredField(paramString));
        paramString = localField;
      }
      catch (NoSuchFieldException localNoSuchFieldException1)
      {
        localClass = localClass.getSuperclass();
        if (localClass == null) {
          throw new b(localNoSuchFieldException2);
        }
      }
    }
  }
  
  private static Class<?> f(String paramString)
  {
    try
    {
      paramString = Class.forName(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      throw new b(paramString);
    }
  }
  
  public final a a(String paramString, Object paramObject)
  {
    try
    {
      Field localField = e(paramString);
      Object localObject = this.a;
      paramString = (String)paramObject;
      if ((paramObject instanceof a)) {
        paramString = ((a)paramObject).a;
      }
      localField.set(localObject, paramString);
      return this;
    }
    catch (Exception paramString)
    {
      throw new b(paramString);
    }
  }
  
  public final a a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    arrayOfClass = a(paramVarArgs);
    try
    {
      arrayOfClass[(paramVarArgs.length - 1)] = Class.forName(paramString2);
      try
      {
        paramString2 = a(a(paramString1, arrayOfClass), this.a, paramVarArgs);
        paramString1 = paramString2;
      }
      catch (NoSuchMethodException paramString2)
      {
        try
        {
          paramString1 = a(b(paramString1, arrayOfClass), this.a, paramVarArgs);
        }
        catch (NoSuchMethodException paramString1)
        {
          throw new b(paramString1);
        }
      }
      return paramString1;
    }
    catch (ClassNotFoundException paramString2)
    {
      for (;;)
      {
        paramString2.printStackTrace();
      }
    }
  }
  
  public final a a(String paramString, Object... paramVarArgs)
  {
    arrayOfClass = a(paramVarArgs);
    try
    {
      a locala = a(a(paramString, arrayOfClass), this.a, paramVarArgs);
      paramString = locala;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      try
      {
        paramString = a(b(paramString, arrayOfClass), this.a, paramVarArgs);
      }
      catch (NoSuchMethodException paramString)
      {
        throw new b(paramString);
      }
    }
    return paramString;
  }
  
  public final <T> T a()
  {
    return (T)this.a;
  }
  
  public final a b(String paramString1, String paramString2, Object... paramVarArgs)
  {
    arrayOfClass = a(paramVarArgs);
    try
    {
      arrayOfClass[14] = Class.forName(paramString2);
      try
      {
        paramString2 = a(a(paramString1, arrayOfClass), this.a, paramVarArgs);
        paramString1 = paramString2;
      }
      catch (NoSuchMethodException paramString2)
      {
        try
        {
          paramString1 = a(b(paramString1, arrayOfClass), this.a, paramVarArgs);
        }
        catch (NoSuchMethodException paramString1)
        {
          throw new b(paramString1);
        }
      }
      return paramString1;
    }
    catch (ClassNotFoundException paramString2)
    {
      for (;;)
      {
        paramString2.printStackTrace();
      }
    }
  }
  
  public final <T> T b(String paramString)
  {
    return (T)d(paramString).a;
  }
  
  public final a c(String paramString)
  {
    return a(paramString, new Object[0]);
  }
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof a)) {}
    for (boolean bool = this.a.equals(((a)paramObject).a);; bool = false) {
      return bool;
    }
  }
  
  public final int hashCode()
  {
    return this.a.hashCode();
  }
  
  public final String toString()
  {
    return this.a.toString();
  }
  
  private static class a {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/plugin/f/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */