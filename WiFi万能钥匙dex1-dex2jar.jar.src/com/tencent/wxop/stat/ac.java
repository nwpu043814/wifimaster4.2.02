package com.tencent.wxop.stat;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.wxop.stat.b.b;

final class ac
  extends SQLiteOpenHelper
{
  private String a = "";
  private Context co = null;
  
  public ac(Context paramContext, String paramString)
  {
    super(paramContext, paramString, null, 3);
    this.a = paramString;
    this.co = paramContext.getApplicationContext();
    if (c.k()) {
      t.ao().b("SQLiteOpenHelper " + this.a);
    }
  }
  
  /* Error */
  private static void a(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: ldc 64
    //   5: aconst_null
    //   6: aconst_null
    //   7: aconst_null
    //   8: aconst_null
    //   9: aconst_null
    //   10: aconst_null
    //   11: invokevirtual 70	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   14: astore_2
    //   15: aload_2
    //   16: astore_1
    //   17: new 72	android/content/ContentValues
    //   20: astore 4
    //   22: aload_2
    //   23: astore_1
    //   24: aload 4
    //   26: invokespecial 75	android/content/ContentValues:<init>	()V
    //   29: aload_2
    //   30: astore_1
    //   31: aload_2
    //   32: invokeinterface 80 1 0
    //   37: ifeq +56 -> 93
    //   40: aload_2
    //   41: astore_1
    //   42: aload_2
    //   43: iconst_0
    //   44: invokeinterface 84 2 0
    //   49: astore_3
    //   50: aload_2
    //   51: astore_1
    //   52: aload_2
    //   53: iconst_1
    //   54: invokeinterface 88 2 0
    //   59: pop
    //   60: aload_2
    //   61: astore_1
    //   62: aload_2
    //   63: iconst_2
    //   64: invokeinterface 84 2 0
    //   69: pop
    //   70: aload_2
    //   71: astore_1
    //   72: aload_2
    //   73: iconst_3
    //   74: invokeinterface 92 2 0
    //   79: pop2
    //   80: aload_2
    //   81: astore_1
    //   82: aload 4
    //   84: ldc 94
    //   86: aload_3
    //   87: invokestatic 100	com/tencent/wxop/stat/b/r:q	(Ljava/lang/String;)Ljava/lang/String;
    //   90: invokevirtual 104	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   93: aload_3
    //   94: ifnull +24 -> 118
    //   97: aload_2
    //   98: astore_1
    //   99: aload_0
    //   100: ldc 64
    //   102: aload 4
    //   104: ldc 106
    //   106: iconst_1
    //   107: anewarray 108	java/lang/String
    //   110: dup
    //   111: iconst_0
    //   112: aload_3
    //   113: aastore
    //   114: invokevirtual 112	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   117: pop
    //   118: aload_2
    //   119: ifnull +9 -> 128
    //   122: aload_2
    //   123: invokeinterface 115 1 0
    //   128: return
    //   129: astore_0
    //   130: aconst_null
    //   131: astore_2
    //   132: aload_2
    //   133: astore_1
    //   134: invokestatic 37	com/tencent/wxop/stat/t:ao	()Lcom/tencent/wxop/stat/b/b;
    //   137: aload_0
    //   138: invokevirtual 118	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   141: aload_2
    //   142: ifnull -14 -> 128
    //   145: aload_2
    //   146: invokeinterface 115 1 0
    //   151: goto -23 -> 128
    //   154: astore_0
    //   155: aconst_null
    //   156: astore_1
    //   157: aload_1
    //   158: ifnull +9 -> 167
    //   161: aload_1
    //   162: invokeinterface 115 1 0
    //   167: aload_0
    //   168: athrow
    //   169: astore_0
    //   170: goto -13 -> 157
    //   173: astore_0
    //   174: goto -42 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	paramSQLiteDatabase	SQLiteDatabase
    //   16	146	1	localCursor1	android.database.Cursor
    //   14	132	2	localCursor2	android.database.Cursor
    //   1	112	3	str	String
    //   20	83	4	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   2	15	129	java/lang/Throwable
    //   2	15	154	finally
    //   17	22	169	finally
    //   24	29	169	finally
    //   31	40	169	finally
    //   42	50	169	finally
    //   52	60	169	finally
    //   62	70	169	finally
    //   72	80	169	finally
    //   82	93	169	finally
    //   99	118	169	finally
    //   134	141	169	finally
    //   17	22	173	java/lang/Throwable
    //   24	29	173	java/lang/Throwable
    //   31	40	173	java/lang/Throwable
    //   42	50	173	java/lang/Throwable
    //   52	60	173	java/lang/Throwable
    //   62	70	173	java/lang/Throwable
    //   72	80	173	java/lang/Throwable
    //   82	93	173	java/lang/Throwable
    //   99	118	173	java/lang/Throwable
  }
  
  /* Error */
  private static void b(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 120
    //   3: aconst_null
    //   4: aconst_null
    //   5: aconst_null
    //   6: aconst_null
    //   7: aconst_null
    //   8: aconst_null
    //   9: invokevirtual 70	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   12: astore 5
    //   14: new 122	java/util/ArrayList
    //   17: astore 6
    //   19: aload 6
    //   21: invokespecial 123	java/util/ArrayList:<init>	()V
    //   24: aload 5
    //   26: invokeinterface 80 1 0
    //   31: ifeq +92 -> 123
    //   34: aload 5
    //   36: iconst_0
    //   37: invokeinterface 92 2 0
    //   42: lstore_3
    //   43: aload 5
    //   45: iconst_1
    //   46: invokeinterface 84 2 0
    //   51: astore 8
    //   53: aload 5
    //   55: iconst_2
    //   56: invokeinterface 88 2 0
    //   61: istore_1
    //   62: aload 5
    //   64: iconst_3
    //   65: invokeinterface 88 2 0
    //   70: istore_2
    //   71: new 125	com/tencent/wxop/stat/ad
    //   74: astore 7
    //   76: aload 7
    //   78: lload_3
    //   79: aload 8
    //   81: iload_1
    //   82: iload_2
    //   83: invokespecial 128	com/tencent/wxop/stat/ad:<init>	(JLjava/lang/String;II)V
    //   86: aload 6
    //   88: aload 7
    //   90: invokeinterface 134 2 0
    //   95: pop
    //   96: goto -72 -> 24
    //   99: astore 6
    //   101: aload 5
    //   103: astore_0
    //   104: invokestatic 37	com/tencent/wxop/stat/t:ao	()Lcom/tencent/wxop/stat/b/b;
    //   107: aload 6
    //   109: invokevirtual 118	com/tencent/wxop/stat/b/b:b	(Ljava/lang/Throwable;)V
    //   112: aload_0
    //   113: ifnull +9 -> 122
    //   116: aload_0
    //   117: invokeinterface 115 1 0
    //   122: return
    //   123: new 72	android/content/ContentValues
    //   126: astore 7
    //   128: aload 7
    //   130: invokespecial 75	android/content/ContentValues:<init>	()V
    //   133: aload 6
    //   135: invokeinterface 138 1 0
    //   140: astore 6
    //   142: aload 6
    //   144: invokeinterface 143 1 0
    //   149: ifeq +74 -> 223
    //   152: aload 6
    //   154: invokeinterface 147 1 0
    //   159: checkcast 125	com/tencent/wxop/stat/ad
    //   162: astore 8
    //   164: aload 7
    //   166: ldc -107
    //   168: aload 8
    //   170: getfield 151	com/tencent/wxop/stat/ad:b	Ljava/lang/String;
    //   173: invokestatic 100	com/tencent/wxop/stat/b/r:q	(Ljava/lang/String;)Ljava/lang/String;
    //   176: invokevirtual 104	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   179: aload_0
    //   180: ldc 120
    //   182: aload 7
    //   184: ldc -103
    //   186: iconst_1
    //   187: anewarray 108	java/lang/String
    //   190: dup
    //   191: iconst_0
    //   192: aload 8
    //   194: getfield 157	com/tencent/wxop/stat/ad:K	J
    //   197: invokestatic 162	java/lang/Long:toString	(J)Ljava/lang/String;
    //   200: aastore
    //   201: invokevirtual 112	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   204: pop
    //   205: goto -63 -> 142
    //   208: astore_0
    //   209: aload 5
    //   211: ifnull +10 -> 221
    //   214: aload 5
    //   216: invokeinterface 115 1 0
    //   221: aload_0
    //   222: athrow
    //   223: aload 5
    //   225: ifnull -103 -> 122
    //   228: aload 5
    //   230: invokeinterface 115 1 0
    //   235: goto -113 -> 122
    //   238: astore_0
    //   239: aconst_null
    //   240: astore 5
    //   242: goto -33 -> 209
    //   245: astore 6
    //   247: aload_0
    //   248: astore 5
    //   250: aload 6
    //   252: astore_0
    //   253: goto -44 -> 209
    //   256: astore 6
    //   258: aconst_null
    //   259: astore_0
    //   260: goto -156 -> 104
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	paramSQLiteDatabase	SQLiteDatabase
    //   61	21	1	i	int
    //   70	13	2	j	int
    //   42	37	3	l	long
    //   12	237	5	localObject1	Object
    //   17	70	6	localArrayList	java.util.ArrayList
    //   99	35	6	localThrowable1	Throwable
    //   140	13	6	localIterator	java.util.Iterator
    //   245	6	6	localObject2	Object
    //   256	1	6	localThrowable2	Throwable
    //   74	109	7	localObject3	Object
    //   51	142	8	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   14	24	99	java/lang/Throwable
    //   24	96	99	java/lang/Throwable
    //   123	142	99	java/lang/Throwable
    //   142	205	99	java/lang/Throwable
    //   14	24	208	finally
    //   24	96	208	finally
    //   123	142	208	finally
    //   142	205	208	finally
    //   0	14	238	finally
    //   104	112	245	finally
    //   0	14	256	java/lang/Throwable
  }
  
  public final void close()
  {
    try
    {
      super.close();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("create table if not exists events(event_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, content TEXT, status INTEGER, send_count INTEGER, timestamp LONG)");
    paramSQLiteDatabase.execSQL("create table if not exists user(uid TEXT PRIMARY KEY, user_type INTEGER, app_ver TEXT, ts INTEGER)");
    paramSQLiteDatabase.execSQL("create table if not exists config(type INTEGER PRIMARY KEY NOT NULL, content TEXT, md5sum TEXT, version INTEGER)");
    paramSQLiteDatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
    paramSQLiteDatabase.execSQL("CREATE INDEX if not exists status_idx ON events(status)");
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    t.ao().debug("upgrade DB from oldVersion " + paramInt1 + " to newVersion " + paramInt2);
    if (paramInt1 == 1)
    {
      paramSQLiteDatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
      a(paramSQLiteDatabase);
      b(paramSQLiteDatabase);
    }
    if (paramInt1 == 2)
    {
      a(paramSQLiteDatabase);
      b(paramSQLiteDatabase);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/wxop/stat/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */