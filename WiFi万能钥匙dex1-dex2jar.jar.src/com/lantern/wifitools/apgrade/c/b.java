package com.lantern.wifitools.apgrade.c;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.bluefay.b.d;
import com.bluefay.b.h;
import com.lantern.core.c;
import com.lantern.core.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b
  extends AsyncTask<String, Integer, Integer>
{
  public static String a = "01000501:01000104";
  private com.bluefay.b.a b;
  private String c;
  private String d;
  private com.lantern.wifitools.apgrade.b.a e;
  private String f = "";
  
  public b(String paramString1, String paramString2, com.bluefay.b.a parama)
  {
    this.c = paramString1;
    this.d = paramString2;
    this.b = parama;
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
      Object localObject2 = com.bluefay.d.a.getAppContext();
      localObject1 = c.getServer().s();
      this.f = com.lantern.wifitools.apgrade.a.a.a((Context)localObject2, this.c, this.d);
      if (TextUtils.isEmpty(this.f)) {}
      for (a = "01000501:01000104";; a = "01000501")
      {
        ((HashMap)localObject1).put("pid", a);
        ((HashMap)localObject1).put("ssid", this.c);
        ((HashMap)localObject1).put("bssid", this.d);
        localObject1 = c.getServer().b(a, (HashMap)localObject1);
        localObject2 = new d("http://apcomment.51y5.net/ap-comment/fa.sec").c(d.a((Map)localObject1));
        if (((String)localObject2).length() != 0) {
          break label149;
        }
        localObject1 = Integer.valueOf(10);
        break;
      }
      label149:
      h.a("JSON:" + (String)localObject2, new Object[0]);
      try
      {
        localObject1 = new org/json/JSONObject;
        ((JSONObject)localObject1).<init>((String)localObject2);
        String str = ((JSONObject)localObject1).optString("retCd");
        if (!"0".equals(str))
        {
          localObject2 = new com/lantern/wifitools/apgrade/b/a;
          ((com.lantern.wifitools.apgrade.b.a)localObject2).<init>();
          this.e = ((com.lantern.wifitools.apgrade.b.a)localObject2);
          this.e.c(str);
          if (((JSONObject)localObject1).has("retMsg"))
          {
            this.e.b(((JSONObject)localObject1).optString("retMsg"));
            h.a("retcode=%s,retmsg=%s", new Object[] { Integer.valueOf(i), ((JSONObject)localObject1).optString("retMsg") });
          }
          if (TextUtils.isEmpty(this.f))
          {
            if (((JSONObject)localObject1).has("01000501"))
            {
              localObject2 = ((JSONObject)localObject1).optJSONObject("01000501");
              if (((JSONObject)localObject2).has("score")) {
                this.e.a(((JSONObject)localObject2).optString("score"));
              }
            }
            j = i;
            if (((JSONObject)localObject1).has("01000104"))
            {
              localObject1 = ((JSONObject)localObject1).optJSONObject("01000104");
              j = i;
              if (((JSONObject)localObject1).has("comment"))
              {
                localObject1 = ((JSONObject)localObject1).optJSONObject("comment");
                if (((JSONObject)localObject1).has("star")) {
                  this.e.a(((JSONObject)localObject1).optInt("star"));
                }
                if (((JSONObject)localObject1).has("comment")) {
                  this.e.d(((JSONObject)localObject1).optString("comment"));
                }
                j = i;
                if (((JSONObject)localObject1).has("comment"))
                {
                  j = i;
                  if (((JSONObject)localObject1).has("star"))
                  {
                    com.lantern.wifitools.apgrade.a.a.a(com.bluefay.d.a.getAppContext(), this.c, this.d, String.format("{\"comment\":\"%s\",\"star\":%s }", new Object[] { ((JSONObject)localObject1).optString("comment"), Integer.valueOf(((JSONObject)localObject1).optInt("star")) }));
                    j = i;
                  }
                }
              }
            }
          }
          for (;;)
          {
            localObject1 = Integer.valueOf(j);
            break;
            j = i;
            if (((JSONObject)localObject1).has("score"))
            {
              this.e.a(((JSONObject)localObject1).optString("score"));
              localObject1 = new org/json/JSONObject;
              ((JSONObject)localObject1).<init>(this.f);
              j = i;
              if (((JSONObject)localObject1).has("comment"))
              {
                if (((JSONObject)localObject1).has("star")) {
                  this.e.a(((JSONObject)localObject1).optInt("star"));
                }
                j = i;
                if (((JSONObject)localObject1).has("comment"))
                {
                  this.e.d(((JSONObject)localObject1).optString("comment"));
                  j = i;
                }
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          h.a(localException);
          int j = 30;
          continue;
          i = 1;
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/apgrade/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */