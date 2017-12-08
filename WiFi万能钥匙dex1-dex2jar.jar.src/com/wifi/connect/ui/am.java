package com.wifi.connect.ui;

import com.bluefay.b.a;

final class am
  implements a
{
  am(ConnectFragment paramConnectFragment) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    if ((paramObject instanceof Integer))
    {
      paramInt = ((Integer)paramObject).intValue();
      ConnectFragment.a(this.a, paramInt);
      ConnectFragment.b(this.a, paramInt);
      ConnectFragment.z(this.a);
      ConnectFragment.c(this.a, paramInt);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/ui/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */