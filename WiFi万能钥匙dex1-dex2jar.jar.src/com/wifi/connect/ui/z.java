package com.wifi.connect.ui;

import android.widget.TextView;
import com.bluefay.b.a;
import com.bluefay.b.h;
import com.lantern.core.g.j;

final class z
  implements a
{
  z(ConnectFragment paramConnectFragment) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    h.b("CheckInternet retcode:%s,retmsg:%s,data:%s", new Object[] { Integer.valueOf(paramInt), paramString, paramObject });
    if ((paramInt == 1) && (j.b(((Integer)paramObject).intValue())) && (ConnectFragment.ag(this.a) != null))
    {
      ConnectFragment.ag(this.a).setVisibility(8);
      ConnectFragment.j(this.a).b(8);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/ui/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */