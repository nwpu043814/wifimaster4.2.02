package com.lantern.bindapp.b;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.bluefay.b.d;
import com.bluefay.b.h;
import com.lantern.core.f;
import com.lantern.core.k;
import com.lantern.core.o;
import com.lantern.core.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends AsyncTask<String, Integer, Integer>
{
  private com.bluefay.b.a a;
  private ArrayList<com.lantern.bindapp.a.a> b = new ArrayList();
  
  public c(com.bluefay.b.a parama)
  {
    this.a = parama;
  }
  
  private static HashMap<String, String> a()
  {
    h.a("start getParamMap", new Object[0]);
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("appInfo", a(com.lantern.core.c.getAppContext()));
      ((JSONObject)localObject).put("ts", String.valueOf(System.currentTimeMillis()));
      o localo = com.lantern.core.c.getServer();
      h.a("getParamMap signparams", new Object[0]);
      localObject = localo.a("cds006001", (JSONObject)localObject);
      h.a("getParamMap done." + d.a((Map)localObject), new Object[0]);
      return (HashMap<String, String>)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.a(localException);
      }
    }
  }
  
  private static JSONObject a(Context paramContext)
  {
    Object localObject1 = null;
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localObject2 = com.lantern.core.c.getServer();
      localJSONObject.put("dhid", ((o)localObject2).g());
      localJSONObject.put("lang", k.c());
      localJSONObject.put("appId", ((o)localObject2).k());
      localJSONObject.put("chanId", ((o)localObject2).b());
      localJSONObject.put("origChanId", ((o)localObject2).c());
      localJSONObject.put("verCode", String.valueOf(k.b(paramContext)));
      localJSONObject.put("verName", k.a(paramContext));
      localJSONObject.put("dhid", ((o)localObject2).g());
      localJSONObject.put("imei", ((o)localObject2).f());
      localJSONObject.put("mac", ((o)localObject2).r());
      localJSONObject.put("mapSP", ((o)localObject2).o());
      localJSONObject.put("longi", com.lantern.bindapp.c.a.c());
      localJSONObject.put("lati", com.lantern.bindapp.c.a.b());
      localJSONObject.put("uhid", ((o)localObject2).h());
      localObject2 = k.n(paramContext);
      localJSONObject.put("netModel", localObject2);
      if (!"w".equals(localObject2)) {
        break label259;
      }
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      if (paramContext == null) {
        break label288;
      }
      localObject1 = o.d(paramContext.getSSID());
      paramContext = o.c(paramContext.getBSSID());
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Object localObject2;
        h.a(paramContext);
        continue;
        paramContext = null;
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    localObject1 = paramContext;
    if (paramContext == null) {
      localObject1 = "";
    }
    localJSONObject.put("capBssid", localObject1);
    localJSONObject.put("capSsid", localObject2);
    for (;;)
    {
      return localJSONObject;
      label259:
      localJSONObject.put("capBssid", "");
      localJSONObject.put("capSsid", "");
    }
  }
  
  private Integer b()
  {
    com.lantern.core.c.getServer().f("cds006001");
    Object localObject2 = f.a().a("bindapp", "");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "http://cds.51y5.net/";
    }
    String str = d.a((String)localObject1 + "feeds.sec", a());
    if ((str == null) || (str.length() == 0)) {
      com.lantern.analytics.a.e().onEvent("bndrd_00");
    }
    for (localObject1 = Integer.valueOf(10);; localObject1 = Integer.valueOf(j))
    {
      return (Integer)localObject1;
      h.a("JSON:" + str, new Object[0]);
      localObject1 = null;
      try
      {
        localObject2 = new org/json/JSONObject;
        ((JSONObject)localObject2).<init>(str);
        if ("0".equals(((JSONObject)localObject2).getString("retCd"))) {
          break;
        }
        i = 0;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          h.a(localJSONException);
          int j = 30;
          continue;
          int i = 1;
        }
      }
      if (((JSONObject)localObject2).has("retMsg")) {
        localObject1 = ((JSONObject)localObject2).getString("retMsg");
      }
      h.a("retcode=%s,retmsg=%s", new Object[] { Integer.valueOf(i), localObject1 });
      j = i;
      if (i == 1)
      {
        localObject1 = ((JSONObject)localObject2).optJSONObject("result");
        j = i;
        if (localObject1 != null)
        {
          this.b = com.lantern.bindapp.c.a.a((JSONObject)localObject1, true);
          com.lantern.analytics.a.e().onEvent("bndrd1");
          p.b("bind_app_show_interval", ((JSONObject)localObject1).optLong("si", 0L));
          p.a("bind_app_cfg_type", ((JSONObject)localObject1).optInt("cfgType", 0));
          j = i;
        }
      }
      if (j != 1) {
        com.lantern.analytics.a.e().onEvent("bndrd_0");
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/bindapp/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */