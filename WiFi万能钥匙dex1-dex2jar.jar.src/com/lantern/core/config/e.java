package com.lantern.core.config;

import com.bluefay.b.h;
import org.json.JSONObject;

final class e
  implements com.bluefay.b.a
{
  e(d paramd) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    if ((paramInt == 1) || (paramInt == 10)) {}
    for (;;)
    {
      try
      {
        com.lantern.analytics.a.e().onEvent("cfgreqf");
        return;
      }
      catch (Exception paramString)
      {
        Object localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>("parse json data error,response:");
        h.a(paramObject, paramString);
        d.b(this.a);
        continue;
        paramString = (String)paramObject;
        localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>("config:");
        h.a(paramString, new Object[0]);
        try
        {
          localObject = new org/json/JSONObject;
          ((JSONObject)localObject).<init>(paramString);
          paramString = ((JSONObject)localObject).getJSONObject("config");
          if (paramString != null) {
            continue;
          }
        }
        catch (Exception paramString)
        {
          h.a(paramString);
          com.lantern.analytics.a.e().onEvent("cfgana0");
        }
        continue;
        if (!d.a(this.a).a(paramString, false)) {
          continue;
        }
        com.lantern.analytics.a.e().onEvent("cfgdis1y");
        d.b(this.a);
        continue;
        com.lantern.analytics.a.e().onEvent("cfgdis1n");
        continue;
      }
      finally
      {
        d.b(this.a);
      }
      if (paramInt == 0) {
        com.lantern.analytics.a.e().onEvent("cfgdis0");
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/config/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */