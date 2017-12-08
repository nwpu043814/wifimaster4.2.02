package com.lantern.browser;

import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class d
  extends WebChromeClient
{
  private final String a = "InjectedChromeClient";
  private e b;
  private boolean c;
  
  public d(String paramString, Class paramClass)
  {
    this.b = new e(paramString, paramClass);
  }
  
  public final void a()
  {
    this.c = false;
  }
  
  public final void a(WebView paramWebView)
  {
    if ((this.b != null) && (!this.c))
    {
      paramWebView.loadUrl(this.b.a());
      if (!TextUtils.isEmpty(bp.a())) {
        paramWebView.loadUrl("javascript:" + bp.a());
      }
      this.c = true;
    }
  }
  
  public boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    if (this.b != null) {
      paramJsPromptResult.confirm(this.b.a(paramWebView, paramString2));
    }
    for (boolean bool = true;; bool = super.onJsPrompt(paramWebView, paramString1, paramString2, paramString3, paramJsPromptResult)) {
      return bool;
    }
  }
  
  public void onProgressChanged(WebView paramWebView, int paramInt)
  {
    if (paramInt <= 25) {
      this.c = false;
    }
    for (;;)
    {
      super.onProgressChanged(paramWebView, paramInt);
      return;
      a(paramWebView);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */