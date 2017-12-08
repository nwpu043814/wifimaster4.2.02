package com.lantern.webox.handler;

import com.lantern.browser.WkBrowserWebView;
import com.lantern.webox.event.WebEvent;

public final class e
  extends a
{
  private boolean a;
  
  public e(WkBrowserWebView paramWkBrowserWebView)
  {
    super(paramWkBrowserWebView);
  }
  
  public final void onWebEvent(WebEvent paramWebEvent)
  {
    super.onWebEvent(paramWebEvent);
    if ((paramWebEvent.getType() == 4) && (this.webox.e() == null) && (!this.a))
    {
      this.a = true;
      com.lantern.webox.b.a.a(new f(this, this.webox.getUrl()));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/handler/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */