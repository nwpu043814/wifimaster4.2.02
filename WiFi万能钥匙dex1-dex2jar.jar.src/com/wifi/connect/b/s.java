package com.wifi.connect.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import bluefay.widget.BLCheckBox;
import com.lantern.core.t;
import com.wifi.connect.d.c;

final class s
  implements DialogInterface.OnClickListener
{
  s(d paramd, BLCheckBox paramBLCheckBox, com.bluefay.b.a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.isChecked()) {
      com.lantern.analytics.a.e().onEvent("oncheck");
    }
    t.e(d.e(this.c), this.a.isChecked());
    d.j(this.c);
    new c(this.b).execute(new String[0]);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/b/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */