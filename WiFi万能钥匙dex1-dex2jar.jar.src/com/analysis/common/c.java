package com.analysis.common;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.analysis.common.tools.a;
import com.analysis.common.tools.b;
import com.qihoo.util.StubApp1053578832;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class c
{
  private static final String a = c.class.getSimpleName();
  
  private static int a(DisplayMetrics paramDisplayMetrics, String paramString)
  {
    try
    {
      paramString = DisplayMetrics.class.getDeclaredField(paramString);
      paramString.setAccessible(true);
      i = paramString.getInt(paramDisplayMetrics);
      return i;
    }
    catch (Exception paramDisplayMetrics)
    {
      for (;;)
      {
        paramDisplayMetrics.printStackTrace();
        int i = -1;
      }
    }
  }
  
  public static String a()
  {
    return e()[0];
  }
  
  public static String a(Context paramContext)
  {
    return paramContext.getPackageName();
  }
  
  public static String a(Context paramContext, SharedPreferences paramSharedPreferences)
  {
    Object localObject = paramSharedPreferences.getString("session_location", "null");
    long l = paramSharedPreferences.getLong("session_location_time", 0L);
    if (System.currentTimeMillis() - l > 3600000L) {}
    for (paramSharedPreferences = "null";; paramSharedPreferences = (SharedPreferences)localObject)
    {
      localObject = paramSharedPreferences;
      if (paramSharedPreferences.equals("null")) {}
      try
      {
        paramContext = StubApp1053578832.mark((LocationManager)paramContext.getSystemService("location"), "network");
        localObject = paramSharedPreferences;
        if (paramContext != null)
        {
          localObject = new java/lang/StringBuilder;
          ((StringBuilder)localObject).<init>();
          localObject = paramContext.getLongitude() + "*" + paramContext.getLatitude();
        }
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
          localObject = paramSharedPreferences;
        }
      }
      return (String)localObject;
    }
  }
  
  private static String a(String paramString)
  {
    return paramString.replace(".", "");
  }
  
  public static int b(Context paramContext)
  {
    int j = 0;
    try
    {
      i = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        int i = j;
      }
    }
  }
  
  public static String b()
  {
    return e()[1];
  }
  
  public static String c()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(localDate);
  }
  
  public static String c(Context paramContext)
  {
    String str2 = paramContext.getSharedPreferences("sp_general_config", 0).getString("version_name", "null");
    String str1 = str2;
    if (str2.equals("null")) {}
    try
    {
      str1 = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName.replace(".", "");
      return str1;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        str1 = "1.0.0";
      }
    }
  }
  
  public static String d()
  {
    return Build.VERSION.RELEASE;
  }
  
  public static String d(Context paramContext)
  {
    return b.a(paramContext);
  }
  
  public static String e(Context paramContext)
  {
    Object localObject = (TelephonyManager)paramContext.getSystemService("phone");
    int i;
    if (localObject == null)
    {
      i = 0;
      if ((i == 0) || (!com.analysis.common.tools.c.a(paramContext, "android.permission.READ_PHONE_STATE"))) {
        break label62;
      }
    }
    label62:
    for (paramContext = ((TelephonyManager)localObject).getSubscriberId();; paramContext = "")
    {
      localObject = paramContext;
      if (com.analysis.common.tools.c.a(paramContext))
      {
        localObject = com.analysis.common.tools.c.a();
        a.a(a, "No imsi");
      }
      return (String)localObject;
      i = 1;
      break;
    }
  }
  
  private static String[] e()
  {
    int i = 0;
    String[] arrayOfString = new String[2];
    arrayOfString[0] = com.analysis.common.tools.c.a();
    arrayOfString[1] = com.analysis.common.tools.c.a();
    BufferedReader localBufferedReader = null;
    for (;;)
    {
      try
      {
        localFileReader = new java/io/FileReader;
        localFileReader.<init>("/proc/cpuinfo");
        if (i >= 2) {}
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        FileReader localFileReader;
        String str;
        localFileNotFoundException.printStackTrace();
        continue;
      }
      try
      {
        localBufferedReader = new java/io/BufferedReader;
        localBufferedReader.<init>(localFileReader, 1024);
        str = localBufferedReader.readLine();
        if (com.analysis.common.tools.c.b(str)) {
          arrayOfString[i] = str.split("\\s+")[2];
        }
        i++;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
    }
    localBufferedReader.close();
    localFileReader.close();
    return arrayOfString;
  }
  
  public static String f(Context paramContext)
  {
    Object localObject = (WifiManager)paramContext.getSystemService("wifi");
    if (com.analysis.common.tools.c.a(paramContext, "android.permission.ACCESS_WIFI_STATE")) {}
    for (paramContext = ((WifiManager)localObject).getConnectionInfo().getMacAddress();; paramContext = "")
    {
      localObject = paramContext;
      if (com.analysis.common.tools.c.a(paramContext))
      {
        localObject = com.analysis.common.tools.c.a();
        a.a(a, "No mac address");
      }
      return (String)localObject;
    }
  }
  
  private static String[] f()
  {
    return new String[] { com.analysis.common.tools.c.a(), com.analysis.common.tools.c.a() };
  }
  
  private static String g()
  {
    return "Unknown";
  }
  
  public static String g(Context paramContext)
  {
    String str = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    paramContext = str;
    if (com.analysis.common.tools.c.a(str)) {
      paramContext = com.analysis.common.tools.c.a();
    }
    return paramContext;
  }
  
  public static String[] h(Context paramContext)
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = com.analysis.common.tools.c.a();
    arrayOfString[1] = com.analysis.common.tools.c.a();
    if (!com.analysis.common.tools.c.a(paramContext, "android.permission.ACCESS_NETWORK_STATE")) {}
    for (;;)
    {
      return arrayOfString;
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (!com.analysis.common.tools.c.a(paramContext)) {
        if (paramContext.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED)
        {
          arrayOfString[0] = "Wi-Fi";
        }
        else
        {
          paramContext = paramContext.getNetworkInfo(0);
          if (paramContext.getState() == NetworkInfo.State.CONNECTED)
          {
            arrayOfString[0] = "2G/3G";
            arrayOfString[1] = paramContext.getSubtypeName();
          }
        }
      }
    }
  }
  
  public static int i(Context paramContext)
  {
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    int i;
    if (com.analysis.common.tools.c.a(paramContext)) {
      i = 5;
    }
    for (;;)
    {
      return i;
      paramContext = paramContext.getSubscriberId();
      if (paramContext == null) {
        i = 0;
      }
      for (;;)
      {
        if (i != 0)
        {
          if ((paramContext.startsWith("46000")) || (paramContext.startsWith("46002")) || (paramContext.startsWith("46007")))
          {
            i = 1;
            break;
            i = 1;
            continue;
          }
          if (paramContext.startsWith("46001"))
          {
            i = 2;
            break;
          }
          if (paramContext.startsWith("46003"))
          {
            i = 3;
            break;
          }
        }
      }
      i = 5;
    }
  }
  
  public static String j(Context paramContext)
  {
    Object localObject = new DisplayMetrics();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    int j;
    int i;
    if ((paramContext.getApplicationInfo().flags & 0x2000) == 0)
    {
      j = a((DisplayMetrics)localObject, "noncompatWidthPixels");
      i = a((DisplayMetrics)localObject, "noncompatHeightPixels");
    }
    for (;;)
    {
      int k;
      if (j != -1)
      {
        k = i;
        if (i != -1) {}
      }
      else
      {
        j = ((DisplayMetrics)localObject).widthPixels;
        k = ((DisplayMetrics)localObject).heightPixels;
      }
      localObject = new int[2];
      if (j > k)
      {
        localObject[0] = k;
        localObject[1] = j;
      }
      for (;;)
      {
        paramContext = new StringBuilder();
        paramContext.append(localObject[0]);
        paramContext.append("*");
        paramContext.append(localObject[1]);
        return paramContext.toString();
        localObject[0] = j;
        localObject[1] = k;
      }
      i = 0;
      j = -1;
    }
  }
  
  public static String k(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    for (;;)
    {
      try
      {
        paramContext = localPackageManager.getApplicationInfo(paramContext.getPackageName(), 128);
        if (paramContext.metaData != null) {
          continue;
        }
        i = 0;
        if (i == 0) {
          continue;
        }
        paramContext = paramContext.metaData.getString("SHENGPAY_CHANNEL");
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        int i;
        paramContext.printStackTrace();
        paramContext = "shengpay";
        continue;
      }
      return paramContext;
      i = 1;
    }
  }
  
  public static long[] l(Context paramContext)
  {
    Object localObject = Class.forName("android.net.TrafficStats");
    Method localMethod = ((Class)localObject).getMethod("getUidRxBytes", new Class[] { Integer.TYPE });
    localObject = ((Class)localObject).getMethod("getUidTxBytes", new Class[] { Integer.TYPE });
    int i = paramContext.getApplicationInfo().uid;
    paramContext = new long[2];
    paramContext[0] = -1L;
    paramContext[1] = -1L;
    paramContext;
    if (i == -1) {}
    for (;;)
    {
      return paramContext;
      paramContext[0] = (((Long)localMethod.invoke(null, new Object[] { Integer.valueOf(i) })).longValue() / 1000L);
      paramContext[1] = (((Long)((Method)localObject).invoke(null, new Object[] { Integer.valueOf(i) })).longValue() / 1000L);
    }
  }
  
  /* Error */
  public static String m(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: lconst_0
    //   4: lstore_3
    //   5: new 229	java/io/FileReader
    //   8: astore 6
    //   10: aload 6
    //   12: ldc_w 438
    //   15: invokespecial 234	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   18: new 236	java/io/BufferedReader
    //   21: astore 5
    //   23: aload 5
    //   25: aload 6
    //   27: sipush 8192
    //   30: invokespecial 239	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   33: aload 5
    //   35: invokevirtual 242	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   38: ldc_w 440
    //   41: invokevirtual 250	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   44: astore 7
    //   46: aload 5
    //   48: invokevirtual 253	java/io/BufferedReader:close	()V
    //   51: aload 7
    //   53: iconst_1
    //   54: aaload
    //   55: invokevirtual 443	java/lang/String:trim	()Ljava/lang/String;
    //   58: astore 7
    //   60: aload 7
    //   62: iconst_0
    //   63: aload 7
    //   65: invokevirtual 447	java/lang/String:length	()I
    //   68: iconst_2
    //   69: isub
    //   70: invokevirtual 451	java/lang/String:substring	(II)Ljava/lang/String;
    //   73: invokevirtual 443	java/lang/String:trim	()Ljava/lang/String;
    //   76: invokestatic 454	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   79: invokevirtual 433	java/lang/Long:longValue	()J
    //   82: lstore_1
    //   83: lload_1
    //   84: ldc2_w 455
    //   87: lmul
    //   88: lstore_1
    //   89: aload 6
    //   91: invokevirtual 254	java/io/FileReader:close	()V
    //   94: aload 5
    //   96: invokevirtual 253	java/io/BufferedReader:close	()V
    //   99: aload_0
    //   100: lload_1
    //   101: invokestatic 462	android/text/format/Formatter:formatFileSize	(Landroid/content/Context;J)Ljava/lang/String;
    //   104: areturn
    //   105: astore 6
    //   107: aload 6
    //   109: invokevirtual 255	java/io/IOException:printStackTrace	()V
    //   112: goto -18 -> 94
    //   115: astore 5
    //   117: aload 5
    //   119: invokevirtual 255	java/io/IOException:printStackTrace	()V
    //   122: goto -23 -> 99
    //   125: astore 7
    //   127: aconst_null
    //   128: astore 8
    //   130: aload 5
    //   132: astore 6
    //   134: aload 8
    //   136: astore 5
    //   138: aload 7
    //   140: invokevirtual 255	java/io/IOException:printStackTrace	()V
    //   143: aload 6
    //   145: ifnull +8 -> 153
    //   148: aload 6
    //   150: invokevirtual 254	java/io/FileReader:close	()V
    //   153: lload_3
    //   154: lstore_1
    //   155: aload 5
    //   157: ifnull -58 -> 99
    //   160: aload 5
    //   162: invokevirtual 253	java/io/BufferedReader:close	()V
    //   165: lload_3
    //   166: lstore_1
    //   167: goto -68 -> 99
    //   170: astore 5
    //   172: aload 5
    //   174: invokevirtual 255	java/io/IOException:printStackTrace	()V
    //   177: lload_3
    //   178: lstore_1
    //   179: goto -80 -> 99
    //   182: astore 6
    //   184: aload 6
    //   186: invokevirtual 255	java/io/IOException:printStackTrace	()V
    //   189: goto -36 -> 153
    //   192: astore_0
    //   193: aconst_null
    //   194: astore 5
    //   196: aconst_null
    //   197: astore 6
    //   199: aload 6
    //   201: ifnull +8 -> 209
    //   204: aload 6
    //   206: invokevirtual 254	java/io/FileReader:close	()V
    //   209: aload 5
    //   211: ifnull +8 -> 219
    //   214: aload 5
    //   216: invokevirtual 253	java/io/BufferedReader:close	()V
    //   219: aload_0
    //   220: athrow
    //   221: astore 6
    //   223: aload 6
    //   225: invokevirtual 255	java/io/IOException:printStackTrace	()V
    //   228: goto -19 -> 209
    //   231: astore 5
    //   233: aload 5
    //   235: invokevirtual 255	java/io/IOException:printStackTrace	()V
    //   238: goto -19 -> 219
    //   241: astore_0
    //   242: aconst_null
    //   243: astore 5
    //   245: goto -46 -> 199
    //   248: astore_0
    //   249: goto -50 -> 199
    //   252: astore_0
    //   253: goto -54 -> 199
    //   256: astore 7
    //   258: aconst_null
    //   259: astore 5
    //   261: goto -123 -> 138
    //   264: astore 7
    //   266: goto -128 -> 138
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	269	0	paramContext	Context
    //   82	97	1	l1	long
    //   4	174	3	l2	long
    //   1	94	5	localBufferedReader	BufferedReader
    //   115	16	5	localIOException1	IOException
    //   136	25	5	localObject1	Object
    //   170	3	5	localIOException2	IOException
    //   194	21	5	localObject2	Object
    //   231	3	5	localIOException3	IOException
    //   243	17	5	localObject3	Object
    //   8	82	6	localFileReader	FileReader
    //   105	3	6	localIOException4	IOException
    //   132	17	6	localIOException5	IOException
    //   182	3	6	localIOException6	IOException
    //   197	8	6	localObject4	Object
    //   221	3	6	localIOException7	IOException
    //   44	20	7	localObject5	Object
    //   125	14	7	localIOException8	IOException
    //   256	1	7	localIOException9	IOException
    //   264	1	7	localIOException10	IOException
    //   128	7	8	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   89	94	105	java/io/IOException
    //   94	99	115	java/io/IOException
    //   5	18	125	java/io/IOException
    //   160	165	170	java/io/IOException
    //   148	153	182	java/io/IOException
    //   5	18	192	finally
    //   204	209	221	java/io/IOException
    //   214	219	231	java/io/IOException
    //   18	33	241	finally
    //   33	83	248	finally
    //   138	143	252	finally
    //   18	33	256	java/io/IOException
    //   33	83	264	java/io/IOException
  }
  
  public static String n(Context paramContext)
  {
    ActivityManager localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    localActivityManager.getMemoryInfo(localMemoryInfo);
    return Formatter.formatFileSize(paramContext, localMemoryInfo.availMem);
  }
  
  private static String o(Context paramContext)
  {
    int i = 0;
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      paramContext = localPackageManager.getApplicationInfo(paramContext.getPackageName(), 0);
      if (paramContext == null)
      {
        if (i == 0) {
          break label49;
        }
        paramContext = localPackageManager.getApplicationLabel(paramContext).toString();
        return paramContext;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext = null;
        continue;
        i = 1;
        continue;
        label49:
        paramContext = com.analysis.common.tools.c.a();
      }
    }
  }
  
  private static String p(Context paramContext)
  {
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (com.analysis.common.tools.c.a(paramContext)) {}
    for (paramContext = com.analysis.common.tools.c.a();; paramContext = paramContext.getNetworkOperatorName()) {
      return paramContext;
    }
  }
  
  private static String q(Context paramContext)
  {
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (com.analysis.common.tools.c.a(paramContext)) {}
    for (paramContext = com.analysis.common.tools.c.a();; paramContext = paramContext.getLine1Number()) {
      return paramContext;
    }
  }
  
  private static Locale r(Context paramContext)
  {
    Configuration localConfiguration = new Configuration();
    localConfiguration.setToDefaults();
    Settings.System.getConfiguration(paramContext.getContentResolver(), localConfiguration);
    return localConfiguration.locale;
  }
  
  private static String[] s(Context paramContext)
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = com.analysis.common.tools.c.a();
    arrayOfString[1] = com.analysis.common.tools.c.a();
    Configuration localConfiguration = new Configuration();
    localConfiguration.setToDefaults();
    Settings.System.getConfiguration(paramContext.getContentResolver(), localConfiguration);
    paramContext = localConfiguration.locale;
    if (paramContext == null) {}
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        arrayOfString[0] = paramContext.getCountry();
        arrayOfString[1] = paramContext.getLanguage();
      }
      return arrayOfString;
    }
  }
  
  private static int[] t(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    int j;
    int i;
    if ((paramContext.getApplicationInfo().flags & 0x2000) == 0)
    {
      j = a(localDisplayMetrics, "noncompatWidthPixels");
      i = a(localDisplayMetrics, "noncompatHeightPixels");
    }
    for (;;)
    {
      int k;
      if (j != -1)
      {
        k = i;
        if (i != -1) {}
      }
      else
      {
        j = localDisplayMetrics.widthPixels;
        k = localDisplayMetrics.heightPixels;
      }
      paramContext = new int[2];
      if (j > k)
      {
        paramContext[0] = k;
        paramContext[1] = j;
      }
      for (;;)
      {
        return paramContext;
        paramContext[0] = j;
        paramContext[1] = k;
      }
      i = 0;
      j = -1;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/analysis/common/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */