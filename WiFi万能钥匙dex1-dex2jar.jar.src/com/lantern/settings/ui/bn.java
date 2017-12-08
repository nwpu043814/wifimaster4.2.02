package com.lantern.settings.ui;

import android.app.Dialog;
import com.bluefay.a.e;
import com.bluefay.b.a;
import com.lantern.settings.R.string;
import com.lantern.settings.a.h;
import org.json.JSONObject;

final class bn
  implements a
{
  bn(UserInfoFragment paramUserInfoFragment, String paramString, Dialog paramDialog) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    paramString = (JSONObject)paramObject;
    if ((paramInt == 1) && (paramString.optBoolean("verify", false)))
    {
      UserInfoFragment.a(this.c, new h(this.a, new bo(this)));
      UserInfoFragment.u(this.c).execute(new Void[0]);
    }
    for (;;)
    {
      return;
      UserInfoFragment.a(this.b);
      if (!paramString.has("retCd")) {
        e.a(R.string.settings_upload_avatar_failed);
      } else {
        UserInfoFragment.p(this.c);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */