package com.lantern.webox.browser;

import com.lantern.browser.WkBrowserWebView;
import com.lantern.webox.event.WebEvent;

final class a
  implements com.lantern.webox.event.c
{
  a(BrowserJsInterface paramBrowserJsInterface, Object paramObject) {}
  
  public final void onWebEvent(WebEvent paramWebEvent)
  {
    if (paramWebEvent.getType() == 8)
    {
      BrowserJsInterface.access$100(this.b).a(BrowserJsInterface.access$000(this.b), this.a, null);
      BrowserJsInterface.access$000(this.b).b(this);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/browser/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */