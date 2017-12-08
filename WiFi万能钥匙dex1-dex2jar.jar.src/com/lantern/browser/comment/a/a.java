package com.lantern.browser.comment.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.lantern.browser.comment.d.f;
import com.lantern.core.c;
import java.util.ArrayList;
import java.util.List;

public final class a
{
  private static Object a = new Object();
  
  public static long a(f paramf)
  {
    synchronized (a)
    {
      SQLiteDatabase localSQLiteDatabase = b.a(c.getInstance()).getWritableDatabase();
      ContentValues localContentValues = new android/content/ContentValues;
      localContentValues.<init>();
      localContentValues.put("unique_id", paramf.a());
      localContentValues.put("news_id", paramf.b());
      localContentValues.put("news_title", paramf.d());
      localContentValues.put("news_url", paramf.c());
      localContentValues.put("comment_uhid", paramf.e());
      localContentValues.put("comment_nickname", paramf.f());
      localContentValues.put("comment_avatar", paramf.g());
      localContentValues.put("comment_content", paramf.h());
      localContentValues.put("reply_sequence", Integer.valueOf(paramf.i()));
      localContentValues.put("full_comment", paramf.j());
      localContentValues.put("create_time", Long.valueOf(paramf.k()));
      long l = localSQLiteDatabase.insert("comment_cache", null, localContentValues);
      if (l != -1L)
      {
        paramf = localSQLiteDatabase.query("comment_cache", null, null, null, null, null, null);
        if (paramf != null)
        {
          int i = paramf.getCount();
          if (i > 10)
          {
            paramf = new java/lang/StringBuilder;
            paramf.<init>("delete from comment_cache where rowid IN (Select rowid from comment_cache order by _id DESC limit ");
            localSQLiteDatabase.execSQL(i - 10 + ")");
          }
        }
      }
      return l;
    }
  }
  
  private static f a(Cursor paramCursor)
  {
    f localf = new f();
    localf.a(paramCursor.getLong(paramCursor.getColumnIndex("_id")));
    localf.a(paramCursor.getString(paramCursor.getColumnIndex("unique_id")));
    localf.b(paramCursor.getString(paramCursor.getColumnIndex("news_id")));
    localf.d(paramCursor.getString(paramCursor.getColumnIndex("news_title")));
    localf.c(paramCursor.getString(paramCursor.getColumnIndex("news_url")));
    localf.e(paramCursor.getString(paramCursor.getColumnIndex("comment_uhid")));
    localf.f(paramCursor.getString(paramCursor.getColumnIndex("comment_nickname")));
    localf.g(paramCursor.getString(paramCursor.getColumnIndex("comment_avatar")));
    localf.h(paramCursor.getString(paramCursor.getColumnIndex("comment_content")));
    localf.a(paramCursor.getInt(paramCursor.getColumnIndex("reply_sequence")));
    localf.i(paramCursor.getString(paramCursor.getColumnIndex("full_comment")));
    localf.b(paramCursor.getLong(paramCursor.getColumnIndex("create_time")));
    return localf;
  }
  
  public static List<f> a()
  {
    for (;;)
    {
      synchronized (a)
      {
        Object localObject1 = b.a(c.getInstance()).getReadableDatabase();
        Object localObject5 = new java/lang/StringBuilder;
        ((StringBuilder)localObject5).<init>();
        localObject5 = ((SQLiteDatabase)localObject1).query("comment_cache", null, null, null, null, null, "create_time ASC " + " limit 10");
        if ((localObject5 != null) && (((Cursor)localObject5).getCount() > 0) && (((Cursor)localObject5).moveToFirst()))
        {
          localObject1 = new java/util/ArrayList;
          ((ArrayList)localObject1).<init>();
          ((List)localObject1).add(a((Cursor)localObject5));
          if (((Cursor)localObject5).moveToNext()) {
            continue;
          }
          if (localObject5 != null) {
            ((Cursor)localObject5).close();
          }
          return (List<f>)localObject1;
        }
      }
      Object localObject3 = null;
    }
  }
  
  public static List<f> a(String paramString)
  {
    for (;;)
    {
      synchronized (a)
      {
        Cursor localCursor = b.a(c.getInstance()).getReadableDatabase().query("comment_cache", null, "news_id = ? ", new String[] { paramString }, null, null, "create_time DESC ");
        if ((localCursor != null) && (localCursor.getCount() > 0) && (localCursor.moveToFirst()))
        {
          paramString = new java/util/ArrayList;
          paramString.<init>();
          paramString.add(a(localCursor));
          if (localCursor.moveToNext()) {
            continue;
          }
          if (localCursor != null) {
            localCursor.close();
          }
          return paramString;
        }
      }
      paramString = null;
    }
  }
  
  public static int b()
  {
    synchronized (a)
    {
      int i = b.a(c.getInstance()).getWritableDatabase().delete("comment_cache", null, null);
      return i;
    }
  }
  
  public static int b(String paramString)
  {
    for (;;)
    {
      synchronized (a)
      {
        paramString = b.a(c.getInstance()).getReadableDatabase().query("comment_cache", new String[] { "count(_id)" }, "news_id = ? ", new String[] { paramString }, null, null, "create_time DESC ");
        if ((paramString != null) && (paramString.getCount() > 0) && (paramString.moveToFirst()))
        {
          i = paramString.getInt(0);
          if (paramString.moveToNext()) {
            continue;
          }
          if (paramString != null) {
            paramString.close();
          }
          return i;
        }
      }
      int i = 0;
    }
  }
  
  public static boolean c(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    synchronized (a)
    {
      if (TextUtils.isEmpty(paramString)) {
        return bool1;
      }
      bool1 = bool2;
      if (b.a(c.getInstance()).getWritableDatabase().delete("comment_cache", "unique_id = ? ", new String[] { paramString }) > 0) {
        bool1 = true;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */