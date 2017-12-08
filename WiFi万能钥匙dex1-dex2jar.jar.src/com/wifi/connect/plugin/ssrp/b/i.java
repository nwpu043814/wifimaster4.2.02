package com.wifi.connect.plugin.ssrp.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import bluefay.app.b;

final class i
  implements DialogInterface.OnCancelListener
{
  i(h paramh) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    com.lantern.analytics.a.e().onEvent("ssrp_cancel");
    if (h.a(this.a) != null)
    {
      ((b)h.a(this.a)).finish();
      if (h.b(this.a) != null) {
        h.b(this.a).b();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/ssrp/b/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */