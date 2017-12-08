package com.wifi.connect.b;

import android.content.Intent;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.os.Message;
import com.bluefay.d.b;
import com.lantern.analytics.a;
import com.lantern.core.c;
import com.lantern.core.g.j;
import com.lantern.core.g.u;
import com.lantern.core.q;
import com.wifi.connect.plugin.l;

final class af
  extends b
{
  af(ad paramad, int[] paramArrayOfInt)
  {
    super(paramArrayOfInt);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    int i = 1;
    int j = paramMessage.what;
    com.bluefay.b.h.a("StickyManager handle:" + j);
    switch (j)
    {
    }
    label277:
    for (;;)
    {
      return;
      paramMessage = (NetworkInfo)((Intent)paramMessage.obj).getParcelableExtra("networkInfo");
      NetworkInfo.DetailedState localDetailedState = paramMessage.getDetailedState();
      com.bluefay.b.h.a("detailstate:" + localDetailedState, new Object[0]);
      if (localDetailedState == NetworkInfo.DetailedState.DISCONNECTED)
      {
        c.getShareValue().a(null);
        j.a().b();
        if (ad.a)
        {
          ad.a = false;
          a.e().onEvent("concmcc3");
        }
      }
      else if (localDetailedState == NetworkInfo.DetailedState.CONNECTED)
      {
        paramMessage = u.a(paramMessage.getExtraInfo());
        this.a.a(paramMessage);
        continue;
        ad.b(this.a);
        continue;
        com.bluefay.b.h.a("disconnect 5 mins, del config");
        new l(ad.a(this.a)).a();
        continue;
        if (paramMessage.arg1 == 1) {}
        for (;;)
        {
          if (i == 0) {
            break label277;
          }
          paramMessage = (String)paramMessage.obj;
          c.getShareValue().a(paramMessage);
          com.lantern.core.h.a(paramMessage);
          j.a().a(ad.c(this.a));
          break;
          i = 0;
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/b/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */