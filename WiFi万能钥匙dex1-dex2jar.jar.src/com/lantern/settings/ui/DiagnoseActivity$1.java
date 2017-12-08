package com.lantern.settings.ui;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

class DiagnoseActivity$1
  extends WebViewClient
{
  DiagnoseActivity$1(DiagnoseActivity paramDiagnoseActivity) {}
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    if (paramString.startsWith("http://wifi01.51y5.net/wifi/clientdebug.php?l="))
    {
      DiagnoseActivity.a(this.this$0).setVisibility(8);
      DiagnoseActivity.b(this.this$0).setVisibility(8);
      DiagnoseActivity.a(System.currentTimeMillis());
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/DiagnoseActivity$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */