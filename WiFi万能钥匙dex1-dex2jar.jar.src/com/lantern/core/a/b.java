package com.lantern.core.a;

import com.bluefay.b.h;
import com.lantern.core.c;
import com.lantern.core.config.d;
import org.json.JSONException;
import org.json.JSONObject;

final class b
  implements com.bluefay.b.a
{
  b(a parama) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    if (paramInt == 1)
    {
      paramObject = (String)paramObject;
      h.a("config:" + (String)paramObject, new Object[0]);
    }
    for (;;)
    {
      try
      {
        paramString = new org/json/JSONObject;
        paramString.<init>((String)paramObject);
        paramString = paramString.getJSONObject("config");
        if (paramString == null) {
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        continue;
      }
      d.a(c.getAppContext()).a(paramString);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */