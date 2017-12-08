package com.lantern.browser.ui;

import android.os.Handler;
import android.text.TextUtils;
import com.bluefay.material.SwipeRefreshLayout;
import com.lantern.browser.WkBrowserWebView;

final class e
  implements Runnable
{
  e(WkBrowserFeedFragment paramWkBrowserFeedFragment) {}
  
  public final void run()
  {
    WkBrowserFeedFragment.h(this.a).removeMessages(2);
    WkBrowserFeedFragment.f(this.a).a(false);
    if ((WkBrowserFeedFragment.a(this.a) != null) && ((TextUtils.isEmpty(WkBrowserFeedFragment.m(this.a))) || (WkBrowserFeedFragment.m(this.a).startsWith("http://wifi02.51y5.net/wifi/apromote.do")))) {
      WkBrowserFeedFragment.a(this.a).a(true);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/ui/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */