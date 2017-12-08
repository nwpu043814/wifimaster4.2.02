package com.wifi.connect.plugin.magickey.a;

import com.bluefay.b.h;

final class l
  implements com.bluefay.b.a
{
  l(a parama) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    h.b("CheckInternet retcode:%s,retmsg:%s,data:%s", new Object[] { Integer.valueOf(paramInt), paramString, paramObject });
    if (a.c(this.a)) {}
    for (;;)
    {
      return;
      if ((paramObject instanceof Integer)) {
        if (((Integer)paramObject).intValue() == 1)
        {
          a.b(this.a).j = System.currentTimeMillis();
          a.b(this.a).k = true;
          a.b(this.a).l = "w";
          this.a.a(a.d(this.a), a.j(this.a));
        }
        else
        {
          a.b(this.a).j = System.currentTimeMillis();
          a.b(this.a).k = false;
          a.b(this.a).l = "w";
          new com.wifi.connect.plugin.magickey.d.a(a.m(this.a)).execute(new String[0]);
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/magickey/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */