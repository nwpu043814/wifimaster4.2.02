package com.wifi.connect.plugin.magickey.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import bluefay.widget.BLCheckBox;
import com.lantern.core.t;
import com.wifi.connect.plugin.magickey.d.b;

final class e
  implements DialogInterface.OnClickListener
{
  e(a parama, BLCheckBox paramBLCheckBox, com.bluefay.b.a parama1) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.isChecked()) {
      com.lantern.analytics.a.e().onEvent("oncheck");
    }
    t.e(a.e(this.c), this.a.isChecked());
    a.n(this.c);
    new b(this.b).execute(new String[0]);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/magickey/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */