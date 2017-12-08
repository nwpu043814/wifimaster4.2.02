package com.lantern.wifitools.apgrade.ui;

import com.bluefay.a.e;
import com.lantern.wifitools.R.string;

final class d
  implements com.bluefay.b.a
{
  d(ApGradeFragment paramApGradeFragment, String paramString1, String paramString2) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    ApGradeFragment.f(this.c);
    if (paramInt == 1)
    {
      com.lantern.wifitools.apgrade.a.a.a(ApGradeFragment.g(this.c), ApGradeFragment.h(this.c), ApGradeFragment.i(this.c), String.format("{\"comment\":\"%s\",\"star\":%s }", new Object[] { this.a, this.b }));
      e.a(R.string.apgrade_tip_sucess);
      com.lantern.analytics.a.e().onEvent("aprate1_s");
      ApGradeFragment.j(this.c);
    }
    for (;;)
    {
      return;
      com.lantern.analytics.a.e().onEvent("aprate1_f");
      e.a(R.string.apgrade_tip_no_net);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/apgrade/ui/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */