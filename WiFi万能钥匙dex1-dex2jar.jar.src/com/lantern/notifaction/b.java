package com.lantern.notifaction;

import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.os.Message;
import com.bluefay.b.h;
import com.lantern.core.c;
import com.lantern.core.g.j;

final class b
  extends com.bluefay.d.b
{
  b(a parama, int[] paramArrayOfInt)
  {
    super(paramArrayOfInt);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    h.a("handle what:" + i);
    if (i == 128005)
    {
      paramMessage = ((NetworkInfo)((Intent)paramMessage.obj).getParcelableExtra("networkInfo")).getDetailedState();
      a.a(this.a, paramMessage);
    }
    for (;;)
    {
      return;
      if (i == 128001)
      {
        paramMessage = (Intent)paramMessage.obj;
        i = paramMessage.getIntExtra("wifi_state", 4);
        WifiInfo.getDetailedStateOf((SupplicantState)paramMessage.getParcelableExtra("newState"));
        a.a(this.a, i);
      }
      else if (i == 128030)
      {
        i = paramMessage.arg1;
        if (j.b(i))
        {
          if (a.a(c.getAppContext())) {
            this.a.a();
          }
        }
        else if ((j.a(i)) && (a.a(c.getAppContext()))) {
          this.a.c();
        }
      }
      else if (i == 128100)
      {
        i = paramMessage.arg1;
        int j = paramMessage.arg2;
        if ((i == 1) && (j.b(j)) && (a.a(c.getAppContext()))) {
          this.a.a();
        }
      }
      else if (i == 128031)
      {
        this.a.d();
      }
      else if (i == 128032)
      {
        this.a.f();
      }
      else if (i == 128201)
      {
        this.a.b();
        this.a.d();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/notifaction/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */