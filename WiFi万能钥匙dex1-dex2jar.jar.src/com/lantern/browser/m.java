package com.lantern.browser;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.bluefay.b.h;

public final class m
{
  private static m a;
  private boolean b = false;
  
  public static m a()
  {
    if (a == null) {
      a = new m();
    }
    return a;
  }
  
  public final void a(Context paramContext)
  {
    if (this.b) {}
    for (;;)
    {
      return;
      CookieSyncManager.createInstance(paramContext.getApplicationContext()).startSync();
      this.b = true;
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if (!this.b) {}
    for (;;)
    {
      return;
      CookieManager.getInstance().setAcceptCookie(true);
      try
      {
        CookieManager.getInstance().setCookie(paramString1, paramString2);
        CookieSyncManager.getInstance().sync();
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          h.a(paramString1);
        }
      }
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    if (!this.b) {}
    for (;;)
    {
      return;
      CookieManager.getInstance().setAcceptCookie(paramBoolean);
    }
  }
  
  public final void b()
  {
    if (!this.b) {}
    for (;;)
    {
      return;
      CookieSyncManager.getInstance().resetSync();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */