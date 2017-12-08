package com.lantern.wifilocating.push.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.lantern.wifilocating.push.f.e;
import com.lantern.wifilocating.push.util.b;
import com.lantern.wifilocating.push.util.j;

public final class a
  extends BroadcastReceiver
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(str))
    {
      b.c("receive action network changed");
      if (paramContext == null) {
        break label144;
      }
    }
    label144:
    for (boolean bool = j.a(paramContext, paramContext.getPackageName() + ":push");; bool = false)
    {
      if (!bool)
      {
        b.c("push process is not running");
        e.a().a(paramContext);
      }
      return;
      if ("com.lantern.wifilocating.push.action.HEARTBEAT".equals(str))
      {
        b.c("receive action heartbeat timer");
        break;
      }
      if ("com.lantern.wifilocating.push.action.SYNC".equals(str))
      {
        b.c("receive action sync timer");
        break;
      }
      if (!"com.lantern.push.ACTION_D".equals(str)) {
        break;
      }
      bool = Boolean.valueOf(paramIntent.getStringExtra("wkdebug")).booleanValue();
      b.a(bool);
      if (!bool) {
        break;
      }
      b.a("open debug mode~");
      break;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/receiver/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */