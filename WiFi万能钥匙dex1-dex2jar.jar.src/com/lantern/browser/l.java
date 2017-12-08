package com.lantern.browser;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.lantern.core.c;
import java.util.ArrayList;

public final class l
{
  private static l a;
  private h b = new h(c.getInstance().getApplicationContext());
  
  public static l a()
  {
    try
    {
      if (a == null)
      {
        locall = new com/lantern/browser/l;
        locall.<init>();
        a = locall;
      }
      l locall = a;
      return locall;
    }
    finally {}
  }
  
  private static ArrayList<k> a(Cursor paramCursor)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramCursor.getCount() == 0) {}
    for (;;)
    {
      return localArrayList;
      int n = paramCursor.getColumnIndex("hid");
      int m = paramCursor.getColumnIndex("downloadid");
      int i2 = paramCursor.getColumnIndex("filename");
      int i3 = paramCursor.getColumnIndex("packagename");
      int j = paramCursor.getColumnIndex("downloadurl");
      int k = paramCursor.getColumnIndex("status");
      int i1 = paramCursor.getColumnIndex("completeurl");
      int i = paramCursor.getColumnIndex("installurl");
      while (paramCursor.moveToNext())
      {
        k localk = new k();
        localk.a(paramCursor.getString(n));
        localk.b(paramCursor.getString(m));
        localk.c(paramCursor.getString(i2));
        localk.d(paramCursor.getString(i3));
        localk.e(paramCursor.getString(j));
        localk.f(paramCursor.getString(k));
        if (i1 != -1) {
          localk.h(paramCursor.getString(i1));
        }
        if (i != -1) {
          localk.i(paramCursor.getString(i));
        }
        localArrayList.add(localk);
      }
    }
  }
  
  private long b(k paramk)
  {
    long l = -1L;
    try
    {
      SQLiteDatabase localSQLiteDatabase = c();
      if (localSQLiteDatabase == null) {
        return l;
      }
      ContentValues localContentValues = new android/content/ContentValues;
      localContentValues.<init>();
      if (!TextUtils.isEmpty(paramk.a())) {
        localContentValues.put("hid", paramk.a());
      }
      if (!TextUtils.isEmpty(paramk.b())) {
        localContentValues.put("downloadid", paramk.b());
      }
      if (!TextUtils.isEmpty(paramk.c())) {
        localContentValues.put("filename", paramk.c());
      }
      if (!TextUtils.isEmpty(paramk.d())) {
        localContentValues.put("packagename", paramk.d());
      }
      if (!TextUtils.isEmpty(paramk.e())) {
        localContentValues.put("downloadurl", paramk.e());
      }
      if (!TextUtils.isEmpty(paramk.f())) {
        localContentValues.put("status", paramk.f());
      }
      if (!TextUtils.isEmpty(paramk.h())) {
        localContentValues.put("completeurl", paramk.h());
      }
      if (!TextUtils.isEmpty(paramk.i())) {
        localContentValues.put("installurl", paramk.i());
      }
      l = localSQLiteDatabase.insert("appstoredownload", null, localContentValues);
      if (l == -1L) {
        l = localSQLiteDatabase.update("appstoredownload", localContentValues, "hid=?", new String[] { paramk.a() });
      }
      for (;;)
      {
        localSQLiteDatabase.close();
        break;
      }
    }
    finally {}
  }
  
  private SQLiteDatabase c()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.b.getWritableDatabase();
      return localSQLiteDatabase;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.bluefay.b.h.a(localException);
        Object localObject1 = null;
      }
    }
    finally {}
  }
  
  /* Error */
  public final long a(k paramk)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 110	com/lantern/browser/l:c	()Landroid/database/sqlite/SQLiteDatabase;
    //   6: astore 7
    //   8: aload 7
    //   10: ifnonnull +11 -> 21
    //   13: ldc2_w 106
    //   16: lstore_2
    //   17: aload_0
    //   18: monitorexit
    //   19: lload_2
    //   20: lreturn
    //   21: new 112	android/content/ContentValues
    //   24: astore 6
    //   26: aload 6
    //   28: invokespecial 113	android/content/ContentValues:<init>	()V
    //   31: aload_1
    //   32: invokevirtual 116	com/lantern/browser/k:a	()Ljava/lang/String;
    //   35: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   38: ifne +14 -> 52
    //   41: aload 6
    //   43: ldc 46
    //   45: aload_1
    //   46: invokevirtual 116	com/lantern/browser/k:a	()Ljava/lang/String;
    //   49: invokevirtual 126	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: aload_1
    //   53: invokevirtual 128	com/lantern/browser/k:b	()Ljava/lang/String;
    //   56: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   59: ifne +14 -> 73
    //   62: aload 6
    //   64: ldc 52
    //   66: aload_1
    //   67: invokevirtual 128	com/lantern/browser/k:b	()Ljava/lang/String;
    //   70: invokevirtual 126	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: aload_1
    //   74: invokevirtual 130	com/lantern/browser/k:c	()Ljava/lang/String;
    //   77: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   80: ifne +14 -> 94
    //   83: aload 6
    //   85: ldc 54
    //   87: aload_1
    //   88: invokevirtual 130	com/lantern/browser/k:c	()Ljava/lang/String;
    //   91: invokevirtual 126	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: aload_1
    //   95: invokevirtual 132	com/lantern/browser/k:d	()Ljava/lang/String;
    //   98: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   101: ifne +14 -> 115
    //   104: aload 6
    //   106: ldc 56
    //   108: aload_1
    //   109: invokevirtual 132	com/lantern/browser/k:d	()Ljava/lang/String;
    //   112: invokevirtual 126	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: aload_1
    //   116: invokevirtual 134	com/lantern/browser/k:e	()Ljava/lang/String;
    //   119: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   122: ifne +14 -> 136
    //   125: aload 6
    //   127: ldc 58
    //   129: aload_1
    //   130: invokevirtual 134	com/lantern/browser/k:e	()Ljava/lang/String;
    //   133: invokevirtual 126	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: aload_1
    //   137: invokevirtual 136	com/lantern/browser/k:f	()Ljava/lang/String;
    //   140: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   143: ifne +14 -> 157
    //   146: aload 6
    //   148: ldc 60
    //   150: aload_1
    //   151: invokevirtual 136	com/lantern/browser/k:f	()Ljava/lang/String;
    //   154: invokevirtual 126	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   157: aload_1
    //   158: invokevirtual 138	com/lantern/browser/k:h	()Ljava/lang/String;
    //   161: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   164: ifne +14 -> 178
    //   167: aload 6
    //   169: ldc 62
    //   171: aload_1
    //   172: invokevirtual 138	com/lantern/browser/k:h	()Ljava/lang/String;
    //   175: invokevirtual 126	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   178: aload_1
    //   179: invokevirtual 140	com/lantern/browser/k:i	()Ljava/lang/String;
    //   182: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   185: ifne +14 -> 199
    //   188: aload 6
    //   190: ldc 64
    //   192: aload_1
    //   193: invokevirtual 140	com/lantern/browser/k:i	()Ljava/lang/String;
    //   196: invokevirtual 126	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   199: aload 7
    //   201: ldc -114
    //   203: aload 6
    //   205: ldc -106
    //   207: iconst_1
    //   208: anewarray 152	java/lang/String
    //   211: dup
    //   212: iconst_0
    //   213: aload_1
    //   214: invokevirtual 116	com/lantern/browser/k:a	()Ljava/lang/String;
    //   217: aastore
    //   218: invokevirtual 156	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   221: i2l
    //   222: lstore 4
    //   224: lload 4
    //   226: lstore_2
    //   227: lload 4
    //   229: lconst_0
    //   230: lcmp
    //   231: ifgt +14 -> 245
    //   234: aload 7
    //   236: ldc -114
    //   238: aconst_null
    //   239: aload 6
    //   241: invokevirtual 148	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   244: lstore_2
    //   245: aload 7
    //   247: invokevirtual 159	android/database/sqlite/SQLiteDatabase:close	()V
    //   250: goto -233 -> 17
    //   253: astore_1
    //   254: aload_0
    //   255: monitorexit
    //   256: aload_1
    //   257: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	258	0	this	l
    //   0	258	1	paramk	k
    //   16	229	2	l1	long
    //   222	6	4	l2	long
    //   24	216	6	localContentValues	ContentValues
    //   6	240	7	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   2	8	253	finally
    //   21	52	253	finally
    //   52	73	253	finally
    //   73	94	253	finally
    //   94	115	253	finally
    //   115	136	253	finally
    //   136	157	253	finally
    //   157	178	253	finally
    //   178	199	253	finally
    //   199	224	253	finally
    //   234	245	253	finally
    //   245	250	253	finally
  }
  
  /* Error */
  public final k a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 110	com/lantern/browser/l:c	()Landroid/database/sqlite/SQLiteDatabase;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +9 -> 17
    //   11: aconst_null
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: areturn
    //   17: aload_2
    //   18: ldc -114
    //   20: aconst_null
    //   21: ldc -84
    //   23: iconst_1
    //   24: anewarray 152	java/lang/String
    //   27: dup
    //   28: iconst_0
    //   29: aload_1
    //   30: aastore
    //   31: aconst_null
    //   32: aconst_null
    //   33: aconst_null
    //   34: invokevirtual 176	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   37: astore_3
    //   38: aload_3
    //   39: invokestatic 178	com/lantern/browser/l:a	(Landroid/database/Cursor;)Ljava/util/ArrayList;
    //   42: astore_1
    //   43: aload_3
    //   44: invokeinterface 179 1 0
    //   49: aload_2
    //   50: invokevirtual 159	android/database/sqlite/SQLiteDatabase:close	()V
    //   53: aload_1
    //   54: invokevirtual 182	java/util/ArrayList:size	()I
    //   57: ifle +15 -> 72
    //   60: aload_1
    //   61: iconst_0
    //   62: invokevirtual 186	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   65: checkcast 70	com/lantern/browser/k
    //   68: astore_1
    //   69: goto -56 -> 13
    //   72: aconst_null
    //   73: astore_1
    //   74: goto -61 -> 13
    //   77: astore_1
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	l
    //   0	82	1	paramString	String
    //   6	44	2	localSQLiteDatabase	SQLiteDatabase
    //   37	7	3	localCursor	Cursor
    // Exception table:
    //   from	to	target	type
    //   2	7	77	finally
    //   17	69	77	finally
  }
  
  /* Error */
  public final void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 110	com/lantern/browser/l:c	()Landroid/database/sqlite/SQLiteDatabase;
    //   6: astore 4
    //   8: aload 4
    //   10: ifnonnull +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: new 112	android/content/ContentValues
    //   19: astore_3
    //   20: aload_3
    //   21: invokespecial 113	android/content/ContentValues:<init>	()V
    //   24: aload_2
    //   25: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   28: ifne +10 -> 38
    //   31: aload_3
    //   32: ldc 60
    //   34: aload_2
    //   35: invokevirtual 126	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: aload 4
    //   40: ldc -114
    //   42: aload_3
    //   43: ldc -84
    //   45: iconst_1
    //   46: anewarray 152	java/lang/String
    //   49: dup
    //   50: iconst_0
    //   51: aload_1
    //   52: aastore
    //   53: invokevirtual 156	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   56: pop
    //   57: aload 4
    //   59: invokevirtual 159	android/database/sqlite/SQLiteDatabase:close	()V
    //   62: goto -49 -> 13
    //   65: astore_1
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_1
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	l
    //   0	70	1	paramString1	String
    //   0	70	2	paramString2	String
    //   19	24	3	localContentValues	ContentValues
    //   6	52	4	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   2	8	65	finally
    //   16	38	65	finally
    //   38	62	65	finally
  }
  
  /* Error */
  public final void a(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 110	com/lantern/browser/l:c	()Landroid/database/sqlite/SQLiteDatabase;
    //   6: astore 5
    //   8: aload 5
    //   10: ifnonnull +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: new 112	android/content/ContentValues
    //   19: astore 4
    //   21: aload 4
    //   23: invokespecial 113	android/content/ContentValues:<init>	()V
    //   26: aload_2
    //   27: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   30: ifne +11 -> 41
    //   33: aload 4
    //   35: ldc 54
    //   37: aload_2
    //   38: invokevirtual 126	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: aload_3
    //   42: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   45: ifne +11 -> 56
    //   48: aload 4
    //   50: ldc 60
    //   52: aload_3
    //   53: invokevirtual 126	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: aload 5
    //   58: ldc -114
    //   60: aload 4
    //   62: ldc -84
    //   64: iconst_1
    //   65: anewarray 152	java/lang/String
    //   68: dup
    //   69: iconst_0
    //   70: aload_1
    //   71: aastore
    //   72: invokevirtual 156	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   75: pop
    //   76: aload 5
    //   78: invokevirtual 159	android/database/sqlite/SQLiteDatabase:close	()V
    //   81: goto -68 -> 13
    //   84: astore_1
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_1
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	l
    //   0	89	1	paramString1	String
    //   0	89	2	paramString2	String
    //   0	89	3	paramString3	String
    //   19	42	4	localContentValues	ContentValues
    //   6	71	5	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   2	8	84	finally
    //   16	41	84	finally
    //   41	56	84	finally
    //   56	81	84	finally
  }
  
  /* Error */
  public final void a(java.util.List<k> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +14 -> 17
    //   6: aload_1
    //   7: invokeinterface 191 1 0
    //   12: istore_2
    //   13: iload_2
    //   14: ifgt +6 -> 20
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: aload_1
    //   21: invokeinterface 195 1 0
    //   26: astore_1
    //   27: aload_1
    //   28: invokeinterface 200 1 0
    //   33: ifeq -16 -> 17
    //   36: aload_0
    //   37: aload_1
    //   38: invokeinterface 204 1 0
    //   43: checkcast 70	com/lantern/browser/k
    //   46: invokespecial 206	com/lantern/browser/l:b	(Lcom/lantern/browser/k;)J
    //   49: pop2
    //   50: goto -23 -> 27
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	l
    //   0	58	1	paramList	java.util.List<k>
    //   12	2	2	i	int
    // Exception table:
    //   from	to	target	type
    //   6	13	53	finally
    //   20	27	53	finally
    //   27	50	53	finally
  }
  
  /* Error */
  public final k b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 110	com/lantern/browser/l:c	()Landroid/database/sqlite/SQLiteDatabase;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +9 -> 17
    //   11: aconst_null
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: areturn
    //   17: aload_2
    //   18: ldc -114
    //   20: aconst_null
    //   21: ldc -47
    //   23: iconst_1
    //   24: anewarray 152	java/lang/String
    //   27: dup
    //   28: iconst_0
    //   29: aload_1
    //   30: aastore
    //   31: aconst_null
    //   32: aconst_null
    //   33: aconst_null
    //   34: invokevirtual 176	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   37: astore_1
    //   38: aload_1
    //   39: invokestatic 178	com/lantern/browser/l:a	(Landroid/database/Cursor;)Ljava/util/ArrayList;
    //   42: astore_3
    //   43: aload_1
    //   44: invokeinterface 179 1 0
    //   49: aload_2
    //   50: invokevirtual 159	android/database/sqlite/SQLiteDatabase:close	()V
    //   53: aload_3
    //   54: invokevirtual 182	java/util/ArrayList:size	()I
    //   57: ifle +15 -> 72
    //   60: aload_3
    //   61: iconst_0
    //   62: invokevirtual 186	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   65: checkcast 70	com/lantern/browser/k
    //   68: astore_1
    //   69: goto -56 -> 13
    //   72: aconst_null
    //   73: astore_1
    //   74: goto -61 -> 13
    //   77: astore_1
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	l
    //   0	82	1	paramString	String
    //   6	44	2	localSQLiteDatabase	SQLiteDatabase
    //   42	19	3	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   2	7	77	finally
    //   17	69	77	finally
  }
  
  public final ArrayList<k> b()
  {
    Object localObject = null;
    SQLiteDatabase localSQLiteDatabase = c();
    if (localSQLiteDatabase == null) {}
    for (;;)
    {
      return (ArrayList<k>)localObject;
      Cursor localCursor = localSQLiteDatabase.query("appstoredownload", null, null, null, null, null, null);
      localObject = a(localCursor);
      localCursor.close();
      localSQLiteDatabase.close();
    }
  }
  
  /* Error */
  public final void b(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifne +14 -> 20
    //   9: aload_0
    //   10: invokespecial 110	com/lantern/browser/l:c	()Landroid/database/sqlite/SQLiteDatabase;
    //   13: astore 4
    //   15: aload 4
    //   17: ifnonnull +6 -> 23
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: new 112	android/content/ContentValues
    //   26: astore_3
    //   27: aload_3
    //   28: invokespecial 113	android/content/ContentValues:<init>	()V
    //   31: aload_3
    //   32: ldc 60
    //   34: aload_2
    //   35: invokevirtual 126	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: aload 4
    //   40: ldc -114
    //   42: aload_3
    //   43: ldc -106
    //   45: iconst_1
    //   46: anewarray 152	java/lang/String
    //   49: dup
    //   50: iconst_0
    //   51: aload_1
    //   52: aastore
    //   53: invokevirtual 156	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   56: pop
    //   57: aload 4
    //   59: invokevirtual 159	android/database/sqlite/SQLiteDatabase:close	()V
    //   62: goto -42 -> 20
    //   65: astore_1
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_1
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	l
    //   0	70	1	paramString1	String
    //   0	70	2	paramString2	String
    //   26	17	3	localContentValues	ContentValues
    //   13	45	4	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   2	15	65	finally
    //   23	62	65	finally
  }
  
  /* Error */
  public final k c(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 110	com/lantern/browser/l:c	()Landroid/database/sqlite/SQLiteDatabase;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +9 -> 17
    //   11: aconst_null
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: areturn
    //   17: aload_2
    //   18: ldc -114
    //   20: aconst_null
    //   21: ldc -106
    //   23: iconst_1
    //   24: anewarray 152	java/lang/String
    //   27: dup
    //   28: iconst_0
    //   29: aload_1
    //   30: aastore
    //   31: aconst_null
    //   32: aconst_null
    //   33: aconst_null
    //   34: invokevirtual 176	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   37: astore_1
    //   38: aload_1
    //   39: invokestatic 178	com/lantern/browser/l:a	(Landroid/database/Cursor;)Ljava/util/ArrayList;
    //   42: astore_3
    //   43: aload_1
    //   44: invokeinterface 179 1 0
    //   49: aload_2
    //   50: invokevirtual 159	android/database/sqlite/SQLiteDatabase:close	()V
    //   53: aload_3
    //   54: invokevirtual 182	java/util/ArrayList:size	()I
    //   57: ifle +15 -> 72
    //   60: aload_3
    //   61: iconst_0
    //   62: invokevirtual 186	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   65: checkcast 70	com/lantern/browser/k
    //   68: astore_1
    //   69: goto -56 -> 13
    //   72: aconst_null
    //   73: astore_1
    //   74: goto -61 -> 13
    //   77: astore_1
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	l
    //   0	82	1	paramString	String
    //   6	44	2	localSQLiteDatabase	SQLiteDatabase
    //   42	19	3	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   2	7	77	finally
    //   17	69	77	finally
  }
  
  /* Error */
  public final void c(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifne +14 -> 20
    //   9: aload_0
    //   10: invokespecial 110	com/lantern/browser/l:c	()Landroid/database/sqlite/SQLiteDatabase;
    //   13: astore 4
    //   15: aload 4
    //   17: ifnonnull +6 -> 23
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: new 112	android/content/ContentValues
    //   26: astore_3
    //   27: aload_3
    //   28: invokespecial 113	android/content/ContentValues:<init>	()V
    //   31: aload_3
    //   32: ldc 60
    //   34: aload_2
    //   35: invokevirtual 126	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: aload 4
    //   40: ldc -114
    //   42: aload_3
    //   43: ldc -43
    //   45: iconst_1
    //   46: anewarray 152	java/lang/String
    //   49: dup
    //   50: iconst_0
    //   51: aload_1
    //   52: aastore
    //   53: invokevirtual 156	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   56: pop
    //   57: aload 4
    //   59: invokevirtual 159	android/database/sqlite/SQLiteDatabase:close	()V
    //   62: goto -42 -> 20
    //   65: astore_1
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_1
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	l
    //   0	70	1	paramString1	String
    //   0	70	2	paramString2	String
    //   26	17	3	localContentValues	ContentValues
    //   13	45	4	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   2	15	65	finally
    //   23	62	65	finally
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */