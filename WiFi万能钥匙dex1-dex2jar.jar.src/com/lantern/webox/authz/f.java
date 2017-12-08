package com.lantern.webox.authz;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import com.lantern.browser.R.string;
import com.lantern.browser.WkBrowserWebView;
import com.lantern.webox.a.o;
import com.lantern.webox.b.c;
import com.lantern.webox.d;
import com.lantern.webox.domain.AuthzPageConfig;
import com.lantern.webox.event.WebEvent;
import com.lantern.webox.handler.a;

public final class f
  extends a
{
  private o a;
  private k b;
  private c c = new c();
  
  public f(WkBrowserWebView paramWkBrowserWebView)
  {
    super(paramWkBrowserWebView);
    this.c.a(false);
    this.a = ((o)d.a(o.class));
    this.b = ((k)d.a(k.class));
  }
  
  private void a()
  {
    this.webox.postDelayed(new j(this), 1000L);
  }
  
  private void a(int paramInt)
  {
    try
    {
      String str = this.webox.getContext().getResources().getString(paramInt);
      WkBrowserWebView localWkBrowserWebView = this.webox;
      WebEvent localWebEvent = new com/lantern/webox/event/WebEvent;
      localWebEvent.<init>(this.webox, 103, str);
      localWkBrowserWebView.a(localWebEvent);
      return;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      for (;;) {}
    }
  }
  
  private void a(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return;
      new StringBuilder("[authz] parse html, length=").append(paramString.length());
      this.webox.postDelayed(new g(this, paramString), 1000L);
    }
  }
  
  public final void onWebEvent(WebEvent paramWebEvent)
  {
    super.onWebEvent(paramWebEvent);
    if (this.b.a()) {}
    for (;;)
    {
      return;
      if (!this.webox.h())
      {
        if (paramWebEvent.getType() == 105) {
          a((String)this.webox.a("page_content"));
        }
        if (paramWebEvent.getType() == 6) {
          a(paramWebEvent.getData());
        }
        if (paramWebEvent.getType() == 104)
        {
          paramWebEvent = paramWebEvent.getData();
          AuthzPageConfig localAuthzPageConfig = this.b.g();
          this.c.a(this.webox, "wifikey_authz.fillAuthzCode", new Object[] { paramWebEvent, localAuthzPageConfig.getAuthzCodeInput() });
          a();
          if (this.b.e())
          {
            a(R.string.webox_authz_login);
            paramWebEvent = this.b.g();
            this.c.a(this.webox, "wifikey_authz.login", paramWebEvent.getLoginButton(), 1000L);
          }
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/authz/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */