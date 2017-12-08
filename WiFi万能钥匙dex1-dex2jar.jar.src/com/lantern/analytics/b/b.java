package com.lantern.analytics.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import com.bluefay.b.h;
import com.lantern.core.g.u;
import com.lantern.core.k;
import com.lantern.core.p;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  private static b a;
  private Context b;
  private IntentFilter c;
  private BroadcastReceiver d = new c(this);
  private Handler e = new d(this);
  
  private b(Context paramContext)
  {
    this.b = paramContext;
    this.c = new IntentFilter();
    this.c.addAction("android.net.wifi.STATE_CHANGE");
    this.b.registerReceiver(this.d, this.c);
  }
  
  public static b a(Context paramContext)
  {
    if (a == null) {
      a = new b(paramContext.getApplicationContext());
    }
    return a;
  }
  
  private void b()
  {
    com.lantern.analytics.a.e().onEvent("dauwifi");
    c();
  }
  
  private void c()
  {
    try
    {
      JSONObject localJSONObject = new org/json/JSONObject;
      localJSONObject.<init>();
      localJSONObject.put("cts", String.valueOf(System.currentTimeMillis()));
      localJSONObject.put("aid", k.g(this.b));
      com.lantern.analytics.a.e().a("005021", localJSONObject, false);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        h.a(localJSONException);
      }
    }
  }
  
  public final void a()
  {
    if (com.bluefay.a.a.c(this.b))
    {
      if (!com.bluefay.a.a.b(this.b)) {
        break label73;
      }
      long l = p.a(this.b, "sdk_common", "last_report_time", 0L);
      if (System.currentTimeMillis() - l > 1800000L)
      {
        p.b(this.b, "sdk_common", "last_report_time", System.currentTimeMillis());
        com.lantern.analytics.a.e().onEvent("dau3g");
        c();
      }
    }
    for (;;)
    {
      return;
      label73:
      b();
    }
  }
  
  public final void a(String paramString)
  {
    String str = paramString;
    if (!u.c(paramString)) {
      if ((paramString == null) || (paramString.length() <= 0)) {}
    }
    for (;;)
    {
      return;
      paramString = ((WifiManager)this.b.getSystemService("wifi")).getConnectionInfo();
      h.a("info:" + paramString);
      if ((paramString != null) && (paramString.getSSID() != null))
      {
        str = u.a(paramString.getSSID());
        if ((str != null) && (str.length() != 0))
        {
          paramString = this.e.obtainMessage(30000, 1, 0, str);
          if (this.e.hasMessages(30000)) {
            this.e.removeMessages(30000);
          }
          this.e.sendMessageDelayed(paramString, 1000L);
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/analytics/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */