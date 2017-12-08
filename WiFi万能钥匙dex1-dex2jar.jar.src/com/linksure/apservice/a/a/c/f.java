package com.linksure.apservice.a.a.c;

import org.json.JSONObject;

public final class f
{
  public static final class a
    extends a
  {
    private String b;
    private int c;
    private String d;
    
    public a(String paramString1, int paramInt, String paramString2)
    {
      this.b = paramString1;
      this.c = paramInt;
      this.d = paramString2;
    }
    
    public final String c()
    {
      return "02300106";
    }
    
    public final String e()
    {
      try
      {
        Object localObject1 = a();
        ((JSONObject)localObject1).put("serviceAccountId", this.b);
        ((JSONObject)localObject1).put("complainType", this.c);
        ((JSONObject)localObject1).put("complainContent", this.d);
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
    extends b<Boolean>
  {
    public final void a(JSONObject paramJSONObject) {}
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/a/a/c/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */