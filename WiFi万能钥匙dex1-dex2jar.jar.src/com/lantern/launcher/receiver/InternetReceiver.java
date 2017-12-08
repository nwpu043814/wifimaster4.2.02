package com.lantern.launcher.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.bluefay.b.h;
import com.lantern.core.a.a;
import com.lantern.core.config.d;
import com.qihoo.util.StubApp1053578832;

public class InternetReceiver
  extends BroadcastReceiver
{
  static
  {
    StubApp1053578832.interface11(25);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = paramIntent.getAction();
    h.a("action:%s", new Object[] { paramIntent });
    if ((Build.VERSION.SDK_INT >= 14) && ("wifi.intent.action.INTERNET_ACCESS_ENABLED".equals(paramIntent)))
    {
      d.a(paramContext).a(false);
      a.a().b();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/launcher/receiver/InternetReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */