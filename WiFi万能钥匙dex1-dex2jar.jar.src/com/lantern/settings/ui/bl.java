package com.lantern.settings.ui;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import bluefay.preference.ValuePreference;
import com.lantern.settings.R.drawable;
import com.lantern.settings.R.string;

final class bl
  implements View.OnClickListener
{
  bl(UserInfoFragment paramUserInfoFragment, Button paramButton1, Button paramButton2) {}
  
  public final void onClick(View paramView)
  {
    int j = 1;
    int i = 1;
    if (paramView == this.a)
    {
      if ((UserInfoFragment.j(this.c) != null) && (UserInfoFragment.j(this.c).booleanValue())) {
        break label209;
      }
      UserInfoFragment.a(this.c, Boolean.valueOf(true));
    }
    for (;;)
    {
      UserInfoFragment.k(this.c).a(R.string.settings_user_info_gender_male);
      this.a.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.settings_ic_checked, 0);
      this.b.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      for (;;)
      {
        UserInfoFragment.q(this.c).dismiss();
        UserInfoFragment.r(this.c);
        if (i != 0) {
          UserInfoFragment.s(this.c);
        }
        return;
        if (paramView == this.b)
        {
          if ((UserInfoFragment.j(this.c) == null) || (UserInfoFragment.j(this.c).booleanValue())) {
            UserInfoFragment.a(this.c, Boolean.valueOf(false));
          }
          for (i = j;; i = 0)
          {
            UserInfoFragment.k(this.c).a(R.string.settings_user_info_gender_female);
            this.b.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.settings_ic_checked, 0);
            this.a.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            break;
          }
        }
        i = 0;
      }
      label209:
      i = 0;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */