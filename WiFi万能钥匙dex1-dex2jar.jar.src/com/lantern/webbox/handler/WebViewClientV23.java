package com.lantern.webbox.handler;

import android.net.Uri;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewClientV23
  extends WebViewClient
{
  public void onReceivedHttpCodeError(WebView paramWebView, String paramString, int paramInt)
  {
    Log.e("AAAAAAAAAAAA", "11111 : " + paramInt);
  }
  
  public void onReceivedHttpError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
  {
    super.onReceivedHttpError(paramWebView, paramWebResourceRequest, paramWebResourceResponse);
    Log.e("AAAAAAAAAAAA", "onReceivedHttpError");
    if (paramWebResourceRequest.isForMainFrame())
    {
      onReceivedHttpCodeError(paramWebView, paramWebResourceRequest.getUrl().toString(), paramWebResourceResponse.getStatusCode());
      Log.e("AAAAAAAAAAAA", "Http Code : " + paramWebResourceResponse.getStatusCode());
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webbox/handler/WebViewClientV23.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */