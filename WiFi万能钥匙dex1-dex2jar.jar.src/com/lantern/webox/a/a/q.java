package com.lantern.webox.a.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.format.Formatter;
import com.bluefay.a.e;
import com.lantern.analytics.a;
import com.lantern.browser.WkBrowserWebView;
import com.lantern.webox.domain.WebDownRequest;
import java.util.HashMap;
import org.json.JSONObject;

final class q
  implements DialogInterface.OnClickListener
{
  q(o paramo, WkBrowserWebView paramWkBrowserWebView, WebDownRequest paramWebDownRequest) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    o.a(this.c, this.a, this.b);
    paramDialogInterface = new HashMap();
    paramDialogInterface.put("url", this.b.getUrl());
    if (this.b.getContentLength() > 0L) {
      paramDialogInterface.put("size", Formatter.formatShortFileSize(this.a.getContext(), this.b.getContentLength()));
    }
    if (e.b(this.a.getContext())) {
      paramDialogInterface.put("net", "3g");
    }
    for (;;)
    {
      a.e().onEvent("broholddl", new JSONObject(paramDialogInterface).toString());
      return;
      paramDialogInterface.put("net", "wifi");
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/a/a/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */