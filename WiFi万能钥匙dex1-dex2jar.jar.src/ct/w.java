package ct;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public final class w
  extends SQLiteOpenHelper
  implements v
{
  private static String a = "";
  private static w b;
  
  private w(Context paramContext, String paramString)
  {
    super(paramContext, paramString, null, 4);
    try
    {
      paramContext.deleteDatabase("access.db");
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public static w a()
  {
    if (b == null)
    {
      a = p.b() + "-access.db";
      b = new w(p.a(), a);
    }
    return b;
  }
  
  /* Error */
  private boolean a(String paramString, t.a parama, long paramLong)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: invokevirtual 68	ct/w:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   9: astore 8
    //   11: aload 8
    //   13: invokevirtual 74	android/database/sqlite/SQLiteDatabase:isDbLockedByOtherThreads	()Z
    //   16: ifne +15 -> 31
    //   19: aload 8
    //   21: invokevirtual 77	android/database/sqlite/SQLiteDatabase:isDbLockedByCurrentThread	()Z
    //   24: istore 7
    //   26: iload 7
    //   28: ifeq +31 -> 59
    //   31: ldc2_w 78
    //   34: invokestatic 85	java/lang/Thread:sleep	(J)V
    //   37: goto -26 -> 11
    //   40: astore 9
    //   42: aload 9
    //   44: invokevirtual 86	java/lang/InterruptedException:printStackTrace	()V
    //   47: goto -36 -> 11
    //   50: astore_1
    //   51: iconst_0
    //   52: istore 6
    //   54: aload_0
    //   55: monitorexit
    //   56: iload 6
    //   58: ireturn
    //   59: new 88	android/content/ContentValues
    //   62: astore 9
    //   64: aload 9
    //   66: invokespecial 89	android/content/ContentValues:<init>	()V
    //   69: aload 9
    //   71: ldc 91
    //   73: aload_2
    //   74: invokevirtual 95	ct/t$a:a	()Ljava/lang/String;
    //   77: invokevirtual 99	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   80: aload 9
    //   82: ldc 101
    //   84: aload_2
    //   85: getfield 105	ct/t$a:e	J
    //   88: invokestatic 111	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   91: invokevirtual 114	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   94: aload 9
    //   96: ldc 116
    //   98: lload_3
    //   99: invokestatic 111	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   102: invokevirtual 114	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   105: aload 9
    //   107: ldc 118
    //   109: aload_2
    //   110: getfield 120	ct/t$a:b	Ljava/lang/String;
    //   113: invokevirtual 99	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   116: aload 8
    //   118: ldc 122
    //   120: aload 9
    //   122: ldc 124
    //   124: iconst_2
    //   125: anewarray 126	java/lang/String
    //   128: dup
    //   129: iconst_0
    //   130: aload_1
    //   131: aastore
    //   132: dup
    //   133: iconst_1
    //   134: aload_2
    //   135: getfield 127	ct/t$a:a	Ljava/lang/String;
    //   138: aastore
    //   139: invokevirtual 131	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   142: istore 5
    //   144: iload 5
    //   146: ifne +117 -> 263
    //   149: aload 9
    //   151: ldc -123
    //   153: aload_1
    //   154: invokevirtual 99	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   157: aload 9
    //   159: ldc -121
    //   161: aload_2
    //   162: getfield 127	ct/t$a:a	Ljava/lang/String;
    //   165: invokevirtual 99	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   168: aload 9
    //   170: ldc 118
    //   172: aload_2
    //   173: getfield 120	ct/t$a:b	Ljava/lang/String;
    //   176: invokevirtual 99	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   179: aload 8
    //   181: ldc 122
    //   183: aconst_null
    //   184: aload 9
    //   186: invokevirtual 139	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   189: lstore_3
    //   190: new 40	java/lang/StringBuilder
    //   193: astore 8
    //   195: aload 8
    //   197: ldc -115
    //   199: invokespecial 144	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   202: ldc -110
    //   204: aload 8
    //   206: lload_3
    //   207: invokevirtual 149	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   210: ldc -105
    //   212: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload_1
    //   216: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: ldc -103
    //   221: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: aload_2
    //   225: getfield 127	ct/t$a:a	Ljava/lang/String;
    //   228: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: ldc -101
    //   233: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: aload_2
    //   237: invokevirtual 95	ct/t$a:a	()Ljava/lang/String;
    //   240: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: invokestatic 159	ct/bb:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   249: ldc2_w 160
    //   252: lload_3
    //   253: lcmp
    //   254: ifne -200 -> 54
    //   257: iconst_0
    //   258: istore 6
    //   260: goto -206 -> 54
    //   263: new 40	java/lang/StringBuilder
    //   266: astore 8
    //   268: aload 8
    //   270: ldc -93
    //   272: invokespecial 144	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   275: ldc -110
    //   277: aload 8
    //   279: iload 5
    //   281: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   284: ldc -105
    //   286: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: aload_1
    //   290: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: ldc -103
    //   295: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: aload_2
    //   299: getfield 127	ct/t$a:a	Ljava/lang/String;
    //   302: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: ldc -101
    //   307: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: aload_2
    //   311: invokevirtual 95	ct/t$a:a	()Ljava/lang/String;
    //   314: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokestatic 159	ct/bb:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   323: goto -66 -> 257
    //   326: astore_1
    //   327: aload_0
    //   328: monitorexit
    //   329: aload_1
    //   330: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	331	0	this	w
    //   0	331	1	paramString	String
    //   0	331	2	parama	t.a
    //   0	331	3	paramLong	long
    //   142	138	5	i	int
    //   1	258	6	bool1	boolean
    //   24	3	7	bool2	boolean
    //   9	269	8	localObject	Object
    //   40	3	9	localInterruptedException	InterruptedException
    //   62	123	9	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   31	37	40	java/lang/InterruptedException
    //   5	11	50	java/lang/Exception
    //   11	26	50	java/lang/Exception
    //   31	37	50	java/lang/Exception
    //   42	47	50	java/lang/Exception
    //   59	144	50	java/lang/Exception
    //   149	249	50	java/lang/Exception
    //   263	323	50	java/lang/Exception
    //   5	11	326	finally
    //   11	26	326	finally
    //   31	37	326	finally
    //   42	47	326	finally
    //   59	144	326	finally
    //   149	249	326	finally
    //   263	323	326	finally
  }
  
  public final t a(String paramString)
  {
    label278:
    label299:
    for (;;)
    {
      try
      {
        Object localObject1 = getReadableDatabase();
        boolean bool;
        if (!((SQLiteDatabase)localObject1).isDbLockedByOtherThreads())
        {
          bool = ((SQLiteDatabase)localObject1).isDbLockedByCurrentThread();
          if (!bool) {}
        }
        else
        {
          try
          {
            Thread.sleep(10L);
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
          continue;
        }
        Cursor localCursor;
        String str2;
        String str1;
        String str3;
        long l;
        t.a locala;
        paramString = null;
      }
      catch (Exception paramString)
      {
        localObject1 = null;
        return (t)localObject1;
      }
      finally
      {
        try
        {
          localCursor = ((SQLiteDatabase)localObject1).query("access_tbl", null, "apn=?", new String[] { paramString }, null, null, null);
          if (localCursor == null) {
            break label299;
          }
        }
        finally
        {
          paramString = null;
          if (paramString != null) {
            paramString.close();
          }
        }
        try
        {
          if (!localCursor.moveToFirst()) {
            break label299;
          }
          localObject1 = new ct/t;
          ((t)localObject1).<init>(paramString);
          str2 = localCursor.getString(localCursor.getColumnIndex("domain"));
          str1 = localCursor.getString(localCursor.getColumnIndex("iplist"));
          paramString = localCursor.getString(localCursor.getColumnIndex("last_suc_ip"));
          str3 = localCursor.getString(localCursor.getColumnIndex("rule"));
          l = localCursor.getLong(localCursor.getColumnIndex("schedule_lasttime"));
          localCursor.getLong(localCursor.getColumnIndex("apn_lasttime"));
          locala = new ct/t$a;
          locala.<init>(str2, l, str1, str3, paramString);
          ((t)localObject1).a(locala);
          bool = localCursor.moveToNext();
          if (bool) {
            continue;
          }
          paramString = (String)localObject1;
          localObject1 = paramString;
          if (localCursor == null) {
            continue;
          }
          localCursor.close();
        }
        finally
        {
          paramString = localCursor;
          break label278;
        }
        paramString = finally;
      }
    }
  }
  
  /* Error */
  public final void a(t paramt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: ifnonnull +6 -> 11
    //   8: aload_0
    //   9: monitorexit
    //   10: return
    //   11: aload_1
    //   12: getfield 214	ct/t:b	Ljava/util/Map;
    //   15: astore 6
    //   17: invokestatic 220	android/os/SystemClock:elapsedRealtime	()J
    //   20: lstore 4
    //   22: aload 6
    //   24: invokeinterface 226 1 0
    //   29: invokeinterface 232 1 0
    //   34: astore 6
    //   36: aload 6
    //   38: invokeinterface 237 1 0
    //   43: ifeq +37 -> 80
    //   46: aload 6
    //   48: invokeinterface 241 1 0
    //   53: checkcast 93	ct/t$a
    //   56: astore 7
    //   58: aload_0
    //   59: aload_1
    //   60: getfield 242	ct/t:a	Ljava/lang/String;
    //   63: aload 7
    //   65: lload 4
    //   67: invokespecial 244	ct/w:a	(Ljava/lang/String;Lct/t$a;J)Z
    //   70: istore_3
    //   71: iload_3
    //   72: ifeq +284 -> 356
    //   75: iconst_1
    //   76: istore_2
    //   77: goto -41 -> 36
    //   80: iload_2
    //   81: ifeq -73 -> 8
    //   84: ldc -110
    //   86: ldc -10
    //   88: invokestatic 249	ct/bb:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: aload_0
    //   92: invokevirtual 68	ct/w:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   95: astore 7
    //   97: aload 7
    //   99: invokevirtual 74	android/database/sqlite/SQLiteDatabase:isDbLockedByOtherThreads	()Z
    //   102: ifne +13 -> 115
    //   105: aload 7
    //   107: invokevirtual 77	android/database/sqlite/SQLiteDatabase:isDbLockedByCurrentThread	()Z
    //   110: istore_3
    //   111: iload_3
    //   112: ifeq +24 -> 136
    //   115: ldc2_w 78
    //   118: invokestatic 85	java/lang/Thread:sleep	(J)V
    //   121: goto -24 -> 97
    //   124: astore_1
    //   125: aload_1
    //   126: invokevirtual 86	java/lang/InterruptedException:printStackTrace	()V
    //   129: goto -32 -> 97
    //   132: astore_1
    //   133: goto -125 -> 8
    //   136: aload 7
    //   138: ldc 122
    //   140: iconst_1
    //   141: anewarray 126	java/lang/String
    //   144: dup
    //   145: iconst_0
    //   146: ldc -123
    //   148: aastore
    //   149: aconst_null
    //   150: aconst_null
    //   151: ldc -123
    //   153: aconst_null
    //   154: ldc 116
    //   156: invokevirtual 176	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   159: astore_1
    //   160: aload_1
    //   161: ifnull +188 -> 349
    //   164: aload_1
    //   165: invokeinterface 253 1 0
    //   170: invokestatic 258	ct/b$a:b	()Lct/b$a;
    //   173: getfield 261	ct/b$a:b	Lct/e;
    //   176: getfield 266	ct/e:c	I
    //   179: if_icmple +170 -> 349
    //   182: aload_1
    //   183: invokeinterface 181 1 0
    //   188: ifeq +161 -> 349
    //   191: aload_1
    //   192: aload_1
    //   193: ldc -123
    //   195: invokeinterface 188 2 0
    //   200: invokeinterface 192 2 0
    //   205: astore 6
    //   207: aload 6
    //   209: invokestatic 272	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   212: ifne +137 -> 349
    //   215: new 40	java/lang/StringBuilder
    //   218: astore 8
    //   220: aload 8
    //   222: ldc_w 274
    //   225: invokespecial 144	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   228: ldc -110
    //   230: aload 8
    //   232: aload 6
    //   234: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 249	ct/bb:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: aload_1
    //   244: ifnull +9 -> 253
    //   247: aload_1
    //   248: invokeinterface 210 1 0
    //   253: aload 6
    //   255: invokestatic 272	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   258: ifne -250 -> 8
    //   261: aload 7
    //   263: ldc 122
    //   265: ldc -84
    //   267: iconst_1
    //   268: anewarray 126	java/lang/String
    //   271: dup
    //   272: iconst_0
    //   273: aload 6
    //   275: aastore
    //   276: invokevirtual 278	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   279: istore_2
    //   280: new 40	java/lang/StringBuilder
    //   283: astore_1
    //   284: aload_1
    //   285: ldc_w 280
    //   288: invokespecial 144	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   291: ldc -110
    //   293: aload_1
    //   294: aload 6
    //   296: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: ldc_w 282
    //   302: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: iload_2
    //   306: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   309: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokestatic 249	ct/bb:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   315: goto -307 -> 8
    //   318: astore_1
    //   319: aload_0
    //   320: monitorexit
    //   321: aload_1
    //   322: athrow
    //   323: astore 6
    //   325: aconst_null
    //   326: astore_1
    //   327: aload_1
    //   328: ifnull +9 -> 337
    //   331: aload_1
    //   332: invokeinterface 210 1 0
    //   337: aload 6
    //   339: athrow
    //   340: astore_1
    //   341: goto -333 -> 8
    //   344: astore 6
    //   346: goto -19 -> 327
    //   349: ldc 14
    //   351: astore 6
    //   353: goto -110 -> 243
    //   356: goto -279 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	359	0	this	w
    //   0	359	1	paramt	t
    //   1	305	2	i	int
    //   70	42	3	bool	boolean
    //   20	46	4	l	long
    //   15	280	6	localObject1	Object
    //   323	15	6	localObject2	Object
    //   344	1	6	localObject3	Object
    //   351	1	6	str	String
    //   56	206	7	localObject4	Object
    //   218	13	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   115	121	124	java/lang/InterruptedException
    //   84	97	132	java/lang/Exception
    //   97	111	132	java/lang/Exception
    //   115	121	132	java/lang/Exception
    //   125	129	132	java/lang/Exception
    //   247	253	132	java/lang/Exception
    //   253	315	132	java/lang/Exception
    //   331	337	132	java/lang/Exception
    //   337	340	132	java/lang/Exception
    //   11	36	318	finally
    //   36	71	318	finally
    //   84	97	318	finally
    //   97	111	318	finally
    //   115	121	318	finally
    //   125	129	318	finally
    //   247	253	318	finally
    //   253	315	318	finally
    //   331	337	318	finally
    //   337	340	318	finally
    //   136	160	323	finally
    //   11	36	340	java/lang/Exception
    //   36	71	340	java/lang/Exception
    //   164	243	344	finally
  }
  
  /* Error */
  public final void a(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 68	ct/w:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   6: astore 6
    //   8: aload 6
    //   10: invokevirtual 74	android/database/sqlite/SQLiteDatabase:isDbLockedByOtherThreads	()Z
    //   13: ifne +15 -> 28
    //   16: aload 6
    //   18: invokevirtual 77	android/database/sqlite/SQLiteDatabase:isDbLockedByCurrentThread	()Z
    //   21: istore 5
    //   23: iload 5
    //   25: ifeq +26 -> 51
    //   28: ldc2_w 78
    //   31: invokestatic 85	java/lang/Thread:sleep	(J)V
    //   34: goto -26 -> 8
    //   37: astore 7
    //   39: aload 7
    //   41: invokevirtual 86	java/lang/InterruptedException:printStackTrace	()V
    //   44: goto -36 -> 8
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: return
    //   51: new 88	android/content/ContentValues
    //   54: astore 7
    //   56: aload 7
    //   58: invokespecial 89	android/content/ContentValues:<init>	()V
    //   61: aload 7
    //   63: ldc -62
    //   65: aload_3
    //   66: invokevirtual 99	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: aload 6
    //   71: ldc 122
    //   73: aload 7
    //   75: ldc 124
    //   77: iconst_2
    //   78: anewarray 126	java/lang/String
    //   81: dup
    //   82: iconst_0
    //   83: aload_1
    //   84: aastore
    //   85: dup
    //   86: iconst_1
    //   87: aload_2
    //   88: aastore
    //   89: invokevirtual 131	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   92: istore 4
    //   94: new 40	java/lang/StringBuilder
    //   97: astore_2
    //   98: aload_2
    //   99: ldc_w 285
    //   102: invokespecial 144	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   105: ldc -110
    //   107: aload_2
    //   108: aload_1
    //   109: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: ldc_w 287
    //   115: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: iload 4
    //   120: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   123: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 159	ct/bb:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   129: goto -81 -> 48
    //   132: astore_1
    //   133: aload_0
    //   134: monitorexit
    //   135: aload_1
    //   136: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	this	w
    //   0	137	1	paramString1	String
    //   0	137	2	paramString2	String
    //   0	137	3	paramString3	String
    //   92	27	4	i	int
    //   21	3	5	bool	boolean
    //   6	64	6	localSQLiteDatabase	SQLiteDatabase
    //   37	3	7	localInterruptedException	InterruptedException
    //   54	20	7	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   28	34	37	java/lang/InterruptedException
    //   2	8	47	java/lang/Exception
    //   8	23	47	java/lang/Exception
    //   28	34	47	java/lang/Exception
    //   39	44	47	java/lang/Exception
    //   51	129	47	java/lang/Exception
    //   2	8	132	finally
    //   8	23	132	finally
    //   28	34	132	finally
    //   39	44	132	finally
    //   51	129	132	finally
  }
  
  /* Error */
  public final void b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 68	ct/w:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   6: astore 4
    //   8: aload 4
    //   10: invokevirtual 74	android/database/sqlite/SQLiteDatabase:isDbLockedByOtherThreads	()Z
    //   13: ifne +13 -> 26
    //   16: aload 4
    //   18: invokevirtual 77	android/database/sqlite/SQLiteDatabase:isDbLockedByCurrentThread	()Z
    //   21: istore_3
    //   22: iload_3
    //   23: ifeq +26 -> 49
    //   26: ldc2_w 78
    //   29: invokestatic 85	java/lang/Thread:sleep	(J)V
    //   32: goto -24 -> 8
    //   35: astore 5
    //   37: aload 5
    //   39: invokevirtual 86	java/lang/InterruptedException:printStackTrace	()V
    //   42: goto -34 -> 8
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: new 88	android/content/ContentValues
    //   52: astore 5
    //   54: aload 5
    //   56: invokespecial 89	android/content/ContentValues:<init>	()V
    //   59: aload 5
    //   61: ldc 116
    //   63: invokestatic 220	android/os/SystemClock:elapsedRealtime	()J
    //   66: invokestatic 111	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   69: invokevirtual 114	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   72: aload 4
    //   74: ldc 122
    //   76: aload 5
    //   78: ldc -84
    //   80: iconst_1
    //   81: anewarray 126	java/lang/String
    //   84: dup
    //   85: iconst_0
    //   86: aload_1
    //   87: aastore
    //   88: invokevirtual 131	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   91: istore_2
    //   92: new 40	java/lang/StringBuilder
    //   95: astore 4
    //   97: aload 4
    //   99: ldc_w 285
    //   102: invokespecial 144	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   105: ldc -110
    //   107: aload 4
    //   109: aload_1
    //   110: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: ldc_w 287
    //   116: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: iload_2
    //   120: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   123: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 159	ct/bb:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   129: goto -83 -> 46
    //   132: astore_1
    //   133: aload_0
    //   134: monitorexit
    //   135: aload_1
    //   136: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	this	w
    //   0	137	1	paramString	String
    //   91	29	2	i	int
    //   21	2	3	bool	boolean
    //   6	102	4	localObject	Object
    //   35	3	5	localInterruptedException	InterruptedException
    //   52	25	5	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   26	32	35	java/lang/InterruptedException
    //   2	8	45	java/lang/Exception
    //   8	22	45	java/lang/Exception
    //   26	32	45	java/lang/Exception
    //   37	42	45	java/lang/Exception
    //   49	129	45	java/lang/Exception
    //   2	8	132	finally
    //   8	22	132	finally
    //   26	32	132	finally
    //   37	42	132	finally
    //   49	129	132	finally
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS access_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,apn TEXT,domain TEXT,rule TEXT,iplist TEXT,last_suc_ip TEXT,apn_lasttime INTEGER,schedule_lasttime INTEGER);");
      bb.b("DataAccessDBImpl", "db created.");
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      for (;;)
      {
        paramSQLiteDatabase.printStackTrace();
        bb.a("DataAccessDBImpl", "db create failed.", paramSQLiteDatabase);
      }
    }
  }
  
  /* Error */
  public final void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 306	android/database/sqlite/SQLiteOpenHelper:onOpen	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   5: aload_1
    //   6: invokevirtual 309	android/database/sqlite/SQLiteDatabase:getVersion	()I
    //   9: istore_2
    //   10: iload_2
    //   11: ifeq +30 -> 41
    //   14: iload_2
    //   15: iconst_4
    //   16: if_icmpge +33 -> 49
    //   19: aload_1
    //   20: ldc_w 311
    //   23: invokevirtual 294	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   26: aload_1
    //   27: ldc_w 291
    //   30: invokevirtual 294	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   33: ldc -110
    //   35: ldc_w 296
    //   38: invokestatic 159	ct/bb:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: return
    //   42: astore_1
    //   43: aload_1
    //   44: athrow
    //   45: astore_1
    //   46: goto -5 -> 41
    //   49: iload_2
    //   50: iconst_4
    //   51: if_icmple -10 -> 41
    //   54: aload_1
    //   55: ldc_w 311
    //   58: invokevirtual 294	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   61: aload_1
    //   62: ldc_w 291
    //   65: invokevirtual 294	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   68: ldc -110
    //   70: ldc_w 296
    //   73: invokestatic 159	ct/bb:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: goto -35 -> 41
    //   79: astore_1
    //   80: aload_1
    //   81: athrow
    //   82: astore_1
    //   83: goto -42 -> 41
    //   86: astore_1
    //   87: goto -46 -> 41
    //   90: astore_3
    //   91: goto -30 -> 61
    //   94: astore_3
    //   95: goto -69 -> 26
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	w
    //   0	98	1	paramSQLiteDatabase	SQLiteDatabase
    //   9	43	2	i	int
    //   90	1	3	localSQLException1	SQLException
    //   94	1	3	localSQLException2	SQLException
    // Exception table:
    //   from	to	target	type
    //   26	41	42	android/database/SQLException
    //   19	26	45	java/lang/Exception
    //   26	41	45	java/lang/Exception
    //   43	45	45	java/lang/Exception
    //   61	76	79	android/database/SQLException
    //   54	61	82	java/lang/Exception
    //   61	76	82	java/lang/Exception
    //   80	82	82	java/lang/Exception
    //   5	10	86	java/lang/Exception
    //   54	61	90	android/database/SQLException
    //   19	26	94	android/database/SQLException
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS access_tbl");
      try
      {
        paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS access_tbl (key INTEGER PRIMARY KEY AUTOINCREMENT,apn TEXT,domain TEXT,rule TEXT,iplist TEXT,last_suc_ip TEXT,apn_lasttime INTEGER,schedule_lasttime INTEGER);");
        bb.b("DataAccessDBImpl", "db created.");
        return;
      }
      catch (SQLException paramSQLiteDatabase)
      {
        throw paramSQLiteDatabase;
      }
    }
    catch (Exception paramSQLiteDatabase)
    {
      for (;;) {}
    }
    catch (SQLException localSQLException)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */