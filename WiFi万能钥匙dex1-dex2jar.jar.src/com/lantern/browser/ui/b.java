package com.lantern.browser.ui;

import com.lantern.browser.WkBrowserWebView;
import com.lantern.core.g.j;

final class b
  implements com.bluefay.b.a
{
  b(a parama) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    if ((WkBrowserFeedFragment.a(this.a.a) == null) || (!WkBrowserFeedFragment.b(this.a.a)) || (this.a.a.getActivity() == null) || (this.a.a.isDetached())) {}
    for (;;)
    {
      return;
      if (j.b(((Integer)paramObject).intValue())) {
        WkBrowserFeedFragment.a(this.a.a).loadUrl(this.a.a.c());
      } else {
        WkBrowserFeedFragment.e(this.a.a);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/ui/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */