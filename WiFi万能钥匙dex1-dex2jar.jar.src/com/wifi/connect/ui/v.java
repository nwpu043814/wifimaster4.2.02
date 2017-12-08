package com.wifi.connect.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.lantern.analytics.a;

final class v
  implements DialogInterface.OnClickListener
{
  v(ConnectFragment paramConnectFragment) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    a.e().onEvent("cpop_qx");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/ui/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */