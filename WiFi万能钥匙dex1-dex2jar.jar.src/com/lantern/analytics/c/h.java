package com.lantern.analytics.c;

import org.json.JSONException;
import org.json.JSONObject;

public final class h
{
  public int a;
  public int b;
  public String c;
  
  public final String toString()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (this.c != null) {
        localJSONObject.put("networkName", this.c);
      }
      localJSONObject.put("phoneType", this.a);
      localJSONObject.put("networkType", this.b);
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        com.bluefay.b.h.c(localJSONException.getMessage());
      }
    }
    return localJSONObject.toString();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/analytics/c/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */