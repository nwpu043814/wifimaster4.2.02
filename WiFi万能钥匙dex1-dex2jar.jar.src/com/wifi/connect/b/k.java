package com.wifi.connect.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.wifi.connect.e.b;

final class k
  implements DialogInterface.OnClickListener
{
  k(d paramd, com.bluefay.b.a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (b.a())
    {
      d.c(this.b, this.a);
      b.a(d.e(this.b));
    }
    for (;;)
    {
      com.lantern.analytics.a.e().onEvent("qa5mo_Y");
      return;
      paramDialogInterface = new Intent("android.settings.SETTINGS");
      paramDialogInterface.setFlags(268435456);
      d.e(this.b).startActivity(paramDialogInterface);
      this.a.a(0, "10006", null);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/b/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */