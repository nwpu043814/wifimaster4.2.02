package com.lantern.wifilocating.push.a.c;

import org.json.JSONArray;
import org.json.JSONObject;

public final class a
  implements Runnable
{
  private String a;
  private JSONObject b;
  private JSONArray c;
  
  public a(String paramString, JSONArray paramJSONArray)
  {
    this.a = paramString;
    this.c = paramJSONArray;
  }
  
  public a(String paramString, JSONObject paramJSONObject)
  {
    this.a = paramString;
    this.b = paramJSONObject;
  }
  
  public final void run()
  {
    if (this.b != null) {
      com.lantern.wifilocating.push.a.a.c().a().a(this.a, this.b);
    }
    for (;;)
    {
      return;
      if (this.c != null) {
        com.lantern.wifilocating.push.a.a.c().a().a(this.a, this.c);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/a/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */