package com.lantern.browser.search.ui;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.lantern.browser.bp;

class WkSearchFragment$3
  extends WebViewClient
{
  WkSearchFragment$3(WkSearchFragment paramWkSearchFragment) {}
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    bp.c(paramWebView.getContext(), paramString);
    return true;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/search/ui/WkSearchFragment$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */