package com.wifi.connect.plugin.magickey.a;

import android.os.Build.VERSION;
import com.bluefay.b.h;
import com.lantern.core.t;
import com.wifi.connect.plugin.magickey.d.b;

final class ab
  implements com.bluefay.b.a
{
  ab(p paramp) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    h.b("DisconenctWifiNetwork retcode:%s,retmsg:%s,data:%s", new Object[] { Integer.valueOf(paramInt), paramString, paramObject });
    if (p.c(this.a)) {}
    for (;;)
    {
      return;
      if (paramInt == 1)
      {
        p.b(this.a).m = System.currentTimeMillis();
        p.b(this.a).n = true;
        p.b(this.a).o = "w";
        this.a.a(p.e(this.a), p.k(this.a));
      }
      else if (Build.VERSION.SDK_INT >= 21)
      {
        if (com.lantern.auth.utils.a.b(p.f(this.a))) {
          this.a.a(p.l(this.a));
        } else {
          p.l(this.a).a(0, null, Integer.valueOf(10104));
        }
      }
      else if (t.g(p.f(this.a)))
      {
        new b(p.l(this.a)).execute(new String[0]);
      }
      else
      {
        this.a.b(p.l(this.a));
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/magickey/a/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */