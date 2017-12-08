package com.wifi.backup.c;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.bluefay.b.d;
import com.bluefay.b.h;
import com.lantern.core.WkSecretKeyNative;
import com.lantern.core.c;
import com.lantern.core.model.WkAccessPoint;
import com.lantern.core.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
  extends AsyncTask<String, Integer, Integer>
{
  private com.bluefay.b.a a;
  private List<com.wifi.backup.c.a.a> b;
  private WifiManager c;
  private Context d;
  private String e;
  private String f;
  private boolean g;
  
  public b(Context paramContext, boolean paramBoolean, List<com.wifi.backup.c.a.a> paramList, WifiManager paramWifiManager, com.bluefay.b.a parama)
  {
    this.a = parama;
    this.b = paramList;
    this.g = paramBoolean;
    this.c = paramWifiManager;
    this.d = paramContext;
  }
  
  private String a(List<com.wifi.backup.c.a.a> paramList)
  {
    JSONArray localJSONArray;
    if (paramList != null)
    {
      localJSONArray = new JSONArray();
      int i = 0;
      for (;;)
      {
        if (i >= paramList.size()) {
          break label152;
        }
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("ssid", ((com.wifi.backup.c.a.a)this.b.get(i)).i());
          localJSONObject.put("bssid", ((com.wifi.backup.c.a.a)this.b.get(i)).j());
          localJSONObject.put("pwd", ((com.wifi.backup.c.a.a)this.b.get(i)).l());
          localJSONObject.put("secLevel", ((com.wifi.backup.c.a.a)this.b.get(i)).k());
          localJSONArray.put(localJSONObject);
          i++;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
      }
      label152:
      this.e = localJSONArray.toString();
    }
    for (paramList = localJSONArray.toString();; paramList = "") {
      return paramList;
    }
  }
  
  private void a()
  {
    Iterator localIterator = com.wifi.backup.a.a.b().a().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      WkAccessPoint localWkAccessPoint = (WkAccessPoint)((Map.Entry)localObject).getKey();
      String str = (String)((Map.Entry)localObject).getValue();
      localObject = new com.wifi.backup.c.a.a();
      ((com.wifi.backup.c.a.a)localObject).e(localWkAccessPoint.b);
      ((com.wifi.backup.c.a.a)localObject).d(localWkAccessPoint.a);
      ((com.wifi.backup.c.a.a)localObject).a(true);
      ((com.wifi.backup.c.a.a)localObject).g(WkSecretKeyNative.a(str));
      ((com.wifi.backup.c.a.a)localObject).c("internet");
      ((com.wifi.backup.c.a.a)localObject).f(String.valueOf(localWkAccessPoint.c));
      this.b.add(localObject);
    }
  }
  
  private Integer b()
  {
    int i = 10;
    Object localObject1;
    if (!com.bluefay.a.a.c(com.bluefay.d.a.getAppContext())) {
      localObject1 = Integer.valueOf(10);
    }
    Object localObject2;
    for (;;)
    {
      return (Integer)localObject1;
      this.e = "";
      localObject2 = com.wifi.connect.a.a();
      com.bluefay.d.a.getAppContext();
      localObject1 = c.getServer().s();
      ((HashMap)localObject1).put("pid", "00300302");
      if (this.g) {
        ((HashMap)localObject1).put("aps", a(this.b));
      }
      for (;;)
      {
        localObject1 = c.getServer().b("00300302", (HashMap)localObject1);
        if ((!TextUtils.isEmpty(this.e)) && (!"[]".equals(this.e))) {
          break label146;
        }
        localObject1 = Integer.valueOf(-1);
        break;
        this.b = new ArrayList();
        a();
        ((HashMap)localObject1).put("aps", a(this.b));
      }
      label146:
      localObject2 = new d((String)localObject2);
      ((d)localObject2).a(10000, 10000);
      localObject2 = ((d)localObject2).c(d.a((Map)localObject1));
      if (((String)localObject2).length() == 0)
      {
        localObject1 = Integer.valueOf(10);
      }
      else
      {
        h.a("JSON:" + (String)localObject2, new Object[0]);
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          break;
        }
        localObject1 = Integer.valueOf(10);
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = new org/json/JSONObject;
        ((JSONObject)localObject1).<init>((String)localObject2);
        boolean bool = "0".equals(((JSONObject)localObject1).optString("retCd"));
        if (!bool) {
          continue;
        }
        i = 1;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      localObject1 = Integer.valueOf(i);
      break;
      this.f = ((JSONObject)localObject1).optString("retMsg");
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/backup/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */