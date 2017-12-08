package com.linksure.apservice.a.a.c;

import com.linksure.apservice.a.d.f;
import java.util.List;
import org.json.JSONObject;

public final class o
{
  public static final class a
    extends a
  {
    private int b;
    private String c;
    private String d;
    
    public a(int paramInt, String paramString1, String paramString2)
    {
      this.b = paramInt;
      this.c = paramString1;
      this.d = paramString2;
    }
    
    public final String c()
    {
      return "02300201";
    }
    
    public final String e()
    {
      try
      {
        Object localObject1 = a();
        ((JSONObject)localObject1).put("serviceAccountId", this.d);
        ((JSONObject)localObject1).put("type", this.b);
        ((JSONObject)localObject1).put("textContent", this.c);
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
    extends b<List<f>>
  {
    public final void a(JSONObject paramJSONObject) {}
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/a/a/c/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */