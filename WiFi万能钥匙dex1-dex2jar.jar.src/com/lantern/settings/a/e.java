package com.lantern.settings.a;

import android.os.AsyncTask;
import com.bluefay.b.d;
import com.bluefay.b.h;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
  extends AsyncTask<Void, Integer, Void>
{
  private static String d = "http://master.lianwifi.com/api/upnickname";
  private String a;
  private String b;
  private String c;
  private int e;
  private String f;
  
  public e(String paramString1, String paramString2, String paramString3)
  {
    this.a = paramString2;
    this.b = paramString1;
    this.c = paramString3;
  }
  
  private static String a(String paramString)
  {
    try
    {
      String str = URLEncoder.encode(paramString, "utf-8");
      paramString = str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
    return paramString;
  }
  
  private Void a()
  {
    Object localObject = new HashMap();
    ((HashMap)localObject).put("data", com.lantern.settings.b.e.a(String.format("phone=%s&uhid=%s&nickname=%s", new Object[] { this.b, this.a, a(this.c) })));
    this.e = 1;
    String str = d.a(d, (Map)localObject);
    if ((str == null) || (str.length() == 0)) {
      this.e = 10;
    }
    for (;;)
    {
      return null;
      try
      {
        localObject = new org/json/JSONObject;
        ((JSONObject)localObject).<init>(str);
        if (!"0".equals(((JSONObject)localObject).getString("return_code"))) {
          this.e = 0;
        }
        if (((JSONObject)localObject).has("retMsg")) {
          this.f = ((JSONObject)localObject).getString("return_message");
        }
        h.a("retcode=%s,retmsg=%s", new Object[] { Integer.valueOf(this.e), this.f });
      }
      catch (JSONException localJSONException)
      {
        h.a(localJSONException);
        this.e = 30;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */