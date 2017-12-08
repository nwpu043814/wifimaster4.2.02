package com.lantern.wifilocating.push.i;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class d
  implements DialogInterface.OnClickListener
{
  d(c paramc) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (c.a(this.a) != null) {
      c.a(this.a).a();
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/i/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */