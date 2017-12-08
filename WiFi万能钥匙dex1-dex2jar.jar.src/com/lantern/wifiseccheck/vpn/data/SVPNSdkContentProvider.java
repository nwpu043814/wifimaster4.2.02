package com.lantern.wifiseccheck.vpn.data;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;
import com.lantern.wifiseccheck.LogUtils;

public class SVPNSdkContentProvider
  extends ContentProvider
{
  public static final String AUTHORITY = "com.lantern.wifi.sec.provider";
  private static final int DETAILEVENT = 3;
  private static final int DETAILEVENTS = 4;
  private static final int LOG = 9;
  private static final int LOGS = 10;
  private static final int MAINEVENT = 1;
  private static final int MAINEVENTS = 2;
  private static final int PREFERENCE = 5;
  private static final int PREFERENCES = 6;
  private static final int RULE = 7;
  private static final int RULES = 8;
  private static final String TAG = "SVPNContentProvider";
  private static UriMatcher macher;
  private SVPNSQLiteHelper mHelper;
  
  static
  {
    UriMatcher localUriMatcher = new UriMatcher(-1);
    macher = localUriMatcher;
    localUriMatcher.addURI("com.lantern.wifi.sec.provider", "t_main_event", 2);
    macher.addURI("com.lantern.wifi.sec.provider", "t_main_event/#", 1);
    macher.addURI("com.lantern.wifi.sec.provider", "t_detail_event", 4);
    macher.addURI("com.lantern.wifi.sec.provider", "t_detail_event/#", 3);
    macher.addURI("com.lantern.wifi.sec.provider", "t_preference", 5);
    macher.addURI("com.lantern.wifi.sec.provider", "t_detail_event/#", 6);
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    SQLiteDatabase localSQLiteDatabase = this.mHelper.getWriteableDb();
    int i = 0;
    switch (macher.match(paramUri))
    {
    }
    for (;;)
    {
      getContext().getContentResolver().notifyChange(paramUri, null);
      return i;
      LogUtils.d("SVPNContentProvider", "delete main event ");
      i = localSQLiteDatabase.delete("t_main_event", paramString, paramArrayOfString);
      continue;
      LogUtils.d("SVPNContentProvider", "delete detail event ");
      i = localSQLiteDatabase.delete("t_detail_event", paramString, paramArrayOfString);
      continue;
      LogUtils.d("SVPNContentProvider", "delete preference ");
      i = localSQLiteDatabase.delete("t_preference", paramString, paramArrayOfString);
    }
  }
  
  public String getType(Uri paramUri)
  {
    switch (macher.match(paramUri))
    {
    default: 
      paramUri = null;
    }
    for (;;)
    {
      return paramUri;
      paramUri = "vnd.android.cursor.item/t_main_event";
      continue;
      paramUri = "vnd.android.cursor.dir/t_main_event";
      continue;
      paramUri = "vnd.android.cursor.item/t_detail_event";
      continue;
      paramUri = "vnd.android.cursor.dir/t_detail_event";
      continue;
      paramUri = "vnd.android.cursor.item/t_preference";
      continue;
      paramUri = "vnd.android.cursor.dir/t_preference";
      continue;
      paramUri = "vnd.android.cursor.item/t_detail_event";
      continue;
      paramUri = "vnd.android.cursor.dir/t_detail_event";
    }
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    SQLiteDatabase localSQLiteDatabase = this.mHelper.getWriteableDb();
    long l = -1L;
    switch (macher.match(paramUri))
    {
    default: 
      LogUtils.d("SVPNContentProvider", "insert with unkown uri:" + paramUri.toString());
    }
    for (;;)
    {
      paramUri = ContentUris.withAppendedId(paramUri, l);
      getContext().getContentResolver().notifyChange(paramUri, null);
      return paramUri;
      l = localSQLiteDatabase.insert("t_main_event", null, paramContentValues);
      continue;
      l = localSQLiteDatabase.insert("t_detail_event", null, paramContentValues);
      continue;
      l = localSQLiteDatabase.replace("t_preference", null, paramContentValues);
    }
  }
  
  public boolean onCreate()
  {
    this.mHelper = SVPNSQLiteHelper.getInstance(getContext());
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    int i = 0;
    SQLiteDatabase localSQLiteDatabase = this.mHelper.getWriteableDb();
    String str;
    StringBuilder localStringBuilder;
    switch (macher.match(paramUri))
    {
    default: 
      str = null;
      if (i != 0)
      {
        localStringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(paramString1)) {
          localStringBuilder.append(paramString1);
        }
      }
      break;
    }
    for (;;)
    {
      try
      {
        long l = ContentUris.parseId(paramUri);
        paramUri = localStringBuilder.append(" and ");
        paramString1 = new java/lang/StringBuilder;
        paramString1.<init>("id=");
        paramUri.append(l);
        paramUri = localSQLiteDatabase.query(str, paramArrayOfString1, localStringBuilder.toString(), paramArrayOfString2, null, null, paramString2);
        return paramUri;
        str = "t_main_event";
        i = 1;
        break;
        str = "t_main_event";
        break;
        str = "t_detail_event";
        i = 1;
        break;
        str = "t_detail_event";
        break;
        str = "t_preference";
        i = 1;
        break;
        str = "t_preference";
      }
      catch (Exception paramUri)
      {
        paramUri.printStackTrace();
        continue;
      }
      paramUri = localSQLiteDatabase.query(str, paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2);
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    SQLiteDatabase localSQLiteDatabase = this.mHelper.getWriteableDb();
    String str;
    switch (macher.match(paramUri))
    {
    default: 
      str = null;
    }
    for (;;)
    {
      int i = localSQLiteDatabase.update(str, paramContentValues, paramString, paramArrayOfString);
      getContext().getContentResolver().notifyChange(paramUri, null);
      return i;
      str = "t_main_event";
      continue;
      str = "t_detail_event";
      continue;
      str = "t_preference";
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/vpn/data/SVPNSdkContentProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */