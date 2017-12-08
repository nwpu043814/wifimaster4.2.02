package com.wifi.connect.plugin;

import android.os.Build.VERSION;
import com.bluefay.b.h;

final class c
  implements com.bluefay.b.a
{
  c(a parama) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    h.b("CheckInternet retcode:%s,retmsg:%s,data:%s", new Object[] { Integer.valueOf(paramInt), paramString, paramObject });
    if ((paramObject instanceof Integer))
    {
      if (((Integer)paramObject).intValue() == 1) {
        break label82;
      }
      if (Build.VERSION.SDK_INT < 21) {
        break label65;
      }
      this.a.a(a.b(this.a));
    }
    for (;;)
    {
      return;
      label65:
      this.a.b(a.b(this.a));
      continue;
      label82:
      a.a(this.a);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */