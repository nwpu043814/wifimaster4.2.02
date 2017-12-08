package com.lantern.push.utils;

import android.content.ContentResolver;
import android.database.Cursor;
import com.lantern.core.g.k;
import com.lantern.core.g.k.b;
import com.lantern.push.provider.b.a;

public final class a
{
  public static void a(ContentResolver paramContentResolver)
  {
    paramContentResolver = paramContentResolver.query(b.a.a, new String[] { "count(_id) as itemcount" }, "state = ? ", new String[] { "0" }, null);
    while ((paramContentResolver != null) && (paramContentResolver.moveToNext())) {
      if (paramContentResolver.getInt(0) > 0) {
        k.a().a(k.b.e);
      } else {
        k.a().c(k.b.e);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/push/utils/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */