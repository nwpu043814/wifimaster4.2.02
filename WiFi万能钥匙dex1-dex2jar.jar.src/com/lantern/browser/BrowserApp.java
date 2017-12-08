package com.lantern.browser;

import android.content.Context;
import android.content.IntentFilter;
import bluefay.app.l;
import com.bluefay.b.h;
import com.lantern.core.config.d;

public class BrowserApp
  extends l
{
  public final void a()
  {
    super.a();
    d.a(this.a).b("errpage");
    d.a(this.a).b("wkbrowser");
    d.a(this.a).b("download_wl");
    d.a(this.a).b("comment");
    d.a(this.a).b("download_js");
    try
    {
      IntentFilter localIntentFilter = new android/content/IntentFilter;
      localIntentFilter.<init>("android.intent.action.DOWNLOAD_COMPLETE");
      Context localContext = this.a;
      i locali = new com/lantern/browser/i;
      locali.<init>();
      localContext.registerReceiver(locali, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.a(localException);
      }
    }
  }
  
  public final void b()
  {
    super.b();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/BrowserApp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */