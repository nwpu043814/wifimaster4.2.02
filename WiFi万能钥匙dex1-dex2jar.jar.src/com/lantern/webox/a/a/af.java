package com.lantern.webox.a.a;

import com.lantern.browser.WkBrowserWebView;
import com.lantern.core.p;
import com.lantern.webox.a.t;
import com.lantern.webox.a.t.a;
import java.util.HashMap;
import java.util.Map;

public final class af
  implements t
{
  public final void a(WkBrowserWebView paramWkBrowserWebView, t.a parama)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("uhid", p.c(""));
    localHashMap.put("dhid", p.b(""));
    localHashMap.put("userToken", "");
    localHashMap.put("ph", p.c(paramWkBrowserWebView.getContext()));
    localHashMap.put("nick", "");
    parama.a(localHashMap);
  }
  
  public final void a(t.a parama)
  {
    parama.a();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/a/a/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */