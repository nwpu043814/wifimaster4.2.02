package com.wifi.connect.b;

import android.net.wifi.WifiManager;
import android.os.Build;
import com.bluefay.a.e;
import com.bluefay.b.h;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public final class ag
{
  public static int a;
  public static int b;
  public static int c;
  public static int d;
  public static int e;
  public static String f;
  private static final Map<String, Method> g = new HashMap();
  private static Boolean h;
  private static boolean i;
  private final WifiManager j;
  
  public ag(WifiManager paramWifiManager)
  {
    if (!c()) {
      throw new RuntimeException("Unsupport Ap!");
    }
    h.a("Build.BRAND -----------> " + Build.BRAND, new Object[0]);
    this.j = paramWifiManager;
    try
    {
      e.a(this.j, this.j.getClass(), "WIFI_AP_STATE_DISABLING");
      a = a("WIFI_AP_STATE_DISABLING");
      b = a("WIFI_AP_STATE_DISABLED");
      c = a("WIFI_AP_STATE_ENABLING");
      d = a("WIFI_AP_STATE_ENABLED");
      e = a("WIFI_AP_STATE_FAILED");
      paramWifiManager = e.a(this.j, this.j.getClass(), "WIFI_AP_STATE_CHANGED_ACTION");
      if ((paramWifiManager instanceof Integer))
      {
        f = (String)paramWifiManager;
        return;
      }
      Exception localException = new java/lang/Exception;
      paramWifiManager = new java/lang/StringBuilder;
      paramWifiManager.<init>("Get Filed:");
      localException.<init>("WIFI_AP_STATE_CHANGED_ACTION" + " exception");
      throw localException;
    }
    catch (Exception paramWifiManager)
    {
      for (;;)
      {
        h.c("error:" + paramWifiManager.getMessage());
        h.a(paramWifiManager);
        a = 10;
        b = 11;
        c = 12;
        d = 13;
        e = 14;
        f = "android.net.wifi.WIFI_AP_STATE_CHANGED";
      }
    }
  }
  
  private int a(String paramString)
  {
    Object localObject = e.a(this.j, this.j.getClass(), paramString);
    if ((localObject instanceof Integer)) {
      return ((Integer)localObject).intValue();
    }
    throw new Exception("Get Filed:" + paramString + " exception");
  }
  
  /* Error */
  private static boolean c()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 137	com/wifi/connect/b/ag:h	Ljava/lang/Boolean;
    //   8: ifnull +15 -> 23
    //   11: getstatic 137	com/wifi/connect/b/ag:h	Ljava/lang/Boolean;
    //   14: invokevirtual 142	java/lang/Boolean:booleanValue	()Z
    //   17: istore_1
    //   18: ldc 2
    //   20: monitorexit
    //   21: iload_1
    //   22: ireturn
    //   23: getstatic 147	android/os/Build$VERSION:SDK_INT	I
    //   26: istore_0
    //   27: iload_0
    //   28: bipush 8
    //   30: if_icmple +262 -> 292
    //   33: iconst_1
    //   34: istore_1
    //   35: iload_1
    //   36: ifeq +19 -> 55
    //   39: ldc -107
    //   41: ldc -105
    //   43: invokevirtual 157	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   46: ifnull +251 -> 297
    //   49: iconst_1
    //   50: istore_2
    //   51: iload_2
    //   52: putstatic 159	com/wifi/connect/b/ag:i	Z
    //   55: iload_1
    //   56: istore_2
    //   57: iload_1
    //   58: ifeq +38 -> 96
    //   61: ldc -95
    //   63: ldc -93
    //   65: iconst_0
    //   66: anewarray 153	java/lang/Class
    //   69: invokevirtual 167	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   72: astore 4
    //   74: getstatic 30	com/wifi/connect/b/ag:g	Ljava/util/Map;
    //   77: ldc -93
    //   79: aload 4
    //   81: invokeinterface 173 3 0
    //   86: pop
    //   87: aload 4
    //   89: ifnull +213 -> 302
    //   92: iconst_1
    //   93: istore_1
    //   94: iload_1
    //   95: istore_2
    //   96: iload_2
    //   97: istore_1
    //   98: iload_2
    //   99: ifeq +47 -> 146
    //   102: ldc -95
    //   104: ldc -81
    //   106: iconst_2
    //   107: anewarray 153	java/lang/Class
    //   110: dup
    //   111: iconst_0
    //   112: ldc -107
    //   114: aastore
    //   115: dup
    //   116: iconst_1
    //   117: getstatic 179	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   120: aastore
    //   121: invokevirtual 167	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   124: astore 4
    //   126: getstatic 30	com/wifi/connect/b/ag:g	Ljava/util/Map;
    //   129: ldc -81
    //   131: aload 4
    //   133: invokeinterface 173 3 0
    //   138: pop
    //   139: aload 4
    //   141: ifnull +202 -> 343
    //   144: iconst_1
    //   145: istore_1
    //   146: iload_1
    //   147: istore_2
    //   148: iload_1
    //   149: ifeq +38 -> 187
    //   152: ldc -95
    //   154: ldc -75
    //   156: iconst_0
    //   157: anewarray 153	java/lang/Class
    //   160: invokevirtual 167	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   163: astore 4
    //   165: getstatic 30	com/wifi/connect/b/ag:g	Ljava/util/Map;
    //   168: ldc -75
    //   170: aload 4
    //   172: invokeinterface 173 3 0
    //   177: pop
    //   178: aload 4
    //   180: ifnull +196 -> 376
    //   183: iconst_1
    //   184: istore_1
    //   185: iload_1
    //   186: istore_2
    //   187: iload_2
    //   188: istore_1
    //   189: iload_2
    //   190: ifeq +51 -> 241
    //   193: getstatic 159	com/wifi/connect/b/ag:i	Z
    //   196: ifeq +213 -> 409
    //   199: ldc -73
    //   201: astore 4
    //   203: ldc -95
    //   205: aload 4
    //   207: iconst_1
    //   208: anewarray 153	java/lang/Class
    //   211: dup
    //   212: iconst_0
    //   213: ldc -107
    //   215: aastore
    //   216: invokevirtual 167	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   219: astore 5
    //   221: getstatic 30	com/wifi/connect/b/ag:g	Ljava/util/Map;
    //   224: aload 4
    //   226: aload 5
    //   228: invokeinterface 173 3 0
    //   233: pop
    //   234: aload 5
    //   236: ifnull +180 -> 416
    //   239: iconst_1
    //   240: istore_1
    //   241: iload_1
    //   242: ifeq +233 -> 475
    //   245: ldc -95
    //   247: ldc -71
    //   249: iconst_0
    //   250: anewarray 153	java/lang/Class
    //   253: invokevirtual 167	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   256: astore 4
    //   258: getstatic 30	com/wifi/connect/b/ag:g	Ljava/util/Map;
    //   261: ldc -71
    //   263: aload 4
    //   265: invokeinterface 173 3 0
    //   270: pop
    //   271: aload 4
    //   273: ifnull +176 -> 449
    //   276: iload_3
    //   277: istore_1
    //   278: iload_1
    //   279: invokestatic 189	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   282: putstatic 137	com/wifi/connect/b/ag:h	Ljava/lang/Boolean;
    //   285: invokestatic 38	com/wifi/connect/b/ag:c	()Z
    //   288: istore_1
    //   289: goto -271 -> 18
    //   292: iconst_0
    //   293: istore_1
    //   294: goto -259 -> 35
    //   297: iconst_0
    //   298: istore_2
    //   299: goto -248 -> 51
    //   302: iconst_0
    //   303: istore_1
    //   304: goto -210 -> 94
    //   307: astore 4
    //   309: ldc -65
    //   311: aload 4
    //   313: invokestatic 194	com/bluefay/b/h:a	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   316: iload_1
    //   317: istore_2
    //   318: goto -222 -> 96
    //   321: astore 4
    //   323: ldc 2
    //   325: monitorexit
    //   326: aload 4
    //   328: athrow
    //   329: astore 4
    //   331: ldc -60
    //   333: aload 4
    //   335: invokestatic 194	com/bluefay/b/h:a	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   338: iload_1
    //   339: istore_2
    //   340: goto -244 -> 96
    //   343: iconst_0
    //   344: istore_1
    //   345: goto -199 -> 146
    //   348: astore 4
    //   350: ldc -65
    //   352: aload 4
    //   354: invokestatic 194	com/bluefay/b/h:a	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   357: iload_2
    //   358: istore_1
    //   359: goto -213 -> 146
    //   362: astore 4
    //   364: ldc -60
    //   366: aload 4
    //   368: invokestatic 194	com/bluefay/b/h:a	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   371: iload_2
    //   372: istore_1
    //   373: goto -227 -> 146
    //   376: iconst_0
    //   377: istore_1
    //   378: goto -193 -> 185
    //   381: astore 4
    //   383: ldc -65
    //   385: aload 4
    //   387: invokestatic 194	com/bluefay/b/h:a	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   390: iload_1
    //   391: istore_2
    //   392: goto -205 -> 187
    //   395: astore 4
    //   397: ldc -60
    //   399: aload 4
    //   401: invokestatic 194	com/bluefay/b/h:a	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   404: iload_1
    //   405: istore_2
    //   406: goto -219 -> 187
    //   409: ldc -58
    //   411: astore 4
    //   413: goto -210 -> 203
    //   416: iconst_0
    //   417: istore_1
    //   418: goto -177 -> 241
    //   421: astore 4
    //   423: ldc -65
    //   425: aload 4
    //   427: invokestatic 194	com/bluefay/b/h:a	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   430: iload_2
    //   431: istore_1
    //   432: goto -191 -> 241
    //   435: astore 4
    //   437: ldc -60
    //   439: aload 4
    //   441: invokestatic 194	com/bluefay/b/h:a	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   444: iload_2
    //   445: istore_1
    //   446: goto -205 -> 241
    //   449: iconst_0
    //   450: istore_1
    //   451: goto -173 -> 278
    //   454: astore 4
    //   456: ldc -65
    //   458: aload 4
    //   460: invokestatic 194	com/bluefay/b/h:a	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   463: goto -185 -> 278
    //   466: astore 4
    //   468: ldc -60
    //   470: aload 4
    //   472: invokestatic 194	com/bluefay/b/h:a	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   475: goto -197 -> 278
    //   478: astore 4
    //   480: goto -425 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   26	5	0	k	int
    //   17	434	1	bool1	boolean
    //   50	395	2	bool2	boolean
    //   1	276	3	bool3	boolean
    //   72	200	4	localObject1	Object
    //   307	5	4	localSecurityException1	SecurityException
    //   321	6	4	localObject2	Object
    //   329	5	4	localNoSuchMethodException1	NoSuchMethodException
    //   348	5	4	localSecurityException2	SecurityException
    //   362	5	4	localNoSuchMethodException2	NoSuchMethodException
    //   381	5	4	localSecurityException3	SecurityException
    //   395	5	4	localNoSuchMethodException3	NoSuchMethodException
    //   411	1	4	str	String
    //   421	5	4	localSecurityException4	SecurityException
    //   435	5	4	localNoSuchMethodException4	NoSuchMethodException
    //   454	5	4	localSecurityException5	SecurityException
    //   466	5	4	localNoSuchMethodException5	NoSuchMethodException
    //   478	1	4	localException	Exception
    //   219	16	5	localMethod	Method
    // Exception table:
    //   from	to	target	type
    //   61	87	307	java/lang/SecurityException
    //   5	18	321	finally
    //   23	27	321	finally
    //   39	49	321	finally
    //   51	55	321	finally
    //   61	87	321	finally
    //   102	139	321	finally
    //   152	178	321	finally
    //   193	199	321	finally
    //   203	234	321	finally
    //   245	271	321	finally
    //   278	289	321	finally
    //   309	316	321	finally
    //   331	338	321	finally
    //   350	357	321	finally
    //   364	371	321	finally
    //   383	390	321	finally
    //   397	404	321	finally
    //   423	430	321	finally
    //   437	444	321	finally
    //   456	463	321	finally
    //   468	475	321	finally
    //   61	87	329	java/lang/NoSuchMethodException
    //   102	139	348	java/lang/SecurityException
    //   102	139	362	java/lang/NoSuchMethodException
    //   152	178	381	java/lang/SecurityException
    //   152	178	395	java/lang/NoSuchMethodException
    //   193	199	421	java/lang/SecurityException
    //   203	234	421	java/lang/SecurityException
    //   193	199	435	java/lang/NoSuchMethodException
    //   203	234	435	java/lang/NoSuchMethodException
    //   245	271	454	java/lang/SecurityException
    //   245	271	466	java/lang/NoSuchMethodException
    //   39	49	478	java/lang/Exception
    //   51	55	478	java/lang/Exception
  }
  
  private int d()
  {
    try
    {
      k = ((Integer)((Method)g.get("getWifiApState")).invoke(this.j, new Object[0])).intValue();
      return k;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.a(localException.getMessage(), localException);
        int k = e;
      }
    }
  }
  
  public final boolean a()
  {
    boolean bool = false;
    int k = d();
    h.a("getWifiApState:" + k, new Object[0]);
    if ((k == d) || (k == c)) {
      bool = true;
    }
    return bool;
  }
  
  public final boolean b()
  {
    try
    {
      bool = ((Boolean)((Method)g.get("setWifiApEnabled")).invoke(this.j, new Object[] { null, Boolean.valueOf(false) })).booleanValue();
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.a(localException.getMessage(), localException);
        boolean bool = false;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/b/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */