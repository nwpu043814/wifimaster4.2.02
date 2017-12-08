package com.lantern.dynamictab.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bluefay.b.h;
import com.lantern.dynamictab.e.e;
import java.util.ArrayList;

public final class a
  extends BroadcastReceiver
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = 0;
    h.a("Friend %s", new Object[] { "FriendsThirdPartMsgReceiver" });
    com.lantern.analytics.a.e().onEvent("dy_tp_msg");
    paramContext = com.lantern.dynamictab.e.b.a().c();
    if ((paramContext == null) || (paramContext.a == null) || (paramContext.a.size() == 0)) {
      com.lantern.analytics.a.e().onEvent("dy_tp_msg_no_config");
    }
    label181:
    for (;;)
    {
      return;
      e locale = com.lantern.dynamictab.e.b.a().a;
      paramContext = paramIntent.getStringExtra("PKG");
      if ((TextUtils.isEmpty(paramContext)) || (!com.lantern.dynamictab.e.b.a().a(paramContext))) {
        com.lantern.analytics.a.e().onEvent("dy_tp_pkg_n");
      }
      for (;;)
      {
        if (i == 0) {
          break label181;
        }
        com.lantern.dynamictab.e.b.a().a(null, true);
        com.lantern.dynamictab.a.a();
        break;
        paramIntent = e.a(paramContext, paramIntent.getStringExtra("DATA"));
        if (TextUtils.isEmpty(paramIntent))
        {
          com.lantern.analytics.a.e().onEvent("dy_tp_data_n");
        }
        else
        {
          h.a("Friend msg: %s", new Object[] { paramIntent });
          paramIntent = com.lantern.dynamictab.b.b.a(paramContext, paramIntent);
          if (paramIntent != null)
          {
            locale.a(paramContext, paramIntent);
            i = 1;
          }
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/dynamictab/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */