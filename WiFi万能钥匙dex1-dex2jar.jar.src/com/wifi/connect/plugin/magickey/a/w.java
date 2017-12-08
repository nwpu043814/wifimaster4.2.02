package com.wifi.connect.plugin.magickey.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import bluefay.widget.BLCheckBox;
import com.bluefay.b.a;
import com.lantern.core.t;
import com.wifi.connect.plugin.magickey.d.b;

final class w
  implements DialogInterface.OnClickListener
{
  w(p paramp, BLCheckBox paramBLCheckBox, a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    t.e(p.f(this.c), this.a.isChecked());
    p.q(this.c);
    new b(this.b).execute(new String[0]);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/magickey/a/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */