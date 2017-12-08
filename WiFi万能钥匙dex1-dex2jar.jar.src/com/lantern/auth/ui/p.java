package com.lantern.auth.ui;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

final class p
  extends WebChromeClient
{
  p(WebViewFragment paramWebViewFragment) {}
  
  public final void onReceivedTitle(WebView paramWebView, String paramString)
  {
    super.onReceivedTitle(paramWebView, paramString);
    WebViewFragment.a(this.a, paramString);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/ui/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */