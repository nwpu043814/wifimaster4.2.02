package com.wifi.connect.b;

import android.os.Handler;
import android.os.Message;
import com.bluefay.a.a;
import com.bluefay.b.h;
import com.lantern.core.c;
import com.lantern.core.model.WkAccessPoint;
import com.lantern.core.p;

final class an
  extends Handler
{
  an(al paramal) {}
  
  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return;
      h.a("nearby MSG_20SEC_FOUND  ", new Object[0]);
      boolean bool = c.getInstance().isAppForeground();
      if ((al.b(this.a) != null) && (!a.a(al.b(this.a))) && (!bool))
      {
        h.a("nearby MSG_20SEC_FOUND  foundaplogic", new Object[0]);
        al.f(this.a);
        continue;
        Object localObject = (WkAccessPoint)paramMessage.obj;
        h.a("nearby MSG_NOTICE ssid is " + ((WkAccessPoint)localObject).a(), new Object[0]);
        long l = System.currentTimeMillis();
        if (l - p.a(al.b(this.a), "sdk_common", "last_nearby_ap_view_show_time2", 0L) >= 60000 * al.g(this.a))
        {
          p.b(al.b(this.a), "sdk_common", "last_nearby_ap_view_show_time2", l);
          al.a(this.a, (WkAccessPoint)localObject);
          if ("A".equals(al.a(this.a))) {
            al.b(this.a, (WkAccessPoint)localObject);
          }
          al.c(this.a).removeMessages(102);
          paramMessage = Message.obtain();
          paramMessage.what = 102;
          paramMessage.obj = localObject;
          al.a(this.a, 1);
          al.c(this.a).removeMessages(102);
          al.c(this.a).sendMessageDelayed(paramMessage, 60000L);
          continue;
          localObject = (WkAccessPoint)paramMessage.obj;
          al.h(this.a);
          if (al.i(this.a) <= 3)
          {
            if (al.c(this.a, (WkAccessPoint)localObject))
            {
              h.a("nearby MSG_CHECKAP true apSsid " + ((WkAccessPoint)localObject).a(), new Object[0]);
              localObject = Message.obtain();
              ((Message)localObject).copyFrom(paramMessage);
              ((Message)localObject).what = 102;
              al.c(this.a).removeMessages(102);
              al.c(this.a).sendMessageDelayed((Message)localObject, 60000L);
            }
            else
            {
              h.a("nearby MSG_CHECKAP false  ", new Object[0]);
              al.a(this.a, 0);
              al.e(this.a);
              al.c(this.a).removeCallbacksAndMessages(null);
              if ((al.b(this.a) != null) && (!a.a(al.b(this.a)))) {
                al.f(this.a);
              }
            }
          }
          else
          {
            h.a("nearby MSG_CHECKAP remove notify", new Object[0]);
            al.e(this.a);
          }
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/b/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */