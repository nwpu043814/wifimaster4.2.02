package com.wifi.connect.ui;

import com.wifi.connect.model.c;

final class h
  implements com.bluefay.b.a
{
  h(ConnectFragment paramConnectFragment) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    if ((paramObject instanceof c))
    {
      paramString = (c)paramObject;
      ConnectFragment.d(this.a).a(paramString);
      ConnectFragment.b(this.a);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/ui/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */