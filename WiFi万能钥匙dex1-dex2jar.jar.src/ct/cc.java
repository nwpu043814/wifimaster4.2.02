package ct;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public final class cc
  extends BroadcastReceiver
{
  private final bi a;
  private boolean b;
  
  public cc(bi parambi)
  {
    this.a = parambi;
  }
  
  public final void a()
  {
    if (this.b) {}
    for (;;)
    {
      return;
      this.b = true;
      IntentFilter localIntentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
      try
      {
        this.a.a.registerReceiver(this, localIntentFilter);
      }
      catch (Exception localException)
      {
        b.a.a("TxNetworkStateMonitor", "listenNetworkState: failed", localException);
      }
    }
  }
  
  public final void b()
  {
    if (!this.b) {}
    for (;;)
    {
      return;
      this.b = false;
      try
      {
        this.a.a.unregisterReceiver(this);
      }
      catch (Exception localException) {}
    }
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    for (;;)
    {
      return;
      if (paramIntent.getBooleanExtra("noConnectivity", false)) {
        this.a.c(Integer.valueOf(-1));
      } else if (b.a.c(paramContext)) {
        this.a.c(Integer.valueOf(1));
      } else {
        this.a.c(Integer.valueOf(0));
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/cc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */