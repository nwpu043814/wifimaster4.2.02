package com.wifi.connect.ui;

import com.bluefay.b.h;
import com.lantern.core.location.LocationBean;
import com.lantern.core.location.LocationCallBack;

final class ad
  implements LocationCallBack
{
  ad(ConnectFragment paramConnectFragment) {}
  
  public final void callback(LocationBean paramLocationBean)
  {
    if (paramLocationBean != null)
    {
      h.a("tiger location is lat " + paramLocationBean.getLat() + " lon " + paramLocationBean.getLon(), new Object[0]);
      ConnectFragment.a(this.a, paramLocationBean);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/ui/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */