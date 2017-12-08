package com.lantern.wifitools.hotspot;

import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Build;
import com.bluefay.b.h;
import com.lantern.wifitools.a.b;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public final class k
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
  
  public k(WifiManager paramWifiManager)
  {
    if (!a()) {
      throw new RuntimeException("Unsupport Ap!");
    }
    h.a("Build.BRAND -----------> " + Build.BRAND, new Object[0]);
    this.j = paramWifiManager;
    try
    {
      a = Integer.parseInt(b.a(this.j, "WIFI_AP_STATE_DISABLING").toString());
      b = Integer.parseInt(b.a(this.j, "WIFI_AP_STATE_DISABLED").toString());
      c = Integer.parseInt(b.a(this.j, "WIFI_AP_STATE_ENABLING").toString());
      d = Integer.parseInt(b.a(this.j, "WIFI_AP_STATE_ENABLED").toString());
      e = Integer.parseInt(b.a(this.j, "WIFI_AP_STATE_FAILED").toString());
      f = b.a(this.j, "WIFI_AP_STATE_CHANGED_ACTION").toString();
      return;
    }
    catch (Exception paramWifiManager)
    {
      for (;;)
      {
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
  
  /* Error */
  public static final boolean a()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 117	com/lantern/wifitools/hotspot/k:h	Ljava/lang/Boolean;
    //   8: ifnull +15 -> 23
    //   11: getstatic 117	com/lantern/wifitools/hotspot/k:h	Ljava/lang/Boolean;
    //   14: invokevirtual 122	java/lang/Boolean:booleanValue	()Z
    //   17: istore_1
    //   18: ldc 2
    //   20: monitorexit
    //   21: iload_1
    //   22: ireturn
    //   23: getstatic 127	android/os/Build$VERSION:SDK_INT	I
    //   26: istore_0
    //   27: iload_0
    //   28: bipush 8
    //   30: if_icmple +257 -> 287
    //   33: iconst_1
    //   34: istore_1
    //   35: iload_1
    //   36: ifeq +19 -> 55
    //   39: ldc -127
    //   41: ldc -125
    //   43: invokevirtual 137	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   46: ifnull +246 -> 292
    //   49: iconst_1
    //   50: istore_2
    //   51: iload_2
    //   52: putstatic 139	com/lantern/wifitools/hotspot/k:i	Z
    //   55: iload_1
    //   56: istore_2
    //   57: iload_1
    //   58: ifeq +38 -> 96
    //   61: ldc -115
    //   63: ldc -113
    //   65: iconst_0
    //   66: anewarray 133	java/lang/Class
    //   69: invokevirtual 147	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   72: astore 4
    //   74: getstatic 30	com/lantern/wifitools/hotspot/k:g	Ljava/util/Map;
    //   77: ldc -113
    //   79: aload 4
    //   81: invokeinterface 153 3 0
    //   86: pop
    //   87: aload 4
    //   89: ifnull +208 -> 297
    //   92: iconst_1
    //   93: istore_1
    //   94: iload_1
    //   95: istore_2
    //   96: iload_2
    //   97: istore_1
    //   98: iload_2
    //   99: ifeq +47 -> 146
    //   102: ldc -115
    //   104: ldc -101
    //   106: iconst_2
    //   107: anewarray 133	java/lang/Class
    //   110: dup
    //   111: iconst_0
    //   112: ldc -127
    //   114: aastore
    //   115: dup
    //   116: iconst_1
    //   117: getstatic 159	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   120: aastore
    //   121: invokevirtual 147	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   124: astore 4
    //   126: getstatic 30	com/lantern/wifitools/hotspot/k:g	Ljava/util/Map;
    //   129: ldc -101
    //   131: aload 4
    //   133: invokeinterface 153 3 0
    //   138: pop
    //   139: aload 4
    //   141: ifnull +193 -> 334
    //   144: iconst_1
    //   145: istore_1
    //   146: iload_1
    //   147: istore_2
    //   148: iload_1
    //   149: ifeq +38 -> 187
    //   152: ldc -115
    //   154: ldc -95
    //   156: iconst_0
    //   157: anewarray 133	java/lang/Class
    //   160: invokevirtual 147	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   163: astore 4
    //   165: getstatic 30	com/lantern/wifitools/hotspot/k:g	Ljava/util/Map;
    //   168: ldc -95
    //   170: aload 4
    //   172: invokeinterface 153 3 0
    //   177: pop
    //   178: aload 4
    //   180: ifnull +183 -> 363
    //   183: iconst_1
    //   184: istore_1
    //   185: iload_1
    //   186: istore_2
    //   187: iload_2
    //   188: istore_1
    //   189: iload_2
    //   190: ifeq +46 -> 236
    //   193: invokestatic 163	com/lantern/wifitools/hotspot/k:e	()Ljava/lang/String;
    //   196: astore 4
    //   198: ldc -115
    //   200: aload 4
    //   202: iconst_1
    //   203: anewarray 133	java/lang/Class
    //   206: dup
    //   207: iconst_0
    //   208: ldc -127
    //   210: aastore
    //   211: invokevirtual 147	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   214: astore 5
    //   216: getstatic 30	com/lantern/wifitools/hotspot/k:g	Ljava/util/Map;
    //   219: aload 4
    //   221: aload 5
    //   223: invokeinterface 153 3 0
    //   228: pop
    //   229: aload 5
    //   231: ifnull +161 -> 392
    //   234: iconst_1
    //   235: istore_1
    //   236: iload_1
    //   237: ifeq +206 -> 443
    //   240: ldc -115
    //   242: ldc -91
    //   244: iconst_0
    //   245: anewarray 133	java/lang/Class
    //   248: invokevirtual 147	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   251: astore 4
    //   253: getstatic 30	com/lantern/wifitools/hotspot/k:g	Ljava/util/Map;
    //   256: ldc -91
    //   258: aload 4
    //   260: invokeinterface 153 3 0
    //   265: pop
    //   266: aload 4
    //   268: ifnull +153 -> 421
    //   271: iload_3
    //   272: istore_1
    //   273: iload_1
    //   274: invokestatic 169	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   277: putstatic 117	com/lantern/wifitools/hotspot/k:h	Ljava/lang/Boolean;
    //   280: invokestatic 38	com/lantern/wifitools/hotspot/k:a	()Z
    //   283: istore_1
    //   284: goto -266 -> 18
    //   287: iconst_0
    //   288: istore_1
    //   289: goto -254 -> 35
    //   292: iconst_0
    //   293: istore_2
    //   294: goto -243 -> 51
    //   297: iconst_0
    //   298: istore_1
    //   299: goto -205 -> 94
    //   302: astore 4
    //   304: aload 4
    //   306: invokestatic 109	com/bluefay/b/h:a	(Ljava/lang/Exception;)V
    //   309: iload_1
    //   310: istore_2
    //   311: goto -215 -> 96
    //   314: astore 4
    //   316: ldc 2
    //   318: monitorexit
    //   319: aload 4
    //   321: athrow
    //   322: astore 4
    //   324: aload 4
    //   326: invokestatic 109	com/bluefay/b/h:a	(Ljava/lang/Exception;)V
    //   329: iload_1
    //   330: istore_2
    //   331: goto -235 -> 96
    //   334: iconst_0
    //   335: istore_1
    //   336: goto -190 -> 146
    //   339: astore 4
    //   341: aload 4
    //   343: invokestatic 109	com/bluefay/b/h:a	(Ljava/lang/Exception;)V
    //   346: iload_2
    //   347: istore_1
    //   348: goto -202 -> 146
    //   351: astore 4
    //   353: aload 4
    //   355: invokestatic 109	com/bluefay/b/h:a	(Ljava/lang/Exception;)V
    //   358: iload_2
    //   359: istore_1
    //   360: goto -214 -> 146
    //   363: iconst_0
    //   364: istore_1
    //   365: goto -180 -> 185
    //   368: astore 4
    //   370: aload 4
    //   372: invokestatic 109	com/bluefay/b/h:a	(Ljava/lang/Exception;)V
    //   375: iload_1
    //   376: istore_2
    //   377: goto -190 -> 187
    //   380: astore 4
    //   382: aload 4
    //   384: invokestatic 109	com/bluefay/b/h:a	(Ljava/lang/Exception;)V
    //   387: iload_1
    //   388: istore_2
    //   389: goto -202 -> 187
    //   392: iconst_0
    //   393: istore_1
    //   394: goto -158 -> 236
    //   397: astore 4
    //   399: aload 4
    //   401: invokestatic 109	com/bluefay/b/h:a	(Ljava/lang/Exception;)V
    //   404: iload_2
    //   405: istore_1
    //   406: goto -170 -> 236
    //   409: astore 4
    //   411: aload 4
    //   413: invokestatic 109	com/bluefay/b/h:a	(Ljava/lang/Exception;)V
    //   416: iload_2
    //   417: istore_1
    //   418: goto -182 -> 236
    //   421: iconst_0
    //   422: istore_1
    //   423: goto -150 -> 273
    //   426: astore 4
    //   428: aload 4
    //   430: invokestatic 109	com/bluefay/b/h:a	(Ljava/lang/Exception;)V
    //   433: goto -160 -> 273
    //   436: astore 4
    //   438: aload 4
    //   440: invokestatic 109	com/bluefay/b/h:a	(Ljava/lang/Exception;)V
    //   443: goto -170 -> 273
    //   446: astore 4
    //   448: goto -393 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   26	5	0	k	int
    //   17	406	1	bool1	boolean
    //   50	367	2	bool2	boolean
    //   1	271	3	bool3	boolean
    //   72	195	4	localObject1	Object
    //   302	3	4	localSecurityException1	SecurityException
    //   314	6	4	localObject2	Object
    //   322	3	4	localNoSuchMethodException1	NoSuchMethodException
    //   339	3	4	localSecurityException2	SecurityException
    //   351	3	4	localNoSuchMethodException2	NoSuchMethodException
    //   368	3	4	localSecurityException3	SecurityException
    //   380	3	4	localNoSuchMethodException3	NoSuchMethodException
    //   397	3	4	localSecurityException4	SecurityException
    //   409	3	4	localNoSuchMethodException4	NoSuchMethodException
    //   426	3	4	localSecurityException5	SecurityException
    //   436	3	4	localNoSuchMethodException5	NoSuchMethodException
    //   446	1	4	localException	Exception
    //   214	16	5	localMethod	Method
    // Exception table:
    //   from	to	target	type
    //   61	87	302	java/lang/SecurityException
    //   5	18	314	finally
    //   23	27	314	finally
    //   39	49	314	finally
    //   51	55	314	finally
    //   61	87	314	finally
    //   102	139	314	finally
    //   152	178	314	finally
    //   193	229	314	finally
    //   240	266	314	finally
    //   273	284	314	finally
    //   304	309	314	finally
    //   324	329	314	finally
    //   341	346	314	finally
    //   353	358	314	finally
    //   370	375	314	finally
    //   382	387	314	finally
    //   399	404	314	finally
    //   411	416	314	finally
    //   428	433	314	finally
    //   438	443	314	finally
    //   61	87	322	java/lang/NoSuchMethodException
    //   102	139	339	java/lang/SecurityException
    //   102	139	351	java/lang/NoSuchMethodException
    //   152	178	368	java/lang/SecurityException
    //   152	178	380	java/lang/NoSuchMethodException
    //   193	229	397	java/lang/SecurityException
    //   193	229	409	java/lang/NoSuchMethodException
    //   240	266	426	java/lang/SecurityException
    //   240	266	436	java/lang/NoSuchMethodException
    //   39	49	446	java/lang/Exception
    //   51	55	446	java/lang/Exception
  }
  
  private static WifiConfiguration b(WifiConfiguration paramWifiConfiguration)
  {
    try
    {
      Object localObject = b.a(paramWifiConfiguration, "mWifiApProfile");
      if (localObject != null) {
        paramWifiConfiguration.SSID = ((String)b.a(localObject, "SSID"));
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.a(localException);
      }
    }
    return paramWifiConfiguration;
  }
  
  private static String e()
  {
    if (i) {}
    for (String str = "setWifiApConfig";; str = "setWifiApConfiguration") {
      return str;
    }
  }
  
  public final boolean a(WifiConfiguration paramWifiConfiguration)
  {
    boolean bool;
    Method localMethod;
    int k;
    try
    {
      bool = i;
      if (bool) {}
      try
      {
        localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>("config=  ");
        h.a(paramWifiConfiguration, new Object[0]);
        localObject = b.a(paramWifiConfiguration, "mWifiApProfile");
        if (localObject != null)
        {
          b.a(localObject, "SSID", paramWifiConfiguration.SSID);
          b.a(localObject, "BSSID", paramWifiConfiguration.BSSID);
          b.a(localObject, "secureType", "open");
          b.a(localObject, "dhcpEnable", Integer.valueOf(1));
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject;
          Class[] arrayOfClass;
          int m;
          h.a(localException);
        }
      }
      localMethod = (Method)g.get(e());
      arrayOfClass = localMethod.getParameterTypes();
      m = arrayOfClass.length;
      k = 0;
      while (k < m)
      {
        Class localClass = arrayOfClass[k];
        localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>("param -> ");
        h.a(localClass.getSimpleName(), new Object[0]);
        k++;
        continue;
        return bool;
      }
    }
    catch (Exception paramWifiConfiguration)
    {
      h.a(paramWifiConfiguration);
      bool = false;
    }
    for (;;)
    {
      if (i)
      {
        k = ((Integer)localMethod.invoke(this.j, new Object[] { paramWifiConfiguration })).intValue();
        paramWifiConfiguration = new java/lang/StringBuilder;
        paramWifiConfiguration.<init>("rValue -> ");
        h.a(k, new Object[0]);
        if (k > 0) {
          bool = true;
        } else {
          bool = false;
        }
      }
      else
      {
        bool = ((Boolean)localMethod.invoke(this.j, new Object[] { paramWifiConfiguration })).booleanValue();
      }
    }
  }
  
  public final boolean a(WifiConfiguration paramWifiConfiguration, boolean paramBoolean)
  {
    try
    {
      paramBoolean = ((Boolean)((Method)g.get("setWifiApEnabled")).invoke(this.j, new Object[] { paramWifiConfiguration, Boolean.valueOf(paramBoolean) })).booleanValue();
      return paramBoolean;
    }
    catch (Exception paramWifiConfiguration)
    {
      for (;;)
      {
        h.a(paramWifiConfiguration);
        paramBoolean = false;
      }
    }
  }
  
  public final int b()
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
        h.a(localException);
        int k = e;
      }
    }
  }
  
  public final WifiConfiguration c()
  {
    for (;;)
    {
      try
      {
        localWifiConfiguration2 = (WifiConfiguration)((Method)g.get("getWifiApConfiguration")).invoke(this.j, new Object[0]);
        localWifiConfiguration1 = localWifiConfiguration2;
        h.a(localException1);
      }
      catch (Exception localException1)
      {
        try
        {
          if (i) {
            localWifiConfiguration1 = b(localWifiConfiguration2);
          }
          return localWifiConfiguration1;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            WifiConfiguration localWifiConfiguration2;
            WifiConfiguration localWifiConfiguration1 = localWifiConfiguration2;
          }
        }
        localException1 = localException1;
        localWifiConfiguration1 = null;
      }
    }
  }
  
  public final boolean d()
  {
    try
    {
      bool = ((Boolean)((Method)g.get("isWifiApEnabled")).invoke(this.j, new Object[0])).booleanValue();
      return bool;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.a(localException);
        boolean bool = false;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/hotspot/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */