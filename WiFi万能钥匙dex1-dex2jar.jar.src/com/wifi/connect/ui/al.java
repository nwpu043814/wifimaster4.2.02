package com.wifi.connect.ui;

import com.bluefay.b.a;
import com.bluefay.material.SwipeRefreshLayout;

final class al
  implements a
{
  al(ConnectFragment paramConnectFragment) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    ConnectFragment.w(this.a).a(false);
    if (paramInt == 1)
    {
      ConnectFragment.x(this.a);
      if ((!ConnectFragment.j(this.a).b()) && (!ConnectFragment.j(this.a).a())) {
        break label50;
      }
    }
    for (;;)
    {
      return;
      label50:
      ConnectFragment.y(this.a);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/ui/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */