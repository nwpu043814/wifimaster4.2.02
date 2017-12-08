package com.alipay.b.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.alipay.b.d.e;
import com.alipay.b.f.g;
import com.alipay.b.f.h;
import com.alipay.b.f.i;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public final class a
{
  private Context a;
  private com.alipay.b.b.a b = com.alipay.b.b.a.a();
  private int c = 4;
  
  public a(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public static String a(Context paramContext)
  {
    String str2 = b(paramContext);
    String str1 = str2;
    if (com.alipay.c.a.a.a.a.a(str2)) {
      str1 = h.f(paramContext);
    }
    return str1;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    for (;;)
    {
      try
      {
        String str = i.a(paramString);
        if (!com.alipay.c.a.a.a.a.a(str))
        {
          paramContext = str;
          return paramContext;
        }
        paramContext = g.a(paramContext, paramString);
        i.a(paramString, paramContext);
        boolean bool = com.alipay.c.a.a.a.a.a(paramContext);
        if (!bool) {
          continue;
        }
      }
      catch (Throwable paramContext)
      {
        continue;
      }
      paramContext = "";
    }
  }
  
  private static boolean a()
  {
    boolean bool1 = true;
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    int j = (int)(Math.random() * 24.0D * 60.0D * 60.0D);
    int i = 0;
    if (i < 2) {}
    for (;;)
    {
      try
      {
        Object localObject2 = new String[] { "2016-11-10 2016-11-11", "2016-12-11 2016-12-12" }[i].split(" ");
        if ((localObject2 != null) && (localObject2.length == 2))
        {
          Date localDate = new java/util/Date;
          localDate.<init>();
          Object localObject1 = new java/lang/StringBuilder;
          ((StringBuilder)localObject1).<init>();
          localObject1 = localSimpleDateFormat.parse(localObject2[0] + " 00:00:00");
          Object localObject3 = new java/lang/StringBuilder;
          ((StringBuilder)localObject3).<init>();
          localObject2 = localSimpleDateFormat.parse(localObject2[1] + " 23:59:59");
          localObject3 = Calendar.getInstance();
          ((Calendar)localObject3).setTime((Date)localObject2);
          ((Calendar)localObject3).add(13, j * 1);
          localObject2 = ((Calendar)localObject3).getTime();
          if (localDate.after((Date)localObject1))
          {
            boolean bool2 = localDate.before((Date)localObject2);
            if (bool2) {
              return bool1;
            }
          }
        }
        i++;
      }
      catch (Exception localException) {}
      bool1 = false;
    }
  }
  
  /* Error */
  private boolean a(Map paramMap, String paramString)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 6
    //   3: iconst_1
    //   4: istore 11
    //   6: invokestatic 139	com/alipay/b/a/a:a	()Z
    //   9: ifeq +47 -> 56
    //   12: aload_0
    //   13: getfield 26	com/alipay/b/a/a:a	Landroid/content/Context;
    //   16: aload_2
    //   17: invokestatic 140	com/alipay/b/a/a:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   20: invokestatic 35	com/alipay/c/a/a/a/a:a	(Ljava/lang/String;)Z
    //   23: ifeq +10 -> 33
    //   26: iload 11
    //   28: istore 10
    //   30: iload 10
    //   32: ireturn
    //   33: iload 11
    //   35: istore 10
    //   37: aload_0
    //   38: getfield 26	com/alipay/b/a/a:a	Landroid/content/Context;
    //   41: invokestatic 30	com/alipay/b/a/a:b	(Landroid/content/Context;)Ljava/lang/String;
    //   44: invokestatic 35	com/alipay/c/a/a/a/a:a	(Ljava/lang/String;)Z
    //   47: ifne -17 -> 30
    //   50: iconst_0
    //   51: istore 10
    //   53: goto -23 -> 30
    //   56: invokestatic 144	com/alipay/b/d/e:a	()V
    //   59: aload_0
    //   60: getfield 26	com/alipay/b/a/a:a	Landroid/content/Context;
    //   63: aload_1
    //   64: invokestatic 147	com/alipay/b/d/e:b	(Landroid/content/Context;Ljava/util/Map;)Ljava/lang/String;
    //   67: invokestatic 149	com/alipay/b/f/i:c	()Ljava/lang/String;
    //   70: invokestatic 152	com/alipay/c/a/a/a/a:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   73: ifne +193 -> 266
    //   76: iconst_1
    //   77: istore_3
    //   78: iload 11
    //   80: istore 10
    //   82: iload_3
    //   83: ifne -53 -> 30
    //   86: aload_0
    //   87: getfield 26	com/alipay/b/a/a:a	Landroid/content/Context;
    //   90: invokestatic 153	com/alipay/b/f/h:b	(Landroid/content/Context;)Ljava/lang/String;
    //   93: astore 12
    //   95: aload 12
    //   97: invokestatic 159	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   100: lstore 4
    //   102: invokestatic 164	com/alipay/c/a/a/b/b:a	()Lcom/alipay/c/a/a/b/b;
    //   105: pop
    //   106: invokestatic 167	com/alipay/c/a/a/b/b:o	()Ljava/lang/String;
    //   109: invokestatic 159	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   112: lstore 8
    //   114: lload 8
    //   116: lstore 6
    //   118: iconst_0
    //   119: istore_3
    //   120: iload 11
    //   122: istore 10
    //   124: lload 6
    //   126: lload 4
    //   128: lsub
    //   129: invokestatic 171	java/lang/Math:abs	(J)J
    //   132: ldc2_w 172
    //   135: lcmp
    //   136: ifgt -106 -> 30
    //   139: iload 11
    //   141: istore 10
    //   143: iload_3
    //   144: ifne -114 -> 30
    //   147: aload_1
    //   148: ldc -81
    //   150: ldc 57
    //   152: invokestatic 178	com/alipay/c/a/a/a/a:a	(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   155: astore 12
    //   157: aload_1
    //   158: ldc -76
    //   160: ldc 57
    //   162: invokestatic 178	com/alipay/c/a/a/a/a:a	(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   165: astore_1
    //   166: aload 12
    //   168: invokestatic 182	com/alipay/c/a/a/a/a:b	(Ljava/lang/String;)Z
    //   171: ifeq +18 -> 189
    //   174: iload 11
    //   176: istore 10
    //   178: aload 12
    //   180: invokestatic 185	com/alipay/b/f/i:d	()Ljava/lang/String;
    //   183: invokestatic 152	com/alipay/c/a/a/a/a:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   186: ifeq -156 -> 30
    //   189: aload_1
    //   190: invokestatic 182	com/alipay/c/a/a/a/a:b	(Ljava/lang/String;)Z
    //   193: ifeq +17 -> 210
    //   196: iload 11
    //   198: istore 10
    //   200: aload_1
    //   201: invokestatic 188	com/alipay/b/f/i:e	()Ljava/lang/String;
    //   204: invokestatic 152	com/alipay/c/a/a/a/a:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   207: ifeq -177 -> 30
    //   210: iload 11
    //   212: istore 10
    //   214: aload_0
    //   215: getfield 26	com/alipay/b/a/a:a	Landroid/content/Context;
    //   218: aload_2
    //   219: invokestatic 191	com/alipay/b/f/i:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   222: ifeq -192 -> 30
    //   225: iload 11
    //   227: istore 10
    //   229: aload_0
    //   230: getfield 26	com/alipay/b/a/a:a	Landroid/content/Context;
    //   233: aload_2
    //   234: invokestatic 140	com/alipay/b/a/a:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   237: invokestatic 35	com/alipay/c/a/a/a/a:a	(Ljava/lang/String;)Z
    //   240: ifne -210 -> 30
    //   243: iload 11
    //   245: istore 10
    //   247: aload_0
    //   248: getfield 26	com/alipay/b/a/a:a	Landroid/content/Context;
    //   251: invokestatic 30	com/alipay/b/a/a:b	(Landroid/content/Context;)Ljava/lang/String;
    //   254: invokestatic 35	com/alipay/c/a/a/a/a:a	(Ljava/lang/String;)Z
    //   257: ifne -227 -> 30
    //   260: iconst_0
    //   261: istore 10
    //   263: goto -233 -> 30
    //   266: iconst_0
    //   267: istore_3
    //   268: goto -190 -> 78
    //   271: astore 12
    //   273: lconst_0
    //   274: lstore 4
    //   276: iconst_1
    //   277: istore_3
    //   278: goto -158 -> 120
    //   281: astore 12
    //   283: goto -7 -> 276
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	286	0	this	a
    //   0	286	1	paramMap	Map
    //   0	286	2	paramString	String
    //   77	201	3	i	int
    //   100	175	4	l1	long
    //   1	124	6	l2	long
    //   112	3	8	l3	long
    //   28	234	10	bool1	boolean
    //   4	240	11	bool2	boolean
    //   93	86	12	str	String
    //   271	1	12	localThrowable1	Throwable
    //   281	1	12	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   95	102	271	java/lang/Throwable
    //   102	114	281	java/lang/Throwable
  }
  
  private com.alipay.c.a.a.c.a.c b(Map paramMap)
  {
    for (;;)
    {
      try
      {
        Context localContext = this.a;
        locald = new com/alipay/c/a/a/c/a/d;
        locald.<init>();
        Object localObject2 = a(localContext, com.alipay.c.a.a.a.a.a(paramMap, "appName", ""));
        Object localObject1 = com.alipay.b.e.a.a();
        localObject3 = h.e(localContext);
        locald.c((String)localObject2);
        locald.d((String)localObject1);
        locald.e((String)localObject3);
        locald.a("android");
        Object localObject5 = "";
        localObject1 = "";
        localObject2 = "";
        Object localObject6 = "";
        localObject3 = com.alipay.b.f.d.c(localContext);
        if (localObject3 != null)
        {
          localObject1 = ((com.alipay.b.f.c)localObject3).a();
          localObject2 = ((com.alipay.b.f.c)localObject3).c();
        }
        localObject4 = localObject2;
        localObject3 = localObject1;
        if (com.alipay.c.a.a.a.a.a((String)localObject1))
        {
          localObject7 = com.alipay.b.f.a.c(localContext);
          localObject4 = localObject2;
          localObject3 = localObject1;
          if (localObject7 != null)
          {
            localObject3 = ((com.alipay.b.f.b)localObject7).a();
            localObject4 = ((com.alipay.b.f.b)localObject7).c();
          }
        }
        Object localObject7 = com.alipay.b.f.d.b();
        localObject1 = localObject6;
        localObject2 = localObject5;
        if (localObject7 != null)
        {
          localObject2 = ((com.alipay.b.f.c)localObject7).a();
          localObject1 = ((com.alipay.b.f.c)localObject7).c();
        }
        localObject6 = localObject1;
        localObject5 = localObject2;
        if (com.alipay.c.a.a.a.a.a((String)localObject2))
        {
          localObject7 = com.alipay.b.f.a.b();
          localObject6 = localObject1;
          localObject5 = localObject2;
          if (localObject7 != null)
          {
            localObject5 = ((com.alipay.b.f.b)localObject7).a();
            localObject6 = ((com.alipay.b.f.b)localObject7).c();
          }
        }
        locald.g((String)localObject3);
        locald.f((String)localObject5);
        if (!com.alipay.c.a.a.a.a.a((String)localObject3)) {
          continue;
        }
        locald.b((String)localObject5);
        locald.h((String)localObject6);
        locald.a(e.a(localContext, paramMap));
        paramMap = com.alipay.c.a.a.c.d.a(this.a, this.b.d()).a(locald);
      }
      catch (Throwable paramMap)
      {
        com.alipay.c.a.a.c.a.d locald;
        Object localObject3;
        Object localObject4;
        com.alipay.b.c.a.a(paramMap);
        paramMap = null;
        continue;
      }
      return paramMap;
      locald.b((String)localObject3);
      locald.h((String)localObject4);
    }
  }
  
  private static String b(Context paramContext)
  {
    for (;;)
    {
      try
      {
        localObject = i.b();
        if (!com.alipay.c.a.a.a.a.a((String)localObject)) {
          return (String)localObject;
        }
        localObject = com.alipay.b.f.d.b(paramContext);
        if (localObject != null)
        {
          i.a((com.alipay.b.f.c)localObject);
          String str = ((com.alipay.b.f.c)localObject).a();
          localObject = str;
          if (com.alipay.c.a.a.a.a.b(str)) {
            continue;
          }
        }
        paramContext = com.alipay.b.f.a.b(paramContext);
        if (paramContext != null)
        {
          i.a(paramContext);
          localObject = paramContext.a();
          boolean bool = com.alipay.c.a.a.a.a.b((String)localObject);
          if (bool) {
            continue;
          }
        }
      }
      catch (Throwable paramContext)
      {
        Object localObject;
        continue;
      }
      localObject = "";
    }
  }
  
  public final int a(Map paramMap)
  {
    j = 2;
    for (;;)
    {
      try
      {
        com.alipay.b.c.a.a(this.a, com.alipay.c.a.a.a.a.a(paramMap, "tid", ""), com.alipay.c.a.a.a.a.a(paramMap, "utdid", ""), a(this.a));
        localObject2 = com.alipay.c.a.a.a.a.a(paramMap, "appName", "");
        b(this.a);
        a(this.a, (String)localObject2);
        i.a();
        boolean bool = a(paramMap, (String)localObject2);
        localObject1 = this.a;
        com.alipay.c.a.a.b.b.a();
        h.b((Context)localObject1, String.valueOf(com.alipay.c.a.a.b.b.o()));
        if (bool) {
          continue;
        }
        i = 0;
        this.c = i;
        localObject1 = com.alipay.c.a.a.c.d.a(this.a, this.b.d());
        localObject2 = this.a;
        paramMap = (ConnectivityManager)((Context)localObject2).getSystemService("connectivity");
        if (paramMap == null) {
          continue;
        }
        paramMap = paramMap.getActiveNetworkInfo();
      }
      catch (Exception paramMap)
      {
        Object localObject2;
        com.alipay.c.a.a.c.a.c localc;
        com.alipay.b.c.a.a(paramMap);
        continue;
        int i = j;
        if (!"APPKEY_ERROR".equals(localc.b)) {
          continue;
        }
        i = 3;
        continue;
        h.a(this.a, "1".equals(localc.e));
        Context localContext = this.a;
        if (localc.f != null) {
          continue;
        }
        Object localObject1 = "0";
        h.d(localContext, (String)localObject1);
        h.e(this.a, localc.g);
        h.a(this.a, localc.h);
        h.f(this.a, localc.i);
        i.c(e.b(this.a, paramMap));
        i.a((String)localObject2, localc.d);
        i.b(localc.c);
        i.d(localc.j);
        localObject1 = com.alipay.c.a.a.a.a.a(paramMap, "tid", "");
        if ((!com.alipay.c.a.a.a.a.b((String)localObject1)) || (com.alipay.c.a.a.a.a.a((String)localObject1, i.d()))) {
          continue;
        }
        i.e((String)localObject1);
        i.e((String)localObject1);
        paramMap = com.alipay.c.a.a.a.a.a(paramMap, "utdid", "");
        if ((!com.alipay.c.a.a.a.a.b(paramMap)) || (com.alipay.c.a.a.a.a.a(paramMap, i.e()))) {
          continue;
        }
        i.f(paramMap);
        i.f(paramMap);
        i.a();
        paramMap = i.g();
        com.alipay.b.f.d.a(this.a, paramMap);
        com.alipay.b.f.d.a();
        paramMap = this.a;
        localObject1 = new com/alipay/b/f/b;
        ((com.alipay.b.f.b)localObject1).<init>(i.b(), i.c(), i.f());
        com.alipay.b.f.a.a(paramMap, (com.alipay.b.f.b)localObject1);
        com.alipay.b.f.a.a();
        paramMap = i.a((String)localObject2);
        g.a(this.a, (String)localObject2, paramMap);
        g.a();
        h.a(this.a, (String)localObject2, System.currentTimeMillis());
        i = 0;
        continue;
        localObject1 = localc.f;
        continue;
        localObject1 = i.d();
        continue;
        paramMap = i.e();
        continue;
        i = 1;
        continue;
        com.alipay.b.c.a.a("Server error, returned null");
        continue;
        i = 0;
        continue;
        paramMap = null;
        continue;
      }
      if ((paramMap == null) || (!paramMap.isConnected()) || (paramMap.getType() != 1)) {
        continue;
      }
      i = 1;
      if ((i != 0) && (h.d((Context)localObject2)))
      {
        paramMap = new java/lang/StringBuilder;
        paramMap.<init>();
        paramMap = ((Context)localObject2).getFilesDir().getAbsolutePath() + "/log/ap";
        localObject2 = new com/alipay/c/a/a/e/b;
        ((com.alipay.c.a.a.e.b)localObject2).<init>(paramMap, (com.alipay.c.a.a.c.b.a)localObject1);
        ((com.alipay.c.a.a.e.b)localObject2).a();
      }
      return this.c;
      new com.alipay.b.c.b();
      com.alipay.b.b.a.a().b();
      com.alipay.b.e.a.b();
      localc = b(paramMap);
      i = j;
      if (localc != null)
      {
        if (!localc.a) {
          continue;
        }
        i = j;
        if (!com.alipay.c.a.a.a.a.a(localc.c)) {
          i = 1;
        }
      }
      switch (i)
      {
      case 2: 
      default: 
        if (localc == null) {
          continue;
        }
        paramMap = new java/lang/StringBuilder;
        paramMap.<init>("Server error, result:");
        com.alipay.b.c.a.a(localc.b);
        if (!com.alipay.c.a.a.a.a.a(a(this.a, (String)localObject2))) {
          continue;
        }
        i = 4;
        a(this.a, (String)localObject2);
        h.f(this.a);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/b/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */