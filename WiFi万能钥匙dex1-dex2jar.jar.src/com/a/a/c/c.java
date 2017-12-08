package com.a.a.c;

import android.content.Context;
import android.provider.Settings.System;
import com.a.a.a.a.b;
import com.a.a.a.a.e;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class c
{
  private static final Object b = new Object();
  private static c c = null;
  private static final String j = ".UTSystemConfig" + File.separator + "Global";
  private Context a = null;
  private String d = null;
  private d e = null;
  private String f = "xx_utdid_key";
  private String g = "xx_utdid_domain";
  private com.a.a.b.a.c h = null;
  private com.a.a.b.a.c i = null;
  private Pattern k = Pattern.compile("[^0-9a-zA-Z=/+]+");
  
  private c(Context paramContext)
  {
    this.a = paramContext;
    this.i = new com.a.a.b.a.c(paramContext, j, "Alvin2");
    this.h = new com.a.a.b.a.c(paramContext, ".DataStorage", "ContextData");
    this.e = new d();
    this.f = String.format("K_%d", new Object[] { Integer.valueOf(e.b(this.f)) });
    this.g = String.format("D_%d", new Object[] { Integer.valueOf(e.b(this.g)) });
  }
  
  public static c a(Context paramContext)
  {
    int n = 1;
    if ((paramContext != null) && (c == null)) {}
    label198:
    for (;;)
    {
      synchronized (b)
      {
        if (c == null)
        {
          c localc = new com/a/a/c/c;
          localc.<init>(paramContext);
          c = localc;
          if (localc.i != null)
          {
            if (e.a(localc.i.b("UTDID2")))
            {
              paramContext = localc.i.b("UTDID");
              if (!e.a(paramContext)) {
                localc.a(paramContext);
              }
            }
            int m = 0;
            if (!e.a(localc.i.b("DID")))
            {
              localc.i.a("DID");
              m = 1;
            }
            if (!e.a(localc.i.b("EI")))
            {
              localc.i.a("EI");
              m = 1;
            }
            if (e.a(localc.i.b("SI"))) {
              break label198;
            }
            localc.i.a("SI");
            m = n;
            if (m != 0) {
              localc.i.a();
            }
          }
        }
        return c;
      }
    }
  }
  
  private void a(String paramString)
  {
    if (e(paramString))
    {
      String str = paramString;
      if (paramString.endsWith("\n")) {
        str = paramString.substring(0, paramString.length() - 1);
      }
      if ((str.length() == 24) && (this.i != null))
      {
        this.i.a("UTDID2", str);
        this.i.a();
      }
    }
  }
  
  private void b(String paramString)
  {
    if ((paramString != null) && (this.h != null) && (!paramString.equals(this.h.b(this.f))))
    {
      this.h.a(this.f, paramString);
      this.h.a();
    }
  }
  
  private final byte[] b()
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int m = (int)(System.currentTimeMillis() / 1000L);
    int n = new Random().nextInt();
    Object localObject2 = com.a.a.a.a.c.a(m);
    Object localObject1 = com.a.a.a.a.c.a(n);
    localByteArrayOutputStream.write((byte[])localObject2, 0, 4);
    localByteArrayOutputStream.write((byte[])localObject1, 0, 4);
    localByteArrayOutputStream.write(3);
    localByteArrayOutputStream.write(0);
    try
    {
      localObject1 = com.a.a.a.a.d.a(this.a);
      localByteArrayOutputStream.write(com.a.a.a.a.c.a(e.b((String)localObject1)), 0, 4);
      localObject1 = localByteArrayOutputStream.toByteArray();
      localObject2 = Mac.getInstance("HmacSHA1");
      ((Mac)localObject2).init(new SecretKeySpec("d6fc3a4a06adbde89223bvefedc24fecde188aaa9161".getBytes(), ((Mac)localObject2).getAlgorithm()));
      localByteArrayOutputStream.write(com.a.a.a.a.c.a(e.b(b.a(((Mac)localObject2).doFinal((byte[])localObject1), 2))));
      return localByteArrayOutputStream.toByteArray();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        String str = new Random().nextInt();
      }
    }
  }
  
  private void c(String paramString)
  {
    String str1;
    if ((this.a.checkCallingOrSelfPermission("android.permission.WRITE_SETTINGS") == 0) && (e(paramString)))
    {
      str1 = paramString;
      if (paramString.endsWith("\n")) {
        str1 = paramString.substring(0, paramString.length() - 1);
      }
      if (24 == str1.length()) {
        paramString = null;
      }
    }
    try
    {
      String str2 = Settings.System.getString(this.a.getContentResolver(), "mqBRboGZkQPcAkyk");
      paramString = str2;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    if (!e(paramString)) {}
    try
    {
      Settings.System.putString(this.a.getContentResolver(), "mqBRboGZkQPcAkyk", str1);
      return;
    }
    catch (Exception paramString)
    {
      for (;;) {}
    }
  }
  
  private void d(String paramString)
  {
    Object localObject;
    if ((this.a.checkCallingOrSelfPermission("android.permission.WRITE_SETTINGS") == 0) && (paramString != null)) {
      localObject = null;
    }
    try
    {
      String str = Settings.System.getString(this.a.getContentResolver(), "dxCRMxhQkdGePGnp");
      localObject = str;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    if (!paramString.equals(localObject)) {}
    try
    {
      Settings.System.putString(this.a.getContentResolver(), "dxCRMxhQkdGePGnp", paramString);
      return;
    }
    catch (Exception paramString)
    {
      for (;;) {}
    }
  }
  
  private boolean e(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      String str = paramString;
      if (paramString.endsWith("\n")) {
        str = paramString.substring(0, paramString.length() - 1);
      }
      bool1 = bool2;
      if (24 == str.length())
      {
        bool1 = bool2;
        if (!this.k.matcher(str).find()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  /* Error */
  public final String a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 61	com/a/a/c/c:d	Ljava/lang/String;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 61	com/a/a/c/c:d	Ljava/lang/String;
    //   13: astore_2
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_2
    //   17: areturn
    //   18: ldc_w 284
    //   21: astore_3
    //   22: aload_0
    //   23: getfield 59	com/a/a/c/c:a	Landroid/content/Context;
    //   26: invokevirtual 259	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   29: ldc_w 261
    //   32: invokestatic 267	android/provider/Settings$System:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   35: astore_2
    //   36: aload_2
    //   37: astore_3
    //   38: aload_3
    //   39: astore_2
    //   40: aload_0
    //   41: aload_3
    //   42: invokespecial 147	com/a/a/c/c:e	(Ljava/lang/String;)Z
    //   45: ifne -31 -> 14
    //   48: new 286	com/a/a/c/e
    //   51: astore 4
    //   53: aload 4
    //   55: invokespecial 287	com/a/a/c/e:<init>	()V
    //   58: iconst_0
    //   59: istore_1
    //   60: aload_0
    //   61: getfield 59	com/a/a/c/c:a	Landroid/content/Context;
    //   64: invokevirtual 259	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   67: ldc_w 273
    //   70: invokestatic 267	android/provider/Settings$System:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   73: astore_2
    //   74: aload_2
    //   75: invokestatic 131	com/a/a/a/a/e:a	(Ljava/lang/String;)Z
    //   78: ifne +143 -> 221
    //   81: aload 4
    //   83: aload_2
    //   84: invokevirtual 288	com/a/a/c/e:b	(Ljava/lang/String;)Ljava/lang/String;
    //   87: astore_3
    //   88: aload_0
    //   89: aload_3
    //   90: invokespecial 147	com/a/a/c/c:e	(Ljava/lang/String;)Z
    //   93: ifeq +24 -> 117
    //   96: aload_0
    //   97: aload_3
    //   98: invokespecial 290	com/a/a/c/c:c	(Ljava/lang/String;)V
    //   101: aload_3
    //   102: astore_2
    //   103: goto -89 -> 14
    //   106: astore_2
    //   107: aload_0
    //   108: monitorexit
    //   109: aload_2
    //   110: athrow
    //   111: astore_2
    //   112: aconst_null
    //   113: astore_2
    //   114: goto -40 -> 74
    //   117: aload 4
    //   119: aload_2
    //   120: invokevirtual 292	com/a/a/c/e:a	(Ljava/lang/String;)Ljava/lang/String;
    //   123: astore_3
    //   124: aload_0
    //   125: aload_3
    //   126: invokespecial 147	com/a/a/c/c:e	(Ljava/lang/String;)Z
    //   129: ifeq +89 -> 218
    //   132: aload_0
    //   133: getfield 63	com/a/a/c/c:e	Lcom/a/a/c/d;
    //   136: aload_3
    //   137: invokevirtual 293	com/a/a/c/d:a	(Ljava/lang/String;)Ljava/lang/String;
    //   140: astore_3
    //   141: aload_3
    //   142: invokestatic 131	com/a/a/a/a/e:a	(Ljava/lang/String;)Z
    //   145: ifne +73 -> 218
    //   148: aload_0
    //   149: aload_3
    //   150: invokespecial 295	com/a/a/c/c:d	(Ljava/lang/String;)V
    //   153: aload_0
    //   154: getfield 59	com/a/a/c/c:a	Landroid/content/Context;
    //   157: invokevirtual 259	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   160: ldc_w 273
    //   163: invokestatic 267	android/provider/Settings$System:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   166: astore_3
    //   167: aload_3
    //   168: astore_2
    //   169: aload_0
    //   170: getfield 63	com/a/a/c/c:e	Lcom/a/a/c/d;
    //   173: aload_2
    //   174: invokevirtual 296	com/a/a/c/d:b	(Ljava/lang/String;)Ljava/lang/String;
    //   177: astore_3
    //   178: aload_0
    //   179: aload_3
    //   180: invokespecial 147	com/a/a/c/c:e	(Ljava/lang/String;)Z
    //   183: ifeq +40 -> 223
    //   186: aload_0
    //   187: aload_3
    //   188: putfield 61	com/a/a/c/c:d	Ljava/lang/String;
    //   191: aload_0
    //   192: aload_3
    //   193: invokespecial 135	com/a/a/c/c:a	(Ljava/lang/String;)V
    //   196: aload_0
    //   197: aload_2
    //   198: invokespecial 298	com/a/a/c/c:b	(Ljava/lang/String;)V
    //   201: aload_0
    //   202: aload_0
    //   203: getfield 61	com/a/a/c/c:d	Ljava/lang/String;
    //   206: invokespecial 290	com/a/a/c/c:c	(Ljava/lang/String;)V
    //   209: aload_0
    //   210: getfield 61	com/a/a/c/c:d	Ljava/lang/String;
    //   213: astore_2
    //   214: goto -200 -> 14
    //   217: astore_3
    //   218: goto -49 -> 169
    //   221: iconst_1
    //   222: istore_1
    //   223: aload_0
    //   224: getfield 75	com/a/a/c/c:i	Lcom/a/a/b/a/c;
    //   227: ifnull +75 -> 302
    //   230: aload_0
    //   231: getfield 75	com/a/a/c/c:i	Lcom/a/a/b/a/c;
    //   234: ldc 125
    //   236: invokevirtual 128	com/a/a/b/a/c:b	(Ljava/lang/String;)Ljava/lang/String;
    //   239: astore_2
    //   240: aload_2
    //   241: invokestatic 131	com/a/a/a/a/e:a	(Ljava/lang/String;)Z
    //   244: ifne +58 -> 302
    //   247: aload_0
    //   248: getfield 63	com/a/a/c/c:e	Lcom/a/a/c/d;
    //   251: aload_2
    //   252: invokevirtual 293	com/a/a/c/d:a	(Ljava/lang/String;)Ljava/lang/String;
    //   255: ifnull +47 -> 302
    //   258: aload_0
    //   259: aload_2
    //   260: invokespecial 147	com/a/a/c/c:e	(Ljava/lang/String;)Z
    //   263: ifeq +44 -> 307
    //   266: aload_0
    //   267: getfield 63	com/a/a/c/c:e	Lcom/a/a/c/d;
    //   270: aload_2
    //   271: invokevirtual 293	com/a/a/c/d:a	(Ljava/lang/String;)Ljava/lang/String;
    //   274: astore_3
    //   275: iload_1
    //   276: ifeq +8 -> 284
    //   279: aload_0
    //   280: aload_3
    //   281: invokespecial 295	com/a/a/c/c:d	(Ljava/lang/String;)V
    //   284: aload_0
    //   285: aload_2
    //   286: invokespecial 290	com/a/a/c/c:c	(Ljava/lang/String;)V
    //   289: aload_0
    //   290: aload_3
    //   291: invokespecial 298	com/a/a/c/c:b	(Ljava/lang/String;)V
    //   294: aload_0
    //   295: aload_2
    //   296: putfield 61	com/a/a/c/c:d	Ljava/lang/String;
    //   299: goto -285 -> 14
    //   302: aconst_null
    //   303: astore_2
    //   304: goto -46 -> 258
    //   307: aload_0
    //   308: getfield 73	com/a/a/c/c:h	Lcom/a/a/b/a/c;
    //   311: aload_0
    //   312: getfield 67	com/a/a/c/c:f	Ljava/lang/String;
    //   315: invokevirtual 128	com/a/a/b/a/c:b	(Ljava/lang/String;)Ljava/lang/String;
    //   318: astore 5
    //   320: aload 5
    //   322: invokestatic 131	com/a/a/a/a/e:a	(Ljava/lang/String;)Z
    //   325: ifne +85 -> 410
    //   328: aload 4
    //   330: aload 5
    //   332: invokevirtual 292	com/a/a/c/e:a	(Ljava/lang/String;)Ljava/lang/String;
    //   335: astore_3
    //   336: aload_3
    //   337: astore_2
    //   338: aload_0
    //   339: aload_3
    //   340: invokespecial 147	com/a/a/c/c:e	(Ljava/lang/String;)Z
    //   343: ifne +13 -> 356
    //   346: aload_0
    //   347: getfield 63	com/a/a/c/c:e	Lcom/a/a/c/d;
    //   350: aload 5
    //   352: invokevirtual 296	com/a/a/c/d:b	(Ljava/lang/String;)Ljava/lang/String;
    //   355: astore_2
    //   356: aload_0
    //   357: aload_2
    //   358: invokespecial 147	com/a/a/c/c:e	(Ljava/lang/String;)Z
    //   361: ifeq +49 -> 410
    //   364: aload_0
    //   365: getfield 63	com/a/a/c/c:e	Lcom/a/a/c/d;
    //   368: aload_2
    //   369: invokevirtual 293	com/a/a/c/d:a	(Ljava/lang/String;)Ljava/lang/String;
    //   372: astore_3
    //   373: aload_2
    //   374: invokestatic 131	com/a/a/a/a/e:a	(Ljava/lang/String;)Z
    //   377: ifne +33 -> 410
    //   380: aload_0
    //   381: aload_2
    //   382: putfield 61	com/a/a/c/c:d	Ljava/lang/String;
    //   385: iload_1
    //   386: ifeq +8 -> 394
    //   389: aload_0
    //   390: aload_3
    //   391: invokespecial 295	com/a/a/c/c:d	(Ljava/lang/String;)V
    //   394: aload_0
    //   395: aload_0
    //   396: getfield 61	com/a/a/c/c:d	Ljava/lang/String;
    //   399: invokespecial 135	com/a/a/c/c:a	(Ljava/lang/String;)V
    //   402: aload_0
    //   403: getfield 61	com/a/a/c/c:d	Ljava/lang/String;
    //   406: astore_2
    //   407: goto -393 -> 14
    //   410: aload_0
    //   411: invokespecial 300	com/a/a/c/c:b	()[B
    //   414: astore_2
    //   415: aload_2
    //   416: ifnull +60 -> 476
    //   419: aload_0
    //   420: aload_2
    //   421: iconst_2
    //   422: invokestatic 241	com/a/a/a/a/b:a	([BI)Ljava/lang/String;
    //   425: putfield 61	com/a/a/c/c:d	Ljava/lang/String;
    //   428: aload_0
    //   429: aload_0
    //   430: getfield 61	com/a/a/c/c:d	Ljava/lang/String;
    //   433: invokespecial 135	com/a/a/c/c:a	(Ljava/lang/String;)V
    //   436: aload_0
    //   437: getfield 63	com/a/a/c/c:e	Lcom/a/a/c/d;
    //   440: aload_2
    //   441: invokevirtual 303	com/a/a/c/d:a	([B)Ljava/lang/String;
    //   444: astore_2
    //   445: aload_2
    //   446: ifnull +17 -> 463
    //   449: iload_1
    //   450: ifeq +8 -> 458
    //   453: aload_0
    //   454: aload_2
    //   455: invokespecial 295	com/a/a/c/c:d	(Ljava/lang/String;)V
    //   458: aload_0
    //   459: aload_2
    //   460: invokespecial 298	com/a/a/c/c:b	(Ljava/lang/String;)V
    //   463: aload_0
    //   464: getfield 61	com/a/a/c/c:d	Ljava/lang/String;
    //   467: astore_2
    //   468: goto -454 -> 14
    //   471: astore_2
    //   472: aload_2
    //   473: invokevirtual 306	java/lang/Exception:printStackTrace	()V
    //   476: aconst_null
    //   477: astore_2
    //   478: goto -464 -> 14
    //   481: astore_2
    //   482: goto -444 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	485	0	this	c
    //   59	391	1	m	int
    //   13	90	2	localObject1	Object
    //   106	4	2	localObject2	Object
    //   111	1	2	localException1	Exception
    //   113	355	2	localObject3	Object
    //   471	2	2	localException2	Exception
    //   477	1	2	localObject4	Object
    //   481	1	2	localException3	Exception
    //   21	172	3	localObject5	Object
    //   217	1	3	localException4	Exception
    //   274	117	3	str1	String
    //   51	278	4	locale	e
    //   318	33	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   2	14	106	finally
    //   22	36	106	finally
    //   40	58	106	finally
    //   60	74	106	finally
    //   74	101	106	finally
    //   117	153	106	finally
    //   153	167	106	finally
    //   169	178	106	finally
    //   178	214	106	finally
    //   223	258	106	finally
    //   258	275	106	finally
    //   279	284	106	finally
    //   284	299	106	finally
    //   307	336	106	finally
    //   338	356	106	finally
    //   356	385	106	finally
    //   389	394	106	finally
    //   394	407	106	finally
    //   410	415	106	finally
    //   419	445	106	finally
    //   453	458	106	finally
    //   458	463	106	finally
    //   463	468	106	finally
    //   472	476	106	finally
    //   60	74	111	java/lang/Exception
    //   153	167	217	java/lang/Exception
    //   410	415	471	java/lang/Exception
    //   419	445	471	java/lang/Exception
    //   453	458	471	java/lang/Exception
    //   458	463	471	java/lang/Exception
    //   463	468	471	java/lang/Exception
    //   22	36	481	java/lang/Exception
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/a/a/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */