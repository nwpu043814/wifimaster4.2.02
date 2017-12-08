package com.lantern.webox.a.a;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.telephony.SmsManager;
import com.lantern.browser.WkBrowserWebView;
import com.lantern.webox.a.p;
import com.lantern.webox.a.p.a;
import java.util.Iterator;
import java.util.List;

public final class z
  implements p
{
  public final void a(WkBrowserWebView paramWkBrowserWebView, String paramString1, String paramString2)
  {
    paramString1 = new Intent("android.intent.action.VIEW", Uri.parse("smsto:" + paramString1));
    paramString1.putExtra("sms_body", paramString2);
    paramWkBrowserWebView.getContext().startActivity(paramString1);
  }
  
  public final void a(WkBrowserWebView paramWkBrowserWebView, String paramString1, String paramString2, p.a parama)
  {
    SmsManager localSmsManager = SmsManager.getDefault();
    paramWkBrowserWebView = PendingIntent.getBroadcast(paramWkBrowserWebView.getContext(), 0, new Intent(), 0);
    if (paramString2.length() >= 70)
    {
      paramString2 = localSmsManager.divideMessage(paramString2).iterator();
      while (paramString2.hasNext()) {
        localSmsManager.sendTextMessage(paramString1, null, (String)paramString2.next(), paramWkBrowserWebView, null);
      }
    }
    localSmsManager.sendTextMessage(paramString1, null, paramString2, paramWkBrowserWebView, null);
    parama.a(Boolean.valueOf(true));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/a/a/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */