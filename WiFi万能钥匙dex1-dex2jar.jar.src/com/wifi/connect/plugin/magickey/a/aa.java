package com.wifi.connect.plugin.magickey.a;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.lantern.core.model.WkAccessPoint;
import com.wifi.connect.plugin.magickey.b.b;

final class aa
  implements com.bluefay.b.a
{
  aa(p paramp) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    if (p.c(this.a)) {}
    for (;;)
    {
      return;
      p.a(this.a, true, paramInt, paramString, paramObject);
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
      while (paramInt != 0)
      {
        p.g(this.a).a(paramInt, paramString, paramObject);
        break;
      }
      if (p.h(this.a) >= 2)
      {
        this.a.a(paramInt, paramObject);
        paramString = p.e(this.a);
        com.wifi.connect.plugin.magickey.database.a.a().a(paramString.a);
        p.j(this.a);
        p.a(this.a, p.e(this.a));
      }
      else
      {
        p.i(this.a).obtainMessage(1, 2, p.a(this.a).l(), p.a(this.a).j()).sendToTarget();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/magickey/a/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */