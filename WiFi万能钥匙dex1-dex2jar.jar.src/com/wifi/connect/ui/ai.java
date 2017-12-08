package com.wifi.connect.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.lantern.analytics.a;
import com.wifi.connect.a.g;

final class ai
  implements AdapterView.OnItemClickListener
{
  ai(ConnectFragment paramConnectFragment) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((paramView instanceof WifiListItemView))
    {
      paramAdapterView = ((WifiListItemView)paramView).a();
      ConnectFragment.b(this.a, paramAdapterView);
      ConnectFragment.b(this.a, false);
      ConnectFragment.c(this.a, paramAdapterView);
      if (g.a().a(paramAdapterView)) {
        a.e().onEvent("ssrp_click");
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/ui/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */