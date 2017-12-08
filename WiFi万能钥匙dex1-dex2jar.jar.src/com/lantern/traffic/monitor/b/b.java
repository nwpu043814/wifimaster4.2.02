package com.lantern.traffic.monitor.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public final class b
  extends SQLiteOpenHelper
{
  private static b a;
  private static String b = "traffic.db";
  private static int c = 21;
  
  private b(Context paramContext)
  {
    super(paramContext, b, null, c);
  }
  
  public static final b a(Context paramContext)
  {
    if (a == null) {
      a = new b(paramContext.getApplicationContext());
    }
    return a;
  }
  
  public final SQLiteDatabase getReadableDatabase()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = super.getReadableDatabase();
      return localSQLiteDatabase;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final SQLiteDatabase getWritableDatabase()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = super.getWritableDatabase();
      return localSQLiteDatabase;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS TRAFFICINFO (_id INTEGER PRIMARY KEY AUTOINCREMENT, PACKAGENAME TEXT, APPNAME TEXT, INSERTTIME LONG, NETWORKTYPE TEXT, RX LONG, TX LONG, UIDRX LONG, UIDTX LONG)");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS TRBLACKINFO (_id INTEGER PRIMARY KEY AUTOINCREMENT, PACKAGENAME TEXT, STATTIME LONG, ENDTIME LONG, APPNAME TEXT, SNOTETR LONG, WARNTIMES INT, FREQUENCY LONG, CNOTETR LONG, SHOWTIMES INT, NOTETIME LONG, USETIME LONG, SERVERCODE INT, NOTETTYPE  INT)");
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      for (;;)
      {
        Log.e("onCreate DB", paramSQLiteDatabase.getMessage());
      }
    }
  }
  
  public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    try
    {
      paramSQLiteDatabase.execSQL("drop table if exists TRBLACKINFO");
      paramSQLiteDatabase.execSQL("drop table if exists TRAFFICINFO");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS TRAFFICINFO (_id INTEGER PRIMARY KEY AUTOINCREMENT, PACKAGENAME TEXT, APPNAME TEXT, INSERTTIME LONG, NETWORKTYPE TEXT, RX LONG, TX LONG, UIDRX LONG, UIDTX LONG)");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS TRBLACKINFO (_id INTEGER PRIMARY KEY AUTOINCREMENT, PACKAGENAME TEXT, STATTIME LONG, ENDTIME LONG, APPNAME TEXT, SNOTETR LONG, WARNTIMES INT, FREQUENCY LONG, CNOTETR LONG, SHOWTIMES INT, NOTETIME LONG, USETIME LONG, SERVERCODE INT, NOTETTYPE  INT)");
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      for (;;)
      {
        Log.e("onCreate DB", paramSQLiteDatabase.getMessage());
      }
    }
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    try
    {
      paramSQLiteDatabase.execSQL("drop table if exists TRBLACKINFO");
      paramSQLiteDatabase.execSQL("drop table if exists TRAFFICINFO");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS TRAFFICINFO (_id INTEGER PRIMARY KEY AUTOINCREMENT, PACKAGENAME TEXT, APPNAME TEXT, INSERTTIME LONG, NETWORKTYPE TEXT, RX LONG, TX LONG, UIDRX LONG, UIDTX LONG)");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS TRBLACKINFO (_id INTEGER PRIMARY KEY AUTOINCREMENT, PACKAGENAME TEXT, STATTIME LONG, ENDTIME LONG, APPNAME TEXT, SNOTETR LONG, WARNTIMES INT, FREQUENCY LONG, CNOTETR LONG, SHOWTIMES INT, NOTETIME LONG, USETIME LONG, SERVERCODE INT, NOTETTYPE  INT)");
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      for (;;)
      {
        Log.e("onCreate DB", paramSQLiteDatabase.getMessage());
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/traffic/monitor/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */