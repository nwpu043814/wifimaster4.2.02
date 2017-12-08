package com.lantern.settings.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.lantern.auth.utils.f;
import com.lantern.settings.a.g;
import com.lantern.settings.a.h;

final class bm
  implements DialogInterface.OnDismissListener
{
  bm(UserInfoFragment paramUserInfoFragment) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    if (UserInfoFragment.t(this.a) != null) {
      UserInfoFragment.t(this.a).cancel(true);
    }
    if (UserInfoFragment.u(this.a) != null) {
      UserInfoFragment.u(this.a).cancel(true);
    }
    if (UserInfoFragment.v(this.a) != null) {
      UserInfoFragment.v(this.a).cancel(true);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */