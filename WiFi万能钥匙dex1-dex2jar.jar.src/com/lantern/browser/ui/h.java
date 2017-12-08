package com.lantern.browser.ui;

import android.text.TextUtils;
import bluefay.app.Fragment;
import bluefay.app.u;
import com.lantern.browser.WkBrowserWebView;
import com.lantern.browser.a;
import com.lantern.browser.at;
import com.lantern.browser.bp;
import com.lantern.webox.event.WebEvent;
import com.lantern.webox.event.c;

final class h
  implements c
{
  h(WkBrowserFragment paramWkBrowserFragment, WkBrowserWebView paramWkBrowserWebView) {}
  
  public final void onWebEvent(WebEvent paramWebEvent)
  {
    if (paramWebEvent.getType() == 4) {
      if ((!WkBrowserFragment.a(this.b)) && (WkBrowserFragment.b(this.b)))
      {
        paramWebEvent = (String)paramWebEvent.getData();
        if (!TextUtils.isEmpty(paramWebEvent))
        {
          if (!paramWebEvent.startsWith(a.b())) {
            break label79;
          }
          WkBrowserFragment.a(this.b, Fragment.a, new u(WkBrowserFragment.c(this.b)));
        }
      }
    }
    for (;;)
    {
      return;
      label79:
      WkBrowserFragment.b(this.b, Fragment.a, this.b.c());
      continue;
      if (paramWebEvent.getType() == 5)
      {
        if (this.a.getScrollY() == 0) {
          this.a.scrollTo(0, bp.b(this.a));
        }
        if (this.b.g.l().startsWith(a.b())) {
          WkBrowserFragment.c(this.b, Fragment.a, new u(WkBrowserFragment.d(this.b)));
        } else {
          WkBrowserFragment.d(this.b, Fragment.a, this.b.c());
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/ui/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */