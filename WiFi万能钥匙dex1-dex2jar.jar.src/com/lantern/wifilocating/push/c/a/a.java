package com.lantern.wifilocating.push.c.a;

import org.json.JSONObject;

public abstract class a
{
  private long a = -1L;
  
  protected abstract void a(JSONObject paramJSONObject);
  
  public final void b(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optLong("cv", this.a);
    a(paramJSONObject);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/c/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */