package com.lantern.traffic.monitor.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class a
{
  private static a f;
  private b a = null;
  private SQLiteDatabase b;
  private SQLiteDatabase c;
  private Context d;
  private Lock e;
  
  private a(Context paramContext)
  {
    this.d = paramContext;
    this.a = b.a(paramContext);
    this.e = new ReentrantLock();
  }
  
  private SQLiteDatabase a(boolean paramBoolean)
  {
    if ((this.a == null) && (this.d != null)) {
      this.a = b.a(this.d);
    }
    this.e.lock();
    if (paramBoolean) {}
    for (SQLiteDatabase localSQLiteDatabase = this.a.getWritableDatabase();; localSQLiteDatabase = this.a.getReadableDatabase()) {
      return localSQLiteDatabase;
    }
  }
  
  public static final a a(Context paramContext)
  {
    if (f == null) {
      f = new a(paramContext.getApplicationContext());
    }
    return f;
  }
  
  /* Error */
  public final com.lantern.traffic.monitor.c.b a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: iconst_0
    //   3: invokespecial 64	com/lantern/traffic/monitor/b/a:a	(Z)Landroid/database/sqlite/SQLiteDatabase;
    //   6: putfield 66	com/lantern/traffic/monitor/b/a:c	Landroid/database/sqlite/SQLiteDatabase;
    //   9: new 68	com/lantern/traffic/monitor/c/b
    //   12: astore_3
    //   13: aload_3
    //   14: invokespecial 69	com/lantern/traffic/monitor/c/b:<init>	()V
    //   17: aload_0
    //   18: getfield 66	com/lantern/traffic/monitor/b/a:c	Landroid/database/sqlite/SQLiteDatabase;
    //   21: astore 4
    //   23: new 71	java/lang/StringBuilder
    //   26: astore 5
    //   28: aload 5
    //   30: ldc 73
    //   32: invokespecial 76	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   35: aload 4
    //   37: ldc 78
    //   39: aconst_null
    //   40: aload 5
    //   42: aload_1
    //   43: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: ldc 84
    //   48: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: aconst_null
    //   55: aconst_null
    //   56: aconst_null
    //   57: ldc 90
    //   59: ldc 92
    //   61: invokevirtual 98	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   64: astore 4
    //   66: aload 4
    //   68: invokeinterface 104 1 0
    //   73: astore_1
    //   74: aload 4
    //   76: invokeinterface 108 1 0
    //   81: ifeq +142 -> 223
    //   84: iconst_0
    //   85: istore_2
    //   86: iload_2
    //   87: aload 4
    //   89: invokeinterface 112 1 0
    //   94: if_icmpge -20 -> 74
    //   97: aload_1
    //   98: iload_2
    //   99: aaload
    //   100: ldc 114
    //   102: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   105: ifne +26 -> 131
    //   108: aload_1
    //   109: iload_2
    //   110: aaload
    //   111: ldc 122
    //   113: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   116: ifeq +21 -> 137
    //   119: aload_3
    //   120: aload 4
    //   122: iload_2
    //   123: invokeinterface 126 2 0
    //   128: invokevirtual 129	com/lantern/traffic/monitor/c/b:a	(J)V
    //   131: iinc 2 1
    //   134: goto -48 -> 86
    //   137: aload_1
    //   138: iload_2
    //   139: aaload
    //   140: ldc -125
    //   142: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   145: ifeq +40 -> 185
    //   148: aload_3
    //   149: aload 4
    //   151: iload_2
    //   152: invokeinterface 126 2 0
    //   157: invokevirtual 133	com/lantern/traffic/monitor/c/b:b	(J)V
    //   160: goto -29 -> 131
    //   163: astore 4
    //   165: aload_3
    //   166: astore_1
    //   167: aload 4
    //   169: astore_3
    //   170: aload_3
    //   171: invokevirtual 136	java/lang/Exception:printStackTrace	()V
    //   174: aload_0
    //   175: getfield 34	com/lantern/traffic/monitor/b/a:e	Ljava/util/concurrent/locks/Lock;
    //   178: invokeinterface 139 1 0
    //   183: aload_1
    //   184: areturn
    //   185: aload_1
    //   186: iload_2
    //   187: aaload
    //   188: ldc -115
    //   190: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   193: ifeq -62 -> 131
    //   196: aload_3
    //   197: aload 4
    //   199: iload_2
    //   200: invokeinterface 126 2 0
    //   205: invokevirtual 143	com/lantern/traffic/monitor/c/b:c	(J)V
    //   208: goto -77 -> 131
    //   211: astore_1
    //   212: aload_0
    //   213: getfield 34	com/lantern/traffic/monitor/b/a:e	Ljava/util/concurrent/locks/Lock;
    //   216: invokeinterface 139 1 0
    //   221: aload_1
    //   222: athrow
    //   223: aload 4
    //   225: ifnull +20 -> 245
    //   228: aload 4
    //   230: invokeinterface 146 1 0
    //   235: ifne +10 -> 245
    //   238: aload 4
    //   240: invokeinterface 149 1 0
    //   245: aload_0
    //   246: getfield 34	com/lantern/traffic/monitor/b/a:e	Ljava/util/concurrent/locks/Lock;
    //   249: invokeinterface 139 1 0
    //   254: aload_3
    //   255: astore_1
    //   256: goto -73 -> 183
    //   259: astore_3
    //   260: aconst_null
    //   261: astore_1
    //   262: goto -92 -> 170
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	this	a
    //   0	265	1	paramString	String
    //   85	115	2	i	int
    //   12	243	3	localObject1	Object
    //   259	1	3	localException1	Exception
    //   21	129	4	localObject2	Object
    //   163	76	4	localException2	Exception
    //   26	15	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   17	74	163	java/lang/Exception
    //   74	84	163	java/lang/Exception
    //   86	131	163	java/lang/Exception
    //   137	160	163	java/lang/Exception
    //   185	208	163	java/lang/Exception
    //   228	245	163	java/lang/Exception
    //   0	17	211	finally
    //   17	74	211	finally
    //   74	84	211	finally
    //   86	131	211	finally
    //   137	160	211	finally
    //   170	174	211	finally
    //   185	208	211	finally
    //   228	245	211	finally
    //   0	17	259	java/lang/Exception
  }
  
  public final boolean a()
  {
    bool = true;
    try
    {
      this.b = a(true);
      this.b.execSQL("DELETE  FROM TRBLACKINFO");
    }
    catch (SQLException localSQLException)
    {
      for (;;)
      {
        localSQLException.printStackTrace();
        bool = false;
        this.e.unlock();
      }
    }
    finally
    {
      this.e.unlock();
    }
    return bool;
  }
  
  public final boolean a(int paramInt)
  {
    bool = true;
    try
    {
      this.b = a(true);
      ContentValues localContentValues = new android/content/ContentValues;
      localContentValues.<init>();
      localContentValues.put("NOTETTYPE", Integer.valueOf(paramInt));
      this.b.update("TRBLACKINFO", localContentValues, "NOTETTYPE = ?", new String[] { String.valueOf(paramInt) });
    }
    catch (SQLException localSQLException)
    {
      for (;;)
      {
        localSQLException.printStackTrace();
        this.e.unlock();
        bool = false;
      }
    }
    finally
    {
      this.e.unlock();
    }
    return bool;
  }
  
  public final boolean a(ContentValues paramContentValues)
  {
    for (boolean bool = true;; bool = false) {
      try
      {
        this.b = a(true);
        this.b.beginTransaction();
        if (this.b.insert("TRBLACKINFO", null, paramContentValues) != -1L)
        {
          this.b.setTransactionSuccessful();
          return bool;
        }
      }
      finally
      {
        this.b.endTransaction();
        this.e.unlock();
      }
    }
  }
  
  public final boolean a(String paramString, int paramInt, long paramLong)
  {
    bool = true;
    try
    {
      this.b = a(true);
      ContentValues localContentValues = new android/content/ContentValues;
      localContentValues.<init>();
      localContentValues.put("SHOWTIMES", Integer.valueOf(paramInt));
      localContentValues.put("NOTETIME", Long.valueOf(paramLong));
      this.b.update("TRBLACKINFO", localContentValues, "PACKAGENAME = ?", new String[] { paramString });
    }
    catch (SQLException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        this.e.unlock();
        bool = false;
      }
    }
    finally
    {
      this.e.unlock();
    }
    return bool;
  }
  
  public final boolean a(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    bool = true;
    try
    {
      this.b = a(true);
      ContentValues localContentValues = new android/content/ContentValues;
      localContentValues.<init>();
      localContentValues.put("CNOTETR", Long.valueOf(paramLong1));
      localContentValues.put("APPNAME", paramString2);
      localContentValues.put("USETIME", Long.valueOf(paramLong2));
      this.b.update("TRBLACKINFO", localContentValues, "PACKAGENAME = ?", new String[] { paramString1 });
    }
    catch (SQLException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
        this.e.unlock();
        bool = false;
      }
    }
    finally
    {
      this.e.unlock();
    }
    return bool;
  }
  
  /* Error */
  public final java.util.List<com.lantern.traffic.monitor.c.a> b()
  {
    // Byte code:
    //   0: new 230	java/util/ArrayList
    //   3: astore_2
    //   4: aload_2
    //   5: invokespecial 231	java/util/ArrayList:<init>	()V
    //   8: aload_0
    //   9: aload_0
    //   10: iconst_0
    //   11: invokespecial 64	com/lantern/traffic/monitor/b/a:a	(Z)Landroid/database/sqlite/SQLiteDatabase;
    //   14: putfield 66	com/lantern/traffic/monitor/b/a:c	Landroid/database/sqlite/SQLiteDatabase;
    //   17: aload_0
    //   18: getfield 66	com/lantern/traffic/monitor/b/a:c	Landroid/database/sqlite/SQLiteDatabase;
    //   21: ldc -23
    //   23: aconst_null
    //   24: invokevirtual 237	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   27: astore 4
    //   29: aload 4
    //   31: invokeinterface 104 1 0
    //   36: astore_3
    //   37: aload 4
    //   39: invokeinterface 108 1 0
    //   44: ifeq +395 -> 439
    //   47: new 239	com/lantern/traffic/monitor/c/a
    //   50: astore 5
    //   52: aload 5
    //   54: invokespecial 240	com/lantern/traffic/monitor/c/a:<init>	()V
    //   57: iconst_0
    //   58: istore_1
    //   59: iload_1
    //   60: aload 4
    //   62: invokeinterface 112 1 0
    //   67: if_icmpge +360 -> 427
    //   70: aload_3
    //   71: iload_1
    //   72: aaload
    //   73: ldc 114
    //   75: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   78: ifeq +22 -> 100
    //   81: aload 5
    //   83: aload 4
    //   85: iload_1
    //   86: invokeinterface 243 2 0
    //   91: invokevirtual 245	com/lantern/traffic/monitor/c/a:b	(Ljava/lang/String;)V
    //   94: iinc 1 1
    //   97: goto -38 -> 59
    //   100: aload_3
    //   101: iload_1
    //   102: aaload
    //   103: ldc -9
    //   105: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   108: ifeq +35 -> 143
    //   111: aload 5
    //   113: aload 4
    //   115: iload_1
    //   116: invokeinterface 126 2 0
    //   121: invokevirtual 248	com/lantern/traffic/monitor/c/a:a	(J)V
    //   124: goto -30 -> 94
    //   127: astore_3
    //   128: aload_3
    //   129: invokevirtual 136	java/lang/Exception:printStackTrace	()V
    //   132: aload_0
    //   133: getfield 34	com/lantern/traffic/monitor/b/a:e	Ljava/util/concurrent/locks/Lock;
    //   136: invokeinterface 139 1 0
    //   141: aload_2
    //   142: areturn
    //   143: aload_3
    //   144: iload_1
    //   145: aaload
    //   146: ldc -6
    //   148: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   151: ifeq +31 -> 182
    //   154: aload 5
    //   156: aload 4
    //   158: iload_1
    //   159: invokeinterface 126 2 0
    //   164: invokevirtual 251	com/lantern/traffic/monitor/c/a:b	(J)V
    //   167: goto -73 -> 94
    //   170: astore_2
    //   171: aload_0
    //   172: getfield 34	com/lantern/traffic/monitor/b/a:e	Ljava/util/concurrent/locks/Lock;
    //   175: invokeinterface 139 1 0
    //   180: aload_2
    //   181: athrow
    //   182: aload_3
    //   183: iload_1
    //   184: aaload
    //   185: ldc -3
    //   187: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   190: ifeq +19 -> 209
    //   193: aload 5
    //   195: aload 4
    //   197: iload_1
    //   198: invokeinterface 126 2 0
    //   203: invokevirtual 255	com/lantern/traffic/monitor/c/a:d	(J)V
    //   206: goto -112 -> 94
    //   209: aload_3
    //   210: iload_1
    //   211: aaload
    //   212: ldc -49
    //   214: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   217: ifeq +19 -> 236
    //   220: aload 5
    //   222: aload 4
    //   224: iload_1
    //   225: invokeinterface 126 2 0
    //   230: invokevirtual 256	com/lantern/traffic/monitor/c/a:c	(J)V
    //   233: goto -139 -> 94
    //   236: aload_3
    //   237: iload_1
    //   238: aaload
    //   239: ldc -36
    //   241: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   244: ifeq +19 -> 263
    //   247: aload 5
    //   249: aload 4
    //   251: iload_1
    //   252: invokeinterface 126 2 0
    //   257: invokevirtual 258	com/lantern/traffic/monitor/c/a:e	(J)V
    //   260: goto -166 -> 94
    //   263: aload_3
    //   264: iload_1
    //   265: aaload
    //   266: ldc -34
    //   268: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   271: ifeq +19 -> 290
    //   274: aload 5
    //   276: aload 4
    //   278: iload_1
    //   279: invokeinterface 243 2 0
    //   284: invokevirtual 260	com/lantern/traffic/monitor/c/a:a	(Ljava/lang/String;)V
    //   287: goto -193 -> 94
    //   290: aload_3
    //   291: iload_1
    //   292: aaload
    //   293: ldc_w 262
    //   296: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   299: ifeq +19 -> 318
    //   302: aload 5
    //   304: aload 4
    //   306: iload_1
    //   307: invokeinterface 266 2 0
    //   312: invokevirtual 269	com/lantern/traffic/monitor/c/a:a	(I)V
    //   315: goto -221 -> 94
    //   318: aload_3
    //   319: iload_1
    //   320: aaload
    //   321: ldc -51
    //   323: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   326: ifeq +19 -> 345
    //   329: aload 5
    //   331: aload 4
    //   333: iload_1
    //   334: invokeinterface 266 2 0
    //   339: invokevirtual 271	com/lantern/traffic/monitor/c/a:b	(I)V
    //   342: goto -248 -> 94
    //   345: aload_3
    //   346: iload_1
    //   347: aaload
    //   348: ldc_w 273
    //   351: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   354: ifeq +19 -> 373
    //   357: aload 5
    //   359: aload 4
    //   361: iload_1
    //   362: invokeinterface 126 2 0
    //   367: invokevirtual 275	com/lantern/traffic/monitor/c/a:f	(J)V
    //   370: goto -276 -> 94
    //   373: aload_3
    //   374: iload_1
    //   375: aaload
    //   376: ldc -91
    //   378: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   381: ifeq +19 -> 400
    //   384: aload 5
    //   386: aload 4
    //   388: iload_1
    //   389: invokeinterface 266 2 0
    //   394: invokevirtual 277	com/lantern/traffic/monitor/c/a:c	(I)V
    //   397: goto -303 -> 94
    //   400: aload_3
    //   401: iload_1
    //   402: aaload
    //   403: ldc -29
    //   405: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   408: ifeq -314 -> 94
    //   411: aload 5
    //   413: aload 4
    //   415: iload_1
    //   416: invokeinterface 126 2 0
    //   421: invokevirtual 280	com/lantern/traffic/monitor/c/a:g	(J)V
    //   424: goto -330 -> 94
    //   427: aload_2
    //   428: aload 5
    //   430: invokeinterface 285 2 0
    //   435: pop
    //   436: goto -399 -> 37
    //   439: aload 4
    //   441: ifnull +20 -> 461
    //   444: aload 4
    //   446: invokeinterface 146 1 0
    //   451: ifne +10 -> 461
    //   454: aload 4
    //   456: invokeinterface 149 1 0
    //   461: aload_0
    //   462: getfield 34	com/lantern/traffic/monitor/b/a:e	Ljava/util/concurrent/locks/Lock;
    //   465: invokeinterface 139 1 0
    //   470: goto -329 -> 141
    //   473: astore_3
    //   474: aconst_null
    //   475: astore_2
    //   476: goto -348 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	479	0	this	a
    //   58	358	1	i	int
    //   3	139	2	localArrayList	java.util.ArrayList
    //   170	258	2	localObject1	Object
    //   475	1	2	localObject2	Object
    //   36	65	3	arrayOfString	String[]
    //   127	274	3	localException1	Exception
    //   473	1	3	localException2	Exception
    //   27	428	4	localCursor	android.database.Cursor
    //   50	379	5	locala	com.lantern.traffic.monitor.c.a
    // Exception table:
    //   from	to	target	type
    //   8	37	127	java/lang/Exception
    //   37	57	127	java/lang/Exception
    //   59	94	127	java/lang/Exception
    //   100	124	127	java/lang/Exception
    //   143	167	127	java/lang/Exception
    //   182	206	127	java/lang/Exception
    //   209	233	127	java/lang/Exception
    //   236	260	127	java/lang/Exception
    //   263	287	127	java/lang/Exception
    //   290	315	127	java/lang/Exception
    //   318	342	127	java/lang/Exception
    //   345	370	127	java/lang/Exception
    //   373	397	127	java/lang/Exception
    //   400	424	127	java/lang/Exception
    //   427	436	127	java/lang/Exception
    //   444	461	127	java/lang/Exception
    //   0	8	170	finally
    //   8	37	170	finally
    //   37	57	170	finally
    //   59	94	170	finally
    //   100	124	170	finally
    //   128	132	170	finally
    //   143	167	170	finally
    //   182	206	170	finally
    //   209	233	170	finally
    //   236	260	170	finally
    //   263	287	170	finally
    //   290	315	170	finally
    //   318	342	170	finally
    //   345	370	170	finally
    //   373	397	170	finally
    //   400	424	170	finally
    //   427	436	170	finally
    //   444	461	170	finally
    //   0	8	473	java/lang/Exception
  }
  
  public final boolean b(ContentValues paramContentValues)
  {
    for (boolean bool = true;; bool = false) {
      try
      {
        this.b = a(true);
        this.b.beginTransaction();
        if (this.b.insert("TRAFFICINFO", null, paramContentValues) != -1L)
        {
          this.b.setTransactionSuccessful();
          return bool;
        }
      }
      finally
      {
        this.b.endTransaction();
        this.e.unlock();
      }
    }
  }
  
  public final boolean b(String paramString)
  {
    bool = true;
    try
    {
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>("DELETE  FROM TRBLACKINFO WHERE PACKAGENAME ='");
      paramString = paramString + "'";
      this.b = a(true);
      this.b.execSQL(paramString);
    }
    catch (SQLException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        bool = false;
        this.e.unlock();
      }
    }
    finally
    {
      this.e.unlock();
    }
    return bool;
  }
  
  /* Error */
  public final java.util.List<com.lantern.traffic.monitor.c.a> c()
  {
    // Byte code:
    //   0: new 230	java/util/ArrayList
    //   3: astore_2
    //   4: aload_2
    //   5: invokespecial 231	java/util/ArrayList:<init>	()V
    //   8: aload_0
    //   9: aload_0
    //   10: iconst_0
    //   11: invokespecial 64	com/lantern/traffic/monitor/b/a:a	(Z)Landroid/database/sqlite/SQLiteDatabase;
    //   14: putfield 66	com/lantern/traffic/monitor/b/a:c	Landroid/database/sqlite/SQLiteDatabase;
    //   17: aload_0
    //   18: getfield 66	com/lantern/traffic/monitor/b/a:c	Landroid/database/sqlite/SQLiteDatabase;
    //   21: ldc_w 292
    //   24: aconst_null
    //   25: invokevirtual 237	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   28: astore_3
    //   29: aload_3
    //   30: invokeinterface 104 1 0
    //   35: astore 5
    //   37: aload_3
    //   38: invokeinterface 108 1 0
    //   43: ifeq +390 -> 433
    //   46: new 239	com/lantern/traffic/monitor/c/a
    //   49: astore 4
    //   51: aload 4
    //   53: invokespecial 240	com/lantern/traffic/monitor/c/a:<init>	()V
    //   56: iconst_0
    //   57: istore_1
    //   58: iload_1
    //   59: aload_3
    //   60: invokeinterface 112 1 0
    //   65: if_icmpge +356 -> 421
    //   68: aload 5
    //   70: iload_1
    //   71: aaload
    //   72: ldc 114
    //   74: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   77: ifeq +21 -> 98
    //   80: aload 4
    //   82: aload_3
    //   83: iload_1
    //   84: invokeinterface 243 2 0
    //   89: invokevirtual 245	com/lantern/traffic/monitor/c/a:b	(Ljava/lang/String;)V
    //   92: iinc 1 1
    //   95: goto -37 -> 58
    //   98: aload 5
    //   100: iload_1
    //   101: aaload
    //   102: ldc -9
    //   104: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   107: ifeq +30 -> 137
    //   110: aload 4
    //   112: aload_3
    //   113: iload_1
    //   114: invokeinterface 126 2 0
    //   119: invokevirtual 248	com/lantern/traffic/monitor/c/a:a	(J)V
    //   122: goto -30 -> 92
    //   125: astore_3
    //   126: aload_0
    //   127: getfield 34	com/lantern/traffic/monitor/b/a:e	Ljava/util/concurrent/locks/Lock;
    //   130: invokeinterface 139 1 0
    //   135: aload_2
    //   136: areturn
    //   137: aload 5
    //   139: iload_1
    //   140: aaload
    //   141: ldc -6
    //   143: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   146: ifeq +30 -> 176
    //   149: aload 4
    //   151: aload_3
    //   152: iload_1
    //   153: invokeinterface 126 2 0
    //   158: invokevirtual 251	com/lantern/traffic/monitor/c/a:b	(J)V
    //   161: goto -69 -> 92
    //   164: astore_2
    //   165: aload_0
    //   166: getfield 34	com/lantern/traffic/monitor/b/a:e	Ljava/util/concurrent/locks/Lock;
    //   169: invokeinterface 139 1 0
    //   174: aload_2
    //   175: athrow
    //   176: aload 5
    //   178: iload_1
    //   179: aaload
    //   180: ldc -3
    //   182: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   185: ifeq +18 -> 203
    //   188: aload 4
    //   190: aload_3
    //   191: iload_1
    //   192: invokeinterface 126 2 0
    //   197: invokevirtual 255	com/lantern/traffic/monitor/c/a:d	(J)V
    //   200: goto -108 -> 92
    //   203: aload 5
    //   205: iload_1
    //   206: aaload
    //   207: ldc -49
    //   209: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   212: ifeq +18 -> 230
    //   215: aload 4
    //   217: aload_3
    //   218: iload_1
    //   219: invokeinterface 126 2 0
    //   224: invokevirtual 256	com/lantern/traffic/monitor/c/a:c	(J)V
    //   227: goto -135 -> 92
    //   230: aload 5
    //   232: iload_1
    //   233: aaload
    //   234: ldc -36
    //   236: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   239: ifeq +18 -> 257
    //   242: aload 4
    //   244: aload_3
    //   245: iload_1
    //   246: invokeinterface 126 2 0
    //   251: invokevirtual 258	com/lantern/traffic/monitor/c/a:e	(J)V
    //   254: goto -162 -> 92
    //   257: aload 5
    //   259: iload_1
    //   260: aaload
    //   261: ldc -34
    //   263: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   266: ifeq +18 -> 284
    //   269: aload 4
    //   271: aload_3
    //   272: iload_1
    //   273: invokeinterface 243 2 0
    //   278: invokevirtual 260	com/lantern/traffic/monitor/c/a:a	(Ljava/lang/String;)V
    //   281: goto -189 -> 92
    //   284: aload 5
    //   286: iload_1
    //   287: aaload
    //   288: ldc_w 262
    //   291: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   294: ifeq +18 -> 312
    //   297: aload 4
    //   299: aload_3
    //   300: iload_1
    //   301: invokeinterface 266 2 0
    //   306: invokevirtual 269	com/lantern/traffic/monitor/c/a:a	(I)V
    //   309: goto -217 -> 92
    //   312: aload 5
    //   314: iload_1
    //   315: aaload
    //   316: ldc -51
    //   318: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   321: ifeq +18 -> 339
    //   324: aload 4
    //   326: aload_3
    //   327: iload_1
    //   328: invokeinterface 266 2 0
    //   333: invokevirtual 271	com/lantern/traffic/monitor/c/a:b	(I)V
    //   336: goto -244 -> 92
    //   339: aload 5
    //   341: iload_1
    //   342: aaload
    //   343: ldc_w 273
    //   346: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   349: ifeq +18 -> 367
    //   352: aload 4
    //   354: aload_3
    //   355: iload_1
    //   356: invokeinterface 126 2 0
    //   361: invokevirtual 275	com/lantern/traffic/monitor/c/a:f	(J)V
    //   364: goto -272 -> 92
    //   367: aload 5
    //   369: iload_1
    //   370: aaload
    //   371: ldc -91
    //   373: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   376: ifeq +18 -> 394
    //   379: aload 4
    //   381: aload_3
    //   382: iload_1
    //   383: invokeinterface 266 2 0
    //   388: invokevirtual 277	com/lantern/traffic/monitor/c/a:c	(I)V
    //   391: goto -299 -> 92
    //   394: aload 5
    //   396: iload_1
    //   397: aaload
    //   398: ldc -29
    //   400: invokevirtual 120	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   403: ifeq -311 -> 92
    //   406: aload 4
    //   408: aload_3
    //   409: iload_1
    //   410: invokeinterface 126 2 0
    //   415: invokevirtual 280	com/lantern/traffic/monitor/c/a:g	(J)V
    //   418: goto -326 -> 92
    //   421: aload_2
    //   422: aload 4
    //   424: invokeinterface 285 2 0
    //   429: pop
    //   430: goto -393 -> 37
    //   433: aload_3
    //   434: ifnull +18 -> 452
    //   437: aload_3
    //   438: invokeinterface 146 1 0
    //   443: ifne +9 -> 452
    //   446: aload_3
    //   447: invokeinterface 149 1 0
    //   452: aload_0
    //   453: getfield 34	com/lantern/traffic/monitor/b/a:e	Ljava/util/concurrent/locks/Lock;
    //   456: invokeinterface 139 1 0
    //   461: goto -326 -> 135
    //   464: astore_2
    //   465: aconst_null
    //   466: astore_2
    //   467: goto -341 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	470	0	this	a
    //   57	353	1	i	int
    //   3	133	2	localArrayList	java.util.ArrayList
    //   164	258	2	localObject1	Object
    //   464	1	2	localException1	Exception
    //   466	1	2	localObject2	Object
    //   28	85	3	localCursor	android.database.Cursor
    //   125	322	3	localException2	Exception
    //   49	374	4	locala	com.lantern.traffic.monitor.c.a
    //   35	360	5	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   8	37	125	java/lang/Exception
    //   37	56	125	java/lang/Exception
    //   58	92	125	java/lang/Exception
    //   98	122	125	java/lang/Exception
    //   137	161	125	java/lang/Exception
    //   176	200	125	java/lang/Exception
    //   203	227	125	java/lang/Exception
    //   230	254	125	java/lang/Exception
    //   257	281	125	java/lang/Exception
    //   284	309	125	java/lang/Exception
    //   312	336	125	java/lang/Exception
    //   339	364	125	java/lang/Exception
    //   367	391	125	java/lang/Exception
    //   394	418	125	java/lang/Exception
    //   421	430	125	java/lang/Exception
    //   437	452	125	java/lang/Exception
    //   0	8	164	finally
    //   8	37	164	finally
    //   37	56	164	finally
    //   58	92	164	finally
    //   98	122	164	finally
    //   137	161	164	finally
    //   176	200	164	finally
    //   203	227	164	finally
    //   230	254	164	finally
    //   257	281	164	finally
    //   284	309	164	finally
    //   312	336	164	finally
    //   339	364	164	finally
    //   367	391	164	finally
    //   394	418	164	finally
    //   421	430	164	finally
    //   437	452	164	finally
    //   0	8	464	java/lang/Exception
  }
  
  public final boolean c(String paramString)
  {
    bool = true;
    try
    {
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>("DELETE  FROM TRAFFICINFO WHERE PACKAGENAME ='");
      paramString = paramString + "'";
      this.b = a(true);
      this.b.execSQL(paramString);
    }
    catch (SQLException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        bool = false;
        this.e.unlock();
      }
    }
    finally
    {
      this.e.unlock();
    }
    return bool;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/traffic/monitor/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */