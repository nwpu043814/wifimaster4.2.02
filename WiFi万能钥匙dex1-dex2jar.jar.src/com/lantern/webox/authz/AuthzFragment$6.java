package com.lantern.webox.authz;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.lantern.browser.WkBrowserWebView;

class AuthzFragment$6
  extends WebViewClient
{
  AuthzFragment$6(AuthzFragment paramAuthzFragment) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    AuthzFragment.d(this.this$0).loadUrl(paramString);
    return true;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/authz/AuthzFragment$6.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */