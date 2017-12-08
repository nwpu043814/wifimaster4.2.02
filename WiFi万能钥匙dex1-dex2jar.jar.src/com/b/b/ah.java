package com.b.b;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

final class ah
{
  private static final Unsafe a = ;
  private static final boolean b = f();
  private static final boolean c;
  private static final long d;
  private static final long e;
  
  static
  {
    boolean bool = e();
    c = bool;
    int i;
    Field localField;
    if (bool)
    {
      i = a.arrayBaseOffset(byte[].class);
      d = i;
      localField = a(Buffer.class, "address");
      if ((localField != null) && (a != null)) {
        break label72;
      }
    }
    label72:
    for (long l = -1L;; l = a.objectFieldOffset(localField))
    {
      e = l;
      return;
      i = -1;
      break;
    }
  }
  
  static byte a(byte[] paramArrayOfByte, long paramLong)
  {
    return a.getByte(paramArrayOfByte, paramLong);
  }
  
  private static Field a(Class<?> paramClass, String paramString)
  {
    try
    {
      paramClass = paramClass.getDeclaredField(paramString);
      paramClass.setAccessible(true);
      return paramClass;
    }
    catch (Throwable paramClass)
    {
      for (;;)
      {
        paramClass = null;
      }
    }
  }
  
  static void a(byte[] paramArrayOfByte, long paramLong, byte paramByte)
  {
    a.putByte(paramArrayOfByte, paramLong, paramByte);
  }
  
  static boolean a()
  {
    return c;
  }
  
  static long b(byte[] paramArrayOfByte, long paramLong)
  {
    return a.getLong(paramArrayOfByte, paramLong);
  }
  
  static boolean b()
  {
    return b;
  }
  
  static long c()
  {
    return d;
  }
  
  private static Unsafe d()
  {
    try
    {
      Object localObject1 = new com/b/b/ai;
      ((ai)localObject1).<init>();
      localObject1 = (Unsafe)AccessController.doPrivileged((PrivilegedExceptionAction)localObject1);
      return (Unsafe)localObject1;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject2 = null;
      }
    }
  }
  
  private static boolean e()
  {
    boolean bool = true;
    if (a != null) {}
    for (;;)
    {
      try
      {
        Class localClass = a.getClass();
        localClass.getMethod("arrayBaseOffset", new Class[] { Class.class });
        localClass.getMethod("getByte", new Class[] { Object.class, Long.TYPE });
        localClass.getMethod("putByte", new Class[] { Object.class, Long.TYPE, Byte.TYPE });
        localClass.getMethod("getLong", new Class[] { Object.class, Long.TYPE });
        localClass.getMethod("copyMemory", new Class[] { Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE });
        return bool;
      }
      catch (Throwable localThrowable) {}
      bool = false;
    }
  }
  
  private static boolean f()
  {
    boolean bool = true;
    if (a != null) {}
    for (;;)
    {
      try
      {
        Class localClass = a.getClass();
        localClass.getMethod("objectFieldOffset", new Class[] { Field.class });
        localClass.getMethod("getByte", new Class[] { Long.TYPE });
        localClass.getMethod("getLong", new Class[] { Object.class, Long.TYPE });
        localClass.getMethod("putByte", new Class[] { Long.TYPE, Byte.TYPE });
        localClass.getMethod("getLong", new Class[] { Long.TYPE });
        localClass.getMethod("copyMemory", new Class[] { Long.TYPE, Long.TYPE, Long.TYPE });
        return bool;
      }
      catch (Throwable localThrowable) {}
      bool = false;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/b/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */