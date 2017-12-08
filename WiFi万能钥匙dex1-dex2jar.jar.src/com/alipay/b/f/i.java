package com.alipay.b.f;

import android.content.Context;
import com.alipay.b.c.a;
import java.util.HashMap;
import java.util.Map;

public final class i
{
  private static String a = "";
  private static String b = "";
  private static String c = "";
  private static String d = "";
  private static String e = "";
  private static Map f = new HashMap();
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 37	java/lang/StringBuilder
    //   6: astore_2
    //   7: aload_2
    //   8: ldc 39
    //   10: invokespecial 42	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   13: aload_2
    //   14: aload_0
    //   15: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   21: astore_0
    //   22: getstatic 33	com/alipay/b/f/i:f	Ljava/util/Map;
    //   25: aload_0
    //   26: invokeinterface 56 2 0
    //   31: ifeq +30 -> 61
    //   34: getstatic 33	com/alipay/b/f/i:f	Ljava/util/Map;
    //   37: aload_0
    //   38: invokeinterface 60 2 0
    //   43: checkcast 62	java/lang/String
    //   46: astore_0
    //   47: aload_0
    //   48: invokestatic 67	com/alipay/c/a/a/a/a:b	(Ljava/lang/String;)Z
    //   51: istore_1
    //   52: iload_1
    //   53: ifeq +8 -> 61
    //   56: ldc 2
    //   58: monitorexit
    //   59: aload_0
    //   60: areturn
    //   61: ldc 16
    //   63: astore_0
    //   64: goto -8 -> 56
    //   67: astore_0
    //   68: ldc 2
    //   70: monitorexit
    //   71: aload_0
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	paramString	String
    //   51	2	1	bool	boolean
    //   6	8	2	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   3	52	67	finally
  }
  
  public static void a() {}
  
  public static void a(b paramb)
  {
    if (paramb != null) {}
    try
    {
      a = paramb.a();
      b = paramb.b();
      c = paramb.c();
      return;
    }
    finally
    {
      paramb = finally;
      throw paramb;
    }
  }
  
  public static void a(c paramc)
  {
    if (paramc != null) {}
    try
    {
      a = paramc.a();
      b = paramc.b();
      d = paramc.d();
      e = paramc.e();
      c = paramc.c();
      return;
    }
    finally
    {
      paramc = finally;
      throw paramc;
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    try
    {
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>("apdidTokenCache");
      paramString1 = paramString1;
      if (f.containsKey(paramString1)) {
        f.remove(paramString1);
      }
      f.put(paramString1, paramString2);
      return;
    }
    finally {}
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    long l1 = 86400000L;
    for (;;)
    {
      long l2;
      try
      {
        l2 = h.a(paramContext);
        if (l2 >= 0L) {
          break label72;
        }
      }
      catch (Throwable localThrowable)
      {
        boolean bool;
        continue;
      }
      finally {}
      try
      {
        l2 = Math.abs(System.currentTimeMillis() - h.g(paramContext, paramString));
        if (l2 >= l1) {
          continue;
        }
        bool = true;
      }
      catch (Throwable paramContext)
      {
        a.a(paramContext);
        bool = false;
        continue;
      }
      return bool;
      label72:
      l1 = l2;
    }
  }
  
  public static String b()
  {
    try
    {
      String str = a;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void b(String paramString)
  {
    a = paramString;
  }
  
  public static String c()
  {
    try
    {
      String str = b;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void c(String paramString)
  {
    b = paramString;
  }
  
  public static String d()
  {
    try
    {
      String str = d;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void d(String paramString)
  {
    c = paramString;
  }
  
  public static String e()
  {
    try
    {
      String str = e;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void e(String paramString)
  {
    d = paramString;
  }
  
  public static String f()
  {
    try
    {
      String str = c;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void f(String paramString)
  {
    e = paramString;
  }
  
  public static c g()
  {
    try
    {
      c localc = new c(a, b, c, d, e);
      return localc;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void h()
  {
    f.clear();
    a = "";
    b = "";
    d = "";
    e = "";
    c = "";
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/b/f/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */