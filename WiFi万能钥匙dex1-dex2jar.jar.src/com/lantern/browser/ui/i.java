package com.lantern.browser.ui;

import com.lantern.browser.WkBrowserWebView;
import com.lantern.browser.c.b;
import com.lantern.webox.event.WebEvent;
import com.lantern.webox.event.c;

final class i
  implements c
{
  i(WkDetailContentLayout paramWkDetailContentLayout) {}
  
  public final void onWebEvent(WebEvent paramWebEvent)
  {
    if (paramWebEvent.getType() == 4)
    {
      WkDetailContentLayout.a(this.a);
      WkDetailContentLayout.b(this.a);
      WkDetailContentLayout.a(this.a, b.b(WkDetailContentLayout.c(this.a).getUrl(), "newsId"));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/ui/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */