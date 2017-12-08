package com.lantern.webox.a.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.lantern.browser.WkBrowserWebView;

public final class c
  implements com.lantern.webox.a.c
{
  private static ApplicationInfo b(WkBrowserWebView paramWkBrowserWebView, String paramString)
  {
    try
    {
      paramWkBrowserWebView = paramWkBrowserWebView.getContext().getPackageManager().getApplicationInfo(paramString, 8192);
      return paramWkBrowserWebView;
    }
    catch (Exception paramWkBrowserWebView)
    {
      for (;;)
      {
        paramWkBrowserWebView = null;
      }
    }
  }
  
  public final boolean a(WkBrowserWebView paramWkBrowserWebView, String paramString)
  {
    if (b(paramWkBrowserWebView, paramString) != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/a/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */