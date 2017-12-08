package com.lantern.feed.ui;

import android.os.CountDownTimer;
import android.os.Message;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebView.WebViewTransport;
import android.widget.TextView;
import com.bluefay.b.h;

final class bt
  extends WebChromeClient
{
  public final void onCloseWindow(WebView paramWebView)
  {
    if (bs.a(this.a) != null) {
      bs.a(this.a).cancel();
    }
    bs.b(this.a);
  }
  
  public final boolean onCreateWindow(WebView paramWebView, boolean paramBoolean1, boolean paramBoolean2, Message paramMessage)
  {
    paramWebView = new WebView(paramWebView.getContext());
    paramWebView.setWebViewClient(new WkFeedPopWindow.3.1(this));
    ((WebView.WebViewTransport)paramMessage.obj).setWebView(paramWebView);
    paramMessage.sendToTarget();
    return true;
  }
  
  public final void onProgressChanged(WebView paramWebView, int paramInt)
  {
    super.onProgressChanged(paramWebView, paramInt);
    if (paramInt == 100)
    {
      h.a("onProgressChanged newProgress 100", new Object[0]);
      if ((bs.c(this.a) != null) && (bs.c(this.a).getVisibility() != 0))
      {
        bs.c(this.a).setVisibility(0);
        bs.a(this.a).start();
      }
      this.a.setBackgroundColor(-1509949440);
      bs.d(this.a).setVisibility(0);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */