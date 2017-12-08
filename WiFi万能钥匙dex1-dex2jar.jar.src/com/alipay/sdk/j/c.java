package com.alipay.sdk.j;

import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  public static JSONObject a(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    JSONObject localJSONObject1 = new JSONObject();
    for (int i = 0;; i++) {
      if (i < 2) {
        try
        {
          JSONObject localJSONObject2 = new JSONObject[] { paramJSONObject1, paramJSONObject2 }[i];
          if (localJSONObject2 != null)
          {
            Iterator localIterator = localJSONObject2.keys();
            while (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              localJSONObject1.put(str, localJSONObject2.get(str));
              continue;
              return localJSONObject1;
            }
          }
        }
        catch (JSONException paramJSONObject1) {}
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/sdk/j/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */