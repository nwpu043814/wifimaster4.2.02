package com.wifi.connect.plugin.magickey.a;

import android.os.Handler;
import com.lantern.core.model.WkAccessPoint;

final class i
  implements com.bluefay.b.a
{
  i(a parama) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    if (a.c(this.a)) {}
    for (;;)
    {
      return;
      a.a(this.a, true, paramInt, paramObject);
      if (paramInt == 1)
      {
        a.a(this.a, paramInt, paramObject);
        ah.a(a.e(this.a)).a(a.d(this.a));
        ah.a(a.e(this.a)).a();
        a.a(a.d(this.a), a.a(this.a));
      }
      while (paramInt != 0)
      {
        a.f(this.a).a(paramInt, paramString, paramObject);
        break;
      }
      if (a.g(this.a) >= 2)
      {
        this.a.a(paramInt, paramObject);
        paramString = a.d(this.a);
        com.wifi.connect.plugin.magickey.database.a.a().a(paramString.a);
        a.i(this.a);
        a.a(this.a, a.d(this.a));
      }
      else
      {
        a.h(this.a).sendEmptyMessage(1);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/magickey/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */