package com.wifi.connect.plugin.magickey;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.lantern.analytics.a;

final class i
  implements DialogInterface.OnClickListener
{
  i(ConnectActivity paramConnectActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    a.e().onEvent("wfnoshow1");
    ConnectActivity localConnectActivity = this.a;
    paramDialogInterface = new Intent("wifi.intent.action.SETTINGS_MAIN");
    paramDialogInterface.setPackage(localConnectActivity.getPackageName());
    paramDialogInterface.putExtra("fragment", "com.lantern.settings.ui.DefaultSettingsFragment");
    localConnectActivity.startActivity(paramDialogInterface);
    this.a.finish();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/magickey/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */