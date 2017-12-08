package com.wifi.connect.b;

import android.os.Handler;
import android.os.Message;
import com.bluefay.b.h;
import com.lantern.core.g.u;
import com.lantern.core.model.WkAccessPoint;
import com.wifi.connect.a.b;
import com.wifi.connect.model.d;
import java.util.ArrayList;
import java.util.List;

final class ao
  implements Runnable
{
  ao(al paramal) {}
  
  public final void run()
  {
    if (al.b(this.a) == null) {}
    label168:
    label172:
    for (;;)
    {
      return;
      ArrayList localArrayList2 = b.b().a();
      ArrayList localArrayList1 = u.a(al.b(this.a));
      h.a("nearby aps size is " + localArrayList1.size(), new Object[0]);
      for (int i = 0;; i++)
      {
        if (i >= localArrayList2.size()) {
          break label172;
        }
        d locald = (d)localArrayList2.get(i);
        for (int j = 0;; j++)
        {
          if (j >= localArrayList1.size()) {
            break label168;
          }
          WkAccessPoint localWkAccessPoint = (WkAccessPoint)localArrayList1.get(j);
          if (locald.a(localWkAccessPoint))
          {
            h.a("nearby foundApLogic apCache ap ssid  " + locald.toString(), new Object[0]);
            al.c(this.a).obtainMessage(101, 0, 0, localWkAccessPoint).sendToTarget();
            break;
          }
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/b/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */