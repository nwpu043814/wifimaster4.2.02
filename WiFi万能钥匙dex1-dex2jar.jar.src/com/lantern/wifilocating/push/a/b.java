package com.lantern.wifilocating.push.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.lantern.wifilocating.push.util.h;

final class b
  extends BroadcastReceiver
{
  b(a parama) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    h.a(paramContext);
    if ("android.intent.action.SCREEN_OFF".equals(paramContext)) {
      this.a.b();
    }
    for (;;)
    {
      return;
      "android.intent.action.SCREEN_ON".equals(paramContext);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */