package com.lantern.auth.ui;

import com.lantern.auth.WkParamsConfig;
import com.lantern.auth.g;

final class h
  implements com.bluefay.b.a
{
  h(AuthActivity paramAuthActivity) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    if (paramInt == 1) {
      AuthActivity.l(this.a);
    }
    for (;;)
    {
      return;
      com.lantern.analytics.a.e().onEvent("oauth_ul", g.a("1", "failed", AuthActivity.b(this.a).mThirdAppId));
      AuthActivity.j(this.a);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/ui/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */