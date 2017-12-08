package com.linksure.apservice.a.a.c;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class m
{
  public static final class a
    extends a
  {
    public final String c()
    {
      return "02300108";
    }
    
    public final String e()
    {
      return a().toString();
    }
  }
  
  public static class b
    extends b<List<com.linksure.apservice.a.d.a>>
  {
    public final void a(JSONObject paramJSONObject)
    {
      JSONArray localJSONArray = paramJSONObject.optJSONArray("serviceAccountList");
      if ((localJSONArray == null) || (localJSONArray.length() == 0)) {}
      for (;;)
      {
        return;
        int j = localJSONArray.length();
        paramJSONObject = new ArrayList(j);
        for (int i = 0; i < j; i++)
        {
          com.linksure.apservice.a.d.a locala = c.a(localJSONArray.optJSONObject(i));
          if (locala != null) {
            paramJSONObject.add(locala);
          }
        }
        this.c = paramJSONObject;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/a/a/c/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */