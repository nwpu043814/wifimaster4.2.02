package com.linksure.apservice.a.b.a.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public final class c
  extends SQLiteOpenHelper
{
  public c(Context paramContext)
  {
    super(paramContext, "aps", null, 1);
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS aps_account(_id  INTEGER,aps_id TEXT PRIMARY KEY,name TEXT,type INTEGER,stat INTEGER,unread INTEGER,latest TEXT,menu TEXT,data TEXT,create_at INTEGER,update_at INTEGER)");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS aps_message(_id INTEGER PRIMARY KEY,thread_id TEXT,type INTEGER,stat INTEGER,send INTEGER,ts INTEGER,content TEXT,extra TEXT)");
    Log.d("create", "数据库创建成功");
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS aps_account");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS aps_message");
    Log.d("create", "数据库删除成功");
    onCreate(paramSQLiteDatabase);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/a/b/a/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */