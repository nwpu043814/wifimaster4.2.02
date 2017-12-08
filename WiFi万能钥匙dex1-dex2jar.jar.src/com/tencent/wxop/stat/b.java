package com.tencent.wxop.stat;

import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  private long K = 0L;
  private int L = 0;
  private String M = "";
  private String c = "";
  private int g = 0;
  
  public final void a(long paramLong)
  {
    this.K = paramLong;
  }
  
  public final JSONObject i()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("tm", this.K);
      localJSONObject.put("st", this.g);
      if (this.c != null) {
        localJSONObject.put("dm", this.c);
      }
      localJSONObject.put("pt", this.L);
      if (this.M != null) {
        localJSONObject.put("rip", this.M);
      }
      localJSONObject.put("ts", System.currentTimeMillis() / 1000L);
    }
    catch (JSONException localJSONException)
    {
      for (;;) {}
    }
    return localJSONObject;
  }
  
  public final void k(String paramString)
  {
    this.M = paramString;
  }
  
  public final void setDomain(String paramString)
  {
    this.c = paramString;
  }
  
  public final void setPort(int paramInt)
  {
    this.L = paramInt;
  }
  
  public final void setStatusCode(int paramInt)
  {
    this.g = paramInt;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/wxop/stat/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */