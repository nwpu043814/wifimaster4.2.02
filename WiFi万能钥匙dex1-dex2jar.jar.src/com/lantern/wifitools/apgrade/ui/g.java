package com.lantern.wifitools.apgrade.ui;

import android.app.Activity;
import android.content.Intent;
import com.bluefay.a.e;
import com.lantern.wifitools.R.string;

final class g
  implements com.bluefay.b.a
{
  g(ApGradeFragmentNew paramApGradeFragmentNew, String paramString1, String paramString2) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    ApGradeFragmentNew.a(this.c);
    if (paramInt == 1)
    {
      e.a(R.string.apgrade_tip_sucess);
      com.lantern.analytics.a.e().onEvent("aprate1_s");
      paramString = new Intent();
      paramString.putExtra("callback", ApGradeFragmentNew.b(this.c));
      paramString.putExtra("param", String.format("{\"comment\":\"%s\",\"star\":\"%s\"}", new Object[] { this.a, this.b }));
      this.c.getActivity().setResult(-1, paramString);
      ApGradeFragmentNew.c(this.c);
    }
    for (;;)
    {
      return;
      com.lantern.analytics.a.e().onEvent("aprate1_f");
      e.a(R.string.apgrade_tip_no_net);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/apgrade/ui/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */