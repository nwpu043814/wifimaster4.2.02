package com.lantern.base.a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class a
  extends SQLiteOpenHelper
{
  private List<b> a;
  
  public a(Context paramContext, String paramString, int paramInt)
  {
    super(paramContext, paramString, null, paramInt);
  }
  
  private static List<String> a(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    Object localObject4 = null;
    Object localObject3 = null;
    localArrayList = new ArrayList();
    localObject1 = localObject3;
    localObject2 = localObject4;
    try
    {
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localObject1 = localObject3;
      localObject2 = localObject4;
      localStringBuilder.<init>("select * from ");
      localObject1 = localObject3;
      localObject2 = localObject4;
      paramString = paramSQLiteDatabase.rawQuery(paramString + " limit 1", null);
      paramSQLiteDatabase = localArrayList;
      if (paramString != null)
      {
        localObject1 = paramString;
        localObject2 = paramString;
        paramSQLiteDatabase = new java/util/ArrayList;
        localObject1 = paramString;
        localObject2 = paramString;
        paramSQLiteDatabase.<init>(Arrays.asList(paramString.getColumnNames()));
      }
      localObject2 = paramSQLiteDatabase;
      if (paramString != null)
      {
        paramString.close();
        localObject2 = paramSQLiteDatabase;
      }
    }
    catch (Exception paramSQLiteDatabase)
    {
      for (;;)
      {
        localObject2 = localObject1;
        paramSQLiteDatabase.printStackTrace();
        localObject2 = localArrayList;
        if (localObject1 != null)
        {
          ((Cursor)localObject1).close();
          localObject2 = localArrayList;
        }
      }
    }
    finally
    {
      if (localObject2 == null) {
        break label150;
      }
      ((Cursor)localObject2).close();
    }
    return (List<String>)localObject2;
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase)
  {
    Object localObject1 = b();
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      Iterator localIterator = ((List)localObject1).iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (b)localIterator.next();
        localObject1 = ((b)localObject2).b();
        localObject2 = ((b)localObject2).a();
        Object localObject5 = a(paramSQLiteDatabase, (String)localObject1);
        Object localObject4 = a(paramSQLiteDatabase, (String)localObject2);
        Object localObject3 = new HashMap();
        localObject5 = ((List)localObject5).iterator();
        while (((Iterator)localObject5).hasNext()) {
          ((Map)localObject3).put((String)((Iterator)localObject5).next(), Integer.valueOf(1));
        }
        localObject5 = ((List)localObject4).iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject4 = (String)((Iterator)localObject5).next();
          if (((Map)localObject3).containsKey(localObject4)) {
            ((Map)localObject3).put(localObject4, Integer.valueOf(2));
          }
        }
        ((Map)localObject3).remove("_id");
        ArrayList localArrayList = new ArrayList();
        localObject5 = ((Map)localObject3).keySet().iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject4 = (String)((Iterator)localObject5).next();
          if (((Integer)((Map)localObject3).get(localObject4)).intValue() == 2) {
            localArrayList.add(localObject4);
          }
        }
        localObject3 = TextUtils.join(",", localArrayList);
        paramSQLiteDatabase.execSQL("INSERT INTO " + (String)localObject2 + " (" + (String)localObject3 + ") SELECT " + (String)localObject3 + " FROM " + (String)localObject1);
      }
    }
  }
  
  private List<b> b()
  {
    if (this.a == null) {
      this.a = a();
    }
    return this.a;
  }
  
  private void b(SQLiteDatabase paramSQLiteDatabase)
  {
    Object localObject = b();
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        b localb = (b)((Iterator)localObject).next();
        paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + localb.b());
      }
    }
  }
  
  /* Error */
  private void c(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 173	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   4: aload_0
    //   5: aload_1
    //   6: invokespecial 175	com/lantern/base/a/a:b	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   9: aload_0
    //   10: aload_1
    //   11: invokevirtual 178	com/lantern/base/a/a:onCreate	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   14: aload_0
    //   15: invokespecial 72	com/lantern/base/a/a:b	()Ljava/util/List;
    //   18: astore_2
    //   19: aload_2
    //   20: ifnull +91 -> 111
    //   23: aload_2
    //   24: invokeinterface 78 1 0
    //   29: ifne +82 -> 111
    //   32: aload_2
    //   33: invokeinterface 82 1 0
    //   38: astore 4
    //   40: aload 4
    //   42: invokeinterface 87 1 0
    //   47: ifeq +64 -> 111
    //   50: aload 4
    //   52: invokeinterface 91 1 0
    //   57: checkcast 93	com/lantern/base/a/b
    //   60: astore_2
    //   61: new 23	java/lang/StringBuilder
    //   64: astore_3
    //   65: aload_3
    //   66: ldc -76
    //   68: invokespecial 28	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   71: aload_1
    //   72: aload_3
    //   73: aload_2
    //   74: invokevirtual 97	com/lantern/base/a/b:a	()Ljava/lang/String;
    //   77: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: ldc -74
    //   82: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_2
    //   86: invokevirtual 95	com/lantern/base/a/b:b	()Ljava/lang/String;
    //   89: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokevirtual 162	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   98: goto -58 -> 40
    //   101: astore_2
    //   102: aload_2
    //   103: invokevirtual 65	java/lang/Exception:printStackTrace	()V
    //   106: aload_1
    //   107: invokevirtual 185	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   110: return
    //   111: aload_0
    //   112: aload_1
    //   113: invokevirtual 178	com/lantern/base/a/a:onCreate	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   116: aload_0
    //   117: aload_1
    //   118: invokespecial 187	com/lantern/base/a/a:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   121: aload_0
    //   122: aload_1
    //   123: invokespecial 175	com/lantern/base/a/a:b	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   126: aload_1
    //   127: invokevirtual 190	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   130: aload_1
    //   131: invokevirtual 185	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   134: goto -24 -> 110
    //   137: astore_2
    //   138: aload_1
    //   139: invokevirtual 185	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   142: aload_2
    //   143: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	this	a
    //   0	144	1	paramSQLiteDatabase	SQLiteDatabase
    //   18	68	2	localObject1	Object
    //   101	2	2	localException	Exception
    //   137	6	2	localObject2	Object
    //   64	9	3	localStringBuilder	StringBuilder
    //   38	13	4	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   0	19	101	java/lang/Exception
    //   23	40	101	java/lang/Exception
    //   40	98	101	java/lang/Exception
    //   111	130	101	java/lang/Exception
    //   0	19	137	finally
    //   23	40	137	finally
    //   40	98	137	finally
    //   102	106	137	finally
    //   111	130	137	finally
  }
  
  protected abstract List<b> a();
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    Object localObject = b();
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        b localb = (b)((Iterator)localObject).next();
        paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS " + localb.a() + " (" + localb.c() + ");");
      }
    }
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    c(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    c(paramSQLiteDatabase);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/base/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */