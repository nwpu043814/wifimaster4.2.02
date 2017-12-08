package com.lantern.wifitools.apgrade.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.bluefay.material.f;

final class e
  implements DialogInterface.OnCancelListener
{
  e(ApGradeFragment paramApGradeFragment, boolean paramBoolean) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    ApGradeFragment.k(this.b).hide();
    ApGradeFragment.k(this.b).dismiss();
    if (this.a) {
      ApGradeFragment.l(this.b);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/apgrade/ui/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */