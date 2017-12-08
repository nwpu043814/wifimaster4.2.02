package com.lantern.webox.a.a;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.lantern.browser.WkBrowserWebView;
import com.lantern.core.p;
import com.lantern.webox.a.o;
import com.lantern.webox.a.o.a;

public final class y
  implements o
{
  public final void a(WkBrowserWebView paramWkBrowserWebView, o.a parama)
  {
    Context localContext = paramWkBrowserWebView.getContext();
    String str = ((TelephonyManager)localContext.getSystemService("phone")).getLine1Number();
    paramWkBrowserWebView = str;
    if (TextUtils.isEmpty(str)) {
      paramWkBrowserWebView = p.c(localContext);
    }
    parama.a(paramWkBrowserWebView);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/a/a/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */