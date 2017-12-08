package com.lantern.settings.ui;

import android.text.TextUtils;
import bluefay.preference.ValuePreference;
import com.bluefay.b.a;
import com.lantern.core.model.g;
import com.lantern.core.p;
import com.lantern.settings.R.string;
import com.lantern.settings.b.e;

final class bj
  implements a
{
  bj(UserInfoFragment paramUserInfoFragment) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if ((paramObject instanceof g))
    {
      paramString = (g)paramObject;
      String str = paramString.d;
      paramObject = paramString.e;
      p.i(UserInfoFragment.e(this.a), str);
      p.j(UserInfoFragment.f(this.a), (String)paramObject);
      p.k(UserInfoFragment.g(this.a), paramString.g);
      UserInfoFragment.h(this.a).a(e.b(paramString.a));
      UserInfoFragment.i(this.a).a(str);
      UserInfoFragment.a(this.a, Boolean.valueOf("M".equals(paramObject)));
      paramObject = UserInfoFragment.k(this.a);
      if (!UserInfoFragment.j(this.a).booleanValue()) {
        break label192;
      }
    }
    label192:
    for (paramInt = R.string.settings_user_info_gender_male;; paramInt = R.string.settings_user_info_gender_female)
    {
      ((ValuePreference)paramObject).a(paramInt);
      UserInfoFragment.l(this.a);
      if (TextUtils.isEmpty(paramString.a)) {
        break;
      }
      p.a(UserInfoFragment.m(this.a), paramString.a);
      break;
      break;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */