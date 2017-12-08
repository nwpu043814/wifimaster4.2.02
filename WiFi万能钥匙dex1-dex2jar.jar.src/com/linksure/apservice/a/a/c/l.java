package com.linksure.apservice.a.a.c;

import org.json.JSONObject;

public final class l
{
  public static final class a
    extends a
  {
    static String b = "02300111";
    private String c;
    
    public a(String paramString)
    {
      this.c = paramString;
    }
    
    public final String c()
    {
      return b;
    }
    
    public final String e()
    {
      try
      {
        Object localObject1 = a();
        ((JSONObject)localObject1).put("serviceAccountId", this.c);
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
    extends b<Double>
  {
    static String d = "score";
    
    public final void a(JSONObject paramJSONObject)
    {
      this.c = Double.valueOf(paramJSONObject.optDouble(d));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/a/a/c/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */