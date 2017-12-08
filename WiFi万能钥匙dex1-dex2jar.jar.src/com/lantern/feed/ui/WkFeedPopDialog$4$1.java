package com.lantern.feed.ui;

import android.os.CountDownTimer;
import android.webkit.WebView;
import android.webkit.WebViewClient;

class WkFeedPopDialog$4$1
  extends WebViewClient
{
  WkFeedPopDialog$4$1(bp parambp) {}
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (bm.c(this.this$1.a) != null) {
      bm.c(this.this$1.a).cancel();
    }
    this.this$1.a.dismiss();
    bm.a(this.this$1.a, paramString);
    return true;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/WkFeedPopDialog$4$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */