package com.lantern.core.config.a;

import android.os.AsyncTask;
import com.bluefay.b.h;
import com.lantern.core.c;
import com.lantern.core.e;
import com.lantern.core.o;
import java.util.HashMap;
import org.json.JSONObject;

public final class a
  extends AsyncTask<Void, Void, Integer>
{
  private com.bluefay.b.a a;
  private String b;
  private JSONObject c;
  
  public a(com.bluefay.b.a parama, JSONObject paramJSONObject)
  {
    this.a = parama;
    this.c = paramJSONObject;
  }
  
  private Integer a()
  {
    int i = 0;
    c.getServer().f("00100103");
    Object localObject2 = c.getServer();
    Object localObject1 = com.lantern.core.c.a.a();
    localObject2 = ((o)localObject2).s();
    ((HashMap)localObject2).put("pid", "00100103");
    ((HashMap)localObject2).put("cate", "config");
    ((HashMap)localObject2).put("fp", this.c.toString());
    String str = e.a((String)localObject1, c.getServer().a("00100103", (HashMap)localObject2));
    if ((str == null) || (str.length() == 0)) {
      localObject1 = Integer.valueOf(10);
    }
    for (;;)
    {
      return (Integer)localObject1;
      h.a("JSON:" + str, new Object[0]);
      this.b = str;
      localObject1 = null;
      try
      {
        localObject2 = new org/json/JSONObject;
        ((JSONObject)localObject2).<init>(str);
        if (!"0".equals(((JSONObject)localObject2).getString("retCd")))
        {
          if (((JSONObject)localObject2).has("retMsg")) {
            localObject1 = ((JSONObject)localObject2).getString("retMsg");
          }
          h.a("retcode=%s,retmsg=%s", new Object[] { Integer.valueOf(i), localObject1 });
          localObject1 = Integer.valueOf(i);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          h.a(localException);
          i = 30;
          continue;
          i = 1;
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/config/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */