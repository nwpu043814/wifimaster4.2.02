package com.linksure.apservice.a.a.c;

import org.json.JSONObject;

public final class k
{
  public static final class a
    extends a
  {
    private String b;
    private int c = -1;
    private int d = -1;
    
    public a(String paramString, int paramInt1, int paramInt2)
    {
      this.b = paramString;
      this.c = paramInt1;
      this.d = paramInt2;
    }
    
    public final String c()
    {
      return "02300202";
    }
    
    public final String e()
    {
      try
      {
        localObject1 = a();
        ((JSONObject)localObject1).put("serviceAccountId", this.b);
        if (this.c != -1) {
          ((JSONObject)localObject1).put("pushSwitch", this.c);
        }
        if (this.d != -1) {
          ((JSONObject)localObject1).put("replySwitch", this.d);
        }
        localObject1 = ((JSONObject)localObject1).toString();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject1;
          localException.printStackTrace();
          Object localObject2 = null;
        }
      }
      return (String)localObject1;
    }
  }
  
  public static class b
    extends b<Boolean>
  {
    public final void a(JSONObject paramJSONObject) {}
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/a/a/c/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */