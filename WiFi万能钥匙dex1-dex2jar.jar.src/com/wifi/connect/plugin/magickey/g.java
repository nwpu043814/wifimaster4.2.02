package com.wifi.connect.plugin.magickey;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.lantern.analytics.a;

final class g
  implements DialogInterface.OnCancelListener
{
  g(ConnectActivity paramConnectActivity) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    a.e().onEvent("wfmshow0");
    this.a.finish();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/magickey/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */