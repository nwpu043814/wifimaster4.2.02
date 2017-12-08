package com.wifi.connect.ui;

import android.text.TextUtils;
import com.bluefay.d.b;
import com.lantern.core.location.LocationBean;
import com.lantern.core.location.LocationCallBack;

final class ab
  implements LocationCallBack
{
  ab(ConnectFragment paramConnectFragment) {}
  
  public final void callback(LocationBean paramLocationBean)
  {
    if ((paramLocationBean != null) && (paramLocationBean.getAddress() != null) && (!TextUtils.isEmpty(paramLocationBean.getAddress().trim())))
    {
      String str = paramLocationBean.getAddress().trim();
      ConnectFragment.a(this.a, str);
      ConnectFragment.ai(this.a).post(new ac(this, str));
      ConnectFragment.a(this.a, paramLocationBean);
      ConnectFragment.b(this.a, paramLocationBean);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/ui/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */