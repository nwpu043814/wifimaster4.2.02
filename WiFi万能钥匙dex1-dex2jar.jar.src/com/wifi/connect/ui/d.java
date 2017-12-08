package com.wifi.connect.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.lantern.analytics.a;
import com.wifi.connect.model.AccessPoint;

final class d
  implements DialogInterface.OnClickListener
{
  d(ConnectFragment paramConnectFragment, boolean paramBoolean, AccessPoint paramAccessPoint) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a)
    {
      a.e().onEvent("smh_11");
      ConnectFragment.e(this.c, this.b);
    }
    for (;;)
    {
      return;
      a.e().onEvent("smh_21");
      ConnectFragment.a(this.c, this.b, 0, false, false, false, false, false);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/ui/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */