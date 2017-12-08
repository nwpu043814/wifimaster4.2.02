package com.lantern.launcher.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.lantern.core.t;
import com.lantern.widget.WkCheckBox;

final class q
  implements View.OnClickListener
{
  q(UserGuideFragment paramUserGuideFragment) {}
  
  public final void onClick(View paramView)
  {
    if (paramView == UserGuideFragment.b(this.a))
    {
      boolean bool = UserGuideFragment.b(this.a).a();
      t.a(UserGuideFragment.m(this.a), bool);
      if (UserGuideFragment.n(this.a) != null)
      {
        if (!bool) {
          break label60;
        }
        UserGuideFragment.n(this.a).setText(2131363312);
      }
    }
    for (;;)
    {
      return;
      label60:
      UserGuideFragment.n(this.a).setText(2131363313);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/launcher/ui/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */