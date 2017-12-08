package com.lantern.push.provider;

import android.net.Uri;
import android.provider.BaseColumns;

public final class b
{
  public static final class a
    implements BaseColumns
  {
    public static final Uri a = Uri.parse("content://com.lantern.push/message");
    public static final String[] b = { "_id INTEGER PRIMARY KEY", "title TEXT", "content TEXT", "pushId TEXT", "msgId TEXT", "address TEXT", "state INTEGER NOT NULL DEFAULT 0", "icon TEXT", "server_time INTEGER", "create_time INTEGER" };
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/push/provider/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */