package ct;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;

final class l
  extends BroadcastReceiver
{
  l(k paramk) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (SystemClock.elapsedRealtime() - k.a(this.a) > 5000L) {
      new Thread(new k.b(this.a, paramContext)).start();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */