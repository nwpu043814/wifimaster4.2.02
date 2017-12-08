package com.lantern.webox.a.a;

import android.widget.Toast;
import com.lantern.browser.R.string;
import com.lantern.browser.WkBrowserWebView;

final class p
  implements Runnable
{
  p(o paramo, String paramString, WkBrowserWebView paramWkBrowserWebView) {}
  
  public final void run()
  {
    if (this.a.equals("shared")) {
      Toast.makeText(this.b.getContext(), R.string.browser_download_sdcard_busy, 0).show();
    }
    for (;;)
    {
      return;
      Toast.makeText(this.b.getContext(), R.string.browser_download_no_sdcard, 0).show();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/a/a/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */