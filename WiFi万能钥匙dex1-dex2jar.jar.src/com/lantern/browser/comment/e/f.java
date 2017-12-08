package com.lantern.browser.comment.e;

import android.os.AsyncTask;
import com.bluefay.b.a;
import com.bluefay.b.d;
import com.bluefay.b.h;
import com.lantern.browser.comment.d.l;
import com.lantern.core.c;
import com.lantern.core.o;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f
  extends AsyncTask<Void, Void, Void>
{
  private String a;
  private a b;
  private int c;
  private String d;
  private Object e;
  
  public f(String paramString, a parama)
  {
    this.a = paramString;
    this.b = parama;
  }
  
  private Void a()
  {
    Object localObject2 = c.getServer().s();
    ((HashMap)localObject2).put("newsId", this.a);
    ((HashMap)localObject2).put("pageSize", "100");
    Object localObject1 = com.lantern.core.f.b();
    if (localObject1 != null) {
      localObject1 = String.format("%s%s", new Object[] { localObject1, "/comment/comment/replyList.do" });
    }
    for (;;)
    {
      localObject2 = d.a((String)localObject1, (Map)localObject2);
      this.c = 0;
      try
      {
        localObject1 = new org/json/JSONObject;
        ((JSONObject)localObject1).<init>((String)localObject2);
        if ("0".equals(((JSONObject)localObject1).optString("retCd")))
        {
          this.e = l.a(((JSONObject)localObject1).optJSONArray("result"), this.a);
          this.c = 1;
        }
        for (;;)
        {
          return null;
          localObject1 = String.format("%s%s", new Object[] { "http://comment.51y5.net", "/comment/comment/replyList.do" });
          break;
          this.d = ((JSONObject)localObject1).getString("retMsg");
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          this.c = 0;
          h.a(localException);
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/e/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */