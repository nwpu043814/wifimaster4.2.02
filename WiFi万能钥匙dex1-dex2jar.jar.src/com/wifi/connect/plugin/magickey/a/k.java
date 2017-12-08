package com.wifi.connect.plugin.magickey.a;

import com.lantern.core.c;
import com.lantern.core.q;

final class k
  implements com.bluefay.b.a
{
  k(a parama) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    a.l(this.a);
    if (a.c(this.a)) {}
    for (;;)
    {
      return;
      if (paramInt == 1)
      {
        a.b(this.a).m = System.currentTimeMillis();
        a.b(this.a).n = true;
        a.b(this.a).o = "g";
        c.getShareValue().c(true);
        this.a.a(a.d(this.a), a.j(this.a));
      }
      else
      {
        a.b(this.a).m = System.currentTimeMillis();
        a.b(this.a).n = false;
        a.b(this.a).o = "g";
        int i = 10101;
        paramInt = i;
        if (paramObject != null)
        {
          paramInt = i;
          if ((paramObject instanceof Integer)) {
            paramInt = ((Integer)paramObject).intValue();
          }
        }
        paramString = a.a(paramInt);
        a.a(this.a, 0, paramString);
        a.f(this.a).a(0, "ENABLE_MOBILE_FAILED", paramString);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/magickey/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */