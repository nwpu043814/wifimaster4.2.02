package com.wifipay.sdk.app;

import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebView;

public class d
  extends WebChromeClient
{
  public void onConsoleMessage(String paramString1, int paramInt, String paramString2)
  {
    super.onConsoleMessage(paramString1, paramInt, paramString2);
  }
  
  public boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    return super.onConsoleMessage(paramConsoleMessage);
  }
  
  public void onHideCustomView()
  {
    super.onHideCustomView();
  }
  
  public boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return super.onJsAlert(paramWebView, paramString1, paramString2, paramJsResult);
  }
  
  public boolean onJsConfirm(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return super.onJsConfirm(paramWebView, paramString1, paramString2, paramJsResult);
  }
  
  public boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    return super.onJsPrompt(paramWebView, paramString1, paramString2, paramString3, paramJsPromptResult);
  }
  
  public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    super.onShowCustomView(paramView, paramCustomViewCallback);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/sdk/app/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */