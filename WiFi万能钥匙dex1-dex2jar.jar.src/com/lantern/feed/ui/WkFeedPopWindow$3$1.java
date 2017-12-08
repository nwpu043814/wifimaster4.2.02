package com.lantern.feed.ui;

import android.os.CountDownTimer;
import android.webkit.WebView;
import android.webkit.WebViewClient;

class WkFeedPopWindow$3$1
  extends WebViewClient
{
  WkFeedPopWindow$3$1(bt parambt) {}
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (bs.a(this.this$1.a) != null) {
      bs.a(this.this$1.a).cancel();
    }
    bs.b(this.this$1.a);
    bs.a(this.this$1.a, paramString);
    return true;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/WkFeedPopWindow$3$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */