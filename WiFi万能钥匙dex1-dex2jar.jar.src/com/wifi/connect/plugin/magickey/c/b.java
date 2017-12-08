package com.wifi.connect.plugin.magickey.c;

import com.lantern.core.c;
import com.lantern.core.k;
import com.lantern.core.model.WkAccessPoint;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public ArrayList<WkAccessPoint> h = new ArrayList();
  public String i;
  public long j;
  public String k;
  public String l;
  public String m;
  public String n;
  public String o;
  public String p;
  
  public static b a(JSONObject paramJSONObject)
  {
    b localb = new b();
    localb.b = paramJSONObject.optString("ssid");
    localb.c = paramJSONObject.optString("bssid");
    localb.f = paramJSONObject.optString("errorCode");
    localb.g = paramJSONObject.optString("errorMsg");
    localb.e = paramJSONObject.optString("qid");
    localb.d = paramJSONObject.optString("pwdId");
    localb.a = paramJSONObject.optString("apId");
    localb.m = paramJSONObject.optString("ccId");
    localb.n = paramJSONObject.optString("rssi");
    localb.o = paramJSONObject.optString("qpts");
    localb.l = paramJSONObject.optString("cid");
    localb.p = paramJSONObject.optString("security");
    if (paramJSONObject.has("nbaps"))
    {
      Object localObject = paramJSONObject.get("nbaps");
      paramJSONObject = null;
      if ((localObject instanceof String)) {
        paramJSONObject = new JSONArray((String)localObject);
      }
      while (paramJSONObject != null)
      {
        int i2 = paramJSONObject.length();
        localb.h = new ArrayList();
        for (int i1 = 0; i1 < i2; i1++)
        {
          localObject = new WkAccessPoint(paramJSONObject.getJSONObject(i1));
          localb.h.add(localObject);
        }
        if ((localObject instanceof JSONArray)) {
          paramJSONObject = (JSONArray)localObject;
        }
      }
    }
    return localb;
  }
  
  private static JSONArray a(ArrayList<WkAccessPoint> paramArrayList)
  {
    JSONArray localJSONArray = new JSONArray();
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    for (;;)
    {
      return localJSONArray;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        localJSONArray.put(((WkAccessPoint)paramArrayList.next()).c());
      }
    }
  }
  
  private JSONObject b()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("ssid", this.b);
      localJSONObject.put("bssid", this.c);
      localJSONObject.put("errorCode", this.f);
      localJSONObject.put("errorMsg", this.g);
      localJSONObject.put("qid", this.e);
      localJSONObject.put("pwdId", this.d);
      localJSONObject.put("apId", this.a);
      localJSONObject.put("nbaps", a(this.h));
      localJSONObject.put("lac", this.k);
      localJSONObject.put("cid", this.l);
      localJSONObject.put("ccId", this.m);
      localJSONObject.put("rssi", this.n);
      localJSONObject.put("qpts", this.o);
      localJSONObject.put("security", this.p);
      localJSONObject.put("sn", k.f(c.getAppContext()));
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
        Object localObject = null;
      }
    }
  }
  
  public final String a()
  {
    if (this.m != null) {}
    for (String str = this.m;; str = "") {
      return str;
    }
  }
  
  public final String toString()
  {
    Object localObject = b();
    if (localObject != null) {}
    for (localObject = ((JSONObject)localObject).toString();; localObject = "{}") {
      return (String)localObject;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/magickey/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */