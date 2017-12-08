package com.tencent.wxop.stat;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.wxop.stat.b.b;
import com.tencent.wxop.stat.b.l;
import com.tencent.wxop.stat.b.q;
import com.tencent.wxop.stat.b.r;
import java.net.URI;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  static String M;
  private static b N = ;
  static ah O = new ah(2);
  static ah P = new ah(1);
  private static d Q = d.aE;
  private static boolean R = false;
  private static boolean S = true;
  private static int T = 30000;
  private static int U = 100000;
  private static int V = 30;
  static String W;
  private static String X;
  private static String Y;
  private static String Z;
  static int aA = 512;
  private static String aa;
  static String ab;
  private static int ac;
  static boolean ad;
  static int ae;
  static long af;
  private static int ag;
  static boolean ah;
  private static long ai;
  private static long aj;
  public static boolean ak;
  static volatile String al;
  private static volatile String am;
  private static int an;
  private static volatile int ao;
  private static int ap;
  private static int aq;
  private static boolean ar;
  private static int as;
  private static boolean at;
  private static String au;
  private static boolean av;
  private static ai aw;
  static boolean ax;
  static int ay;
  static long az;
  static String c;
  private static int w = 10;
  private static int x = 100;
  private static int y = 30;
  private static int z = 1;
  
  static
  {
    c = "__HIBERNATE__";
    W = "__HIBERNATE__TIME";
    M = "__MTA_KILL__";
    X = null;
    aa = "mta_channel";
    ab = "";
    ac = 180;
    ad = false;
    ae = 100;
    af = 10000L;
    ag = 1024;
    ah = true;
    ai = 0L;
    aj = 300000L;
    ak = true;
    al = "pingma.qq.com:80";
    am = "http://pingma.qq.com:80/mstat/report";
    an = 0;
    ao = 0;
    ap = 20;
    aq = 0;
    ar = false;
    as = 4096;
    at = false;
    au = null;
    av = false;
    aw = null;
    ax = true;
    ay = 0;
    az = 10000L;
  }
  
  public static int A()
  {
    return ap;
  }
  
  static void B()
  {
    aq += 1;
  }
  
  static void C()
  {
    aq = 0;
  }
  
  static int D()
  {
    return aq;
  }
  
  public static boolean E()
  {
    return at;
  }
  
  public static ai F()
  {
    return aw;
  }
  
  static void a(Context paramContext, ah paramah)
  {
    if (paramah.aI == P.aI)
    {
      P = paramah;
      a(paramah.df);
      if (!P.df.isNull("iplist")) {
        g.r(paramContext).b(P.df.getString("iplist"));
      }
    }
    for (;;)
    {
      return;
      if (paramah.aI == O.aI) {
        O = paramah;
      }
    }
  }
  
  private static void a(Context paramContext, ah paramah, JSONObject paramJSONObject)
  {
    for (;;)
    {
      try
      {
        localObject1 = paramJSONObject.keys();
        i = 0;
      }
      catch (JSONException paramContext)
      {
        int j;
        N.b(paramContext);
        return;
        if (!((String)localObject2).equalsIgnoreCase("m")) {
          continue;
        }
        paramah.c = paramJSONObject.getString("m");
        continue;
      }
      catch (Throwable paramContext)
      {
        N.b(paramContext);
        continue;
        if (i != 1) {
          continue;
        }
        paramJSONObject = t.s(ak.aB());
        if (paramJSONObject == null) {
          continue;
        }
        paramJSONObject.b(paramah);
        if (paramah.aI != P.aI) {
          continue;
        }
        a(paramah.df);
        paramJSONObject = paramah.df;
        if ((paramJSONObject != null) && (paramJSONObject.length() != 0)) {
          continue;
        }
        a(paramContext, paramah);
        continue;
        try
        {
          localObject1 = ak.aB();
        }
        catch (JSONException paramJSONObject)
        {
          N.e("__HIBERNATE__ not found.");
        }
        try
        {
          localObject3 = paramJSONObject.optString(M);
          if (l.e((String)localObject3))
          {
            localObject2 = new org/json/JSONObject;
            ((JSONObject)localObject2).<init>((String)localObject3);
            i = ((JSONObject)localObject2).length();
            if (i != 0) {
              continue;
            }
          }
        }
        catch (Exception localException)
        {
          Object localObject4;
          long l2;
          N.b(localException);
          continue;
          if (!(localObject3 instanceof String)) {
            continue;
          }
          i = Integer.valueOf((String)localObject3).intValue();
          continue;
          i = 0;
          continue;
          i = 0;
          continue;
        }
        Object localObject1 = paramJSONObject.getString(c);
        if (!R) {
          continue;
        }
        paramJSONObject = N;
        Object localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>("hibernateVer:");
        paramJSONObject.e((String)localObject1 + ", current version:2.0.3");
        long l1 = l.u((String)localObject1);
        if (l.u("2.0.3") > l1) {
          continue;
        }
        b(l1);
        continue;
        continue;
        if (((JSONObject)localObject2).isNull("sm")) {
          continue;
        }
        Object localObject3 = ((JSONObject)localObject2).get("sm");
        if (!(localObject3 instanceof Integer)) {
          continue;
        }
        int i = ((Integer)localObject3).intValue();
        if (i <= 0) {
          continue;
        }
        if (!R) {
          continue;
        }
        localObject4 = N;
        localObject3 = new java/lang/StringBuilder;
        ((StringBuilder)localObject3).<init>("match sleepTime:");
        ((b)localObject4).b(i + " minutes");
        l1 = System.currentTimeMillis();
        l2 = i * 60 * 1000;
        q.a((Context)localObject1, W, l1 + l2);
        a(false);
        N.warn("MTA is disable for current SDK version");
        if (!b((JSONObject)localObject2, "sv", "2.0.3")) {
          continue;
        }
        N.b("match sdk version:2.0.3");
        i = 1;
        if (!b((JSONObject)localObject2, "md", Build.MODEL)) {
          continue;
        }
        localObject3 = N;
        localObject4 = new java/lang/StringBuilder;
        ((StringBuilder)localObject4).<init>("match MODEL:");
        ((b)localObject3).b(Build.MODEL);
        i = 1;
        if (!b((JSONObject)localObject2, "av", l.D((Context)localObject1))) {
          continue;
        }
        localObject3 = N;
        localObject4 = new java/lang/StringBuilder;
        ((StringBuilder)localObject4).<init>("match app version:");
        ((b)localObject3).b(l.D((Context)localObject1));
        i = 1;
        localObject3 = new java/lang/StringBuilder;
        ((StringBuilder)localObject3).<init>();
        if (!b((JSONObject)localObject2, "mf", Build.MANUFACTURER)) {
          continue;
        }
        localObject4 = N;
        localObject3 = new java/lang/StringBuilder;
        ((StringBuilder)localObject3).<init>("match MANUFACTURER:");
        ((b)localObject4).b(Build.MANUFACTURER);
        i = 1;
        localObject3 = new java/lang/StringBuilder;
        ((StringBuilder)localObject3).<init>();
        if (!b((JSONObject)localObject2, "osv", Build.VERSION.SDK_INT)) {
          continue;
        }
        localObject3 = N;
        localObject4 = new java/lang/StringBuilder;
        ((StringBuilder)localObject4).<init>("match android SDK version:");
        ((b)localObject3).b(Build.VERSION.SDK_INT);
        i = 1;
        localObject3 = new java/lang/StringBuilder;
        ((StringBuilder)localObject3).<init>();
        if (!b((JSONObject)localObject2, "ov", Build.VERSION.SDK_INT)) {
          continue;
        }
        localObject3 = N;
        localObject4 = new java/lang/StringBuilder;
        ((StringBuilder)localObject4).<init>("match android SDK version:");
        ((b)localObject3).b(Build.VERSION.SDK_INT);
        i = 1;
        if (!b((JSONObject)localObject2, "ui", t.s((Context)localObject1).t((Context)localObject1).b())) {
          continue;
        }
        localObject3 = N;
        localObject4 = new java/lang/StringBuilder;
        ((StringBuilder)localObject4).<init>("match imei:");
        ((b)localObject3).b(t.s((Context)localObject1).t((Context)localObject1).b());
        i = 1;
        if (!b((JSONObject)localObject2, "mid", h((Context)localObject1))) {
          continue;
        }
        localObject2 = N;
        localObject3 = new java/lang/StringBuilder;
        ((StringBuilder)localObject3).<init>("match mid:");
        ((b)localObject2).b(h((Context)localObject1));
        i = 1;
        if (i == 0) {
          continue;
        }
        b(l.u("2.0.3"));
        continue;
        continue;
      }
      if (!((Iterator)localObject1).hasNext()) {
        continue;
      }
      localObject2 = (String)((Iterator)localObject1).next();
      if (((String)localObject2).equalsIgnoreCase("v"))
      {
        j = paramJSONObject.getInt((String)localObject2);
        if (paramah.L == j) {
          continue;
        }
        i = 1;
        paramah.L = j;
      }
      else
      {
        if (!((String)localObject2).equalsIgnoreCase("c")) {
          continue;
        }
        localObject3 = paramJSONObject.getString("c");
        if (((String)localObject3).length() > 0)
        {
          localObject2 = new org/json/JSONObject;
          ((JSONObject)localObject2).<init>((String)localObject3);
          paramah.df = ((JSONObject)localObject2);
        }
      }
    }
  }
  
  static void a(Context paramContext, JSONObject paramJSONObject)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = paramJSONObject.keys();
        if (localIterator.hasNext())
        {
          localObject = (String)localIterator.next();
          if (((String)localObject).equalsIgnoreCase(Integer.toString(P.aI)))
          {
            localObject = paramJSONObject.getJSONObject((String)localObject);
            a(paramContext, P, (JSONObject)localObject);
          }
        }
        else
        {
          return;
        }
      }
      catch (JSONException paramContext)
      {
        N.b(paramContext);
      }
      do
      {
        if (((String)localObject).equalsIgnoreCase(Integer.toString(O.aI)))
        {
          localObject = paramJSONObject.getJSONObject((String)localObject);
          a(paramContext, O, (JSONObject)localObject);
          break;
        }
      } while (!((String)localObject).equalsIgnoreCase("rs"));
      Object localObject = d.a(paramJSONObject.getInt((String)localObject));
      if (localObject != null)
      {
        Q = (d)localObject;
        if (R)
        {
          b localb = N;
          StringBuilder localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>("Change to ReportStrategy:");
          localb.e(((d)localObject).name());
        }
      }
    }
  }
  
  public static void a(d paramd)
  {
    Q = paramd;
    if (paramd != d.aG) {
      e.aZ = 0L;
    }
    if (R) {
      N.e("Change to statSendStrategy: " + paramd);
    }
  }
  
  private static void a(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = d.a(paramJSONObject.getInt("rs"));
      if (paramJSONObject != null) {
        a(paramJSONObject);
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        if (R) {
          N.b("rs not found.");
        }
      }
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    S = paramBoolean;
    if (!paramBoolean) {
      N.warn("!!!!!!MTA StatService has been disabled!!!!!!");
    }
  }
  
  private static void b(long paramLong)
  {
    q.a(ak.aB(), c, paramLong);
    a(false);
    N.warn("MTA is disable for current SDK version");
  }
  
  public static void b(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      N.error("ctx in StatConfig.setAppKey() is null");
    }
    for (;;)
    {
      return;
      if ((paramString == null) || (paramString.length() > 256))
      {
        N.error("appkey in StatConfig.setAppKey() is null or exceed 256 bytes");
      }
      else
      {
        if (Y == null) {
          Y = r.t(q.b(paramContext, "_mta_ky_tag_", null));
        }
        if ((m(paramString) | m(l.z(paramContext))))
        {
          paramString = Y;
          if (paramString != null) {
            q.c(paramContext, "_mta_ky_tag_", r.q(paramString));
          }
        }
      }
    }
  }
  
  private static boolean b(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    if (!paramJSONObject.isNull(paramString1))
    {
      paramJSONObject = paramJSONObject.optString(paramString1);
      if ((!l.e(paramString2)) || (!l.e(paramJSONObject)) || (!paramString2.equalsIgnoreCase(paramJSONObject))) {}
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static void c(Context paramContext, String paramString)
  {
    if (paramString.length() > 128) {
      N.error("the length of installChannel can not exceed the range of 128 bytes.");
    }
    for (;;)
    {
      return;
      Z = paramString;
      q.c(paramContext, aa, paramString);
    }
  }
  
  /* Error */
  public static String d(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 481	com/tencent/wxop/stat/c:Y	Ljava/lang/String;
    //   6: ifnull +12 -> 18
    //   9: getstatic 481	com/tencent/wxop/stat/c:Y	Ljava/lang/String;
    //   12: astore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: aload_0
    //   19: ifnull +16 -> 35
    //   22: getstatic 481	com/tencent/wxop/stat/c:Y	Ljava/lang/String;
    //   25: ifnonnull +10 -> 35
    //   28: aload_0
    //   29: invokestatic 494	com/tencent/wxop/stat/b/l:z	(Landroid/content/Context;)Ljava/lang/String;
    //   32: putstatic 481	com/tencent/wxop/stat/c:Y	Ljava/lang/String;
    //   35: getstatic 481	com/tencent/wxop/stat/c:Y	Ljava/lang/String;
    //   38: ifnull +15 -> 53
    //   41: getstatic 481	com/tencent/wxop/stat/c:Y	Ljava/lang/String;
    //   44: invokevirtual 508	java/lang/String:trim	()Ljava/lang/String;
    //   47: invokevirtual 264	java/lang/String:length	()I
    //   50: ifne +12 -> 62
    //   53: getstatic 66	com/tencent/wxop/stat/c:N	Lcom/tencent/wxop/stat/b/b;
    //   56: ldc_w 510
    //   59: invokevirtual 477	com/tencent/wxop/stat/b/b:error	(Ljava/lang/Object;)V
    //   62: getstatic 481	com/tencent/wxop/stat/c:Y	Ljava/lang/String;
    //   65: astore_0
    //   66: goto -53 -> 13
    //   69: astore_0
    //   70: ldc 2
    //   72: monitorexit
    //   73: aload_0
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   3	13	69	finally
    //   22	35	69	finally
    //   35	53	69	finally
    //   53	62	69	finally
    //   62	66	69	finally
  }
  
  /* Error */
  public static String e(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 504	com/tencent/wxop/stat/c:Z	Ljava/lang/String;
    //   6: ifnull +12 -> 18
    //   9: getstatic 504	com/tencent/wxop/stat/c:Z	Ljava/lang/String;
    //   12: astore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: aload_0
    //   19: getstatic 120	com/tencent/wxop/stat/c:aa	Ljava/lang/String;
    //   22: ldc 122
    //   24: invokestatic 486	com/tencent/wxop/stat/b/q:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   27: astore_1
    //   28: aload_1
    //   29: putstatic 504	com/tencent/wxop/stat/c:Z	Ljava/lang/String;
    //   32: aload_1
    //   33: ifnull +15 -> 48
    //   36: getstatic 504	com/tencent/wxop/stat/c:Z	Ljava/lang/String;
    //   39: invokevirtual 508	java/lang/String:trim	()Ljava/lang/String;
    //   42: invokevirtual 264	java/lang/String:length	()I
    //   45: ifne +10 -> 55
    //   48: aload_0
    //   49: invokestatic 512	com/tencent/wxop/stat/b/l:A	(Landroid/content/Context;)Ljava/lang/String;
    //   52: putstatic 504	com/tencent/wxop/stat/c:Z	Ljava/lang/String;
    //   55: getstatic 504	com/tencent/wxop/stat/c:Z	Ljava/lang/String;
    //   58: ifnull +15 -> 73
    //   61: getstatic 504	com/tencent/wxop/stat/c:Z	Ljava/lang/String;
    //   64: invokevirtual 508	java/lang/String:trim	()Ljava/lang/String;
    //   67: invokevirtual 264	java/lang/String:length	()I
    //   70: ifne +12 -> 82
    //   73: getstatic 66	com/tencent/wxop/stat/c:N	Lcom/tencent/wxop/stat/b/b;
    //   76: ldc_w 514
    //   79: invokevirtual 516	com/tencent/wxop/stat/b/b:c	(Ljava/lang/Object;)V
    //   82: getstatic 504	com/tencent/wxop/stat/c:Z	Ljava/lang/String;
    //   85: astore_0
    //   86: goto -73 -> 13
    //   89: astore_0
    //   90: ldc 2
    //   92: monitorexit
    //   93: aload_0
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	paramContext	Context
    //   27	6	1	str	String
    // Exception table:
    //   from	to	target	type
    //   3	13	89	finally
    //   18	32	89	finally
    //   36	48	89	finally
    //   48	55	89	finally
    //   55	73	89	finally
    //   73	82	89	finally
    //   82	86	89	finally
  }
  
  public static String f(Context paramContext)
  {
    return q.b(paramContext, "mta.acc.qq", ab);
  }
  
  public static String g(Context paramContext)
  {
    if (paramContext == null) {
      N.error("Context for getCustomUid is null.");
    }
    for (paramContext = null;; paramContext = au)
    {
      return paramContext;
      if (au == null) {
        au = q.b(paramContext, "MTA_CUSTOM_UID", "");
      }
    }
  }
  
  public static String h(Context paramContext)
  {
    if (paramContext != null) {}
    for (paramContext = com.tencent.a.a.a.a.g.a(paramContext).f().c();; paramContext = "0") {
      return paramContext;
    }
  }
  
  public static d j()
  {
    return Q;
  }
  
  public static boolean k()
  {
    return R;
  }
  
  static String l(String paramString)
  {
    try
    {
      String str = P.df.getString(paramString);
      paramString = str;
      if (paramString == null) {
        break label43;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        N.c("can't find custom key:" + paramString);
        label43:
        paramString = null;
      }
    }
    return paramString;
  }
  
  public static boolean l()
  {
    return S;
  }
  
  public static int m()
  {
    return T;
  }
  
  private static boolean m(String paramString)
  {
    boolean bool = false;
    if (paramString == null) {}
    for (;;)
    {
      return bool;
      if (Y == null)
      {
        Y = paramString;
        bool = true;
      }
      else if (!Y.contains(paramString))
      {
        Y = Y + "|" + paramString;
        bool = true;
      }
    }
  }
  
  public static int n()
  {
    return x;
  }
  
  public static void n(String paramString)
  {
    if (paramString.length() > 128) {
      N.error("the length of installChannel can not exceed the range of 128 bytes.");
    }
    for (;;)
    {
      return;
      Z = paramString;
    }
  }
  
  public static int o()
  {
    return y;
  }
  
  public static void o(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      N.error("statReportUrl cannot be null or empty.");
    }
    for (;;)
    {
      return;
      am = paramString;
      try
      {
        paramString = new java/net/URI;
        paramString.<init>(am);
        al = paramString.getHost();
        if (!R) {
          continue;
        }
        N.b("url:" + am + ", domain:" + al);
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          N.c(paramString);
        }
      }
    }
  }
  
  public static int p()
  {
    return w;
  }
  
  public static int q()
  {
    return z;
  }
  
  static int r()
  {
    return V;
  }
  
  public static int s()
  {
    return U;
  }
  
  public static void t()
  {
    ac = 60;
  }
  
  public static int u()
  {
    return ac;
  }
  
  public static int v()
  {
    return ag;
  }
  
  public static void w()
  {
    ah = true;
  }
  
  public static boolean x()
  {
    return ak;
  }
  
  public static String y()
  {
    return am;
  }
  
  static void z()
  {
    try
    {
      ao = 0;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/wxop/stat/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */