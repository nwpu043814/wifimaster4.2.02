package com.linksure.apservice.a.b.a;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.linksure.apservice.a.b.a.a.a;
import com.linksure.apservice.a.b.d;
import com.linksure.apservice.a.d.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class b
  implements d
{
  private a a;
  
  public b(a parama)
  {
    this.a = parama;
  }
  
  private static f a(Cursor paramCursor)
  {
    a locala = a.a(paramCursor);
    f localf = new f();
    localf.a = paramCursor.getLong(locala.a);
    localf.b = paramCursor.getInt(locala.b);
    localf.c = paramCursor.getInt(locala.c);
    localf.e = paramCursor.getString(locala.d);
    localf.g = paramCursor.getLong(locala.e);
    localf.d = paramCursor.getString(locala.f);
    localf.f = paramCursor.getInt(locala.g);
    return localf;
  }
  
  private static ContentValues b(f paramf)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("thread_id", paramf.e);
    localContentValues.put("type", Integer.valueOf(paramf.b));
    localContentValues.put("stat", Integer.valueOf(paramf.c));
    localContentValues.put("ts", Long.valueOf(paramf.g));
    localContentValues.put("content", paramf.d);
    localContentValues.put("send", Integer.valueOf(paramf.f));
    return localContentValues;
  }
  
  public final long a(f paramf)
  {
    Log.e("--->", "dao create message:" + paramf);
    return this.a.a().insert("aps_message", null, b(paramf));
  }
  
  public final f a(long paramLong)
  {
    f localf = null;
    Cursor localCursor = this.a.a().rawQuery("select * from aps_message where _id=" + paramLong, null);
    if (localCursor.moveToFirst()) {
      localf = a(localCursor);
    }
    return localf;
  }
  
  public final f a(String paramString)
  {
    Cursor localCursor = this.a.a().rawQuery("SELECT * from aps_message WHERE thread_id=? ORDER BY _ID DESC LIMIT 1", new String[] { paramString });
    paramString = null;
    if (localCursor.moveToFirst()) {
      paramString = a(localCursor);
    }
    localCursor.close();
    return paramString;
  }
  
  public final List<f> a(String paramString, long paramLong)
  {
    Cursor localCursor = this.a.a().rawQuery("select * from aps_message WHERE thread_id=? AND ts < ? ORDER BY ts DESC LIMIT ?", new String[] { paramString, String.valueOf(paramLong), "10" });
    paramString = new ArrayList(localCursor.getCount());
    while (localCursor.moveToNext()) {
      paramString.add(a(localCursor));
    }
    localCursor.close();
    Collections.reverse(paramString);
    return paramString;
  }
  
  public final void a(long paramLong, int paramInt)
  {
    Cursor localCursor = this.a.a().rawQuery("UPDATE aps_message SET stat=? WHERE _id=?", new String[] { String.valueOf(paramInt), String.valueOf(paramLong) });
    localCursor.moveToFirst();
    localCursor.close();
  }
  
  public final void a(long paramLong, f paramf)
  {
    this.a.a().update("aps_message", b(paramf), "_id=" + paramLong, null);
  }
  
  public final void b(long paramLong)
  {
    this.a.a().delete("aps_message", "_id=" + paramLong, null);
  }
  
  public final void b(String paramString)
  {
    this.a.a().delete("aps_message", "thread_id=?", new String[] { paramString });
  }
  
  public final void c(String paramString)
  {
    paramString = this.a.a().rawQuery("UPDATE aps_message SET stat=4 WHERE stat=? AND thread_id=?", new String[] { "3", paramString });
    paramString.moveToFirst();
    paramString.close();
  }
  
  static final class a
  {
    private static a h;
    int a;
    int b;
    int c;
    int d;
    int e;
    int f;
    int g;
    
    public static a a(Cursor paramCursor)
    {
      if (h == null)
      {
        a locala = new a();
        h = locala;
        locala.a = paramCursor.getColumnIndex("_id");
        h.b = paramCursor.getColumnIndex("type");
        h.c = paramCursor.getColumnIndex("stat");
        h.d = paramCursor.getColumnIndex("thread_id");
        h.e = paramCursor.getColumnIndex("ts");
        h.f = paramCursor.getColumnIndex("content");
        h.g = paramCursor.getColumnIndex("send");
      }
      return h;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/a/b/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */