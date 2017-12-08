package com.lantern.webox.authz;

import com.lantern.browser.WkBrowserWebView;
import com.lantern.webox.a.o.a;
import com.lantern.webox.event.WebEvent;

final class h
  implements o.a
{
  h(f paramf) {}
  
  public final void a(String paramString)
  {
    if (f.d(this.a).a()) {}
    for (;;)
    {
      return;
      if (paramString == null) {}
      for (paramString = null;; paramString = paramString.replaceAll(" ", "").replaceAll("-", "").replaceAll("\\+86", ""))
      {
        if ((paramString != null) && (paramString.length() != 0)) {
          break label86;
        }
        f.f(this.a).a(new WebEvent(f.e(this.a), 102));
        break;
      }
      label86:
      f.a(this.a, paramString);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/authz/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */