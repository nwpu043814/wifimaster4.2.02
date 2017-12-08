package com.wifi.connect.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.lantern.analytics.a;

final class w
  implements DialogInterface.OnCancelListener
{
  w(ConnectFragment paramConnectFragment) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    a.e().onEvent("cpop_qxkb");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/ui/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */