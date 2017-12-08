package com.lantern.mailbox.c;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import com.lantern.core.o;
import java.util.Iterator;
import java.util.List;

public final class a
  extends SQLiteOpenHelper
{
  private static a a;
  private static SharedPreferences c;
  private boolean b;
  
  private a(Context paramContext)
  {
    super(paramContext, "mailbox.db" + com.lantern.core.c.getServer().h(), null, 1);
  }
  
  private SQLiteDatabase a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (SQLiteDatabase localSQLiteDatabase = getWritableDatabase();; localSQLiteDatabase = getReadableDatabase()) {
      return localSQLiteDatabase;
    }
  }
  
  public static a a()
  {
    int i = 0;
    if (a != null)
    {
      String str = com.lantern.core.c.getServer().h();
      if (c == null) {
        c = com.lantern.core.c.getAppContext().getSharedPreferences("MAILBOX_SP", 0);
      }
      if (!c.getString("id", "0").equals(str))
      {
        SharedPreferences.Editor localEditor = c.edit();
        localEditor.putString("id", str);
        localEditor.apply();
        i = 1;
      }
      if (i == 0) {}
    }
    else
    {
      a = new a(com.lantern.core.c.getAppContext());
    }
    return a;
  }
  
  private void a(List<com.lantern.mailbox.d.a> paramList)
  {
    SQLiteDatabase localSQLiteDatabase = a(true);
    for (;;)
    {
      try
      {
        localSQLiteDatabase.beginTransaction();
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break;
        }
        com.lantern.mailbox.d.a locala = (com.lantern.mailbox.d.a)paramList.next();
        if (locala.g())
        {
          ContentValues localContentValues = new android/content/ContentValues;
          localContentValues.<init>();
          localContentValues.put("LID", Long.valueOf(Long.parseLong(locala.j())));
          localContentValues.put("MSOURCE", locala.k());
          localContentValues.put("BEFORE", locala.b());
          localContentValues.put("AFTER", locala.c());
          localContentValues.put("CCONTENT", locala.l());
          localContentValues.put("CUHID", locala.m());
          localContentValues.put("CHEADIMG", locala.n());
          localContentValues.put("TYPE", locala.o());
          localContentValues.put("BIZID", locala.p());
          localContentValues.put("CURL", locala.q());
          localContentValues.put("CNICKNAME", locala.r());
          localContentValues.put("TIME", Long.valueOf(locala.i()));
          int i;
          if (locala.h())
          {
            i = 0;
            localContentValues.put("UNREAD", Integer.valueOf(i));
            localContentValues.put("ICON", com.lantern.mailbox.e.b.a(locala.e()));
            localContentValues.put("COUNT", Integer.valueOf(locala.d()));
            localContentValues.put("BAR", locala.a());
            localSQLiteDatabase.insert("MESSAGE", null, localContentValues);
          }
          else
          {
            i = 1;
          }
        }
      }
      finally
      {
        localSQLiteDatabase.endTransaction();
      }
    }
    localSQLiteDatabase.setTransactionSuccessful();
    localSQLiteDatabase.endTransaction();
  }
  
  /* Error */
  public final List<com.lantern.mailbox.d.a> a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 264	com/lantern/mailbox/c/a:b	Z
    //   6: istore 4
    //   8: iload 4
    //   10: ifeq +7 -> 17
    //   13: aload_0
    //   14: invokevirtual 269	java/lang/Object:wait	()V
    //   17: new 271	java/util/ArrayList
    //   20: astore 7
    //   22: aload 7
    //   24: invokespecial 272	java/util/ArrayList:<init>	()V
    //   27: aload_0
    //   28: iconst_0
    //   29: invokespecial 46	com/lantern/mailbox/c/a:a	(Z)Landroid/database/sqlite/SQLiteDatabase;
    //   32: astore 8
    //   34: new 14	java/lang/StringBuilder
    //   37: astore 6
    //   39: aload 6
    //   41: ldc -121
    //   43: invokespecial 19	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   46: iload_3
    //   47: ifeq +391 -> 438
    //   50: ldc_w 274
    //   53: astore 5
    //   55: aload 6
    //   57: aload 5
    //   59: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: ldc_w 276
    //   65: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: astore 9
    //   73: iload_2
    //   74: ifeq +372 -> 446
    //   77: ldc 74
    //   79: astore 5
    //   81: iload_2
    //   82: ifeq +372 -> 454
    //   85: aconst_null
    //   86: astore 6
    //   88: aload 8
    //   90: ldc -9
    //   92: aconst_null
    //   93: aload 9
    //   95: iconst_2
    //   96: anewarray 82	java/lang/String
    //   99: dup
    //   100: iconst_0
    //   101: aload_1
    //   102: aastore
    //   103: dup
    //   104: iconst_1
    //   105: aload 5
    //   107: aastore
    //   108: aconst_null
    //   109: aconst_null
    //   110: ldc_w 278
    //   113: aload 6
    //   115: invokevirtual 282	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   118: astore 5
    //   120: aload 5
    //   122: invokeinterface 287 1 0
    //   127: pop
    //   128: aload 5
    //   130: invokeinterface 290 1 0
    //   135: ifne +337 -> 472
    //   138: new 126	com/lantern/mailbox/d/a
    //   141: astore 6
    //   143: aload 6
    //   145: invokespecial 291	com/lantern/mailbox/d/a:<init>	()V
    //   148: aload 6
    //   150: aload 5
    //   152: iconst_1
    //   153: invokeinterface 295 2 0
    //   158: invokestatic 298	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   161: invokevirtual 300	com/lantern/mailbox/d/a:d	(Ljava/lang/String;)V
    //   164: aload 6
    //   166: aload 5
    //   168: iconst_2
    //   169: invokeinterface 303 2 0
    //   174: invokevirtual 305	com/lantern/mailbox/d/a:e	(Ljava/lang/String;)V
    //   177: aload 6
    //   179: aload 5
    //   181: iconst_5
    //   182: invokeinterface 303 2 0
    //   187: invokevirtual 308	com/lantern/mailbox/d/a:f	(Ljava/lang/String;)V
    //   190: aload 6
    //   192: aload 5
    //   194: bipush 6
    //   196: invokeinterface 303 2 0
    //   201: invokevirtual 310	com/lantern/mailbox/d/a:g	(Ljava/lang/String;)V
    //   204: aload 6
    //   206: aload 5
    //   208: bipush 7
    //   210: invokeinterface 303 2 0
    //   215: invokevirtual 312	com/lantern/mailbox/d/a:h	(Ljava/lang/String;)V
    //   218: aload 6
    //   220: aload 5
    //   222: bipush 8
    //   224: invokeinterface 303 2 0
    //   229: invokevirtual 314	com/lantern/mailbox/d/a:i	(Ljava/lang/String;)V
    //   232: aload 6
    //   234: aload 5
    //   236: bipush 9
    //   238: invokeinterface 303 2 0
    //   243: invokevirtual 316	com/lantern/mailbox/d/a:j	(Ljava/lang/String;)V
    //   246: aload 6
    //   248: aload 5
    //   250: bipush 10
    //   252: invokeinterface 303 2 0
    //   257: invokevirtual 318	com/lantern/mailbox/d/a:k	(Ljava/lang/String;)V
    //   260: aload 6
    //   262: aload 5
    //   264: bipush 11
    //   266: invokeinterface 303 2 0
    //   271: invokevirtual 320	com/lantern/mailbox/d/a:l	(Ljava/lang/String;)V
    //   274: aload 6
    //   276: aload 5
    //   278: bipush 12
    //   280: invokeinterface 295 2 0
    //   285: invokevirtual 323	com/lantern/mailbox/d/a:a	(J)V
    //   288: aload 5
    //   290: bipush 13
    //   292: invokeinterface 327 2 0
    //   297: ifne +165 -> 462
    //   300: iconst_1
    //   301: istore_2
    //   302: aload 6
    //   304: iload_2
    //   305: invokevirtual 330	com/lantern/mailbox/d/a:c	(Z)V
    //   308: aload 5
    //   310: bipush 14
    //   312: invokeinterface 334 2 0
    //   317: astore_1
    //   318: aload_1
    //   319: ifnull +148 -> 467
    //   322: aload_1
    //   323: iconst_0
    //   324: aload_1
    //   325: arraylength
    //   326: invokestatic 340	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   329: astore_1
    //   330: aload 6
    //   332: aload_1
    //   333: invokevirtual 343	com/lantern/mailbox/d/a:a	(Landroid/graphics/Bitmap;)V
    //   336: aload 6
    //   338: aload 5
    //   340: bipush 15
    //   342: invokeinterface 327 2 0
    //   347: invokevirtual 346	com/lantern/mailbox/d/a:a	(I)V
    //   350: aload 6
    //   352: aload 5
    //   354: iconst_3
    //   355: invokeinterface 303 2 0
    //   360: invokevirtual 348	com/lantern/mailbox/d/a:b	(Ljava/lang/String;)V
    //   363: aload 6
    //   365: aload 5
    //   367: iconst_4
    //   368: invokeinterface 303 2 0
    //   373: invokevirtual 350	com/lantern/mailbox/d/a:c	(Ljava/lang/String;)V
    //   376: aload 6
    //   378: aload 5
    //   380: bipush 16
    //   382: invokeinterface 303 2 0
    //   387: invokevirtual 352	com/lantern/mailbox/d/a:a	(Ljava/lang/String;)V
    //   390: aload 6
    //   392: iconst_1
    //   393: invokevirtual 354	com/lantern/mailbox/d/a:b	(Z)V
    //   396: aload 6
    //   398: iconst_0
    //   399: invokevirtual 356	com/lantern/mailbox/d/a:a	(Z)V
    //   402: aload 7
    //   404: aload 6
    //   406: invokeinterface 359 2 0
    //   411: pop
    //   412: aload 5
    //   414: invokeinterface 362 1 0
    //   419: pop
    //   420: goto -292 -> 128
    //   423: astore_1
    //   424: aload_0
    //   425: monitorexit
    //   426: aload_1
    //   427: athrow
    //   428: astore 5
    //   430: aload 5
    //   432: invokevirtual 365	java/lang/InterruptedException:printStackTrace	()V
    //   435: goto -418 -> 17
    //   438: ldc_w 367
    //   441: astore 5
    //   443: goto -388 -> 55
    //   446: ldc_w 369
    //   449: astore 5
    //   451: goto -370 -> 81
    //   454: ldc_w 371
    //   457: astore 6
    //   459: goto -371 -> 88
    //   462: iconst_0
    //   463: istore_2
    //   464: goto -162 -> 302
    //   467: aconst_null
    //   468: astore_1
    //   469: goto -139 -> 330
    //   472: aload 5
    //   474: invokeinterface 374 1 0
    //   479: aload_0
    //   480: monitorexit
    //   481: aload 7
    //   483: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	484	0	this	a
    //   0	484	1	paramString	String
    //   0	484	2	paramBoolean1	boolean
    //   0	484	3	paramBoolean2	boolean
    //   6	3	4	bool	boolean
    //   53	360	5	localObject1	Object
    //   428	3	5	localInterruptedException	InterruptedException
    //   441	32	5	str1	String
    //   37	421	6	localObject2	Object
    //   20	462	7	localArrayList	java.util.ArrayList
    //   32	57	8	localSQLiteDatabase	SQLiteDatabase
    //   71	23	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   2	8	423	finally
    //   13	17	423	finally
    //   17	46	423	finally
    //   55	73	423	finally
    //   88	128	423	finally
    //   128	300	423	finally
    //   302	318	423	finally
    //   322	330	423	finally
    //   330	420	423	finally
    //   430	435	423	finally
    //   472	479	423	finally
    //   13	17	428	java/lang/InterruptedException
  }
  
  public final void a(com.lantern.mailbox.d.a parama, Bitmap paramBitmap)
  {
    new Thread(new c(this, parama, paramBitmap)).start();
  }
  
  public final void a(String paramString)
  {
    new Thread(new b(this, paramString)).start();
  }
  
  /* Error */
  public final void a(List<com.lantern.mailbox.d.a> paramList1, List<com.lantern.mailbox.d.a> paramList2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield 264	com/lantern/mailbox/c/a:b	Z
    //   7: aload_0
    //   8: iconst_1
    //   9: invokespecial 46	com/lantern/mailbox/c/a:a	(Z)Landroid/database/sqlite/SQLiteDatabase;
    //   12: astore_3
    //   13: aload_3
    //   14: invokevirtual 108	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   17: aload_1
    //   18: invokeinterface 114 1 0
    //   23: astore 4
    //   25: aload 4
    //   27: invokeinterface 120 1 0
    //   32: ifeq +133 -> 165
    //   35: aload 4
    //   37: invokeinterface 124 1 0
    //   42: checkcast 126	com/lantern/mailbox/d/a
    //   45: astore 5
    //   47: aload 5
    //   49: invokevirtual 399	com/lantern/mailbox/d/a:f	()Z
    //   52: ifeq -27 -> 25
    //   55: new 131	android/content/ContentValues
    //   58: astore_1
    //   59: aload_1
    //   60: invokespecial 133	android/content/ContentValues:<init>	()V
    //   63: aload_1
    //   64: ldc -76
    //   66: aload 5
    //   68: invokevirtual 183	com/lantern/mailbox/d/a:n	()Ljava/lang/String;
    //   71: invokevirtual 160	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: aload_1
    //   75: ldc -56
    //   77: aload 5
    //   79: invokevirtual 203	com/lantern/mailbox/d/a:r	()Ljava/lang/String;
    //   82: invokevirtual 160	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: aload_1
    //   86: ldc -33
    //   88: aload 5
    //   90: invokevirtual 227	com/lantern/mailbox/d/a:e	()Landroid/graphics/Bitmap;
    //   93: invokestatic 232	com/lantern/mailbox/e/b:a	(Landroid/graphics/Bitmap;)[B
    //   96: invokevirtual 235	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   99: aload_1
    //   100: ldc -19
    //   102: aload 5
    //   104: invokevirtual 241	com/lantern/mailbox/d/a:d	()I
    //   107: invokestatic 218	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   110: invokevirtual 221	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   113: aload_3
    //   114: ldc -9
    //   116: aload_1
    //   117: ldc_w 401
    //   120: iconst_1
    //   121: anewarray 82	java/lang/String
    //   124: dup
    //   125: iconst_0
    //   126: aload 5
    //   128: invokevirtual 138	com/lantern/mailbox/d/a:j	()Ljava/lang/String;
    //   131: aastore
    //   132: invokevirtual 405	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   135: pop
    //   136: goto -111 -> 25
    //   139: astore_1
    //   140: aload_1
    //   141: invokevirtual 406	java/lang/Exception:printStackTrace	()V
    //   144: aload_3
    //   145: invokevirtual 254	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   148: aload_0
    //   149: aload_2
    //   150: invokespecial 408	com/lantern/mailbox/c/a:a	(Ljava/util/List;)V
    //   153: aload_0
    //   154: iconst_0
    //   155: putfield 264	com/lantern/mailbox/c/a:b	Z
    //   158: aload_0
    //   159: invokevirtual 411	java/lang/Object:notify	()V
    //   162: aload_0
    //   163: monitorexit
    //   164: return
    //   165: aload_3
    //   166: invokevirtual 257	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   169: aload_3
    //   170: invokevirtual 254	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   173: goto -25 -> 148
    //   176: astore_1
    //   177: aload_0
    //   178: monitorexit
    //   179: aload_1
    //   180: athrow
    //   181: astore_1
    //   182: aload_3
    //   183: invokevirtual 254	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   186: aload_1
    //   187: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	this	a
    //   0	188	1	paramList1	List<com.lantern.mailbox.d.a>
    //   0	188	2	paramList2	List<com.lantern.mailbox.d.a>
    //   12	171	3	localSQLiteDatabase	SQLiteDatabase
    //   23	13	4	localIterator	Iterator
    //   45	82	5	locala	com.lantern.mailbox.d.a
    // Exception table:
    //   from	to	target	type
    //   13	25	139	java/lang/Exception
    //   25	136	139	java/lang/Exception
    //   165	169	139	java/lang/Exception
    //   2	13	176	finally
    //   144	148	176	finally
    //   148	162	176	finally
    //   169	173	176	finally
    //   182	188	176	finally
    //   13	25	181	finally
    //   25	136	181	finally
    //   140	144	181	finally
    //   165	169	181	finally
  }
  
  public final String b()
  {
    if (this.b) {}
    try
    {
      wait();
      Object localObject = a(false).query("MESSAGE", new String[] { "LID" }, null, null, null, null, "LID desc", "1");
      if (((Cursor)localObject).getCount() > 0)
      {
        ((Cursor)localObject).moveToFirst();
        localObject = String.valueOf(((Cursor)localObject).getLong(0));
        return (String)localObject;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
        continue;
        localInterruptedException.close();
        String str = "-1";
      }
    }
  }
  
  public final void c()
  {
    try
    {
      this.b = true;
      SQLiteDatabase localSQLiteDatabase = a(true);
      Cursor localCursor = localSQLiteDatabase.query("MESSAGE", new String[] { "LID", "UNREAD" }, null, null, null, null, "LID desc");
      localCursor.moveToFirst();
      while (!localCursor.isAfterLast())
      {
        long l = localCursor.getLong(0);
        if (localCursor.getInt(1) == 0)
        {
          ContentValues localContentValues = new android/content/ContentValues;
          localContentValues.<init>();
          localContentValues.put("UNREAD", Integer.valueOf(1));
          localSQLiteDatabase.update("MESSAGE", localContentValues, "LID=?", new String[] { String.valueOf(l) });
        }
        localCursor.moveToNext();
      }
      ((Cursor)localObject).close();
    }
    finally {}
    this.b = false;
    notify();
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS MESSAGE (_id INTEGER PRIMARY KEY AUTOINCREMENT, LID LONG, MSOURCE TEXT, BEFORE TEXT, AFTER TEXT, CCONTENT TEXT, CUHID TEXT, CHEADIMG TEXT, TYPE TEXT, BIZID TEXT, CURL TEXT, CNICKNAME TEXT, TIME LONG , UNREAD INT , ICON BLOB , COUNT INT, BAR TEXT)");
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      for (;;)
      {
        paramSQLiteDatabase.printStackTrace();
      }
    }
  }
  
  public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS MESSAGE");
      onCreate(paramSQLiteDatabase);
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      for (;;)
      {
        paramSQLiteDatabase.printStackTrace();
      }
    }
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS MESSAGE");
      onCreate(paramSQLiteDatabase);
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      for (;;)
      {
        paramSQLiteDatabase.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/mailbox/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */