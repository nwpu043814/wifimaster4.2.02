package com.linksure.apservice.a.a.c;

import org.json.JSONObject;

public final class p
{
  public static final class a
    extends a
  {
    private String b;
    private int c = 0;
    
    public a(String paramString, int paramInt)
    {
      this.b = paramString;
      this.c = paramInt;
    }
    
    public final String c()
    {
      return "02300115";
    }
    
    public final String e()
    {
      try
      {
        Object localObject1 = a();
        ((JSONObject)localObject1).put("serviceAccountId", this.b);
        ((JSONObject)localObject1).put("topSwitch", this.c);
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


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/a/a/c/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */