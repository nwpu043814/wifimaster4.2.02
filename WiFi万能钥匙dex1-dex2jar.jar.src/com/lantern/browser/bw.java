package com.lantern.browser;

import android.content.Context;
import com.bluefay.a.e;
import com.bluefay.b.d;
import com.bluefay.b.h;
import com.lantern.core.c;
import com.lantern.core.f;
import com.lantern.core.g;
import com.lantern.core.o;
import java.util.HashMap;
import java.util.Map;

final class bw
  extends Thread
{
  bw(Context paramContext, String paramString1, String paramString2) {}
  
  public final void run()
  {
    HashMap localHashMap;
    if (e.c(this.a))
    {
      localHashMap = new HashMap();
      localObject = c.getServer();
      localHashMap.put("appId", ((o)localObject).k());
      localHashMap.put("url", this.b);
      localHashMap.put("httpCode", this.c);
      localHashMap.put("sign", g.a(localHashMap, ((o)localObject).n()));
      localObject = f.a().a("cdshost");
      if (localObject == null) {
        break label119;
      }
    }
    label119:
    for (Object localObject = String.format("%s%s", new Object[] { localObject, "/http_error.do" });; localObject = String.format("%s%s", new Object[] { "https://cds.51y5.net", "/http_error.do" }))
    {
      h.a(d.a((String)localObject, localHashMap));
      return;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/bw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */