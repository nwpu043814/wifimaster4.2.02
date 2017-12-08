package com.lantern.launcher.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.lantern.core.t;
import com.lantern.widget.WkCheckBox;

final class r
  implements View.OnClickListener
{
  r(UserGuideFragment paramUserGuideFragment) {}
  
  public final void onClick(View paramView)
  {
    if (paramView == UserGuideFragment.d(this.a))
    {
      boolean bool = UserGuideFragment.d(this.a).a();
      t.a(UserGuideFragment.o(this.a), bool);
      if (UserGuideFragment.p(this.a) != null)
      {
        if (!bool) {
          break label60;
        }
        UserGuideFragment.p(this.a).setText(2131363312);
      }
    }
    for (;;)
    {
      return;
      label60:
      UserGuideFragment.p(this.a).setText(2131363313);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/launcher/ui/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */