package com.alipay.sdk.i;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.lang.ref.WeakReference;

public final class a
  extends SQLiteOpenHelper
{
  private WeakReference a;
  
  public a(Context paramContext)
  {
    super(paramContext, "msp.db", null, 1);
    this.a = new WeakReference(paramContext);
  }
  
  private static boolean a(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2)
  {
    boolean bool = true;
    SQLiteDatabase localSQLiteDatabase2 = null;
    SQLiteDatabase localSQLiteDatabase1 = null;
    for (;;)
    {
      try
      {
        paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("select count(*) from tb_tid where name=?", new String[] { c(paramString1, paramString2) });
        localSQLiteDatabase1 = paramSQLiteDatabase;
        localSQLiteDatabase2 = paramSQLiteDatabase;
        if (!paramSQLiteDatabase.moveToFirst()) {
          break label113;
        }
        localSQLiteDatabase1 = paramSQLiteDatabase;
        localSQLiteDatabase2 = paramSQLiteDatabase;
        i = paramSQLiteDatabase.getInt(0);
      }
      catch (Exception paramSQLiteDatabase)
      {
        if (localSQLiteDatabase1 == null) {
          continue;
        }
        localSQLiteDatabase1.close();
        i = 0;
        continue;
      }
      finally
      {
        if (localSQLiteDatabase2 == null) {
          continue;
        }
        localSQLiteDatabase2.close();
      }
      if (i > 0) {
        return bool;
      }
      bool = false;
      continue;
      label113:
      int i = 0;
    }
  }
  
  private static String c(String paramString1, String paramString2)
  {
    return paramString1 + paramString2;
  }
  
  /* Error */
  public final String a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokevirtual 68	com/alipay/sdk/i/a:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   7: astore_3
    //   8: aload_3
    //   9: ldc 70
    //   11: iconst_1
    //   12: anewarray 28	java/lang/String
    //   15: dup
    //   16: iconst_0
    //   17: aload_1
    //   18: aload_2
    //   19: invokestatic 32	com/alipay/sdk/i/a:c	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   22: aastore
    //   23: invokevirtual 38	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   26: astore_1
    //   27: aload 4
    //   29: astore_2
    //   30: aload_1
    //   31: invokeinterface 44 1 0
    //   36: ifeq +11 -> 47
    //   39: aload_1
    //   40: iconst_0
    //   41: invokeinterface 74 2 0
    //   46: astore_2
    //   47: aload_1
    //   48: ifnull +9 -> 57
    //   51: aload_1
    //   52: invokeinterface 52 1 0
    //   57: aload_3
    //   58: ifnull +14 -> 72
    //   61: aload_3
    //   62: invokevirtual 77	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   65: ifeq +7 -> 72
    //   68: aload_3
    //   69: invokevirtual 78	android/database/sqlite/SQLiteDatabase:close	()V
    //   72: aload_2
    //   73: astore_1
    //   74: aload_1
    //   75: astore_2
    //   76: aload_1
    //   77: invokestatic 84	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   80: ifne +22 -> 102
    //   83: iconst_2
    //   84: aload_1
    //   85: aload_0
    //   86: getfield 20	com/alipay/sdk/i/a:a	Ljava/lang/ref/WeakReference;
    //   89: invokevirtual 88	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   92: checkcast 90	android/content/Context
    //   95: invokestatic 95	com/alipay/sdk/j/b:c	(Landroid/content/Context;)Ljava/lang/String;
    //   98: invokestatic 100	com/alipay/sdk/d/b:a	(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   101: astore_2
    //   102: aload_2
    //   103: areturn
    //   104: astore_1
    //   105: aconst_null
    //   106: astore_1
    //   107: aconst_null
    //   108: astore_3
    //   109: aload_1
    //   110: ifnull +9 -> 119
    //   113: aload_1
    //   114: invokeinterface 52 1 0
    //   119: aload_3
    //   120: ifnull +14 -> 134
    //   123: aload_3
    //   124: invokevirtual 77	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   127: ifeq +7 -> 134
    //   130: aload_3
    //   131: invokevirtual 78	android/database/sqlite/SQLiteDatabase:close	()V
    //   134: aconst_null
    //   135: astore_1
    //   136: goto -62 -> 74
    //   139: astore_2
    //   140: aconst_null
    //   141: astore_3
    //   142: aconst_null
    //   143: astore_1
    //   144: aload_1
    //   145: ifnull +9 -> 154
    //   148: aload_1
    //   149: invokeinterface 52 1 0
    //   154: aload_3
    //   155: ifnull +14 -> 169
    //   158: aload_3
    //   159: invokevirtual 77	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   162: ifeq +7 -> 169
    //   165: aload_3
    //   166: invokevirtual 78	android/database/sqlite/SQLiteDatabase:close	()V
    //   169: aload_2
    //   170: athrow
    //   171: astore_2
    //   172: aconst_null
    //   173: astore_1
    //   174: goto -30 -> 144
    //   177: astore_2
    //   178: goto -34 -> 144
    //   181: astore_1
    //   182: aconst_null
    //   183: astore_1
    //   184: goto -75 -> 109
    //   187: astore_2
    //   188: goto -79 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	this	a
    //   0	191	1	paramString1	String
    //   0	191	2	paramString2	String
    //   7	159	3	localSQLiteDatabase	SQLiteDatabase
    //   1	27	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	8	104	java/lang/Exception
    //   3	8	139	finally
    //   8	27	171	finally
    //   30	47	177	finally
    //   8	27	181	java/lang/Exception
    //   30	47	187	java/lang/Exception
  }
  
  /* Error */
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aload_0
    //   4: invokevirtual 104	com/alipay/sdk/i/a:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   7: astore 9
    //   9: aload 9
    //   11: astore 8
    //   13: aload 8
    //   15: aload_1
    //   16: aload_2
    //   17: invokestatic 106	com/alipay/sdk/i/a:a	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;)Z
    //   20: ifeq +67 -> 87
    //   23: aload 8
    //   25: ldc 108
    //   27: iconst_3
    //   28: anewarray 110	java/lang/Object
    //   31: dup
    //   32: iconst_0
    //   33: iconst_1
    //   34: aload_3
    //   35: aload_0
    //   36: getfield 20	com/alipay/sdk/i/a:a	Ljava/lang/ref/WeakReference;
    //   39: invokevirtual 88	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   42: checkcast 90	android/content/Context
    //   45: invokestatic 95	com/alipay/sdk/j/b:c	(Landroid/content/Context;)Ljava/lang/String;
    //   48: invokestatic 100	com/alipay/sdk/d/b:a	(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   51: aastore
    //   52: dup
    //   53: iconst_1
    //   54: aload 4
    //   56: aastore
    //   57: dup
    //   58: iconst_2
    //   59: aload_1
    //   60: aload_2
    //   61: invokestatic 32	com/alipay/sdk/i/a:c	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   64: aastore
    //   65: invokevirtual 114	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   68: aload 8
    //   70: ifnull +16 -> 86
    //   73: aload 8
    //   75: invokevirtual 77	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   78: ifeq +8 -> 86
    //   81: aload 8
    //   83: invokevirtual 78	android/database/sqlite/SQLiteDatabase:close	()V
    //   86: return
    //   87: iconst_1
    //   88: aload_3
    //   89: aload_0
    //   90: getfield 20	com/alipay/sdk/i/a:a	Ljava/lang/ref/WeakReference;
    //   93: invokevirtual 88	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   96: checkcast 90	android/content/Context
    //   99: invokestatic 95	com/alipay/sdk/j/b:c	(Landroid/content/Context;)Ljava/lang/String;
    //   102: invokestatic 100	com/alipay/sdk/d/b:a	(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   105: astore_3
    //   106: aload 8
    //   108: ldc 116
    //   110: iconst_3
    //   111: anewarray 110	java/lang/Object
    //   114: dup
    //   115: iconst_0
    //   116: aload_1
    //   117: aload_2
    //   118: invokestatic 32	com/alipay/sdk/i/a:c	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   121: aastore
    //   122: dup
    //   123: iconst_1
    //   124: aload_3
    //   125: aastore
    //   126: dup
    //   127: iconst_2
    //   128: aload 4
    //   130: aastore
    //   131: invokevirtual 114	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   134: aload 8
    //   136: ldc 118
    //   138: aconst_null
    //   139: invokevirtual 38	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   142: astore_2
    //   143: aload_2
    //   144: invokeinterface 122 1 0
    //   149: bipush 14
    //   151: if_icmpgt +34 -> 185
    //   154: aload_2
    //   155: invokeinterface 52 1 0
    //   160: goto -92 -> 68
    //   163: astore_1
    //   164: aload 8
    //   166: ifnull -80 -> 86
    //   169: aload 8
    //   171: invokevirtual 77	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   174: ifeq -88 -> 86
    //   177: aload 8
    //   179: invokevirtual 78	android/database/sqlite/SQLiteDatabase:close	()V
    //   182: goto -96 -> 86
    //   185: aload_2
    //   186: invokeinterface 122 1 0
    //   191: bipush 14
    //   193: isub
    //   194: istore 7
    //   196: iload 7
    //   198: anewarray 28	java/lang/String
    //   201: astore_1
    //   202: aload_2
    //   203: invokeinterface 44 1 0
    //   208: ifeq +43 -> 251
    //   211: iconst_0
    //   212: istore 5
    //   214: aload_1
    //   215: iload 5
    //   217: aload_2
    //   218: iconst_0
    //   219: invokeinterface 74 2 0
    //   224: aastore
    //   225: iload 5
    //   227: iconst_1
    //   228: iadd
    //   229: istore 6
    //   231: aload_2
    //   232: invokeinterface 125 1 0
    //   237: ifeq +14 -> 251
    //   240: iload 6
    //   242: istore 5
    //   244: iload 7
    //   246: iload 6
    //   248: if_icmpgt -34 -> 214
    //   251: aload_2
    //   252: invokeinterface 52 1 0
    //   257: iconst_0
    //   258: istore 5
    //   260: iload 5
    //   262: iload 7
    //   264: if_icmpge -196 -> 68
    //   267: aload_1
    //   268: iload 5
    //   270: aaload
    //   271: invokestatic 84	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   274: ifne +26 -> 300
    //   277: aload_1
    //   278: iload 5
    //   280: aaload
    //   281: astore_2
    //   282: aload 8
    //   284: ldc 127
    //   286: ldc -127
    //   288: iconst_1
    //   289: anewarray 28	java/lang/String
    //   292: dup
    //   293: iconst_0
    //   294: aload_2
    //   295: aastore
    //   296: invokevirtual 133	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   299: pop
    //   300: iinc 5 1
    //   303: goto -43 -> 260
    //   306: astore_1
    //   307: aconst_null
    //   308: astore 8
    //   310: aload 8
    //   312: ifnull +16 -> 328
    //   315: aload 8
    //   317: invokevirtual 77	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   320: ifeq +8 -> 328
    //   323: aload 8
    //   325: invokevirtual 78	android/database/sqlite/SQLiteDatabase:close	()V
    //   328: aload_1
    //   329: athrow
    //   330: astore_1
    //   331: goto -21 -> 310
    //   334: astore_1
    //   335: goto -171 -> 164
    //   338: astore_2
    //   339: goto -39 -> 300
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	342	0	this	a
    //   0	342	1	paramString1	String
    //   0	342	2	paramString2	String
    //   0	342	3	paramString3	String
    //   0	342	4	paramString4	String
    //   212	89	5	i	int
    //   229	20	6	j	int
    //   194	71	7	k	int
    //   1	323	8	localObject	Object
    //   7	3	9	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   13	68	163	java/lang/Exception
    //   87	160	163	java/lang/Exception
    //   185	211	163	java/lang/Exception
    //   214	225	163	java/lang/Exception
    //   231	240	163	java/lang/Exception
    //   251	257	163	java/lang/Exception
    //   267	277	163	java/lang/Exception
    //   3	9	306	finally
    //   13	68	330	finally
    //   87	160	330	finally
    //   185	211	330	finally
    //   214	225	330	finally
    //   231	240	330	finally
    //   251	257	330	finally
    //   267	277	330	finally
    //   282	300	330	finally
    //   3	9	334	java/lang/Exception
    //   282	300	338	java/lang/Exception
  }
  
  /* Error */
  public final String b(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: invokevirtual 68	com/alipay/sdk/i/a:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   10: astore_3
    //   11: aload_3
    //   12: ldc -120
    //   14: iconst_1
    //   15: anewarray 28	java/lang/String
    //   18: dup
    //   19: iconst_0
    //   20: aload_1
    //   21: aload_2
    //   22: invokestatic 32	com/alipay/sdk/i/a:c	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   25: aastore
    //   26: invokevirtual 38	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   29: astore_1
    //   30: aload 5
    //   32: astore_2
    //   33: aload_1
    //   34: invokeinterface 44 1 0
    //   39: ifeq +11 -> 50
    //   42: aload_1
    //   43: iconst_0
    //   44: invokeinterface 74 2 0
    //   49: astore_2
    //   50: aload_1
    //   51: ifnull +9 -> 60
    //   54: aload_1
    //   55: invokeinterface 52 1 0
    //   60: aload_2
    //   61: astore_1
    //   62: aload_3
    //   63: ifnull +18 -> 81
    //   66: aload_2
    //   67: astore_1
    //   68: aload_3
    //   69: invokevirtual 77	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   72: ifeq +9 -> 81
    //   75: aload_3
    //   76: invokevirtual 78	android/database/sqlite/SQLiteDatabase:close	()V
    //   79: aload_2
    //   80: astore_1
    //   81: aload_1
    //   82: areturn
    //   83: astore_1
    //   84: aconst_null
    //   85: astore_1
    //   86: aconst_null
    //   87: astore_3
    //   88: aload_1
    //   89: ifnull +9 -> 98
    //   92: aload_1
    //   93: invokeinterface 52 1 0
    //   98: aload 4
    //   100: astore_1
    //   101: aload_3
    //   102: ifnull -21 -> 81
    //   105: aload 4
    //   107: astore_1
    //   108: aload_3
    //   109: invokevirtual 77	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   112: ifeq -31 -> 81
    //   115: aload_3
    //   116: invokevirtual 78	android/database/sqlite/SQLiteDatabase:close	()V
    //   119: aload 4
    //   121: astore_1
    //   122: goto -41 -> 81
    //   125: astore_2
    //   126: aconst_null
    //   127: astore_3
    //   128: aconst_null
    //   129: astore_1
    //   130: aload_1
    //   131: ifnull +9 -> 140
    //   134: aload_1
    //   135: invokeinterface 52 1 0
    //   140: aload_3
    //   141: ifnull +14 -> 155
    //   144: aload_3
    //   145: invokevirtual 77	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   148: ifeq +7 -> 155
    //   151: aload_3
    //   152: invokevirtual 78	android/database/sqlite/SQLiteDatabase:close	()V
    //   155: aload_2
    //   156: athrow
    //   157: astore_2
    //   158: aconst_null
    //   159: astore_1
    //   160: goto -30 -> 130
    //   163: astore_2
    //   164: goto -34 -> 130
    //   167: astore_1
    //   168: aconst_null
    //   169: astore_1
    //   170: goto -82 -> 88
    //   173: astore_2
    //   174: goto -86 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	this	a
    //   0	177	1	paramString1	String
    //   0	177	2	paramString2	String
    //   10	142	3	localSQLiteDatabase	SQLiteDatabase
    //   1	119	4	localObject1	Object
    //   4	27	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   6	11	83	java/lang/Exception
    //   6	11	125	finally
    //   11	30	157	finally
    //   33	50	163	finally
    //   11	30	167	java/lang/Exception
    //   33	50	173	java/lang/Exception
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("create table if not exists tb_tid (name text primary key, tid text, key_tid text, dt datetime);");
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("drop table if exists tb_tid");
    onCreate(paramSQLiteDatabase);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/sdk/i/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */