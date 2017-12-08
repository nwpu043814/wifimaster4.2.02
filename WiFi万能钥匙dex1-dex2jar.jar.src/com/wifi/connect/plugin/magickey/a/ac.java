package com.wifi.connect.plugin.magickey.a;

import com.bluefay.b.a;
import com.lantern.core.c;
import com.lantern.core.q;

final class ac
  implements a
{
  ac(p paramp) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    p.m(this.a);
    if (p.c(this.a)) {}
    for (;;)
    {
      return;
      if (paramInt == 1)
      {
        p.b(this.a).m = System.currentTimeMillis();
        p.b(this.a).n = true;
        p.b(this.a).o = "g";
        c.getShareValue().c(true);
        this.a.a(p.e(this.a), p.k(this.a));
      }
      else
      {
        p.b(this.a).m = System.currentTimeMillis();
        p.b(this.a).n = false;
        p.b(this.a).o = "g";
        int i = 10101;
        paramInt = i;
        if (paramObject != null)
        {
          paramInt = i;
          if ((paramObject instanceof Integer)) {
            paramInt = ((Integer)paramObject).intValue();
          }
        }
        paramString = p.b(paramInt);
        p.a(this.a, 0, "ENABLE_MOBILE_FAILED", paramString);
        p.g(this.a).a(0, "ENABLE_MOBILE_FAILED", paramString);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/magickey/a/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */