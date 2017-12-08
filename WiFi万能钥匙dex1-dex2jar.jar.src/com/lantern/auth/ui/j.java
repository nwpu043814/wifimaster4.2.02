package com.lantern.auth.ui;

import com.lantern.auth.WkParamsConfig;
import com.lantern.auth.g;
import org.json.JSONObject;

final class j
  implements com.bluefay.b.a
{
  j(AuthActivity paramAuthActivity) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    if (paramInt == 1)
    {
      paramString = "success";
      com.lantern.analytics.a.e().onEvent("oauth_cmcc", g.a(null, paramString, AuthActivity.b(this.a).mThirdAppId));
      if (paramObject != null)
      {
        paramString = (JSONObject)paramObject;
        AuthActivity.a(this.a, paramString.optString("lastPath"));
      }
      if (paramInt != 1) {
        break label92;
      }
      AuthActivity.a(this.a, "cmcc");
      AuthActivity.b(this.a, "1");
      AuthActivity.h(this.a);
    }
    for (;;)
    {
      return;
      paramString = "failed";
      break;
      label92:
      AuthActivity.n(this.a);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/ui/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */