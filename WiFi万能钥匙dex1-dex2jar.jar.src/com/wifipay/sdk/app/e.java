package com.wifipay.sdk.app;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.wifipay.sdk.util.c;
import com.wifipay.sdk.util.h;

public class e
  extends WebViewClient
{
  private a a;
  private g b;
  private boolean c = false;
  private Runnable d = new f(this);
  
  e(a parama)
  {
    this.a = parama;
    this.b = new g(parama.a.getMainLooper());
  }
  
  private void b()
  {
    this.b.b(this.d);
    if (this.a != null) {
      this.a.b.a();
    }
  }
  
  public void a()
  {
    this.c = true;
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    b();
    if (this.c)
    {
      this.c = false;
      paramWebView.clearHistory();
    }
    paramWebView.setBackgroundColor(-1);
    super.onPageFinished(paramWebView, paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    this.b.a(this.d, 30000L);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    b();
    paramWebView.loadUrl("http://static.51y5.net/wifi/client/error.html");
  }
  
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    paramSslErrorHandler.proceed();
  }
  
  public WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
  {
    return super.shouldInterceptRequest(paramWebView, paramString);
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    boolean bool = true;
    c.a("kyo", "shouldOverrideUrlLoading = " + paramString);
    if (this.a.a(paramString)) {}
    for (;;)
    {
      return bool;
      if (!h.b(paramWebView, paramString, this.a.d)) {
        bool = false;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/sdk/app/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */