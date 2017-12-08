package com.lantern.wifilocating.push.i;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class e
  implements DialogInterface.OnClickListener
{
  e(c paramc) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (c.b(this.a) != null) {
      c.b(this.a).a();
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/i/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */