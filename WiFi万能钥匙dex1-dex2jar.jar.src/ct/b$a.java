package ct;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.telephony.NeighboringCellInfo;
import android.text.format.DateFormat;
import android.util.Log;
import com.tencent.map.geolocation.TencentLocation;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;
import org.eclipse.jdt.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b$a
{
  private static a d;
  public d a;
  public e b = new e();
  public c c;
  
  public b$a()
  {
    this.b.a();
    this.a = new d();
    this.a.a();
    this.c = new c();
    this.c.a = p.a().getSharedPreferences("Access_Preferences", 0).getString("detectTaskCode", "200001010101011234");
  }
  
  private static double a(double paramDouble)
  {
    return 3.141592653589793D * paramDouble / 180.0D;
  }
  
  public static double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    paramDouble1 = a(paramDouble1);
    paramDouble3 = a(paramDouble3);
    paramDouble2 = a(paramDouble2);
    double d1 = a(paramDouble4);
    paramDouble4 = Math.pow(Math.sin((paramDouble1 - paramDouble3) / 2.0D), 2.0D);
    return Math.round(Math.asin(Math.sqrt(Math.cos(paramDouble1) * Math.cos(paramDouble3) * Math.pow(Math.sin((paramDouble2 - d1) / 2.0D), 2.0D) + paramDouble4)) * 2.0D * 6178.137D * 10000.0D) / 10000.0D * 1000.0D;
  }
  
  public static double a(double paramDouble, int paramInt)
  {
    d1 = 0.0D;
    for (;;)
    {
      try
      {
        if (!Double.isNaN(paramDouble)) {
          continue;
        }
        paramDouble = d1;
      }
      catch (Exception localException)
      {
        paramDouble = d1;
        continue;
      }
      return paramDouble;
      paramDouble = BigDecimal.valueOf(paramDouble).setScale(paramInt, RoundingMode.HALF_DOWN).doubleValue();
    }
  }
  
  public static Location a(TencentLocation paramTencentLocation)
  {
    if (paramTencentLocation == null) {}
    Location localLocation;
    for (paramTencentLocation = null;; paramTencentLocation = localLocation)
    {
      return paramTencentLocation;
      localLocation = new Location(paramTencentLocation.getProvider());
      localLocation.setLatitude(paramTencentLocation.getLatitude());
      localLocation.setLongitude(paramTencentLocation.getLongitude());
      localLocation.setAccuracy(paramTencentLocation.getAccuracy());
      localLocation.setTime(paramTencentLocation.getTime());
    }
  }
  
  public static z a()
  {
    return aa.a();
  }
  
  private static String a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, String paramString)
  {
    String str1 = "0";
    String str2 = "0";
    if (paramInt6 != Integer.MAX_VALUE) {
      str1 = String.format(Locale.ENGLISH, "%.6f", new Object[] { Float.valueOf(paramInt6 / 14400.0F) });
    }
    if (paramInt7 != Integer.MAX_VALUE) {
      str2 = String.format(Locale.ENGLISH, "%.6f", new Object[] { Float.valueOf(paramInt7 / 14400.0F) });
    }
    return de.a(paramString).a(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), str1, str2 });
  }
  
  public static String a(Location paramLocation, String paramString)
  {
    if (paramLocation == null) {}
    for (paramLocation = "";; paramLocation = de.a(paramString).a(Double.valueOf(a(paramLocation.getLatitude(), 6)), Double.valueOf(a(paramLocation.getLongitude(), 6)), new Object[] { Double.valueOf(a(paramLocation.getAltitude(), 1)), Double.valueOf(a(paramLocation.getAccuracy(), 1)), Double.valueOf(a(paramLocation.getBearing(), 1)), Double.valueOf(a(paramLocation.getSpeed(), 1)), Long.valueOf(paramLocation.getTime()) })) {
      return paramLocation;
    }
  }
  
  public static String a(TencentLocation paramTencentLocation, int paramInt)
  {
    if (paramTencentLocation == null) {}
    for (long l = System.currentTimeMillis();; l = paramTencentLocation.getTime())
    {
      CharSequence localCharSequence = DateFormat.format("yyyy-MM-dd kk:mm:ss", l);
      return localCharSequence + " error=" + paramInt + paramTencentLocation + "\n";
    }
  }
  
  public static String a(ck paramck, String paramString1, String paramString2)
  {
    if (paramck == null) {}
    ArrayList localArrayList;
    for (paramck = "";; paramck = de.a(paramString2).a(localArrayList))
    {
      return paramck;
      localArrayList = new ArrayList();
      int k = paramck.b;
      int j = paramck.c;
      int i = paramck.a;
      if (db.a(i, k, j, paramck.d, paramck.e)) {
        localArrayList.add(a(k, j, paramck.d, paramck.e, paramck.f, paramck.g, paramck.h, paramString1));
      }
      paramck = paramck.a().iterator();
      while (paramck.hasNext())
      {
        NeighboringCellInfo localNeighboringCellInfo = (NeighboringCellInfo)paramck.next();
        int n = localNeighboringCellInfo.getLac();
        int m = localNeighboringCellInfo.getCid();
        if (db.a(i, k, j, n, m)) {
          localArrayList.add(a(k, j, n, m, (localNeighboringCellInfo.getRssi() << 1) - 113, Integer.MAX_VALUE, Integer.MAX_VALUE, paramString1));
        }
      }
    }
  }
  
  public static String a(ck paramck, boolean paramBoolean)
  {
    if (paramck == null)
    {
      paramck = "[]";
      return paramck;
    }
    int j = paramck.b;
    int k = paramck.c;
    int m = paramck.a;
    ArrayList localArrayList = new ArrayList();
    Object localObject = paramck.a();
    int i;
    int n;
    int i1;
    if (db.a(m, j, k, paramck.d, paramck.e))
    {
      int i2 = paramck.d;
      i = paramck.e;
      int i3 = paramck.f;
      n = paramck.g;
      i1 = paramck.h;
      paramck = new StringBuilder();
      paramck.append("{");
      paramck.append("\"mcc\":");
      paramck.append(j);
      paramck.append(",\"mnc\":");
      paramck.append(k);
      paramck.append(",\"lac\":");
      paramck.append(i2);
      paramck.append(",\"cellid\":");
      paramck.append(i);
      paramck.append(",\"rss\":");
      paramck.append(i3);
      paramck.append(",\"seed\":");
      if (paramBoolean)
      {
        i = 1;
        label193:
        paramck.append(i);
        if ((n != Integer.MAX_VALUE) && (i1 != Integer.MAX_VALUE))
        {
          paramck.append(",\"stationLat\":");
          paramck.append(String.format("%.6f", new Object[] { Float.valueOf(n / 14400.0F) }));
          paramck.append(",\"stationLng\":");
          paramck.append(String.format("%.6f", new Object[] { Float.valueOf(i1 / 14400.0F) }));
        }
        paramck.append("}");
        localArrayList.add(paramck.toString());
      }
    }
    for (;;)
    {
      try
      {
        paramck = ((List)localObject).iterator();
        if (paramck.hasNext())
        {
          localObject = (NeighboringCellInfo)paramck.next();
          n = ((NeighboringCellInfo)localObject).getLac();
          i1 = ((NeighboringCellInfo)localObject).getCid();
          if (!db.a(m, j, k, n, i1)) {
            break label563;
          }
          i = ((NeighboringCellInfo)localObject).getRssi();
          localObject = new java/lang/StringBuilder;
          ((StringBuilder)localObject).<init>();
          ((StringBuilder)localObject).append("{");
          ((StringBuilder)localObject).append("\"mcc\":");
          ((StringBuilder)localObject).append(j);
          ((StringBuilder)localObject).append(",\"mnc\":");
          ((StringBuilder)localObject).append(k);
          ((StringBuilder)localObject).append(",\"lac\":");
          ((StringBuilder)localObject).append(n);
          ((StringBuilder)localObject).append(",\"cellid\":");
          ((StringBuilder)localObject).append(i1);
          ((StringBuilder)localObject).append(",\"rss\":");
          ((StringBuilder)localObject).append((i << 1) - 113);
          ((StringBuilder)localObject).append("}");
          localArrayList.add(((StringBuilder)localObject).toString());
          continue;
        }
      }
      catch (Exception paramck)
      {
        paramck = new StringBuilder("[");
        paramck.append(de.a(",").a(localArrayList));
        paramck.append("]");
        paramck = paramck.toString();
      }
      i = 0;
      break label193;
      a("illeagal main cell! ", j, k, m, paramck.d, paramck.e);
      continue;
      label563:
      a("illeagal neighboringCell! ", j, k, m, n, i1);
    }
  }
  
  public static String a(cl paramcl)
  {
    if (paramcl == null) {}
    StringBuilder localStringBuilder;
    for (paramcl = "{}";; paramcl = localStringBuilder.toString())
    {
      return paramcl;
      Location localLocation = paramcl.a;
      localStringBuilder = new StringBuilder();
      double d3 = a(localLocation.getLatitude(), 6);
      double d6 = a(localLocation.getLongitude(), 6);
      double d5 = a(localLocation.getAltitude(), 1);
      double d2 = a(localLocation.getAccuracy(), 1);
      double d1 = a(localLocation.getBearing(), 1);
      double d4 = a(localLocation.getSpeed(), 1);
      localStringBuilder.append("{");
      localStringBuilder.append("\"latitude\":");
      localStringBuilder.append(d3);
      localStringBuilder.append(",\"longitude\":");
      localStringBuilder.append(d6);
      localStringBuilder.append(",\"additional\":");
      localStringBuilder.append("\"" + d5 + "," + d2 + "," + d1 + "," + d4 + "," + paramcl.b + "\"");
      localStringBuilder.append("}");
    }
  }
  
  public static String a(co paramco)
  {
    if ((paramco == null) || (paramco.a() == null)) {
      paramco = "[]";
    }
    for (;;)
    {
      return paramco;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      if ((paramco.a() == null) || (paramco.a().size() <= 0))
      {
        localStringBuilder.append("]");
        paramco = localStringBuilder.toString();
      }
      else
      {
        List localList = paramco.a();
        Iterator localIterator = localList.iterator();
        for (int i = 0; localIterator.hasNext(); i++)
        {
          paramco = (ScanResult)localIterator.next();
          localList.size();
          if (i > 0) {
            localStringBuilder.append(",");
          }
          localStringBuilder.append("{\"mac\":\"").append(paramco.BSSID).append("\",");
          localStringBuilder.append("\"rssi\":").append(paramco.level).append("}");
        }
        localStringBuilder.append("]");
        paramco = localStringBuilder.toString();
      }
    }
  }
  
  public static String a(List<ScanResult> paramList, String paramString1, String paramString2)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    ArrayList localArrayList;
    for (paramList = "";; paramList = de.a(paramString2).a(localArrayList))
    {
      return paramList;
      de localde = de.a(paramString1);
      localArrayList = new ArrayList();
      paramString1 = paramList.iterator();
      while (paramString1.hasNext())
      {
        ScanResult localScanResult = (ScanResult)paramString1.next();
        paramList.size();
        localArrayList.add(localde.a(localScanResult.BSSID, Integer.valueOf(localScanResult.level), new Object[0]));
      }
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, List paramList)
  {
    paramContext = i.a(paramContext, paramString1, paramString2, paramString3);
    if (paramContext != null) {
      paramContext.a(paramList);
    }
  }
  
  public static void a(Location paramLocation)
  {
    if (paramLocation.getAccuracy() > 500.0F) {
      paramLocation.setAccuracy(500.0F);
    }
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      for (;;) {}
    }
  }
  
  /* Error */
  public static void a(CharSequence paramCharSequence, java.io.File paramFile, java.nio.charset.Charset paramCharset)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 455	java/io/FileOutputStream
    //   6: astore 5
    //   8: aload 5
    //   10: aload_1
    //   11: iconst_1
    //   12: invokespecial 458	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   15: new 460	java/io/BufferedWriter
    //   18: astore_3
    //   19: new 462	java/io/OutputStreamWriter
    //   22: astore_1
    //   23: aload_1
    //   24: aload 5
    //   26: aload_2
    //   27: invokespecial 465	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
    //   30: aload_3
    //   31: aload_1
    //   32: invokespecial 468	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   35: aload_3
    //   36: astore_1
    //   37: aload_3
    //   38: aload_0
    //   39: invokevirtual 471	java/io/BufferedWriter:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   42: pop
    //   43: aload_3
    //   44: astore_1
    //   45: aload_3
    //   46: invokevirtual 474	java/io/BufferedWriter:flush	()V
    //   49: aload_3
    //   50: invokestatic 476	ct/b$a:a	(Ljava/io/Closeable;)V
    //   53: return
    //   54: astore_0
    //   55: aconst_null
    //   56: astore_1
    //   57: aload_0
    //   58: athrow
    //   59: astore_0
    //   60: aload_1
    //   61: invokestatic 476	ct/b$a:a	(Ljava/io/Closeable;)V
    //   64: aload_0
    //   65: athrow
    //   66: astore_0
    //   67: aload 4
    //   69: astore_1
    //   70: goto -10 -> 60
    //   73: astore_0
    //   74: aload_3
    //   75: astore_1
    //   76: goto -19 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	paramCharSequence	CharSequence
    //   0	79	1	paramFile	java.io.File
    //   0	79	2	paramCharset	java.nio.charset.Charset
    //   18	57	3	localBufferedWriter	java.io.BufferedWriter
    //   1	67	4	localObject	Object
    //   6	19	5	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   3	35	54	java/io/IOException
    //   37	43	59	finally
    //   45	49	59	finally
    //   57	59	59	finally
    //   3	35	66	finally
    //   37	43	73	java/io/IOException
    //   45	49	73	java/io/IOException
  }
  
  public static void a(String paramString)
  {
    a("#", 4, paramString);
  }
  
  private static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    boolean bool = true;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getCellInfoWithJsonFormat: ");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.append("isGsm=");
    if (paramInt3 == 1) {}
    for (;;)
    {
      paramString.append(bool);
      localStringBuilder.append(", mcc,mnc=").append(paramInt1).append(",").append(paramInt2);
      localStringBuilder.append(", lac,cid=").append(paramInt4).append(",").append(paramInt5);
      return;
      bool = false;
    }
  }
  
  private static void a(String paramString1, int paramInt, String paramString2)
  {
    Object localObject = cp.e();
    if (paramString2 != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((cs)((Iterator)localObject).next()).a(paramString1, paramInt, paramString2);
      }
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a(paramString1, 4, paramString2);
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(paramString1, 6, paramString2 + " exception: " + Log.getStackTraceString(paramThrowable));
  }
  
  /* Error */
  public static void a(byte[] paramArrayOfByte, java.io.File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 512	java/io/BufferedOutputStream
    //   5: astore_2
    //   6: new 455	java/io/FileOutputStream
    //   9: astore 4
    //   11: aload 4
    //   13: aload_1
    //   14: iconst_1
    //   15: invokespecial 458	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   18: aload_2
    //   19: aload 4
    //   21: invokespecial 515	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   24: aload_2
    //   25: astore_1
    //   26: aload_2
    //   27: aload_0
    //   28: invokevirtual 519	java/io/BufferedOutputStream:write	([B)V
    //   31: aload_2
    //   32: astore_1
    //   33: aload_2
    //   34: invokevirtual 520	java/io/BufferedOutputStream:flush	()V
    //   37: aload_2
    //   38: invokestatic 476	ct/b$a:a	(Ljava/io/Closeable;)V
    //   41: return
    //   42: astore_0
    //   43: aconst_null
    //   44: astore_1
    //   45: aload_0
    //   46: athrow
    //   47: astore_0
    //   48: aload_1
    //   49: invokestatic 476	ct/b$a:a	(Ljava/io/Closeable;)V
    //   52: aload_0
    //   53: athrow
    //   54: astore_0
    //   55: aload_3
    //   56: astore_1
    //   57: goto -9 -> 48
    //   60: astore_0
    //   61: aload_2
    //   62: astore_1
    //   63: goto -18 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	paramArrayOfByte	byte[]
    //   0	66	1	paramFile	java.io.File
    //   5	57	2	localBufferedOutputStream	java.io.BufferedOutputStream
    //   1	55	3	localObject	Object
    //   9	11	4	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   2	24	42	java/io/IOException
    //   26	31	47	finally
    //   33	37	47	finally
    //   45	47	47	finally
    //   2	24	54	finally
    //   26	31	60	java/io/IOException
    //   33	37	60	java/io/IOException
  }
  
  public static boolean a(int paramInt)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean a(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null) {
        break label33;
      }
      int i = paramContext.getType();
      if (i != 1) {
        break label33;
      }
      bool = true;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        label33:
        boolean bool = false;
      }
    }
    return bool;
  }
  
  public static boolean a(Location paramLocation, double[] paramArrayOfDouble)
  {
    int n = (int)(paramLocation.getLatitude() * 1000000.0D);
    int i1 = (int)(paramLocation.getLongitude() * 1000000.0D);
    paramLocation = d("tencent_loc_lib");
    int k = 0;
    int m = 0;
    while (k < paramLocation.length())
    {
      int i2 = paramLocation.charAt(k);
      int j = 256;
      int i = j;
      if (i2 >= 65)
      {
        i = j;
        if (i2 <= 90) {
          i = i2 - 65;
        }
      }
      j = i;
      if (i2 >= 97)
      {
        j = i;
        if (i2 <= 122) {
          j = i2 - 97 + 64;
        }
      }
      i = j;
      if (i2 >= 48)
      {
        i = j;
        if (i2 <= 57) {
          i = i2 + 128 - 48;
        }
      }
      m += i;
      k++;
    }
    paramLocation = new double[2];
    com.tencent.tencentmap.lbssdk.service.e.b(n ^ m, m ^ i1, paramLocation);
    paramArrayOfDouble[0] = paramLocation[0];
    paramArrayOfDouble[1] = paramLocation[1];
    return true;
  }
  
  public static boolean a(Object paramObject)
  {
    if (paramObject == null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean a(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == null) || (paramObject2 == null)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean a(Object paramObject, Object... paramVarArgs)
  {
    boolean bool2 = false;
    int i;
    boolean bool1;
    if ((paramVarArgs == null) && (paramObject == null))
    {
      i = 1;
      if (i != 0) {
        break label29;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      i = 0;
      break;
      label29:
      int j = paramVarArgs.length;
      for (i = 0;; i++)
      {
        if (i >= j) {
          break label55;
        }
        bool1 = bool2;
        if (paramVarArgs[i] != null) {
          break;
        }
      }
      label55:
      bool1 = true;
    }
  }
  
  public static boolean a(List<ScanResult> paramList1, List<ScanResult> paramList2)
  {
    boolean bool = false;
    int i;
    if ((paramList1 == null) || (paramList2 == null)) {
      i = 0;
    }
    for (;;)
    {
      if (i == 0) {
        bool = true;
      }
      return bool;
      int m = paramList1.size();
      int k = paramList2.size();
      if ((m == 0) && (k == 0))
      {
        i = 1;
      }
      else if ((m == 0) || (k == 0))
      {
        i = 0;
      }
      else
      {
        if (a(paramList1, paramList2)) {
          i = 0;
        }
        for (;;)
        {
          if ((i << 1 >= (m + k) * 0.5D) || (i >= 13))
          {
            i = 1;
            break;
            if ((paramList1.size() == 0) || (paramList2.size() == 0))
            {
              i = 0;
            }
            else
            {
              if (paramList1.size() > paramList2.size()) {}
              for (;;)
              {
                paramList2 = paramList2.iterator();
                label154:
                int j = 0;
                for (;;)
                {
                  i = j;
                  if (!paramList2.hasNext()) {
                    break;
                  }
                  ScanResult localScanResult = (ScanResult)paramList2.next();
                  localObject = paramList1.iterator();
                  if (((Iterator)localObject).hasNext())
                  {
                    if (!((ScanResult)((Iterator)localObject).next()).BSSID.equals(localScanResult.BSSID)) {
                      break label154;
                    }
                    j++;
                  }
                }
                Object localObject = paramList2;
                paramList2 = paramList1;
                paramList1 = (List<ScanResult>)localObject;
              }
            }
          }
        }
        i = 0;
      }
    }
  }
  
  /* Error */
  public static byte[] a(java.io.File paramFile)
  {
    // Byte code:
    //   0: new 573	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 574	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_3
    //   8: sipush 8192
    //   11: newarray <illegal type>
    //   13: astore 4
    //   15: new 576	java/io/BufferedInputStream
    //   18: astore_2
    //   19: new 578	java/io/FileInputStream
    //   22: astore 5
    //   24: aload 5
    //   26: aload_0
    //   27: invokespecial 581	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   30: aload_2
    //   31: aload 5
    //   33: invokespecial 584	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   36: aload_2
    //   37: astore_0
    //   38: aload_2
    //   39: aload 4
    //   41: invokevirtual 588	java/io/BufferedInputStream:read	([B)I
    //   44: istore_1
    //   45: iload_1
    //   46: iconst_m1
    //   47: if_icmpeq +34 -> 81
    //   50: aload_2
    //   51: astore_0
    //   52: aload_3
    //   53: aload 4
    //   55: iconst_0
    //   56: iload_1
    //   57: invokevirtual 591	java/io/ByteArrayOutputStream:write	([BII)V
    //   60: goto -24 -> 36
    //   63: astore_3
    //   64: aload_2
    //   65: astore_0
    //   66: aload_3
    //   67: astore_2
    //   68: aload_2
    //   69: athrow
    //   70: astore_3
    //   71: aload_0
    //   72: astore_2
    //   73: aload_3
    //   74: astore_0
    //   75: aload_2
    //   76: invokestatic 476	ct/b$a:a	(Ljava/io/Closeable;)V
    //   79: aload_0
    //   80: athrow
    //   81: aload_2
    //   82: astore_0
    //   83: aload_3
    //   84: invokevirtual 595	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   87: astore_3
    //   88: aload_2
    //   89: invokestatic 476	ct/b$a:a	(Ljava/io/Closeable;)V
    //   92: aload_3
    //   93: areturn
    //   94: astore_0
    //   95: aconst_null
    //   96: astore_2
    //   97: goto -22 -> 75
    //   100: astore_2
    //   101: aconst_null
    //   102: astore_0
    //   103: goto -35 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	106	0	paramFile	java.io.File
    //   44	13	1	i	int
    //   18	79	2	localObject1	Object
    //   100	1	2	localIOException1	IOException
    //   7	46	3	localByteArrayOutputStream	ByteArrayOutputStream
    //   63	4	3	localIOException2	IOException
    //   70	14	3	localObject2	Object
    //   87	6	3	arrayOfByte1	byte[]
    //   13	41	4	arrayOfByte2	byte[]
    //   22	10	5	localFileInputStream	java.io.FileInputStream
    // Exception table:
    //   from	to	target	type
    //   38	45	63	java/io/IOException
    //   52	60	63	java/io/IOException
    //   83	88	63	java/io/IOException
    //   38	45	70	finally
    //   52	60	70	finally
    //   68	70	70	finally
    //   83	88	70	finally
    //   15	36	94	finally
    //   15	36	100	java/io/IOException
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = b(paramArrayOfByte);
    int i = arrayOfByte.length;
    paramArrayOfByte = new byte[i];
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte, 0, i);
    int k = i % 5 + 7;
    i = 0;
    while ((k << 1) + i < paramArrayOfByte.length)
    {
      int m = Integer.valueOf(i).byteValue();
      for (int j = 0; j < k; j++)
      {
        int n = paramArrayOfByte[(i + j)];
        paramArrayOfByte[(i + j)] = ((byte)(paramArrayOfByte[(i + k + j)] ^ m));
        paramArrayOfByte[(i + k + j)] = ((byte)(n ^ m));
      }
      i += (k << 1);
    }
    arrayOfByte = new byte[paramArrayOfByte.length + 4];
    i = paramArrayOfByte.length;
    arrayOfByte[0] = Integer.valueOf(i >> 8).byteValue();
    arrayOfByte[1] = Integer.valueOf(i >> 24).byteValue();
    arrayOfByte[2] = Integer.valueOf(i >> 16).byteValue();
    arrayOfByte[3] = Integer.valueOf(i).byteValue();
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 4, i);
    return arrayOfByte;
  }
  
  public static a b()
  {
    try
    {
      if (d == null)
      {
        locala = new ct/b$a;
        locala.<init>();
        d = locala;
      }
      a locala = d;
      return locala;
    }
    finally {}
  }
  
  public static String b(Context paramContext)
  {
    int i = d(paramContext);
    if (i != -1) {
      if (i == 0) {
        paramContext = "mobile";
      }
    }
    for (;;)
    {
      return paramContext;
      if (i == 1) {
        paramContext = "wifi";
      } else {
        paramContext = "none";
      }
    }
  }
  
  public static String b(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static void b(String paramString1, String paramString2)
  {
    a(paramString1, 6, paramString2);
  }
  
  public static boolean b(Object paramObject)
  {
    if (paramObject != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static byte[] b(byte[] paramArrayOfByte)
  {
    Object localObject = null;
    if (paramArrayOfByte == null) {
      paramArrayOfByte = (byte[])localObject;
    }
    for (;;)
    {
      return paramArrayOfByte;
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      DeflaterOutputStream localDeflaterOutputStream = new DeflaterOutputStream(localByteArrayOutputStream);
      try
      {
        localDeflaterOutputStream.write(paramArrayOfByte, 0, paramArrayOfByte.length);
        localDeflaterOutputStream.finish();
        localDeflaterOutputStream.flush();
        localDeflaterOutputStream.close();
        paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte = (byte[])localObject;
      }
    }
  }
  
  public static boolean c(Context paramContext)
  {
    int i = 1;
    boolean bool2 = false;
    Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (localObject == null) {}
    boolean bool1;
    while (i != 0)
    {
      bool1 = bool2;
      return bool1;
      i = 0;
    }
    for (;;)
    {
      try
      {
        paramContext = ((ConnectivityManager)localObject).getNetworkInfo(0);
        localObject = ((ConnectivityManager)localObject).getNetworkInfo(1);
        if (localObject == null) {
          break label90;
        }
        boolean bool3 = ((NetworkInfo)localObject).isConnected();
        bool1 = bool3;
        if (!bool3)
        {
          bool1 = bool3;
          if (paramContext != null) {
            bool1 = paramContext.isConnected();
          }
        }
      }
      catch (Exception paramContext)
      {
        bool1 = bool2;
      }
      break;
      label90:
      bool1 = false;
    }
  }
  
  public static boolean c(String paramString)
  {
    bool2 = true;
    try
    {
      localJSONObject = new org/json/JSONObject;
      localJSONObject.<init>(paramString);
      if (!paramString.contains("latitude")) {
        break label31;
      }
      bool1 = bool2;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        boolean bool1 = false;
        continue;
        paramString = localJSONObject.optJSONArray("cells");
        if (paramString != null)
        {
          bool1 = bool2;
          if (paramString.length() > 0) {}
        }
        else
        {
          paramString = localJSONObject.optJSONArray("wifis");
          if (paramString != null)
          {
            bool1 = bool2;
            if (paramString.length() > 0) {}
          }
          else
          {
            bool1 = false;
          }
        }
      }
    }
    return bool1;
  }
  
  @Nullable
  public static byte[] c(byte[] paramArrayOfByte)
  {
    int i = 0;
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = null;
      return paramArrayOfByte;
    }
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
    InflaterInputStream localInflaterInputStream = new InflaterInputStream(localByteArrayInputStream);
    paramArrayOfByte = new byte[0];
    byte[] arrayOfByte2 = new byte['Ѐ'];
    label112:
    label115:
    for (;;)
    {
      try
      {
        int j = localInflaterInputStream.read(arrayOfByte2);
        if (j <= 0) {
          break label115;
        }
        i += j;
        byte[] arrayOfByte1 = new byte[i];
        System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, 0, paramArrayOfByte.length);
        System.arraycopy(arrayOfByte2, 0, arrayOfByte1, paramArrayOfByte.length, j);
        paramArrayOfByte = arrayOfByte1;
        if (j > 0) {
          break label112;
        }
        try
        {
          localByteArrayInputStream.close();
          localInflaterInputStream.close();
        }
        catch (IOException paramArrayOfByte)
        {
          paramArrayOfByte = null;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte = null;
      }
      break;
    }
  }
  
  private static int d(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    int i;
    if (paramContext == null)
    {
      i = 1;
      if (i == 0) {
        break label30;
      }
      i = -1;
    }
    for (;;)
    {
      return i;
      i = 0;
      break;
      try
      {
        label30:
        paramContext = paramContext.getActiveNetworkInfo();
        if (paramContext != null) {
          i = paramContext.getType();
        }
      }
      catch (Exception paramContext)
      {
        i = -1;
      }
    }
  }
  
  public static String d(String paramString)
  {
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes());
      byte[] arrayOfByte = ((MessageDigest)localObject).digest();
      localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      int j = arrayOfByte.length;
      for (int i = 0; i < j; i++) {
        ((StringBuilder)localObject).append(Integer.toHexString(arrayOfByte[i] & 0xFF)).append("");
      }
      localObject = ((StringBuilder)localObject).toString();
      paramString = (String)localObject;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return paramString;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/b$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */