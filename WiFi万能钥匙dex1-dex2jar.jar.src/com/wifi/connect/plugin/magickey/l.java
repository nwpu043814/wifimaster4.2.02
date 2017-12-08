package com.wifi.connect.plugin.magickey;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.bluefay.a.e;
import com.lantern.analytics.a;

final class l
  implements DialogInterface.OnClickListener
{
  l(ConnectActivity paramConnectActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    a.e().onEvent("wfnoshow1");
    paramDialogInterface = new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS");
    paramDialogInterface.addFlags(268435456);
    e.a(this.a, paramDialogInterface);
    this.a.finish();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/magickey/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */