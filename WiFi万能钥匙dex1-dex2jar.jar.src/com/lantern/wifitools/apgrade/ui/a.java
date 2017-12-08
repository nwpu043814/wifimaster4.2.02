package com.lantern.wifitools.apgrade.ui;

import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import com.bluefay.a.e;
import com.lantern.wifitools.R.string;

final class a
  implements com.bluefay.b.a
{
  a(ApGradeFragment paramApGradeFragment) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    if (paramInt == 1) {
      if (!ApGradeFragment.a(this.a)) {
        ApGradeFragment.a(this.a, (com.lantern.wifitools.apgrade.b.a)paramObject);
      }
    }
    for (;;)
    {
      ApGradeFragment.f(this.a);
      return;
      e.a(R.string.apgrade_tip_no_net);
      ApGradeFragment.b(this.a);
      continue;
      paramString = (com.lantern.wifitools.apgrade.b.a)paramObject;
      if ((paramString != null) && (!TextUtils.isEmpty(paramString.b()))) {
        e.a(paramString.b());
      }
      ApGradeFragment.c(this.a).setVisibility(0);
      ApGradeFragment.d(this.a).setVisibility(8);
      ApGradeFragment.e(this.a).setVisibility(0);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/apgrade/ui/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */