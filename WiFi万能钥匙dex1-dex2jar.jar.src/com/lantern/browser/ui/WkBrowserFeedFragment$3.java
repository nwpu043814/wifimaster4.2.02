package com.lantern.browser.ui;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.lantern.browser.bp;
import com.lantern.browser.n;

class WkBrowserFeedFragment$3
  extends WebViewClient
{
  WkBrowserFeedFragment$3(WkBrowserFeedFragment paramWkBrowserFeedFragment) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (this.this$0.isVisible())
    {
      paramString = paramString.replaceAll(" ", "%20");
      if (!paramString.endsWith(".apk")) {
        break label47;
      }
      paramWebView = n.b();
      WkBrowserFeedFragment.a(this.this$0);
      paramWebView.a(paramString);
    }
    for (;;)
    {
      return true;
      label47:
      bp.c(paramWebView.getContext(), paramString);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/ui/WkBrowserFeedFragment$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */