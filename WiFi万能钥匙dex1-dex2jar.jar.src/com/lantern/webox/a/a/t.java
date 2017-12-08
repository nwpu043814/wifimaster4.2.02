package com.lantern.webox.a.a;

import android.app.Activity;
import android.webkit.WebBackForwardList;
import com.bluefay.b.h;
import com.lantern.browser.WkBrowserWebView;
import com.lantern.browser.at;
import com.lantern.browser.bh;
import com.lantern.browser.cc;

final class t
  implements Runnable
{
  t(o paramo, WkBrowserWebView paramWkBrowserWebView) {}
  
  public final void run()
  {
    if ((this.a.copyBackForwardList() == null) || (this.a.copyBackForwardList().getSize() == 0)) {}
    try
    {
      cc localcc = this.a.b();
      if ((localcc instanceof bh)) {
        ((bh)localcc).b().r().finish();
      }
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


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/a/a/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */