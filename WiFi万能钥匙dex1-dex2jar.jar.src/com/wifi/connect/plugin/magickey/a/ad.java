package com.wifi.connect.plugin.magickey.a;

import com.bluefay.b.h;

final class ad
  implements com.bluefay.b.a
{
  ad(p paramp) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    h.b("CheckInternet retcode:%s,retmsg:%s,data:%s", new Object[] { Integer.valueOf(paramInt), paramString, paramObject });
    if (p.c(this.a)) {}
    for (;;)
    {
      return;
      if ((paramObject instanceof Integer)) {
        if (((Integer)paramObject).intValue() == 1)
        {
          p.b(this.a).j = System.currentTimeMillis();
          p.b(this.a).k = true;
          p.b(this.a).l = "w";
          this.a.a(p.e(this.a), p.k(this.a));
        }
        else
        {
          p.b(this.a).j = System.currentTimeMillis();
          p.b(this.a).k = false;
          p.b(this.a).l = "w";
          new com.wifi.connect.plugin.magickey.d.a(p.n(this.a)).execute(new String[0]);
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/magickey/a/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */