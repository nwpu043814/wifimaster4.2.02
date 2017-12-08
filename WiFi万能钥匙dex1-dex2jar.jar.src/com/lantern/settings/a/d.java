package com.lantern.settings.a;

import android.os.AsyncTask;
import com.bluefay.b.h;
import com.lantern.core.c;
import com.lantern.core.model.g;
import com.lantern.core.o;
import com.lantern.core.s;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends AsyncTask<Void, Integer, Void>
{
  private com.bluefay.b.a a;
  private g b;
  private int c;
  private String d;
  
  public d(com.bluefay.b.a parama)
  {
    this.a = parama;
    this.b = new g();
  }
  
  private Void a()
  {
    if (!com.bluefay.a.a.c(com.bluefay.d.a.getAppContext())) {
      this.c = 10;
    }
    for (;;)
    {
      return null;
      c.getServer().f("00200409");
      String str = s.a();
      Object localObject = c.getServer().s();
      ((HashMap)localObject).put("pid", "00200409");
      localObject = c.getServer().b("00200409", (HashMap)localObject);
      this.c = 1;
      str = com.bluefay.b.d.a(str, (Map)localObject);
      if ((str == null) || (str.length() == 0)) {
        this.c = 10;
      } else {
        try
        {
          localObject = new org/json/JSONObject;
          ((JSONObject)localObject).<init>(str);
          if (!"0".equals(((JSONObject)localObject).getString("retCd"))) {
            this.c = 0;
          }
          if (((JSONObject)localObject).has("retMsg")) {
            this.d = ((JSONObject)localObject).getString("retMsg");
          }
          if (((JSONObject)localObject).has("uhid")) {
            this.b.b = ((JSONObject)localObject).optString("uhid");
          }
          if (((JSONObject)localObject).has("nickName")) {
            this.b.d = ((JSONObject)localObject).optString("nickName");
          }
          if (((JSONObject)localObject).has("sex")) {
            this.b.e = ((JSONObject)localObject).optString("sex");
          }
          if (((JSONObject)localObject).has("mobile")) {
            this.b.a = ((JSONObject)localObject).optString("mobile");
          }
          if (((JSONObject)localObject).has("countryCode")) {
            this.b.f = ((JSONObject)localObject).optString("countryCode");
          }
          if (((JSONObject)localObject).has("headImgUrl")) {
            this.b.g = ((JSONObject)localObject).optString("headImgUrl");
          }
          h.a("retcode=%s,retmsg=%s", new Object[] { Integer.valueOf(this.c), this.d });
        }
        catch (JSONException localJSONException)
        {
          h.a(localJSONException);
          this.c = 30;
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */