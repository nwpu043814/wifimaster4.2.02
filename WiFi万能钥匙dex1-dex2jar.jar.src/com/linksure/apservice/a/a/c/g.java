package com.linksure.apservice.a.a.c;

import org.json.JSONObject;

public final class g
{
  public static final class a
    extends a
  {
    private String b;
    
    public a(String paramString)
    {
      this.b = paramString;
    }
    
    public final String c()
    {
      return "02300104";
    }
    
    public final String e()
    {
      try
      {
        Object localObject1 = a();
        ((JSONObject)localObject1).put("serviceAccountId", this.b);
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
    extends b<com.linksure.apservice.a.d.a>
  {
    public final void a(JSONObject paramJSONObject)
    {
      com.linksure.apservice.a.d.a locala = c.a(paramJSONObject.optJSONObject("serviceAccount"));
      locala.t = paramJSONObject.optString("retCd");
      this.c = locala;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/a/a/c/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */