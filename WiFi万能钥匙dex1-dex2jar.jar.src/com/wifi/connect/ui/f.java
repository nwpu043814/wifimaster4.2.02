package com.wifi.connect.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.lantern.analytics.a;

final class f
  implements DialogInterface.OnCancelListener
{
  f(ConnectFragment paramConnectFragment, boolean paramBoolean) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
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


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/ui/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */