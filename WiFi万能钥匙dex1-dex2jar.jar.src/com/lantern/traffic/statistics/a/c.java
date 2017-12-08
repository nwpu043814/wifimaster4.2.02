package com.lantern.traffic.statistics.a;

import android.content.Context;
import com.lantern.base.a.a;
import com.lantern.base.a.b;
import java.util.ArrayList;
import java.util.List;

public final class c
  extends a
{
  private static c a;
  
  private c(Context paramContext)
  {
    super(paramContext, "traffic_statistics.db", 53);
  }
  
  public static c a(Context paramContext)
  {
    if (a == null) {
      a = new c(paramContext);
    }
    return a;
  }
  
  protected final List<b> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new b("traffic_statistics_table", "traffic_statistics_table_temp", b.a.a));
    return localArrayList;
  }
  
  /* Error */
  public final void onUpgrade(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: iload_2
    //   3: iload_3
    //   4: invokespecial 53	com/lantern/base/a/a:onUpgrade	(Landroid/database/sqlite/SQLiteDatabase;II)V
    //   7: iload_2
    //   8: bipush 53
    //   10: if_icmpge +189 -> 199
    //   13: aload_1
    //   14: invokevirtual 58	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   17: aload_1
    //   18: ldc 29
    //   20: iconst_1
    //   21: anewarray 60	java/lang/String
    //   24: dup
    //   25: iconst_0
    //   26: ldc 62
    //   28: aastore
    //   29: aconst_null
    //   30: aconst_null
    //   31: aconst_null
    //   32: aconst_null
    //   33: ldc 62
    //   35: invokevirtual 66	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   38: astore 5
    //   40: aload 5
    //   42: ifnull +133 -> 175
    //   45: aload 5
    //   47: astore 4
    //   49: aload 5
    //   51: invokeinterface 72 1 0
    //   56: ifle +119 -> 175
    //   59: aload 5
    //   61: astore 4
    //   63: aload 5
    //   65: invokeinterface 76 1 0
    //   70: ifeq +105 -> 175
    //   73: aload 5
    //   75: astore 4
    //   77: aload 5
    //   79: aload 5
    //   81: ldc 62
    //   83: invokeinterface 80 2 0
    //   88: invokeinterface 84 2 0
    //   93: astore 6
    //   95: aload 5
    //   97: astore 4
    //   99: aload 6
    //   101: invokestatic 90	com/lantern/settings/b/e:c	(Ljava/lang/String;)Ljava/lang/String;
    //   104: astore 8
    //   106: aload 5
    //   108: astore 4
    //   110: new 92	android/content/ContentValues
    //   113: astore 7
    //   115: aload 5
    //   117: astore 4
    //   119: aload 7
    //   121: invokespecial 93	android/content/ContentValues:<init>	()V
    //   124: aload 5
    //   126: astore 4
    //   128: aload 7
    //   130: ldc 62
    //   132: aload 8
    //   134: invokevirtual 97	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   137: aload 5
    //   139: astore 4
    //   141: aload_1
    //   142: ldc 29
    //   144: aload 7
    //   146: ldc 99
    //   148: iconst_1
    //   149: anewarray 60	java/lang/String
    //   152: dup
    //   153: iconst_0
    //   154: aload 6
    //   156: aastore
    //   157: invokevirtual 103	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   160: pop
    //   161: aload 5
    //   163: astore 4
    //   165: aload 5
    //   167: invokeinterface 106 1 0
    //   172: ifne -99 -> 73
    //   175: aload 5
    //   177: astore 4
    //   179: aload_1
    //   180: invokevirtual 109	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   183: aload 5
    //   185: ifnull +10 -> 195
    //   188: aload 5
    //   190: invokeinterface 112 1 0
    //   195: aload_1
    //   196: invokevirtual 115	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   199: return
    //   200: astore 6
    //   202: aconst_null
    //   203: astore 5
    //   205: aload 5
    //   207: astore 4
    //   209: aload 6
    //   211: invokevirtual 118	java/lang/Exception:printStackTrace	()V
    //   214: aload 5
    //   216: ifnull +10 -> 226
    //   219: aload 5
    //   221: invokeinterface 112 1 0
    //   226: aload_1
    //   227: invokevirtual 115	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   230: goto -31 -> 199
    //   233: astore 4
    //   235: aconst_null
    //   236: astore 5
    //   238: aload 4
    //   240: astore 6
    //   242: aload 5
    //   244: ifnull +10 -> 254
    //   247: aload 5
    //   249: invokeinterface 112 1 0
    //   254: aload_1
    //   255: invokevirtual 115	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   258: aload 6
    //   260: athrow
    //   261: astore 6
    //   263: aload 4
    //   265: astore 5
    //   267: goto -25 -> 242
    //   270: astore 6
    //   272: goto -67 -> 205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	275	0	this	c
    //   0	275	1	paramSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    //   0	275	2	paramInt1	int
    //   0	275	3	paramInt2	int
    //   47	161	4	localObject1	Object
    //   233	31	4	localObject2	Object
    //   38	228	5	localObject3	Object
    //   93	62	6	str1	String
    //   200	10	6	localException1	Exception
    //   240	19	6	localObject4	Object
    //   261	1	6	localObject5	Object
    //   270	1	6	localException2	Exception
    //   113	32	7	localContentValues	android.content.ContentValues
    //   104	29	8	str2	String
    // Exception table:
    //   from	to	target	type
    //   13	40	200	java/lang/Exception
    //   13	40	233	finally
    //   49	59	261	finally
    //   63	73	261	finally
    //   77	95	261	finally
    //   99	106	261	finally
    //   110	115	261	finally
    //   119	124	261	finally
    //   128	137	261	finally
    //   141	161	261	finally
    //   165	175	261	finally
    //   179	183	261	finally
    //   209	214	261	finally
    //   49	59	270	java/lang/Exception
    //   63	73	270	java/lang/Exception
    //   77	95	270	java/lang/Exception
    //   99	106	270	java/lang/Exception
    //   110	115	270	java/lang/Exception
    //   119	124	270	java/lang/Exception
    //   128	137	270	java/lang/Exception
    //   141	161	270	java/lang/Exception
    //   165	175	270	java/lang/Exception
    //   179	183	270	java/lang/Exception
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/traffic/statistics/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */