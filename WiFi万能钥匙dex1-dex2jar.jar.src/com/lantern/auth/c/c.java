package com.lantern.auth.c;

import android.content.Context;
import android.os.AsyncTask;
import com.bluefay.b.d;
import com.lantern.core.k;
import com.lantern.core.o;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends AsyncTask<String, Integer, Integer>
{
  private com.bluefay.b.a a;
  private com.lantern.auth.b.a b;
  private String c = "";
  private String d = "";
  
  public c(com.bluefay.b.a parama, String paramString1, String paramString2)
  {
    this.a = parama;
    this.b = new com.lantern.auth.b.a();
    this.c = paramString1;
    this.d = paramString2;
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
      com.lantern.core.c.getServer().f("00200401");
      Object localObject3;
      try
      {
        Thread.sleep(3000L);
        String str = com.lantern.auth.h.a();
        localObject1 = com.bluefay.d.a.getAppContext();
        localObject3 = com.lantern.core.c.getServer().s();
        ((HashMap)localObject3).put("sim", k.d((Context)localObject1));
        localObject3 = d.a(str, com.lantern.core.c.getServer().b("00200401", (HashMap)localObject3));
        if ((localObject3 == null) || (((String)localObject3).length() == 0)) {
          localObject1 = Integer.valueOf(10);
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
        com.bluefay.b.h.a("JSON:" + (String)localObject3, new Object[0]);
      }
      try
      {
        Object localObject2 = new org/json/JSONObject;
        ((JSONObject)localObject2).<init>((String)localObject3);
        if (!"0".equals(((JSONObject)localObject2).getString("retCd")))
        {
          com.bluefay.b.h.a("retcode=%s", new Object[] { Integer.valueOf(i) });
          j = i;
          if (i == 1)
          {
            if (((JSONObject)localObject2).has("sessionId")) {
              this.b.a = ((JSONObject)localObject2).getString("sessionId");
            }
            if (((JSONObject)localObject2).has("accessToken")) {
              this.b.b = ((JSONObject)localObject2).getString("accessToken");
            }
            if (((JSONObject)localObject2).has("uhid")) {
              this.b.c = ((JSONObject)localObject2).getString("uhid");
            }
            if (((JSONObject)localObject2).has("mobile")) {
              this.b.d = ((JSONObject)localObject2).getString("mobile");
            }
            if (((JSONObject)localObject2).has("nickName")) {
              this.b.e = ((JSONObject)localObject2).getString("nickName");
            }
            if (((JSONObject)localObject2).has("headImgUrl")) {
              this.b.f = ((JSONObject)localObject2).optString("headImgUrl");
            }
            j = i;
            if (((JSONObject)localObject2).has("userToken"))
            {
              this.b.g = ((JSONObject)localObject2).optString("userToken");
              j = i;
            }
          }
          localObject2 = Integer.valueOf(j);
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


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */