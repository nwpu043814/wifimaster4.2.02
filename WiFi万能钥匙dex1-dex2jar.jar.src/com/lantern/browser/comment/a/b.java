package com.lantern.browser.comment.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public final class b
  extends SQLiteOpenHelper
{
  private static b a;
  
  private b(Context paramContext)
  {
    super(paramContext, "comment_cache.db", null, 1);
  }
  
  public static b a(Context paramContext)
  {
    if (a == null) {
      a = new b(paramContext);
    }
    return a;
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("create table if not exists comment_cache (_id integer primary key autoincrement,unique_id text, news_id text,news_title text,news_url text,comment_uhid text,comment_nickname text,comment_avatar text,comment_content text,reply_sequence integer,full_comment text,create_time integer)");
  }
  
  public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("drop table if exists comment_cache");
    onCreate(paramSQLiteDatabase);
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("drop table if exists comment_cache");
    onCreate(paramSQLiteDatabase);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */