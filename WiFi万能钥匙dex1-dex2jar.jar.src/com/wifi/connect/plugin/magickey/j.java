package com.wifi.connect.plugin.magickey;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.lantern.analytics.a;

final class j
  implements DialogInterface.OnCancelListener
{
  j(ConnectActivity paramConnectActivity) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    a.e().onEvent("wfnoshow0");
    this.a.finish();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/magickey/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */