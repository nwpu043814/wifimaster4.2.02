package com.lantern.launcher.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.lantern.analytics.a;
import com.lantern.core.k;
import com.lantern.core.p;

final class t
  implements View.OnClickListener
{
  t(UserGuideFragment paramUserGuideFragment) {}
  
  public final void onClick(View paramView)
  {
    int j = k.b(UserGuideFragment.r(this.a));
    int i = p.a("prev_version");
    if ((i != 0) && (i < j)) {
      a.e().onEvent("update_" + i + "_" + j);
    }
    p.b("prev_version", j);
    UserGuideFragment.a(this.a);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/launcher/ui/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */