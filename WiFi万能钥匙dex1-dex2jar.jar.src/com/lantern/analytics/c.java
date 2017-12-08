package com.lantern.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bluefay.b.h;

final class c
  extends BroadcastReceiver
{
  c(a parama) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    h.a(paramContext);
    if ("android.intent.action.SCREEN_OFF".equals(paramContext))
    {
      Object localObject = com.lantern.core.c.getProcessName();
      paramIntent = null;
      paramContext = paramIntent;
      if (localObject != null)
      {
        paramContext = paramIntent;
        if (((String)localObject).contains(":"))
        {
          localObject = ((String)localObject).split(":");
          paramContext = paramIntent;
          if (localObject != null)
          {
            paramContext = paramIntent;
            if (localObject.length == 2) {
              paramContext = localObject[1];
            }
          }
        }
      }
      h.a("subprocess:" + paramContext);
      if (paramContext == null) {
        this.a.d();
      }
      this.a.c();
    }
    for (;;)
    {
      return;
      "android.intent.action.SCREEN_ON".equals(paramContext);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/analytics/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */