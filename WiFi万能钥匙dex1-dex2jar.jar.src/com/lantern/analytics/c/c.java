package com.lantern.analytics.c;

import com.bluefay.b.h;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public int f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  
  public final String toString()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (this.a != null) {
        localJSONObject.put("device", this.a);
      }
      if (this.b != null) {
        localJSONObject.put("model", this.b);
      }
      if (this.c != null) {
        localJSONObject.put("product", this.c);
      }
      if (this.d != null) {
        localJSONObject.put("board", this.d);
      }
      if (this.e != null) {
        localJSONObject.put("firmware", this.e);
      }
      localJSONObject.put("sdk_int", this.f);
      if (this.g != null) {
        localJSONObject.put("baseband", this.g);
      }
      if (this.h != null) {
        localJSONObject.put("kernel", this.h);
      }
      if (this.i != null) {
        localJSONObject.put("buildIncremental", this.i);
      }
      if (this.j != null) {
        localJSONObject.put("buildDisplay", this.j);
      }
      if (this.k != null) {
        localJSONObject.put("buildType", this.k);
      }
      if (this.m != null) {
        localJSONObject.put("serial", this.m);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        h.c(localJSONException.getMessage());
      }
    }
    return localJSONObject.toString();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/analytics/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */