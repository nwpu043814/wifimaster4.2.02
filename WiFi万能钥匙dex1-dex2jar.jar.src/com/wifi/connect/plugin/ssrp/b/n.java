package com.wifi.connect.plugin.ssrp.b;

import com.bluefay.b.h;
import com.lantern.core.c;
import com.lantern.core.o;
import com.lantern.core.p;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class n
{
  public long a;
  public long b;
  public String c;
  public String d;
  public int e;
  public int f;
  public String g = p.c(com.bluefay.d.a.getAppContext());
  public String h = c.getServer().e();
  public String i = c.getServer().d();
  public int j;
  public String k = "ss" + UUID.randomUUID().toString();
  public boolean l;
  public String m;
  
  private JSONObject b()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("eventid", this.k);
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localJSONObject.put("start", this.a);
      localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localJSONObject.put("end", this.b);
      localJSONObject.put("capSsidExt", this.c);
      localJSONObject.put("capBssidExt", this.d);
      localJSONObject.put("uinfo", this.g);
      localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localJSONObject.put("longi", this.h);
      localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localJSONObject.put("lati", this.i);
      localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localJSONObject.put("keycon", this.l);
      localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localJSONObject.put("times", this.f);
      localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localJSONObject.put("rssi", this.e);
      localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localJSONObject.put("res", this.j);
      localJSONObject.put("retres", this.m);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        h.a(localJSONException);
        Object localObject = null;
      }
    }
  }
  
  public final void a()
  {
    com.lantern.analytics.a locala = com.lantern.analytics.a.e();
    JSONObject localJSONObject = b();
    JSONArray localJSONArray;
    if (localJSONObject != null)
    {
      localJSONArray = new JSONArray();
      localJSONArray.put(localJSONObject);
    }
    for (;;)
    {
      locala.a("005038", localJSONArray);
      h.a("005038" + toString(), new Object[0]);
      return;
      localJSONArray = null;
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


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/ssrp/b/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */