package com.lantern.auth.widget;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;

final class h
  extends WebChromeClient
{
  h(WkRegsView paramWkRegsView) {}
  
  public final void onProgressChanged(WebView paramWebView, int paramInt)
  {
    WkRegsView.a(this.a).setProgress(paramInt);
    if (paramInt >= 100)
    {
      if (WkRegsView.b(this.a) == null) {
        WkRegsView.a(this.a, new i(this));
      }
      WkRegsView.a(this.a).postDelayed(WkRegsView.b(this.a), 500L);
    }
    for (;;)
    {
      return;
      WkRegsView.a(this.a).removeCallbacks(WkRegsView.b(this.a));
      WkRegsView.a(this.a).setVisibility(0);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/widget/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */