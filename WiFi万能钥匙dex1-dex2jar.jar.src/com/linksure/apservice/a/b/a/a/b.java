package com.linksure.apservice.a.b.a.a;

import android.database.sqlite.SQLiteDatabase;

public final class b
  implements a
{
  private boolean a = false;
  private c b;
  
  public final SQLiteDatabase a()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.b.getWritableDatabase();
      return localSQLiteDatabase;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public final void a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 16	com/linksure/apservice/a/b/a/a/b:a	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: new 22	com/linksure/apservice/a/b/a/a/c
    //   17: astore_3
    //   18: aload_3
    //   19: aload_1
    //   20: invokespecial 28	com/linksure/apservice/a/b/a/a/c:<init>	(Landroid/content/Context;)V
    //   23: aload_0
    //   24: aload_3
    //   25: putfield 20	com/linksure/apservice/a/b/a/a/b:b	Lcom/linksure/apservice/a/b/a/a/c;
    //   28: aload_0
    //   29: invokevirtual 30	com/linksure/apservice/a/b/a/a/b:a	()Landroid/database/sqlite/SQLiteDatabase;
    //   32: pop
    //   33: aload_0
    //   34: iconst_1
    //   35: putfield 16	com/linksure/apservice/a/b/a/a/b:a	Z
    //   38: goto -27 -> 11
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	b
    //   0	46	1	paramContext	android.content.Context
    //   6	2	2	bool	boolean
    //   17	8	3	localc	c
    // Exception table:
    //   from	to	target	type
    //   2	7	41	finally
    //   14	38	41	finally
  }
  
  public final void b()
  {
    try
    {
      this.b.close();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/a/b/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */