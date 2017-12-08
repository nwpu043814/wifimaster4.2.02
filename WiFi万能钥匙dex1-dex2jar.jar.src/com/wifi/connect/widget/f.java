package com.wifi.connect.widget;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.bluefay.a.e;
import com.lantern.analytics.a;

final class f
  implements View.OnClickListener
{
  f(d paramd) {}
  
  public final void onClick(View paramView)
  {
    this.a.dismiss();
    if (!d.a(this.a))
    {
      a.e().onEvent("keysh10");
      d.b(this.a);
    }
    for (;;)
    {
      return;
      if (!d.c(this.a))
      {
        paramView = new Intent("android.settings.WIFI_SETTINGS");
        paramView.setFlags(268435456);
        e.a(d.d(this.a), paramView);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/widget/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */