package com.lantern.webox.handler;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import bluefay.app.k.a;
import com.lantern.browser.R.string;
import com.lantern.browser.WkBrowserWebView;
import com.lantern.browser.bp;
import com.lantern.browser.c.a;
import com.lantern.browser.cc;
import com.lantern.browser.m;
import com.lantern.core.config.SSLErrorConfig;
import com.lantern.core.config.d;
import com.lantern.webbox.handler.WebViewClientV23;
import com.lantern.webox.b.e;
import com.lantern.webox.event.WebEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class WebViewClientHandler
  extends WebViewClientV23
{
  private e logger = new e(getClass());
  private boolean mShowDialog = false;
  private WkBrowserWebView mWebView;
  
  public WebViewClientHandler(WkBrowserWebView paramWkBrowserWebView)
  {
    this.mWebView = paramWkBrowserWebView;
    paramWkBrowserWebView.setWebViewClient(this);
  }
  
  private void sslErrorAlert(SslErrorHandler paramSslErrorHandler)
  {
    if (this.mShowDialog) {}
    for (;;)
    {
      return;
      Object localObject = this.mWebView.b();
      if (localObject != null)
      {
        localObject = ((cc)localObject).getActivity();
        if (localObject != null)
        {
          localObject = new k.a((Context)localObject);
          ((k.a)localObject).a(R.string.browser_ssl_title);
          ((k.a)localObject).b(R.string.browser_ssl_msg);
          ((k.a)localObject).a(R.string.browser_ssl_continue, new h(this, paramSslErrorHandler));
          ((k.a)localObject).b(R.string.browser_btn_cancel, new i(this, paramSslErrorHandler));
          ((k.a)localObject).c();
          ((k.a)localObject).d();
          this.mShowDialog = true;
        }
      }
    }
  }
  
  public void doUpdateVisitedHistory(WebView paramWebView, String paramString, boolean paramBoolean)
  {
    super.doUpdateVisitedHistory(paramWebView, paramString, paramBoolean);
    paramWebView = (WkBrowserWebView)paramWebView;
    paramWebView.a(new WebEvent(paramWebView, 11));
  }
  
  public void onLoadResource(WebView paramWebView, String paramString)
  {
    super.onLoadResource(paramWebView, paramString);
    paramWebView = (WkBrowserWebView)paramWebView;
    paramWebView.a(new WebEvent(paramWebView, 0, paramString));
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    paramWebView = (WkBrowserWebView)paramWebView;
    if (!TextUtils.isEmpty(paramString)) {
      paramWebView.d(paramString);
    }
    paramWebView.a(new WebEvent(paramWebView, 5, paramString));
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    paramBitmap = (WkBrowserWebView)paramWebView;
    a.a(paramString, paramBitmap.l());
    paramBitmap.k();
    WebSettings localWebSettings = paramBitmap.getSettings();
    if (!localWebSettings.getJavaScriptEnabled()) {}
    try
    {
      localWebSettings.setJavaScriptEnabled(true);
      if (!TextUtils.isEmpty(paramString))
      {
        paramBitmap.d(paramString);
        m.a().a(bp.a(paramWebView.getContext(), paramString));
        m.a().b();
      }
      paramBitmap.a(new WebEvent(paramBitmap, 4, paramString));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.bluefay.b.h.a(localException);
      }
    }
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    HashMap localHashMap = new HashMap();
    localHashMap.put("failingUrl", paramString2);
    localHashMap.put("errorCode", String.valueOf(paramInt));
    localHashMap.put("description", paramString1);
    paramWebView = (WkBrowserWebView)paramWebView;
    paramWebView.a(new WebEvent(paramWebView, 9, localHashMap));
  }
  
  public void onReceivedHttpCodeError(WebView paramWebView, String paramString, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("failingUrl", paramString);
    localHashMap.put("httpCode", String.valueOf(paramInt));
    paramWebView = (WkBrowserWebView)paramWebView;
    paramWebView.a(new WebEvent(paramWebView, 12, localHashMap));
    Log.e("AAAAAAAAAAAA", "2222222 : " + paramInt);
  }
  
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    paramSslError = (SSLErrorConfig)d.a(paramWebView.getContext()).a(SSLErrorConfig.class);
    if ((paramSslError == null) || (!paramSslError.d()))
    {
      paramSslErrorHandler.proceed();
      return;
    }
    paramSslError = paramSslError.e();
    if ((paramSslError != null) && (!paramSslError.isEmpty()))
    {
      paramWebView = paramWebView.getUrl();
      paramSslError = paramSslError.iterator();
      do
      {
        if (!paramSslError.hasNext()) {
          break;
        }
      } while (paramWebView.indexOf((String)paramSslError.next()) == -1);
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        paramSslErrorHandler.proceed();
        break;
      }
      sslErrorAlert(paramSslErrorHandler);
      break;
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    this.mWebView.c(null);
    if (this.mWebView.b() != null) {}
    for (boolean bool = this.mWebView.b().a(paramWebView, paramString);; bool = false) {
      return bool;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/handler/WebViewClientHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */