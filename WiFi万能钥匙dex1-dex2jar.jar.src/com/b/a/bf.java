package com.b.a;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

abstract class bf
{
  public static bf a()
  {
    try
    {
      Object localObject1 = Class.forName("sun.misc.Unsafe");
      localObject3 = ((Class)localObject1).getDeclaredField("theUnsafe");
      ((Field)localObject3).setAccessible(true);
      localObject3 = ((Field)localObject3).get(null);
      Method localMethod = ((Class)localObject1).getMethod("allocateInstance", new Class[] { Class.class });
      localObject1 = new com/b/a/bg;
      ((bg)localObject1).<init>(localMethod, localObject3);
      return (bf)localObject1;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          localObject3 = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[] { Class.class, Class.class });
          ((Method)localObject3).setAccessible(true);
          bh localbh = new com/b/a/bh;
          localbh.<init>((Method)localObject3);
        }
        catch (Exception localException2)
        {
          try
          {
            Object localObject2 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[] { Class.class });
            ((Method)localObject2).setAccessible(true);
            int i = ((Integer)((Method)localObject2).invoke(null, new Object[] { Object.class })).intValue();
            Object localObject3 = ObjectStreamClass.class.getDeclaredMethod("newInstance", new Class[] { Class.class, Integer.TYPE });
            ((Method)localObject3).setAccessible(true);
            localObject2 = new com/b/a/bi;
            ((bi)localObject2).<init>((Method)localObject3, i);
          }
          catch (Exception localException3)
          {
            bj localbj = new bj();
          }
        }
      }
    }
  }
  
  public abstract <T> T a(Class<T> paramClass);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/a/bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */