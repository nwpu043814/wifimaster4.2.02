package com.lantern.browser.ui;

import android.os.Handler;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.bluefay.b.h;
import com.lantern.browser.WkBrowserWebView;
import com.lantern.browser.ab;
import com.lantern.browser.bp;

final class c
  implements com.bluefay.b.a
{
  c(a parama) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    Object localObject = (ab)paramObject;
    if (WkBrowserFeedFragment.a(this.a.a) == null) {}
    for (;;)
    {
      return;
      h.a("loadNews network state is " + ((ab)localObject).a() + ", " + ((ab)localObject).b(), new Object[0]);
      if ((((ab)localObject).a()) && (!((ab)localObject).b())) {
        WkBrowserFeedFragment.a(this.a.a).getSettings().setCacheMode(-1);
      }
      for (;;)
      {
        paramObject = this.a.a.c();
        paramString = WkBrowserFeedFragment.a(this.a.a, (String)paramObject);
        if (!((ab)localObject).b()) {
          break label205;
        }
        com.lantern.analytics.a.e().onEvent("dloadhij");
        if (!TextUtils.isEmpty(paramString)) {
          break;
        }
        WkBrowserFeedFragment.e(this.a.a);
        WkBrowserFeedFragment.h(this.a.a).removeMessages(1);
        WkBrowserFeedFragment.h(this.a.a).sendEmptyMessageDelayed(7, 1000L);
        break;
        WkBrowserFeedFragment.a(this.a.a).getSettings().setCacheMode(1);
      }
      label205:
      if ((!((ab)localObject).a()) && (TextUtils.isEmpty(paramString)))
      {
        WkBrowserFeedFragment.e(this.a.a);
        WkBrowserFeedFragment.h(this.a.a).removeMessages(1);
        WkBrowserFeedFragment.h(this.a.a).sendEmptyMessageDelayed(7, 1000L);
      }
      else
      {
        localObject = ((ab)localObject).c();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          if (TextUtils.isEmpty(paramString)) {
            WkBrowserFeedFragment.a(this.a.a).loadUrl((String)paramObject);
          }
          this.a.a.a((String)localObject);
          bp.a((String)paramObject, (String)localObject);
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/ui/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */