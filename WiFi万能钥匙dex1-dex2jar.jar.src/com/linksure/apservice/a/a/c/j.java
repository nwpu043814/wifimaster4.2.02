package com.linksure.apservice.a.a.c;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class j
{
  public static final class a
    extends a
  {
    private int b = 10000;
    private int c = 1;
    
    public final String c()
    {
      return "02300102";
    }
    
    public final String e()
    {
      try
      {
        Object localObject1 = a();
        ((JSONObject)localObject1).put("pageSize", this.b);
        ((JSONObject)localObject1).put("pageIndex", this.c);
        localObject1 = ((JSONObject)localObject1).toString();
        return (String)localObject1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          Object localObject2 = null;
        }
      }
    }
  }
  
  public static class b
    extends b<List<com.linksure.apservice.a.d.a>>
  {
    public final void a(JSONObject paramJSONObject)
    {
      paramJSONObject = paramJSONObject.optJSONArray("serviceAccountList");
      if ((paramJSONObject == null) || (paramJSONObject.length() == 0)) {}
      for (;;)
      {
        return;
        int j = paramJSONObject.length();
        ArrayList localArrayList = new ArrayList(j);
        for (int i = 0; i < j; i++)
        {
          com.linksure.apservice.a.d.a locala = c.a(paramJSONObject.optJSONObject(i));
          if (locala != null) {
            localArrayList.add(locala);
          }
        }
        this.c = localArrayList;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/a/a/c/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */