package com.lantern.webox.a.a;

import com.lantern.browser.WkBrowserWebView;
import com.lantern.browser.bp;
import com.lantern.core.k;
import com.lantern.webox.a.m.a;
import com.lantern.webox.c.c;
import java.util.HashMap;
import java.util.Map;

final class w
  implements Runnable
{
  w(v paramv, WkBrowserWebView paramWkBrowserWebView, m.a parama) {}
  
  public final void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("onLine", Boolean.valueOf(c.a(this.a.getContext())));
    localHashMap.put("netModel", k.n(this.a.getContext()));
    localHashMap.put("capSsid", bp.a(this.a.getContext()));
    localHashMap.put("capBssid", bp.b(this.a.getContext()));
    this.b.a(localHashMap);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/a/a/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */