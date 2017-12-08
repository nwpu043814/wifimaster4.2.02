package com.lantern.webox.authz;

import com.bluefay.b.h;
import com.lantern.browser.WkBrowserWebView;

final class j
  implements Runnable
{
  j(f paramf) {}
  
  public final void run()
  {
    try
    {
      f.j(this.a).setScrollY(1);
      f.k(this.a).postInvalidate();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.a(localException);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/authz/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */