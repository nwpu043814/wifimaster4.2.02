package com.lantern.auth.ui;

import android.view.View;
import com.lantern.auth.WkParamsConfig;
import com.lantern.auth.g;

final class d
  implements com.bluefay.b.a
{
  d(AuthActivity paramAuthActivity) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    AuthActivity.g(this.a);
    if ((paramInt == 1) && (paramObject != null))
    {
      AuthActivity.a(this.a, "mt");
      AuthActivity.h(this.a);
      paramString = new View(this.a);
      paramString.setBackgroundColor(-1);
      this.a.setCustomContentView(paramString);
      com.lantern.analytics.a.e().onEvent("oauth_dl", g.a("1", "success", AuthActivity.b(this.a).mThirdAppId));
      AuthActivity.b(this.a, "1");
    }
    for (;;)
    {
      return;
      com.lantern.analytics.a.e().onEvent("oauth_dl", g.a("1", "failed", AuthActivity.b(this.a).mThirdAppId));
      AuthActivity.b(this.a, "2");
      AuthActivity.f(this.a).a(1004, paramString, Boolean.valueOf(true));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/ui/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */