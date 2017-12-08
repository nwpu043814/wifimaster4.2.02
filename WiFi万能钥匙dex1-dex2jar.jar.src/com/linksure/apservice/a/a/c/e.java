package com.linksure.apservice.a.a.c;

import com.linksure.apservice.a.d.c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e
{
  public static final class a
    extends a
  {
    String b;
    int c;
    int d;
    
    public a(String paramString, int paramInt1, int paramInt2)
    {
      this.b = paramString;
      this.c = paramInt1;
      this.d = paramInt2;
    }
    
    public final String c()
    {
      return "02300113";
    }
    
    public final String e()
    {
      try
      {
        Object localObject1 = a();
        ((JSONObject)localObject1).put("sortCode", this.b);
        ((JSONObject)localObject1).put("pageIndex", this.c);
        ((JSONObject)localObject1).put("pageSize", this.d);
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
    extends b<List<c>>
  {
    public final void a(JSONObject paramJSONObject)
    {
      JSONArray localJSONArray = paramJSONObject.optJSONArray("serviceAccountList");
      ArrayList localArrayList = new ArrayList();
      for (int i = 0; i < localJSONArray.length(); i++)
      {
        JSONObject localJSONObject = localJSONArray.optJSONObject(i);
        paramJSONObject = new c();
        paramJSONObject.a = localJSONObject.optString("serviceAccountId");
        paramJSONObject.b = localJSONObject.optString("name");
        paramJSONObject.c = localJSONObject.optString("logo");
        paramJSONObject.d = localJSONObject.optInt("type");
        paramJSONObject.e = localJSONObject.optString("introduce");
        paramJSONObject.f = localJSONObject.optInt("followCount");
        paramJSONObject.g = localJSONObject.optBoolean("follow");
        paramJSONObject.h = localJSONObject.optBoolean("black");
        paramJSONObject.i = localJSONObject.optBoolean("replySwitch");
        paramJSONObject.j = localJSONObject.optBoolean("pushSwitch");
        paramJSONObject.k = localJSONObject.optBoolean("frozen");
        localArrayList.add(paramJSONObject);
      }
      this.c = localArrayList;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/a/a/c/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */