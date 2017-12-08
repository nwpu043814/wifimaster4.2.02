package com.lantern.wifilocating.push.g.c;

import com.lantern.wifilocating.push.util.h;
import org.json.JSONObject;

final class d
  extends Thread
{
  d(c paramc, JSONObject paramJSONObject) {}
  
  public final void run()
  {
    try
    {
      this.b.b(this.a);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        h.a(localThrowable);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/g/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */