package com.lantern.core.g;

import android.text.TextUtils;
import com.lantern.core.model.d;
import com.lantern.core.p;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public final class i
{
  private static i b;
  private final String a = "co_dnkey";
  private ConcurrentHashMap<String, d> c = new ConcurrentHashMap();
  
  public static i a()
  {
    if (b == null) {
      b = new i();
    }
    return b;
  }
  
  private static d b(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new org/json/JSONObject;
      localJSONObject.<init>(paramString.replace("\\", ""));
      paramString = new com/lantern/core/model/d;
      paramString.<init>();
      paramString.a(localJSONObject.optString("ak"));
      paramString.b(localJSONObject.optString("ai"));
      paramString.c(localJSONObject.optString("mk"));
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = null;
      }
    }
  }
  
  public final d a(String paramString)
  {
    d locald2 = (d)this.c.get(paramString);
    d locald1 = locald2;
    if (locald2 == null)
    {
      String str = p.a("co_dnkey", paramString, null);
      locald1 = locald2;
      if (!TextUtils.isEmpty(str))
      {
        locald2 = b(str);
        locald1 = locald2;
        if (locald2 != null)
        {
          this.c.put(paramString, locald2);
          locald1 = locald2;
        }
      }
    }
    return locald1;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/g/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */