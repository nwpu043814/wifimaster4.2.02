package com.lantern.settings.ui;

import android.text.TextUtils;
import bluefay.preference.Preference;
import com.bluefay.b.a;
import com.lantern.core.model.g;
import com.lantern.core.p;
import com.lantern.settings.R.string;
import com.lantern.settings.a.e;

final class z
  implements a
{
  z(MineFragment paramMineFragment) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      MineFragment.g(this.a).e(R.string.settings_user_info_get_nickname_failed);
      MineFragment.i(this.a);
      MineFragment.f(this.a);
    }
    label198:
    label213:
    for (;;)
    {
      return;
      if ((paramObject instanceof g))
      {
        paramString = (g)paramObject;
        p.i(MineFragment.c(this.a), paramString.d);
        p.j(MineFragment.d(this.a), paramString.e);
        p.k(MineFragment.e(this.a), paramString.g);
        MineFragment.f(this.a);
        if (!TextUtils.isEmpty(paramString.d)) {
          break label198;
        }
        MineFragment.g(this.a).e(R.string.settings_user_info_no_nickname);
      }
      for (;;)
      {
        if (TextUtils.isEmpty(paramString.a)) {
          break label213;
        }
        p.a(MineFragment.h(this.a), paramString.a);
        if (TextUtils.isEmpty(paramString.d)) {
          break;
        }
        new e(paramString.a, paramString.b, paramString.d).execute(new Void[0]);
        break;
        break;
        MineFragment.g(this.a).b(paramString.d);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */