package com.lantern.settings.a;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.bluefay.b.d;
import com.lantern.core.c;
import com.lantern.core.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class f
  extends AsyncTask<Void, Integer, Void>
{
  private com.bluefay.b.a a;
  private int b;
  private String c;
  private String d;
  private String e;
  private JSONObject f = null;
  
  public f(String paramString, Boolean paramBoolean, com.bluefay.b.a parama)
  {
    this.a = parama;
    if (paramBoolean != null) {
      if (!paramBoolean.booleanValue()) {
        break label39;
      }
    }
    label39:
    for (paramBoolean = "M";; paramBoolean = "F")
    {
      this.e = paramBoolean;
      this.d = paramString;
      return;
    }
  }
  
  private Void a()
  {
    if (!com.bluefay.a.a.c(com.bluefay.d.a.getAppContext())) {
      this.b = 10;
    }
    for (;;)
    {
      return null;
      c.getServer().f("05000506");
      Object localObject1 = com.lantern.auth.h.d();
      String str2 = this.d;
      String str1 = this.e;
      Object localObject2 = c.getServer().s();
      ((HashMap)localObject2).put("pid", "05000506");
      if (!TextUtils.isEmpty(str2)) {
        ((HashMap)localObject2).put("nickName", str2);
      }
      if (!TextUtils.isEmpty(str1)) {
        ((HashMap)localObject2).put("sex", str1);
      }
      localObject2 = c.getServer().b("05000506", (HashMap)localObject2);
      this.b = 1;
      localObject2 = d.a((String)localObject1, (Map)localObject2);
      if ((localObject2 == null) || (((String)localObject2).length() == 0)) {
        this.b = 10;
      } else {
        try
        {
          localObject1 = new org/json/JSONObject;
          ((JSONObject)localObject1).<init>((String)localObject2);
          this.f = ((JSONObject)localObject1);
          if (!"0".equals(this.f.getString("retCd"))) {
            this.b = 0;
          }
          if (this.f.has("retMsg")) {
            this.c = this.f.getString("retMsg");
          }
          com.bluefay.b.h.a("retcode=%s,retmsg=%s", new Object[] { Integer.valueOf(this.b), this.c });
        }
        catch (JSONException localJSONException)
        {
          com.bluefay.b.h.a(localJSONException);
          this.b = 30;
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */