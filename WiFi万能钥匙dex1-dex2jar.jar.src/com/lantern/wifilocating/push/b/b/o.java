package com.lantern.wifilocating.push.b.b;

import org.json.JSONObject;

public final class o
{
  public static JSONObject a(e parame)
  {
    try
    {
      localJSONObject = new org/json/JSONObject;
      localJSONObject.<init>();
    }
    catch (Exception parame)
    {
      for (;;)
      {
        label21:
        parame = null;
      }
    }
    try
    {
      localJSONObject.put("cmd", parame.a());
      parame = localJSONObject;
    }
    catch (Exception parame)
    {
      parame = localJSONObject;
      break label21;
    }
    return parame;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/b/b/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */