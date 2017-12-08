package com.lantern.wifitools.apgrade.c;

import android.os.AsyncTask;
import com.bluefay.b.d;
import com.bluefay.b.h;
import com.lantern.core.c;
import com.lantern.core.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  extends AsyncTask<String, Integer, Integer>
{
  private com.bluefay.b.a a;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private com.lantern.wifitools.apgrade.b.a h;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, com.bluefay.b.a parama)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.e = paramString4;
    this.f = paramString5;
    this.g = paramString6;
    this.d = paramString3;
    this.a = parama;
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
      com.bluefay.d.a.getAppContext();
      localObject1 = c.getServer().s();
      ((HashMap)localObject1).put("pid", "01000101");
      ((HashMap)localObject1).put("ssid", this.b);
      ((HashMap)localObject1).put("bssid", this.c);
      ((HashMap)localObject1).put("comment", this.d);
      ((HashMap)localObject1).put("star", this.e);
      ((HashMap)localObject1).put("nickname", this.f);
      ((HashMap)localObject1).put("userImg", this.g);
      Object localObject2 = c.getServer().b("01000101", (HashMap)localObject1);
      localObject1 = new d("http://apcomment.51y5.net/ap-comment/fa.sec");
      localObject2 = d.a((Map)localObject2);
      h.a("mapStr:" + (String)localObject2, new Object[0]);
      localObject2 = ((d)localObject1).c((String)localObject2);
      if (((String)localObject2).length() == 0)
      {
        localObject1 = Integer.valueOf(10);
        continue;
      }
      h.a("JSON:" + (String)localObject2, new Object[0]);
      try
      {
        localObject1 = new org/json/JSONObject;
        ((JSONObject)localObject1).<init>((String)localObject2);
        String str = ((JSONObject)localObject1).getString("retCd");
        if (!"0".equals(str))
        {
          localObject2 = new com/lantern/wifitools/apgrade/b/a;
          ((com.lantern.wifitools.apgrade.b.a)localObject2).<init>();
          this.h = ((com.lantern.wifitools.apgrade.b.a)localObject2);
          this.h.c(str);
          j = i;
          if (((JSONObject)localObject1).has("retMsg"))
          {
            this.h.b(((JSONObject)localObject1).getString("retMsg"));
            h.a("retcode=%s,retmsg=%s", new Object[] { Integer.valueOf(i), ((JSONObject)localObject1).getString("retMsg") });
            j = i;
          }
          localObject1 = Integer.valueOf(j);
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          h.a(localJSONException);
          int j = 30;
          continue;
          i = 1;
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/apgrade/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */