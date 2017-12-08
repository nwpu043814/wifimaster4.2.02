package com.lantern.browser.comment.e;

import android.os.AsyncTask;
import com.bluefay.b.a;
import com.bluefay.b.d;
import com.bluefay.b.h;
import com.lantern.core.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends AsyncTask<Void, Void, Void>
{
  private String a;
  private a b;
  private int c;
  private String d;
  private String e;
  
  public c(String paramString, a parama)
  {
    this.a = paramString;
    this.b = parama;
  }
  
  private Void a()
  {
    Object localObject = com.lantern.core.c.getServer().s();
    ((HashMap)localObject).put("bizId", "wk_0003");
    localObject = com.lantern.core.c.getServer().b("", (HashMap)localObject);
    ((HashMap)localObject).put("bizId", "wk_0003");
    String str = d.a("https://fs.51y5.net/fs/uploadImg.action", (Map)localObject, this.a, "image/jpeg");
    this.c = 1;
    if ((str == null) || (str.length() == 0))
    {
      this.c = 10;
      return null;
    }
    for (;;)
    {
      try
      {
        localObject = new org/json/JSONObject;
        ((JSONObject)localObject).<init>(str);
        if ("0".equals(((JSONObject)localObject).getString("retCd"))) {
          break label153;
        }
        this.c = 0;
        this.d = ((JSONObject)localObject).optString("retMsg");
        h.a("retcode=%s,retmsg=%s", new Object[] { Integer.valueOf(this.c), this.d });
      }
      catch (JSONException localJSONException)
      {
        h.a(localJSONException);
        this.c = 30;
      }
      break;
      label153:
      this.e = localJSONException.optString("url");
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/e/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */