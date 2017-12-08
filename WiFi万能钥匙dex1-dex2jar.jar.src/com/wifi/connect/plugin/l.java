package com.wifi.connect.plugin;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.lantern.core.model.WkAccessPoint;
import com.lantern.core.o;
import com.wifi.connect.a.e;
import com.wifi.connect.a.f;
import com.wifi.connect.a.g;
import com.wifi.connect.model.AccessPointAlias;
import com.wifi.connect.model.AccessPointKey;
import com.wifi.connect.model.PluginAp;
import com.wifi.connect.model.WebAuthAp;
import org.json.JSONException;
import org.json.JSONObject;

public final class l
{
  private Context a;
  private a b;
  private com.bluefay.b.a c = new m(this);
  
  public l(Context paramContext)
  {
    this.a = paramContext;
    this.b = new a(this.a);
    com.wifi.plugin.c.a(com.bluefay.d.a.isDebugable(), "WifiApp");
  }
  
  private void a(PluginAp paramPluginAp, String paramString)
  {
    com.bluefay.b.h.a("syncRunPluginApi:" + paramPluginAp + " method:" + paramString);
    Bundle localBundle = new Bundle();
    localBundle.putString("what", paramString);
    localBundle.putString("ssid", paramPluginAp.a);
    localBundle.putString("bssid", paramPluginAp.b);
    localBundle.putInt("security", paramPluginAp.c);
    localBundle.putInt("rssi", paramPluginAp.d);
    localBundle.putString("dhid", com.lantern.core.c.getServer().g());
    localBundle.putString("uhid", com.lantern.core.c.getServer().h());
    localBundle.putString("channel", com.lantern.core.c.getServer().b());
    if (paramPluginAp.n != null) {
      localBundle.putString("ext", paramPluginAp.n);
    }
    if (paramPluginAp.k != null)
    {
      paramString = paramPluginAp.k;
      if (!paramString.contains("Service")) {
        break label197;
      }
      com.wifi.plugin.c.b(this.a, paramPluginAp.m, paramString, localBundle);
    }
    for (;;)
    {
      return;
      paramString = paramPluginAp.j + ".ConnectService";
      break;
      label197:
      com.wifi.plugin.c.a(this.a, paramPluginAp.m, paramString, localBundle);
    }
  }
  
  public final void a()
  {
    PluginAp localPluginAp = new PluginAp();
    localPluginAp.j = "com.wifi.connect.plugin.magickey";
    a(localPluginAp, "deleteConfig");
  }
  
  public final void a(WkAccessPoint paramWkAccessPoint)
  {
    PluginAp localPluginAp = new PluginAp(paramWkAccessPoint, 100);
    localPluginAp.j = "com.wifi.connect.plugin.webauth";
    localPluginAp.k = "com.lantern.webox.authz.AuthzActivity";
    paramWkAccessPoint = com.wifi.connect.a.h.a().a(paramWkAccessPoint);
    if (paramWkAccessPoint != null) {
      localPluginAp.n = paramWkAccessPoint.f;
    }
    a(localPluginAp, "connect");
  }
  
  public final void a(WkAccessPoint paramWkAccessPoint, String paramString)
  {
    a(paramWkAccessPoint, paramString, "");
  }
  
  public final void a(WkAccessPoint paramWkAccessPoint, String paramString1, String paramString2)
  {
    localPluginAp = f.a().a(paramWkAccessPoint);
    if (localPluginAp != null)
    {
      com.lantern.analytics.a.e().onEvent("exsta");
      localPluginAp.a = paramWkAccessPoint.a;
      localPluginAp.b = paramWkAccessPoint.b;
      com.bluefay.b.h.a("asyncRunPlugin:" + localPluginAp);
      this.b.a(localPluginAp, this.c);
    }
    for (;;)
    {
      return;
      if (!g.a().a(paramWkAccessPoint)) {
        break;
      }
      paramWkAccessPoint = new PluginAp(paramWkAccessPoint, 3);
      paramWkAccessPoint.j = "com.wifi.connect.plugin.ssrp";
      paramWkAccessPoint.k = "com.wifi.connect.plugin.ssrp.ConnectActivity";
      a(paramWkAccessPoint, "connect");
    }
    localPluginAp = new PluginAp(paramWkAccessPoint, 10);
    localPluginAp.j = "com.wifi.connect.plugin.magickey";
    localPluginAp.n = e.b().b(localPluginAp);
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("hasKey", e.b().b(localPluginAp));
        if (e.b().b(localPluginAp)) {
          localJSONObject.put("qid", e.b().a(localPluginAp).g);
        }
        if (paramString1 != null) {
          localJSONObject.put("pos", paramString1);
        }
        int j = e.b().c(paramWkAccessPoint);
        if (j > 0)
        {
          i = paramWkAccessPoint.d;
          if (i != Integer.MAX_VALUE) {
            continue;
          }
          i = -1;
          if (i >= 2) {
            localJSONObject.put("recommand", String.valueOf(j));
          }
        }
        if (e.b().b(localPluginAp))
        {
          localJSONObject.put("apRefId", e.b().a(paramWkAccessPoint).e);
          localJSONObject.put("ccId", e.b().a(paramWkAccessPoint).h);
        }
        if (!TextUtils.isEmpty(paramString2)) {
          localJSONObject.put("nearby", paramString2);
        }
        if ((com.wifi.connect.a.a.a().c(paramWkAccessPoint.a, paramWkAccessPoint.c)) && (com.wifi.connect.a.a.a().a(paramWkAccessPoint) != null))
        {
          localJSONObject.put("shop_ssid", paramWkAccessPoint.a);
          localJSONObject.put("shop_alias", com.wifi.connect.a.a.a().a(paramWkAccessPoint).e);
          localJSONObject.put("shop_avatar", e.b().a(paramWkAccessPoint).i);
          localJSONObject.put("shop_type", e.b().a(paramWkAccessPoint).k);
        }
        localPluginAp.n = localJSONObject.toString();
      }
      catch (JSONException paramWkAccessPoint)
      {
        int i;
        com.bluefay.b.h.a(paramWkAccessPoint);
        localPluginAp.n = e.b().b(localPluginAp);
        continue;
      }
      a(localPluginAp, "connect");
      break;
      i = WifiManager.calculateSignalLevel(i, 4);
    }
  }
  
  public final void b()
  {
    PluginAp localPluginAp = new PluginAp();
    localPluginAp.j = "com.wifi.connect.plugin.magickey";
    a(localPluginAp, "submitEventLog");
  }
  
  public final void b(WkAccessPoint paramWkAccessPoint)
  {
    paramWkAccessPoint = new PluginAp(paramWkAccessPoint, 10);
    paramWkAccessPoint.j = "com.wifi.connect.plugin.magickey";
    paramWkAccessPoint.n = e.b().b(paramWkAccessPoint);
    a(paramWkAccessPoint, "delete");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */