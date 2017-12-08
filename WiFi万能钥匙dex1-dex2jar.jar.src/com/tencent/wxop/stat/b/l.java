package com.tencent.wxop.stat.b;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.wxop.stat.c;
import com.tencent.wxop.stat.f;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpHost;
import org.json.JSONObject;

public final class l
{
  private static int U;
  private static String W;
  private static String a = null;
  private static String aR;
  private static String b = null;
  private static int bG;
  private static volatile int bn;
  private static String bq;
  private static String br;
  private static String bs;
  private static String c = null;
  private static String cC;
  private static String cE;
  private static Random cR;
  private static DisplayMetrics cS;
  private static b cT;
  private static String cU;
  private static String cV;
  private static long cW;
  private static o cX;
  private static String cY;
  private static long cZ;
  private static String da = "";
  private static int w;
  
  static
  {
    W = null;
    cR = null;
    cS = null;
    bq = null;
    br = "";
    bs = "";
    bG = -1;
    cT = null;
    cU = null;
    aR = null;
    bn = -1;
    cV = null;
    cC = null;
    cW = -1L;
    cE = "";
    cX = null;
    cY = "__MTA_FIRST_ACTIVATE__";
    U = -1;
    cZ = -1L;
    w = 0;
  }
  
  public static String A(Context paramContext)
  {
    for (;;)
    {
      try
      {
        paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
        if (paramContext != null)
        {
          paramContext = paramContext.metaData.get("InstallChannel");
          if (paramContext != null)
          {
            paramContext = paramContext.toString();
            return paramContext;
          }
          cT.c("Could not read InstallChannel meta-data from AndroidManifest.xml");
        }
      }
      catch (Throwable paramContext)
      {
        cT.d("Could not read InstallChannel meta-data from AndroidManifest.xml");
        continue;
      }
      paramContext = null;
    }
  }
  
  public static String B(Context paramContext)
  {
    if (paramContext == null) {}
    for (paramContext = null;; paramContext = paramContext.getClass().getName()) {
      return paramContext;
    }
  }
  
  public static String C(Context paramContext)
  {
    if (bq != null)
    {
      paramContext = bq;
      return paramContext;
    }
    for (;;)
    {
      try
      {
        if (!r.a(paramContext, "android.permission.READ_PHONE_STATE")) {
          continue;
        }
        if (paramContext.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", paramContext.getPackageName()) == 0) {
          continue;
        }
        i = 0;
        if (i != 0)
        {
          paramContext = (TelephonyManager)paramContext.getSystemService("phone");
          if (paramContext != null) {
            bq = paramContext.getSimOperator();
          }
        }
      }
      catch (Throwable paramContext)
      {
        int i;
        cT.b(paramContext);
        continue;
      }
      paramContext = bq;
      break;
      i = 1;
      continue;
      cT.d("Could not get permission of android.permission.READ_PHONE_STATE");
    }
  }
  
  public static String D(Context paramContext)
  {
    if (e(br)) {
      paramContext = br;
    }
    for (;;)
    {
      return paramContext;
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
        br = paramContext;
        if (paramContext == null) {
          paramContext = "";
        }
      }
      catch (Throwable paramContext)
      {
        cT.b(paramContext);
        paramContext = br;
      }
    }
  }
  
  public static String E(Context paramContext)
  {
    str = "";
    for (;;)
    {
      try
      {
        if ((!r.a(paramContext, "android.permission.INTERNET")) || (!r.a(paramContext, "android.permission.ACCESS_NETWORK_STATE"))) {
          continue;
        }
        localObject = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if ((localObject == null) || (!((NetworkInfo)localObject).isConnected())) {
          continue;
        }
        paramContext = ((NetworkInfo)localObject).getTypeName();
        localObject = ((NetworkInfo)localObject).getExtraInfo();
        if (paramContext == null) {
          continue;
        }
        if (!paramContext.equalsIgnoreCase("WIFI")) {
          continue;
        }
        paramContext = "WIFI";
      }
      catch (Throwable paramContext)
      {
        Object localObject;
        cT.b(paramContext);
        paramContext = str;
        continue;
      }
      return paramContext;
      if (paramContext.equalsIgnoreCase("MOBILE"))
      {
        if (localObject != null) {
          paramContext = (Context)localObject;
        } else {
          paramContext = "MOBILE";
        }
      }
      else if (localObject != null)
      {
        paramContext = (Context)localObject;
        continue;
        paramContext = "";
      }
      else
      {
        continue;
        cT.d("can not get the permission of android.permission.ACCESS_WIFI_STATE");
        paramContext = str;
      }
    }
  }
  
  public static Integer F(Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext == null) {
        break label27;
      }
      int i = paramContext.getNetworkType();
      paramContext = Integer.valueOf(i);
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        label27:
        paramContext = null;
      }
    }
    return paramContext;
  }
  
  public static String G(Context paramContext)
  {
    if (e(bs)) {
      paramContext = bs;
    }
    for (;;)
    {
      return paramContext;
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
        bs = paramContext;
        if ((paramContext == null) || (bs.length() == 0)) {
          paramContext = "unknown";
        }
      }
      catch (Throwable paramContext)
      {
        cT.b(paramContext);
        paramContext = bs;
      }
    }
  }
  
  public static String H(Context paramContext)
  {
    if (e(cU)) {
      paramContext = cU;
    }
    for (;;)
    {
      return paramContext;
      try
      {
        if (!r.a(paramContext, "android.permission.WRITE_EXTERNAL_STORAGE")) {
          break label149;
        }
        paramContext = Environment.getExternalStorageState();
        if ((paramContext != null) && (paramContext.equals("mounted")))
        {
          String str = Environment.getExternalStorageDirectory().getPath();
          if (str != null)
          {
            paramContext = new android/os/StatFs;
            paramContext.<init>(str);
            long l2 = paramContext.getBlockCount() * paramContext.getBlockSize() / 1000000L;
            long l1 = paramContext.getAvailableBlocks() * paramContext.getBlockSize() / 1000000L;
            paramContext = new java/lang/StringBuilder;
            paramContext.<init>();
            paramContext = String.valueOf(l1) + "/" + String.valueOf(l2);
            cU = paramContext;
          }
        }
      }
      catch (Throwable paramContext)
      {
        cT.b(paramContext);
        paramContext = null;
      }
      continue;
      label149:
      cT.warn("can not get the permission of android.permission.WRITE_EXTERNAL_STORAGE");
      paramContext = null;
    }
  }
  
  static String I(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (aR != null)
        {
          paramContext = aR;
          return paramContext;
        }
        int i = Process.myPid();
        Iterator localIterator = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
        if (localIterator.hasNext())
        {
          paramContext = (ActivityManager.RunningAppProcessInfo)localIterator.next();
          if (paramContext.pid != i) {
            continue;
          }
          aR = paramContext.processName;
        }
      }
      catch (Throwable paramContext)
      {
        continue;
      }
      paramContext = aR;
    }
  }
  
  public static String J(Context paramContext)
  {
    return e(paramContext, a.ct);
  }
  
  public static Integer K(Context paramContext)
  {
    int i = 0;
    for (;;)
    {
      int j;
      try
      {
        if (bn > 0)
        {
          j = bn;
          if (j % 1000 == 0) {}
          try
          {
            j = bn;
            if (bn < 2147383647) {
              break label107;
            }
            q.b(paramContext, "MTA_EVENT_INDEX", i);
          }
          catch (Throwable paramContext)
          {
            cT.c(paramContext);
            continue;
          }
          i = bn + 1;
          bn = i;
          return Integer.valueOf(i);
        }
      }
      finally {}
      bn = q.a(paramContext, "MTA_EVENT_INDEX", 0);
      q.b(paramContext, "MTA_EVENT_INDEX", bn + 1000);
      continue;
      label107:
      i = j + 1000;
    }
  }
  
  public static String L(Context paramContext)
  {
    try
    {
      ActivityManager localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
      paramContext = new android/app/ActivityManager$MemoryInfo;
      paramContext.<init>();
      localActivityManager.getMemoryInfo(paramContext);
      long l2 = paramContext.availMem / 1000000L;
      long l1 = ay() / 1000000L;
      paramContext = new java/lang/StringBuilder;
      paramContext.<init>();
      paramContext = String.valueOf(l2) + "/" + String.valueOf(l1);
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = null;
      }
    }
  }
  
  public static String M(Context paramContext)
  {
    if (e(cE)) {}
    for (paramContext = cE;; paramContext = cE)
    {
      return paramContext;
      try
      {
        paramContext = (SensorManager)paramContext.getSystemService("sensor");
        if (paramContext != null)
        {
          paramContext = paramContext.getSensorList(-1);
          if (paramContext != null)
          {
            StringBuilder localStringBuilder = new java/lang/StringBuilder;
            localStringBuilder.<init>(paramContext.size() * 10);
            for (int i = 0; i < paramContext.size(); i++)
            {
              localStringBuilder.append(((Sensor)paramContext.get(i)).getType());
              if (i != paramContext.size() - 1) {
                localStringBuilder.append(",");
              }
            }
            cE = localStringBuilder.toString();
          }
        }
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          cT.b(paramContext);
        }
      }
    }
  }
  
  /* Error */
  public static int N(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 85	com/tencent/wxop/stat/b/l:U	I
    //   6: iconst_m1
    //   7: if_icmpeq +12 -> 19
    //   10: getstatic 85	com/tencent/wxop/stat/b/l:U	I
    //   13: istore_1
    //   14: ldc 2
    //   16: monitorexit
    //   17: iload_1
    //   18: ireturn
    //   19: aload_0
    //   20: invokestatic 412	com/tencent/wxop/stat/b/l:O	(Landroid/content/Context;)V
    //   23: getstatic 85	com/tencent/wxop/stat/b/l:U	I
    //   26: istore_1
    //   27: goto -13 -> 14
    //   30: astore_0
    //   31: ldc 2
    //   33: monitorexit
    //   34: aload_0
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	paramContext	Context
    //   13	14	1	i	int
    // Exception table:
    //   from	to	target	type
    //   3	14	30	finally
    //   19	27	30	finally
  }
  
  public static void O(Context paramContext)
  {
    int i = q.a(paramContext, cY, 1);
    U = i;
    if (i == 1) {
      q.b(paramContext, cY, 0);
    }
  }
  
  public static boolean P(Context paramContext)
  {
    if (cZ < 0L) {
      cZ = q.f(paramContext, "mta.qq.com.checktime");
    }
    if (Math.abs(System.currentTimeMillis() - cZ) > 86400000L) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static void Q(Context paramContext)
  {
    cZ = System.currentTimeMillis();
    q.a(paramContext, "mta.qq.com.checktime", cZ);
  }
  
  public static String R(Context paramContext)
  {
    Object localObject1 = null;
    if (paramContext == null) {
      paramContext = (Context)localObject1;
    }
    for (;;)
    {
      return paramContext;
      Object localObject2 = new Intent("android.intent.action.MAIN");
      ((Intent)localObject2).addCategory("android.intent.category.HOME");
      localObject2 = paramContext.getPackageManager().resolveActivity((Intent)localObject2, 0);
      paramContext = (Context)localObject1;
      if (((ResolveInfo)localObject2).activityInfo != null)
      {
        paramContext = (Context)localObject1;
        if (!((ResolveInfo)localObject2).activityInfo.packageName.equals("android")) {
          paramContext = ((ResolveInfo)localObject2).activityInfo.packageName;
        }
      }
    }
  }
  
  public static int a(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean) {
      w = q.a(paramContext, "mta.qq.com.difftime", 0);
    }
    return w;
  }
  
  private static Long a(String paramString1, String paramString2, Long paramLong)
  {
    Object localObject = paramLong;
    if (paramString1 != null)
    {
      if (paramString2 != null) {
        break label17;
      }
      localObject = paramLong;
    }
    for (;;)
    {
      return (Long)localObject;
      label17:
      if (!paramString2.equalsIgnoreCase("."))
      {
        localObject = paramString2;
        if (!paramString2.equalsIgnoreCase("|")) {}
      }
      else
      {
        localObject = "\\" + paramString2;
      }
      paramString2 = paramString1.split((String)localObject);
      localObject = paramLong;
      if (paramString2.length == 3) {
        try
        {
          paramString1 = Long.valueOf(0L);
          int i = 0;
          while (i < paramString2.length)
          {
            long l2 = paramString1.longValue();
            long l1 = Long.valueOf(paramString2[i]).longValue();
            i++;
            paramString1 = Long.valueOf(100L * (l2 + l1));
          }
          localObject = paramString1;
        }
        catch (NumberFormatException paramString1)
        {
          localObject = paramLong;
        }
      }
    }
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    w = paramInt;
    q.b(paramContext, "mta.qq.com.difftime", paramInt);
  }
  
  public static boolean a(f paramf)
  {
    if (paramf == null) {}
    for (boolean bool = false;; bool = e(paramf.S())) {
      return bool;
    }
  }
  
  public static long ad()
  {
    try
    {
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.set(11, 0);
      localCalendar.set(12, 0);
      localCalendar.set(13, 0);
      localCalendar.set(14, 0);
      l = localCalendar.getTimeInMillis();
      l += 86400000L;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        cT.b(localThrowable);
        long l = System.currentTimeMillis() + 86400000L;
      }
    }
    return l;
  }
  
  private static Random at()
  {
    try
    {
      if (cR == null)
      {
        localRandom = new java/util/Random;
        localRandom.<init>();
        cR = localRandom;
      }
      Random localRandom = cR;
      return localRandom;
    }
    finally {}
  }
  
  public static int au()
  {
    int i;
    if (bG != -1) {
      i = bG;
    }
    for (;;)
    {
      return i;
      try
      {
        if (p.a()) {
          bG = 1;
        }
        i = 0;
        bG = 0;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          cT.b(localThrowable);
        }
      }
    }
  }
  
  public static b av()
  {
    try
    {
      if (cT == null)
      {
        localb = new com/tencent/wxop/stat/b/b;
        localb.<init>("MtaSDK");
        cT = localb;
        localb.ap();
      }
      b localb = cT;
      return localb;
    }
    finally {}
  }
  
  public static String aw()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.roll(6, 0);
    return new SimpleDateFormat("yyyyMMdd").format(localCalendar.getTime());
  }
  
  public static String ax()
  {
    Object localObject;
    if (e(cC)) {
      localObject = cC;
    }
    for (;;)
    {
      return (String)localObject;
      localObject = new StatFs(Environment.getDataDirectory().getPath());
      long l1 = ((StatFs)localObject).getBlockSize();
      l1 = ((StatFs)localObject).getBlockCount() * l1 / 1000000L;
      localObject = new StatFs(Environment.getDataDirectory().getPath());
      long l2 = ((StatFs)localObject).getBlockSize();
      l2 = ((StatFs)localObject).getAvailableBlocks() * l2 / 1000000L;
      localObject = String.valueOf(l2) + "/" + String.valueOf(l1);
      cC = (String)localObject;
    }
  }
  
  private static long ay()
  {
    long l1;
    if (cW > 0L) {
      l1 = cW;
    }
    for (;;)
    {
      return l1;
      long l2 = 1L;
      l1 = l2;
      try
      {
        FileReader localFileReader = new java/io/FileReader;
        l1 = l2;
        localFileReader.<init>("/proc/meminfo");
        l1 = l2;
        BufferedReader localBufferedReader = new java/io/BufferedReader;
        l1 = l2;
        localBufferedReader.<init>(localFileReader, 8192);
        l1 = l2;
        l2 = Integer.valueOf(localBufferedReader.readLine().split("\\s+")[1]).intValue() * 1024;
        l1 = l2;
        localBufferedReader.close();
        l1 = l2;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
      cW = l1;
    }
  }
  
  public static JSONObject az()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("n", m.r());
      String str = m.ax();
      if ((str != null) && (str.length() > 0)) {
        localJSONObject.put("na", str);
      }
      int i = m.aA();
      if (i > 0) {
        localJSONObject.put("fx", i / 1000000);
      }
      i = m.D();
      if (i > 0) {
        localJSONObject.put("fn", i / 1000000);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.w("MtaSDK", "get cpu error", localThrowable);
      }
    }
    return localJSONObject;
  }
  
  public static byte[] b(byte[] paramArrayOfByte)
  {
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
    GZIPInputStream localGZIPInputStream = new GZIPInputStream(localByteArrayInputStream);
    byte[] arrayOfByte = new byte['က'];
    paramArrayOfByte = new ByteArrayOutputStream(paramArrayOfByte.length * 2);
    for (;;)
    {
      int i = localGZIPInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      paramArrayOfByte.write(arrayOfByte, 0, i);
    }
    arrayOfByte = paramArrayOfByte.toByteArray();
    localByteArrayInputStream.close();
    localGZIPInputStream.close();
    paramArrayOfByte.close();
    return arrayOfByte;
  }
  
  /* Error */
  public static String c(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 39	com/tencent/wxop/stat/b/l:a	Ljava/lang/String;
    //   6: ifnull +24 -> 30
    //   9: getstatic 39	com/tencent/wxop/stat/b/l:a	Ljava/lang/String;
    //   12: invokevirtual 653	java/lang/String:trim	()Ljava/lang/String;
    //   15: invokevirtual 242	java/lang/String:length	()I
    //   18: ifeq +12 -> 30
    //   21: getstatic 39	com/tencent/wxop/stat/b/l:a	Ljava/lang/String;
    //   24: astore_0
    //   25: ldc 2
    //   27: monitorexit
    //   28: aload_0
    //   29: areturn
    //   30: aload_0
    //   31: invokestatic 655	com/tencent/wxop/stat/b/r:b	(Landroid/content/Context;)Ljava/lang/String;
    //   34: astore_0
    //   35: aload_0
    //   36: putstatic 39	com/tencent/wxop/stat/b/l:a	Ljava/lang/String;
    //   39: aload_0
    //   40: ifnull +15 -> 55
    //   43: getstatic 39	com/tencent/wxop/stat/b/l:a	Ljava/lang/String;
    //   46: invokevirtual 653	java/lang/String:trim	()Ljava/lang/String;
    //   49: invokevirtual 242	java/lang/String:length	()I
    //   52: ifne +18 -> 70
    //   55: invokestatic 657	com/tencent/wxop/stat/b/l:at	()Ljava/util/Random;
    //   58: ldc_w 658
    //   61: invokevirtual 662	java/util/Random:nextInt	(I)I
    //   64: invokestatic 665	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   67: putstatic 39	com/tencent/wxop/stat/b/l:a	Ljava/lang/String;
    //   70: getstatic 39	com/tencent/wxop/stat/b/l:a	Ljava/lang/String;
    //   73: astore_0
    //   74: goto -49 -> 25
    //   77: astore_0
    //   78: ldc 2
    //   80: monitorexit
    //   81: aload_0
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   3	25	77	finally
    //   30	39	77	finally
    //   43	55	77	finally
    //   55	70	77	finally
    //   70	74	77	finally
  }
  
  public static String d(long paramLong)
  {
    return new SimpleDateFormat("yyyyMMdd").format(new Date(paramLong));
  }
  
  public static String e(Context paramContext, String paramString)
  {
    String str = paramString;
    if (c.E() == true)
    {
      if (aR == null) {
        aR = I(paramContext);
      }
      str = paramString;
      if (aR != null) {
        str = paramString + "_" + aR;
      }
    }
    return str;
  }
  
  public static boolean e(String paramString)
  {
    if ((paramString == null) || (paramString.trim().length() == 0)) {}
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  public static int r()
  {
    return at().nextInt(Integer.MAX_VALUE);
  }
  
  public static String t(String paramString)
  {
    if (paramString == null) {
      paramString = "0";
    }
    for (;;)
    {
      return paramString;
      try
      {
        Object localObject = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject).update(paramString.getBytes());
        localObject = ((MessageDigest)localObject).digest();
        paramString = new java/lang/StringBuffer;
        paramString.<init>();
        for (int i = 0; i < localObject.length; i++)
        {
          int j = localObject[i] & 0xFF;
          if (j < 16) {
            paramString.append("0");
          }
          paramString.append(Integer.toHexString(j));
        }
        paramString = paramString.toString();
      }
      catch (Throwable paramString)
      {
        paramString = "0";
      }
    }
  }
  
  public static long u(String paramString)
  {
    return a(paramString, ".", Long.valueOf(0L)).longValue();
  }
  
  public static HttpHost v(Context paramContext)
  {
    if (paramContext == null) {
      paramContext = null;
    }
    for (;;)
    {
      return paramContext;
      label148:
      do
      {
        try
        {
          if (paramContext.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", paramContext.getPackageName()) != 0)
          {
            paramContext = null;
            break;
          }
          paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
          if (paramContext == null)
          {
            paramContext = null;
            break;
          }
          if ((paramContext.getTypeName() != null) && (paramContext.getTypeName().equalsIgnoreCase("WIFI")))
          {
            paramContext = null;
            break;
          }
          paramContext = paramContext.getExtraInfo();
          if (paramContext == null)
          {
            paramContext = null;
            break;
          }
          if ((!paramContext.equals("cmwap")) && (!paramContext.equals("3gwap")) && (!paramContext.equals("uniwap"))) {
            break label148;
          }
          paramContext = new org/apache/http/HttpHost;
          paramContext.<init>("10.0.0.172", 80);
        }
        catch (Throwable paramContext)
        {
          cT.b(paramContext);
          paramContext = null;
        }
        break;
        if (paramContext.equals("ctwap"))
        {
          paramContext = new HttpHost("10.0.0.200", 80);
          break;
        }
        paramContext = Proxy.getDefaultHost();
      } while ((paramContext == null) || (paramContext.trim().length() <= 0));
      paramContext = new HttpHost(paramContext, Proxy.getDefaultPort());
    }
  }
  
  public static String w(Context paramContext)
  {
    try
    {
      if ((c == null) || (c.trim().length() == 0)) {
        c = r.c(paramContext);
      }
      paramContext = c;
      return paramContext;
    }
    finally {}
  }
  
  public static DisplayMetrics x(Context paramContext)
  {
    if (cS == null)
    {
      cS = new DisplayMetrics();
      ((WindowManager)paramContext.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(cS);
    }
    return cS;
  }
  
  public static boolean y(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (r.a(paramContext, "android.permission.ACCESS_WIFI_STATE"))
        {
          paramContext = (ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity");
          if (paramContext != null)
          {
            paramContext = paramContext.getAllNetworkInfo();
            if (paramContext != null)
            {
              int i = 0;
              if (i < paramContext.length)
              {
                if ((paramContext[i].getTypeName().equalsIgnoreCase("WIFI")) && (paramContext[i].isConnected()))
                {
                  bool = true;
                  return bool;
                }
                i++;
                continue;
              }
            }
          }
          bool = false;
          continue;
        }
        cT.warn("can not get the permission of android.permission.ACCESS_WIFI_STATE");
      }
      catch (Throwable paramContext)
      {
        boolean bool;
        cT.b(paramContext);
        continue;
      }
      bool = false;
    }
  }
  
  public static String z(Context paramContext)
  {
    if (b != null) {
      paramContext = b;
    }
    for (;;)
    {
      return paramContext;
      try
      {
        paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
        if (paramContext != null)
        {
          paramContext = paramContext.metaData.getString("TA_APPKEY");
          if (paramContext == null) {
            break label68;
          }
          b = paramContext;
        }
      }
      catch (Throwable paramContext)
      {
        cT.b("Could not read APPKEY meta-data from AndroidManifest.xml");
      }
    }
    for (;;)
    {
      paramContext = null;
      break;
      label68:
      cT.b("Could not read APPKEY meta-data from AndroidManifest.xml");
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/wxop/stat/b/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */