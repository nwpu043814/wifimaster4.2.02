package com.lantern.feed.ui;

import android.os.CountDownTimer;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import com.bluefay.b.h;

class WkFeedPopWindow$2
  extends WebViewClient
{
  WkFeedPopWindow$2(bs parambs) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    h.a("onPageFinished", new Object[0]);
    if ((bs.c(this.this$0) != null) && (bs.c(this.this$0).getVisibility() != 0))
    {
      bs.c(this.this$0).setVisibility(0);
      bs.a(this.this$0).start();
    }
    this.this$0.setBackgroundColor(-1509949440);
    bs.d(this.this$0).setVisibility(0);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (bs.a(this.this$0) != null) {
      bs.a(this.this$0).cancel();
    }
    bs.b(this.this$0);
    bs.a(this.this$0, paramString);
    return true;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/WkFeedPopWindow$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */