package com.alipay.sdk.c;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public final class c
{
  private static c d;
  public String a;
  public String b = "sdk-and-lite";
  public String c;
  
  public static c a()
  {
    try
    {
      if (d == null)
      {
        localc = new com/alipay/sdk/c/c;
        localc.<init>();
        d = localc;
      }
      c localc = d;
      return localc;
    }
    finally {}
  }
  
  static String a(Context paramContext, HashMap paramHashMap)
  {
    String str = "";
    try
    {
      paramContext = com.alipay.e.a.a.a(paramContext, paramHashMap);
      if (TextUtils.isEmpty(paramContext)) {
        com.alipay.sdk.app.a.a.a("third", "GetApdidNull", "apdid == null");
      }
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        com.alipay.sdk.app.a.a.a("third", "GetApdidEx", paramContext);
        paramContext = str;
      }
    }
  }
  
  public static String b()
  {
    String str = Long.toHexString(System.currentTimeMillis());
    Random localRandom = new Random();
    return str + (localRandom.nextInt(9000) + 1000);
  }
  
  /* Error */
  public final void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 39	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: invokestatic 94	com/alipay/sdk/h/b:a	()Lcom/alipay/sdk/h/b;
    //   17: getfield 97	com/alipay/sdk/h/b:a	Landroid/content/Context;
    //   20: invokestatic 103	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   23: invokeinterface 109 1 0
    //   28: ldc 111
    //   30: aload_1
    //   31: invokeinterface 117 3 0
    //   36: invokeinterface 121 1 0
    //   41: pop
    //   42: aload_1
    //   43: putstatic 124	com/alipay/sdk/b/a:b	Ljava/lang/String;
    //   46: goto -35 -> 11
    //   49: astore_1
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_1
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	c
    //   0	54	1	paramString	String
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	49	finally
    //   14	46	49	finally
  }
  
  public final String b(Context paramContext, HashMap paramHashMap)
  {
    paramContext = Executors.newFixedThreadPool(2).submit(new d(this, paramContext, paramHashMap));
    try
    {
      paramContext = (String)paramContext.get(3000L, TimeUnit.MILLISECONDS);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        com.alipay.sdk.app.a.a.a("third", "GetApdidTimeout", paramContext);
        paramContext = "";
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/sdk/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */