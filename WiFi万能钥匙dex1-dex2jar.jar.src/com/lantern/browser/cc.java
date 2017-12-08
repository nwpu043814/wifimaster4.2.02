package com.lantern.browser;

import android.app.Activity;
import android.net.Uri;
import android.os.Message;
import android.webkit.ValueCallback;
import android.webkit.WebView;

public abstract interface cc
{
  public abstract void a(int paramInt1, int paramInt2);
  
  public abstract void a(int paramInt, String paramString);
  
  public abstract void a(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2);
  
  public abstract boolean a(WebView paramWebView, Message paramMessage);
  
  public abstract boolean a(WebView paramWebView, String paramString);
  
  public abstract void f();
  
  public abstract void g();
  
  public abstract Activity getActivity();
  
  public abstract void h();
  
  public abstract void i();
  
  public abstract void j();
  
  public abstract void k();
  
  public abstract void l();
  
  public abstract void m();
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/cc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */