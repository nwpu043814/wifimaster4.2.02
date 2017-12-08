package com.lantern.webox.a.a;

import android.os.Build;
import android.os.Build.VERSION;
import com.lantern.browser.WkBrowserWebView;
import com.lantern.browser.bp;
import com.lantern.core.c;
import com.lantern.core.k;
import com.lantern.core.o;
import com.lantern.core.p;
import com.lantern.webox.a.j;
import java.util.HashMap;
import java.util.Map;

public final class n
  implements j
{
  public final Object a(WkBrowserWebView paramWkBrowserWebView)
  {
    HashMap localHashMap2 = new HashMap();
    HashMap localHashMap1 = c.getServer().s();
    localHashMap2.put("verCode", Integer.valueOf(k.b(paramWkBrowserWebView.getContext())));
    localHashMap2.put("verName", k.a(paramWkBrowserWebView.getContext()));
    localHashMap2.put("lang", k.c());
    localHashMap2.put("origChanId", p.d(""));
    localHashMap2.put("chanId", k.l(paramWkBrowserWebView.getContext()));
    localHashMap2.put("appId", c.getServer().k());
    localHashMap2.put("imei", k.c(paramWkBrowserWebView.getContext()));
    localHashMap2.put("ii", k.c(paramWkBrowserWebView.getContext()));
    localHashMap2.put("mac", k.e(paramWkBrowserWebView.getContext()));
    localHashMap2.put("ts", String.valueOf(System.currentTimeMillis()));
    localHashMap2.put("mapSP", localHashMap1.get("mapSP"));
    localHashMap2.put("netModel", k.n(paramWkBrowserWebView.getContext()));
    localHashMap2.put("ssid", bp.a(paramWkBrowserWebView.getContext()));
    localHashMap2.put("capSsid", bp.a(paramWkBrowserWebView.getContext()));
    localHashMap2.put("bssid", bp.b(paramWkBrowserWebView.getContext()));
    localHashMap2.put("capBssid", bp.b(paramWkBrowserWebView.getContext()));
    localHashMap2.put("osver", String.valueOf(Build.VERSION.SDK_INT));
    localHashMap2.put("osvername", Build.VERSION.RELEASE);
    localHashMap2.put("netmode", k.n(paramWkBrowserWebView.getContext()));
    localHashMap2.put("simop", bp.e(paramWkBrowserWebView.getContext()));
    localHashMap2.put("manufacturer", Build.MANUFACTURER);
    localHashMap2.put("model", Build.MODEL);
    localHashMap2.put("device", Build.DEVICE);
    localHashMap2.put("brand", Build.BRAND);
    localHashMap2.put("product", Build.PRODUCT);
    localHashMap2.put("androidid", k.g(paramWkBrowserWebView.getContext()));
    return localHashMap2;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/a/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */