package com.lantern.dynamictab.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.bluefay.b.h;

public final class b
  extends BroadcastReceiver
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      paramIntent = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if ((paramIntent != null) && (paramIntent.isAvailable()))
      {
        paramContext = new java/lang/StringBuilder;
        paramContext.<init>("net available:");
        h.a("Friends %s", new Object[] { paramIntent });
        com.lantern.dynamictab.e.b.a().b();
      }
      return;
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/dynamictab/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */