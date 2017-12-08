package com.lantern.launcher.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import bluefay.widget.BLCheckBox;
import com.lantern.analytics.a;
import com.lantern.core.t;

final class l
  implements DialogInterface.OnClickListener
{
  l(MainActivityICS paramMainActivityICS, BLCheckBox paramBLCheckBox) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    MainActivityICS.a(this.b);
    paramDialogInterface = this.b;
    if (!this.a.isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      t.d(paramDialogInterface, bool);
      this.b.finish();
      a.e().onEvent("qudisp");
      return;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/launcher/ui/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */