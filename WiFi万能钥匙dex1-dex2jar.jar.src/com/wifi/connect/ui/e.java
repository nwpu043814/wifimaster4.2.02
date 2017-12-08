package com.wifi.connect.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.lantern.analytics.a;

final class e
  implements DialogInterface.OnClickListener
{
  e(ConnectFragment paramConnectFragment, boolean paramBoolean) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (this.a) {
      a.e().onEvent("smh_10");
    }
    for (;;)
    {
      return;
      a.e().onEvent("smh_20");
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/ui/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */