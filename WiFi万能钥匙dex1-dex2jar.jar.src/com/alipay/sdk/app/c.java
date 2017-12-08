package com.alipay.sdk.app;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Handler;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alipay.sdk.j.k;

public final class c
  extends WebViewClient
{
  Activity a;
  Handler b;
  boolean c;
  private boolean d;
  private com.alipay.sdk.k.a e;
  private Runnable f = new h(this);
  
  public c(Activity paramActivity)
  {
    this.a = paramActivity;
    this.b = new Handler(this.a.getMainLooper());
  }
  
  private void a()
  {
    if (this.e != null) {
      this.e.b();
    }
    this.e = null;
  }
  
  public final void onPageFinished(WebView paramWebView, String paramString)
  {
    a();
    this.b.removeCallbacks(this.f);
  }
  
  public final void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    if (this.e == null)
    {
      this.e = new com.alipay.sdk.k.a(this.a, "正在加载");
      this.e.b = true;
    }
    this.e.a();
    this.b.postDelayed(this.f, 30000L);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public final void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    this.c = true;
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
  }
  
  public final void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    com.alipay.sdk.app.a.a.a("net", "SSLError", "证书错误");
    if (this.d)
    {
      paramSslErrorHandler.proceed();
      this.d = false;
    }
    for (;;)
    {
      return;
      this.a.runOnUiThread(new e(this, paramSslErrorHandler));
    }
  }
  
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    return k.a(paramWebView, paramString, this.a);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/sdk/app/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */