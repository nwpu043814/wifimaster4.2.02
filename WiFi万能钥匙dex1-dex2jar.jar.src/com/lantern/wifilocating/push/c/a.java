package com.lantern.wifilocating.push.c;

import org.json.JSONObject;

public class a
  extends com.lantern.wifilocating.push.c.a.a
{
  private long a = 285000L;
  private String b;
  
  public final long a()
  {
    return this.a;
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      this.a = paramJSONObject.optLong("heartbeat.interval", this.a);
      this.b = paramJSONObject.optString("url");
    }
  }
  
  public final String b()
  {
    return this.b;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */