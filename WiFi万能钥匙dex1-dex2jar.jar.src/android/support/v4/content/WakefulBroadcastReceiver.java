package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import android.util.SparseArray;

public abstract class WakefulBroadcastReceiver
  extends BroadcastReceiver
{
  private static final String EXTRA_WAKE_LOCK_ID = "android.support.content.wakelockid";
  private static final SparseArray<PowerManager.WakeLock> mActiveWakeLocks = new SparseArray();
  private static int mNextId = 1;
  
  public static boolean completeWakefulIntent(Intent arg0)
  {
    boolean bool = false;
    int i = ???.getIntExtra("android.support.content.wakelockid", 0);
    if (i == 0) {}
    for (;;)
    {
      return bool;
      synchronized (mActiveWakeLocks)
      {
        Object localObject1 = (PowerManager.WakeLock)mActiveWakeLocks.get(i);
        if (localObject1 != null)
        {
          ((PowerManager.WakeLock)localObject1).release();
          mActiveWakeLocks.remove(i);
          bool = true;
          continue;
        }
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>("No active wake lock id #");
        Log.w("WakefulBroadcastReceiver", i);
        bool = true;
      }
    }
  }
  
  public static ComponentName startWakefulService(Context paramContext, Intent paramIntent)
  {
    synchronized (mActiveWakeLocks)
    {
      int i = mNextId;
      int j = mNextId + 1;
      mNextId = j;
      if (j <= 0) {
        mNextId = 1;
      }
      paramIntent.putExtra("android.support.content.wakelockid", i);
      paramIntent = paramContext.startService(paramIntent);
      if (paramIntent == null)
      {
        paramContext = null;
        return paramContext;
      }
      paramContext = (PowerManager)paramContext.getSystemService("power");
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>("wake:");
      paramContext = paramContext.newWakeLock(1, paramIntent.flattenToShortString());
      paramContext.setReferenceCounted(false);
      paramContext.acquire(60000L);
      mActiveWakeLocks.put(i, paramContext);
      paramContext = paramIntent;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/android/support/v4/content/WakefulBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */