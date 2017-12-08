package com.lantern.webox.b;

import android.webkit.WebView;

final class d
  implements Runnable
{
  d(c paramc, Object paramObject1, WebView paramWebView, Object paramObject2) {}
  
  public final void run()
  {
    String str = "javascript:" + this.a + "(" + c.a(this.d, this.c) + ");";
    this.b.loadUrl(str);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/b/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */