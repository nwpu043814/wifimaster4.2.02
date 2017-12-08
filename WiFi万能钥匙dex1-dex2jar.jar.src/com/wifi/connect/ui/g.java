package com.wifi.connect.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.wifi.connect.a.d;
import com.wifi.connect.model.AccessPoint;
import com.wifi.connect.widget.n.a;

final class g
  implements n.a
{
  g(ConnectFragment paramConnectFragment) {}
  
  public final void onEvent(int paramInt, AccessPoint paramAccessPoint)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return;
      if (com.wifi.connect.a.e.b().a(paramAccessPoint))
      {
        ConnectFragment.a(this.a, true, paramAccessPoint);
      }
      else if (d.a().a(paramAccessPoint))
      {
        paramInt = ConnectFragment.d(this.a).a(paramAccessPoint);
        ConnectFragment.a(this.a, paramAccessPoint, 0, false, false, false, false, false);
        com.lantern.analytics.a.e().onEvent("http_click", paramAccessPoint.a + "," + paramAccessPoint.b);
        paramAccessPoint = String.format("%d,%d", new Object[] { Integer.valueOf(paramInt + 1), Integer.valueOf(ConnectFragment.d(this.a).getCount()) });
        com.lantern.analytics.a.e().onEvent("http_c_no", paramAccessPoint);
      }
      else
      {
        ConnectFragment.e(this.a, paramAccessPoint);
        continue;
        if (com.wifi.connect.a.e.b().a(paramAccessPoint))
        {
          ConnectFragment.a(this.a, false, paramAccessPoint);
        }
        else
        {
          ConnectFragment.a(this.a, paramAccessPoint, 0, false, false, false, false, false);
          continue;
          ConnectFragment.a(this.a, paramAccessPoint, false, false);
          com.lantern.analytics.a.e().onEvent("conbyuserown");
          continue;
          ConnectFragment.a(paramAccessPoint);
          ConnectFragment.f(this.a, paramAccessPoint);
          com.lantern.analytics.a.e().onEvent("conbrk");
          continue;
          ConnectFragment.g(this.a, paramAccessPoint);
          continue;
          ConnectFragment.h(this.a, paramAccessPoint);
          continue;
          ConnectFragment.b(this.a, true);
          ConnectFragment.a(this.a, paramAccessPoint, true, false);
          continue;
          ConnectFragment.a(paramAccessPoint);
          ConnectFragment.i(this.a, paramAccessPoint);
          com.lantern.analytics.a.e().onEvent("confgt");
          continue;
          ConnectFragment.j(this.a, paramAccessPoint);
          continue;
          ConnectFragment.b(this.a, paramAccessPoint);
          continue;
          Intent localIntent = new Intent("wifi.intent.action.SPEED_TEST");
          localIntent.setPackage(ConnectFragment.A(this.a).getPackageName());
          Bundle localBundle = new Bundle();
          localBundle.putString("ssid", paramAccessPoint.a);
          localIntent.putExtras(localBundle);
          localIntent.addFlags(268435456);
          com.bluefay.a.e.a(ConnectFragment.B(this.a), localIntent);
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/ui/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */