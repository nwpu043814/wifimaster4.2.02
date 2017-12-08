package com.alipay.c.a.a.b;

import android.app.KeyguardManager;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.alipay.c.a.a.a.a;
import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
{
  private static b a = new b();
  
  public static b a()
  {
    return a;
  }
  
  public static String a(Context paramContext)
  {
    if (a(paramContext, "android.permission.READ_PHONE_STATE"))
    {
      paramContext = "";
      return paramContext;
    }
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        paramContext = (TelephonyManager)paramContext.getSystemService("phone");
        if (paramContext != null)
        {
          str = paramContext.getDeviceId();
          paramContext = str;
          if (str != null) {
            break;
          }
          paramContext = "";
        }
      }
      catch (Throwable paramContext) {}
      String str = null;
    }
  }
  
  private static boolean a(Context paramContext, String paramString)
  {
    boolean bool = true;
    int i;
    if (paramContext.getPackageManager().checkPermission(paramString, paramContext.getPackageName()) == 0)
    {
      i = 1;
      if (i != 0) {
        break label30;
      }
    }
    for (;;)
    {
      return bool;
      i = 0;
      break;
      label30:
      bool = false;
    }
  }
  
  public static String b()
  {
    long l1 = 0L;
    try
    {
      File localFile = Environment.getDataDirectory();
      StatFs localStatFs = new android/os/StatFs;
      localStatFs.<init>(localFile.getPath());
      long l2 = localStatFs.getBlockSize();
      int i = localStatFs.getAvailableBlocks();
      l1 = i * l2;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
    return String.valueOf(l1);
  }
  
  public static String b(Context paramContext)
  {
    if (a(paramContext, "android.permission.READ_PHONE_STATE"))
    {
      paramContext = "";
      return paramContext;
    }
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        paramContext = (TelephonyManager)paramContext.getSystemService("phone");
        if (paramContext != null)
        {
          str = paramContext.getSubscriberId();
          paramContext = str;
          if (str != null) {
            break;
          }
          paramContext = "";
        }
      }
      catch (Throwable paramContext) {}
      String str = "";
    }
  }
  
  public static String c()
  {
    l2 = 0L;
    l1 = l2;
    try
    {
      if ("mounted".equals(Environment.getExternalStorageState()))
      {
        File localFile = a.a();
        StatFs localStatFs = new android/os/StatFs;
        localStatFs.<init>(localFile.getPath());
        l1 = localStatFs.getBlockSize();
        int i = localStatFs.getAvailableBlocks();
        l1 = i * l1;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        l1 = l2;
      }
    }
    return String.valueOf(l1);
  }
  
  public static String c(Context paramContext)
  {
    int j = 0;
    try
    {
      i = Settings.System.getInt(paramContext.getContentResolver(), "airplane_mode_on", 0);
      if (i == 1) {}
      for (paramContext = "1";; paramContext = "0") {
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        int i = j;
      }
    }
  }
  
  /* Error */
  public static String d()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: new 119	java/io/FileInputStream
    //   9: astore_1
    //   10: new 64	java/io/File
    //   13: astore_2
    //   14: aload_2
    //   15: ldc 121
    //   17: invokespecial 122	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: aload_1
    //   21: aload_2
    //   22: invokespecial 125	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   25: new 127	java/io/InputStreamReader
    //   28: astore_3
    //   29: aload_3
    //   30: aload_1
    //   31: invokespecial 130	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   34: new 132	java/io/LineNumberReader
    //   37: astore 4
    //   39: aload 4
    //   41: aload_3
    //   42: invokespecial 135	java/io/LineNumberReader:<init>	(Ljava/io/Reader;)V
    //   45: iconst_1
    //   46: istore_0
    //   47: iload_0
    //   48: bipush 100
    //   50: if_icmpge +254 -> 304
    //   53: aload 4
    //   55: invokevirtual 138	java/io/LineNumberReader:readLine	()Ljava/lang/String;
    //   58: astore_2
    //   59: aload_2
    //   60: ifnull +244 -> 304
    //   63: aload_2
    //   64: ldc -116
    //   66: invokevirtual 144	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   69: iflt +49 -> 118
    //   72: aload_2
    //   73: aload_2
    //   74: ldc -110
    //   76: invokevirtual 144	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   79: iconst_1
    //   80: iadd
    //   81: aload_2
    //   82: invokevirtual 149	java/lang/String:length	()I
    //   85: invokevirtual 153	java/lang/String:substring	(II)Ljava/lang/String;
    //   88: invokevirtual 156	java/lang/String:trim	()Ljava/lang/String;
    //   91: astore_2
    //   92: aload 4
    //   94: invokevirtual 159	java/io/LineNumberReader:close	()V
    //   97: aload_3
    //   98: invokevirtual 160	java/io/InputStreamReader:close	()V
    //   101: aload_1
    //   102: invokevirtual 161	java/io/FileInputStream:close	()V
    //   105: aload_2
    //   106: astore_1
    //   107: aload_1
    //   108: astore_2
    //   109: aload_1
    //   110: ifnonnull +6 -> 116
    //   113: ldc 26
    //   115: astore_2
    //   116: aload_2
    //   117: areturn
    //   118: iinc 0 1
    //   121: goto -74 -> 47
    //   124: astore_1
    //   125: aload_2
    //   126: astore_1
    //   127: goto -20 -> 107
    //   130: astore_1
    //   131: aconst_null
    //   132: astore_1
    //   133: aconst_null
    //   134: astore_2
    //   135: aload 4
    //   137: astore_3
    //   138: aload_1
    //   139: ifnull +7 -> 146
    //   142: aload_1
    //   143: invokevirtual 159	java/io/LineNumberReader:close	()V
    //   146: aload_3
    //   147: ifnull +7 -> 154
    //   150: aload_3
    //   151: invokevirtual 160	java/io/InputStreamReader:close	()V
    //   154: aload_2
    //   155: ifnull +143 -> 298
    //   158: aload_2
    //   159: invokevirtual 161	java/io/FileInputStream:close	()V
    //   162: ldc -93
    //   164: astore_1
    //   165: goto -58 -> 107
    //   168: astore_1
    //   169: ldc -93
    //   171: astore_1
    //   172: goto -65 -> 107
    //   175: astore_2
    //   176: aconst_null
    //   177: astore_3
    //   178: aconst_null
    //   179: astore_1
    //   180: aload 5
    //   182: astore 4
    //   184: aload 4
    //   186: ifnull +8 -> 194
    //   189: aload 4
    //   191: invokevirtual 159	java/io/LineNumberReader:close	()V
    //   194: aload_3
    //   195: ifnull +7 -> 202
    //   198: aload_3
    //   199: invokevirtual 160	java/io/InputStreamReader:close	()V
    //   202: aload_1
    //   203: ifnull +7 -> 210
    //   206: aload_1
    //   207: invokevirtual 161	java/io/FileInputStream:close	()V
    //   210: aload_2
    //   211: athrow
    //   212: astore 4
    //   214: goto -117 -> 97
    //   217: astore_3
    //   218: goto -117 -> 101
    //   221: astore_1
    //   222: goto -76 -> 146
    //   225: astore_1
    //   226: goto -72 -> 154
    //   229: astore 4
    //   231: goto -37 -> 194
    //   234: astore_3
    //   235: goto -33 -> 202
    //   238: astore_1
    //   239: goto -29 -> 210
    //   242: astore_2
    //   243: aconst_null
    //   244: astore_3
    //   245: aload 5
    //   247: astore 4
    //   249: goto -65 -> 184
    //   252: astore_2
    //   253: aload 5
    //   255: astore 4
    //   257: goto -73 -> 184
    //   260: astore_2
    //   261: goto -77 -> 184
    //   264: astore_2
    //   265: aconst_null
    //   266: astore_3
    //   267: aload_1
    //   268: astore_2
    //   269: aload_3
    //   270: astore_1
    //   271: aload 4
    //   273: astore_3
    //   274: goto -136 -> 138
    //   277: astore_2
    //   278: aconst_null
    //   279: astore 4
    //   281: aload_1
    //   282: astore_2
    //   283: aload 4
    //   285: astore_1
    //   286: goto -148 -> 138
    //   289: astore_2
    //   290: aload_1
    //   291: astore_2
    //   292: aload 4
    //   294: astore_1
    //   295: goto -157 -> 138
    //   298: ldc -93
    //   300: astore_1
    //   301: goto -194 -> 107
    //   304: ldc -93
    //   306: astore_2
    //   307: goto -215 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   46	73	0	i	int
    //   9	101	1	localObject1	Object
    //   124	1	1	localThrowable1	Throwable
    //   126	1	1	localObject2	Object
    //   130	1	1	localThrowable2	Throwable
    //   132	33	1	str1	String
    //   168	1	1	localThrowable3	Throwable
    //   171	36	1	str2	String
    //   221	1	1	localThrowable4	Throwable
    //   225	1	1	localThrowable5	Throwable
    //   238	30	1	localThrowable6	Throwable
    //   270	31	1	localObject3	Object
    //   13	146	2	localObject4	Object
    //   175	36	2	localObject5	Object
    //   242	1	2	localObject6	Object
    //   252	1	2	localObject7	Object
    //   260	1	2	localObject8	Object
    //   264	1	2	localThrowable7	Throwable
    //   268	1	2	localThrowable8	Throwable
    //   277	1	2	localThrowable9	Throwable
    //   282	1	2	localObject9	Object
    //   289	1	2	localThrowable10	Throwable
    //   291	16	2	localObject10	Object
    //   28	171	3	localObject11	Object
    //   217	1	3	localThrowable11	Throwable
    //   234	1	3	localThrowable12	Throwable
    //   244	30	3	localObject12	Object
    //   4	186	4	localObject13	Object
    //   212	1	4	localThrowable13	Throwable
    //   229	1	4	localThrowable14	Throwable
    //   247	46	4	localObject14	Object
    //   1	253	5	localObject15	Object
    // Exception table:
    //   from	to	target	type
    //   101	105	124	java/lang/Throwable
    //   6	25	130	java/lang/Throwable
    //   158	162	168	java/lang/Throwable
    //   6	25	175	finally
    //   92	97	212	java/lang/Throwable
    //   97	101	217	java/lang/Throwable
    //   142	146	221	java/lang/Throwable
    //   150	154	225	java/lang/Throwable
    //   189	194	229	java/lang/Throwable
    //   198	202	234	java/lang/Throwable
    //   206	210	238	java/lang/Throwable
    //   25	34	242	finally
    //   34	45	252	finally
    //   53	59	260	finally
    //   63	92	260	finally
    //   25	34	264	java/lang/Throwable
    //   34	45	277	java/lang/Throwable
    //   53	59	289	java/lang/Throwable
    //   63	92	289	java/lang/Throwable
  }
  
  public static String d(Context paramContext)
  {
    int i = 1;
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        paramContext = (AudioManager)paramContext.getSystemService("audio");
        if (paramContext.getRingerMode() != 0) {
          continue;
        }
        int i1 = paramContext.getStreamVolume(0);
        int m = paramContext.getStreamVolume(1);
        int k = paramContext.getStreamVolume(2);
        int n = paramContext.getStreamVolume(3);
        int j = paramContext.getStreamVolume(4);
        localJSONObject.put("ringermode", String.valueOf(i));
        localJSONObject.put("call", String.valueOf(i1));
        localJSONObject.put("system", String.valueOf(m));
        localJSONObject.put("ring", String.valueOf(k));
        localJSONObject.put("music", String.valueOf(n));
        localJSONObject.put("alarm", String.valueOf(j));
      }
      catch (Throwable paramContext)
      {
        continue;
      }
      return localJSONObject.toString();
      i = 0;
    }
  }
  
  public static String e(Context paramContext)
  {
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        paramContext = (TelephonyManager)paramContext.getSystemService("phone");
        if (paramContext != null)
        {
          paramContext = paramContext.getNetworkOperatorName();
          Object localObject;
          if (paramContext != null)
          {
            localObject = paramContext;
            if (!"null".equals(paramContext)) {}
          }
          else
          {
            localObject = "";
          }
          return (String)localObject;
        }
      }
      catch (Throwable paramContext) {}
      paramContext = null;
    }
  }
  
  public static String f()
  {
    String str = w();
    if (!a.a(str)) {}
    for (;;)
    {
      return str;
      str = x();
    }
  }
  
  public static String f(Context paramContext)
  {
    Object localObject;
    if (a(paramContext, "android.permission.READ_PHONE_STATE"))
    {
      localObject = "";
      return (String)localObject;
    }
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        paramContext = (TelephonyManager)paramContext.getSystemService("phone");
        if (paramContext != null)
        {
          paramContext = paramContext.getLine1Number();
          localObject = paramContext;
          if (paramContext != null) {
            break;
          }
          localObject = "";
        }
      }
      catch (Throwable paramContext) {}
      paramContext = "";
    }
  }
  
  /* Error */
  public static String g()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 221	java/io/FileReader
    //   5: astore_0
    //   6: aload_0
    //   7: ldc 121
    //   9: invokespecial 222	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   12: new 224	java/io/BufferedReader
    //   15: astore_2
    //   16: aload_2
    //   17: aload_0
    //   18: invokespecial 225	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   21: aload_2
    //   22: invokevirtual 226	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   25: ldc -28
    //   27: iconst_2
    //   28: invokevirtual 232	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   31: astore_1
    //   32: aload_1
    //   33: ifnull +25 -> 58
    //   36: aload_1
    //   37: arraylength
    //   38: iconst_1
    //   39: if_icmple +19 -> 58
    //   42: aload_1
    //   43: iconst_1
    //   44: aaload
    //   45: astore_1
    //   46: aload_0
    //   47: invokevirtual 233	java/io/FileReader:close	()V
    //   50: aload_2
    //   51: invokevirtual 234	java/io/BufferedReader:close	()V
    //   54: aload_1
    //   55: astore_0
    //   56: aload_0
    //   57: areturn
    //   58: aload_0
    //   59: invokevirtual 233	java/io/FileReader:close	()V
    //   62: aload_2
    //   63: invokevirtual 234	java/io/BufferedReader:close	()V
    //   66: ldc 26
    //   68: astore_0
    //   69: goto -13 -> 56
    //   72: astore_0
    //   73: aconst_null
    //   74: astore_0
    //   75: aload_0
    //   76: ifnull +7 -> 83
    //   79: aload_0
    //   80: invokevirtual 233	java/io/FileReader:close	()V
    //   83: aload_1
    //   84: ifnull -18 -> 66
    //   87: aload_1
    //   88: invokevirtual 234	java/io/BufferedReader:close	()V
    //   91: goto -25 -> 66
    //   94: astore_0
    //   95: goto -29 -> 66
    //   98: astore_1
    //   99: aconst_null
    //   100: astore_0
    //   101: aconst_null
    //   102: astore_2
    //   103: aload_0
    //   104: ifnull +7 -> 111
    //   107: aload_0
    //   108: invokevirtual 233	java/io/FileReader:close	()V
    //   111: aload_2
    //   112: ifnull +7 -> 119
    //   115: aload_2
    //   116: invokevirtual 234	java/io/BufferedReader:close	()V
    //   119: aload_1
    //   120: athrow
    //   121: astore_0
    //   122: goto -72 -> 50
    //   125: astore_0
    //   126: aload_1
    //   127: astore_0
    //   128: goto -72 -> 56
    //   131: astore_0
    //   132: goto -70 -> 62
    //   135: astore_0
    //   136: goto -70 -> 66
    //   139: astore_0
    //   140: goto -57 -> 83
    //   143: astore_0
    //   144: goto -33 -> 111
    //   147: astore_0
    //   148: goto -29 -> 119
    //   151: astore_1
    //   152: aconst_null
    //   153: astore_2
    //   154: goto -51 -> 103
    //   157: astore_1
    //   158: goto -55 -> 103
    //   161: astore_2
    //   162: goto -87 -> 75
    //   165: astore_1
    //   166: aload_2
    //   167: astore_1
    //   168: goto -93 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   5	64	0	localObject1	Object
    //   72	1	0	localThrowable1	Throwable
    //   74	6	0	localObject2	Object
    //   94	1	0	localThrowable2	Throwable
    //   100	8	0	localObject3	Object
    //   121	1	0	localThrowable3	Throwable
    //   125	1	0	localThrowable4	Throwable
    //   127	1	0	localObject4	Object
    //   131	1	0	localThrowable5	Throwable
    //   135	1	0	localThrowable6	Throwable
    //   139	1	0	localThrowable7	Throwable
    //   143	1	0	localThrowable8	Throwable
    //   147	1	0	localThrowable9	Throwable
    //   1	87	1	localObject5	Object
    //   98	29	1	localObject6	Object
    //   151	1	1	localObject7	Object
    //   157	1	1	localObject8	Object
    //   165	1	1	localThrowable10	Throwable
    //   167	1	1	localObject9	Object
    //   15	139	2	localBufferedReader	java.io.BufferedReader
    //   161	6	2	localThrowable11	Throwable
    // Exception table:
    //   from	to	target	type
    //   2	12	72	java/lang/Throwable
    //   87	91	94	java/lang/Throwable
    //   2	12	98	finally
    //   46	50	121	java/lang/Throwable
    //   50	54	125	java/lang/Throwable
    //   58	62	131	java/lang/Throwable
    //   62	66	135	java/lang/Throwable
    //   79	83	139	java/lang/Throwable
    //   107	111	143	java/lang/Throwable
    //   115	119	147	java/lang/Throwable
    //   12	21	151	finally
    //   21	32	157	finally
    //   36	42	157	finally
    //   12	21	161	java/lang/Throwable
    //   21	32	165	java/lang/Throwable
    //   36	42	165	java/lang/Throwable
  }
  
  public static String g(Context paramContext)
  {
    Object localObject;
    if (paramContext != null) {
      try
      {
        paramContext = (SensorManager)paramContext.getSystemService("sensor");
        if (paramContext != null)
        {
          localObject = paramContext.getSensorList(-1);
          if ((localObject != null) && (((List)localObject).size() > 0))
          {
            paramContext = new java/lang/StringBuilder;
            paramContext.<init>();
            Iterator localIterator = ((List)localObject).iterator();
            while (localIterator.hasNext())
            {
              localObject = (Sensor)localIterator.next();
              paramContext.append(((Sensor)localObject).getName());
              paramContext.append(((Sensor)localObject).getVersion());
              paramContext.append(((Sensor)localObject).getVendor());
            }
          }
        }
        paramContext = null;
      }
      catch (Throwable paramContext) {}
    }
    for (;;)
    {
      localObject = paramContext;
      if (paramContext == null) {
        localObject = "";
      }
      return (String)localObject;
      paramContext = a.d(paramContext.toString());
    }
  }
  
  /* Error */
  public static String h()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: lconst_0
    //   4: lstore_3
    //   5: new 221	java/io/FileReader
    //   8: astore 6
    //   10: aload 6
    //   12: ldc_w 289
    //   15: invokespecial 222	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   18: new 224	java/io/BufferedReader
    //   21: astore 7
    //   23: aload 7
    //   25: aload 6
    //   27: sipush 8192
    //   30: invokespecial 292	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   33: aload 7
    //   35: invokevirtual 226	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   38: astore 5
    //   40: lload_3
    //   41: lstore_1
    //   42: aload 5
    //   44: ifnull +20 -> 64
    //   47: aload 5
    //   49: ldc_w 294
    //   52: invokevirtual 297	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   55: iconst_1
    //   56: aaload
    //   57: invokestatic 302	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   60: istore_0
    //   61: iload_0
    //   62: i2l
    //   63: lstore_1
    //   64: aload 6
    //   66: invokevirtual 233	java/io/FileReader:close	()V
    //   69: aload 7
    //   71: invokevirtual 234	java/io/BufferedReader:close	()V
    //   74: lload_1
    //   75: invokestatic 83	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   78: areturn
    //   79: astore 6
    //   81: aconst_null
    //   82: astore 6
    //   84: aload 6
    //   86: ifnull +8 -> 94
    //   89: aload 6
    //   91: invokevirtual 233	java/io/FileReader:close	()V
    //   94: lload_3
    //   95: lstore_1
    //   96: aload 5
    //   98: ifnull -24 -> 74
    //   101: aload 5
    //   103: invokevirtual 234	java/io/BufferedReader:close	()V
    //   106: lload_3
    //   107: lstore_1
    //   108: goto -34 -> 74
    //   111: astore 5
    //   113: lload_3
    //   114: lstore_1
    //   115: goto -41 -> 74
    //   118: astore 5
    //   120: aconst_null
    //   121: astore 8
    //   123: aconst_null
    //   124: astore 6
    //   126: aload 8
    //   128: ifnull +8 -> 136
    //   131: aload 8
    //   133: invokevirtual 233	java/io/FileReader:close	()V
    //   136: aload 6
    //   138: ifnull +8 -> 146
    //   141: aload 6
    //   143: invokevirtual 234	java/io/BufferedReader:close	()V
    //   146: aload 5
    //   148: athrow
    //   149: astore 5
    //   151: goto -82 -> 69
    //   154: astore 5
    //   156: goto -82 -> 74
    //   159: astore 6
    //   161: goto -67 -> 94
    //   164: astore 7
    //   166: goto -30 -> 136
    //   169: astore 6
    //   171: goto -25 -> 146
    //   174: astore 5
    //   176: aconst_null
    //   177: astore 7
    //   179: aload 6
    //   181: astore 8
    //   183: aload 7
    //   185: astore 6
    //   187: goto -61 -> 126
    //   190: astore 5
    //   192: aload 6
    //   194: astore 8
    //   196: aload 7
    //   198: astore 6
    //   200: goto -74 -> 126
    //   203: astore 7
    //   205: goto -121 -> 84
    //   208: astore 5
    //   210: aload 7
    //   212: astore 5
    //   214: goto -130 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   60	2	0	i	int
    //   41	74	1	l1	long
    //   4	110	3	l2	long
    //   1	101	5	str	String
    //   111	1	5	localThrowable1	Throwable
    //   118	29	5	localObject1	Object
    //   149	1	5	localThrowable2	Throwable
    //   154	1	5	localThrowable3	Throwable
    //   174	1	5	localObject2	Object
    //   190	1	5	localObject3	Object
    //   208	1	5	localThrowable4	Throwable
    //   212	1	5	localObject4	Object
    //   8	57	6	localFileReader	java.io.FileReader
    //   79	1	6	localThrowable5	Throwable
    //   82	60	6	localObject5	Object
    //   159	1	6	localThrowable6	Throwable
    //   169	11	6	localThrowable7	Throwable
    //   185	14	6	localObject6	Object
    //   21	49	7	localBufferedReader	java.io.BufferedReader
    //   164	1	7	localThrowable8	Throwable
    //   177	20	7	localObject7	Object
    //   203	8	7	localThrowable9	Throwable
    //   121	74	8	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   5	18	79	java/lang/Throwable
    //   101	106	111	java/lang/Throwable
    //   5	18	118	finally
    //   64	69	149	java/lang/Throwable
    //   69	74	154	java/lang/Throwable
    //   89	94	159	java/lang/Throwable
    //   131	136	164	java/lang/Throwable
    //   141	146	169	java/lang/Throwable
    //   18	33	174	finally
    //   33	40	190	finally
    //   47	61	190	finally
    //   18	33	203	java/lang/Throwable
    //   33	40	208	java/lang/Throwable
    //   47	61	208	java/lang/Throwable
  }
  
  public static String h(Context paramContext)
  {
    localJSONArray = new JSONArray();
    if (paramContext != null) {
      try
      {
        paramContext = (SensorManager)paramContext.getSystemService("sensor");
        if (paramContext != null)
        {
          paramContext = paramContext.getSensorList(-1);
          if ((paramContext != null) && (paramContext.size() > 0))
          {
            Iterator localIterator = paramContext.iterator();
            while (localIterator.hasNext())
            {
              paramContext = (Sensor)localIterator.next();
              if (paramContext != null)
              {
                JSONObject localJSONObject = new org/json/JSONObject;
                localJSONObject.<init>();
                localJSONObject.put("name", paramContext.getName());
                localJSONObject.put("version", paramContext.getVersion());
                localJSONObject.put("vendor", paramContext.getVendor());
                localJSONArray.put(localJSONObject);
              }
            }
          }
        }
        return localJSONArray.toString();
      }
      catch (Throwable paramContext) {}
    }
  }
  
  public static String i()
  {
    long l1 = 0L;
    try
    {
      File localFile = Environment.getDataDirectory();
      StatFs localStatFs = new android/os/StatFs;
      localStatFs.<init>(localFile.getPath());
      long l2 = localStatFs.getBlockSize();
      int i = localStatFs.getBlockCount();
      l1 = i * l2;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
    return String.valueOf(l1);
  }
  
  public static String i(Context paramContext)
  {
    try
    {
      DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
      paramContext = new java/lang/StringBuilder;
      paramContext.<init>();
      paramContext = Integer.toString(localDisplayMetrics.widthPixels) + "*" + Integer.toString(localDisplayMetrics.heightPixels);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext = "";
      }
    }
  }
  
  public static String j()
  {
    l2 = 0L;
    l1 = l2;
    try
    {
      if ("mounted".equals(Environment.getExternalStorageState()))
      {
        File localFile = Environment.getExternalStorageDirectory();
        StatFs localStatFs = new android/os/StatFs;
        localStatFs.<init>(localFile.getPath());
        l1 = localStatFs.getBlockSize();
        int i = localStatFs.getBlockCount();
        l1 = i * l1;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        l1 = l2;
      }
    }
    return String.valueOf(l1);
  }
  
  public static String j(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getResources().getDisplayMetrics();
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      paramContext = paramContext.widthPixels;
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext = "";
      }
    }
  }
  
  public static String k()
  {
    try
    {
      Object localObject2 = Class.forName("android.os.SystemProperties");
      Object localObject1 = ((Class)localObject2).newInstance();
      localObject1 = (String)((Class)localObject2).getMethod("get", new Class[] { String.class, String.class }).invoke(localObject1, new Object[] { "gsm.version.baseband", "no message" });
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      return (String)localObject2;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        String str = "";
      }
    }
  }
  
  public static String k(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getResources().getDisplayMetrics();
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      paramContext = paramContext.heightPixels;
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext = "";
      }
    }
  }
  
  public static String l()
  {
    Object localObject1 = "";
    try
    {
      localObject2 = Build.SERIAL;
      localObject1 = localObject2;
    }
    catch (Throwable localThrowable)
    {
      Object localObject2;
      for (;;) {}
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    return (String)localObject2;
  }
  
  public static String l(Context paramContext)
  {
    if (a(paramContext, "android.permission.ACCESS_WIFI_STATE")) {
      paramContext = "";
    }
    for (;;)
    {
      return paramContext;
      try
      {
        str = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getMacAddress();
        if (str == null) {}
      }
      catch (Throwable paramContext)
      {
        try
        {
          if (str.length() != 0)
          {
            paramContext = str;
            if (!"02:00:00:00:00:00".equals(str)) {
              continue;
            }
          }
          paramContext = v();
        }
        catch (Throwable paramContext)
        {
          String str;
          paramContext = str;
        }
        paramContext = paramContext;
        paramContext = "";
      }
    }
  }
  
  public static String m()
  {
    Object localObject1 = "";
    try
    {
      localObject2 = Locale.getDefault().toString();
      localObject1 = localObject2;
    }
    catch (Throwable localThrowable)
    {
      Object localObject2;
      for (;;) {}
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    return (String)localObject2;
  }
  
  public static String m(Context paramContext)
  {
    if (a(paramContext, "android.permission.READ_PHONE_STATE")) {
      paramContext = "";
    }
    for (;;)
    {
      return paramContext;
      try
      {
        str = ((TelephonyManager)paramContext.getSystemService("phone")).getSimSerialNumber();
        if (str != null)
        {
          paramContext = str;
          if (str == null) {
            continue;
          }
          paramContext = str;
        }
      }
      catch (Throwable paramContext)
      {
        try
        {
          if (str.length() != 0) {
            continue;
          }
          paramContext = "";
        }
        catch (Throwable paramContext)
        {
          String str;
          paramContext = str;
        }
        paramContext = paramContext;
        paramContext = "";
      }
    }
  }
  
  public static String n()
  {
    Object localObject1 = "";
    try
    {
      localObject2 = TimeZone.getDefault().getDisplayName(false, 0);
      localObject1 = localObject2;
    }
    catch (Throwable localThrowable)
    {
      Object localObject2;
      for (;;) {}
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    return (String)localObject2;
  }
  
  public static String n(Context paramContext)
  {
    Object localObject = "";
    try
    {
      paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      localObject = paramContext;
      if (paramContext == null) {
        localObject = "";
      }
      return (String)localObject;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext = (Context)localObject;
      }
    }
  }
  
  public static String o()
  {
    try
    {
      long l = System.currentTimeMillis() - SystemClock.elapsedRealtime();
      Object localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      localObject = l - l % 1000L;
      return (String)localObject;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        String str = "";
      }
    }
  }
  
  public static String o(Context paramContext)
  {
    if (a(paramContext, "android.permission.BLUETOOTH")) {
      paramContext = "";
    }
    for (;;)
    {
      return paramContext;
      String str3 = y();
      String str2;
      if (str3 != null) {
        str2 = str3;
      }
      try
      {
        String str1;
        if (str3.length() != 0)
        {
          str1 = str3;
          str2 = str3;
          if (!"02:00:00:00:00:00".equals(str3)) {}
        }
        else
        {
          str2 = str3;
          str1 = Settings.Secure.getString(paramContext.getContentResolver(), "bluetooth_address");
        }
        paramContext = str1;
        if (str1 == null) {
          paramContext = "";
        }
      }
      catch (Throwable paramContext)
      {
        paramContext = str2;
      }
    }
  }
  
  public static String p()
  {
    try
    {
      Object localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      localObject = SystemClock.elapsedRealtime();
      return (String)localObject;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        String str = "";
      }
    }
  }
  
  public static String p(Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext == null) {
        break label27;
      }
      int i = paramContext.getNetworkType();
      paramContext = String.valueOf(i);
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        label27:
        paramContext = "";
      }
    }
    return paramContext;
  }
  
  public static String q()
  {
    int i = 0;
    String str;
    try
    {
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      Object localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      localStringBuilder.append("00" + ":");
      if (i < 7)
      {
        localObject = new String[] { "/dev/qemu_pipe", "/dev/socket/qemud", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/genyd", "/dev/socket/baseband_genyd" }[i];
        File localFile = new java/io/File;
        localFile.<init>((String)localObject);
        if (localFile.exists()) {
          localStringBuilder.append("1");
        }
        for (;;)
        {
          i++;
          break;
          localStringBuilder.append("0");
        }
        return str;
      }
    }
    catch (Throwable localThrowable)
    {
      str = "";
    }
    for (;;)
    {
      str = str.toString();
    }
  }
  
  public static String q(Context paramContext)
  {
    if (a(paramContext, "android.permission.ACCESS_WIFI_STATE")) {
      paramContext = "";
    }
    for (;;)
    {
      return paramContext;
      try
      {
        paramContext = (WifiManager)paramContext.getSystemService("wifi");
        if (paramContext.isWifiEnabled())
        {
          str = paramContext.getConnectionInfo().getBSSID();
          paramContext = str;
          if (str != null) {
            continue;
          }
          paramContext = "";
        }
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          String str = "";
        }
      }
    }
  }
  
  public static String r()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("00");
    localStringBuilder.append(":");
    int i = 0;
    for (;;)
    {
      if (i <= 0)
      {
        String str = new String[] { "dalvik.system.Taint" }[0];
        try
        {
          Class.forName(str);
          localStringBuilder.append("1");
          i++;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            localStringBuilder.append("0");
          }
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String r(Context paramContext)
  {
    str1 = "";
    try
    {
      String str2 = u(paramContext);
      String str3 = z();
      paramContext = str1;
      if (a.b(str2))
      {
        paramContext = str1;
        if (a.b(str3))
        {
          paramContext = new java/lang/StringBuilder;
          paramContext.<init>();
          paramContext = str2 + ":" + z();
        }
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext = str1;
      }
    }
    return paramContext;
  }
  
  /* Error */
  public static String s()
  {
    // Byte code:
    //   0: new 249	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 250	java/lang/StringBuilder:<init>	()V
    //   7: astore 5
    //   9: new 501	java/util/LinkedHashMap
    //   12: dup
    //   13: invokespecial 502	java/util/LinkedHashMap:<init>	()V
    //   16: astore 4
    //   18: aload 4
    //   20: ldc_w 504
    //   23: ldc_w 506
    //   26: invokeinterface 511 3 0
    //   31: pop
    //   32: aload 4
    //   34: ldc_w 513
    //   37: ldc_w 515
    //   40: invokeinterface 511 3 0
    //   45: pop
    //   46: aload 4
    //   48: ldc 121
    //   50: ldc_w 515
    //   53: invokeinterface 511 3 0
    //   58: pop
    //   59: aload 5
    //   61: new 249	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 250	java/lang/StringBuilder:<init>	()V
    //   68: ldc_w 464
    //   71: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: ldc -110
    //   76: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload 4
    //   88: invokeinterface 519 1 0
    //   93: invokeinterface 522 1 0
    //   98: astore 6
    //   100: aload 6
    //   102: invokeinterface 260 1 0
    //   107: ifeq +150 -> 257
    //   110: aload 6
    //   112: invokeinterface 264 1 0
    //   117: checkcast 79	java/lang/String
    //   120: astore 7
    //   122: aconst_null
    //   123: astore_3
    //   124: new 132	java/io/LineNumberReader
    //   127: astore_2
    //   128: new 127	java/io/InputStreamReader
    //   131: astore 9
    //   133: new 119	java/io/FileInputStream
    //   136: astore 8
    //   138: aload 8
    //   140: aload 7
    //   142: invokespecial 523	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   145: aload 9
    //   147: aload 8
    //   149: invokespecial 130	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   152: aload_2
    //   153: aload 9
    //   155: invokespecial 135	java/io/LineNumberReader:<init>	(Ljava/io/Reader;)V
    //   158: aload_2
    //   159: invokevirtual 138	java/io/LineNumberReader:readLine	()Ljava/lang/String;
    //   162: astore_3
    //   163: aload_3
    //   164: ifnull +119 -> 283
    //   167: aload_3
    //   168: invokevirtual 526	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   171: aload 4
    //   173: aload 7
    //   175: invokeinterface 529 2 0
    //   180: checkcast 531	java/lang/CharSequence
    //   183: invokevirtual 535	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   186: istore_1
    //   187: iload_1
    //   188: ifeq -30 -> 158
    //   191: bipush 49
    //   193: istore_0
    //   194: aload 5
    //   196: iload_0
    //   197: invokevirtual 538	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload_2
    //   202: invokevirtual 159	java/io/LineNumberReader:close	()V
    //   205: goto -105 -> 100
    //   208: astore_2
    //   209: goto -109 -> 100
    //   212: astore_2
    //   213: aconst_null
    //   214: astore_2
    //   215: aload 5
    //   217: bipush 48
    //   219: invokevirtual 538	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload_2
    //   224: ifnull -124 -> 100
    //   227: aload_2
    //   228: invokevirtual 159	java/io/LineNumberReader:close	()V
    //   231: goto -131 -> 100
    //   234: astore_2
    //   235: goto -135 -> 100
    //   238: astore_2
    //   239: aload 5
    //   241: bipush 48
    //   243: invokevirtual 538	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload_3
    //   248: ifnull +7 -> 255
    //   251: aload_3
    //   252: invokevirtual 159	java/io/LineNumberReader:close	()V
    //   255: aload_2
    //   256: athrow
    //   257: aload 5
    //   259: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: areturn
    //   263: astore_3
    //   264: goto -9 -> 255
    //   267: astore_3
    //   268: aload_2
    //   269: astore 4
    //   271: aload_3
    //   272: astore_2
    //   273: aload 4
    //   275: astore_3
    //   276: goto -37 -> 239
    //   279: astore_3
    //   280: goto -65 -> 215
    //   283: bipush 48
    //   285: istore_0
    //   286: goto -92 -> 194
    // Local variable table:
    //   start	length	slot	name	signature
    //   193	93	0	c	char
    //   186	2	1	bool	boolean
    //   127	75	2	localLineNumberReader	java.io.LineNumberReader
    //   208	1	2	localThrowable1	Throwable
    //   212	1	2	localThrowable2	Throwable
    //   214	14	2	localObject1	Object
    //   234	1	2	localThrowable3	Throwable
    //   238	31	2	localObject2	Object
    //   272	1	2	localObject3	Object
    //   123	129	3	str1	String
    //   263	1	3	localThrowable4	Throwable
    //   267	5	3	localObject4	Object
    //   275	1	3	localObject5	Object
    //   279	1	3	localThrowable5	Throwable
    //   16	258	4	localObject6	Object
    //   7	251	5	localStringBuilder	StringBuilder
    //   98	13	6	localIterator	Iterator
    //   120	54	7	str2	String
    //   136	12	8	localFileInputStream	java.io.FileInputStream
    //   131	23	9	localInputStreamReader	java.io.InputStreamReader
    // Exception table:
    //   from	to	target	type
    //   201	205	208	java/lang/Throwable
    //   124	158	212	java/lang/Throwable
    //   227	231	234	java/lang/Throwable
    //   124	158	238	finally
    //   251	255	263	java/lang/Throwable
    //   158	163	267	finally
    //   167	187	267	finally
    //   158	163	279	java/lang/Throwable
    //   167	187	279	java/lang/Throwable
  }
  
  public static String s(Context paramContext)
  {
    try
    {
      if (((KeyguardManager)paramContext.getSystemService("keyguard")).isKeyguardSecure()) {
        break label22;
      }
      paramContext = "0:0";
    }
    catch (Throwable paramContext)
    {
      try
      {
        for (;;)
        {
          label22:
          int i;
          String str;
          paramContext = new java/io/File;
          paramContext.<init>(str);
          l2 = paramContext.lastModified();
          long l1 = Math.max(l2, l1);
          i++;
          continue;
          paramContext = new java/lang/StringBuilder;
          paramContext.<init>("1:");
          paramContext = l1;
        }
        paramContext = paramContext;
        paramContext = "";
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          long l3;
          long l2 = l3;
        }
      }
    }
    return paramContext;
    i = 0;
    l1 = 0L;
    if (i < 5)
    {
      str = new String[] { "/data/system/password.key", "/data/system/gesture.key", "/data/system/gatekeeper.password.key", "/data/system/gatekeeper.gesture.key", "/data/system/gatekeeper.pattern.key" }[i];
      l3 = -1L;
    }
  }
  
  public static String t()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("00" + ":");
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put("BRAND", "generic");
    localLinkedHashMap.put("BOARD", "unknown");
    localLinkedHashMap.put("DEVICE", "generic");
    localLinkedHashMap.put("HARDWARE", "goldfish");
    localLinkedHashMap.put("PRODUCT", "sdk");
    localLinkedHashMap.put("MODEL", "sdk");
    Iterator localIterator = localLinkedHashMap.keySet().iterator();
    String str2;
    if (localIterator.hasNext()) {
      str2 = (String)localIterator.next();
    }
    for (;;)
    {
      try
      {
        String str1 = (String)Build.class.getField(str2).get(null);
        str2 = (String)localLinkedHashMap.get(str2);
        if (str1 == null) {
          break label261;
        }
        str1 = str1.toLowerCase();
        if (str1 == null) {
          break label255;
        }
        boolean bool = str1.contains(str2);
        if (!bool) {
          break label255;
        }
        c = '1';
        localStringBuilder.append(c);
        break;
      }
      catch (Throwable localThrowable)
      {
        localStringBuilder.append('0');
        break;
      }
      finally
      {
        localStringBuilder.append('0');
      }
      return localStringBuilder.toString();
      label255:
      char c = '0';
      continue;
      label261:
      Object localObject2 = null;
    }
  }
  
  public static String t(Context paramContext)
  {
    for (;;)
    {
      try
      {
        Object localObject = new android/content/IntentFilter;
        ((IntentFilter)localObject).<init>("android.intent.action.BATTERY_CHANGED");
        paramContext = paramContext.registerReceiver(null, (IntentFilter)localObject);
        int j = paramContext.getIntExtra("level", -1);
        i = paramContext.getIntExtra("status", -1);
        if ((i != 2) && (i != 5)) {
          continue;
        }
        i = 1;
        localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>();
        if (i == 0) {
          continue;
        }
        paramContext = "1";
        paramContext = paramContext + ":" + j;
      }
      catch (Throwable paramContext)
      {
        int i;
        paramContext = "";
        continue;
      }
      return paramContext;
      i = 0;
      continue;
      paramContext = "0";
    }
  }
  
  public static String u()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("00" + ":");
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put("ro.hardware", "goldfish");
    localLinkedHashMap.put("ro.kernel.qemu", "1");
    localLinkedHashMap.put("ro.product.device", "generic");
    localLinkedHashMap.put("ro.product.model", "sdk");
    localLinkedHashMap.put("ro.product.brand", "generic");
    localLinkedHashMap.put("ro.product.name", "sdk");
    localLinkedHashMap.put("ro.build.fingerprint", "test-keys");
    localLinkedHashMap.put("ro.product.manufacturer", "unknow");
    Iterator localIterator = localLinkedHashMap.keySet().iterator();
    if (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      String str1 = (String)localLinkedHashMap.get(str2);
      str2 = a.b(str2, "");
      if ((str2 == null) || (!str2.contains(str1))) {
        break label233;
      }
    }
    label233:
    for (char c = '1';; c = '0')
    {
      localStringBuilder.append(c);
      break;
      return localStringBuilder.toString();
    }
  }
  
  private static String u(Context paramContext)
  {
    Object localObject = null;
    if (a(paramContext, "android.permission.ACCESS_NETWORK_STATE"))
    {
      paramContext = "";
      return paramContext;
    }
    for (;;)
    {
      try
      {
        NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        paramContext = (Context)localObject;
        if (localNetworkInfo == null) {
          break;
        }
        if (localNetworkInfo.getType() == 1)
        {
          paramContext = "WIFI";
          break;
        }
        if (localNetworkInfo.getType() != 0) {
          break label183;
        }
        int i = localNetworkInfo.getSubtype();
        if ((i == 4) || (i == 1) || (i == 2) || (i == 7) || (i == 11))
        {
          paramContext = "2G";
          break;
        }
        if ((i == 3) || (i == 5) || (i == 6) || (i == 8) || (i == 9) || (i == 10) || (i == 12) || (i == 14) || (i == 15))
        {
          paramContext = "3G";
          break;
        }
        if (i == 13)
        {
          paramContext = "4G";
          break;
        }
        paramContext = "UNKNOW";
      }
      catch (Throwable paramContext)
      {
        paramContext = (Context)localObject;
      }
      break;
      label183:
      paramContext = null;
    }
  }
  
  private static String v()
  {
    for (;;)
    {
      try
      {
        localObject1 = Collections.list(NetworkInterface.getNetworkInterfaces());
        if (localObject1 == null) {
          continue;
        }
        localObject2 = ((List)localObject1).iterator();
        if (!((Iterator)localObject2).hasNext()) {
          continue;
        }
        localObject1 = (NetworkInterface)((Iterator)localObject2).next();
        if ((localObject1 == null) || (((NetworkInterface)localObject1).getName() == null) || (!((NetworkInterface)localObject1).getName().equalsIgnoreCase("wlan0"))) {
          continue;
        }
        localObject2 = ((NetworkInterface)localObject1).getHardwareAddress();
        if (localObject2 != null) {
          continue;
        }
        localObject1 = "02:00:00:00:00:00";
      }
      catch (Throwable localThrowable)
      {
        Object localObject1;
        Object localObject2;
        int j;
        int i;
        String str = "02:00:00:00:00:00";
        continue;
      }
      return (String)localObject1;
      localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>();
      j = localObject2.length;
      i = 0;
      if (i < j)
      {
        ((StringBuilder)localObject1).append(String.format("%02X:", new Object[] { Integer.valueOf(localObject2[i] & 0xFF) }));
        i++;
      }
      else
      {
        if (((StringBuilder)localObject1).length() > 0) {
          ((StringBuilder)localObject1).deleteCharAt(((StringBuilder)localObject1).length() - 1);
        }
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
  }
  
  /* Error */
  private static String w()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 221	java/io/FileReader
    //   5: astore_0
    //   6: aload_0
    //   7: ldc_w 704
    //   10: invokespecial 222	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   13: new 224	java/io/BufferedReader
    //   16: astore_2
    //   17: aload_2
    //   18: aload_0
    //   19: sipush 8192
    //   22: invokespecial 292	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   25: aload_2
    //   26: invokevirtual 226	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   29: astore_1
    //   30: aload_1
    //   31: invokestatic 212	com/alipay/c/a/a/a/a:a	(Ljava/lang/String;)Z
    //   34: ifne +18 -> 52
    //   37: aload_1
    //   38: invokevirtual 156	java/lang/String:trim	()Ljava/lang/String;
    //   41: astore_1
    //   42: aload_2
    //   43: invokevirtual 234	java/io/BufferedReader:close	()V
    //   46: aload_0
    //   47: invokevirtual 233	java/io/FileReader:close	()V
    //   50: aload_1
    //   51: areturn
    //   52: aload_2
    //   53: invokevirtual 234	java/io/BufferedReader:close	()V
    //   56: aload_0
    //   57: invokevirtual 233	java/io/FileReader:close	()V
    //   60: ldc 26
    //   62: astore_1
    //   63: goto -13 -> 50
    //   66: astore_0
    //   67: aconst_null
    //   68: astore_0
    //   69: aload_1
    //   70: ifnull +7 -> 77
    //   73: aload_1
    //   74: invokevirtual 234	java/io/BufferedReader:close	()V
    //   77: aload_0
    //   78: ifnull -18 -> 60
    //   81: aload_0
    //   82: invokevirtual 233	java/io/FileReader:close	()V
    //   85: goto -25 -> 60
    //   88: astore_0
    //   89: goto -29 -> 60
    //   92: astore_1
    //   93: aconst_null
    //   94: astore_0
    //   95: aconst_null
    //   96: astore_2
    //   97: aload_2
    //   98: ifnull +7 -> 105
    //   101: aload_2
    //   102: invokevirtual 234	java/io/BufferedReader:close	()V
    //   105: aload_0
    //   106: ifnull +7 -> 113
    //   109: aload_0
    //   110: invokevirtual 233	java/io/FileReader:close	()V
    //   113: aload_1
    //   114: athrow
    //   115: astore_2
    //   116: goto -70 -> 46
    //   119: astore_0
    //   120: goto -70 -> 50
    //   123: astore_1
    //   124: goto -68 -> 56
    //   127: astore_0
    //   128: goto -68 -> 60
    //   131: astore_1
    //   132: goto -55 -> 77
    //   135: astore_2
    //   136: goto -31 -> 105
    //   139: astore_0
    //   140: goto -27 -> 113
    //   143: astore_1
    //   144: aconst_null
    //   145: astore_2
    //   146: goto -49 -> 97
    //   149: astore_1
    //   150: goto -53 -> 97
    //   153: astore_2
    //   154: goto -85 -> 69
    //   157: astore_1
    //   158: aload_2
    //   159: astore_1
    //   160: goto -91 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   5	52	0	localFileReader	java.io.FileReader
    //   66	1	0	localThrowable1	Throwable
    //   68	14	0	localObject1	Object
    //   88	1	0	localThrowable2	Throwable
    //   94	16	0	localObject2	Object
    //   119	1	0	localThrowable3	Throwable
    //   127	1	0	localThrowable4	Throwable
    //   139	1	0	localThrowable5	Throwable
    //   1	73	1	str	String
    //   92	22	1	localObject3	Object
    //   123	1	1	localThrowable6	Throwable
    //   131	1	1	localThrowable7	Throwable
    //   143	1	1	localObject4	Object
    //   149	1	1	localObject5	Object
    //   157	1	1	localThrowable8	Throwable
    //   159	1	1	localObject6	Object
    //   16	86	2	localBufferedReader	java.io.BufferedReader
    //   115	1	2	localThrowable9	Throwable
    //   135	1	2	localThrowable10	Throwable
    //   145	1	2	localObject7	Object
    //   153	6	2	localThrowable11	Throwable
    // Exception table:
    //   from	to	target	type
    //   2	13	66	java/lang/Throwable
    //   81	85	88	java/lang/Throwable
    //   2	13	92	finally
    //   42	46	115	java/lang/Throwable
    //   46	50	119	java/lang/Throwable
    //   52	56	123	java/lang/Throwable
    //   56	60	127	java/lang/Throwable
    //   73	77	131	java/lang/Throwable
    //   101	105	135	java/lang/Throwable
    //   109	113	139	java/lang/Throwable
    //   13	25	143	finally
    //   25	42	149	finally
    //   13	25	153	java/lang/Throwable
    //   25	42	157	java/lang/Throwable
  }
  
  /* Error */
  private static String x()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: ldc 26
    //   4: astore_2
    //   5: new 221	java/io/FileReader
    //   8: astore_0
    //   9: aload_0
    //   10: ldc 121
    //   12: invokespecial 222	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   15: new 224	java/io/BufferedReader
    //   18: astore_3
    //   19: aload_3
    //   20: aload_0
    //   21: sipush 8192
    //   24: invokespecial 292	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   27: aload_3
    //   28: invokevirtual 226	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   31: astore 4
    //   33: aload_2
    //   34: astore_1
    //   35: aload 4
    //   37: ifnull +48 -> 85
    //   40: aload 4
    //   42: invokestatic 212	com/alipay/c/a/a/a/a:a	(Ljava/lang/String;)Z
    //   45: ifne -18 -> 27
    //   48: aload 4
    //   50: ldc -110
    //   52: invokevirtual 297	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   55: astore_1
    //   56: aload_1
    //   57: ifnull -30 -> 27
    //   60: aload_1
    //   61: arraylength
    //   62: iconst_1
    //   63: if_icmple -36 -> 27
    //   66: aload_1
    //   67: iconst_0
    //   68: aaload
    //   69: ldc_w 706
    //   72: invokevirtual 535	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   75: ifeq -48 -> 27
    //   78: aload_1
    //   79: iconst_1
    //   80: aaload
    //   81: invokevirtual 156	java/lang/String:trim	()Ljava/lang/String;
    //   84: astore_1
    //   85: aload_0
    //   86: invokevirtual 233	java/io/FileReader:close	()V
    //   89: aload_3
    //   90: invokevirtual 234	java/io/BufferedReader:close	()V
    //   93: aload_1
    //   94: areturn
    //   95: astore_0
    //   96: aconst_null
    //   97: astore_0
    //   98: aload_1
    //   99: ifnull +7 -> 106
    //   102: aload_1
    //   103: invokevirtual 233	java/io/FileReader:close	()V
    //   106: aload_2
    //   107: astore_1
    //   108: aload_0
    //   109: ifnull -16 -> 93
    //   112: aload_0
    //   113: invokevirtual 234	java/io/BufferedReader:close	()V
    //   116: aload_2
    //   117: astore_1
    //   118: goto -25 -> 93
    //   121: astore_0
    //   122: aload_2
    //   123: astore_1
    //   124: goto -31 -> 93
    //   127: astore_1
    //   128: aconst_null
    //   129: astore_2
    //   130: aconst_null
    //   131: astore_0
    //   132: aload_0
    //   133: ifnull +7 -> 140
    //   136: aload_0
    //   137: invokevirtual 233	java/io/FileReader:close	()V
    //   140: aload_2
    //   141: ifnull +7 -> 148
    //   144: aload_2
    //   145: invokevirtual 234	java/io/BufferedReader:close	()V
    //   148: aload_1
    //   149: athrow
    //   150: astore_0
    //   151: goto -62 -> 89
    //   154: astore_0
    //   155: goto -62 -> 93
    //   158: astore_1
    //   159: goto -53 -> 106
    //   162: astore_0
    //   163: goto -23 -> 140
    //   166: astore_0
    //   167: goto -19 -> 148
    //   170: astore_1
    //   171: aconst_null
    //   172: astore_2
    //   173: goto -41 -> 132
    //   176: astore_1
    //   177: aload_3
    //   178: astore_2
    //   179: goto -47 -> 132
    //   182: astore_1
    //   183: aconst_null
    //   184: astore_3
    //   185: aload_0
    //   186: astore_1
    //   187: aload_3
    //   188: astore_0
    //   189: goto -91 -> 98
    //   192: astore_1
    //   193: aload_0
    //   194: astore_1
    //   195: aload_3
    //   196: astore_0
    //   197: goto -99 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   8	78	0	localFileReader	java.io.FileReader
    //   95	1	0	localThrowable1	Throwable
    //   97	16	0	localObject1	Object
    //   121	1	0	localThrowable2	Throwable
    //   131	6	0	localObject2	Object
    //   150	1	0	localThrowable3	Throwable
    //   154	1	0	localThrowable4	Throwable
    //   162	1	0	localThrowable5	Throwable
    //   166	20	0	localThrowable6	Throwable
    //   188	9	0	localObject3	Object
    //   1	123	1	localObject4	Object
    //   127	22	1	localObject5	Object
    //   158	1	1	localThrowable7	Throwable
    //   170	1	1	localObject6	Object
    //   176	1	1	localObject7	Object
    //   182	1	1	localThrowable8	Throwable
    //   186	1	1	localObject8	Object
    //   192	1	1	localThrowable9	Throwable
    //   194	1	1	localObject9	Object
    //   4	175	2	localObject10	Object
    //   18	178	3	localBufferedReader	java.io.BufferedReader
    //   31	18	4	str	String
    // Exception table:
    //   from	to	target	type
    //   5	15	95	java/lang/Throwable
    //   112	116	121	java/lang/Throwable
    //   5	15	127	finally
    //   85	89	150	java/lang/Throwable
    //   89	93	154	java/lang/Throwable
    //   102	106	158	java/lang/Throwable
    //   136	140	162	java/lang/Throwable
    //   144	148	166	java/lang/Throwable
    //   15	27	170	finally
    //   27	33	176	finally
    //   40	56	176	finally
    //   60	85	176	finally
    //   15	27	182	java/lang/Throwable
    //   27	33	192	java/lang/Throwable
    //   40	56	192	java/lang/Throwable
    //   60	85	192	java/lang/Throwable
  }
  
  private static String y()
  {
    Object localObject1 = "";
    for (;;)
    {
      try
      {
        localObject2 = BluetoothAdapter.getDefaultAdapter();
        if ((localObject2 != null) && (!((BluetoothAdapter)localObject2).isEnabled()))
        {
          localObject2 = "";
          return (String)localObject2;
        }
        localObject2 = ((BluetoothAdapter)localObject2).getAddress();
        localObject1 = localObject2;
      }
      catch (Throwable localThrowable)
      {
        Object localObject2;
        continue;
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
    }
  }
  
  private static String z()
  {
    try
    {
      InetAddress localInetAddress;
      do
      {
        Enumeration localEnumeration = NetworkInterface.getNetworkInterfaces();
        while (!((Enumeration)localObject).hasMoreElements())
        {
          if (!localEnumeration.hasMoreElements()) {
            break;
          }
          localObject = ((NetworkInterface)localEnumeration.nextElement()).getInetAddresses();
        }
        localInetAddress = (InetAddress)((Enumeration)localObject).nextElement();
      } while ((localInetAddress.isLoopbackAddress()) || (!(localInetAddress instanceof Inet4Address)));
      localObject = localInetAddress.getHostAddress().toString();
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject;
        String str = "";
      }
    }
    return (String)localObject;
  }
  
  public final String e()
  {
    try
    {
      File localFile = new java/io/File;
      localFile.<init>("/sys/devices/system/cpu/");
      localObject = new com/alipay/c/a/a/b/c;
      ((c)localObject).<init>(this);
      int i = localFile.listFiles((FileFilter)localObject).length;
      localObject = String.valueOf(i);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject;
        String str = "1";
      }
    }
    return (String)localObject;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/c/a/a/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */