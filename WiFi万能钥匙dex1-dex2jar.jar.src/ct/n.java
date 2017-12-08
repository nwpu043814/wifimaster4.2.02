package ct;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;

final class n
  extends BroadcastReceiver
{
  n(k paramk) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    bb.a("AccessSchedulerTrigger", "onAccessSchedulerTriggered by timer, curTime:" + SystemClock.elapsedRealtime());
    new Thread(new k.a(this.a, (byte)0)).start();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */