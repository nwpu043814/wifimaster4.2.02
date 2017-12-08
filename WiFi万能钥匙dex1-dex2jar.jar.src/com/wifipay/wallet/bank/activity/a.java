package com.wifipay.wallet.bank.activity;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

class a
  extends WebViewClient
{
  a(BankQuotaActivity paramBankQuotaActivity) {}
  
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    paramSslErrorHandler.proceed();
    super.onReceivedSslError(paramWebView, paramSslErrorHandler, paramSslError);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/bank/activity/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */