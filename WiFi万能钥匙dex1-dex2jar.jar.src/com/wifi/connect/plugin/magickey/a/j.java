package com.wifi.connect.plugin.magickey.a;

import android.os.Build.VERSION;
import com.bluefay.b.h;
import com.lantern.core.t;
import com.wifi.connect.plugin.magickey.d.b;

final class j
  implements com.bluefay.b.a
{
  j(a parama) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    h.b("DisconenctWifiNetwork retcode:%s,retmsg:%s,data:%s", new Object[] { Integer.valueOf(paramInt), paramString, paramObject });
    if (a.c(this.a)) {}
    for (;;)
    {
      return;
      if (paramInt == 1)
      {
        a.b(this.a).m = System.currentTimeMillis();
        a.b(this.a).n = true;
        a.b(this.a).o = "w";
        this.a.a(a.d(this.a), a.j(this.a));
      }
      else if (Build.VERSION.SDK_INT >= 21)
      {
        this.a.a(a.k(this.a));
      }
      else if (t.g(a.e(this.a)))
      {
        new b(a.k(this.a)).execute(new String[0]);
      }
      else
      {
        this.a.b(a.k(this.a));
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/magickey/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */