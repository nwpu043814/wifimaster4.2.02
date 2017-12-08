package com.lantern.analytics.c;

import com.bluefay.b.h;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public String a;
  public String b;
  public String c;
  public int d;
  public String e;
  public boolean f;
  public boolean g;
  public String h;
  
  public final String toString()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (this.a != null) {
        localJSONObject.put("name", this.a);
      }
      if (this.b != null) {
        localJSONObject.put("packageName", this.b);
      }
      if (this.c != null) {
        localJSONObject.put("processName", this.c);
      }
      localJSONObject.put("versioncode", String.valueOf(this.d));
      if (this.e != null) {
        localJSONObject.put("versionName", this.e);
      }
      localJSONObject.put("system", this.f);
      localJSONObject.put("enabled", this.g);
      if (this.h != null) {
        localJSONObject.put("installer", this.h);
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


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/analytics/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */