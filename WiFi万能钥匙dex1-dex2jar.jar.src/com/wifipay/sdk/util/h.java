package com.wifipay.sdk.util;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebSettings.TextSize;
import android.webkit.WebView;
import com.wifipay.sdk.a.a.a;
import java.lang.reflect.Method;
import java.util.HashMap;

public class h
{
  public static WebView a(Activity paramActivity, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      CookieSyncManager.createInstance(paramActivity.getApplicationContext()).sync();
      CookieManager.getInstance().setCookie(paramString1, paramString2);
      CookieSyncManager.getInstance().sync();
    }
    WebView localWebView = new WebView(paramActivity);
    localWebView.setBackgroundColor(0);
    localWebView.setVisibility(0);
    WebSettings localWebSettings = localWebView.getSettings();
    localWebSettings.setUserAgentString(localWebSettings.getUserAgentString() + a(paramActivity));
    localWebSettings.setJavaScriptEnabled(true);
    localWebSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
    localWebSettings.setSupportMultipleWindows(true);
    localWebSettings.setSavePassword(false);
    localWebSettings.setJavaScriptCanOpenWindowsAutomatically(true);
    localWebSettings.setMinimumFontSize(localWebSettings.getMinimumFontSize() + 8);
    localWebSettings.setAllowFileAccess(false);
    localWebSettings.setTextSize(WebSettings.TextSize.NORMAL);
    localWebSettings.setAllowFileAccess(false);
    localWebView.setInitialScale(0);
    localWebView.setVerticalScrollbarOverlay(false);
    localWebView.setVerticalScrollBarEnabled(false);
    try
    {
      localWebView.removeJavascriptInterface("searchBoxJavaBridge_");
      localWebView.removeJavascriptInterface("accessibility");
      localWebView.removeJavascriptInterface("accessibilityTraversal");
      localWebView.clearCache(true);
      localWebView.setOnLongClickListener(new i());
      if (Build.VERSION.SDK_INT >= 19) {
        localWebSettings.setCacheMode(1);
      }
      c(localWebView, paramString1, paramString2);
      return localWebView;
    }
    catch (Throwable paramActivity)
    {
      for (;;)
      {
        try
        {
          paramActivity = WebView.class.getMethod("removeJavascriptInterface", new Class[0]);
          if (paramActivity != null)
          {
            paramActivity.invoke(localWebView, new Object[] { "searchBoxJavaBridge_" });
            paramActivity.invoke(localWebView, new Object[] { "accessibility" });
            paramActivity.invoke(localWebView, new Object[] { "accessibilityTraversal" });
          }
        }
        catch (Throwable paramActivity) {}
      }
    }
  }
  
  private static String a(Context paramContext)
  {
    return "(WIFIPAY sdk)";
  }
  
  public static void a(WebView paramWebView, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      CookieSyncManager.createInstance(paramWebView.getContext().getApplicationContext()).sync();
      CookieManager.getInstance().setCookie(paramString1, paramString2);
      CookieSyncManager.getInstance().sync();
    }
    c(paramWebView, paramString1, paramString2);
  }
  
  public static boolean a(String paramString)
  {
    return true;
  }
  
  private static String b(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      String[] arrayOfString = paramString.split("=");
      str = paramString;
      if (arrayOfString.length > 1) {
        str = arrayOfString[1];
      }
    }
    return str;
  }
  
  public static boolean b(WebView paramWebView, String paramString1, String paramString2)
  {
    boolean bool = true;
    if (TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      return bool;
      if (a(paramString1)) {
        c(paramWebView, paramString1, paramString2);
      } else {
        bool = false;
      }
    }
  }
  
  private static void c(WebView paramWebView, String paramString1, String paramString2)
  {
    String str1 = String.valueOf(System.currentTimeMillis());
    String str2 = f.b(str1 + a.a.d);
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("app_access_time", str1);
    localHashMap.put("app_access_sign", str2);
    localHashMap.put("jid", b(paramString2));
    paramWebView.loadUrl(paramString1, localHashMap);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/sdk/util/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */