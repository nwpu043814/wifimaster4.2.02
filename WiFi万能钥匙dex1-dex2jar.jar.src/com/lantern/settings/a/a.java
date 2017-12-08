package com.lantern.settings.a;

import android.util.Log;
import com.lantern.core.c;
import com.lantern.core.f;
import com.lantern.core.o;
import java.util.HashMap;
import org.json.JSONObject;

public final class a
  extends Thread
{
  private com.bluefay.b.a a;
  private com.bluefay.b.a b = new b(this);
  
  public a(com.bluefay.b.a parama)
  {
    this.a = parama;
  }
  
  public final void run()
  {
    if (!c.getServer().j()) {
      this.b.a(0, null, null);
    }
    for (;;)
    {
      return;
      if (com.bluefay.a.d.a(c.getAppContext(), "WkServiceAccount", c.getServer().h()))
      {
        this.b.a(1, null, null);
      }
      else
      {
        if (com.bluefay.a.a.c(c.getAppContext())) {
          break;
        }
        this.b.a(10, null, null);
      }
    }
    c.getServer().f("02300304");
    String str = f.a(c.getAppContext()).a("apshost");
    if (str != null) {}
    Object localObject;
    for (str = String.format("%s%s", new Object[] { str, "/serviceaccount/fa.sec" });; str = String.format("%s%s", new Object[] { "http://wifiservice.51y5.net", "/serviceaccount/fa.sec" }))
    {
      localObject = c.getServer().s();
      ((HashMap)localObject).put("pid", "02300304");
      str = com.bluefay.b.d.a(str, c.getServer().b("02300304", (HashMap)localObject));
      if ((str != null) && (str.length() != 0)) {
        break label203;
      }
      this.b.a(10, null, null);
      break;
    }
    for (;;)
    {
      try
      {
        label203:
        JSONObject localJSONObject = new org/json/JSONObject;
        localJSONObject.<init>(str);
        localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>("aps=");
        Log.i("king", str);
        if (!"0".equals(localJSONObject.optString("retCd"))) {
          continue;
        }
        com.bluefay.a.d.a(c.getAppContext(), "WkServiceAccount", c.getServer().h(), true);
        i = 1;
      }
      catch (Exception localException)
      {
        int i = 30;
        continue;
      }
      this.b.a(i, null, null);
      break;
      i = 0;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */