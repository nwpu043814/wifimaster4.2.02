package com.lantern.launcher.ui;

import android.os.Handler;
import com.bluefay.b.h;

final class s
  implements com.bluefay.b.a
{
  s(UserGuideFragment paramUserGuideFragment) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    if (UserGuideFragment.q(this.a))
    {
      if (paramInt == 1) {
        com.lantern.analytics.a.e().onEvent("regsuc0");
      }
      for (;;)
      {
        h.a("reten code:[%s],but the Fragment is already destoryed", new Object[] { Integer.valueOf(paramInt) });
        return;
        com.lantern.analytics.a.e().onEvent("regfai0");
      }
    }
    if (paramInt == 1) {
      com.lantern.analytics.a.e().onEvent("regsuc");
    }
    for (;;)
    {
      UserGuideFragment.l(this.a).removeCallbacksAndMessages(null);
      UserGuideFragment.l(this.a).sendEmptyMessage(1);
      break;
      com.lantern.analytics.a.e().onEvent("regfai");
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/launcher/ui/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */