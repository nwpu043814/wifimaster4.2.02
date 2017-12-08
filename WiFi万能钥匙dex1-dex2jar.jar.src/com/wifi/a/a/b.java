package com.wifi.a.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.lantern.core.p;
import java.io.File;

final class b
  extends BroadcastReceiver
{
  b(a parama) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    for (;;)
    {
      return;
      paramContext = paramIntent.getAction();
      if (paramIntent.getLongExtra("extra_download_id", 0L) == p.a("mapdownload", -1L)) {
        if ("android.intent.action.DOWNLOAD_COMPLETE".equals(paramContext))
        {
          if ((a.a(this.a) != null) && (!TextUtils.isEmpty(a.a(this.a).f())))
          {
            if ((a.a(this.a, a.a(this.a)).exists()) && (a.a(a.a(this.a)))) {
              com.wifi.a.b.a.b(a.b(this.a), a.a(this.a).f());
            }
            a.c(this.a);
          }
          com.lantern.analytics.a.e().onEvent("map_dlw", a.d(this.a));
        }
        else if ("android.intent.action.DOWNLOAD_REMOVE".equals(paramContext))
        {
          a.c(this.a);
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */