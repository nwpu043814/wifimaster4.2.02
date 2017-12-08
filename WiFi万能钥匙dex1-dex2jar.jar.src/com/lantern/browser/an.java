package com.lantern.browser;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import com.bluefay.b.h;

final class an
  implements Runnable
{
  an(String paramString, WebView paramWebView) {}
  
  public final void run()
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setData(Uri.parse("market://details?id=" + this.a));
    try
    {
      this.b.getContext().startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      for (;;)
      {
        h.a("no market installed", new Object[0]);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */