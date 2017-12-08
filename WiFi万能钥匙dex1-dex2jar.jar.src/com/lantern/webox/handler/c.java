package com.lantern.webox.handler;

import com.lantern.browser.WkBrowserWebView;
import com.lantern.webox.domain.WebDownRequest;
import com.lantern.webox.event.WebEvent;

final class c
  implements com.lantern.webox.event.c
{
  c(b paramb, WebDownRequest paramWebDownRequest) {}
  
  public final void onWebEvent(WebEvent paramWebEvent)
  {
    if (paramWebEvent.getType() == 8)
    {
      b.a(this.b).b(this);
      b.a(this.b, this.a);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/handler/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */