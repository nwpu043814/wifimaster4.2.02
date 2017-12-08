package com.lantern.feed.ui;

import android.os.CountDownTimer;
import android.os.Message;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebView.WebViewTransport;
import android.widget.TextView;
import com.bluefay.b.h;
import com.lantern.feed.b.m;

final class bp
  extends WebChromeClient
{
  bp(bm parambm) {}
  
  public final void onCloseWindow(WebView paramWebView)
  {
    if (bm.c(this.a) != null) {
      bm.c(this.a).cancel();
    }
    this.a.dismiss();
  }
  
  public final boolean onCreateWindow(WebView paramWebView, boolean paramBoolean1, boolean paramBoolean2, Message paramMessage)
  {
    paramWebView = new WebView(paramWebView.getContext());
    paramWebView.setWebViewClient(new WkFeedPopDialog.4.1(this));
    ((WebView.WebViewTransport)paramMessage.obj).setWebView(paramWebView);
    paramMessage.sendToTarget();
    return true;
  }
  
  public final void onProgressChanged(WebView paramWebView, int paramInt)
  {
    super.onProgressChanged(paramWebView, paramInt);
    if ((paramInt == 100) && (bm.b(this.a).i() > 0))
    {
      h.a("onProgressChanged newProgress 100", new Object[0]);
      if ((bm.a(this.a) != null) && (bm.a(this.a).getVisibility() != 0)) {
        bm.a(this.a).setVisibility(0);
      }
      if (bm.c(this.a) != null) {
        bm.c(this.a).start();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */