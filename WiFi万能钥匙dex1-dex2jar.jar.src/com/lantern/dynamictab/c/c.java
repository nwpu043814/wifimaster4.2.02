package com.lantern.dynamictab.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.bluefay.b.h;
import com.lantern.dynamictab.e.b;
import com.lantern.dynamictab.e.e;

public final class c
  extends BroadcastReceiver
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    h.a("Friend %s", new Object[] { "PackageRemovedReceiver" });
    if (paramIntent.getBooleanExtra("android.intent.extra.REPLACING", false)) {}
    for (;;)
    {
      return;
      paramContext = paramIntent.getData();
      if (paramContext != null)
      {
        paramContext = paramContext.getSchemeSpecificPart();
        b.a().a.d(paramContext);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/dynamictab/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */