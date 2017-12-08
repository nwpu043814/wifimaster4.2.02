package com.lantern.mailbox.c;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import com.lantern.mailbox.e.b;

final class c
  implements Runnable
{
  c(a parama, com.lantern.mailbox.d.a parama1, Bitmap paramBitmap) {}
  
  public final void run()
  {
    this.a.a(this.b);
    SQLiteDatabase localSQLiteDatabase = a.a(this.c);
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("ICON", b.a(this.b));
    localSQLiteDatabase.update("MESSAGE", localContentValues, "LID=?", new String[] { this.a.j() });
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/mailbox/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */