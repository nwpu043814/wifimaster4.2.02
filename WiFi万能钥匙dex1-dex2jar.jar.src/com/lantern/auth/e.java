package com.lantern.auth;

import com.lantern.core.c;
import com.lantern.core.config.AuthConfig;
import com.lantern.core.o;
import org.json.JSONObject;

final class e
  implements com.bluefay.b.a
{
  e(a parama) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    String str1 = "failed";
    if (paramInt == 1) {
      str1 = "success";
    }
    com.lantern.analytics.a.e().onEvent("auth_auto", g.a(Integer.toString(this.a.a.e()), str1, null));
    if (paramInt == 1) {}
    for (str1 = "1";; str1 = "2")
    {
      String str2 = "";
      if (paramObject != null) {
        str2 = ((JSONObject)paramObject).optString("lastPath");
      }
      com.lantern.analytics.a.e().onEvent("LoginEnd", g.a("app_auto", str2, str1, c.getServer().k()));
      a.d(this.a).a(paramInt, paramString, paramObject);
      return;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */