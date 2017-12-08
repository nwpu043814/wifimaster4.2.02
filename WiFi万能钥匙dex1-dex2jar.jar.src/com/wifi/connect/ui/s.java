package com.wifi.connect.ui;

import android.os.Build.VERSION;
import com.bluefay.a.e;
import com.bluefay.b.h;
import com.lantern.connect.R.string;

final class s
  implements com.bluefay.b.a
{
  s(ConnectFragment paramConnectFragment, boolean paramBoolean) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    h.a("retcode:%s retmsg:%s data:%s", new Object[] { Integer.valueOf(paramInt), paramString, paramObject });
    if (paramInt == 1) {
      e.a(R.string.tips_forget_success);
    }
    for (;;)
    {
      if (paramInt == 1)
      {
        ConnectFragment.x(this.b);
        if (this.a)
        {
          ConnectFragment.d(this.b).a(true);
          ConnectFragment.k(this.b);
        }
      }
      return;
      if (paramInt == 0) {
        if (Build.VERSION.SDK_INT >= 23) {
          e.a(R.string.tips_forget_failed_system_limit);
        } else {
          e.a(R.string.tips_forget_failed);
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/ui/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */