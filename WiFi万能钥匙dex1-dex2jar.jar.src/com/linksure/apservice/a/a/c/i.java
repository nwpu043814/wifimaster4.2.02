package com.linksure.apservice.a.a.c;

import com.linksure.apservice.a.d.d;
import org.json.JSONObject;

public final class i
{
  public static final class a
    extends a
  {
    public final String c()
    {
      return "02300116";
    }
    
    public final String e()
    {
      try
      {
        String str = a().toString();
        return str;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          Object localObject = null;
        }
      }
    }
  }
  
  public static class b
    extends b<d>
  {
    public final void a(JSONObject paramJSONObject)
    {
      JSONObject localJSONObject = paramJSONObject.optJSONObject("result");
      if (localJSONObject == null) {
        paramJSONObject = null;
      }
      for (;;)
      {
        this.c = paramJSONObject;
        return;
        paramJSONObject = new d();
        paramJSONObject.a = localJSONObject.optString("sortListSwitch");
        paramJSONObject.b = localJSONObject.optString("recommendSwitch");
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/a/a/c/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */