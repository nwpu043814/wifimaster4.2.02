package com.lantern.settings.diagnose;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class d
{
  private static d e;
  private e a = null;
  private SQLiteDatabase b;
  private Context c;
  private Lock d;
  
  private d(Context paramContext)
  {
    this.c = paramContext;
    this.a = e.a(paramContext);
    this.d = new ReentrantLock();
  }
  
  public static final d a(Context paramContext)
  {
    if (e == null) {
      e = new d(paramContext.getApplicationContext());
    }
    return e;
  }
  
  /* Error */
  public final java.util.List<c> a()
  {
    // Byte code:
    //   0: new 50	java/util/ArrayList
    //   3: astore_2
    //   4: aload_2
    //   5: invokespecial 51	java/util/ArrayList:<init>	()V
    //   8: aload_0
    //   9: getfield 21	com/lantern/settings/diagnose/d:a	Lcom/lantern/settings/diagnose/e;
    //   12: ifnonnull +21 -> 33
    //   15: aload_0
    //   16: getfield 23	com/lantern/settings/diagnose/d:c	Landroid/content/Context;
    //   19: ifnull +14 -> 33
    //   22: aload_0
    //   23: aload_0
    //   24: getfield 23	com/lantern/settings/diagnose/d:c	Landroid/content/Context;
    //   27: invokestatic 28	com/lantern/settings/diagnose/e:a	(Landroid/content/Context;)Lcom/lantern/settings/diagnose/e;
    //   30: putfield 21	com/lantern/settings/diagnose/d:a	Lcom/lantern/settings/diagnose/e;
    //   33: aload_0
    //   34: getfield 33	com/lantern/settings/diagnose/d:d	Ljava/util/concurrent/locks/Lock;
    //   37: invokeinterface 56 1 0
    //   42: aload_0
    //   43: aload_0
    //   44: getfield 21	com/lantern/settings/diagnose/d:a	Lcom/lantern/settings/diagnose/e;
    //   47: invokevirtual 60	com/lantern/settings/diagnose/e:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   50: putfield 62	com/lantern/settings/diagnose/d:b	Landroid/database/sqlite/SQLiteDatabase;
    //   53: aload_0
    //   54: getfield 62	com/lantern/settings/diagnose/d:b	Landroid/database/sqlite/SQLiteDatabase;
    //   57: ldc 64
    //   59: aconst_null
    //   60: invokevirtual 70	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   63: astore 4
    //   65: aload 4
    //   67: invokeinterface 76 1 0
    //   72: astore_3
    //   73: aload 4
    //   75: invokeinterface 80 1 0
    //   80: ifeq +393 -> 473
    //   83: new 82	com/lantern/settings/diagnose/c
    //   86: astore 5
    //   88: aload 5
    //   90: invokespecial 83	com/lantern/settings/diagnose/c:<init>	()V
    //   93: iconst_0
    //   94: istore_1
    //   95: iload_1
    //   96: aload 4
    //   98: invokeinterface 87 1 0
    //   103: if_icmpge +358 -> 461
    //   106: aload_3
    //   107: iload_1
    //   108: aaload
    //   109: ldc 89
    //   111: invokevirtual 95	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   114: ifeq +22 -> 136
    //   117: aload 5
    //   119: aload 4
    //   121: iload_1
    //   122: invokeinterface 99 2 0
    //   127: invokevirtual 102	com/lantern/settings/diagnose/c:b	(Ljava/lang/String;)V
    //   130: iinc 1 1
    //   133: goto -38 -> 95
    //   136: aload_3
    //   137: iload_1
    //   138: aaload
    //   139: ldc 104
    //   141: invokevirtual 95	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   144: ifeq +35 -> 179
    //   147: aload 5
    //   149: aload 4
    //   151: iload_1
    //   152: invokeinterface 108 2 0
    //   157: invokevirtual 111	com/lantern/settings/diagnose/c:a	(J)V
    //   160: goto -30 -> 130
    //   163: astore_3
    //   164: aload_3
    //   165: invokevirtual 114	java/lang/Exception:printStackTrace	()V
    //   168: aload_0
    //   169: getfield 33	com/lantern/settings/diagnose/d:d	Ljava/util/concurrent/locks/Lock;
    //   172: invokeinterface 117 1 0
    //   177: aload_2
    //   178: areturn
    //   179: aload_3
    //   180: iload_1
    //   181: aaload
    //   182: ldc 119
    //   184: invokevirtual 95	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   187: ifeq +31 -> 218
    //   190: aload 5
    //   192: aload 4
    //   194: iload_1
    //   195: invokeinterface 108 2 0
    //   200: invokevirtual 121	com/lantern/settings/diagnose/c:b	(J)V
    //   203: goto -73 -> 130
    //   206: astore_2
    //   207: aload_0
    //   208: getfield 33	com/lantern/settings/diagnose/d:d	Ljava/util/concurrent/locks/Lock;
    //   211: invokeinterface 117 1 0
    //   216: aload_2
    //   217: athrow
    //   218: aload_3
    //   219: iload_1
    //   220: aaload
    //   221: ldc 123
    //   223: invokevirtual 95	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   226: ifeq +19 -> 245
    //   229: aload 5
    //   231: aload 4
    //   233: iload_1
    //   234: invokeinterface 108 2 0
    //   239: invokevirtual 125	com/lantern/settings/diagnose/c:d	(J)V
    //   242: goto -112 -> 130
    //   245: aload_3
    //   246: iload_1
    //   247: aaload
    //   248: ldc 127
    //   250: invokevirtual 95	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   253: ifeq +19 -> 272
    //   256: aload 5
    //   258: aload 4
    //   260: iload_1
    //   261: invokeinterface 108 2 0
    //   266: invokevirtual 129	com/lantern/settings/diagnose/c:c	(J)V
    //   269: goto -139 -> 130
    //   272: aload_3
    //   273: iload_1
    //   274: aaload
    //   275: ldc -125
    //   277: invokevirtual 95	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   280: ifeq +19 -> 299
    //   283: aload 5
    //   285: aload 4
    //   287: iload_1
    //   288: invokeinterface 108 2 0
    //   293: invokevirtual 133	com/lantern/settings/diagnose/c:e	(J)V
    //   296: goto -166 -> 130
    //   299: aload_3
    //   300: iload_1
    //   301: aaload
    //   302: ldc -121
    //   304: invokevirtual 95	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   307: ifeq +19 -> 326
    //   310: aload 5
    //   312: aload 4
    //   314: iload_1
    //   315: invokeinterface 99 2 0
    //   320: invokevirtual 137	com/lantern/settings/diagnose/c:a	(Ljava/lang/String;)V
    //   323: goto -193 -> 130
    //   326: aload_3
    //   327: iload_1
    //   328: aaload
    //   329: ldc -117
    //   331: invokevirtual 95	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   334: ifeq +19 -> 353
    //   337: aload 5
    //   339: aload 4
    //   341: iload_1
    //   342: invokeinterface 143 2 0
    //   347: invokevirtual 146	com/lantern/settings/diagnose/c:a	(I)V
    //   350: goto -220 -> 130
    //   353: aload_3
    //   354: iload_1
    //   355: aaload
    //   356: ldc -108
    //   358: invokevirtual 95	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   361: ifeq +19 -> 380
    //   364: aload 5
    //   366: aload 4
    //   368: iload_1
    //   369: invokeinterface 143 2 0
    //   374: invokevirtual 150	com/lantern/settings/diagnose/c:b	(I)V
    //   377: goto -247 -> 130
    //   380: aload_3
    //   381: iload_1
    //   382: aaload
    //   383: ldc -104
    //   385: invokevirtual 95	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   388: ifeq +19 -> 407
    //   391: aload 5
    //   393: aload 4
    //   395: iload_1
    //   396: invokeinterface 108 2 0
    //   401: invokevirtual 155	com/lantern/settings/diagnose/c:f	(J)V
    //   404: goto -274 -> 130
    //   407: aload_3
    //   408: iload_1
    //   409: aaload
    //   410: ldc -99
    //   412: invokevirtual 95	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   415: ifeq +19 -> 434
    //   418: aload 5
    //   420: aload 4
    //   422: iload_1
    //   423: invokeinterface 143 2 0
    //   428: invokevirtual 159	com/lantern/settings/diagnose/c:c	(I)V
    //   431: goto -301 -> 130
    //   434: aload_3
    //   435: iload_1
    //   436: aaload
    //   437: ldc -95
    //   439: invokevirtual 95	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   442: ifeq -312 -> 130
    //   445: aload 5
    //   447: aload 4
    //   449: iload_1
    //   450: invokeinterface 108 2 0
    //   455: invokevirtual 164	com/lantern/settings/diagnose/c:g	(J)V
    //   458: goto -328 -> 130
    //   461: aload_2
    //   462: aload 5
    //   464: invokeinterface 169 2 0
    //   469: pop
    //   470: goto -397 -> 73
    //   473: aload 4
    //   475: ifnull +20 -> 495
    //   478: aload 4
    //   480: invokeinterface 172 1 0
    //   485: ifne +10 -> 495
    //   488: aload 4
    //   490: invokeinterface 175 1 0
    //   495: aload_0
    //   496: getfield 33	com/lantern/settings/diagnose/d:d	Ljava/util/concurrent/locks/Lock;
    //   499: invokeinterface 117 1 0
    //   504: goto -327 -> 177
    //   507: astore_3
    //   508: aconst_null
    //   509: astore_2
    //   510: goto -346 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	513	0	this	d
    //   94	356	1	i	int
    //   3	175	2	localArrayList	java.util.ArrayList
    //   206	256	2	localObject1	Object
    //   509	1	2	localObject2	Object
    //   72	65	3	arrayOfString	String[]
    //   163	272	3	localException1	Exception
    //   507	1	3	localException2	Exception
    //   63	426	4	localCursor	android.database.Cursor
    //   86	377	5	localc	c
    // Exception table:
    //   from	to	target	type
    //   8	33	163	java/lang/Exception
    //   33	73	163	java/lang/Exception
    //   73	93	163	java/lang/Exception
    //   95	130	163	java/lang/Exception
    //   136	160	163	java/lang/Exception
    //   179	203	163	java/lang/Exception
    //   218	242	163	java/lang/Exception
    //   245	269	163	java/lang/Exception
    //   272	296	163	java/lang/Exception
    //   299	323	163	java/lang/Exception
    //   326	350	163	java/lang/Exception
    //   353	377	163	java/lang/Exception
    //   380	404	163	java/lang/Exception
    //   407	431	163	java/lang/Exception
    //   434	458	163	java/lang/Exception
    //   461	470	163	java/lang/Exception
    //   478	495	163	java/lang/Exception
    //   0	8	206	finally
    //   8	33	206	finally
    //   33	73	206	finally
    //   73	93	206	finally
    //   95	130	206	finally
    //   136	160	206	finally
    //   164	168	206	finally
    //   179	203	206	finally
    //   218	242	206	finally
    //   245	269	206	finally
    //   272	296	206	finally
    //   299	323	206	finally
    //   326	350	206	finally
    //   353	377	206	finally
    //   380	404	206	finally
    //   407	431	206	finally
    //   434	458	206	finally
    //   461	470	206	finally
    //   478	495	206	finally
    //   0	8	507	java/lang/Exception
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/diagnose/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */