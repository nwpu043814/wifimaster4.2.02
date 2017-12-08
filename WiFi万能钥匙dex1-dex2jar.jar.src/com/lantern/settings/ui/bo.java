package com.lantern.settings.ui;

import com.bluefay.a.e;
import com.bluefay.b.a;
import com.lantern.settings.R.string;
import com.lantern.settings.a.g;

final class bo
  implements a
{
  bo(bn parambn) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    if (paramInt == 1)
    {
      paramString = String.valueOf(paramObject);
      UserInfoFragment.a(this.a.c, new g(paramString, new bp(this, paramString)));
      UserInfoFragment.v(this.a.c).execute(new Void[0]);
    }
    for (;;)
    {
      return;
      UserInfoFragment.a(this.a.b);
      e.a(R.string.settings_upload_avatar_failed);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/bo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */