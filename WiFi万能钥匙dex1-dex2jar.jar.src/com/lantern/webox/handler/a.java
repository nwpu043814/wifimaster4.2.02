package com.lantern.webox.handler;

import com.lantern.browser.WkBrowserWebView;
import com.lantern.webox.b.e;
import com.lantern.webox.d;
import com.lantern.webox.event.WebEvent;
import com.lantern.webox.event.c;

public class a
  implements c
{
  private com.lantern.webox.event.a eventCenter;
  protected e logger = new e(getClass());
  protected WkBrowserWebView webox;
  
  public a(WkBrowserWebView paramWkBrowserWebView)
  {
    this.webox = paramWkBrowserWebView;
    this.webox.a(this);
    this.eventCenter = ((com.lantern.webox.event.a)d.a(com.lantern.webox.event.a.class));
    this.eventCenter.a(this);
  }
  
  protected void destroy()
  {
    this.eventCenter.b(this);
    this.webox.b(this);
  }
  
  public void onWebEvent(WebEvent paramWebEvent)
  {
    if (paramWebEvent.getType() == 7) {
      destroy();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/handler/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */