package com.lantern.settings.ui;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;

final class h
  extends WebChromeClient
{
  h(DiagnoseActivity paramDiagnoseActivity) {}
  
  public final void onProgressChanged(WebView paramWebView, int paramInt)
  {
    DiagnoseActivity.b(this.a).setProgress(paramInt);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */