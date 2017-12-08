package com.lantern.browser.a;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Handler;
import com.lantern.core.c;

public final class a
{
  private Cursor a = c.getAppContext().getContentResolver().query(com.lantern.core.model.a.a, null, "status='192'", null, null);
  private a b = new a();
  
  public a()
  {
    if (this.a != null) {
      this.a.registerContentObserver(this.b);
    }
  }
  
  private final class a
    extends ContentObserver
  {
    public a()
    {
      super();
    }
    
    public final boolean deliverSelfNotifications()
    {
      return true;
    }
    
    public final void onChange(boolean paramBoolean)
    {
      if ((a.a(a.this) == null) || (a.a(a.this).isClosed())) {}
      for (;;)
      {
        return;
        a.a(a.this).requery();
        a.b(a.this);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */