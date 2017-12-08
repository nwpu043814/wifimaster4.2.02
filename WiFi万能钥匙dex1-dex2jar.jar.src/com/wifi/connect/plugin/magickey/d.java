package com.wifi.connect.plugin.magickey;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.lantern.analytics.a;

final class d
  implements DialogInterface.OnClickListener
{
  d(ConnectActivity paramConnectActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    a.e().onEvent("sgnbadcli");
    ConnectActivity.a(this.a, ConnectActivity.b(this.a));
    this.a.finish();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/magickey/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */