package com.wifi.connect.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.wifi.connect.d.h;
import com.wifi.connect.model.AccessPoint;

final class u
  implements DialogInterface.OnClickListener
{
  u(ConnectFragment paramConnectFragment, AccessPoint paramAccessPoint) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    new h(this.a, ConnectFragment.ae(this.b)).execute(new String[0]);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/ui/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */