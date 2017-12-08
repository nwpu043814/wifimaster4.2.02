package com.lantern.auth.ui;

import android.text.TextUtils;
import com.lantern.auth.WkParamsConfig;

final class g
  implements com.bluefay.b.a
{
  g(AuthActivity paramAuthActivity) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    paramObject = (com.lantern.auth.b.b)paramObject;
    if (paramInt == 10) {
      AuthActivity.f(this.a).a(1003, null, Boolean.valueOf(true));
    }
    for (;;)
    {
      return;
      if ("0".equals(((com.lantern.auth.b.b)paramObject).a()))
      {
        paramString = ((com.lantern.auth.b.b)paramObject).c();
        paramObject = ((com.lantern.auth.b.b)paramObject).b();
        if ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty((CharSequence)paramObject)))
        {
          AuthActivity.j(this.a);
        }
        else
        {
          com.lantern.analytics.a.e().onEvent("oauth_ul", com.lantern.auth.g.a("1", "start", AuthActivity.b(this.a).mThirdAppId));
          AuthActivity.k(this.a).a(paramString, (String)paramObject, "app_sdk", AuthActivity.b(this.a).mThirdAppId);
        }
      }
      else
      {
        AuthActivity.j(this.a);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/ui/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */