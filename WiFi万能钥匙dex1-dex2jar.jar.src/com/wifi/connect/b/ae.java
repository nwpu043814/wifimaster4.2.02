package com.wifi.connect.b;

import android.content.Context;
import android.content.Intent;
import com.bluefay.b.a;
import com.lantern.core.g.j;
import com.lantern.core.h;

final class ae
  implements a
{
  ae(ad paramad) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    if ((paramObject instanceof Integer))
    {
      h.a(((Integer)paramObject).intValue());
      if (j.b(((Integer)paramObject).intValue()))
      {
        paramString = new Intent();
        paramString.setAction("wifi.intent.action.INTERNET_ACCESS_ENABLED");
        ad.a(this.a).sendBroadcast(paramString);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/b/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */