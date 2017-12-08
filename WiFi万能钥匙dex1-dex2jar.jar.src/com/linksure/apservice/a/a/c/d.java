package com.linksure.apservice.a.a.c;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d
{
  public static final class a
    extends a
  {
    public final String c()
    {
      return "02300112";
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
    extends b<List<com.linksure.apservice.a.d.b>>
  {
    public final void a(JSONObject paramJSONObject)
    {
      JSONArray localJSONArray = paramJSONObject.optJSONArray("resList");
      paramJSONObject = new ArrayList();
      int i = 0;
      if (i < localJSONArray.length())
      {
        JSONObject localJSONObject = localJSONArray.optJSONObject(i);
        com.linksure.apservice.a.d.b localb = new com.linksure.apservice.a.d.b();
        localb.a = localJSONObject.optString("code");
        localb.b = localJSONObject.optString("desc");
        localb.c = localJSONObject.optInt("indexNo");
        if (localJSONObject.optInt("isShow") == 1) {}
        for (boolean bool = true;; bool = false)
        {
          localb.d = bool;
          paramJSONObject.add(localb);
          i++;
          break;
        }
      }
      this.c = paramJSONObject;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/a/a/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */