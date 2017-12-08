package ct;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.params.HttpParams;

public class ba
{
  public static String a;
  public static String b;
  public static volatile boolean c = false;
  private static final String d = ba.class.getSimpleName();
  private static String e = "cmwap";
  private static String f = "3gwap";
  private static String g = "uniwap";
  private static String h = "ctwap";
  private static Context i;
  private static volatile boolean j = true;
  private static String k;
  private static volatile int l;
  private static int m;
  private static String n = "";
  
  static
  {
    a = "";
    k = "";
    b = "";
    l = 0;
    m = 0;
  }
  
  /* Error */
  public static String a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 60	ct/ba:l	I
    //   6: tableswitch	default:+30->36, 1:+38->44, 2:+68->74, 3:+68->74, 4:+92->98
    //   36: ldc 72
    //   38: astore_0
    //   39: ldc 2
    //   41: monitorexit
    //   42: aload_0
    //   43: areturn
    //   44: new 74	java/lang/StringBuilder
    //   47: astore_0
    //   48: aload_0
    //   49: ldc 76
    //   51: invokespecial 79	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   54: aload_0
    //   55: getstatic 56	ct/ba:k	Ljava/lang/String;
    //   58: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: getstatic 58	ct/ba:b	Ljava/lang/String;
    //   64: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: astore_0
    //   71: goto -32 -> 39
    //   74: new 74	java/lang/StringBuilder
    //   77: astore_0
    //   78: aload_0
    //   79: ldc 88
    //   81: invokespecial 79	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   84: aload_0
    //   85: getstatic 54	ct/ba:a	Ljava/lang/String;
    //   88: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: astore_0
    //   95: goto -56 -> 39
    //   98: new 74	java/lang/StringBuilder
    //   101: astore_0
    //   102: aload_0
    //   103: ldc 90
    //   105: invokespecial 79	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   108: aload_0
    //   109: getstatic 54	ct/ba:a	Ljava/lang/String;
    //   112: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: astore_0
    //   119: goto -80 -> 39
    //   122: astore_0
    //   123: ldc 2
    //   125: monitorexit
    //   126: aload_0
    //   127: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   38	81	0	localObject1	Object
    //   122	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	36	122	finally
    //   44	71	122	finally
    //   74	95	122	finally
    //   98	119	122	finally
  }
  
  public static void a(Context paramContext)
  {
    try
    {
      i = paramContext;
      b();
      f();
      return;
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
  }
  
  public static void a(HttpClient paramHttpClient)
  {
    if ((c) && (!TextUtils.isEmpty(n)))
    {
      HttpHost localHttpHost = new HttpHost(n, 80);
      paramHttpClient.getParams().setParameter("http.route.default-proxy", localHttpHost);
      bb.a(d, "setProxy... sProxyAddress:" + n + ",apn:" + a);
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    j = paramBoolean;
  }
  
  /* Error */
  public static boolean a(Integer paramInteger)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: ldc 2
    //   4: monitorenter
    //   5: iload_3
    //   6: istore_2
    //   7: aload_0
    //   8: invokevirtual 142	java/lang/Integer:intValue	()I
    //   11: iconst_1
    //   12: if_icmpeq +25 -> 37
    //   15: iload_3
    //   16: istore_2
    //   17: aload_0
    //   18: invokevirtual 142	java/lang/Integer:intValue	()I
    //   21: iconst_2
    //   22: if_icmpeq +15 -> 37
    //   25: aload_0
    //   26: invokevirtual 142	java/lang/Integer:intValue	()I
    //   29: istore_1
    //   30: iload_1
    //   31: iconst_3
    //   32: if_icmpne +10 -> 42
    //   35: iload_3
    //   36: istore_2
    //   37: ldc 2
    //   39: monitorexit
    //   40: iload_2
    //   41: ireturn
    //   42: iconst_0
    //   43: istore_2
    //   44: goto -7 -> 37
    //   47: astore_0
    //   48: ldc 2
    //   50: monitorexit
    //   51: aload_0
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	paramInteger	Integer
    //   29	4	1	i1	int
    //   6	38	2	bool1	boolean
    //   1	35	3	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   7	15	47	finally
    //   17	30	47	finally
  }
  
  public static void b()
  {
    for (;;)
    {
      NetworkInfo localNetworkInfo;
      int i1;
      try
      {
        bb.b(d, "updateApn");
        localNetworkInfo = ((ConnectivityManager)i.getSystemService("connectivity")).getActiveNetworkInfo();
        if (localNetworkInfo != null) {
          continue;
        }
        a = "";
        l = 0;
        c = false;
        n = "";
        j = false;
      }
      catch (Exception localException)
      {
        WifiInfo localWifiInfo;
        localException.printStackTrace();
        continue;
      }
      finally {}
      return;
      if ((localNetworkInfo.isAvailable()) && (localNetworkInfo.isConnected()))
      {
        j = true;
        i1 = localNetworkInfo.getType();
        if (i1 == 1)
        {
          l = 1;
          c = false;
          n = "";
          localWifiInfo = ((WifiManager)i.getSystemService("wifi")).getConnectionInfo();
          k = localWifiInfo.getSSID();
          b = localWifiInfo.getBSSID();
        }
      }
      else
      {
        j = false;
        continue;
      }
      String str = localNetworkInfo.getExtraInfo();
      if (str == null)
      {
        a = "";
        l = 0;
        c = false;
        n = "";
      }
      else
      {
        a = str.trim().toLowerCase();
        if (i1 == 0)
        {
          i1 = localNetworkInfo.getSubtype();
          if ((i1 != 1) && (i1 != 2) && (i1 != 4)) {
            break label251;
          }
          l = 2;
        }
        for (;;)
        {
          m = g().intValue();
          if (!a.contains(f)) {
            break label271;
          }
          c = true;
          n = "10.0.0.172";
          break;
          label251:
          if (i1 == 13) {
            l = 4;
          } else {
            l = 3;
          }
        }
        label271:
        if (a.contains(e))
        {
          c = true;
          n = "10.0.0.172";
        }
        else if (a.contains(g))
        {
          c = true;
          n = "10.0.0.172";
        }
        else if (a.contains(h))
        {
          c = true;
          n = "10.0.0.200";
        }
        else
        {
          c = false;
          n = "";
        }
      }
    }
  }
  
  public static int c()
  {
    try
    {
      int i1 = l;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static int d()
  {
    try
    {
      int i1 = m;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static boolean e()
  {
    return j;
  }
  
  public static void f()
  {
    try
    {
      String str = d;
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>("showApnInfo... Apn:");
      bb.b(str, a + ",sIsNetworkOk:" + j + ",sNetType:" + l + ",sIsProxy:" + c + ",sProxyAddress:" + n);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private static Integer g()
  {
    int i3 = 3;
    int i2 = 2;
    int i1 = 1;
    for (;;)
    {
      Object localObject4;
      try
      {
        if (l == 1)
        {
          localObject1 = k;
          if ((localObject1 == null) || (((String)localObject1).length() <= 0))
          {
            localObject1 = Integer.valueOf(0);
            m = ((Integer)localObject1).intValue();
            i1 = m;
            return Integer.valueOf(i1);
          }
          localObject1 = ((String)localObject1).toLowerCase();
          if (!((String)localObject1).contains("cmcc")) {
            break label374;
          }
          if (!((String)localObject1).contains("chinanet")) {
            break label371;
          }
          i1 = i3;
          if (!((String)localObject1).contains("chinaunicom")) {
            break label368;
          }
          i1 = i2;
          localObject1 = Integer.valueOf(i1);
          continue;
        }
        if ((l != 2) && (l != 3)) {
          break label361;
        }
        localObject4 = i;
        Object localObject1 = a;
        localObject4 = (TelephonyManager)((Context)localObject4).getSystemService("phone");
        if ((localObject4 == null) || (((TelephonyManager)localObject4).getSimState() != 5)) {
          break label244;
        }
        localObject4 = ((TelephonyManager)localObject4).getSimOperator();
        if (((String)localObject4).length() <= 0) {
          break label244;
        }
        if ((((String)localObject4).equals("46000")) || (((String)localObject4).equals("46002")))
        {
          localObject1 = Integer.valueOf(1);
          m = ((Integer)localObject1).intValue();
          continue;
        }
        if (!((String)localObject4).equals("46001")) {
          break label225;
        }
      }
      finally {}
      Object localObject3 = Integer.valueOf(2);
      continue;
      label225:
      if (((String)localObject4).equals("46003"))
      {
        localObject3 = Integer.valueOf(3);
      }
      else
      {
        label244:
        if (localObject3 != null)
        {
          localObject3 = ((String)localObject3).toLowerCase();
          if ((((String)localObject3).contains("cmnet")) || (((String)localObject3).contains("cmwap")))
          {
            localObject3 = Integer.valueOf(1);
            continue;
          }
          if ((((String)localObject3).contains("uninet")) || (((String)localObject3).contains("uniwap")) || (((String)localObject3).contains("3gnet")) || (((String)localObject3).contains("3gwap")))
          {
            localObject3 = Integer.valueOf(2);
            continue;
          }
          if ((((String)localObject3).contains("ctnet")) || (((String)localObject3).contains("ctwap")))
          {
            localObject3 = Integer.valueOf(3);
            continue;
          }
        }
        localObject3 = Integer.valueOf(0);
        continue;
        label361:
        m = 0;
        continue;
        label368:
        continue;
        label371:
        continue;
        label374:
        i1 = 0;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */