package com.lantern.push.provider;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

public class PushProvider
  extends ContentProvider
{
  private static final UriMatcher b = new UriMatcher(-1);
  private static Map<String, String> c = new HashMap();
  private SQLiteOpenHelper a;
  
  static
  {
    b.addURI("com.lantern.push", "message", 1);
    c.put("_id", "_id");
    c.put("title", "title");
    c.put("content", "content");
    c.put("icon", "icon");
    c.put("msgId", "msgId");
    c.put("pushId", "pushId");
    c.put("address", "address");
    c.put("state", "state");
    c.put("server_time", "server_time");
    c.put("create_time", "create_time");
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    int i = this.a.getWritableDatabase().delete("message", paramString, paramArrayOfString);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return i;
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    long l = this.a.getWritableDatabase().insert("message", null, paramContentValues);
    if (l > 0L)
    {
      paramUri = ContentUris.withAppendedId(b.a.a, l);
      getContext().getContentResolver().notifyChange(paramUri, null);
      return paramUri;
    }
    throw new SQLException("uri:" + paramUri.toString());
  }
  
  public boolean onCreate()
  {
    this.a = new a(getContext(), "push.db");
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    SQLiteDatabase localSQLiteDatabase = this.a.getReadableDatabase();
    SQLiteQueryBuilder localSQLiteQueryBuilder = new SQLiteQueryBuilder();
    localSQLiteQueryBuilder.setTables("message");
    localSQLiteQueryBuilder.setProjectionMap(c);
    paramArrayOfString1 = localSQLiteQueryBuilder.query(localSQLiteDatabase, paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
    paramArrayOfString1.setNotificationUri(getContext().getContentResolver(), paramUri);
    return paramArrayOfString1;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    int i = this.a.getWritableDatabase().update("message", paramContentValues, paramString, paramArrayOfString);
    getContext().getContentResolver().notifyChange(paramUri, null);
    return i;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/push/provider/PushProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */