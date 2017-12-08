package com.lantern.wifilocating.push.e;

import android.content.Context;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.lantern.wifilocating.push.c;
import com.lantern.wifilocating.push.d.f;
import com.lantern.wifilocating.push.d.g;
import com.lantern.wifilocating.push.h.a;
import com.lantern.wifilocating.push.util.n;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

final class e
  extends Thread
{
  e(d paramd) {}
  
  public final void run()
  {
    for (;;)
    {
      Object localObject4;
      Object localObject3;
      try
      {
        f localf = com.lantern.wifilocating.push.util.d.a().b();
        if (localf == null) {
          return;
        }
      }
      catch (Exception localException1)
      {
        com.lantern.wifilocating.push.util.h.a(localException1);
        continue;
        localObject1 = ((JSONArray)localObject1).toString().trim();
        localObject2 = new org/json/JSONObject;
        ((JSONObject)localObject2).<init>();
        ((JSONObject)localObject2).put("data", localObject1);
        localObject2 = n.a(Uri.encode(((JSONObject)localObject2).toString().trim(), "UTF-8"), localException1.f, localException1.g);
        if ((localObject2 == null) || (((String)localObject2).equals(localObject1))) {
          continue;
        }
        localObject1 = new java/util/HashMap;
        ((HashMap)localObject1).<init>();
        if (localException1 == null) {
          break label301;
        }
      }
      Object localObject1 = (WifiManager)c.a().getSystemService("wifi");
      if (!((WifiManager)localObject1).isWifiEnabled()) {
        continue;
      }
      Object localObject2 = ((WifiManager)localObject1).getScanResults();
      if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
        continue;
      }
      localObject1 = new org/json/JSONArray;
      ((JSONArray)localObject1).<init>();
      localObject2 = ((List)localObject2).iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject4 = (ScanResult)((Iterator)localObject2).next();
        if (localObject4 == null) {
          continue;
        }
        localObject3 = new org/json/JSONObject;
        ((JSONObject)localObject3).<init>();
        ((JSONObject)localObject3).put("ssid", ((ScanResult)localObject4).SSID);
        ((JSONObject)localObject3).put("bssid", ((ScanResult)localObject4).BSSID);
        ((JSONObject)localObject3).put("rssi", ((ScanResult)localObject4).level);
        ((JSONArray)localObject1).put(localObject3);
        continue;
      }
      try
      {
        ((Map)localObject1).put("appId", localException1.a);
        ((Map)localObject1).put("pid", "01600104");
        ((Map)localObject1).put("ed", localObject2);
        ((Map)localObject1).put("et", "a");
        ((Map)localObject1).put("st", "m");
        ((Map)localObject1).put("sign", com.lantern.wifilocating.push.d.h.a((Map)localObject1, localException1.h));
        label301:
        if (((Map)localObject1).isEmpty()) {
          continue;
        }
        localObject1 = com.lantern.wifilocating.push.d.d.a(g.c(), (Map)localObject1);
        localObject2 = new org/json/JSONObject;
        ((JSONObject)localObject2).<init>((String)localObject1);
        if (((JSONObject)localObject2).optInt("retCd", -1) != 0) {
          continue;
        }
        localObject2 = ((JSONObject)localObject2).optString("retMsg");
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          continue;
        }
        localObject1 = new org/json/JSONObject;
        ((JSONObject)localObject1).<init>((String)localObject2);
        if (((JSONObject)localObject1).optInt("errorCode", -1) != 0) {
          continue;
        }
        localObject1 = ((JSONObject)localObject1).optString("data");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          continue;
        }
        String str = n.b((String)localObject1, localException1.f, localException1.g);
        if (TextUtils.isEmpty(str)) {
          continue;
        }
        localObject3 = new org/json/JSONObject;
        ((JSONObject)localObject3).<init>(str);
        localObject1 = ((JSONObject)localObject3).optString("la");
        localObject2 = ((JSONObject)localObject3).optString("lo");
        str = ((JSONObject)localObject3).optString("mapsp");
        localObject4 = ((JSONObject)localObject3).optString("adr");
        localObject3 = new com/lantern/wifilocating/push/h/a;
        ((a)localObject3).<init>(str, (String)localObject2, (String)localObject1, (String)localObject4);
        if (d.a(this.a) == null) {
          continue;
        }
        d.a(this.a).a((a)localObject3);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          com.lantern.wifilocating.push.util.h.a(localException2);
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/e/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */