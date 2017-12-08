package com.lantern.analytics.c;

import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
{
  public int a;
  public long b;
  public String c;
  public List<b> d;
  public b e;
  public c f;
  public g g;
  public h h;
  public d i;
  public a j;
  public String k;
  
  public final String toString()
  {
    localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("type", String.valueOf(this.a));
        localJSONObject.put("time", String.valueOf(this.b));
        if (this.c != null) {
          localJSONObject.put("cid", this.c);
        }
        if (this.a != 1) {
          continue;
        }
        if (this.e != null) {
          localJSONObject.put("app", this.e);
        }
        if (this.f != null) {
          localJSONObject.put("build", this.f);
        }
        if (this.g != null) {
          localJSONObject.put("system", this.g);
        }
        if (this.h != null) {
          localJSONObject.put("telephony", this.h);
        }
        if (this.i != null) {
          localJSONObject.put("crash", this.i);
        }
      }
      catch (JSONException localJSONException)
      {
        com.bluefay.b.h.c(localJSONException.getMessage());
        continue;
        if (this.a != 101) {
          continue;
        }
        if (this.f == null) {
          continue;
        }
        localJSONObject.put("build", this.f);
        if (this.k == null) {
          continue;
        }
        localJSONObject.put("feedback", this.k);
        continue;
        if (this.a != 100) {
          continue;
        }
        if (this.f == null) {
          continue;
        }
        localJSONObject.put("build", this.f);
        if (this.d == null) {
          continue;
        }
        JSONArray localJSONArray = new org/json/JSONArray;
        localJSONArray.<init>();
        Iterator localIterator = this.d.iterator();
        if (!localIterator.hasNext()) {
          continue;
        }
        localJSONArray.put((b)localIterator.next());
        continue;
        localJSONObject.put("apps", localJSONArray);
        continue;
      }
      return localJSONObject.toString();
      if (this.a != 2) {
        continue;
      }
      if (this.e != null) {
        localJSONObject.put("app", this.e);
      }
      if (this.f != null) {
        localJSONObject.put("build", this.f);
      }
      if (this.g != null) {
        localJSONObject.put("system", this.g);
      }
      if (this.h != null) {
        localJSONObject.put("telephony", this.h);
      }
      if (this.j != null) {
        localJSONObject.put("anr", this.j);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/analytics/c/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */