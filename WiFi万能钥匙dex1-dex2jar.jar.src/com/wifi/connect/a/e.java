package com.wifi.connect.a;

import android.text.TextUtils;
import com.lantern.core.model.WkAccessPoint;
import com.wifi.connect.model.AccessPointKey;
import java.util.HashMap;

public final class e
{
  private static e a;
  private HashMap<com.wifi.connect.model.e, AccessPointKey> b = new HashMap();
  
  public static e b()
  {
    if (a == null) {
      a = new e();
    }
    return a;
  }
  
  public final AccessPointKey a(WkAccessPoint paramWkAccessPoint)
  {
    try
    {
      HashMap localHashMap = this.b;
      com.wifi.connect.model.e locale = new com/wifi/connect/model/e;
      locale.<init>(paramWkAccessPoint.a, paramWkAccessPoint.c);
      paramWkAccessPoint = (AccessPointKey)localHashMap.get(locale);
      return paramWkAccessPoint;
    }
    finally {}
  }
  
  public final void a()
  {
    try
    {
      this.b.clear();
      return;
    }
    finally {}
  }
  
  public final void a(String paramString, AccessPointKey paramAccessPointKey)
  {
    try
    {
      HashMap localHashMap = this.b;
      com.wifi.connect.model.e locale = new com/wifi/connect/model/e;
      locale.<init>(paramString, paramAccessPointKey.c);
      localHashMap.put(locale, paramAccessPointKey);
      return;
    }
    finally {}
  }
  
  /* Error */
  public final boolean a(com.wifi.connect.model.AccessPoint paramAccessPoint)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 18	com/wifi/connect/a/e:b	Ljava/util/HashMap;
    //   6: astore_3
    //   7: new 26	com/wifi/connect/model/e
    //   10: astore 4
    //   12: aload 4
    //   14: aload_1
    //   15: getfield 57	com/wifi/connect/model/AccessPoint:a	Ljava/lang/String;
    //   18: aload_1
    //   19: getfield 58	com/wifi/connect/model/AccessPoint:c	I
    //   22: invokespecial 38	com/wifi/connect/model/e:<init>	(Ljava/lang/String;I)V
    //   25: aload_3
    //   26: aload 4
    //   28: invokevirtual 42	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   31: checkcast 44	com/wifi/connect/model/AccessPointKey
    //   34: astore_1
    //   35: aload_1
    //   36: ifnull +21 -> 57
    //   39: ldc 60
    //   41: aload_1
    //   42: getfield 63	com/wifi/connect/model/AccessPointKey:p	Ljava/lang/String;
    //   45: invokevirtual 69	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   48: ifeq +9 -> 57
    //   51: iconst_1
    //   52: istore_2
    //   53: aload_0
    //   54: monitorexit
    //   55: iload_2
    //   56: ireturn
    //   57: iconst_0
    //   58: istore_2
    //   59: goto -6 -> 53
    //   62: astore_1
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_1
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	e
    //   0	67	1	paramAccessPoint	com.wifi.connect.model.AccessPoint
    //   52	7	2	bool	boolean
    //   6	20	3	localHashMap	HashMap
    //   10	17	4	locale	com.wifi.connect.model.e
    // Exception table:
    //   from	to	target	type
    //   2	35	62	finally
    //   39	51	62	finally
    //   53	55	62	finally
    //   63	65	62	finally
  }
  
  public final boolean a(AccessPointKey paramAccessPointKey)
  {
    for (;;)
    {
      try
      {
        HashMap localHashMap = this.b;
        com.wifi.connect.model.e locale = new com/wifi/connect/model/e;
        locale.<init>(paramAccessPointKey.a, paramAccessPointKey.c);
        paramAccessPointKey = (AccessPointKey)localHashMap.get(locale);
        if ((paramAccessPointKey != null) && (!TextUtils.isEmpty(paramAccessPointKey.k)))
        {
          bool = true;
          return bool;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public final boolean b(WkAccessPoint paramWkAccessPoint)
  {
    try
    {
      HashMap localHashMap = this.b;
      com.wifi.connect.model.e locale = new com/wifi/connect/model/e;
      locale.<init>(paramWkAccessPoint.a, paramWkAccessPoint.c);
      boolean bool = localHashMap.containsKey(locale);
      return bool;
    }
    finally {}
  }
  
  /* Error */
  public final int c(WkAccessPoint paramWkAccessPoint)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 18	com/wifi/connect/a/e:b	Ljava/util/HashMap;
    //   6: astore 4
    //   8: new 26	com/wifi/connect/model/e
    //   11: astore 5
    //   13: aload 5
    //   15: aload_1
    //   16: getfield 31	com/lantern/core/model/WkAccessPoint:a	Ljava/lang/String;
    //   19: aload_1
    //   20: getfield 35	com/lantern/core/model/WkAccessPoint:c	I
    //   23: invokespecial 38	com/wifi/connect/model/e:<init>	(Ljava/lang/String;I)V
    //   26: aload 4
    //   28: aload 5
    //   30: invokevirtual 42	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   33: checkcast 44	com/wifi/connect/model/AccessPointKey
    //   36: astore_1
    //   37: aload_1
    //   38: ifnull +35 -> 73
    //   41: aload_1
    //   42: getfield 90	com/wifi/connect/model/AccessPointKey:n	Ljava/lang/String;
    //   45: invokestatic 80	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   48: istore_3
    //   49: iload_3
    //   50: ifne +23 -> 73
    //   53: aload_1
    //   54: getfield 90	com/wifi/connect/model/AccessPointKey:n	Ljava/lang/String;
    //   57: invokevirtual 94	java/lang/String:trim	()Ljava/lang/String;
    //   60: invokestatic 100	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   63: istore_2
    //   64: aload_0
    //   65: monitorexit
    //   66: iload_2
    //   67: ireturn
    //   68: astore_1
    //   69: aload_1
    //   70: invokevirtual 103	java/lang/Exception:printStackTrace	()V
    //   73: iconst_0
    //   74: istore_2
    //   75: goto -11 -> 64
    //   78: astore_1
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_1
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	e
    //   0	83	1	paramWkAccessPoint	WkAccessPoint
    //   63	12	2	i	int
    //   48	2	3	bool	boolean
    //   6	21	4	localHashMap	HashMap
    //   11	18	5	locale	com.wifi.connect.model.e
    // Exception table:
    //   from	to	target	type
    //   53	64	68	java/lang/Exception
    //   2	37	78	finally
    //   41	49	78	finally
    //   53	64	78	finally
    //   64	66	78	finally
    //   69	73	78	finally
    //   79	81	78	finally
  }
  
  /* Error */
  public final boolean d(WkAccessPoint paramWkAccessPoint)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 18	com/wifi/connect/a/e:b	Ljava/util/HashMap;
    //   6: astore 4
    //   8: new 26	com/wifi/connect/model/e
    //   11: astore_3
    //   12: aload_3
    //   13: aload_1
    //   14: getfield 31	com/lantern/core/model/WkAccessPoint:a	Ljava/lang/String;
    //   17: aload_1
    //   18: getfield 35	com/lantern/core/model/WkAccessPoint:c	I
    //   21: invokespecial 38	com/wifi/connect/model/e:<init>	(Ljava/lang/String;I)V
    //   24: aload 4
    //   26: aload_3
    //   27: invokevirtual 42	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   30: checkcast 44	com/wifi/connect/model/AccessPointKey
    //   33: astore_1
    //   34: aload_1
    //   35: ifnull +21 -> 56
    //   38: ldc 60
    //   40: aload_1
    //   41: getfield 63	com/wifi/connect/model/AccessPointKey:p	Ljava/lang/String;
    //   44: invokevirtual 69	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   47: ifeq +9 -> 56
    //   50: iconst_1
    //   51: istore_2
    //   52: aload_0
    //   53: monitorexit
    //   54: iload_2
    //   55: ireturn
    //   56: iconst_0
    //   57: istore_2
    //   58: goto -6 -> 52
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	e
    //   0	66	1	paramWkAccessPoint	WkAccessPoint
    //   51	7	2	bool	boolean
    //   11	16	3	locale	com.wifi.connect.model.e
    //   6	19	4	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   2	34	61	finally
    //   38	50	61	finally
    //   52	54	61	finally
    //   62	64	61	finally
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */