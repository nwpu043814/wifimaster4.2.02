package com.lantern.dm.task;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.UriMatcher;
import android.content.pm.PackageManager.NameNotFoundException;
import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.CursorWrapper;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import com.bluefay.b.h;
import com.lantern.core.model.a;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class DownloadProvider
  extends ContentProvider
{
  private static final Uri[] c;
  private static final UriMatcher d;
  private static final String[] e;
  private static HashSet<String> f;
  private SQLiteOpenHelper a = null;
  private i b;
  
  static
  {
    int i = 0;
    c = new Uri[] { a.a, a.b };
    d = new UriMatcher(-1);
    e = new String[] { "_id", "entity", "_data", "mimetype", "visibility", "destination", "control", "status", "lastmod", "notificationpackage", "notificationclass", "total_bytes", "current_bytes", "title", "description", "uri", "is_visible_in_downloads_ui", "hint", "deleted", "icon", "item" };
    d.addURI("com.lantern.downloads", "my_downloads", 1);
    d.addURI("com.lantern.downloads", "my_downloads/#", 2);
    d.addURI("com.lantern.downloads", "all_downloads", 3);
    d.addURI("com.lantern.downloads", "all_downloads/#", 4);
    f = new HashSet();
    while (i < e.length)
    {
      f.add(e[i]);
      i++;
    }
  }
  
  private c a(Uri paramUri, String paramString, String[] paramArrayOfString, int paramInt)
  {
    c localc = new c((byte)0);
    localc.a(paramString, paramArrayOfString);
    if ((paramInt == 2) || (paramInt == 4)) {
      localc.a("_id = ?", new String[] { (String)paramUri.getPathSegments().get(1) });
    }
    if (((paramInt == 1) || (paramInt == 2)) && (getContext().checkCallingPermission("com.lantern.permission.ACCESS_ALL_DOWNLOADS") != 0)) {
      localc.a("uid= ? OR otheruid= ?", new Integer[] { Integer.valueOf(Binder.getCallingUid()), Integer.valueOf(Binder.getCallingPid()) });
    }
    return localc;
  }
  
  private void a(Uri paramUri, int paramInt)
  {
    if ((paramInt == 2) || (paramInt == 4)) {}
    for (paramUri = Long.valueOf(Long.parseLong((String)paramUri.getPathSegments().get(1)));; paramUri = null)
    {
      for (Uri localUri2 : c)
      {
        Uri localUri1 = localUri2;
        if (paramUri != null) {
          localUri1 = ContentUris.withAppendedId(localUri2, paramUri.longValue());
        }
        getContext().getContentResolver().notifyChange(localUri1, null);
      }
      return;
    }
  }
  
  private static final void a(String paramString, ContentValues paramContentValues1, ContentValues paramContentValues2)
  {
    paramContentValues1 = paramContentValues1.getAsInteger(paramString);
    if (paramContentValues1 != null) {
      paramContentValues2.put(paramString, paramContentValues1);
    }
  }
  
  private static final void a(String paramString1, ContentValues paramContentValues1, ContentValues paramContentValues2, String paramString2)
  {
    c(paramString1, paramContentValues1, paramContentValues2);
    if (!paramContentValues2.containsKey(paramString1)) {
      paramContentValues2.put(paramString1, paramString2);
    }
  }
  
  private static final void b(String paramString, ContentValues paramContentValues1, ContentValues paramContentValues2)
  {
    paramContentValues1 = paramContentValues1.getAsBoolean(paramString);
    if (paramContentValues1 != null) {
      paramContentValues2.put(paramString, paramContentValues1);
    }
  }
  
  private static final void c(String paramString, ContentValues paramContentValues1, ContentValues paramContentValues2)
  {
    paramContentValues1 = paramContentValues1.getAsString(paramString);
    if (paramContentValues1 != null) {
      paramContentValues2.put(paramString, paramContentValues1);
    }
  }
  
  public final int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    e.a(paramString, f);
    SQLiteDatabase localSQLiteDatabase = this.a.getWritableDatabase();
    int i = d.match(paramUri);
    paramString = a(paramUri, paramString, paramArrayOfString, i);
    int j = localSQLiteDatabase.delete("downloads", paramString.a.toString(), paramString.a());
    a(paramUri, i);
    return j;
  }
  
  public final String getType(Uri paramUri)
  {
    return null;
  }
  
  public final Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    bool = false;
    SQLiteDatabase localSQLiteDatabase = this.a.getWritableDatabase();
    localContentValues = new ContentValues();
    c("uri", paramContentValues, localContentValues);
    c("entity", paramContentValues, localContentValues);
    b("no_integrity", paramContentValues, localContentValues);
    c("hint", paramContentValues, localContentValues);
    c("mimetype", paramContentValues, localContentValues);
    b("is_public_api", paramContentValues, localContentValues);
    c("useragent", paramContentValues, localContentValues);
    int i;
    Object localObject;
    if (paramContentValues.getAsBoolean("is_public_api") == Boolean.TRUE)
    {
      i = 1;
      localInteger = paramContentValues.getAsInteger("destination");
      if (localInteger != null)
      {
        if (localInteger.intValue() == 4) {
          getContext().enforcePermission("android.permission.WRITE_EXTERNAL_STORAGE", Binder.getCallingPid(), Binder.getCallingUid(), "need WRITE_EXTERNAL_STORAGE permission to use DESTINATION_FILE_URI");
        }
        localContentValues.put("destination", localInteger);
      }
      localObject = paramContentValues.getAsInteger("visibility");
      if (localObject != null) {
        break label528;
      }
      if (localInteger.intValue() != 0) {
        break label514;
      }
      localContentValues.put("visibility", Integer.valueOf(1));
    }
    for (;;)
    {
      a("control", paramContentValues, localContentValues);
      localContentValues.put("status", Integer.valueOf(190));
      localContentValues.put("lastmod", Long.valueOf(this.b.a()));
      localObject = paramContentValues.getAsString("notificationpackage");
      String str = paramContentValues.getAsString("notificationclass");
      int j;
      if ((localObject != null) && ((str != null) || (i != 0)))
      {
        j = Binder.getCallingUid();
        if (j == 0) {}
      }
      try
      {
        if (this.b.a(j, (String)localObject))
        {
          localContentValues.put("notificationpackage", (String)localObject);
          if (str != null) {
            localContentValues.put("notificationclass", str);
          }
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        for (;;)
        {
          long l;
          localNameNotFoundException.printStackTrace();
          continue;
          if ((localInteger == null) || (localInteger.intValue() == 0)) {
            bool = true;
          }
          localContentValues.put("is_visible_in_downloads_ui", Boolean.valueOf(bool));
          continue;
          a(paramUri, d.match(paramUri));
          paramUri = ContentUris.withAppendedId(a.a, l);
        }
      }
      c("notificationextras", paramContentValues, localContentValues);
      c("cookiedata", paramContentValues, localContentValues);
      c("useragent", paramContentValues, localContentValues);
      c("referer", paramContentValues, localContentValues);
      localContentValues.put("uid", Integer.valueOf(Binder.getCallingUid()));
      if (Binder.getCallingUid() == 0) {
        a("uid", paramContentValues, localContentValues);
      }
      a("item", paramContentValues, localContentValues);
      a("title", paramContentValues, localContentValues, "");
      a("icon", paramContentValues, localContentValues, "");
      a("description", paramContentValues, localContentValues, "");
      localContentValues.put("total_bytes", Integer.valueOf(-1));
      localContentValues.put("current_bytes", Integer.valueOf(0));
      if (!paramContentValues.containsKey("is_visible_in_downloads_ui")) {
        break label550;
      }
      b("is_visible_in_downloads_ui", paramContentValues, localContentValues);
      if (i != 0)
      {
        a("allowed_network_types", paramContentValues, localContentValues);
        b("allow_roaming", paramContentValues, localContentValues);
      }
      paramContentValues = getContext();
      paramContentValues.startService(new Intent(paramContentValues, DownloadService.class));
      l = localSQLiteDatabase.insert("downloads", null, localContentValues);
      if (l != -1L) {
        break label581;
      }
      paramUri = null;
      return paramUri;
      i = 0;
      break;
      label514:
      localContentValues.put("visibility", Integer.valueOf(2));
      continue;
      label528:
      localContentValues.put("visibility", (Integer)localObject);
    }
  }
  
  public final boolean onCreate()
  {
    if (this.b == null) {
      this.b = new f(getContext());
    }
    this.a = new a(getContext());
    return true;
  }
  
  public final ParcelFileDescriptor openFile(Uri paramUri, String paramString)
  {
    Cursor localCursor = query(paramUri, new String[] { "_data" }, null, null, null);
    paramString = "";
    paramUri = paramString;
    if (localCursor != null) {
      paramUri = paramString;
    }
    try
    {
      if (localCursor.getCount() > 0)
      {
        localCursor.moveToFirst();
        paramUri = localCursor.getString(0);
      }
      return ParcelFileDescriptor.open(new File(paramUri), 268435456);
    }
    finally
    {
      if (localCursor != null) {
        localCursor.close();
      }
    }
  }
  
  public final Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    e.a(paramString1, f);
    SQLiteDatabase localSQLiteDatabase = this.a.getReadableDatabase();
    paramString1 = a(paramUri, paramString1, paramArrayOfString2, d.match(paramUri));
    paramArrayOfString1 = localSQLiteDatabase.query("downloads", paramArrayOfString1, paramString1.a.toString(), paramString1.a(), null, null, paramString2);
    if (paramArrayOfString1 != null)
    {
      paramArrayOfString1 = new b(paramArrayOfString1);
      paramArrayOfString1.setNotificationUri(getContext().getContentResolver(), paramUri);
    }
    for (paramUri = paramArrayOfString1;; paramUri = paramArrayOfString1) {
      return paramUri;
    }
  }
  
  public final int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    int j = 0;
    int m = 1;
    int k = 1;
    e.a(paramString, f);
    SQLiteDatabase localSQLiteDatabase = this.a.getWritableDatabase();
    if ((paramContentValues.containsKey("deleted")) && (paramContentValues.getAsInteger("deleted").intValue() == 1)) {}
    for (int i = 1;; i = 0)
    {
      Object localObject1;
      Object localObject2;
      if (Binder.getCallingPid() != Process.myPid())
      {
        localObject1 = new ContentValues();
        c("entity", paramContentValues, (ContentValues)localObject1);
        a("visibility", paramContentValues, (ContentValues)localObject1);
        localObject2 = paramContentValues.getAsInteger("control");
        if (localObject2 == null) {
          break label387;
        }
        ((ContentValues)localObject1).put("control", (Integer)localObject2);
      }
      label387:
      for (j = k;; j = i)
      {
        a("status", paramContentValues, (ContentValues)localObject1);
        a("control", paramContentValues, (ContentValues)localObject1);
        c("title", paramContentValues, (ContentValues)localObject1);
        c("description", paramContentValues, (ContentValues)localObject1);
        a("deleted", paramContentValues, (ContentValues)localObject1);
        for (;;)
        {
          i = d.match(paramUri);
          paramContentValues = a(paramUri, paramString, paramArrayOfString, i);
          k = localSQLiteDatabase.update("downloads", (ContentValues)localObject1, paramContentValues.a.toString(), paramContentValues.a());
          a(paramUri, i);
          if (j != 0)
          {
            paramUri = getContext();
            paramUri.startService(new Intent(paramUri, DownloadService.class));
          }
          return k;
          localObject1 = paramContentValues.getAsString("_data");
          if (localObject1 != null)
          {
            localObject2 = query(paramUri, new String[] { "title" }, null, null, null);
            if ((!((Cursor)localObject2).moveToFirst()) || (((Cursor)localObject2).getString(0).length() == 0)) {
              paramContentValues.put("title", new File((String)localObject1).getName());
            }
            ((Cursor)localObject2).close();
          }
          localObject1 = paramContentValues.getAsInteger("status");
          k = j;
          if (localObject1 != null)
          {
            k = j;
            if (((Integer)localObject1).intValue() == 190) {
              k = 1;
            }
          }
          boolean bool = paramContentValues.containsKey("bypass_recommended_size_limit");
          j = m;
          localObject1 = paramContentValues;
          if (k == 0)
          {
            j = m;
            localObject1 = paramContentValues;
            if (!bool)
            {
              j = i;
              localObject1 = paramContentValues;
            }
          }
        }
      }
    }
  }
  
  private final class a
    extends SQLiteOpenHelper
  {
    public a(Context paramContext)
    {
      super("downloads.db", null, 2);
    }
    
    private static void a(SQLiteDatabase paramSQLiteDatabase, ContentValues paramContentValues)
    {
      String str = (String)((Map.Entry)paramContentValues.valueSet().iterator().next()).getKey();
      paramSQLiteDatabase.update("downloads", paramContentValues, str + " is null", null);
      paramContentValues.clear();
    }
    
    public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      try
      {
        paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS downloads");
        paramSQLiteDatabase.execSQL("CREATE TABLE downloads(_id INTEGER PRIMARY KEY AUTOINCREMENT,uri TEXT, method INTEGER, entity TEXT, no_integrity BOOLEAN, hint TEXT, otaupdate BOOLEAN, _data TEXT, mimetype TEXT, destination INTEGER, no_system BOOLEAN, visibility INTEGER, control INTEGER, status INTEGER, numfailed INTEGER, lastmod BIGINT, notificationpackage TEXT, notificationclass TEXT, notificationextras TEXT, cookiedata TEXT, useragent TEXT, referer TEXT, total_bytes INTEGER, current_bytes INTEGER, etag TEXT, uid INTEGER, otheruid INTEGER, title TEXT, icon TEXT, item INTEGER NOT NULL DEFAULT 0, is_public_api INTEGER NOT NULL DEFAULT 0, allow_roaming INTEGER NOT NULL DEFAULT 0, allowed_network_types INTEGER NOT NULL DEFAULT 0, is_visible_in_downloads_ui INTEGER NOT NULL DEFAULT 1, bypass_recommended_size_limit INTEGER NOT NULL DEFAULT 0, deleted BOOLEAN NOT NULL DEFAULT 0, description TEXT) ");
        h.a("CREATE TABLE downloads(_id INTEGER PRIMARY KEY AUTOINCREMENT,uri TEXT, method INTEGER, entity TEXT, no_integrity BOOLEAN, hint TEXT, otaupdate BOOLEAN, _data TEXT, mimetype TEXT, destination INTEGER, no_system BOOLEAN, visibility INTEGER, control INTEGER, status INTEGER, numfailed INTEGER, lastmod BIGINT, notificationpackage TEXT, notificationclass TEXT, notificationextras TEXT, cookiedata TEXT, useragent TEXT, referer TEXT, total_bytes INTEGER, current_bytes INTEGER, etag TEXT, uid INTEGER, otheruid INTEGER, title TEXT, icon TEXT, item INTEGER NOT NULL DEFAULT 0, is_public_api INTEGER NOT NULL DEFAULT 0, allow_roaming INTEGER NOT NULL DEFAULT 0, allowed_network_types INTEGER NOT NULL DEFAULT 0, is_visible_in_downloads_ui INTEGER NOT NULL DEFAULT 1, bypass_recommended_size_limit INTEGER NOT NULL DEFAULT 0, deleted BOOLEAN NOT NULL DEFAULT 0, description TEXT) ", new Object[0]);
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("is_visible_in_downloads_ui", Boolean.valueOf(false));
        paramSQLiteDatabase.update("downloads", localContentValues, "destination != 0", null);
        localContentValues = new ContentValues();
        localContentValues.put("current_bytes", Integer.valueOf(0));
        a(paramSQLiteDatabase, localContentValues);
        localContentValues.put("total_bytes", Integer.valueOf(-1));
        a(paramSQLiteDatabase, localContentValues);
        localContentValues.put("title", "");
        a(paramSQLiteDatabase, localContentValues);
        localContentValues.put("description", "");
        a(paramSQLiteDatabase, localContentValues);
        return;
      }
      catch (SQLException localSQLException)
      {
        for (;;)
        {
          h.a(localSQLException);
        }
      }
    }
    
    public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      paramSQLiteDatabase.execSQL("drop table if exists downloads");
      onCreate(paramSQLiteDatabase);
    }
    
    public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      paramSQLiteDatabase.execSQL("drop table if exists downloads");
      onCreate(paramSQLiteDatabase);
    }
  }
  
  private final class b
    extends CursorWrapper
    implements CrossProcessCursor
  {
    private CrossProcessCursor b;
    
    public b(Cursor paramCursor)
    {
      super();
      this.b = ((CrossProcessCursor)paramCursor);
    }
    
    public final void fillWindow(int paramInt, CursorWindow paramCursorWindow)
    {
      this.b.fillWindow(paramInt, paramCursorWindow);
    }
    
    public final CursorWindow getWindow()
    {
      return this.b.getWindow();
    }
    
    public final boolean onMove(int paramInt1, int paramInt2)
    {
      return this.b.onMove(paramInt1, paramInt2);
    }
  }
  
  private static final class c
  {
    public StringBuilder a = new StringBuilder();
    public List<String> b = new ArrayList();
    
    public final <T> void a(String paramString, T... paramVarArgs)
    {
      if ((paramString == null) || (paramString.length() == 0)) {}
      for (;;)
      {
        return;
        if (this.a.length() != 0) {
          this.a.append(" AND ");
        }
        this.a.append("(");
        this.a.append(paramString);
        this.a.append(")");
        if (paramVarArgs != null)
        {
          int j = paramVarArgs.length;
          for (int i = 0; i < j; i++)
          {
            paramString = paramVarArgs[i];
            this.b.add(paramString.toString());
          }
        }
      }
    }
    
    public final String[] a()
    {
      String[] arrayOfString = new String[this.b.size()];
      return (String[])this.b.toArray(arrayOfString);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/dm/task/DownloadProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */