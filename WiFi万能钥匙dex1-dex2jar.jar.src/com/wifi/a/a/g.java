package com.wifi.a.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import com.lantern.core.g.j;

final class g
  implements DialogInterface.OnClickListener
{
  g(a parama, int paramInt) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a == 0)
    {
      j.a().a(a.f(this.b));
      com.lantern.analytics.a.e().onEvent("map_w_y");
      return;
    }
    if (this.a == 1)
    {
      if (com.bluefay.a.a.c(a.b(this.b))) {
        break label100;
      }
      if (Build.VERSION.SDK_INT < 21) {
        break label83;
      }
      a.a(this.b, a.e(this.b));
    }
    for (;;)
    {
      com.lantern.analytics.a.e().onEvent("map_g_y");
      break;
      break;
      label83:
      a.b(this.b, a.e(this.b));
      continue;
      label100:
      if (com.bluefay.a.a.b(a.b(this.b))) {
        a.a(this.b, a.a(this.b).b(), "WifiMasterKey/maps", a.b(a.a(this.b)));
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/a/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */