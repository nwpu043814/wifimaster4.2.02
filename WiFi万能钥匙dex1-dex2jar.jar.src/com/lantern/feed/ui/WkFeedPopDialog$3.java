package com.lantern.feed.ui;

import android.os.CountDownTimer;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import com.bluefay.b.h;
import com.lantern.feed.b.m;

class WkFeedPopDialog$3
  extends WebViewClient
{
  WkFeedPopDialog$3(bm parambm) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    h.a("onPageFinished " + paramString, new Object[0]);
    if (bm.b(this.this$0).i() > 0)
    {
      if ((bm.a(this.this$0) != null) && (bm.a(this.this$0).getVisibility() != 0)) {
        bm.a(this.this$0).setVisibility(0);
      }
      if (bm.c(this.this$0) != null) {
        bm.c(this.this$0).start();
      }
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    h.a("shouldOverrideUrlLoading " + paramString, new Object[0]);
    if (bm.c(this.this$0) != null) {
      bm.c(this.this$0).cancel();
    }
    this.this$0.dismiss();
    bm.a(this.this$0, paramString);
    return true;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/WkFeedPopDialog$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */