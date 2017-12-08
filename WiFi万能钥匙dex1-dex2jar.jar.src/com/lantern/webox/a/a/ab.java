package com.lantern.webox.a.a;

import android.os.Handler;
import android.os.Looper;
import com.lantern.analytics.a;
import com.lantern.browser.WkBrowserWebView;
import com.lantern.browser.bp;
import com.lantern.webox.a.r;
import com.lantern.webox.a.r.a;
import com.snda.wifilocating.wxapi.WXEntryActivity;
import com.snda.wifilocating.wxapi.WkWeiXinUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ab
  implements r
{
  public final void a(WkBrowserWebView paramWkBrowserWebView, Map<String, Object> paramMap, r.a parama)
  {
    if (!WkWeiXinUtil.isWXAppInstalledAndSupported()) {
      new Handler(Looper.getMainLooper()).post(new ac(this, paramWkBrowserWebView));
    }
    for (;;)
    {
      return;
      String str = bp.d((String)paramMap.get("url"));
      int i = Integer.valueOf((String)paramMap.get("type")).intValue();
      paramWkBrowserWebView = (String)paramMap.get("title");
      WXEntryActivity.setListener(new ad(this, parama, i));
      WkWeiXinUtil.shareToWeiXin(i, str, paramWkBrowserWebView, (String)paramMap.get("content"), (String)paramMap.get("image"));
      paramMap = new HashMap();
      paramMap.put("src", "web");
      paramMap.put("title", paramWkBrowserWebView);
      paramMap.put("url", str);
      paramWkBrowserWebView = new JSONObject(paramMap).toString();
      switch (i)
      {
      default: 
        break;
      case 0: 
        a.e().onEvent("cht", paramWkBrowserWebView);
        break;
      case 1: 
        a.e().onEvent("mmt", paramWkBrowserWebView);
        break;
      case 2: 
        a.e().onEvent("favo", paramWkBrowserWebView);
      }
    }
  }
  
  public final boolean a()
  {
    return WkWeiXinUtil.isWXAppInstalledAndSupported();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/a/a/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */