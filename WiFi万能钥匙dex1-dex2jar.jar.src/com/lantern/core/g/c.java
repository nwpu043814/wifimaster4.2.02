package com.lantern.core.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.bluefay.b.h;
import java.util.Hashtable;

final class c
  extends BroadcastReceiver
{
  c(b paramb) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (b.a(this.a).size() == 0) {
      h.a("-------no observers--------", new Object[0]);
    }
    for (;;)
    {
      return;
      String str = paramIntent.getAction();
      paramContext = paramIntent.getData().getSchemeSpecificPart().toLowerCase();
      paramIntent = paramIntent.getExtras();
      if ("android.intent.action.PACKAGE_ADDED".equals(str))
      {
        if (!paramIntent.getBoolean("android.intent.extra.REPLACING", false))
        {
          b.a(this.a, paramContext);
          b.b(this.a);
        }
      }
      else if ("android.intent.action.PACKAGE_REPLACED".equals(str))
      {
        b.a(this.a, paramContext);
        b.b(this.a);
      }
      else if (("android.intent.action.PACKAGE_REMOVED".equals(str)) && (paramIntent.getBoolean("android.intent.extra.DATA_REMOVED", false)) && (!paramIntent.containsKey("android.intent.extra.REPLACING")))
      {
        b.b(this.a, paramContext);
        b.c(this.a);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/g/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */