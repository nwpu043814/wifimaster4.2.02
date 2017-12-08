package com.wifipay.wallet.home.ui;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

class a
  extends WebViewClient
{
  a(AccountWebActivity paramAccountWebActivity) {}
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    if ((paramString.startsWith("https://rnauth.shengpay.com/mobile")) || (paramString.startsWith("https://10.241.70.24"))) {
      AccountWebActivity.a(this.a, true);
    }
    for (;;)
    {
      return;
      AccountWebActivity.a(this.a, false);
    }
  }
  
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    paramSslErrorHandler.proceed();
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (AccountWebActivity.a(this.a)) {
      paramWebView.loadUrl(paramString);
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/ui/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */