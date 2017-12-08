package com.lantern.settings.ui;

import com.bluefay.a.e;
import com.lantern.core.p;
import com.lantern.settings.R.string;
import org.json.JSONObject;

final class bk
  implements com.bluefay.b.a
{
  bk(UserInfoFragment paramUserInfoFragment) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    UserInfoFragment.a(UserInfoFragment.n(this.a));
    switch (paramInt)
    {
    default: 
      if ((paramObject != null) && ("O.OPEN.0004".equals(((JSONObject)paramObject).optString("retCd"))))
      {
        com.lantern.analytics.a.e().onEvent("sextofal");
        UserInfoFragment.p(this.a);
      }
      break;
    }
    for (;;)
    {
      return;
      if (UserInfoFragment.j(this.a) != null)
      {
        if (UserInfoFragment.j(this.a).booleanValue()) {}
        for (paramString = "M";; paramString = "F")
        {
          p.j(UserInfoFragment.o(this.a), paramString);
          break;
        }
        e.a(R.string.settings_user_info_submit_sex_failed);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */