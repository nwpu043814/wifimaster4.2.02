package com.lantern.browser.ui;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.bluefay.b.h;
import com.bluefay.material.MaterialProgressBar;
import com.bluefay.material.SwipeRefreshLayout;
import com.lantern.browser.WkBrowserWebView;
import com.lantern.browser.bp;
import com.lantern.browser.y;
import com.lantern.core.g.j;

final class a
  extends Handler
{
  a(WkBrowserFeedFragment paramWkBrowserFeedFragment) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if ((WkBrowserFeedFragment.a(this.a) == null) || (!WkBrowserFeedFragment.b(this.a)) || (this.a.getActivity() == null) || (this.a.isDetached())) {}
    for (;;)
    {
      return;
      switch (paramMessage.what)
      {
      default: 
        break;
      case 1: 
        WkBrowserFeedFragment.c(this.a).setVisibility(4);
        h.a("MSG_TIMEOUT mWebViewProgress:" + WkBrowserFeedFragment.d(this.a), new Object[0]);
        if (WkBrowserFeedFragment.d(this.a) <= 10) {
          WkBrowserFeedFragment.e(this.a);
        } else {
          WkBrowserFeedFragment.a(this.a).loadUrl("javascript:WiFikey.getHtml('<html>'+document.getElementsByTagName('html')[0].innerHTML+'</html>');");
        }
        break;
      case 2: 
        WkBrowserFeedFragment.f(this.a).a(false);
        break;
      case 7: 
        WkBrowserFeedFragment.c(this.a).setVisibility(4);
        break;
      case 3: 
        String str = this.a.c();
        if (bp.d(WkBrowserFeedFragment.g(this.a), str))
        {
          j.a().a(new b(this));
        }
        else
        {
          paramMessage = new StringBuilder();
          paramMessage.append("&ts=" + System.currentTimeMillis());
          new y(str + paramMessage.toString(), new c(this)).execute(new String[0]);
        }
        break;
      case 4: 
        paramMessage = PreferenceManager.getDefaultSharedPreferences(WkBrowserFeedFragment.i(this.a));
        WkBrowserFeedFragment.b(this.a, paramMessage.getString("feed_test_url", ""));
        paramMessage = paramMessage.getString("js_test_url", "");
        if (!TextUtils.isEmpty(paramMessage)) {
          bp.b(WkBrowserFeedFragment.j(this.a), paramMessage);
        }
        break;
      case 5: 
        WkBrowserFeedFragment.k(this.a);
        break;
      case 6: 
        if ((WkBrowserFeedFragment.a(this.a) != null) && (WkBrowserFeedFragment.a(this.a).i())) {
          WkBrowserFeedFragment.a(this.a, 2);
        }
        WkBrowserFeedFragment.h(this.a).removeMessages(6);
        WkBrowserFeedFragment.h(this.a).sendEmptyMessageDelayed(6, 300000L);
        break;
      case 8: 
        WkBrowserFeedFragment.l(this.a);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/ui/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */