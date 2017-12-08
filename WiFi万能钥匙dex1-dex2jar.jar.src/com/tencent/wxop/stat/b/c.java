package com.tencent.wxop.stat.b;

import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  private String W = "0";
  private String a = null;
  private String b = null;
  private int bf = 0;
  private String c = null;
  private int cu;
  private long cv = 0L;
  
  public c() {}
  
  public c(String paramString1, String paramString2, int paramInt)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.cu = paramInt;
  }
  
  private JSONObject aq()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      r.a(localJSONObject, "ui", this.a);
      r.a(localJSONObject, "mc", this.b);
      r.a(localJSONObject, "mid", this.W);
      r.a(localJSONObject, "aid", this.c);
      localJSONObject.put("ts", this.cv);
      localJSONObject.put("ver", this.bf);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;) {}
    }
  }
  
  public final String ar()
  {
    return this.b;
  }
  
  public final int as()
  {
    return this.cu;
  }
  
  public final String b()
  {
    return this.a;
  }
  
  public final String toString()
  {
    return aq().toString();
  }
  
  public final void z()
  {
    this.cu = 1;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/wxop/stat/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */