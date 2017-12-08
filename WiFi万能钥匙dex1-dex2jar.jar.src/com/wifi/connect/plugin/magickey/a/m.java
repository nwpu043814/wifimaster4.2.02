package com.wifi.connect.plugin.magickey.a;

import android.os.Handler;
import com.bluefay.b.h;
import com.wifi.connect.plugin.magickey.b.b;

final class m
  implements com.bluefay.b.a
{
  m(a parama) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    h.a("retcode:%s retmsg:%s data:%s", new Object[] { Integer.valueOf(paramInt), paramString, paramObject });
    if (a.c(this.a)) {}
    for (;;)
    {
      return;
      a.b(this.a).p = System.currentTimeMillis();
      if ((paramObject != null) && ((paramObject instanceof b)))
      {
        a.a(this.a, (b)paramObject);
        if ((a.a(this.a).c()) && (a.a(this.a).h()))
        {
          a.f(this.a).a(3, null, a.c());
          a.b(this.a).q = "S";
          a.b(this.a).s = true;
          a.b(this.a).u = a.a(this.a).a;
          a.b(this.a).t = a.a(this.a).b;
          a.h(this.a).sendEmptyMessage(2);
        }
        else
        {
          a.b(this.a).q = "S";
          a.b(this.a).s = false;
          a.b(this.a).r = a.a(this.a).b();
          a.b(this.a).u = a.a(this.a).a;
          a.b(this.a).t = a.a(this.a).b;
          if (a.a(this.a).g()) {}
          for (paramString = a.a(10102);; paramString = a.a(10002))
          {
            a.a(this.a, 0, paramString);
            a.f(this.a).a(0, a.a(this.a).b(), paramString);
            break;
          }
        }
      }
      else
      {
        a.b(this.a).q = "F";
        a.b(this.a).s = false;
        a.b(this.a).r = "Network Exception";
        paramString = a.a(10103);
        a.a(this.a, 0, paramString);
        a.f(this.a).a(0, "GET_PWD_FAILED", paramString);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/magickey/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */