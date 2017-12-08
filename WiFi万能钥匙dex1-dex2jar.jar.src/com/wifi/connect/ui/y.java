package com.wifi.connect.ui;

import android.view.View;
import android.view.View.OnClickListener;

final class y
  implements View.OnClickListener
{
  y(ConnectFragment paramConnectFragment) {}
  
  public final void onClick(View paramView)
  {
    paramView = ConnectFragment.d(this.a).b();
    if (paramView != null) {
      ConnectFragment.a(this.a, paramView);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/ui/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */