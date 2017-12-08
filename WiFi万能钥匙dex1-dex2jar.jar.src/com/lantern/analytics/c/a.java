package com.lantern.analytics.c;

import com.bluefay.b.h;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public String a;
  public String b;
  public String c;
  
  public final String toString()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (this.a != null) {
        localJSONObject.put("activity", this.a);
      }
      if (this.b != null) {
        localJSONObject.put("cause", this.b);
      }
      if (this.c != null) {
        localJSONObject.put("info", this.c);
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


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/analytics/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */