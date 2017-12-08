package com.lantern.browser.comment.e;

import android.os.AsyncTask;
import com.bluefay.b.d;
import com.bluefay.b.h;
import com.lantern.browser.comment.d.l;
import com.lantern.core.c;
import com.lantern.core.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class g
  extends AsyncTask<Void, Void, Void>
{
  private String a;
  private int b;
  private com.bluefay.b.a c;
  private int d;
  private String e;
  private Object f;
  
  public g(String paramString, int paramInt, com.bluefay.b.a parama)
  {
    this.a = paramString;
    this.b = paramInt;
    this.c = parama;
  }
  
  private Void a()
  {
    Object localObject = c.getServer().s();
    ((HashMap)localObject).put("newsId", this.a);
    ((HashMap)localObject).put("pageSize", "20");
    ((HashMap)localObject).put("sequence", String.valueOf(this.b));
    localObject = d.a(com.lantern.browser.a.a(), (Map)localObject);
    this.d = 0;
    try
    {
      JSONObject localJSONObject = new org/json/JSONObject;
      localJSONObject.<init>((String)localObject);
      if ("0".equals(localJSONObject.optString("retCd")))
      {
        this.d = 1;
        this.f = l.a(localJSONObject.optJSONObject("result"), "recentComments", this.a);
      }
      for (;;)
      {
        return null;
        this.e = localJSONObject.getString("retMsg");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.a(localException);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/e/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */