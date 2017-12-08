package com.wifi.connect.ui;

import com.lantern.analytics.a;

final class x
  implements WifiDisabledView.a
{
  x(ConnectFragment paramConnectFragment) {}
  
  public final void a()
  {
    a.e().onEvent("wlanon2");
    ConnectFragment.af(this.a);
    ConnectFragment.a(this.a, 2);
    ConnectFragment.b(this.a, 2);
    ConnectFragment.c(this.a, 2);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/ui/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */