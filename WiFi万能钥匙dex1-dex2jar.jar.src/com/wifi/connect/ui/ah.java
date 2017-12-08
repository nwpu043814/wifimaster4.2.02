package com.wifi.connect.ui;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.view.View;
import android.view.ViewGroup;
import com.bluefay.a.e;
import com.lantern.analytics.a;
import com.wifi.connect.b.aj;

final class ah
  implements WifiListFooterView.a
{
  ah(ConnectFragment paramConnectFragment) {}
  
  public final void onCheckSettingEvent()
  {
    a.e().onEvent("nolist1");
    Intent localIntent = new Intent("wifi.intent.action.CHECKSETTING");
    localIntent.setPackage(ConnectFragment.r(this.a).getPackageName());
    e.a(ConnectFragment.s(this.a), localIntent);
  }
  
  public final void onEvent() {}
  
  public final void onRefreshListEvent(View paramView)
  {
    a.e().onEvent("nolist2");
    if (ConnectFragment.e(this.a).isWifiEnabled()) {
      ConnectFragment.t(this.a).c();
    }
    ConnectFragment.a(this.a, paramView);
    ConnectFragment.u(this.a).setVisibility(8);
    ConnectFragment.v(this.a).setVisibility(0);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/ui/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */