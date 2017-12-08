package com.lantern.browser;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public final class h
  extends SQLiteOpenHelper
{
  public h(Context paramContext)
  {
    super(paramContext, "appstoredownload.db", null, 2);
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("create table if not exists appstoredownload (id integer primary key autoincrement,hid text UNIQUE,downloadid text,filename text,packagename text,downloadurl text,completeurl text,installurl text,status text)");
  }
  
  public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("drop table if exists appstoredownload");
    onCreate(paramSQLiteDatabase);
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("drop table if exists appstoredownload");
    onCreate(paramSQLiteDatabase);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */