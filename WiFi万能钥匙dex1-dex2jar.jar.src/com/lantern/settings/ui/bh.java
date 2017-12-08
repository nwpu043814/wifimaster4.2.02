package com.lantern.settings.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.URLUtil;
import com.bluefay.b.h;
import com.lantern.core.p;

final class bh
  implements View.OnClickListener
{
  bh(UserInfoFragment paramUserInfoFragment) {}
  
  public final void onClick(View paramView)
  {
    String str = p.e(UserInfoFragment.a(this.a));
    h.a("setOnIconClick url " + str, new Object[0]);
    if ((TextUtils.isEmpty(str)) || (!URLUtil.isNetworkUrl(str))) {
      UserInfoFragment.b(this.a);
    }
    for (;;)
    {
      return;
      paramView = new Bundle();
      paramView.putString("url", str);
      this.a.a(AvatarViewFragment.class.getCanonicalName(), paramView);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */