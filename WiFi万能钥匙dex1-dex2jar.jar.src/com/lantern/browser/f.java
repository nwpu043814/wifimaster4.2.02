package com.lantern.browser;

import android.webkit.WebView;
import java.lang.ref.WeakReference;

public class f
{
  private int a;
  private boolean b = true;
  private WeakReference<WebView> c;
  private String d;
  
  public f(WebView paramWebView, String paramString, int paramInt)
  {
    this.c = new WeakReference(paramWebView);
    this.d = paramString;
    this.a = paramInt;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */