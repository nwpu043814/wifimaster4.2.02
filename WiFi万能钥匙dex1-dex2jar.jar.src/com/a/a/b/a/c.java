package com.a.a.b.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import com.a.a.a.a.e;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class c
{
  private String a;
  private String b;
  private boolean c;
  private boolean d;
  private boolean e;
  private SharedPreferences f;
  private b g;
  private SharedPreferences.Editor h;
  private b.a i;
  private Context j;
  private d k;
  private boolean l;
  
  /* Error */
  public c(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 12
    //   3: aload_0
    //   4: invokespecial 31	java/lang/Object:<init>	()V
    //   7: aload_0
    //   8: ldc 33
    //   10: putfield 35	com/a/a/b/a/c:a	Ljava/lang/String;
    //   13: aload_0
    //   14: ldc 33
    //   16: putfield 37	com/a/a/b/a/c:b	Ljava/lang/String;
    //   19: aload_0
    //   20: iconst_0
    //   21: putfield 39	com/a/a/b/a/c:c	Z
    //   24: aload_0
    //   25: iconst_0
    //   26: putfield 41	com/a/a/b/a/c:d	Z
    //   29: aload_0
    //   30: iconst_0
    //   31: putfield 43	com/a/a/b/a/c:e	Z
    //   34: aload_0
    //   35: aconst_null
    //   36: putfield 45	com/a/a/b/a/c:f	Landroid/content/SharedPreferences;
    //   39: aload_0
    //   40: aconst_null
    //   41: putfield 47	com/a/a/b/a/c:g	Lcom/a/a/b/a/b;
    //   44: aload_0
    //   45: aconst_null
    //   46: putfield 49	com/a/a/b/a/c:h	Landroid/content/SharedPreferences$Editor;
    //   49: aload_0
    //   50: aconst_null
    //   51: putfield 51	com/a/a/b/a/c:i	Lcom/a/a/b/a/b$a;
    //   54: aload_0
    //   55: aconst_null
    //   56: putfield 53	com/a/a/b/a/c:j	Landroid/content/Context;
    //   59: aload_0
    //   60: aconst_null
    //   61: putfield 55	com/a/a/b/a/c:k	Lcom/a/a/b/a/d;
    //   64: aload_0
    //   65: iconst_0
    //   66: putfield 57	com/a/a/b/a/c:l	Z
    //   69: aload_0
    //   70: iconst_0
    //   71: putfield 39	com/a/a/b/a/c:c	Z
    //   74: aload_0
    //   75: iconst_1
    //   76: putfield 57	com/a/a/b/a/c:l	Z
    //   79: aload_0
    //   80: aload_3
    //   81: putfield 35	com/a/a/b/a/c:a	Ljava/lang/String;
    //   84: aload_0
    //   85: aload_2
    //   86: putfield 37	com/a/a/b/a/c:b	Ljava/lang/String;
    //   89: aload_0
    //   90: aload_1
    //   91: putfield 53	com/a/a/b/a/c:j	Landroid/content/Context;
    //   94: aload_1
    //   95: ifnull +647 -> 742
    //   98: aload_0
    //   99: aload_1
    //   100: aload_3
    //   101: iconst_0
    //   102: invokevirtual 63	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   105: putfield 45	com/a/a/b/a/c:f	Landroid/content/SharedPreferences;
    //   108: aload_0
    //   109: getfield 45	com/a/a/b/a/c:f	Landroid/content/SharedPreferences;
    //   112: ldc 65
    //   114: lconst_0
    //   115: invokeinterface 71 4 0
    //   120: lstore 4
    //   122: invokestatic 77	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   125: astore 13
    //   127: aload 13
    //   129: astore 12
    //   131: aload 12
    //   133: invokestatic 82	com/a/a/a/a/e:a	(Ljava/lang/String;)Z
    //   136: ifne +325 -> 461
    //   139: aload 12
    //   141: ldc 84
    //   143: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   146: ifeq +292 -> 438
    //   149: aload_0
    //   150: iconst_1
    //   151: putfield 43	com/a/a/b/a/c:e	Z
    //   154: aload_0
    //   155: iconst_1
    //   156: putfield 41	com/a/a/b/a/c:d	Z
    //   159: aload_0
    //   160: getfield 41	com/a/a/b/a/c:d	Z
    //   163: ifne +10 -> 173
    //   166: aload_0
    //   167: getfield 43	com/a/a/b/a/c:e	Z
    //   170: ifeq +562 -> 732
    //   173: aload_1
    //   174: ifnull +558 -> 732
    //   177: aload_2
    //   178: invokestatic 82	com/a/a/a/a/e:a	(Ljava/lang/String;)Z
    //   181: ifne +551 -> 732
    //   184: aload_0
    //   185: aload_0
    //   186: aload_2
    //   187: invokespecial 93	com/a/a/b/a/c:c	(Ljava/lang/String;)Lcom/a/a/b/a/d;
    //   190: putfield 55	com/a/a/b/a/c:k	Lcom/a/a/b/a/d;
    //   193: aload_0
    //   194: getfield 55	com/a/a/b/a/c:k	Lcom/a/a/b/a/d;
    //   197: ifnull +535 -> 732
    //   200: aload_0
    //   201: aload_0
    //   202: getfield 55	com/a/a/b/a/c:k	Lcom/a/a/b/a/d;
    //   205: aload_3
    //   206: invokevirtual 98	com/a/a/b/a/d:a	(Ljava/lang/String;)Lcom/a/a/b/a/b;
    //   209: putfield 47	com/a/a/b/a/c:g	Lcom/a/a/b/a/b;
    //   212: aload_0
    //   213: getfield 47	com/a/a/b/a/c:g	Lcom/a/a/b/a/b;
    //   216: ldc 65
    //   218: invokeinterface 103 2 0
    //   223: lstore 6
    //   225: aload_0
    //   226: getfield 45	com/a/a/b/a/c:f	Landroid/content/SharedPreferences;
    //   229: ldc 105
    //   231: lconst_0
    //   232: invokeinterface 71 4 0
    //   237: lstore 8
    //   239: lload 8
    //   241: lstore 4
    //   243: aload_0
    //   244: getfield 47	com/a/a/b/a/c:g	Lcom/a/a/b/a/b;
    //   247: ldc 105
    //   249: invokeinterface 103 2 0
    //   254: lstore 8
    //   256: lload 4
    //   258: lload 8
    //   260: lcmp
    //   261: ifge +213 -> 474
    //   264: lload 4
    //   266: lconst_0
    //   267: lcmp
    //   268: ifle +206 -> 474
    //   271: aload_0
    //   272: getfield 45	com/a/a/b/a/c:f	Landroid/content/SharedPreferences;
    //   275: aload_0
    //   276: getfield 47	com/a/a/b/a/c:g	Lcom/a/a/b/a/b;
    //   279: invokestatic 108	com/a/a/b/a/c:a	(Landroid/content/SharedPreferences;Lcom/a/a/b/a/b;)V
    //   282: aload_0
    //   283: aload_0
    //   284: getfield 55	com/a/a/b/a/c:k	Lcom/a/a/b/a/d;
    //   287: aload_3
    //   288: invokevirtual 98	com/a/a/b/a/d:a	(Ljava/lang/String;)Lcom/a/a/b/a/b;
    //   291: putfield 47	com/a/a/b/a/c:g	Lcom/a/a/b/a/b;
    //   294: lload 4
    //   296: lstore 10
    //   298: lload 8
    //   300: lstore 6
    //   302: lload 10
    //   304: lload 6
    //   306: lcmp
    //   307: ifne +17 -> 324
    //   310: lload 10
    //   312: lconst_0
    //   313: lcmp
    //   314: ifne +113 -> 427
    //   317: lload 6
    //   319: lconst_0
    //   320: lcmp
    //   321: ifne +106 -> 427
    //   324: invokestatic 114	java/lang/System:currentTimeMillis	()J
    //   327: lstore 4
    //   329: aload_0
    //   330: getfield 57	com/a/a/b/a/c:l	Z
    //   333: ifeq +24 -> 357
    //   336: aload_0
    //   337: getfield 57	com/a/a/b/a/c:l	Z
    //   340: ifeq +87 -> 427
    //   343: lload 10
    //   345: lconst_0
    //   346: lcmp
    //   347: ifne +80 -> 427
    //   350: lload 6
    //   352: lconst_0
    //   353: lcmp
    //   354: ifne +73 -> 427
    //   357: aload_0
    //   358: getfield 45	com/a/a/b/a/c:f	Landroid/content/SharedPreferences;
    //   361: ifnull +31 -> 392
    //   364: aload_0
    //   365: getfield 45	com/a/a/b/a/c:f	Landroid/content/SharedPreferences;
    //   368: invokeinterface 118 1 0
    //   373: astore_1
    //   374: aload_1
    //   375: ldc 105
    //   377: lload 4
    //   379: invokeinterface 124 4 0
    //   384: pop
    //   385: aload_1
    //   386: invokeinterface 128 1 0
    //   391: pop
    //   392: aload_0
    //   393: getfield 47	com/a/a/b/a/c:g	Lcom/a/a/b/a/b;
    //   396: ifnull +31 -> 427
    //   399: aload_0
    //   400: getfield 47	com/a/a/b/a/c:g	Lcom/a/a/b/a/b;
    //   403: invokeinterface 131 1 0
    //   408: astore_1
    //   409: aload_1
    //   410: ldc 105
    //   412: lload 4
    //   414: invokeinterface 136 4 0
    //   419: pop
    //   420: aload_1
    //   421: invokeinterface 138 1 0
    //   426: pop
    //   427: return
    //   428: astore 13
    //   430: aload 13
    //   432: invokevirtual 141	java/lang/Exception:printStackTrace	()V
    //   435: goto -304 -> 131
    //   438: aload 12
    //   440: ldc -113
    //   442: invokevirtual 90	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   445: ifeq +16 -> 461
    //   448: aload_0
    //   449: iconst_1
    //   450: putfield 41	com/a/a/b/a/c:d	Z
    //   453: aload_0
    //   454: iconst_0
    //   455: putfield 43	com/a/a/b/a/c:e	Z
    //   458: goto -299 -> 159
    //   461: aload_0
    //   462: iconst_0
    //   463: putfield 43	com/a/a/b/a/c:e	Z
    //   466: aload_0
    //   467: iconst_0
    //   468: putfield 41	com/a/a/b/a/c:d	Z
    //   471: goto -312 -> 159
    //   474: lload 4
    //   476: lload 8
    //   478: lcmp
    //   479: ifle +62 -> 541
    //   482: lload 8
    //   484: lconst_0
    //   485: lcmp
    //   486: ifle +55 -> 541
    //   489: aload_0
    //   490: getfield 47	com/a/a/b/a/c:g	Lcom/a/a/b/a/b;
    //   493: aload_0
    //   494: getfield 45	com/a/a/b/a/c:f	Landroid/content/SharedPreferences;
    //   497: invokestatic 146	com/a/a/b/a/c:a	(Lcom/a/a/b/a/b;Landroid/content/SharedPreferences;)V
    //   500: aload_0
    //   501: aload_1
    //   502: aload_3
    //   503: iconst_0
    //   504: invokevirtual 63	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   507: putfield 45	com/a/a/b/a/c:f	Landroid/content/SharedPreferences;
    //   510: lload 8
    //   512: lstore 6
    //   514: lload 4
    //   516: lstore 10
    //   518: goto -216 -> 302
    //   521: astore_1
    //   522: lload 4
    //   524: lstore 6
    //   526: lload 8
    //   528: lstore 4
    //   530: lload 6
    //   532: lstore 10
    //   534: lload 4
    //   536: lstore 6
    //   538: goto -236 -> 302
    //   541: lload 4
    //   543: lconst_0
    //   544: lcmp
    //   545: ifne +42 -> 587
    //   548: lload 8
    //   550: lconst_0
    //   551: lcmp
    //   552: ifle +35 -> 587
    //   555: aload_0
    //   556: getfield 47	com/a/a/b/a/c:g	Lcom/a/a/b/a/b;
    //   559: aload_0
    //   560: getfield 45	com/a/a/b/a/c:f	Landroid/content/SharedPreferences;
    //   563: invokestatic 146	com/a/a/b/a/c:a	(Lcom/a/a/b/a/b;Landroid/content/SharedPreferences;)V
    //   566: aload_0
    //   567: aload_1
    //   568: aload_3
    //   569: iconst_0
    //   570: invokevirtual 63	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   573: putfield 45	com/a/a/b/a/c:f	Landroid/content/SharedPreferences;
    //   576: lload 8
    //   578: lstore 6
    //   580: lload 4
    //   582: lstore 10
    //   584: goto -282 -> 302
    //   587: lload 8
    //   589: lconst_0
    //   590: lcmp
    //   591: ifne +44 -> 635
    //   594: lload 4
    //   596: lconst_0
    //   597: lcmp
    //   598: ifle +37 -> 635
    //   601: aload_0
    //   602: getfield 45	com/a/a/b/a/c:f	Landroid/content/SharedPreferences;
    //   605: aload_0
    //   606: getfield 47	com/a/a/b/a/c:g	Lcom/a/a/b/a/b;
    //   609: invokestatic 108	com/a/a/b/a/c:a	(Landroid/content/SharedPreferences;Lcom/a/a/b/a/b;)V
    //   612: aload_0
    //   613: aload_0
    //   614: getfield 55	com/a/a/b/a/c:k	Lcom/a/a/b/a/d;
    //   617: aload_3
    //   618: invokevirtual 98	com/a/a/b/a/d:a	(Ljava/lang/String;)Lcom/a/a/b/a/b;
    //   621: putfield 47	com/a/a/b/a/c:g	Lcom/a/a/b/a/b;
    //   624: lload 8
    //   626: lstore 6
    //   628: lload 4
    //   630: lstore 10
    //   632: goto -330 -> 302
    //   635: lload 8
    //   637: lstore 6
    //   639: lload 4
    //   641: lstore 10
    //   643: lload 4
    //   645: lload 8
    //   647: lcmp
    //   648: ifne -346 -> 302
    //   651: aload_0
    //   652: getfield 45	com/a/a/b/a/c:f	Landroid/content/SharedPreferences;
    //   655: aload_0
    //   656: getfield 47	com/a/a/b/a/c:g	Lcom/a/a/b/a/b;
    //   659: invokestatic 108	com/a/a/b/a/c:a	(Landroid/content/SharedPreferences;Lcom/a/a/b/a/b;)V
    //   662: aload_0
    //   663: aload_0
    //   664: getfield 55	com/a/a/b/a/c:k	Lcom/a/a/b/a/d;
    //   667: aload_3
    //   668: invokevirtual 98	com/a/a/b/a/d:a	(Ljava/lang/String;)Lcom/a/a/b/a/b;
    //   671: putfield 47	com/a/a/b/a/c:g	Lcom/a/a/b/a/b;
    //   674: lload 8
    //   676: lstore 6
    //   678: lload 4
    //   680: lstore 10
    //   682: goto -380 -> 302
    //   685: astore_1
    //   686: goto -259 -> 427
    //   689: astore_1
    //   690: lload 4
    //   692: lstore 6
    //   694: lconst_0
    //   695: lstore 4
    //   697: goto -167 -> 530
    //   700: astore_1
    //   701: lload 4
    //   703: lstore 8
    //   705: lload 6
    //   707: lstore 4
    //   709: lload 8
    //   711: lstore 6
    //   713: goto -183 -> 530
    //   716: astore_1
    //   717: lload 6
    //   719: lstore 8
    //   721: lload 4
    //   723: lstore 6
    //   725: lload 8
    //   727: lstore 4
    //   729: goto -199 -> 530
    //   732: lconst_0
    //   733: lstore 6
    //   735: lload 4
    //   737: lstore 10
    //   739: goto -437 -> 302
    //   742: lconst_0
    //   743: lstore 4
    //   745: goto -623 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	748	0	this	c
    //   0	748	1	paramContext	Context
    //   0	748	2	paramString1	String
    //   0	748	3	paramString2	String
    //   120	624	4	l1	long
    //   223	511	6	l2	long
    //   237	489	8	l3	long
    //   296	442	10	l4	long
    //   1	438	12	localObject	Object
    //   125	3	13	str	String
    //   428	3	13	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   122	127	428	java/lang/Exception
    //   271	294	521	java/lang/Exception
    //   489	510	521	java/lang/Exception
    //   555	576	521	java/lang/Exception
    //   601	624	521	java/lang/Exception
    //   651	674	521	java/lang/Exception
    //   392	427	685	java/lang/Exception
    //   200	225	689	java/lang/Exception
    //   225	239	700	java/lang/Exception
    //   243	256	716	java/lang/Exception
  }
  
  private static void a(SharedPreferences paramSharedPreferences, b paramb)
  {
    if ((paramSharedPreferences != null) && (paramb != null))
    {
      paramb = paramb.c();
      paramb.a();
      paramSharedPreferences = paramSharedPreferences.getAll().entrySet().iterator();
    }
    for (;;)
    {
      if (!paramSharedPreferences.hasNext())
      {
        paramb.b();
        return;
      }
      Object localObject = (Map.Entry)paramSharedPreferences.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = ((Map.Entry)localObject).getValue();
      if ((localObject instanceof String)) {
        paramb.a(str, (String)localObject);
      } else if ((localObject instanceof Integer)) {
        paramb.a(str, ((Integer)localObject).intValue());
      } else if ((localObject instanceof Long)) {
        paramb.a(str, ((Long)localObject).longValue());
      } else if ((localObject instanceof Float)) {
        paramb.a(str, ((Float)localObject).floatValue());
      } else if ((localObject instanceof Boolean)) {
        paramb.a(str, ((Boolean)localObject).booleanValue());
      }
    }
  }
  
  private static void a(b paramb, SharedPreferences paramSharedPreferences)
  {
    Iterator localIterator;
    if ((paramb != null) && (paramSharedPreferences != null))
    {
      paramSharedPreferences = paramSharedPreferences.edit();
      if (paramSharedPreferences != null)
      {
        paramSharedPreferences.clear();
        localIterator = paramb.b().entrySet().iterator();
      }
    }
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        paramSharedPreferences.commit();
        return;
      }
      Object localObject = (Map.Entry)localIterator.next();
      paramb = (String)((Map.Entry)localObject).getKey();
      localObject = ((Map.Entry)localObject).getValue();
      if ((localObject instanceof String)) {
        paramSharedPreferences.putString(paramb, (String)localObject);
      } else if ((localObject instanceof Integer)) {
        paramSharedPreferences.putInt(paramb, ((Integer)localObject).intValue());
      } else if ((localObject instanceof Long)) {
        paramSharedPreferences.putLong(paramb, ((Long)localObject).longValue());
      } else if ((localObject instanceof Float)) {
        paramSharedPreferences.putFloat(paramb, ((Float)localObject).floatValue());
      } else if ((localObject instanceof Boolean)) {
        paramSharedPreferences.putBoolean(paramb, ((Boolean)localObject).booleanValue());
      }
    }
  }
  
  private boolean b()
  {
    boolean bool2;
    if (this.g != null)
    {
      bool2 = this.g.a();
      bool1 = bool2;
      if (!bool2) {
        a();
      }
    }
    for (boolean bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  private d c(String paramString)
  {
    d locald = null;
    File localFile = Environment.getExternalStorageDirectory();
    if (localFile != null)
    {
      localFile = new File(String.format("%s%s%s", new Object[] { localFile.getAbsolutePath(), File.separator, paramString }));
      paramString = localFile;
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
    }
    for (paramString = localFile;; paramString = null)
    {
      if (paramString != null)
      {
        this.k = new d(paramString.getAbsolutePath());
        locald = this.k;
      }
      return locald;
    }
  }
  
  private void c()
  {
    if ((this.h == null) && (this.f != null)) {
      this.h = this.f.edit();
    }
    if ((this.e) && (this.i == null) && (this.g != null)) {
      this.i = this.g.c();
    }
    b();
  }
  
  public final void a(String paramString)
  {
    if ((!e.a(paramString)) && (!paramString.equals("t")))
    {
      c();
      if (this.h != null) {
        this.h.remove(paramString);
      }
      if (this.i != null) {
        this.i.a(paramString);
      }
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if ((!e.a(paramString1)) && (!paramString1.equals("t")))
    {
      c();
      if (this.h != null) {
        this.h.putString(paramString1, paramString2);
      }
      if (this.i != null) {
        this.i.a(paramString1, paramString2);
      }
    }
  }
  
  public final boolean a()
  {
    bool2 = true;
    long l1 = System.currentTimeMillis();
    bool1 = bool2;
    if (this.h != null)
    {
      if ((!this.l) && (this.f != null)) {
        this.h.putLong("t", l1);
      }
      bool1 = bool2;
      if (!this.h.commit()) {
        bool1 = false;
      }
    }
    if ((this.f != null) && (this.j != null)) {
      this.f = this.j.getSharedPreferences(this.a, 0);
    }
    Object localObject1 = null;
    try
    {
      localObject2 = Environment.getExternalStorageState();
      localObject1 = localObject2;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        Object localObject2;
        localException2.printStackTrace();
        continue;
        a(this.g, this.f);
        continue;
        bool2 = bool1;
        if (this.i != null)
        {
          bool2 = bool1;
          if (!this.i.b()) {
            bool2 = false;
          }
        }
      }
    }
    bool3 = bool1;
    if (!e.a((String)localObject1))
    {
      bool2 = bool1;
      if (((String)localObject1).equals("mounted"))
      {
        if (this.g != null) {
          break label277;
        }
        localObject2 = c(this.b);
        bool2 = bool1;
        if (localObject2 != null)
        {
          this.g = ((d)localObject2).a(this.a);
          if (this.l) {
            break label263;
          }
          a(this.f, this.g);
          this.i = this.g.c();
          bool2 = bool1;
        }
      }
      if (!((String)localObject1).equals("mounted"))
      {
        bool3 = bool2;
        if (((String)localObject1).equals("mounted_ro"))
        {
          bool3 = bool2;
          if (this.g == null) {}
        }
      }
      else
      {
        bool3 = bool2;
      }
    }
    try
    {
      if (this.k != null)
      {
        this.g = this.k.a(this.a);
        bool3 = bool2;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        bool3 = bool2;
      }
    }
    return bool3;
  }
  
  public final String b(String paramString)
  {
    b();
    if (this.f != null)
    {
      String str = this.f.getString(paramString, "");
      if (!e.a(str)) {
        paramString = str;
      }
    }
    for (;;)
    {
      return paramString;
      if (this.g != null) {
        paramString = this.g.a(paramString, "");
      } else {
        paramString = "";
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/a/a/b/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */