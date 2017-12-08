package com.lantern.webox.authz;

import com.lantern.browser.WkBrowserWebView;
import com.lantern.core.g.j;
import com.lantern.webox.d;
import com.lantern.webox.event.WebEvent;

public final class l
  implements Runnable
{
  private WkBrowserWebView a;
  private k b;
  private int c = -1;
  
  public l(WkBrowserWebView paramWkBrowserWebView)
  {
    this.a = paramWkBrowserWebView;
    this.b = ((k)d.a(k.class));
  }
  
  public final void a()
  {
    if (this.c == -1)
    {
      this.c = 0;
      com.lantern.analytics.a.e().onEvent("conbyweb2");
      com.lantern.webox.b.a.a(this);
    }
  }
  
  public final void run()
  {
    if (this.a.h()) {
      this.c = 1;
    }
    for (;;)
    {
      return;
      if (!this.b.c())
      {
        this.c = 1;
      }
      else
      {
        if (1 == j.a().d()) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label83;
          }
          this.a.a(new WebEvent(this.a, 101));
          this.c = 1;
          break;
        }
        label83:
        com.lantern.webox.b.a.a(this, 3500L);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/authz/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */