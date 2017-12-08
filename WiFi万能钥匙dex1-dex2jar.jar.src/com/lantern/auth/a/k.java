package com.lantern.auth.a;

import com.lantern.auth.g;
import org.json.JSONException;
import org.json.JSONObject;

final class k
  implements Runnable
{
  k(a parama, int paramInt, String paramString1, Object paramObject, String paramString2) {}
  
  public final void run()
  {
    Object localObject = "2";
    if (this.a == 1)
    {
      com.lantern.analytics.a.e().onEvent("umcsuc");
      localObject = "1";
      com.lantern.analytics.a.e().onEvent("LoginOn", g.a(a.c(this.e), this.b, (String)localObject, a.m(this.e)));
      localObject = (JSONObject)this.c;
      if (localObject != null) {
        break label146;
      }
      localObject = new JSONObject();
    }
    label146:
    for (;;)
    {
      try
      {
        ((JSONObject)localObject).put("lastPath", this.b);
        a.r(this.e).a(this.a, this.d, localObject);
        return;
        if (this.a == 2)
        {
          com.lantern.analytics.a.e().onEvent("umcfa");
          localObject = "4";
          break;
        }
        com.lantern.analytics.a.e().onEvent("umcfa");
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */