package com.lantern.wifilocating.push.c;

import com.lantern.wifilocating.push.c.a.a;
import org.json.JSONObject;

public class c
  extends a
{
  private boolean a = true;
  
  protected final void a(JSONObject paramJSONObject)
  {
    boolean bool = true;
    if (paramJSONObject == null) {
      return;
    }
    if (paramJSONObject.optInt("switch", 1) == 1) {}
    for (;;)
    {
      this.a = bool;
      break;
      bool = false;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */