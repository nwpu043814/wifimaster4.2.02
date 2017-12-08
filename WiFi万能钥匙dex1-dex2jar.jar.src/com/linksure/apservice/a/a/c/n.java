package com.linksure.apservice.a.a.c;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class n
{
  public static final class a
    extends a
  {
    private String b;
    private int c;
    private int d;
    
    public a(String paramString, int paramInt1, int paramInt2)
    {
      this.b = paramString;
      this.c = paramInt1;
      this.d = paramInt2;
    }
    
    public final String c()
    {
      return "02300114";
    }
    
    public final String e()
    {
      try
      {
        Object localObject1 = a();
        ((JSONObject)localObject1).put("nickNameKeyword", this.b);
        ((JSONObject)localObject1).put("pageIndex", this.d);
        ((JSONObject)localObject1).put("pageSize", this.c);
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


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/a/a/c/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */