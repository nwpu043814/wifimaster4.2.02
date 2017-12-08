package com.lantern.wifilocating.push.d;

import android.content.Context;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.lantern.wifilocating.push.c;
import com.lantern.wifilocating.push.util.d;
import com.lantern.wifilocating.push.util.j;
import com.lantern.wifilocating.push.util.n;
import java.util.HashMap;
import org.json.JSONObject;

public final class g
{
  private static g a = new g();
  private String b = j.f(c.a());
  private String c = j.e(c.a());
  
  public static String a()
  {
    String str = com.lantern.wifilocating.push.util.g.e();
    if (str != null) {}
    for (str = String.format("%s%s", new Object[] { str, "/message/fa.sec" });; str = String.format("%s%s", new Object[] { "http://msg.push.51y5.net", "/message/fa.sec" })) {
      return str;
    }
  }
  
  public static HashMap<String, String> a(String paramString, HashMap<String, String> paramHashMap)
  {
    String str = new JSONObject(paramHashMap).toString();
    paramHashMap.clear();
    f localf = d.a().b();
    if (localf != null) {}
    try
    {
      paramHashMap.put("appId", localf.a);
      paramHashMap.put("pid", paramString);
      paramHashMap.put("ed", n.a(Uri.encode(str.trim(), "UTF-8"), localf.f, localf.g));
      paramHashMap.put("et", "a");
      paramHashMap.put("st", "m");
      paramHashMap.put("sign", h.a(paramHashMap, localf.h));
      return paramHashMap;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        com.lantern.wifilocating.push.util.h.a(paramString);
      }
    }
  }
  
  public static HashMap<String, String> a(HashMap<String, String> paramHashMap)
  {
    f localf = d.a().b();
    if (localf != null) {}
    try
    {
      paramHashMap.put("st", "m");
      paramHashMap.put("sign", h.a(paramHashMap, localf.h));
      return paramHashMap;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.lantern.wifilocating.push.util.h.a(localException);
      }
    }
  }
  
  public static String b()
  {
    String str = com.lantern.wifilocating.push.util.g.c();
    if (str != null) {}
    for (str = String.format("%s%s", new Object[] { str, "/login/fa.sec" });; str = String.format("%s%s", new Object[] { "http://login.push.51y5.net", "/login/fa.sec" })) {
      return str;
    }
  }
  
  public static String c()
  {
    String str = com.lantern.wifilocating.push.util.g.a().a("host");
    if (str != null) {}
    for (str = String.format("%s%s", new Object[] { str, "/api/fa.sec" });; str = String.format("%s%s", new Object[] { "http://api.push.51y5.net", "/api/fa.sec" })) {
      return str;
    }
  }
  
  public static g d()
  {
    return a;
  }
  
  public final HashMap<String, String> e()
  {
    Object localObject2 = null;
    f localf = d.a().b();
    if (localf == null)
    {
      localObject1 = null;
      return (HashMap<String, String>)localObject1;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("appId", localf.a);
    localHashMap.put("lang", j.a());
    localHashMap.put("verName", localf.j);
    localHashMap.put("verCode", localf.i);
    if (localf.d != null)
    {
      localObject1 = localf.d;
      label92:
      localHashMap.put("chanId", localObject1);
      if (localf.e == null) {
        break label400;
      }
      localObject1 = localf.e;
      label115:
      localHashMap.put("origChanId", localObject1);
      if (this.c == null) {
        break label406;
      }
      localObject1 = this.c;
      label136:
      localHashMap.put("imei", localObject1);
      if ((this.b == null) || (this.b.length() == 0)) {
        this.b = j.f(c.a());
      }
      localObject1 = this.b;
      if (localObject1 == null) {
        break label412;
      }
      label181:
      localHashMap.put("mac", localObject1);
      localHashMap.put("dhid", localf.b);
      if (localf.c == null) {
        break label418;
      }
      localObject1 = localf.c;
      label217:
      localHashMap.put("uhid", localObject1);
      localObject1 = j.g(c.a());
      localHashMap.put("netModel", localObject1);
      if (!"w".equals(localObject1)) {
        break label424;
      }
      localObject1 = ((WifiManager)c.a().getSystemService("wifi")).getConnectionInfo();
      if (localObject1 == null) {
        break label447;
      }
      localObject2 = j.c(((WifiInfo)localObject1).getSSID());
    }
    label400:
    label406:
    label412:
    label418:
    label424:
    label447:
    for (Object localObject1 = j.b(((WifiInfo)localObject1).getBSSID());; localObject1 = null)
    {
      Object localObject3 = localObject2;
      if (localObject2 == null) {
        localObject3 = "";
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      localHashMap.put("capBssid", localObject2);
      localHashMap.put("capSsid", localObject3);
      for (;;)
      {
        if (!TextUtils.isEmpty(localf.k))
        {
          localHashMap.put("mapSP", localf.k);
          localHashMap.put("longi", localf.l);
          localHashMap.put("lati", localf.m);
        }
        localHashMap.put("ts", String.valueOf(System.currentTimeMillis()));
        localObject1 = localHashMap;
        break;
        localObject1 = "";
        break label92;
        localObject1 = "";
        break label115;
        localObject1 = "";
        break label136;
        localObject1 = "";
        break label181;
        localObject1 = "";
        break label217;
        localHashMap.put("capBssid", "");
        localHashMap.put("capSsid", "");
      }
    }
  }
  
  public final String f()
  {
    return this.c;
  }
  
  public final String g()
  {
    return this.b;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/d/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */