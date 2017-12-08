package com.lantern.browser;

import android.webkit.WebView;
import android.webkit.WebViewClient;

class WkBrowserTabWindow$1
  extends WebViewClient
{
  WkBrowserTabWindow$1(bh parambh) {}
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    bp.a(paramWebView.getContext(), paramString, bh.a(this.this$0).i().a());
    return true;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/WkBrowserTabWindow$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */