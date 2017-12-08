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

public final class g
  extends AsyncTask<Void, Void, Void>
{
  private com.bluefay.b.a a;
  private int b;
  private String c;
  private String d;
  private JSONObject e = null;
  
  public g(String paramString, com.bluefay.b.a parama)
  {
    this.a = parama;
    this.d = paramString;
  }
  
  private Void a()
  {
    if (!com.bluefay.a.a.c(com.bluefay.d.a.getAppContext())) {
      this.b = 10;
    }
    for (;;)
    {
      return null;
      c.getServer().f("05000507");
      String str = com.lantern.auth.h.d();
      Object localObject = this.d;
      HashMap localHashMap = c.getServer().s();
      localHashMap.put("pid", "05000507");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        localHashMap.put("headImgUrl", localObject);
      }
      localObject = c.getServer().b("05000507", localHashMap);
      this.b = 1;
      str = d.a(str, (Map)localObject);
      if ((str == null) || (str.length() == 0)) {
        this.b = 10;
      } else {
        try
        {
          localObject = new org/json/JSONObject;
          ((JSONObject)localObject).<init>(str);
          this.e = ((JSONObject)localObject);
          if (!"0".equals(this.e.getString("retCd"))) {
            this.b = 0;
          }
          if (this.e.has("retMsg")) {
            this.c = this.e.getString("retMsg");
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


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */