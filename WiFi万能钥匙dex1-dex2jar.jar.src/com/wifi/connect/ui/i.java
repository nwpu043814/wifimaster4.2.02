package com.wifi.connect.ui;

import com.bluefay.a.e;
import com.bluefay.b.h;
import com.lantern.connect.R.string;
import com.wifi.connect.model.c;
import java.util.concurrent.atomic.AtomicBoolean;

final class i
  implements com.bluefay.b.a
{
  i(ConnectFragment paramConnectFragment) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    h.a("retcode:%s retmsg:%s data:%s", new Object[] { Integer.valueOf(paramInt), paramString, paramObject });
    if (paramInt == 1) {
      if (((paramObject instanceof c)) && (((c)paramObject).j())) {
        e.a(R.string.tips_key_queried);
      }
    }
    for (;;)
    {
      ConnectFragment.C(this.a);
      ConnectFragment.y(this.a);
      if ((paramObject instanceof c))
      {
        paramString = (c)paramObject;
        ConnectFragment.d(this.a).a(paramString);
        h.a("mhat 1 ", new Object[0]);
        ConnectFragment.b(this.a);
      }
      ConnectFragment.D(this.a).set(false);
      ConnectFragment.j(this.a).e();
      return;
      e.a(R.string.tips_key_not_found);
      continue;
      if ((paramInt != 0) || (paramString == null)) {
        continue;
      }
      try
      {
        paramInt = Integer.parseInt(paramString);
        if ((paramInt != 10001) && (paramInt != 10002)) {
          continue;
        }
        e.a(R.string.tips_key_query_failed);
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramInt = 0;
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/ui/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */