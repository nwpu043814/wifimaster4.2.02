package com.wifi.connect.model;

import com.bluefay.b.h;
import com.lantern.core.model.WkAccessPoint;
import org.json.JSONException;
import org.json.JSONObject;

public class AccessPointAlias
  extends WkAccessPoint
{
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  public String o;
  public String p;
  
  public AccessPointAlias() {}
  
  public AccessPointAlias(WkAccessPoint paramWkAccessPoint)
  {
    a(paramWkAccessPoint.a);
    b(paramWkAccessPoint.b);
    this.c = paramWkAccessPoint.c;
    this.d = paramWkAccessPoint.d;
  }
  
  public final JSONObject c()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("ssid", this.a);
      localJSONObject.put("alias", this.e);
      localJSONObject.put("hp", this.h);
      localJSONObject.put("adrs", this.g);
      localJSONObject.put("lg", this.i);
      localJSONObject.put("lgm", this.j);
      localJSONObject.put("hat", this.k);
      localJSONObject.put("lgs", this.l);
      localJSONObject.put("lgsm", this.m);
      localJSONObject.put("sai", this.n);
      localJSONObject.put("score", this.o);
      localJSONObject.put("qt", this.p);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        h.a(localJSONException);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/model/AccessPointAlias.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */