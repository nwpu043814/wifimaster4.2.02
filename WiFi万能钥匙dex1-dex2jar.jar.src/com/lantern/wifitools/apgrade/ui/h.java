package com.lantern.wifitools.apgrade.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.bluefay.material.f;

final class h
  implements DialogInterface.OnCancelListener
{
  h(ApGradeFragmentNew paramApGradeFragmentNew) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    ApGradeFragmentNew.d(this.b).hide();
    ApGradeFragmentNew.d(this.b).dismiss();
    if (this.a) {
      ApGradeFragmentNew.e(this.b);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/apgrade/ui/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */