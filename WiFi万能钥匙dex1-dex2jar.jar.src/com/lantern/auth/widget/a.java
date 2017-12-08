package com.lantern.auth.widget;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;

final class a
  extends WebChromeClient
{
  a(WkAuthView paramWkAuthView) {}
  
  public final void onProgressChanged(WebView paramWebView, int paramInt)
  {
    WkAuthView.a(this.a).setProgress(paramInt);
    if (paramInt >= 100)
    {
      if (WkAuthView.b(this.a) == null) {
        WkAuthView.a(this.a, new b(this));
      }
      WkAuthView.a(this.a).postDelayed(WkAuthView.b(this.a), 500L);
    }
    for (;;)
    {
      return;
      WkAuthView.a(this.a).removeCallbacks(WkAuthView.b(this.a));
      WkAuthView.a(this.a).setVisibility(0);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/widget/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */