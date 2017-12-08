package com.wifi.connect.plugin.magickey.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import bluefay.app.b;

final class an
  implements DialogInterface.OnCancelListener
{
  an(am paramam) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if (am.a(this.a) != null) {
      am.a(this.a).a();
    }
    ((b)am.b(this.a)).finish();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/magickey/a/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */