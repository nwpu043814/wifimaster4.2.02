package com.lantern.webox.browser;

import com.lantern.browser.WkBrowserWebView;
import com.lantern.webox.a;
import com.lantern.webox.event.WebEvent;

final class l
  implements com.lantern.webox.event.c
{
  l(BrowserJsInterface paramBrowserJsInterface, String paramString1, String paramString2, String paramString3, Object paramObject) {}
  
  public final void onWebEvent(WebEvent paramWebEvent)
  {
    if (paramWebEvent.getType() == 8)
    {
      boolean bool = BrowserJsInterface.access$000(this.e).f().a(this.a, this.b, this.c);
      BrowserJsInterface.access$100(this.e).a(BrowserJsInterface.access$000(this.e), this.d, Boolean.valueOf(bool));
      BrowserJsInterface.access$000(this.e).b(this);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/browser/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */