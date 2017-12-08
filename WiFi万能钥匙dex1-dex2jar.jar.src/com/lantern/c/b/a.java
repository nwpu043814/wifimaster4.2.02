package com.lantern.c.b;

import android.os.AsyncTask;
import com.bluefay.b.h;
import com.lantern.core.c;
import com.lantern.core.f;
import com.lantern.core.l;
import com.lantern.core.o;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  extends AsyncTask<String, Integer, Integer>
{
  private com.bluefay.b.a a;
  private String b;
  private com.lantern.c.a.a c;
  
  public a(com.bluefay.b.a parama)
  {
    this.a = parama;
  }
  
  private Integer a()
  {
    Object localObject1;
    if (!com.bluefay.a.a.c(com.bluefay.d.a.getAppContext())) {
      localObject1 = Integer.valueOf(10);
    }
    for (;;)
    {
      return (Integer)localObject1;
      c.getServer().f("00600101");
      localObject1 = f.b();
      if (localObject1 != null) {}
      Object localObject2;
      for (localObject1 = String.format("%s%s", new Object[] { localObject1, "/app/fa.sec" });; localObject1 = String.format("%s%s", new Object[] { "https://app.51y5.net", "/app/fa.sec0" }))
      {
        com.bluefay.d.a.getAppContext();
        localObject2 = c.getServer().s();
        ((HashMap)localObject2).put("pid", "00600101");
        localObject2 = l.b((String)localObject1, c.getServer().b("00600101", (HashMap)localObject2));
        if ((localObject2 != null) && (((String)localObject2).length() != 0)) {
          break label136;
        }
        localObject1 = Integer.valueOf(10);
        break;
      }
      label136:
      h.a("JSON:" + (String)localObject2, new Object[0]);
      try
      {
        localObject1 = new org/json/JSONObject;
        ((JSONObject)localObject1).<init>((String)localObject2);
        if ("0".equals(((JSONObject)localObject1).getString("retCd"))) {
          break;
        }
        i = 0;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          h.a(localJSONException);
          int j = 30;
          continue;
          int i = 1;
        }
      }
      if (((JSONObject)localObject1).has("retMsg")) {
        this.b = ((JSONObject)localObject1).getString("retMsg");
      }
      h.a("retcode=%s,retmsg=%s", new Object[] { Integer.valueOf(i), this.b });
      j = i;
      if (i == 1)
      {
        localObject2 = new com/lantern/c/a/a;
        ((com.lantern.c.a.a)localObject2).<init>();
        this.c = ((com.lantern.c.a.a)localObject2);
        if (((JSONObject)localObject1).has("verName"))
        {
          this.c.f = ((JSONObject)localObject1).getString("verName");
          this.c.e = ((JSONObject)localObject1).getString("desc");
          this.c.h = ((JSONObject)localObject1).getString("md5");
          this.c.g = ((JSONObject)localObject1).getString("url");
          this.c.b = "1".equals(((JSONObject)localObject1).getString("stat"));
          this.c.c = "0".equals(((JSONObject)localObject1).optString("dlType", "1"));
          localObject1 = ((JSONObject)localObject1).getString("ver");
          this.c.d = Integer.parseInt((String)localObject1);
          this.c.a = false;
        }
        h.a("verCode:%s, forceUpdate:%s, needBackstageDown:%s", new Object[] { Integer.valueOf(this.c.d), Boolean.valueOf(this.c.b), Boolean.valueOf(this.c.c) });
        j = i;
      }
      localObject1 = Integer.valueOf(j);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/c/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */