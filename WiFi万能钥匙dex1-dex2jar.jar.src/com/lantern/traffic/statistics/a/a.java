package com.lantern.traffic.statistics.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;
import com.lantern.core.n;
import com.lantern.core.o;
import com.lantern.settings.b.e;
import com.lantern.traffic.statistics.b.b;
import com.lantern.traffic.statistics.b.d;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a
{
  /* Error */
  public static long a(com.lantern.traffic.statistics.b.c paramc)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: ldc 2
    //   8: monitorenter
    //   9: invokestatic 14	com/lantern/core/c:getInstance	()Lcom/lantern/core/c;
    //   12: invokestatic 19	com/lantern/traffic/statistics/a/c:a	(Landroid/content/Context;)Lcom/lantern/traffic/statistics/a/c;
    //   15: invokevirtual 23	com/lantern/traffic/statistics/a/c:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   18: astore 9
    //   20: aload 9
    //   22: ldc 25
    //   24: aconst_null
    //   25: aload_0
    //   26: invokestatic 29	com/lantern/traffic/statistics/a/a:c	(Lcom/lantern/traffic/statistics/b/c;)Landroid/content/ContentValues;
    //   29: invokevirtual 35	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   32: pop2
    //   33: ldc2_w 36
    //   36: lstore_3
    //   37: aload 8
    //   39: astore_0
    //   40: aload 9
    //   42: ldc 39
    //   44: aconst_null
    //   45: invokevirtual 43	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   48: astore 8
    //   50: lload_3
    //   51: lstore_1
    //   52: aload 8
    //   54: astore_0
    //   55: aload 8
    //   57: astore 7
    //   59: aload 8
    //   61: invokeinterface 49 1 0
    //   66: ifeq +19 -> 85
    //   69: aload 8
    //   71: astore_0
    //   72: aload 8
    //   74: astore 7
    //   76: aload 8
    //   78: iconst_0
    //   79: invokeinterface 53 2 0
    //   84: lstore_1
    //   85: lload_1
    //   86: lstore 5
    //   88: aload 8
    //   90: ifnull +13 -> 103
    //   93: aload 8
    //   95: invokeinterface 57 1 0
    //   100: lload_1
    //   101: lstore 5
    //   103: ldc 2
    //   105: monitorexit
    //   106: lload 5
    //   108: lreturn
    //   109: astore 7
    //   111: lload_3
    //   112: lstore 5
    //   114: aload_0
    //   115: ifnull -12 -> 103
    //   118: aload_0
    //   119: invokeinterface 57 1 0
    //   124: lload_3
    //   125: lstore 5
    //   127: goto -24 -> 103
    //   130: astore_0
    //   131: ldc 2
    //   133: monitorexit
    //   134: aload_0
    //   135: athrow
    //   136: astore_0
    //   137: aload 7
    //   139: ifnull +10 -> 149
    //   142: aload 7
    //   144: invokeinterface 57 1 0
    //   149: aload_0
    //   150: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	paramc	com.lantern.traffic.statistics.b.c
    //   51	50	1	l1	long
    //   36	89	3	l2	long
    //   86	40	5	l3	long
    //   1	74	7	localObject	Object
    //   109	34	7	localException	Exception
    //   4	90	8	localCursor	Cursor
    //   18	23	9	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   40	50	109	java/lang/Exception
    //   59	69	109	java/lang/Exception
    //   76	85	109	java/lang/Exception
    //   9	33	130	finally
    //   93	100	130	finally
    //   118	124	130	finally
    //   142	149	130	finally
    //   149	151	130	finally
    //   40	50	136	finally
    //   59	69	136	finally
    //   76	85	136	finally
  }
  
  private static com.lantern.traffic.statistics.b.c a(Cursor paramCursor)
  {
    com.lantern.traffic.statistics.b.c localc = new com.lantern.traffic.statistics.b.c();
    localc.a(paramCursor.getLong(paramCursor.getColumnIndex("_id")));
    localc.a(d(paramCursor.getString(paramCursor.getColumnIndex("package_name"))));
    localc.f(paramCursor.getLong(paramCursor.getColumnIndex("last_statistics_id")));
    localc.a(paramCursor.getInt(paramCursor.getColumnIndex("statistics_year")));
    localc.b(paramCursor.getInt(paramCursor.getColumnIndex("statistics_month")));
    localc.c(paramCursor.getInt(paramCursor.getColumnIndex("statistics_day")));
    localc.a(b.a(paramCursor.getInt(paramCursor.getColumnIndex("statistics_status"))));
    localc.c(paramCursor.getLong(paramCursor.getColumnIndex("traffic_receive_incremental")));
    localc.b(paramCursor.getLong(paramCursor.getColumnIndex("traffic_send_incremental")));
    localc.e(paramCursor.getLong(paramCursor.getColumnIndex("traffic_receive")));
    localc.d(paramCursor.getLong(paramCursor.getColumnIndex("traffic_send")));
    localc.a(d.a(paramCursor.getInt(paramCursor.getColumnIndex("traffic_type"))));
    localc.g(paramCursor.getLong(paramCursor.getColumnIndex("statistics_time")));
    localc.d(paramCursor.getInt(paramCursor.getColumnIndex("is_report")));
    localc.h(paramCursor.getLong(paramCursor.getColumnIndex("report_time")));
    return localc;
  }
  
  public static com.lantern.traffic.statistics.b.c a(String paramString)
  {
    try
    {
      paramString = b(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public static List<com.lantern.traffic.statistics.b.c> a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: ldc 2
    //   5: monitorenter
    //   6: iload_0
    //   7: iload_1
    //   8: iload_2
    //   9: iload_3
    //   10: invokestatic 167	com/lantern/traffic/statistics/a/a:c	(IIII)[Ljava/lang/Object;
    //   13: astore 6
    //   15: aload 6
    //   17: iconst_0
    //   18: aaload
    //   19: ifnull +242 -> 261
    //   22: aload 6
    //   24: iconst_0
    //   25: aaload
    //   26: checkcast 169	java/lang/String
    //   29: astore 5
    //   31: aload 6
    //   33: iconst_1
    //   34: aaload
    //   35: ifnull +232 -> 267
    //   38: aload 6
    //   40: iconst_1
    //   41: aaload
    //   42: checkcast 171	[Ljava/lang/String;
    //   45: astore 6
    //   47: new 173	java/util/ArrayList
    //   50: astore 8
    //   52: aload 8
    //   54: invokespecial 174	java/util/ArrayList:<init>	()V
    //   57: invokestatic 14	com/lantern/core/c:getInstance	()Lcom/lantern/core/c;
    //   60: invokestatic 19	com/lantern/traffic/statistics/a/c:a	(Landroid/content/Context;)Lcom/lantern/traffic/statistics/a/c;
    //   63: invokevirtual 177	com/lantern/traffic/statistics/a/c:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   66: astore 9
    //   68: aload 9
    //   70: ldc 25
    //   72: bipush 15
    //   74: anewarray 169	java/lang/String
    //   77: dup
    //   78: iconst_0
    //   79: ldc 66
    //   81: aastore
    //   82: dup
    //   83: iconst_1
    //   84: ldc 75
    //   86: aastore
    //   87: dup
    //   88: iconst_2
    //   89: ldc 88
    //   91: aastore
    //   92: dup
    //   93: iconst_3
    //   94: ldc 93
    //   96: aastore
    //   97: dup
    //   98: iconst_4
    //   99: ldc 102
    //   101: aastore
    //   102: dup
    //   103: iconst_5
    //   104: ldc 107
    //   106: aastore
    //   107: dup
    //   108: bipush 6
    //   110: ldc 111
    //   112: aastore
    //   113: dup
    //   114: bipush 7
    //   116: ldc -77
    //   118: aastore
    //   119: dup
    //   120: bipush 8
    //   122: ldc -75
    //   124: aastore
    //   125: dup
    //   126: bipush 9
    //   128: ldc -127
    //   130: aastore
    //   131: dup
    //   132: bipush 10
    //   134: ldc -122
    //   136: aastore
    //   137: dup
    //   138: bipush 11
    //   140: ldc -118
    //   142: aastore
    //   143: dup
    //   144: bipush 12
    //   146: ldc -108
    //   148: aastore
    //   149: dup
    //   150: bipush 13
    //   152: ldc -103
    //   154: aastore
    //   155: dup
    //   156: bipush 14
    //   158: ldc -99
    //   160: aastore
    //   161: aload 5
    //   163: aload 6
    //   165: ldc 75
    //   167: aconst_null
    //   168: ldc -73
    //   170: invokevirtual 187	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   173: astore 6
    //   175: aload 6
    //   177: ifnull +66 -> 243
    //   180: aload 6
    //   182: astore 5
    //   184: aload 6
    //   186: invokeinterface 191 1 0
    //   191: ifle +52 -> 243
    //   194: aload 6
    //   196: astore 5
    //   198: aload 6
    //   200: invokeinterface 49 1 0
    //   205: ifeq +38 -> 243
    //   208: aload 6
    //   210: astore 5
    //   212: aload 8
    //   214: aload 6
    //   216: invokestatic 193	com/lantern/traffic/statistics/a/a:a	(Landroid/database/Cursor;)Lcom/lantern/traffic/statistics/b/c;
    //   219: invokeinterface 199 2 0
    //   224: pop
    //   225: aload 6
    //   227: astore 5
    //   229: aload 6
    //   231: invokeinterface 202 1 0
    //   236: istore 4
    //   238: iload 4
    //   240: ifne -32 -> 208
    //   243: aload 6
    //   245: ifnull +10 -> 255
    //   248: aload 6
    //   250: invokeinterface 57 1 0
    //   255: ldc 2
    //   257: monitorexit
    //   258: aload 8
    //   260: areturn
    //   261: aconst_null
    //   262: astore 5
    //   264: goto -233 -> 31
    //   267: aconst_null
    //   268: astore 6
    //   270: goto -223 -> 47
    //   273: astore 7
    //   275: aconst_null
    //   276: astore 6
    //   278: aload 6
    //   280: astore 5
    //   282: aload 7
    //   284: invokevirtual 205	java/lang/Exception:printStackTrace	()V
    //   287: aload 6
    //   289: ifnull -34 -> 255
    //   292: aload 6
    //   294: invokeinterface 57 1 0
    //   299: goto -44 -> 255
    //   302: astore 5
    //   304: ldc 2
    //   306: monitorexit
    //   307: aload 5
    //   309: athrow
    //   310: astore 5
    //   312: aload 7
    //   314: astore 6
    //   316: aload 5
    //   318: astore 7
    //   320: aload 6
    //   322: ifnull +10 -> 332
    //   325: aload 6
    //   327: invokeinterface 57 1 0
    //   332: aload 7
    //   334: athrow
    //   335: astore 6
    //   337: aload 6
    //   339: astore 7
    //   341: aload 5
    //   343: astore 6
    //   345: goto -25 -> 320
    //   348: astore 7
    //   350: goto -72 -> 278
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	353	0	paramInt1	int
    //   0	353	1	paramInt2	int
    //   0	353	2	paramInt3	int
    //   0	353	3	paramInt4	int
    //   236	3	4	bool	boolean
    //   29	252	5	localObject1	Object
    //   302	6	5	localObject2	Object
    //   310	32	5	localObject3	Object
    //   13	313	6	localObject4	Object
    //   335	3	6	localObject5	Object
    //   343	1	6	localObject6	Object
    //   1	1	7	localObject7	Object
    //   273	40	7	localException1	Exception
    //   318	22	7	localObject8	Object
    //   348	1	7	localException2	Exception
    //   50	209	8	localArrayList	ArrayList
    //   66	3	9	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   68	175	273	java/lang/Exception
    //   6	15	302	finally
    //   22	31	302	finally
    //   38	47	302	finally
    //   47	68	302	finally
    //   248	255	302	finally
    //   292	299	302	finally
    //   325	332	302	finally
    //   332	335	302	finally
    //   68	175	310	finally
    //   184	194	335	finally
    //   198	208	335	finally
    //   212	225	335	finally
    //   229	238	335	finally
    //   282	287	335	finally
    //   184	194	348	java/lang/Exception
    //   198	208	348	java/lang/Exception
    //   212	225	348	java/lang/Exception
    //   229	238	348	java/lang/Exception
  }
  
  public static Map<String, com.lantern.traffic.statistics.b.a> a()
  {
    try
    {
      Map localMap = c();
      return localMap;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private static com.lantern.traffic.statistics.b.c b(String paramString)
  {
    try
    {
      paramString = c(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void b()
  {
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).set(11, 0);
    ((Calendar)localObject1).set(12, 0);
    ((Calendar)localObject1).set(13, 0);
    ((Calendar)localObject1).set(14, 0);
    long l2 = ((Calendar)localObject1).getTimeInMillis();
    localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).set(5, 1);
    ((Calendar)localObject1).set(11, 0);
    ((Calendar)localObject1).set(12, 0);
    ((Calendar)localObject1).set(13, 0);
    ((Calendar)localObject1).set(14, 0);
    long l1 = ((Calendar)localObject1).getTimeInMillis();
    Object localObject2 = c.a(com.lantern.core.c.getInstance()).getWritableDatabase();
    localObject1 = new ArrayList();
    try
    {
      ((SQLiteDatabase)localObject2).beginTransaction();
      Object localObject3 = new java/lang/StringBuilder;
      ((StringBuilder)localObject3).<init>("is_report = 1 AND statistics_time >= ");
      localObject5 = l1 + " AND statistics_time < " + l2;
      Object localObject6 = ((SQLiteDatabase)localObject2).query("traffic_statistics_table", new String[] { "package_name", "SUM(traffic_send_incremental) AS SEND_TRAFFIC", "SUM(traffic_receive_incremental) AS RECEIVE_TRAFFIC", "COUNT(_id) AS TRAFFIC_COUNT", "traffic_type", "statistics_year", "statistics_month", "statistics_day" }, (String)localObject5, null, "package_name,traffic_type, statistics_year, statistics_month, statistics_day", "TRAFFIC_COUNT > 1", null);
      ((List)localObject1).add(localObject6);
      int j;
      int i;
      int k;
      Object localObject7;
      Object localObject8;
      if ((localObject6 != null) && (((Cursor)localObject6).getCount() > 0) && (((Cursor)localObject6).moveToFirst())) {
        do
        {
          localObject3 = ((Cursor)localObject6).getString(((Cursor)localObject6).getColumnIndex("package_name"));
          l2 = ((Cursor)localObject6).getLong(((Cursor)localObject6).getColumnIndex("SEND_TRAFFIC"));
          long l3 = ((Cursor)localObject6).getLong(((Cursor)localObject6).getColumnIndex("RECEIVE_TRAFFIC"));
          int m = ((Cursor)localObject6).getInt(((Cursor)localObject6).getColumnIndex("traffic_type"));
          j = ((Cursor)localObject6).getInt(((Cursor)localObject6).getColumnIndex("statistics_year"));
          i = ((Cursor)localObject6).getInt(((Cursor)localObject6).getColumnIndex("statistics_month"));
          k = ((Cursor)localObject6).getInt(((Cursor)localObject6).getColumnIndex("statistics_day"));
          localObject7 = new java/lang/StringBuilder;
          ((StringBuilder)localObject7).<init>();
          localObject7 = ((SQLiteDatabase)localObject2).query("traffic_statistics_table", null, (String)localObject5 + " AND package_name = '" + (String)localObject3 + "' AND traffic_type = " + m + " AND statistics_year = " + j + " AND statistics_month = " + i + " AND statistics_day = " + k, null, null, null, "_id DESC limit 1");
          ((List)localObject1).add(localObject7);
          if ((localObject7 != null) && (((Cursor)localObject7).getCount() > 0) && (((Cursor)localObject7).moveToFirst()))
          {
            localObject7 = a((Cursor)localObject7);
            ((com.lantern.traffic.statistics.b.c)localObject7).b(l2);
            ((com.lantern.traffic.statistics.b.c)localObject7).c(l3);
            b((com.lantern.traffic.statistics.b.c)localObject7);
            localObject8 = new java/lang/StringBuilder;
            ((StringBuilder)localObject8).<init>();
            ((SQLiteDatabase)localObject2).delete("traffic_statistics_table", (String)localObject5 + " AND package_name = '" + (String)localObject3 + "' AND traffic_type = " + m + " AND statistics_year = " + j + " AND statistics_month = " + i + " AND statistics_day = " + k + " AND _id != " + ((com.lantern.traffic.statistics.b.c)localObject7).a(), null);
          }
        } while (((Cursor)localObject6).moveToNext());
      }
      localObject3 = new java/lang/StringBuilder;
      ((StringBuilder)localObject3).<init>("is_report = 1 AND statistics_time < ");
      localObject5 = l1;
      localObject3 = ((SQLiteDatabase)localObject2).query("traffic_statistics_table", new String[] { "package_name", "SUM(traffic_send_incremental) AS SEND_TRAFFIC", "SUM(traffic_receive_incremental) AS RECEIVE_TRAFFIC", "COUNT(_id) AS TRAFFIC_COUNT", "traffic_type", "statistics_year", "statistics_month" }, (String)localObject5, null, "package_name,traffic_type, statistics_year, statistics_month", "TRAFFIC_COUNT > 1", null);
      ((List)localObject1).add(localObject3);
      if ((localObject3 != null) && (((Cursor)localObject3).getCount() > 0) && (((Cursor)localObject3).moveToFirst())) {
        do
        {
          localObject6 = ((Cursor)localObject3).getString(((Cursor)localObject3).getColumnIndex("package_name"));
          l2 = ((Cursor)localObject3).getLong(((Cursor)localObject3).getColumnIndex("SEND_TRAFFIC"));
          l1 = ((Cursor)localObject3).getLong(((Cursor)localObject3).getColumnIndex("RECEIVE_TRAFFIC"));
          i = ((Cursor)localObject3).getInt(((Cursor)localObject3).getColumnIndex("traffic_type"));
          j = ((Cursor)localObject3).getInt(((Cursor)localObject3).getColumnIndex("statistics_year"));
          k = ((Cursor)localObject3).getInt(((Cursor)localObject3).getColumnIndex("statistics_month"));
          localObject7 = new java/lang/StringBuilder;
          ((StringBuilder)localObject7).<init>();
          localObject7 = ((SQLiteDatabase)localObject2).query("traffic_statistics_table", null, (String)localObject5 + " AND package_name = '" + (String)localObject6 + "' AND traffic_type = " + i + " AND statistics_year = " + j + " AND statistics_month = " + k, null, null, null, "_id DESC limit 1");
          ((List)localObject1).add(localObject7);
          if ((localObject7 != null) && (((Cursor)localObject7).getCount() > 0) && (((Cursor)localObject7).moveToFirst()))
          {
            localObject8 = a((Cursor)localObject7);
            ((com.lantern.traffic.statistics.b.c)localObject8).b(l2);
            ((com.lantern.traffic.statistics.b.c)localObject8).c(l1);
            b((com.lantern.traffic.statistics.b.c)localObject8);
            localObject7 = new java/lang/StringBuilder;
            ((StringBuilder)localObject7).<init>();
            ((SQLiteDatabase)localObject2).delete("traffic_statistics_table", (String)localObject5 + " AND package_name = '" + (String)localObject6 + "' AND traffic_type = " + i + " AND statistics_year = " + j + " AND statistics_month = " + k + " AND _id != " + ((com.lantern.traffic.statistics.b.c)localObject8).a(), null);
          }
        } while (((Cursor)localObject3).moveToNext());
      }
      ((SQLiteDatabase)localObject2).setTransactionSuccessful();
      return;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        localException2.printStackTrace();
        ((SQLiteDatabase)localObject2).endTransaction();
        localObject2 = ((List)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Cursor localCursor = (Cursor)((Iterator)localObject2).next();
          if (localCursor != null) {
            try
            {
              localCursor.close();
            }
            catch (Exception localException3) {}
          }
        }
        ((List)localObject1).clear();
      }
    }
    finally
    {
      Object localObject5;
      ((SQLiteDatabase)localObject2).endTransaction();
      localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject5 = (Cursor)((Iterator)localObject2).next();
        if (localObject5 != null) {
          try
          {
            ((Cursor)localObject5).close();
          }
          catch (Exception localException4) {}
        }
      }
      ((List)localObject1).clear();
    }
  }
  
  public static void b(com.lantern.traffic.statistics.b.c paramc)
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = c.a(com.lantern.core.c.getInstance()).getWritableDatabase();
      ContentValues localContentValues = c(paramc);
      long l = paramc.a();
      localContentValues.put("_id", Long.valueOf(l));
      localSQLiteDatabase.update("traffic_statistics_table", localContentValues, "_id=?", new String[] { String.valueOf(l) });
      return;
    }
    finally
    {
      paramc = finally;
      throw paramc;
    }
  }
  
  /* Error */
  public static long[] b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: ldc 2
    //   5: monitorenter
    //   6: iload_0
    //   7: iload_1
    //   8: iload_2
    //   9: iload_3
    //   10: invokestatic 167	com/lantern/traffic/statistics/a/a:c	(IIII)[Ljava/lang/Object;
    //   13: astore 5
    //   15: aload 5
    //   17: iconst_0
    //   18: aaload
    //   19: ifnull +168 -> 187
    //   22: aload 5
    //   24: iconst_0
    //   25: aaload
    //   26: checkcast 169	java/lang/String
    //   29: astore 4
    //   31: aload 5
    //   33: iconst_1
    //   34: aaload
    //   35: ifnull +158 -> 193
    //   38: aload 5
    //   40: iconst_1
    //   41: aaload
    //   42: checkcast 171	[Ljava/lang/String;
    //   45: astore 5
    //   47: iconst_2
    //   48: newarray <illegal type>
    //   50: astore 7
    //   52: aload 7
    //   54: dup
    //   55: iconst_0
    //   56: lconst_0
    //   57: lastore
    //   58: dup
    //   59: iconst_1
    //   60: lconst_0
    //   61: lastore
    //   62: pop
    //   63: invokestatic 14	com/lantern/core/c:getInstance	()Lcom/lantern/core/c;
    //   66: invokestatic 19	com/lantern/traffic/statistics/a/c:a	(Landroid/content/Context;)Lcom/lantern/traffic/statistics/a/c;
    //   69: invokevirtual 177	com/lantern/traffic/statistics/a/c:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   72: astore 8
    //   74: aload 8
    //   76: ldc 25
    //   78: iconst_2
    //   79: anewarray 169	java/lang/String
    //   82: dup
    //   83: iconst_0
    //   84: ldc -77
    //   86: aastore
    //   87: dup
    //   88: iconst_1
    //   89: ldc -75
    //   91: aastore
    //   92: aload 4
    //   94: aload 5
    //   96: aconst_null
    //   97: aconst_null
    //   98: aconst_null
    //   99: invokevirtual 187	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   102: astore 4
    //   104: aload 4
    //   106: ifnull +63 -> 169
    //   109: aload 4
    //   111: invokeinterface 191 1 0
    //   116: ifle +53 -> 169
    //   119: aload 4
    //   121: invokeinterface 49 1 0
    //   126: ifeq +43 -> 169
    //   129: aload 7
    //   131: iconst_0
    //   132: aload 4
    //   134: aload 4
    //   136: ldc 125
    //   138: invokeinterface 70 2 0
    //   143: invokeinterface 53 2 0
    //   148: lastore
    //   149: aload 7
    //   151: iconst_1
    //   152: aload 4
    //   154: aload 4
    //   156: ldc 121
    //   158: invokeinterface 70 2 0
    //   163: invokeinterface 53 2 0
    //   168: lastore
    //   169: aload 4
    //   171: ifnull +10 -> 181
    //   174: aload 4
    //   176: invokeinterface 57 1 0
    //   181: ldc 2
    //   183: monitorexit
    //   184: aload 7
    //   186: areturn
    //   187: aconst_null
    //   188: astore 4
    //   190: goto -159 -> 31
    //   193: aconst_null
    //   194: astore 5
    //   196: goto -149 -> 47
    //   199: astore 4
    //   201: aconst_null
    //   202: astore 4
    //   204: aload 4
    //   206: ifnull -25 -> 181
    //   209: aload 4
    //   211: invokeinterface 57 1 0
    //   216: goto -35 -> 181
    //   219: astore 4
    //   221: ldc 2
    //   223: monitorexit
    //   224: aload 4
    //   226: athrow
    //   227: astore 5
    //   229: aload 6
    //   231: astore 4
    //   233: aload 4
    //   235: ifnull +10 -> 245
    //   238: aload 4
    //   240: invokeinterface 57 1 0
    //   245: aload 5
    //   247: athrow
    //   248: astore 5
    //   250: goto -17 -> 233
    //   253: astore 5
    //   255: goto -51 -> 204
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	258	0	paramInt1	int
    //   0	258	1	paramInt2	int
    //   0	258	2	paramInt3	int
    //   0	258	3	paramInt4	int
    //   29	160	4	localObject1	Object
    //   199	1	4	localException1	Exception
    //   202	8	4	localObject2	Object
    //   219	6	4	localObject3	Object
    //   231	8	4	localObject4	Object
    //   13	182	5	localObject5	Object
    //   227	19	5	localObject6	Object
    //   248	1	5	localObject7	Object
    //   253	1	5	localException2	Exception
    //   1	229	6	localObject8	Object
    //   50	135	7	arrayOfLong	long[]
    //   72	3	8	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   74	104	199	java/lang/Exception
    //   6	15	219	finally
    //   22	31	219	finally
    //   38	47	219	finally
    //   47	74	219	finally
    //   174	181	219	finally
    //   209	216	219	finally
    //   238	245	219	finally
    //   245	248	219	finally
    //   74	104	227	finally
    //   109	169	248	finally
    //   109	169	253	java/lang/Exception
  }
  
  private static ContentValues c(com.lantern.traffic.statistics.b.c paramc)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("package_name", e.c(paramc.b()));
    localContentValues.put("last_statistics_id", Long.valueOf(paramc.h()));
    localContentValues.put("statistics_year", Integer.valueOf(paramc.j()));
    localContentValues.put("statistics_month", Integer.valueOf(paramc.k()));
    localContentValues.put("statistics_day", Integer.valueOf(paramc.l()));
    localContentValues.put("statistics_status", Integer.valueOf(paramc.i().a()));
    localContentValues.put("traffic_receive_incremental", Long.valueOf(paramc.e()));
    localContentValues.put("traffic_send_incremental", Long.valueOf(paramc.d()));
    localContentValues.put("traffic_receive", Long.valueOf(paramc.g()));
    localContentValues.put("traffic_send", Long.valueOf(paramc.f()));
    localContentValues.put("traffic_type", Integer.valueOf(paramc.c().a()));
    localContentValues.put("statistics_time", Long.valueOf(paramc.m()));
    localContentValues.put("is_report", Integer.valueOf(paramc.n()));
    localContentValues.put("report_time", Long.valueOf(paramc.o()));
    return localContentValues;
  }
  
  /* Error */
  private static com.lantern.traffic.statistics.b.c c(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: invokestatic 14	com/lantern/core/c:getInstance	()Lcom/lantern/core/c;
    //   8: invokestatic 19	com/lantern/traffic/statistics/a/c:a	(Landroid/content/Context;)Lcom/lantern/traffic/statistics/a/c;
    //   11: invokevirtual 177	com/lantern/traffic/statistics/a/c:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   14: astore_2
    //   15: aload_2
    //   16: ldc 25
    //   18: aconst_null
    //   19: ldc_w 395
    //   22: iconst_1
    //   23: anewarray 169	java/lang/String
    //   26: dup
    //   27: iconst_0
    //   28: aload_0
    //   29: invokestatic 344	com/lantern/settings/b/e:c	(Ljava/lang/String;)Ljava/lang/String;
    //   32: aastore
    //   33: aconst_null
    //   34: aconst_null
    //   35: ldc_w 278
    //   38: invokevirtual 187	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   41: astore_2
    //   42: aload_2
    //   43: ifnull +99 -> 142
    //   46: aload_2
    //   47: invokeinterface 191 1 0
    //   52: ifle +90 -> 142
    //   55: aload_2
    //   56: invokeinterface 49 1 0
    //   61: ifeq +81 -> 142
    //   64: aload_2
    //   65: invokestatic 193	com/lantern/traffic/statistics/a/a:a	(Landroid/database/Cursor;)Lcom/lantern/traffic/statistics/b/c;
    //   68: astore_0
    //   69: aload_0
    //   70: astore_1
    //   71: aload_2
    //   72: ifnull +11 -> 83
    //   75: aload_2
    //   76: invokeinterface 57 1 0
    //   81: aload_0
    //   82: astore_1
    //   83: ldc 2
    //   85: monitorexit
    //   86: aload_1
    //   87: areturn
    //   88: astore_0
    //   89: aconst_null
    //   90: astore_0
    //   91: aload_0
    //   92: ifnull +45 -> 137
    //   95: aload_0
    //   96: invokeinterface 57 1 0
    //   101: aconst_null
    //   102: astore_1
    //   103: goto -20 -> 83
    //   106: astore_0
    //   107: aload_1
    //   108: astore_2
    //   109: aload_2
    //   110: ifnull +9 -> 119
    //   113: aload_2
    //   114: invokeinterface 57 1 0
    //   119: aload_0
    //   120: athrow
    //   121: astore_0
    //   122: ldc 2
    //   124: monitorexit
    //   125: aload_0
    //   126: athrow
    //   127: astore_0
    //   128: goto -19 -> 109
    //   131: astore_0
    //   132: aload_2
    //   133: astore_0
    //   134: goto -43 -> 91
    //   137: aconst_null
    //   138: astore_1
    //   139: goto -56 -> 83
    //   142: aconst_null
    //   143: astore_0
    //   144: goto -75 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	paramString	String
    //   1	138	1	str	String
    //   14	119	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   15	42	88	java/lang/Exception
    //   15	42	106	finally
    //   5	15	121	finally
    //   75	81	121	finally
    //   95	101	121	finally
    //   113	119	121	finally
    //   119	121	121	finally
    //   46	69	127	finally
    //   46	69	131	java/lang/Exception
  }
  
  /* Error */
  private static Map<String, com.lantern.traffic.statistics.b.a> c()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 397	java/util/HashMap
    //   6: astore 9
    //   8: aload 9
    //   10: invokespecial 398	java/util/HashMap:<init>	()V
    //   13: invokestatic 14	com/lantern/core/c:getInstance	()Lcom/lantern/core/c;
    //   16: invokestatic 19	com/lantern/traffic/statistics/a/c:a	(Landroid/content/Context;)Lcom/lantern/traffic/statistics/a/c;
    //   19: invokevirtual 177	com/lantern/traffic/statistics/a/c:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   22: astore 7
    //   24: aconst_null
    //   25: invokestatic 344	com/lantern/settings/b/e:c	(Ljava/lang/String;)Ljava/lang/String;
    //   28: astore 8
    //   30: aload 8
    //   32: invokestatic 404	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   35: ifeq +355 -> 390
    //   38: ldc_w 406
    //   41: astore 6
    //   43: aload 7
    //   45: ldc 25
    //   47: bipush 6
    //   49: anewarray 169	java/lang/String
    //   52: dup
    //   53: iconst_0
    //   54: ldc 75
    //   56: aastore
    //   57: dup
    //   58: iconst_1
    //   59: ldc -6
    //   61: aastore
    //   62: dup
    //   63: iconst_2
    //   64: ldc -4
    //   66: aastore
    //   67: dup
    //   68: iconst_3
    //   69: ldc_w 408
    //   72: aastore
    //   73: dup
    //   74: iconst_4
    //   75: ldc_w 410
    //   78: aastore
    //   79: dup
    //   80: iconst_5
    //   81: ldc -118
    //   83: aastore
    //   84: aload 6
    //   86: aconst_null
    //   87: ldc_w 412
    //   90: aconst_null
    //   91: aconst_null
    //   92: invokevirtual 187	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   95: astore 6
    //   97: aload 6
    //   99: ifnull +273 -> 372
    //   102: aload 6
    //   104: invokeinterface 191 1 0
    //   109: ifle +263 -> 372
    //   112: aload 6
    //   114: invokeinterface 49 1 0
    //   119: ifeq +253 -> 372
    //   122: aload 6
    //   124: aload 6
    //   126: ldc 75
    //   128: invokeinterface 70 2 0
    //   133: invokeinterface 79 2 0
    //   138: invokestatic 83	com/lantern/traffic/statistics/a/a:d	(Ljava/lang/String;)Ljava/lang/String;
    //   141: astore 10
    //   143: aload 9
    //   145: aload 10
    //   147: invokeinterface 418 2 0
    //   152: checkcast 420	com/lantern/traffic/statistics/b/a
    //   155: astore 8
    //   157: aload 8
    //   159: astore 7
    //   161: aload 8
    //   163: ifnonnull +25 -> 188
    //   166: new 420	com/lantern/traffic/statistics/b/a
    //   169: astore 7
    //   171: aload 7
    //   173: invokespecial 421	com/lantern/traffic/statistics/b/a:<init>	()V
    //   176: aload 9
    //   178: aload 10
    //   180: aload 7
    //   182: invokeinterface 424 3 0
    //   187: pop
    //   188: aload 7
    //   190: aload 10
    //   192: invokevirtual 425	com/lantern/traffic/statistics/b/a:a	(Ljava/lang/String;)V
    //   195: aload 6
    //   197: aload 6
    //   199: ldc_w 260
    //   202: invokeinterface 70 2 0
    //   207: invokeinterface 53 2 0
    //   212: lstore_3
    //   213: aload 6
    //   215: aload 6
    //   217: ldc_w 262
    //   220: invokeinterface 70 2 0
    //   225: invokeinterface 53 2 0
    //   230: lstore_1
    //   231: aload 6
    //   233: aload 6
    //   235: ldc -118
    //   237: invokeinterface 70 2 0
    //   242: invokeinterface 97 2 0
    //   247: istore_0
    //   248: iload_0
    //   249: getstatic 428	com/lantern/traffic/statistics/b/d:a	Lcom/lantern/traffic/statistics/b/d;
    //   252: invokevirtual 384	com/lantern/traffic/statistics/b/d:a	()I
    //   255: if_icmpne +169 -> 424
    //   258: aload 7
    //   260: lload_3
    //   261: invokevirtual 429	com/lantern/traffic/statistics/b/a:a	(J)V
    //   264: aload 7
    //   266: lload_1
    //   267: invokevirtual 430	com/lantern/traffic/statistics/b/a:b	(J)V
    //   270: aload 6
    //   272: aload 6
    //   274: ldc_w 432
    //   277: invokeinterface 70 2 0
    //   282: invokeinterface 53 2 0
    //   287: lstore_3
    //   288: aload 6
    //   290: aload 6
    //   292: ldc_w 434
    //   295: invokeinterface 70 2 0
    //   300: invokeinterface 53 2 0
    //   305: lstore_1
    //   306: aload 7
    //   308: invokevirtual 435	com/lantern/traffic/statistics/b/a:h	()J
    //   311: lconst_0
    //   312: lcmp
    //   313: ifeq +13 -> 326
    //   316: lload_3
    //   317: aload 7
    //   319: invokevirtual 435	com/lantern/traffic/statistics/b/a:h	()J
    //   322: lcmp
    //   323: ifge +9 -> 332
    //   326: aload 7
    //   328: lload_3
    //   329: invokevirtual 436	com/lantern/traffic/statistics/b/a:g	(J)V
    //   332: aload 7
    //   334: invokevirtual 438	com/lantern/traffic/statistics/b/a:i	()J
    //   337: lconst_0
    //   338: lcmp
    //   339: ifeq +13 -> 352
    //   342: lload_1
    //   343: aload 7
    //   345: invokevirtual 438	com/lantern/traffic/statistics/b/a:i	()J
    //   348: lcmp
    //   349: ifle +9 -> 358
    //   352: aload 7
    //   354: lload_1
    //   355: invokevirtual 439	com/lantern/traffic/statistics/b/a:h	(J)V
    //   358: aload 6
    //   360: invokeinterface 202 1 0
    //   365: istore 5
    //   367: iload 5
    //   369: ifne -247 -> 122
    //   372: aload 6
    //   374: ifnull +10 -> 384
    //   377: aload 6
    //   379: invokeinterface 57 1 0
    //   384: ldc 2
    //   386: monitorexit
    //   387: aload 9
    //   389: areturn
    //   390: new 231	java/lang/StringBuilder
    //   393: astore 6
    //   395: aload 6
    //   397: ldc_w 441
    //   400: invokespecial 235	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   403: aload 6
    //   405: aload 8
    //   407: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: ldc_w 443
    //   413: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   419: astore 6
    //   421: goto -378 -> 43
    //   424: iload_0
    //   425: getstatic 445	com/lantern/traffic/statistics/b/d:b	Lcom/lantern/traffic/statistics/b/d;
    //   428: invokevirtual 384	com/lantern/traffic/statistics/b/d:a	()I
    //   431: if_icmpne +43 -> 474
    //   434: aload 7
    //   436: lload_3
    //   437: invokevirtual 446	com/lantern/traffic/statistics/b/a:c	(J)V
    //   440: aload 7
    //   442: lload_1
    //   443: invokevirtual 447	com/lantern/traffic/statistics/b/a:d	(J)V
    //   446: goto -176 -> 270
    //   449: astore 7
    //   451: aload 6
    //   453: ifnull -69 -> 384
    //   456: aload 6
    //   458: invokeinterface 57 1 0
    //   463: goto -79 -> 384
    //   466: astore 6
    //   468: ldc 2
    //   470: monitorexit
    //   471: aload 6
    //   473: athrow
    //   474: iload_0
    //   475: getstatic 449	com/lantern/traffic/statistics/b/d:c	Lcom/lantern/traffic/statistics/b/d;
    //   478: invokevirtual 384	com/lantern/traffic/statistics/b/d:a	()I
    //   481: if_icmpne -211 -> 270
    //   484: aload 7
    //   486: lload_3
    //   487: invokevirtual 450	com/lantern/traffic/statistics/b/a:e	(J)V
    //   490: aload 7
    //   492: lload_1
    //   493: invokevirtual 451	com/lantern/traffic/statistics/b/a:f	(J)V
    //   496: goto -226 -> 270
    //   499: astore 7
    //   501: aload 6
    //   503: ifnull +10 -> 513
    //   506: aload 6
    //   508: invokeinterface 57 1 0
    //   513: aload 7
    //   515: athrow
    //   516: astore 7
    //   518: aconst_null
    //   519: astore 6
    //   521: goto -20 -> 501
    //   524: astore 6
    //   526: aconst_null
    //   527: astore 6
    //   529: goto -78 -> 451
    // Local variable table:
    //   start	length	slot	name	signature
    //   247	235	0	i	int
    //   230	263	1	l1	long
    //   212	275	3	l2	long
    //   365	3	5	bool	boolean
    //   41	416	6	localObject1	Object
    //   466	41	6	localObject2	Object
    //   519	1	6	localObject3	Object
    //   524	1	6	localException1	Exception
    //   527	1	6	localObject4	Object
    //   22	419	7	localObject5	Object
    //   449	42	7	localException2	Exception
    //   499	15	7	localObject6	Object
    //   516	1	7	localObject7	Object
    //   28	378	8	localObject8	Object
    //   6	382	9	localHashMap	java.util.HashMap
    //   141	50	10	str	String
    // Exception table:
    //   from	to	target	type
    //   102	122	449	java/lang/Exception
    //   122	157	449	java/lang/Exception
    //   166	188	449	java/lang/Exception
    //   188	270	449	java/lang/Exception
    //   270	326	449	java/lang/Exception
    //   326	332	449	java/lang/Exception
    //   332	352	449	java/lang/Exception
    //   352	358	449	java/lang/Exception
    //   358	367	449	java/lang/Exception
    //   424	446	449	java/lang/Exception
    //   474	496	449	java/lang/Exception
    //   3	24	466	finally
    //   377	384	466	finally
    //   456	463	466	finally
    //   506	513	466	finally
    //   513	516	466	finally
    //   102	122	499	finally
    //   122	157	499	finally
    //   166	188	499	finally
    //   188	270	499	finally
    //   270	326	499	finally
    //   326	332	499	finally
    //   332	352	499	finally
    //   352	358	499	finally
    //   358	367	499	finally
    //   424	446	499	finally
    //   474	496	499	finally
    //   24	38	516	finally
    //   43	97	516	finally
    //   390	421	516	finally
    //   24	38	524	java/lang/Exception
    //   43	97	524	java/lang/Exception
    //   390	421	524	java/lang/Exception
  }
  
  private static Object[] c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    String str2 = e.c(com.lantern.core.c.getInstance().getPackageName());
    String str1;
    String[] arrayOfString;
    if (paramInt1 == 1)
    {
      str1 = "statistics_year = ? and statistics_month = ? and statistics_day = ? and package_name != ? ";
      arrayOfString = new String[4];
      arrayOfString[0] = String.valueOf(paramInt2);
      arrayOfString[1] = String.valueOf(paramInt3);
      arrayOfString[2] = String.valueOf(paramInt4);
      arrayOfString[3] = str2;
    }
    for (;;)
    {
      return new Object[] { str1, arrayOfString };
      if (paramInt1 == 2)
      {
        str1 = "statistics_year = ? and statistics_month = ? and package_name != ? ";
        arrayOfString = new String[3];
        arrayOfString[0] = String.valueOf(paramInt2);
        arrayOfString[1] = String.valueOf(paramInt3);
        arrayOfString[2] = str2;
      }
      else if (paramInt1 == 3)
      {
        str1 = "statistics_year = ? and package_name != ? ";
        arrayOfString = new String[2];
        arrayOfString[0] = String.valueOf(paramInt2);
        arrayOfString[1] = str2;
      }
      else
      {
        str1 = "package_name != ? ";
        arrayOfString = new String[1];
        arrayOfString[0] = str2;
      }
    }
  }
  
  private static String d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return paramString;
      paramString = n.c(Uri.encode(paramString, "UTF-8"), com.lantern.core.c.getServer().l(), com.lantern.core.c.getServer().m()).trim();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/traffic/statistics/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */