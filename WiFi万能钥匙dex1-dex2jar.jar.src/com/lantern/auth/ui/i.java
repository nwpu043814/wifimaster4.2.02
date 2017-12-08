package com.lantern.auth.ui;

import android.text.TextUtils;
import com.lantern.auth.WkParamsConfig;
import com.lantern.core.o;
import com.lantern.core.p;

final class i
  implements com.bluefay.b.a
{
  i(AuthActivity paramAuthActivity) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    int i = 1;
    paramObject = (com.lantern.auth.b.a)paramObject;
    AuthActivity.a(this.a);
    if (paramInt == 1) {
      if ((((com.lantern.auth.b.a)paramObject).a != null) && (((com.lantern.auth.b.a)paramObject).a.length() > 0) && (((com.lantern.auth.b.a)paramObject).c != null) && (((com.lantern.auth.b.a)paramObject).c.length() > 0) && (((com.lantern.auth.b.a)paramObject).d != null) && (((com.lantern.auth.b.a)paramObject).d.length() > 0))
      {
        paramInt = i;
        if ((paramInt == 0) || (TextUtils.isEmpty(((com.lantern.auth.b.a)paramObject).g))) {
          break label254;
        }
        p.g(this.a, ((com.lantern.auth.b.a)paramObject).a);
        paramString = new com.lantern.core.model.g();
        paramString.a = ((com.lantern.auth.b.a)paramObject).d;
        paramString.b = ((com.lantern.auth.b.a)paramObject).c;
        paramString.c = com.bluefay.a.c.d(this.a);
        paramString.d = ((com.lantern.auth.b.a)paramObject).e;
        paramString.g = ((com.lantern.auth.b.a)paramObject).f;
        paramString.h = ((com.lantern.auth.b.a)paramObject).g;
        com.lantern.core.c.getServer().a(paramString);
        com.lantern.analytics.a.e().onEvent("oauth_ul", com.lantern.auth.g.a("1", "success", AuthActivity.b(this.a).mThirdAppId));
        com.lantern.analytics.a.e().onEvent("LoginOn", com.lantern.auth.g.a("app_sdk", AuthActivity.m(this.a), "1", AuthActivity.b(this.a).mThirdAppId));
        AuthActivity.a(this.a, "mo");
        AuthActivity.b(this.a, "1");
        AuthActivity.h(this.a);
      }
    }
    for (;;)
    {
      return;
      paramInt = 0;
      break;
      label254:
      com.lantern.analytics.a.e().onEvent("oauth_ul", com.lantern.auth.g.a("1", "failed", AuthActivity.b(this.a).mThirdAppId));
      com.lantern.analytics.a.e().onEvent("LoginOn", com.lantern.auth.g.a("app_sdk", AuthActivity.m(this.a), "2", AuthActivity.b(this.a).mThirdAppId));
      AuthActivity.n(this.a);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/ui/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */