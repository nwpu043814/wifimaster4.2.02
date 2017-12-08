package com.lantern.webox.a.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.lantern.analytics.a;
import com.lantern.browser.WkBrowserWebView;
import com.lantern.webox.domain.AppStoreQuery;

final class f
  implements DialogInterface.OnClickListener
{
  f(d paramd, WkBrowserWebView paramWkBrowserWebView, AppStoreQuery paramAppStoreQuery) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    d.d(this.a, this.b);
    a.e().onEvent("dlmw1");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/a/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */