package com.alipay.b.f;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public final class g
{
  /* Error */
  public static String a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 8	java/lang/StringBuilder
    //   6: astore_2
    //   7: aload_2
    //   8: ldc 10
    //   10: invokespecial 14	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   13: aload_0
    //   14: ldc 16
    //   16: aload_2
    //   17: aload_1
    //   18: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 24	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: ldc 26
    //   26: invokestatic 31	com/alipay/c/a/a/d/d:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   29: astore_0
    //   30: aload_0
    //   31: invokestatic 36	com/alipay/c/a/a/a/a:a	(Ljava/lang/String;)Z
    //   34: ifeq +11 -> 45
    //   37: ldc 26
    //   39: astore_0
    //   40: ldc 2
    //   42: monitorexit
    //   43: aload_0
    //   44: areturn
    //   45: invokestatic 40	com/alipay/c/a/a/a/a/c:a	()Ljava/lang/String;
    //   48: aload_0
    //   49: invokestatic 44	com/alipay/c/a/a/a/a/c:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   52: astore_1
    //   53: aload_1
    //   54: astore_0
    //   55: aload_1
    //   56: invokestatic 36	com/alipay/c/a/a/a/a:a	(Ljava/lang/String;)Z
    //   59: ifeq -19 -> 40
    //   62: ldc 26
    //   64: astore_0
    //   65: goto -25 -> 40
    //   68: astore_0
    //   69: ldc 2
    //   71: monitorexit
    //   72: aload_0
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	paramContext	Context
    //   0	74	1	paramString	String
    //   6	11	2	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   3	37	68	finally
    //   45	53	68	finally
    //   55	62	68	finally
  }
  
  public static void a() {}
  
  public static void a(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("openapi_file_pri", 0).edit();
      if (paramContext != null)
      {
        paramContext.clear();
        paramContext.commit();
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ldc 16
    //   6: iconst_0
    //   7: invokevirtual 53	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   10: invokeinterface 59 1 0
    //   15: astore_3
    //   16: aload_3
    //   17: ifnull +42 -> 59
    //   20: new 8	java/lang/StringBuilder
    //   23: astore_0
    //   24: aload_0
    //   25: ldc 10
    //   27: invokespecial 14	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   30: aload_3
    //   31: aload_0
    //   32: aload_1
    //   33: invokevirtual 20	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 24	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 40	com/alipay/c/a/a/a/a/c:a	()Ljava/lang/String;
    //   42: aload_2
    //   43: invokestatic 73	com/alipay/c/a/a/a/a/c:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   46: invokeinterface 77 3 0
    //   51: pop
    //   52: aload_3
    //   53: invokeinterface 68 1 0
    //   58: pop
    //   59: ldc 2
    //   61: monitorexit
    //   62: return
    //   63: astore_0
    //   64: ldc 2
    //   66: monitorexit
    //   67: aload_0
    //   68: athrow
    //   69: astore_0
    //   70: goto -11 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	paramContext	Context
    //   0	73	1	paramString1	String
    //   0	73	2	paramString2	String
    //   15	38	3	localEditor	SharedPreferences.Editor
    // Exception table:
    //   from	to	target	type
    //   3	16	63	finally
    //   20	59	63	finally
    //   3	16	69	java/lang/Throwable
    //   20	59	69	java/lang/Throwable
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/b/f/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */