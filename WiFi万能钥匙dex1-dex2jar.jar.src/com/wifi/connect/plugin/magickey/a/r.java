package com.wifi.connect.plugin.magickey.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.wifi.connect.plugin.magickey.e.c;

final class r
  implements DialogInterface.OnClickListener
{
  r(p paramp, com.bluefay.b.a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (c.a())
    {
      p.a(this.b, this.a);
      c.a(p.f(this.b));
    }
    for (;;)
    {
      com.lantern.analytics.a.e().onEvent("qo5mo_Y");
      return;
      paramDialogInterface = new Intent("android.settings.SETTINGS");
      paramDialogInterface.setFlags(268435456);
      p.f(this.b).startActivity(paramDialogInterface);
      this.a.a(0, null, Integer.valueOf(10104));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/magickey/a/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */