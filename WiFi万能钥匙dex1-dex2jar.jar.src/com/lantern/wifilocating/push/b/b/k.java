package com.lantern.wifilocating.push.b.b;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.SystemClock;
import android.text.TextUtils;
import com.lantern.wifilocating.push.c;
import com.lantern.wifilocating.push.d.f;
import com.lantern.wifilocating.push.util.d;
import com.lantern.wifilocating.push.util.h;
import com.lantern.wifilocating.push.util.j;
import org.json.JSONObject;

public final class k
  extends a
{
  public k()
  {
    super(e.a);
  }
  
  private static JSONObject a(f paramf)
  {
    localObject2 = null;
    localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("appId", paramf.a);
        localJSONObject.put("lang", j.a());
        localJSONObject.put("verName", paramf.j);
        localJSONObject.put("origChanId", paramf.e);
        localObject1 = j.e(c.a());
        if (localObject1 == null) {
          continue;
        }
        localJSONObject.put("imei", localObject1);
        localObject1 = j.f(c.a());
        if (localObject1 == null) {
          continue;
        }
        localJSONObject.put("mac", localObject1);
        localJSONObject.put("uhid", paramf.c);
        long l = SystemClock.elapsedRealtime();
        if ((TextUtils.isEmpty(paramf.k)) || (TextUtils.isEmpty(paramf.l)) || (TextUtils.isEmpty(paramf.m))) {
          continue;
        }
        localJSONObject.put("mapSP", paramf.k);
        localJSONObject.put("longi", paramf.l);
        localJSONObject.put("lati", paramf.m);
        d.c(paramf.k);
        d.b(paramf.l);
        d.a(paramf.m);
        d.a(l);
        paramf = j.g(c.a());
        localJSONObject.put("netModel", paramf);
        if (!"w".equals(paramf)) {
          continue;
        }
        paramf = ((WifiManager)c.a().getSystemService("wifi")).getConnectionInfo();
        if (paramf == null) {
          continue;
        }
        localObject1 = j.c(paramf.getSSID());
        paramf = j.b(paramf.getBSSID());
      }
      catch (Exception paramf)
      {
        continue;
        localJSONObject.put("capBssid", "");
        localJSONObject.put("capSsid", "");
        continue;
        paramf = null;
        Object localObject1 = localObject2;
        continue;
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      localObject1 = paramf;
      if (paramf == null) {
        localObject1 = "";
      }
      localJSONObject.put("capBssid", localObject1);
      localJSONObject.put("capSsid", localObject2);
      localJSONObject.put("ts", String.valueOf(System.currentTimeMillis()));
      return localJSONObject;
      localObject1 = "";
      continue;
      localObject1 = "";
      continue;
      localJSONObject.put("mapSP", "");
      localJSONObject.put("longi", "");
      localJSONObject.put("lati", "");
    }
  }
  
  public final void b()
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = o.a(e());
        if (localJSONObject != null)
        {
          localf = d.a().b();
          localJSONObject.put("dhid", localf.b);
          localJSONObject.put("verCode", localf.i);
          localJSONObject.put("chanId", localf.d);
          localJSONObject.put("sdkVersion", "2.0");
          localJSONObject.put("version", "1.0");
          if (localf.n == null)
          {
            str = "";
            localJSONObject.put("token", str);
            localJSONObject.put("extra", a(localf));
            a(localJSONObject);
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception localException)
      {
        f localf;
        String str;
        h.a(localException);
        continue;
      }
      str = localf.n;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/b/b/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */