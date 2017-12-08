package com.wifi.connect.model;

import com.bluefay.b.h;
import com.lantern.core.model.WkAccessPoint;
import org.json.JSONException;
import org.json.JSONObject;

public class AccessPointKey
  extends WkAccessPoint
{
  public String e;
  public int f;
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
  public String q;
  
  public AccessPointKey() {}
  
  public AccessPointKey(WkAccessPoint paramWkAccessPoint)
  {
    super(paramWkAccessPoint);
  }
  
  public final JSONObject c()
  {
    JSONObject localJSONObject = super.c();
    try
    {
      localJSONObject.put("apid", this.e);
      localJSONObject.put("keyStatus", this.f);
      localJSONObject.put("score", this.n);
      localJSONObject.put("qid", this.g);
      localJSONObject.put("ccId", this.h);
      localJSONObject.put("lg", this.i);
      localJSONObject.put("lgm", this.j);
      localJSONObject.put("hat", this.k);
      localJSONObject.put("lgs", this.l);
      localJSONObject.put("lgsm", this.m);
      localJSONObject.put("sai", this.o);
      localJSONObject.put("mat", this.p);
      localJSONObject.put("qt", this.q);
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


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/model/AccessPointKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */