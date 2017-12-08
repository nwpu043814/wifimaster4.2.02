package com.lantern.mailbox.c;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

final class b
  implements Runnable
{
  b(a parama, String paramString) {}
  
  public final void run()
  {
    SQLiteDatabase localSQLiteDatabase = a.a(this.b);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("UNREAD", Integer.valueOf(1));
    localSQLiteDatabase.update("MESSAGE", localContentValues, "LID=?", new String[] { this.a });
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/mailbox/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */