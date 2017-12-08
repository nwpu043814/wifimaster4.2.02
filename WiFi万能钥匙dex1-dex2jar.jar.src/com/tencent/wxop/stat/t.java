package com.tencent.wxop.stat;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.wxop.stat.a.d;
import com.tencent.wxop.stat.b.b;
import com.tencent.wxop.stat.b.f;
import com.tencent.wxop.stat.b.l;
import com.tencent.wxop.stat.b.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class t
{
  private static b bZ = ;
  private static Context ca = null;
  private static t cb = null;
  volatile int aI = 0;
  private String ab = "";
  private ac bW = null;
  private ac bX = null;
  com.tencent.wxop.stat.b.c bY = null;
  private f be = null;
  private String bq = "";
  private int cc = 0;
  private ConcurrentHashMap<d, String> cd = null;
  private boolean ce = false;
  private HashMap<String, String> cf = new HashMap();
  
  private t(Context paramContext)
  {
    try
    {
      Object localObject = new com/tencent/wxop/stat/b/f;
      ((f)localObject).<init>();
      this.be = ((f)localObject);
      ca = paramContext.getApplicationContext();
      localObject = new java/util/concurrent/ConcurrentHashMap;
      ((ConcurrentHashMap)localObject).<init>();
      this.cd = ((ConcurrentHashMap)localObject);
      this.ab = l.J(paramContext);
      localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>("pri_");
      this.bq = l.J(paramContext);
      paramContext = new com/tencent/wxop/stat/ac;
      paramContext.<init>(ca, this.ab);
      this.bW = paramContext;
      paramContext = new com/tencent/wxop/stat/ac;
      paramContext.<init>(ca, this.bq);
      this.bX = paramContext;
      b(true);
      b(false);
      aj();
      t(ca);
      I();
      an();
      return;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        bZ.b(paramContext);
      }
    }
  }
  
  /* Error */
  private void I()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 54	com/tencent/wxop/stat/t:bW	Lcom/tencent/wxop/stat/ac;
    //   4: invokevirtual 140	com/tencent/wxop/stat/ac:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   7: ldc -114
    //   9: aconst_null
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: aconst_null
    //   14: aconst_null
    //   15: invokevirtual 148	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   18: astore 4
    //   20: aload 4
    //   22: astore_3
    //   23: aload 4
    //   25: invokeinterface 154 1 0
    //   30: ifeq +166 -> 196
    //   33: aload 4
    //   35: astore_3
    //   36: aload 4
    //   38: iconst_0
    //   39: invokeinterface 158 2 0
    //   44: istore_2
    //   45: aload 4
    //   47: astore_3
    //   48: aload 4
    //   50: iconst_1
    //   51: invokeinterface 162 2 0
    //   56: astore 8
    //   58: aload 4
    //   60: astore_3
    //   61: aload 4
    //   63: iconst_2
    //   64: invokeinterface 162 2 0
    //   69: astore 7
    //   71: aload 4
    //   73: astore_3
    //   74: aload 4
    //   76: iconst_3
    //   77: invokeinterface 158 2 0
    //   82: istore_1
    //   83: aload 4
    //   85: astore_3
    //   86: new 164	com/tencent/wxop/stat/ah
    //   89: astore 5
    //   91: aload 4
    //   93: astore_3
    //   94: aload 5
    //   96: iload_2
    //   97: invokespecial 167	com/tencent/wxop/stat/ah:<init>	(I)V
    //   100: aload 4
    //   102: astore_3
    //   103: aload 5
    //   105: iload_2
    //   106: putfield 168	com/tencent/wxop/stat/ah:aI	I
    //   109: aload 4
    //   111: astore_3
    //   112: new 170	org/json/JSONObject
    //   115: astore 6
    //   117: aload 4
    //   119: astore_3
    //   120: aload 6
    //   122: aload 8
    //   124: invokespecial 171	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   127: aload 4
    //   129: astore_3
    //   130: aload 5
    //   132: aload 6
    //   134: putfield 175	com/tencent/wxop/stat/ah:df	Lorg/json/JSONObject;
    //   137: aload 4
    //   139: astore_3
    //   140: aload 5
    //   142: aload 7
    //   144: putfield 178	com/tencent/wxop/stat/ah:c	Ljava/lang/String;
    //   147: aload 4
    //   149: astore_3
    //   150: aload 5
    //   152: iload_1
    //   153: putfield 181	com/tencent/wxop/stat/ah:L	I
    //   156: aload 4
    //   158: astore_3
    //   159: getstatic 43	com/tencent/wxop/stat/t:ca	Landroid/content/Context;
    //   162: aload 5
    //   164: invokestatic 187	com/tencent/wxop/stat/c:a	(Landroid/content/Context;Lcom/tencent/wxop/stat/ah;)V
    //   167: goto -147 -> 20
    //   170: astore 5
    //   172: aload 4
    //   174: astore_3
    //   175: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   178: aload 5
    //   180: invokevirtual 136	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   183: aload 4
    //   185: ifnull +10 -> 195
    //   188: aload 4
    //   190: invokeinterface 190 1 0
    //   195: return
    //   196: aload 4
    //   198: ifnull -3 -> 195
    //   201: aload 4
    //   203: invokeinterface 190 1 0
    //   208: goto -13 -> 195
    //   211: astore 4
    //   213: aconst_null
    //   214: astore_3
    //   215: aload_3
    //   216: ifnull +9 -> 225
    //   219: aload_3
    //   220: invokeinterface 190 1 0
    //   225: aload 4
    //   227: athrow
    //   228: astore 4
    //   230: goto -15 -> 215
    //   233: astore 5
    //   235: aconst_null
    //   236: astore 4
    //   238: goto -66 -> 172
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	this	t
    //   82	71	1	i	int
    //   44	62	2	j	int
    //   22	198	3	localCursor1	android.database.Cursor
    //   18	184	4	localCursor2	android.database.Cursor
    //   211	15	4	localObject1	Object
    //   228	1	4	localObject2	Object
    //   236	1	4	localObject3	Object
    //   89	74	5	localah	ah
    //   170	9	5	localThrowable1	Throwable
    //   233	1	5	localThrowable2	Throwable
    //   115	18	6	localJSONObject	org.json.JSONObject
    //   69	74	7	str1	String
    //   56	67	8	str2	String
    // Exception table:
    //   from	to	target	type
    //   23	33	170	java/lang/Throwable
    //   36	45	170	java/lang/Throwable
    //   48	58	170	java/lang/Throwable
    //   61	71	170	java/lang/Throwable
    //   74	83	170	java/lang/Throwable
    //   86	91	170	java/lang/Throwable
    //   94	100	170	java/lang/Throwable
    //   103	109	170	java/lang/Throwable
    //   112	117	170	java/lang/Throwable
    //   120	127	170	java/lang/Throwable
    //   130	137	170	java/lang/Throwable
    //   140	147	170	java/lang/Throwable
    //   150	156	170	java/lang/Throwable
    //   159	167	170	java/lang/Throwable
    //   0	20	211	finally
    //   23	33	228	finally
    //   36	45	228	finally
    //   48	58	228	finally
    //   61	71	228	finally
    //   74	83	228	finally
    //   86	91	228	finally
    //   94	100	228	finally
    //   103	109	228	finally
    //   112	117	228	finally
    //   120	127	228	finally
    //   130	137	228	finally
    //   140	147	228	finally
    //   150	156	228	finally
    //   159	167	228	finally
    //   175	183	228	finally
    //   0	20	233	java/lang/Throwable
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if ((this.aI > 0) && (paramInt > 0))
        {
          boolean bool = e.a();
          if (!bool) {
            continue;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject1;
        Object localObject3;
        Object localObject4;
        bZ.b(localThrowable);
        continue;
      }
      finally {}
      return;
      if (c.k())
      {
        localObject1 = bZ;
        localObject3 = new java/lang/StringBuilder;
        ((StringBuilder)localObject3).<init>("Load ");
        ((b)localObject1).b(this.aI + " unsent events");
      }
      localObject1 = new java/util/ArrayList;
      ((ArrayList)localObject1).<init>(paramInt);
      b((List)localObject1, paramInt, paramBoolean);
      if (((List)localObject1).size() > 0)
      {
        if (c.k())
        {
          localObject3 = bZ;
          localObject4 = new java/lang/StringBuilder;
          ((StringBuilder)localObject4).<init>("Peek ");
          ((b)localObject3).b(((List)localObject1).size() + " unsent events.");
        }
        a((List)localObject1, 2, paramBoolean);
        localObject4 = ak.Z(ca);
        localObject3 = new com/tencent/wxop/stat/aa;
        ((aa)localObject3).<init>(this, (List)localObject1, paramBoolean);
        ((ak)localObject4).b((List)localObject1, (aj)localObject3);
      }
    }
  }
  
  /* Error */
  private void a(d paramd, aj paramaj, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 11
    //   6: aload_0
    //   7: monitorenter
    //   8: invokestatic 243	com/tencent/wxop/stat/c:s	()I
    //   11: ifle +432 -> 443
    //   14: getstatic 246	com/tencent/wxop/stat/c:ay	I
    //   17: istore 5
    //   19: iload 5
    //   21: ifle +12 -> 33
    //   24: iload_3
    //   25: ifne +8 -> 33
    //   28: iload 4
    //   30: ifeq +548 -> 578
    //   33: aload_0
    //   34: iload_3
    //   35: invokespecial 249	com/tencent/wxop/stat/t:c	(Z)Landroid/database/sqlite/SQLiteDatabase;
    //   38: astore 12
    //   40: aload 12
    //   42: astore 11
    //   44: aload 12
    //   46: astore 10
    //   48: aload 12
    //   50: invokevirtual 252	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   53: iload_3
    //   54: ifne +71 -> 125
    //   57: aload 12
    //   59: astore 11
    //   61: aload 12
    //   63: astore 10
    //   65: aload_0
    //   66: getfield 66	com/tencent/wxop/stat/t:aI	I
    //   69: invokestatic 243	com/tencent/wxop/stat/c:s	()I
    //   72: if_icmple +53 -> 125
    //   75: aload 12
    //   77: astore 11
    //   79: aload 12
    //   81: astore 10
    //   83: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   86: ldc -2
    //   88: invokevirtual 257	com/tencent/wxop/stat/b/b:warn	(Ljava/lang/Object;)V
    //   91: aload 12
    //   93: astore 11
    //   95: aload 12
    //   97: astore 10
    //   99: aload_0
    //   100: aload_0
    //   101: getfield 66	com/tencent/wxop/stat/t:aI	I
    //   104: aload_0
    //   105: getfield 54	com/tencent/wxop/stat/t:bW	Lcom/tencent/wxop/stat/ac;
    //   108: invokevirtual 260	com/tencent/wxop/stat/ac:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   111: ldc_w 262
    //   114: ldc_w 264
    //   117: aconst_null
    //   118: invokevirtual 268	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   121: isub
    //   122: putfield 66	com/tencent/wxop/stat/t:aI	I
    //   125: aload 12
    //   127: astore 11
    //   129: aload 12
    //   131: astore 10
    //   133: new 270	android/content/ContentValues
    //   136: astore 13
    //   138: aload 12
    //   140: astore 11
    //   142: aload 12
    //   144: astore 10
    //   146: aload 13
    //   148: invokespecial 271	android/content/ContentValues:<init>	()V
    //   151: aload 12
    //   153: astore 11
    //   155: aload 12
    //   157: astore 10
    //   159: aload_1
    //   160: invokevirtual 276	com/tencent/wxop/stat/a/d:af	()Ljava/lang/String;
    //   163: astore 16
    //   165: aload 12
    //   167: astore 11
    //   169: aload 12
    //   171: astore 10
    //   173: invokestatic 198	com/tencent/wxop/stat/c:k	()Z
    //   176: ifeq +68 -> 244
    //   179: aload 12
    //   181: astore 11
    //   183: aload 12
    //   185: astore 10
    //   187: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   190: astore 14
    //   192: aload 12
    //   194: astore 11
    //   196: aload 12
    //   198: astore 10
    //   200: new 97	java/lang/StringBuilder
    //   203: astore 15
    //   205: aload 12
    //   207: astore 11
    //   209: aload 12
    //   211: astore 10
    //   213: aload 15
    //   215: ldc_w 278
    //   218: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   221: aload 12
    //   223: astore 11
    //   225: aload 12
    //   227: astore 10
    //   229: aload 14
    //   231: aload 15
    //   233: aload 16
    //   235: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokevirtual 208	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Object;)V
    //   244: aload 12
    //   246: astore 11
    //   248: aload 12
    //   250: astore 10
    //   252: aload 13
    //   254: ldc_w 280
    //   257: aload 16
    //   259: invokestatic 286	com/tencent/wxop/stat/b/r:q	(Ljava/lang/String;)Ljava/lang/String;
    //   262: invokevirtual 290	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   265: aload 12
    //   267: astore 11
    //   269: aload 12
    //   271: astore 10
    //   273: aload 13
    //   275: ldc_w 292
    //   278: ldc_w 294
    //   281: invokevirtual 290	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   284: aload 12
    //   286: astore 11
    //   288: aload 12
    //   290: astore 10
    //   292: aload 13
    //   294: ldc_w 296
    //   297: iconst_1
    //   298: invokestatic 300	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   301: invokevirtual 290	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   304: aload 12
    //   306: astore 11
    //   308: aload 12
    //   310: astore 10
    //   312: aload 13
    //   314: ldc_w 302
    //   317: aload_1
    //   318: invokevirtual 306	com/tencent/wxop/stat/a/d:ad	()J
    //   321: invokestatic 312	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   324: invokevirtual 315	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   327: aload 12
    //   329: astore 11
    //   331: aload 12
    //   333: astore 10
    //   335: aload 12
    //   337: ldc_w 262
    //   340: aconst_null
    //   341: aload 13
    //   343: invokevirtual 319	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   346: lstore 6
    //   348: aload 12
    //   350: astore 11
    //   352: aload 12
    //   354: astore 10
    //   356: aload 12
    //   358: invokevirtual 322	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   361: lload 6
    //   363: lstore 8
    //   365: aload 12
    //   367: ifnull +376 -> 743
    //   370: aload 12
    //   372: invokevirtual 325	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   375: lload 6
    //   377: lconst_0
    //   378: lcmp
    //   379: ifle +164 -> 543
    //   382: aload_0
    //   383: aload_0
    //   384: getfield 66	com/tencent/wxop/stat/t:aI	I
    //   387: iconst_1
    //   388: iadd
    //   389: putfield 66	com/tencent/wxop/stat/t:aI	I
    //   392: invokestatic 198	com/tencent/wxop/stat/c:k	()Z
    //   395: ifeq +38 -> 433
    //   398: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   401: astore 10
    //   403: new 97	java/lang/StringBuilder
    //   406: astore 11
    //   408: aload 11
    //   410: ldc_w 327
    //   413: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   416: aload 10
    //   418: aload 11
    //   420: aload_1
    //   421: invokevirtual 276	com/tencent/wxop/stat/a/d:af	()Ljava/lang/String;
    //   424: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: invokevirtual 330	com/tencent/wxop/stat/b/b:e	(Ljava/lang/Object;)V
    //   433: aload_2
    //   434: ifnull +9 -> 443
    //   437: aload_2
    //   438: invokeinterface 335 1 0
    //   443: aload_0
    //   444: monitorexit
    //   445: return
    //   446: astore 10
    //   448: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   451: aload 10
    //   453: invokevirtual 136	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   456: goto -81 -> 375
    //   459: astore 12
    //   461: ldc2_w 336
    //   464: lstore 8
    //   466: aload 11
    //   468: astore 10
    //   470: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   473: aload 12
    //   475: invokevirtual 136	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   478: aload 11
    //   480: ifnull +263 -> 743
    //   483: aload 11
    //   485: invokevirtual 325	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   488: ldc2_w 336
    //   491: lstore 6
    //   493: goto -118 -> 375
    //   496: astore 10
    //   498: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   501: aload 10
    //   503: invokevirtual 136	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   506: ldc2_w 336
    //   509: lstore 6
    //   511: goto -136 -> 375
    //   514: astore_1
    //   515: aload 10
    //   517: ifnull +8 -> 525
    //   520: aload 10
    //   522: invokevirtual 325	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   525: aload_1
    //   526: athrow
    //   527: astore_1
    //   528: aload_0
    //   529: monitorexit
    //   530: aload_1
    //   531: athrow
    //   532: astore_2
    //   533: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   536: aload_2
    //   537: invokevirtual 136	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   540: goto -15 -> 525
    //   543: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   546: astore 10
    //   548: new 97	java/lang/StringBuilder
    //   551: astore_2
    //   552: aload_2
    //   553: ldc_w 339
    //   556: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   559: aload 10
    //   561: aload_2
    //   562: aload_1
    //   563: invokevirtual 276	com/tencent/wxop/stat/a/d:af	()Ljava/lang/String;
    //   566: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   572: invokevirtual 342	com/tencent/wxop/stat/b/b:error	(Ljava/lang/Object;)V
    //   575: goto -132 -> 443
    //   578: getstatic 246	com/tencent/wxop/stat/c:ay	I
    //   581: ifle -138 -> 443
    //   584: invokestatic 198	com/tencent/wxop/stat/c:k	()Z
    //   587: ifeq +101 -> 688
    //   590: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   593: astore 11
    //   595: new 97	java/lang/StringBuilder
    //   598: astore 10
    //   600: aload 10
    //   602: ldc_w 344
    //   605: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   608: aload 11
    //   610: aload 10
    //   612: aload_0
    //   613: getfield 72	com/tencent/wxop/stat/t:cd	Ljava/util/concurrent/ConcurrentHashMap;
    //   616: invokevirtual 345	java/util/concurrent/ConcurrentHashMap:size	()I
    //   619: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   622: ldc_w 347
    //   625: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: getstatic 246	com/tencent/wxop/stat/c:ay	I
    //   631: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   634: ldc_w 349
    //   637: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   640: aload_0
    //   641: getfield 66	com/tencent/wxop/stat/t:aI	I
    //   644: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   647: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   650: invokevirtual 208	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Object;)V
    //   653: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   656: astore 11
    //   658: new 97	java/lang/StringBuilder
    //   661: astore 10
    //   663: aload 10
    //   665: ldc_w 351
    //   668: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   671: aload 11
    //   673: aload 10
    //   675: aload_1
    //   676: invokevirtual 276	com/tencent/wxop/stat/a/d:af	()Ljava/lang/String;
    //   679: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   685: invokevirtual 208	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Object;)V
    //   688: aload_0
    //   689: getfield 72	com/tencent/wxop/stat/t:cd	Ljava/util/concurrent/ConcurrentHashMap;
    //   692: aload_1
    //   693: ldc 60
    //   695: invokevirtual 354	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   698: pop
    //   699: aload_0
    //   700: getfield 72	com/tencent/wxop/stat/t:cd	Ljava/util/concurrent/ConcurrentHashMap;
    //   703: invokevirtual 345	java/util/concurrent/ConcurrentHashMap:size	()I
    //   706: getstatic 246	com/tencent/wxop/stat/c:ay	I
    //   709: if_icmplt +7 -> 716
    //   712: aload_0
    //   713: invokespecial 357	com/tencent/wxop/stat/t:am	()V
    //   716: aload_2
    //   717: ifnull -274 -> 443
    //   720: aload_0
    //   721: getfield 72	com/tencent/wxop/stat/t:cd	Ljava/util/concurrent/ConcurrentHashMap;
    //   724: invokevirtual 345	java/util/concurrent/ConcurrentHashMap:size	()I
    //   727: ifle +7 -> 734
    //   730: aload_0
    //   731: invokespecial 357	com/tencent/wxop/stat/t:am	()V
    //   734: aload_2
    //   735: invokeinterface 335 1 0
    //   740: goto -297 -> 443
    //   743: lload 8
    //   745: lstore 6
    //   747: goto -372 -> 375
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	750	0	this	t
    //   0	750	1	paramd	d
    //   0	750	2	paramaj	aj
    //   0	750	3	paramBoolean1	boolean
    //   0	750	4	paramBoolean2	boolean
    //   17	3	5	i	int
    //   346	400	6	l1	long
    //   363	381	8	l2	long
    //   1	416	10	localObject1	Object
    //   446	6	10	localThrowable1	Throwable
    //   468	1	10	localObject2	Object
    //   496	25	10	localThrowable2	Throwable
    //   546	128	10	localObject3	Object
    //   4	668	11	localObject4	Object
    //   38	333	12	localSQLiteDatabase	SQLiteDatabase
    //   459	15	12	localThrowable3	Throwable
    //   136	206	13	localContentValues	ContentValues
    //   190	40	14	localb	b
    //   203	29	15	localStringBuilder	StringBuilder
    //   163	95	16	str	String
    // Exception table:
    //   from	to	target	type
    //   370	375	446	java/lang/Throwable
    //   33	40	459	java/lang/Throwable
    //   48	53	459	java/lang/Throwable
    //   65	75	459	java/lang/Throwable
    //   83	91	459	java/lang/Throwable
    //   99	125	459	java/lang/Throwable
    //   133	138	459	java/lang/Throwable
    //   146	151	459	java/lang/Throwable
    //   159	165	459	java/lang/Throwable
    //   173	179	459	java/lang/Throwable
    //   187	192	459	java/lang/Throwable
    //   200	205	459	java/lang/Throwable
    //   213	221	459	java/lang/Throwable
    //   229	244	459	java/lang/Throwable
    //   252	265	459	java/lang/Throwable
    //   273	284	459	java/lang/Throwable
    //   292	304	459	java/lang/Throwable
    //   312	327	459	java/lang/Throwable
    //   335	348	459	java/lang/Throwable
    //   356	361	459	java/lang/Throwable
    //   483	488	496	java/lang/Throwable
    //   33	40	514	finally
    //   48	53	514	finally
    //   65	75	514	finally
    //   83	91	514	finally
    //   99	125	514	finally
    //   133	138	514	finally
    //   146	151	514	finally
    //   159	165	514	finally
    //   173	179	514	finally
    //   187	192	514	finally
    //   200	205	514	finally
    //   213	221	514	finally
    //   229	244	514	finally
    //   252	265	514	finally
    //   273	284	514	finally
    //   292	304	514	finally
    //   312	327	514	finally
    //   335	348	514	finally
    //   356	361	514	finally
    //   470	478	514	finally
    //   8	19	527	finally
    //   370	375	527	finally
    //   382	433	527	finally
    //   437	443	527	finally
    //   448	456	527	finally
    //   483	488	527	finally
    //   498	506	527	finally
    //   520	525	527	finally
    //   525	527	527	finally
    //   533	540	527	finally
    //   543	575	527	finally
    //   578	688	527	finally
    //   688	716	527	finally
    //   720	734	527	finally
    //   734	740	527	finally
    //   520	525	532	java/lang/Throwable
  }
  
  /* Error */
  private void a(ah paramah)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: getfield 175	com/tencent/wxop/stat/ah:df	Lorg/json/JSONObject;
    //   6: invokevirtual 361	org/json/JSONObject:toString	()Ljava/lang/String;
    //   9: astore 7
    //   11: aload 7
    //   13: invokestatic 363	com/tencent/wxop/stat/b/l:t	(Ljava/lang/String;)Ljava/lang/String;
    //   16: astore 5
    //   18: new 270	android/content/ContentValues
    //   21: astore 8
    //   23: aload 8
    //   25: invokespecial 271	android/content/ContentValues:<init>	()V
    //   28: aload 8
    //   30: ldc_w 280
    //   33: aload_1
    //   34: getfield 175	com/tencent/wxop/stat/ah:df	Lorg/json/JSONObject;
    //   37: invokevirtual 361	org/json/JSONObject:toString	()Ljava/lang/String;
    //   40: invokevirtual 290	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload 8
    //   45: ldc_w 365
    //   48: aload 5
    //   50: invokevirtual 290	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: aload_1
    //   54: aload 5
    //   56: putfield 178	com/tencent/wxop/stat/ah:c	Ljava/lang/String;
    //   59: aload 8
    //   61: ldc_w 367
    //   64: aload_1
    //   65: getfield 181	com/tencent/wxop/stat/ah:L	I
    //   68: invokestatic 370	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   71: invokevirtual 373	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   74: aload_0
    //   75: getfield 54	com/tencent/wxop/stat/t:bW	Lcom/tencent/wxop/stat/ac;
    //   78: invokevirtual 140	com/tencent/wxop/stat/ac:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   81: ldc -114
    //   83: aconst_null
    //   84: aconst_null
    //   85: aconst_null
    //   86: aconst_null
    //   87: aconst_null
    //   88: aconst_null
    //   89: invokevirtual 148	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   92: astore 6
    //   94: aload 6
    //   96: astore 5
    //   98: aload 6
    //   100: invokeinterface 154 1 0
    //   105: ifeq +359 -> 464
    //   108: aload 6
    //   110: astore 5
    //   112: aload 6
    //   114: iconst_0
    //   115: invokeinterface 158 2 0
    //   120: aload_1
    //   121: getfield 168	com/tencent/wxop/stat/ah:aI	I
    //   124: if_icmpne -30 -> 94
    //   127: iconst_1
    //   128: istore_2
    //   129: aload 6
    //   131: astore 5
    //   133: aload_0
    //   134: getfield 54	com/tencent/wxop/stat/t:bW	Lcom/tencent/wxop/stat/ac;
    //   137: invokevirtual 260	com/tencent/wxop/stat/ac:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   140: invokevirtual 252	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   143: iconst_1
    //   144: iload_2
    //   145: if_icmpne +134 -> 279
    //   148: aload 6
    //   150: astore 5
    //   152: aload_0
    //   153: getfield 54	com/tencent/wxop/stat/t:bW	Lcom/tencent/wxop/stat/ac;
    //   156: invokevirtual 260	com/tencent/wxop/stat/ac:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   159: ldc -114
    //   161: aload 8
    //   163: ldc_w 375
    //   166: iconst_1
    //   167: anewarray 377	java/lang/String
    //   170: dup
    //   171: iconst_0
    //   172: aload_1
    //   173: getfield 168	com/tencent/wxop/stat/ah:aI	I
    //   176: invokestatic 300	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   179: aastore
    //   180: invokevirtual 381	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   183: i2l
    //   184: lstore_3
    //   185: lload_3
    //   186: ldc2_w 336
    //   189: lcmp
    //   190: ifne +131 -> 321
    //   193: aload 6
    //   195: astore 5
    //   197: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   200: astore_1
    //   201: aload 6
    //   203: astore 5
    //   205: new 97	java/lang/StringBuilder
    //   208: astore 8
    //   210: aload 6
    //   212: astore 5
    //   214: aload 8
    //   216: ldc_w 383
    //   219: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   222: aload 6
    //   224: astore 5
    //   226: aload_1
    //   227: aload 8
    //   229: aload 7
    //   231: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: invokevirtual 386	com/tencent/wxop/stat/b/b:d	(Ljava/lang/Object;)V
    //   240: aload 6
    //   242: astore 5
    //   244: aload_0
    //   245: getfield 54	com/tencent/wxop/stat/t:bW	Lcom/tencent/wxop/stat/ac;
    //   248: invokevirtual 260	com/tencent/wxop/stat/ac:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   251: invokevirtual 322	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   254: aload 6
    //   256: ifnull +10 -> 266
    //   259: aload 6
    //   261: invokeinterface 190 1 0
    //   266: aload_0
    //   267: getfield 54	com/tencent/wxop/stat/t:bW	Lcom/tencent/wxop/stat/ac;
    //   270: invokevirtual 260	com/tencent/wxop/stat/ac:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   273: invokevirtual 325	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   276: aload_0
    //   277: monitorexit
    //   278: return
    //   279: aload 6
    //   281: astore 5
    //   283: aload 8
    //   285: ldc_w 388
    //   288: aload_1
    //   289: getfield 168	com/tencent/wxop/stat/ah:aI	I
    //   292: invokestatic 370	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   295: invokevirtual 373	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   298: aload 6
    //   300: astore 5
    //   302: aload_0
    //   303: getfield 54	com/tencent/wxop/stat/t:bW	Lcom/tencent/wxop/stat/ac;
    //   306: invokevirtual 260	com/tencent/wxop/stat/ac:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   309: ldc -114
    //   311: aconst_null
    //   312: aload 8
    //   314: invokevirtual 319	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   317: lstore_3
    //   318: goto -133 -> 185
    //   321: aload 6
    //   323: astore 5
    //   325: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   328: astore 8
    //   330: aload 6
    //   332: astore 5
    //   334: new 97	java/lang/StringBuilder
    //   337: astore_1
    //   338: aload 6
    //   340: astore 5
    //   342: aload_1
    //   343: ldc_w 390
    //   346: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   349: aload 6
    //   351: astore 5
    //   353: aload 8
    //   355: aload_1
    //   356: aload 7
    //   358: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   364: invokevirtual 330	com/tencent/wxop/stat/b/b:e	(Ljava/lang/Object;)V
    //   367: goto -127 -> 240
    //   370: astore_1
    //   371: aload 6
    //   373: astore 5
    //   375: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   378: aload_1
    //   379: invokevirtual 136	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   382: aload 6
    //   384: ifnull +10 -> 394
    //   387: aload 6
    //   389: invokeinterface 190 1 0
    //   394: aload_0
    //   395: getfield 54	com/tencent/wxop/stat/t:bW	Lcom/tencent/wxop/stat/ac;
    //   398: invokevirtual 260	com/tencent/wxop/stat/ac:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   401: invokevirtual 325	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   404: goto -128 -> 276
    //   407: astore_1
    //   408: goto -132 -> 276
    //   411: astore_1
    //   412: aconst_null
    //   413: astore 5
    //   415: aload 5
    //   417: ifnull +10 -> 427
    //   420: aload 5
    //   422: invokeinterface 190 1 0
    //   427: aload_0
    //   428: getfield 54	com/tencent/wxop/stat/t:bW	Lcom/tencent/wxop/stat/ac;
    //   431: invokevirtual 260	com/tencent/wxop/stat/ac:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   434: invokevirtual 325	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   437: aload_1
    //   438: athrow
    //   439: astore_1
    //   440: aload_0
    //   441: monitorexit
    //   442: aload_1
    //   443: athrow
    //   444: astore 5
    //   446: goto -9 -> 437
    //   449: astore_1
    //   450: goto -35 -> 415
    //   453: astore_1
    //   454: aconst_null
    //   455: astore 6
    //   457: goto -86 -> 371
    //   460: astore_1
    //   461: goto -185 -> 276
    //   464: iconst_0
    //   465: istore_2
    //   466: goto -337 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	469	0	this	t
    //   0	469	1	paramah	ah
    //   128	338	2	i	int
    //   184	134	3	l	long
    //   16	405	5	localObject1	Object
    //   444	1	5	localException	Exception
    //   92	364	6	localCursor	android.database.Cursor
    //   9	348	7	str	String
    //   21	333	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   98	108	370	java/lang/Throwable
    //   112	127	370	java/lang/Throwable
    //   133	143	370	java/lang/Throwable
    //   152	185	370	java/lang/Throwable
    //   197	201	370	java/lang/Throwable
    //   205	210	370	java/lang/Throwable
    //   214	222	370	java/lang/Throwable
    //   226	240	370	java/lang/Throwable
    //   244	254	370	java/lang/Throwable
    //   283	298	370	java/lang/Throwable
    //   302	318	370	java/lang/Throwable
    //   325	330	370	java/lang/Throwable
    //   334	338	370	java/lang/Throwable
    //   342	349	370	java/lang/Throwable
    //   353	367	370	java/lang/Throwable
    //   394	404	407	java/lang/Exception
    //   2	94	411	finally
    //   259	266	439	finally
    //   266	276	439	finally
    //   387	394	439	finally
    //   394	404	439	finally
    //   420	427	439	finally
    //   427	437	439	finally
    //   437	439	439	finally
    //   427	437	444	java/lang/Exception
    //   98	108	449	finally
    //   112	127	449	finally
    //   133	143	449	finally
    //   152	185	449	finally
    //   197	201	449	finally
    //   205	210	449	finally
    //   214	222	449	finally
    //   226	240	449	finally
    //   244	254	449	finally
    //   283	298	449	finally
    //   302	318	449	finally
    //   325	330	449	finally
    //   334	338	449	finally
    //   342	349	449	finally
    //   353	367	449	finally
    //   375	382	449	finally
    //   2	94	453	java/lang/Throwable
    //   266	276	460	java/lang/Exception
  }
  
  /* Error */
  private void a(List<ad> paramList, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 7
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_1
    //   9: invokeinterface 220 1 0
    //   14: istore 4
    //   16: iload 4
    //   18: ifne +6 -> 24
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: iload_3
    //   25: ifne +263 -> 288
    //   28: invokestatic 434	com/tencent/wxop/stat/c:p	()I
    //   31: istore 4
    //   33: aload_0
    //   34: iload_3
    //   35: invokespecial 249	com/tencent/wxop/stat/t:c	(Z)Landroid/database/sqlite/SQLiteDatabase;
    //   38: astore 6
    //   40: iload_2
    //   41: iconst_2
    //   42: if_icmpne +254 -> 296
    //   45: aload 6
    //   47: astore 5
    //   49: new 97	java/lang/StringBuilder
    //   52: astore 8
    //   54: aload 6
    //   56: astore 5
    //   58: aload 8
    //   60: ldc_w 436
    //   63: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   66: aload 6
    //   68: astore 5
    //   70: aload 8
    //   72: iload_2
    //   73: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   76: ldc_w 438
    //   79: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_1
    //   83: invokestatic 441	com/tencent/wxop/stat/t:b	(Ljava/util/List;)Ljava/lang/String;
    //   86: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: astore 8
    //   94: aload 7
    //   96: astore_1
    //   97: aload 8
    //   99: astore 7
    //   101: aload 6
    //   103: astore 5
    //   105: invokestatic 198	com/tencent/wxop/stat/c:k	()Z
    //   108: ifeq +52 -> 160
    //   111: aload 6
    //   113: astore 5
    //   115: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   118: astore 8
    //   120: aload 6
    //   122: astore 5
    //   124: new 97	java/lang/StringBuilder
    //   127: astore 9
    //   129: aload 6
    //   131: astore 5
    //   133: aload 9
    //   135: ldc_w 443
    //   138: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   141: aload 6
    //   143: astore 5
    //   145: aload 8
    //   147: aload 9
    //   149: aload 7
    //   151: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokevirtual 208	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Object;)V
    //   160: aload 6
    //   162: astore 5
    //   164: aload 6
    //   166: invokevirtual 252	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   169: aload 6
    //   171: astore 5
    //   173: aload 6
    //   175: aload 7
    //   177: invokevirtual 446	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   180: aload_1
    //   181: ifnull +69 -> 250
    //   184: aload 6
    //   186: astore 5
    //   188: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   191: astore 7
    //   193: aload 6
    //   195: astore 5
    //   197: new 97	java/lang/StringBuilder
    //   200: astore 8
    //   202: aload 6
    //   204: astore 5
    //   206: aload 8
    //   208: ldc_w 448
    //   211: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   214: aload 6
    //   216: astore 5
    //   218: aload 7
    //   220: aload 8
    //   222: aload_1
    //   223: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokevirtual 208	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Object;)V
    //   232: aload 6
    //   234: astore 5
    //   236: aload 6
    //   238: aload_1
    //   239: invokevirtual 446	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   242: aload 6
    //   244: astore 5
    //   246: aload_0
    //   247: invokespecial 122	com/tencent/wxop/stat/t:aj	()V
    //   250: aload 6
    //   252: astore 5
    //   254: aload 6
    //   256: invokevirtual 322	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   259: aload 6
    //   261: ifnull -240 -> 21
    //   264: aload 6
    //   266: invokevirtual 325	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   269: goto -248 -> 21
    //   272: astore_1
    //   273: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   276: aload_1
    //   277: invokevirtual 136	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   280: goto -259 -> 21
    //   283: astore_1
    //   284: aload_0
    //   285: monitorexit
    //   286: aload_1
    //   287: athrow
    //   288: invokestatic 451	com/tencent/wxop/stat/c:n	()I
    //   291: istore 4
    //   293: goto -260 -> 33
    //   296: aload 6
    //   298: astore 5
    //   300: new 97	java/lang/StringBuilder
    //   303: astore 7
    //   305: aload 6
    //   307: astore 5
    //   309: aload 7
    //   311: ldc_w 436
    //   314: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   317: aload 6
    //   319: astore 5
    //   321: aload 7
    //   323: iload_2
    //   324: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   327: ldc_w 453
    //   330: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: aload_1
    //   334: invokestatic 441	com/tencent/wxop/stat/t:b	(Ljava/util/List;)Ljava/lang/String;
    //   337: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: astore 7
    //   345: aload 8
    //   347: astore_1
    //   348: aload 6
    //   350: astore 5
    //   352: aload_0
    //   353: getfield 70	com/tencent/wxop/stat/t:cc	I
    //   356: iconst_3
    //   357: irem
    //   358: ifne +36 -> 394
    //   361: aload 6
    //   363: astore 5
    //   365: new 97	java/lang/StringBuilder
    //   368: astore_1
    //   369: aload 6
    //   371: astore 5
    //   373: aload_1
    //   374: ldc_w 455
    //   377: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   380: aload 6
    //   382: astore 5
    //   384: aload_1
    //   385: iload 4
    //   387: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   390: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   393: astore_1
    //   394: aload 6
    //   396: astore 5
    //   398: aload_0
    //   399: aload_0
    //   400: getfield 70	com/tencent/wxop/stat/t:cc	I
    //   403: iconst_1
    //   404: iadd
    //   405: putfield 70	com/tencent/wxop/stat/t:cc	I
    //   408: goto -307 -> 101
    //   411: astore_1
    //   412: aconst_null
    //   413: astore 6
    //   415: aload 6
    //   417: astore 5
    //   419: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   422: aload_1
    //   423: invokevirtual 136	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   426: aload 6
    //   428: ifnull -407 -> 21
    //   431: aload 6
    //   433: invokevirtual 325	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   436: goto -415 -> 21
    //   439: astore_1
    //   440: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   443: aload_1
    //   444: invokevirtual 136	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   447: goto -426 -> 21
    //   450: astore_1
    //   451: aconst_null
    //   452: astore 5
    //   454: aload 5
    //   456: ifnull +8 -> 464
    //   459: aload 5
    //   461: invokevirtual 325	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   464: aload_1
    //   465: athrow
    //   466: astore 5
    //   468: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   471: aload 5
    //   473: invokevirtual 136	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   476: goto -12 -> 464
    //   479: astore_1
    //   480: goto -26 -> 454
    //   483: astore_1
    //   484: goto -69 -> 415
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	487	0	this	t
    //   0	487	1	paramList	List<ad>
    //   0	487	2	paramInt	int
    //   0	487	3	paramBoolean	boolean
    //   14	372	4	i	int
    //   47	413	5	localSQLiteDatabase1	SQLiteDatabase
    //   466	6	5	localThrowable	Throwable
    //   38	394	6	localSQLiteDatabase2	SQLiteDatabase
    //   4	340	7	localObject1	Object
    //   1	345	8	localObject2	Object
    //   127	21	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   264	269	272	java/lang/Throwable
    //   8	16	283	finally
    //   28	33	283	finally
    //   264	269	283	finally
    //   273	280	283	finally
    //   288	293	283	finally
    //   431	436	283	finally
    //   440	447	283	finally
    //   459	464	283	finally
    //   464	466	283	finally
    //   468	476	283	finally
    //   33	40	411	java/lang/Throwable
    //   431	436	439	java/lang/Throwable
    //   33	40	450	finally
    //   459	464	466	java/lang/Throwable
    //   49	54	479	finally
    //   58	66	479	finally
    //   70	94	479	finally
    //   105	111	479	finally
    //   115	120	479	finally
    //   124	129	479	finally
    //   133	141	479	finally
    //   145	160	479	finally
    //   164	169	479	finally
    //   173	180	479	finally
    //   188	193	479	finally
    //   197	202	479	finally
    //   206	214	479	finally
    //   218	232	479	finally
    //   236	242	479	finally
    //   246	250	479	finally
    //   254	259	479	finally
    //   300	305	479	finally
    //   309	317	479	finally
    //   321	345	479	finally
    //   352	361	479	finally
    //   365	369	479	finally
    //   373	380	479	finally
    //   384	394	479	finally
    //   398	408	479	finally
    //   419	426	479	finally
    //   49	54	483	java/lang/Throwable
    //   58	66	483	java/lang/Throwable
    //   70	94	483	java/lang/Throwable
    //   105	111	483	java/lang/Throwable
    //   115	120	483	java/lang/Throwable
    //   124	129	483	java/lang/Throwable
    //   133	141	483	java/lang/Throwable
    //   145	160	483	java/lang/Throwable
    //   164	169	483	java/lang/Throwable
    //   173	180	483	java/lang/Throwable
    //   188	193	483	java/lang/Throwable
    //   197	202	483	java/lang/Throwable
    //   206	214	483	java/lang/Throwable
    //   218	232	483	java/lang/Throwable
    //   236	242	483	java/lang/Throwable
    //   246	250	483	java/lang/Throwable
    //   254	259	483	java/lang/Throwable
    //   300	305	483	java/lang/Throwable
    //   309	317	483	java/lang/Throwable
    //   321	345	483	java/lang/Throwable
    //   352	361	483	java/lang/Throwable
    //   365	369	483	java/lang/Throwable
    //   373	380	483	java/lang/Throwable
    //   384	394	483	java/lang/Throwable
    //   398	408	483	java/lang/Throwable
  }
  
  /* Error */
  private void a(List<ad> paramList, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: monitorenter
    //   8: aload_1
    //   9: invokeinterface 220 1 0
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +6 -> 22
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: invokestatic 198	com/tencent/wxop/stat/c:k	()Z
    //   25: ifeq +50 -> 75
    //   28: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   31: astore 7
    //   33: new 97	java/lang/StringBuilder
    //   36: astore 8
    //   38: aload 8
    //   40: ldc_w 459
    //   43: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   46: aload 7
    //   48: aload 8
    //   50: aload_1
    //   51: invokeinterface 220 1 0
    //   56: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   59: ldc_w 461
    //   62: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: iload_2
    //   66: invokevirtual 410	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   69: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokevirtual 208	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Object;)V
    //   75: new 97	java/lang/StringBuilder
    //   78: astore 7
    //   80: aload 7
    //   82: aload_1
    //   83: invokeinterface 220 1 0
    //   88: iconst_3
    //   89: imul
    //   90: invokespecial 462	java/lang/StringBuilder:<init>	(I)V
    //   93: aload 7
    //   95: ldc_w 464
    //   98: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload_1
    //   103: invokeinterface 220 1 0
    //   108: istore 4
    //   110: aload_1
    //   111: invokeinterface 468 1 0
    //   116: astore_1
    //   117: iconst_0
    //   118: istore_3
    //   119: aload_1
    //   120: invokeinterface 473 1 0
    //   125: ifeq +44 -> 169
    //   128: aload 7
    //   130: aload_1
    //   131: invokeinterface 477 1 0
    //   136: checkcast 479	com/tencent/wxop/stat/ad
    //   139: getfield 482	com/tencent/wxop/stat/ad:K	J
    //   142: invokevirtual 485	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: iload_3
    //   147: iload 4
    //   149: iconst_1
    //   150: isub
    //   151: if_icmpeq +12 -> 163
    //   154: aload 7
    //   156: ldc_w 487
    //   159: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: iinc 3 1
    //   166: goto -47 -> 119
    //   169: aload 7
    //   171: ldc_w 489
    //   174: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload 6
    //   180: astore_1
    //   181: aload_0
    //   182: iload_2
    //   183: invokespecial 249	com/tencent/wxop/stat/t:c	(Z)Landroid/database/sqlite/SQLiteDatabase;
    //   186: astore 6
    //   188: aload 6
    //   190: astore 5
    //   192: aload 6
    //   194: astore_1
    //   195: aload 6
    //   197: invokevirtual 252	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   200: aload 6
    //   202: astore 5
    //   204: aload 6
    //   206: astore_1
    //   207: aload 6
    //   209: ldc_w 262
    //   212: aload 7
    //   214: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: aconst_null
    //   218: invokevirtual 268	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   221: istore_3
    //   222: aload 6
    //   224: astore 5
    //   226: aload 6
    //   228: astore_1
    //   229: invokestatic 198	com/tencent/wxop/stat/c:k	()Z
    //   232: ifeq +88 -> 320
    //   235: aload 6
    //   237: astore 5
    //   239: aload 6
    //   241: astore_1
    //   242: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   245: astore 9
    //   247: aload 6
    //   249: astore 5
    //   251: aload 6
    //   253: astore_1
    //   254: new 97	java/lang/StringBuilder
    //   257: astore 8
    //   259: aload 6
    //   261: astore 5
    //   263: aload 6
    //   265: astore_1
    //   266: aload 8
    //   268: ldc_w 491
    //   271: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   274: aload 6
    //   276: astore 5
    //   278: aload 6
    //   280: astore_1
    //   281: aload 9
    //   283: aload 8
    //   285: iload 4
    //   287: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   290: ldc_w 493
    //   293: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: aload 7
    //   298: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: ldc_w 495
    //   307: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: iload_3
    //   311: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   314: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: invokevirtual 208	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Object;)V
    //   320: aload 6
    //   322: astore 5
    //   324: aload 6
    //   326: astore_1
    //   327: aload_0
    //   328: aload_0
    //   329: getfield 66	com/tencent/wxop/stat/t:aI	I
    //   332: iload_3
    //   333: isub
    //   334: putfield 66	com/tencent/wxop/stat/t:aI	I
    //   337: aload 6
    //   339: astore 5
    //   341: aload 6
    //   343: astore_1
    //   344: aload 6
    //   346: invokevirtual 322	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   349: aload 6
    //   351: astore 5
    //   353: aload 6
    //   355: astore_1
    //   356: aload_0
    //   357: invokespecial 122	com/tencent/wxop/stat/t:aj	()V
    //   360: aload 6
    //   362: ifnull -343 -> 19
    //   365: aload 6
    //   367: invokevirtual 325	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   370: goto -351 -> 19
    //   373: astore_1
    //   374: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   377: aload_1
    //   378: invokevirtual 136	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   381: goto -362 -> 19
    //   384: astore_1
    //   385: aload_0
    //   386: monitorexit
    //   387: aload_1
    //   388: athrow
    //   389: astore 6
    //   391: aload 5
    //   393: astore_1
    //   394: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   397: aload 6
    //   399: invokevirtual 136	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   402: aload 5
    //   404: ifnull -385 -> 19
    //   407: aload 5
    //   409: invokevirtual 325	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   412: goto -393 -> 19
    //   415: astore_1
    //   416: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   419: aload_1
    //   420: invokevirtual 136	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   423: goto -404 -> 19
    //   426: astore 5
    //   428: aload_1
    //   429: ifnull +7 -> 436
    //   432: aload_1
    //   433: invokevirtual 325	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   436: aload 5
    //   438: athrow
    //   439: astore_1
    //   440: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   443: aload_1
    //   444: invokevirtual 136	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   447: goto -11 -> 436
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	450	0	this	t
    //   0	450	1	paramList	List<ad>
    //   0	450	2	paramBoolean	boolean
    //   14	320	3	i	int
    //   108	178	4	j	int
    //   4	404	5	localSQLiteDatabase1	SQLiteDatabase
    //   426	11	5	localObject1	Object
    //   1	365	6	localSQLiteDatabase2	SQLiteDatabase
    //   389	9	6	localThrowable	Throwable
    //   31	266	7	localObject2	Object
    //   36	248	8	localStringBuilder	StringBuilder
    //   245	37	9	localb	b
    // Exception table:
    //   from	to	target	type
    //   365	370	373	java/lang/Throwable
    //   8	15	384	finally
    //   22	75	384	finally
    //   75	117	384	finally
    //   119	146	384	finally
    //   154	163	384	finally
    //   169	178	384	finally
    //   365	370	384	finally
    //   374	381	384	finally
    //   407	412	384	finally
    //   416	423	384	finally
    //   432	436	384	finally
    //   436	439	384	finally
    //   440	447	384	finally
    //   181	188	389	java/lang/Throwable
    //   195	200	389	java/lang/Throwable
    //   207	222	389	java/lang/Throwable
    //   229	235	389	java/lang/Throwable
    //   242	247	389	java/lang/Throwable
    //   254	259	389	java/lang/Throwable
    //   266	274	389	java/lang/Throwable
    //   281	320	389	java/lang/Throwable
    //   327	337	389	java/lang/Throwable
    //   344	349	389	java/lang/Throwable
    //   356	360	389	java/lang/Throwable
    //   407	412	415	java/lang/Throwable
    //   181	188	426	finally
    //   195	200	426	finally
    //   207	222	426	finally
    //   229	235	426	finally
    //   242	247	426	finally
    //   254	259	426	finally
    //   266	274	426	finally
    //   281	320	426	finally
    //   327	337	426	finally
    //   344	349	426	finally
    //   356	360	426	finally
    //   394	402	426	finally
    //   432	436	439	java/lang/Throwable
  }
  
  public static t ai()
  {
    return cb;
  }
  
  private void aj()
  {
    this.aI = (ak() + al());
  }
  
  private int ak()
  {
    return (int)DatabaseUtils.queryNumEntries(this.bW.getReadableDatabase(), "events");
  }
  
  private int al()
  {
    return (int)DatabaseUtils.queryNumEntries(this.bX.getReadableDatabase(), "events");
  }
  
  private void am()
  {
    Object localObject5 = null;
    Object localObject1 = null;
    if (this.ce) {}
    for (;;)
    {
      return;
      synchronized (this.cd)
      {
        if (this.cd.size() != 0) {}
      }
      this.ce = true;
      Object localObject6;
      Object localObject7;
      if (c.k())
      {
        localObject6 = bZ;
        localObject7 = new java/lang/StringBuilder;
        ((StringBuilder)localObject7).<init>("insert ");
        ((b)localObject6).b(this.cd.size() + " events ,numEventsCachedInMemory:" + c.ay + ",numStoredEvents:" + this.aI);
      }
      try
      {
        localObject6 = this.bW.getWritableDatabase();
        localObject3 = localObject6;
        localObject5 = localObject6;
        ((SQLiteDatabase)localObject6).beginTransaction();
        localObject3 = localObject6;
        localObject5 = localObject6;
        Iterator localIterator = this.cd.entrySet().iterator();
        for (;;)
        {
          localObject3 = localObject6;
          localObject5 = localObject6;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject3 = localObject6;
          localObject5 = localObject6;
          d locald = (d)((Map.Entry)localIterator.next()).getKey();
          localObject3 = localObject6;
          localObject5 = localObject6;
          localObject7 = new android/content/ContentValues;
          localObject3 = localObject6;
          localObject5 = localObject6;
          ((ContentValues)localObject7).<init>();
          localObject3 = localObject6;
          localObject5 = localObject6;
          String str = locald.af();
          localObject3 = localObject6;
          localObject5 = localObject6;
          if (c.k())
          {
            localObject3 = localObject6;
            localObject5 = localObject6;
            b localb = bZ;
            localObject3 = localObject6;
            localObject5 = localObject6;
            StringBuilder localStringBuilder = new java/lang/StringBuilder;
            localObject3 = localObject6;
            localObject5 = localObject6;
            localStringBuilder.<init>("insert content:");
            localObject3 = localObject6;
            localObject5 = localObject6;
            localb.b(str);
          }
          localObject3 = localObject6;
          localObject5 = localObject6;
          ((ContentValues)localObject7).put("content", r.q(str));
          localObject3 = localObject6;
          localObject5 = localObject6;
          ((ContentValues)localObject7).put("send_count", "0");
          localObject3 = localObject6;
          localObject5 = localObject6;
          ((ContentValues)localObject7).put("status", Integer.toString(1));
          localObject3 = localObject6;
          localObject5 = localObject6;
          ((ContentValues)localObject7).put("timestamp", Long.valueOf(locald.ad()));
          localObject3 = localObject6;
          localObject5 = localObject6;
          ((SQLiteDatabase)localObject6).insert("events", null, (ContentValues)localObject7);
          localObject3 = localObject6;
          localObject5 = localObject6;
          localIterator.remove();
        }
      }
      catch (Throwable localThrowable4)
      {
        Object localObject3;
        localObject5 = localObject3;
        bZ.b(localThrowable4);
        if (localObject3 != null) {}
        try
        {
          ((SQLiteDatabase)localObject3).endTransaction();
          aj();
          for (;;)
          {
            this.ce = false;
            if (c.k())
            {
              localObject3 = bZ;
              localObject5 = new java/lang/StringBuilder;
              ((StringBuilder)localObject5).<init>("after insert, cacheEventsInMemory.size():");
              ((b)localObject3).b(this.cd.size() + ",numEventsCachedInMemory:" + c.ay + ",numStoredEvents:" + this.aI);
            }
            break;
            localObject3 = localThrowable4;
            localObject5 = localThrowable4;
            localThrowable4.setTransactionSuccessful();
            if (localThrowable4 != null) {
              try
              {
                localThrowable4.endTransaction();
                aj();
              }
              catch (Throwable localThrowable1)
              {
                bZ.b(localThrowable1);
              }
            }
          }
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            bZ.b(localThrowable2);
          }
        }
      }
      finally
      {
        if (localObject5 == null) {}
      }
    }
    try
    {
      ((SQLiteDatabase)localObject5).endTransaction();
      aj();
      throw ((Throwable)localObject4);
    }
    catch (Throwable localThrowable3)
    {
      for (;;)
      {
        bZ.b(localThrowable3);
      }
    }
  }
  
  /* Error */
  private void an()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 54	com/tencent/wxop/stat/t:bW	Lcom/tencent/wxop/stat/ac;
    //   4: invokevirtual 140	com/tencent/wxop/stat/ac:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   7: ldc_w 529
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: aconst_null
    //   14: aconst_null
    //   15: aconst_null
    //   16: invokevirtual 148	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   19: astore_2
    //   20: aload_2
    //   21: astore_1
    //   22: aload_2
    //   23: invokeinterface 154 1 0
    //   28: ifeq +51 -> 79
    //   31: aload_2
    //   32: astore_1
    //   33: aload_0
    //   34: getfield 79	com/tencent/wxop/stat/t:cf	Ljava/util/HashMap;
    //   37: aload_2
    //   38: iconst_0
    //   39: invokeinterface 162 2 0
    //   44: aload_2
    //   45: iconst_1
    //   46: invokeinterface 162 2 0
    //   51: invokevirtual 530	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   54: pop
    //   55: goto -35 -> 20
    //   58: astore_3
    //   59: aload_2
    //   60: astore_1
    //   61: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   64: aload_3
    //   65: invokevirtual 136	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   68: aload_2
    //   69: ifnull +9 -> 78
    //   72: aload_2
    //   73: invokeinterface 190 1 0
    //   78: return
    //   79: aload_2
    //   80: ifnull -2 -> 78
    //   83: aload_2
    //   84: invokeinterface 190 1 0
    //   89: goto -11 -> 78
    //   92: astore_2
    //   93: aconst_null
    //   94: astore_1
    //   95: aload_1
    //   96: ifnull +9 -> 105
    //   99: aload_1
    //   100: invokeinterface 190 1 0
    //   105: aload_2
    //   106: athrow
    //   107: astore_2
    //   108: goto -13 -> 95
    //   111: astore_3
    //   112: aconst_null
    //   113: astore_2
    //   114: goto -55 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	t
    //   21	79	1	localCursor1	android.database.Cursor
    //   19	65	2	localCursor2	android.database.Cursor
    //   92	14	2	localObject1	Object
    //   107	1	2	localObject2	Object
    //   113	1	2	localObject3	Object
    //   58	7	3	localThrowable1	Throwable
    //   111	1	3	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   22	31	58	java/lang/Throwable
    //   33	55	58	java/lang/Throwable
    //   0	20	92	finally
    //   22	31	107	finally
    //   33	55	107	finally
    //   61	68	107	finally
    //   0	20	111	java/lang/Throwable
  }
  
  private static String b(List<ad> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramList.size() * 3);
    localStringBuilder.append("event_id in (");
    int j = paramList.size();
    paramList = paramList.iterator();
    for (int i = 0; paramList.hasNext(); i++)
    {
      localStringBuilder.append(((ad)paramList.next()).K);
      if (i != j - 1) {
        localStringBuilder.append(",");
      }
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  /* Error */
  private void b(List<ad> paramList, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: iload_3
    //   1: ifne +238 -> 239
    //   4: aload_0
    //   5: getfield 54	com/tencent/wxop/stat/t:bW	Lcom/tencent/wxop/stat/ac;
    //   8: invokevirtual 140	com/tencent/wxop/stat/ac:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   11: astore 7
    //   13: iconst_1
    //   14: invokestatic 300	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   17: astore 9
    //   19: iload_2
    //   20: invokestatic 300	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   23: astore 8
    //   25: aload 7
    //   27: ldc_w 262
    //   30: aconst_null
    //   31: ldc_w 534
    //   34: iconst_1
    //   35: anewarray 377	java/lang/String
    //   38: dup
    //   39: iconst_0
    //   40: aload 9
    //   42: aastore
    //   43: aconst_null
    //   44: aconst_null
    //   45: aconst_null
    //   46: aload 8
    //   48: invokevirtual 537	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   51: astore 7
    //   53: aload 7
    //   55: invokeinterface 154 1 0
    //   60: ifeq +191 -> 251
    //   63: aload 7
    //   65: iconst_0
    //   66: invokeinterface 541 2 0
    //   71: lstore 5
    //   73: aload 7
    //   75: iconst_1
    //   76: invokeinterface 162 2 0
    //   81: astore 9
    //   83: aload 9
    //   85: astore 8
    //   87: getstatic 543	com/tencent/wxop/stat/c:ad	Z
    //   90: ifne +10 -> 100
    //   93: aload 9
    //   95: invokestatic 544	com/tencent/wxop/stat/b/r:t	(Ljava/lang/String;)Ljava/lang/String;
    //   98: astore 8
    //   100: aload 7
    //   102: iconst_2
    //   103: invokeinterface 158 2 0
    //   108: istore_2
    //   109: aload 7
    //   111: iconst_3
    //   112: invokeinterface 158 2 0
    //   117: istore 4
    //   119: new 479	com/tencent/wxop/stat/ad
    //   122: astore 9
    //   124: aload 9
    //   126: lload 5
    //   128: aload 8
    //   130: iload_2
    //   131: iload 4
    //   133: invokespecial 547	com/tencent/wxop/stat/ad:<init>	(JLjava/lang/String;II)V
    //   136: invokestatic 198	com/tencent/wxop/stat/c:k	()Z
    //   139: ifeq +64 -> 203
    //   142: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   145: astore 8
    //   147: new 97	java/lang/StringBuilder
    //   150: astore 10
    //   152: aload 10
    //   154: ldc_w 549
    //   157: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   160: aload 8
    //   162: aload 10
    //   164: lload 5
    //   166: invokevirtual 485	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   169: ldc_w 551
    //   172: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: iload 4
    //   177: invokevirtual 203	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   180: ldc_w 553
    //   183: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: aload 7
    //   188: iconst_4
    //   189: invokeinterface 541 2 0
    //   194: invokevirtual 485	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   197: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokevirtual 208	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Object;)V
    //   203: aload_1
    //   204: aload 9
    //   206: invokeinterface 557 2 0
    //   211: pop
    //   212: goto -159 -> 53
    //   215: astore 8
    //   217: aload 7
    //   219: astore_1
    //   220: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   223: aload 8
    //   225: invokevirtual 136	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   228: aload_1
    //   229: ifnull +9 -> 238
    //   232: aload_1
    //   233: invokeinterface 190 1 0
    //   238: return
    //   239: aload_0
    //   240: getfield 56	com/tencent/wxop/stat/t:bX	Lcom/tencent/wxop/stat/ac;
    //   243: invokevirtual 140	com/tencent/wxop/stat/ac:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   246: astore 7
    //   248: goto -235 -> 13
    //   251: aload 7
    //   253: ifnull -15 -> 238
    //   256: aload 7
    //   258: invokeinterface 190 1 0
    //   263: goto -25 -> 238
    //   266: astore_1
    //   267: aconst_null
    //   268: astore 7
    //   270: aload 7
    //   272: ifnull +10 -> 282
    //   275: aload 7
    //   277: invokeinterface 190 1 0
    //   282: aload_1
    //   283: athrow
    //   284: astore_1
    //   285: goto -15 -> 270
    //   288: astore 8
    //   290: aload_1
    //   291: astore 7
    //   293: aload 8
    //   295: astore_1
    //   296: goto -26 -> 270
    //   299: astore 8
    //   301: aconst_null
    //   302: astore_1
    //   303: goto -83 -> 220
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	306	0	this	t
    //   0	306	1	paramList	List<ad>
    //   0	306	2	paramInt	int
    //   0	306	3	paramBoolean	boolean
    //   117	59	4	i	int
    //   71	94	5	l	long
    //   11	281	7	localObject1	Object
    //   23	138	8	localObject2	Object
    //   215	9	8	localThrowable1	Throwable
    //   288	6	8	localObject3	Object
    //   299	1	8	localThrowable2	Throwable
    //   17	188	9	localObject4	Object
    //   150	13	10	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   53	83	215	java/lang/Throwable
    //   87	100	215	java/lang/Throwable
    //   100	203	215	java/lang/Throwable
    //   203	212	215	java/lang/Throwable
    //   4	13	266	finally
    //   13	53	266	finally
    //   239	248	266	finally
    //   53	83	284	finally
    //   87	100	284	finally
    //   100	203	284	finally
    //   203	212	284	finally
    //   220	228	288	finally
    //   4	13	299	java/lang/Throwable
    //   13	53	299	java/lang/Throwable
    //   239	248	299	java/lang/Throwable
  }
  
  private void b(boolean paramBoolean)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        localSQLiteDatabase = c(paramBoolean);
        localObject1 = localSQLiteDatabase;
        localObject3 = localSQLiteDatabase;
        localSQLiteDatabase.beginTransaction();
        localObject1 = localSQLiteDatabase;
        localObject3 = localSQLiteDatabase;
        Object localObject4 = new android/content/ContentValues;
        localObject1 = localSQLiteDatabase;
        localObject3 = localSQLiteDatabase;
        ((ContentValues)localObject4).<init>();
        localObject1 = localSQLiteDatabase;
        localObject3 = localSQLiteDatabase;
        ((ContentValues)localObject4).put("status", Integer.valueOf(1));
        localObject1 = localSQLiteDatabase;
        localObject3 = localSQLiteDatabase;
        int i = localSQLiteDatabase.update("events", (ContentValues)localObject4, "status=?", new String[] { Long.toString(2L) });
        localObject1 = localSQLiteDatabase;
        localObject3 = localSQLiteDatabase;
        if (c.k())
        {
          localObject1 = localSQLiteDatabase;
          localObject3 = localSQLiteDatabase;
          localObject4 = bZ;
          localObject1 = localSQLiteDatabase;
          localObject3 = localSQLiteDatabase;
          StringBuilder localStringBuilder = new java/lang/StringBuilder;
          localObject1 = localSQLiteDatabase;
          localObject3 = localSQLiteDatabase;
          localStringBuilder.<init>("update ");
          localObject1 = localSQLiteDatabase;
          localObject3 = localSQLiteDatabase;
          ((b)localObject4).b(i + " unsent events.");
        }
        localObject1 = localSQLiteDatabase;
        localObject3 = localSQLiteDatabase;
        localSQLiteDatabase.setTransactionSuccessful();
      }
      catch (Throwable localThrowable4)
      {
        SQLiteDatabase localSQLiteDatabase;
        localObject3 = localThrowable1;
        bZ.b(localThrowable4);
        if (localThrowable1 == null) {
          continue;
        }
        try
        {
          localThrowable1.endTransaction();
        }
        catch (Throwable localThrowable2)
        {
          bZ.b(localThrowable2);
        }
        continue;
      }
      finally
      {
        if (localObject3 == null) {
          break label259;
        }
      }
      try
      {
        localSQLiteDatabase.endTransaction();
        return;
      }
      catch (Throwable localThrowable1)
      {
        bZ.b(localThrowable1);
      }
    }
    try
    {
      ((SQLiteDatabase)localObject3).endTransaction();
      label259:
      throw ((Throwable)localObject2);
    }
    catch (Throwable localThrowable3)
    {
      for (;;)
      {
        bZ.b(localThrowable3);
      }
    }
  }
  
  private SQLiteDatabase c(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (SQLiteDatabase localSQLiteDatabase = this.bW.getWritableDatabase();; localSQLiteDatabase = this.bX.getWritableDatabase()) {
      return localSQLiteDatabase;
    }
  }
  
  public static t s(Context paramContext)
  {
    if (cb == null) {}
    try
    {
      if (cb == null)
      {
        t localt = new com/tencent/wxop/stat/t;
        localt.<init>(paramContext);
        cb = localt;
      }
      return cb;
    }
    finally {}
  }
  
  final void H()
  {
    if (!c.l()) {}
    for (;;)
    {
      return;
      try
      {
        f localf = this.be;
        w localw = new com/tencent/wxop/stat/w;
        localw.<init>(this);
        localf.a(localw);
      }
      catch (Throwable localThrowable)
      {
        bZ.b(localThrowable);
      }
    }
  }
  
  final void b(int paramInt)
  {
    this.be.a(new ab(this, paramInt));
  }
  
  final void b(d paramd, aj paramaj, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.be != null) {
      this.be.a(new x(this, paramd, paramaj, paramBoolean1, paramBoolean2));
    }
  }
  
  final void b(ah paramah)
  {
    if (paramah == null) {}
    for (;;)
    {
      return;
      this.be.a(new y(this, paramah));
    }
  }
  
  final void b(List<ad> paramList, boolean paramBoolean)
  {
    if (this.be != null) {
      this.be.a(new u(this, paramList, paramBoolean));
    }
  }
  
  final void c(List<ad> paramList, boolean paramBoolean)
  {
    if (this.be != null) {
      this.be.a(new v(this, paramList, paramBoolean));
    }
  }
  
  public final int r()
  {
    return this.aI;
  }
  
  /* Error */
  public final com.tencent.wxop.stat.b.c t(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 68	com/tencent/wxop/stat/t:bY	Lcom/tencent/wxop/stat/b/c;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 68	com/tencent/wxop/stat/t:bY	Lcom/tencent/wxop/stat/b/c;
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_0
    //   19: getfield 54	com/tencent/wxop/stat/t:bW	Lcom/tencent/wxop/stat/ac;
    //   22: invokevirtual 260	com/tencent/wxop/stat/ac:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   25: invokevirtual 252	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   28: invokestatic 198	com/tencent/wxop/stat/c:k	()Z
    //   31: ifeq +12 -> 43
    //   34: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   37: ldc_w 599
    //   40: invokevirtual 208	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Object;)V
    //   43: aload_0
    //   44: getfield 54	com/tencent/wxop/stat/t:bW	Lcom/tencent/wxop/stat/ac;
    //   47: invokevirtual 140	com/tencent/wxop/stat/ac:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   50: ldc_w 601
    //   53: aconst_null
    //   54: aconst_null
    //   55: aconst_null
    //   56: aconst_null
    //   57: aconst_null
    //   58: aconst_null
    //   59: aconst_null
    //   60: invokevirtual 537	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   63: astore 11
    //   65: iconst_0
    //   66: istore_2
    //   67: aload 11
    //   69: invokeinterface 154 1 0
    //   74: ifeq +386 -> 460
    //   77: aload 11
    //   79: iconst_0
    //   80: invokeinterface 162 2 0
    //   85: astore 16
    //   87: aload 16
    //   89: invokestatic 544	com/tencent/wxop/stat/b/r:t	(Ljava/lang/String;)Ljava/lang/String;
    //   92: astore 12
    //   94: aload 11
    //   96: iconst_1
    //   97: invokeinterface 158 2 0
    //   102: istore 5
    //   104: aload 11
    //   106: iconst_2
    //   107: invokeinterface 162 2 0
    //   112: astore 10
    //   114: aload 11
    //   116: iconst_3
    //   117: invokeinterface 541 2 0
    //   122: lstore 6
    //   124: invokestatic 606	java/lang/System:currentTimeMillis	()J
    //   127: ldc2_w 607
    //   130: ldiv
    //   131: lstore 8
    //   133: iload 5
    //   135: iconst_1
    //   136: if_icmpeq +785 -> 921
    //   139: lload 6
    //   141: ldc2_w 607
    //   144: lmul
    //   145: invokestatic 610	com/tencent/wxop/stat/b/l:d	(J)Ljava/lang/String;
    //   148: ldc2_w 607
    //   151: lload 8
    //   153: lmul
    //   154: invokestatic 610	com/tencent/wxop/stat/b/l:d	(J)Ljava/lang/String;
    //   157: invokevirtual 613	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   160: ifne +761 -> 921
    //   163: iconst_1
    //   164: istore_2
    //   165: aload 10
    //   167: aload_1
    //   168: invokestatic 616	com/tencent/wxop/stat/b/l:G	(Landroid/content/Context;)Ljava/lang/String;
    //   171: invokevirtual 613	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   174: ifne +742 -> 916
    //   177: iload_2
    //   178: iconst_2
    //   179: ior
    //   180: istore_3
    //   181: aload 12
    //   183: ldc_w 487
    //   186: invokevirtual 620	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   189: astore 14
    //   191: iconst_0
    //   192: istore 4
    //   194: iconst_0
    //   195: istore_2
    //   196: aload 14
    //   198: ifnull +465 -> 663
    //   201: aload 14
    //   203: arraylength
    //   204: ifle +459 -> 663
    //   207: aload 14
    //   209: iconst_0
    //   210: aaload
    //   211: astore 10
    //   213: aload 10
    //   215: ifnull +13 -> 228
    //   218: aload 10
    //   220: invokevirtual 623	java/lang/String:length	()I
    //   223: bipush 11
    //   225: if_icmpge +673 -> 898
    //   228: aload_1
    //   229: invokestatic 625	com/tencent/wxop/stat/b/r:b	(Landroid/content/Context;)Ljava/lang/String;
    //   232: astore 13
    //   234: aload 13
    //   236: ifnull +659 -> 895
    //   239: aload 13
    //   241: invokevirtual 623	java/lang/String:length	()I
    //   244: bipush 10
    //   246: if_icmple +649 -> 895
    //   249: iconst_1
    //   250: istore_2
    //   251: aload 13
    //   253: astore 10
    //   255: aload 12
    //   257: astore 13
    //   259: aload 10
    //   261: astore 12
    //   263: aload 13
    //   265: astore 10
    //   267: aload 14
    //   269: ifnull +409 -> 678
    //   272: aload 14
    //   274: arraylength
    //   275: iconst_2
    //   276: if_icmplt +402 -> 678
    //   279: aload 14
    //   281: iconst_1
    //   282: aaload
    //   283: astore 14
    //   285: new 97	java/lang/StringBuilder
    //   288: astore 10
    //   290: aload 10
    //   292: invokespecial 626	java/lang/StringBuilder:<init>	()V
    //   295: aload 10
    //   297: aload 12
    //   299: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: ldc_w 487
    //   305: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: aload 14
    //   310: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: astore 13
    //   318: iload_2
    //   319: istore 4
    //   321: new 628	com/tencent/wxop/stat/b/c
    //   324: astore 10
    //   326: aload 10
    //   328: aload 12
    //   330: aload 14
    //   332: iload_3
    //   333: invokespecial 631	com/tencent/wxop/stat/b/c:<init>	(Ljava/lang/String;Ljava/lang/String;I)V
    //   336: aload_0
    //   337: aload 10
    //   339: putfield 68	com/tencent/wxop/stat/t:bY	Lcom/tencent/wxop/stat/b/c;
    //   342: new 270	android/content/ContentValues
    //   345: astore 10
    //   347: aload 10
    //   349: invokespecial 271	android/content/ContentValues:<init>	()V
    //   352: aload 10
    //   354: ldc_w 633
    //   357: aload 13
    //   359: invokestatic 286	com/tencent/wxop/stat/b/r:q	(Ljava/lang/String;)Ljava/lang/String;
    //   362: invokevirtual 290	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   365: aload 10
    //   367: ldc_w 635
    //   370: iload_3
    //   371: invokestatic 370	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   374: invokevirtual 373	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   377: aload 10
    //   379: ldc_w 637
    //   382: aload_1
    //   383: invokestatic 616	com/tencent/wxop/stat/b/l:G	(Landroid/content/Context;)Ljava/lang/String;
    //   386: invokevirtual 290	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   389: aload 10
    //   391: ldc_w 639
    //   394: lload 8
    //   396: invokestatic 312	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   399: invokevirtual 315	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   402: iload 4
    //   404: ifeq +31 -> 435
    //   407: aload_0
    //   408: getfield 54	com/tencent/wxop/stat/t:bW	Lcom/tencent/wxop/stat/ac;
    //   411: invokevirtual 260	com/tencent/wxop/stat/ac:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   414: ldc_w 601
    //   417: aload 10
    //   419: ldc_w 641
    //   422: iconst_1
    //   423: anewarray 377	java/lang/String
    //   426: dup
    //   427: iconst_0
    //   428: aload 16
    //   430: aastore
    //   431: invokevirtual 381	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   434: pop
    //   435: iload_3
    //   436: iload 5
    //   438: if_icmpeq +20 -> 458
    //   441: aload_0
    //   442: getfield 54	com/tencent/wxop/stat/t:bW	Lcom/tencent/wxop/stat/ac;
    //   445: invokevirtual 260	com/tencent/wxop/stat/ac:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   448: ldc_w 601
    //   451: aconst_null
    //   452: aload 10
    //   454: invokevirtual 644	android/database/sqlite/SQLiteDatabase:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   457: pop2
    //   458: iconst_1
    //   459: istore_2
    //   460: iload_2
    //   461: ifne +162 -> 623
    //   464: aload_1
    //   465: invokestatic 646	com/tencent/wxop/stat/b/l:c	(Landroid/content/Context;)Ljava/lang/String;
    //   468: astore 12
    //   470: aload_1
    //   471: invokestatic 649	com/tencent/wxop/stat/b/l:w	(Landroid/content/Context;)Ljava/lang/String;
    //   474: astore 13
    //   476: aload 13
    //   478: ifnull +410 -> 888
    //   481: aload 13
    //   483: invokevirtual 623	java/lang/String:length	()I
    //   486: ifle +402 -> 888
    //   489: new 97	java/lang/StringBuilder
    //   492: astore 10
    //   494: aload 10
    //   496: invokespecial 626	java/lang/StringBuilder:<init>	()V
    //   499: aload 10
    //   501: aload 12
    //   503: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: ldc_w 487
    //   509: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: aload 13
    //   514: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   520: astore 10
    //   522: invokestatic 606	java/lang/System:currentTimeMillis	()J
    //   525: ldc2_w 607
    //   528: ldiv
    //   529: lstore 6
    //   531: aload_1
    //   532: invokestatic 616	com/tencent/wxop/stat/b/l:G	(Landroid/content/Context;)Ljava/lang/String;
    //   535: astore 14
    //   537: new 270	android/content/ContentValues
    //   540: astore_1
    //   541: aload_1
    //   542: invokespecial 271	android/content/ContentValues:<init>	()V
    //   545: aload_1
    //   546: ldc_w 633
    //   549: aload 10
    //   551: invokestatic 286	com/tencent/wxop/stat/b/r:q	(Ljava/lang/String;)Ljava/lang/String;
    //   554: invokevirtual 290	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   557: aload_1
    //   558: ldc_w 635
    //   561: iconst_0
    //   562: invokestatic 370	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   565: invokevirtual 373	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   568: aload_1
    //   569: ldc_w 637
    //   572: aload 14
    //   574: invokevirtual 290	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   577: aload_1
    //   578: ldc_w 639
    //   581: lload 6
    //   583: invokestatic 312	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   586: invokevirtual 315	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   589: aload_0
    //   590: getfield 54	com/tencent/wxop/stat/t:bW	Lcom/tencent/wxop/stat/ac;
    //   593: invokevirtual 260	com/tencent/wxop/stat/ac:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   596: ldc_w 601
    //   599: aconst_null
    //   600: aload_1
    //   601: invokevirtual 319	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   604: pop2
    //   605: new 628	com/tencent/wxop/stat/b/c
    //   608: astore_1
    //   609: aload_1
    //   610: aload 12
    //   612: aload 13
    //   614: iconst_0
    //   615: invokespecial 631	com/tencent/wxop/stat/b/c:<init>	(Ljava/lang/String;Ljava/lang/String;I)V
    //   618: aload_0
    //   619: aload_1
    //   620: putfield 68	com/tencent/wxop/stat/t:bY	Lcom/tencent/wxop/stat/b/c;
    //   623: aload_0
    //   624: getfield 54	com/tencent/wxop/stat/t:bW	Lcom/tencent/wxop/stat/ac;
    //   627: invokevirtual 260	com/tencent/wxop/stat/ac:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   630: invokevirtual 322	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   633: aload 11
    //   635: ifnull +10 -> 645
    //   638: aload 11
    //   640: invokeinterface 190 1 0
    //   645: aload_0
    //   646: getfield 54	com/tencent/wxop/stat/t:bW	Lcom/tencent/wxop/stat/ac;
    //   649: invokevirtual 260	com/tencent/wxop/stat/ac:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   652: invokevirtual 325	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   655: aload_0
    //   656: getfield 68	com/tencent/wxop/stat/t:bY	Lcom/tencent/wxop/stat/b/c;
    //   659: astore_1
    //   660: goto -646 -> 14
    //   663: aload_1
    //   664: invokestatic 646	com/tencent/wxop/stat/b/l:c	(Landroid/content/Context;)Ljava/lang/String;
    //   667: astore 10
    //   669: iconst_1
    //   670: istore_2
    //   671: aload 10
    //   673: astore 12
    //   675: goto -408 -> 267
    //   678: aload_1
    //   679: invokestatic 649	com/tencent/wxop/stat/b/l:w	(Landroid/content/Context;)Ljava/lang/String;
    //   682: astore 15
    //   684: iload_2
    //   685: istore 4
    //   687: aload 15
    //   689: astore 14
    //   691: aload 10
    //   693: astore 13
    //   695: aload 15
    //   697: ifnull -376 -> 321
    //   700: iload_2
    //   701: istore 4
    //   703: aload 15
    //   705: astore 14
    //   707: aload 10
    //   709: astore 13
    //   711: aload 15
    //   713: invokevirtual 623	java/lang/String:length	()I
    //   716: ifle -395 -> 321
    //   719: new 97	java/lang/StringBuilder
    //   722: astore 10
    //   724: aload 10
    //   726: invokespecial 626	java/lang/StringBuilder:<init>	()V
    //   729: aload 10
    //   731: aload 12
    //   733: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   736: ldc_w 487
    //   739: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   742: aload 15
    //   744: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   750: astore 13
    //   752: iconst_1
    //   753: istore 4
    //   755: aload 15
    //   757: astore 14
    //   759: goto -438 -> 321
    //   762: astore_1
    //   763: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   766: aload_1
    //   767: invokevirtual 136	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   770: goto -115 -> 655
    //   773: astore_1
    //   774: aload_0
    //   775: monitorexit
    //   776: aload_1
    //   777: athrow
    //   778: astore 10
    //   780: aconst_null
    //   781: astore_1
    //   782: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   785: aload 10
    //   787: invokevirtual 136	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   790: aload_1
    //   791: ifnull +9 -> 800
    //   794: aload_1
    //   795: invokeinterface 190 1 0
    //   800: aload_0
    //   801: getfield 54	com/tencent/wxop/stat/t:bW	Lcom/tencent/wxop/stat/ac;
    //   804: invokevirtual 260	com/tencent/wxop/stat/ac:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   807: invokevirtual 325	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   810: goto -155 -> 655
    //   813: astore_1
    //   814: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   817: aload_1
    //   818: invokevirtual 136	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   821: goto -166 -> 655
    //   824: astore_1
    //   825: aconst_null
    //   826: astore 11
    //   828: aload 11
    //   830: ifnull +10 -> 840
    //   833: aload 11
    //   835: invokeinterface 190 1 0
    //   840: aload_0
    //   841: getfield 54	com/tencent/wxop/stat/t:bW	Lcom/tencent/wxop/stat/ac;
    //   844: invokevirtual 260	com/tencent/wxop/stat/ac:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   847: invokevirtual 325	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   850: aload_1
    //   851: athrow
    //   852: astore 10
    //   854: getstatic 41	com/tencent/wxop/stat/t:bZ	Lcom/tencent/wxop/stat/b/b;
    //   857: aload 10
    //   859: invokevirtual 136	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   862: goto -12 -> 850
    //   865: astore_1
    //   866: goto -38 -> 828
    //   869: astore 10
    //   871: aload_1
    //   872: astore 11
    //   874: aload 10
    //   876: astore_1
    //   877: goto -49 -> 828
    //   880: astore 10
    //   882: aload 11
    //   884: astore_1
    //   885: goto -103 -> 782
    //   888: aload 12
    //   890: astore 10
    //   892: goto -370 -> 522
    //   895: goto -640 -> 255
    //   898: aload 10
    //   900: astore 13
    //   902: iload 4
    //   904: istore_2
    //   905: aload 12
    //   907: astore 10
    //   909: aload 13
    //   911: astore 12
    //   913: goto -646 -> 267
    //   916: iload_2
    //   917: istore_3
    //   918: goto -737 -> 181
    //   921: iload 5
    //   923: istore_2
    //   924: goto -759 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	927	0	this	t
    //   0	927	1	paramContext	Context
    //   66	858	2	i	int
    //   180	738	3	j	int
    //   192	711	4	k	int
    //   102	820	5	m	int
    //   122	460	6	l1	long
    //   131	264	8	l2	long
    //   112	618	10	localObject1	Object
    //   778	8	10	localThrowable1	Throwable
    //   852	6	10	localThrowable2	Throwable
    //   869	6	10	localObject2	Object
    //   880	1	10	localThrowable3	Throwable
    //   890	18	10	localObject3	Object
    //   63	820	11	localObject4	Object
    //   92	820	12	localObject5	Object
    //   232	678	13	localObject6	Object
    //   189	569	14	localObject7	Object
    //   682	74	15	str1	String
    //   85	344	16	str2	String
    // Exception table:
    //   from	to	target	type
    //   638	645	762	java/lang/Throwable
    //   645	655	762	java/lang/Throwable
    //   2	14	773	finally
    //   638	645	773	finally
    //   645	655	773	finally
    //   655	660	773	finally
    //   763	770	773	finally
    //   794	800	773	finally
    //   800	810	773	finally
    //   814	821	773	finally
    //   833	840	773	finally
    //   840	850	773	finally
    //   850	852	773	finally
    //   854	862	773	finally
    //   18	43	778	java/lang/Throwable
    //   43	65	778	java/lang/Throwable
    //   794	800	813	java/lang/Throwable
    //   800	810	813	java/lang/Throwable
    //   18	43	824	finally
    //   43	65	824	finally
    //   833	840	852	java/lang/Throwable
    //   840	850	852	java/lang/Throwable
    //   67	133	865	finally
    //   139	163	865	finally
    //   165	177	865	finally
    //   181	191	865	finally
    //   201	207	865	finally
    //   218	228	865	finally
    //   228	234	865	finally
    //   239	249	865	finally
    //   272	279	865	finally
    //   285	318	865	finally
    //   321	402	865	finally
    //   407	435	865	finally
    //   441	458	865	finally
    //   464	476	865	finally
    //   481	522	865	finally
    //   522	623	865	finally
    //   623	633	865	finally
    //   663	669	865	finally
    //   678	684	865	finally
    //   711	752	865	finally
    //   782	790	869	finally
    //   67	133	880	java/lang/Throwable
    //   139	163	880	java/lang/Throwable
    //   165	177	880	java/lang/Throwable
    //   181	191	880	java/lang/Throwable
    //   201	207	880	java/lang/Throwable
    //   218	228	880	java/lang/Throwable
    //   228	234	880	java/lang/Throwable
    //   239	249	880	java/lang/Throwable
    //   272	279	880	java/lang/Throwable
    //   285	318	880	java/lang/Throwable
    //   321	402	880	java/lang/Throwable
    //   407	435	880	java/lang/Throwable
    //   441	458	880	java/lang/Throwable
    //   464	476	880	java/lang/Throwable
    //   481	522	880	java/lang/Throwable
    //   522	623	880	java/lang/Throwable
    //   623	633	880	java/lang/Throwable
    //   663	669	880	java/lang/Throwable
    //   678	684	880	java/lang/Throwable
    //   711	752	880	java/lang/Throwable
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/wxop/stat/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */