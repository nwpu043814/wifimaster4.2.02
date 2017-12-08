package com.lantern.browser;

import android.content.Context;
import com.bluefay.b.h;
import com.lantern.webox.browser.BrowserJsInterface;

public final class cb
{
  public static WkBrowserWebView a(Context paramContext)
  {
    WkBrowserWebView localWkBrowserWebView = new WkBrowserWebView(paramContext);
    try
    {
      localWkBrowserWebView.removeJavascriptInterface("searchBoxJavaBridge_");
      localWkBrowserWebView.removeJavascriptInterface("accessibility");
      localWkBrowserWebView.removeJavascriptInterface("accessibilityTraversal");
      localWkBrowserWebView.a("jsi:wifikey", new BrowserJsInterface(localWkBrowserWebView));
      return localWkBrowserWebView;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        h.a(paramContext);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/cb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */