package com.lantern.wifiseccheck.vpn.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DownloadDBHelper
  extends SQLiteOpenHelper
{
  private static final String DBNAME = "download.db";
  private static final int VERSION = 1;
  
  public DownloadDBHelper(Context paramContext)
  {
    super(paramContext, "download.db", null, 1);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS filedownlog (id integer primary key autoincrement, downpath text, threadid INTEGER, downlength INTEGER)");
    paramSQLiteDatabase.execSQL("create table if not exists downfileinfo (id integer primary key autoincrement,downpath text,date integer,md5 text,contentType text,contentLength integer,lastModified integer,etag text)");
    paramSQLiteDatabase.execSQL("create table if not exists appdownlog (id integer primary key autoincrement,hid text,title text,iconPath text,icon blob,readableFileSize text,packageName text,prefix text,md5 text,downPath text,filePath text,downLength integer,totalLength int,status integer)");
    paramSQLiteDatabase.execSQL("create table if not exists appdownlog_honly (id integer primary key autoincrement,hid text,title text,iconPath text,icon blob,readableFileSize text,packageName text,prefix text,md5 text,downPath text,filePath text,downLength integer,totalLength int,status integer)");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS filedownlog");
    paramSQLiteDatabase.execSQL("drop table if exists downfileinfo");
    paramSQLiteDatabase.execSQL("drop table if exists appdownlog");
    paramSQLiteDatabase.execSQL("drop table if exists appdownlog_honly");
    onCreate(paramSQLiteDatabase);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/vpn/data/DownloadDBHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */