package com.wifi.connect.plugin.magickey.a;

import android.os.Handler;
import android.os.Message;
import com.bluefay.b.h;
import com.wifi.connect.plugin.magickey.b.b;
import com.wifi.connect.plugin.magickey.b.d;
import java.util.ArrayList;

final class ae
  implements com.bluefay.b.a
{
  ae(p paramp) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    h.a("retcode:%s retmsg:%s data:%s", new Object[] { Integer.valueOf(paramInt), paramString, paramObject });
    if (p.c(this.a)) {}
    for (;;)
    {
      return;
      p.b(this.a).p = System.currentTimeMillis();
      if ((paramObject != null) && ((paramObject instanceof b)))
      {
        p.a(this.a, (b)paramObject);
        if ((p.a(this.a).c()) && (p.a(this.a).h()))
        {
          p.a(this.a, new d[p.a(this.a).d.size()]);
          p.a(this.a, new int[p.a(this.a).d.size()]);
          p.g(this.a).a(3, null, p.c());
          p.b(this.a).q = "S";
          p.b(this.a).s = true;
          p.b(this.a).u = p.a(this.a).a;
          p.b(this.a).t = p.a(this.a).b;
          paramInt = p.a(this.a).l() + 1;
          p.g(this.a).a(3, null, p.a(paramInt));
          p.i(this.a).obtainMessage(2, 1, paramInt, p.a(this.a).i()).sendToTarget();
          label281:
          if (p.o(this.a)) {
            com.lantern.analytics.a.e().onEvent("qo5qry_OY");
          }
        }
        else
        {
          p.b(this.a).q = "S";
          p.b(this.a).s = false;
          p.b(this.a).r = p.a(this.a).b();
          p.b(this.a).u = p.a(this.a).a;
          p.b(this.a).t = p.a(this.a).b;
          if (!p.a(this.a).g()) {
            break label451;
          }
        }
        label451:
        for (paramString = p.b(10102);; paramString = p.b(10002))
        {
          p.a(this.a, 0, p.a(this.a).b(), paramString);
          p.g(this.a).a(0, p.a(this.a).b(), paramString);
          break label281;
          break;
        }
      }
      else
      {
        p.b(this.a).q = "F";
        p.b(this.a).s = false;
        p.b(this.a).r = "Network Exception";
        paramString = p.b(10103);
        p.a(this.a, 0, "GET_PWD_FAILED", paramString);
        p.g(this.a).a(0, "GET_PWD_FAILED", paramString);
        if (p.o(this.a)) {
          com.lantern.analytics.a.e().onEvent("qo5qry_ON");
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/magickey/a/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */