package com.lantern.auth.c;

import android.content.Context;
import android.os.AsyncTask;
import com.bluefay.b.d;
import com.lantern.core.c;
import com.lantern.core.k;
import com.lantern.core.o;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends AsyncTask<String, Integer, Integer>
{
  private com.bluefay.b.a a;
  private com.lantern.auth.b.b b;
  private String c;
  private String d;
  
  public b(com.bluefay.b.a parama, String paramString1, String paramString2)
  {
    this.a = parama;
    this.b = new com.lantern.auth.b.b();
    this.d = paramString2;
    this.c = paramString1;
  }
  
  private Integer a()
  {
    int i = 0;
    Object localObject1;
    if (!com.bluefay.a.a.c(com.bluefay.d.a.getAppContext())) {
      localObject1 = Integer.valueOf(10);
    }
    for (;;)
    {
      return (Integer)localObject1;
      c.getServer().f("00200404");
      String str = com.lantern.auth.h.a();
      localObject1 = com.bluefay.d.a.getAppContext();
      Object localObject2 = c.getServer().s();
      ((HashMap)localObject2).put("countryCode", com.lantern.auth.utils.a.a((Context)localObject1));
      ((HashMap)localObject2).put("netOperator", k.f((Context)localObject1));
      localObject2 = d.a(str, c.getServer().b("00200404", (HashMap)localObject2));
      if ((localObject2 == null) || (((String)localObject2).length() == 0))
      {
        localObject1 = Integer.valueOf(10);
        continue;
      }
      com.bluefay.b.h.a("JSON:" + (String)localObject2, new Object[0]);
      try
      {
        localObject1 = new org/json/JSONObject;
        ((JSONObject)localObject1).<init>((String)localObject2);
        localObject2 = ((JSONObject)localObject1).getString("retCd");
        if (!"0".equals(localObject2))
        {
          this.b.a((String)localObject2);
          if (((JSONObject)localObject1).has("retMsg"))
          {
            this.b.d(((JSONObject)localObject1).getString("retMsg"));
            com.bluefay.b.h.a("retcode=%s,retmsg=%s", new Object[] { Integer.valueOf(i), ((JSONObject)localObject1).getString("retMsg") });
          }
          if (((JSONObject)localObject1).has("smsContent")) {
            this.b.b(((JSONObject)localObject1).getString("smsContent"));
          }
          j = i;
          if (((JSONObject)localObject1).has("serviceno"))
          {
            this.b.c(((JSONObject)localObject1).getString("serviceno"));
            j = i;
          }
          localObject1 = Integer.valueOf(j);
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          com.bluefay.b.h.a(localJSONException);
          int j = 30;
          continue;
          i = 1;
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */