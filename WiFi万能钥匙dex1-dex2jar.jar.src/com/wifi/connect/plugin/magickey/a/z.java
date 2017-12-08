package com.wifi.connect.plugin.magickey.a;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.wifi.connect.plugin.magickey.b.b;

final class z
  implements com.bluefay.b.a
{
  z(p paramp) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    if (p.c(this.a)) {}
    for (;;)
    {
      return;
      p.a(this.a, false, paramInt, paramString, paramObject);
      if (paramInt == 1)
      {
        if (!TextUtils.isEmpty(p.d(this.a))) {
          com.lantern.analytics.a.e().onEvent("nnmcs");
        }
        p.a(this.a, paramInt, paramString, paramObject);
        ah.a(p.f(this.a)).a(p.e(this.a));
        ah.a(p.f(this.a)).a();
        p.a(p.e(this.a), p.a(this.a));
      }
      for (;;)
      {
        p.g(this.a).a(paramInt, paramString, paramObject);
        break;
        if (paramInt == 0)
        {
          if (p.h(this.a) < 2) {
            break label294;
          }
          if ((p.a(this.a) != null) && (p.a(this.a).k()))
          {
            paramInt = p.a(this.a).l() + 1;
            p.g(this.a).a(3, null, p.a(paramInt));
            paramString = p.b(this.a);
            paramString.F = 0L;
            paramString.G = 0L;
            paramString.H = false;
            paramString.I = null;
            paramString.J = 0L;
            paramString.K = 0L;
            paramString.L = false;
            paramString.M = null;
            p.i(this.a).obtainMessage(2, 1, paramInt, p.a(this.a).i()).sendToTarget();
            break;
          }
          p.a(this.a, paramInt, paramString, paramObject);
          this.a.a(paramInt, paramObject);
        }
      }
      label294:
      p.i(this.a).obtainMessage(2, 2, p.a(this.a).l(), p.a(this.a).j()).sendToTarget();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/magickey/a/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */