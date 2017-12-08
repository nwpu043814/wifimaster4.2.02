package com.lantern.browser;

import android.content.Context;
import android.content.Intent;
import android.webkit.WebView;

final class as
  implements Runnable
{
  as(String paramString1, String paramString2, WebView paramWebView, String paramString3) {}
  
  public final void run()
  {
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.setType("text/plain");
    localIntent.putExtra("android.intent.extra.SUBJECT", this.a);
    localIntent.putExtra("android.intent.extra.TEXT", this.b);
    this.c.getContext().startActivity(Intent.createChooser(localIntent, this.d));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */