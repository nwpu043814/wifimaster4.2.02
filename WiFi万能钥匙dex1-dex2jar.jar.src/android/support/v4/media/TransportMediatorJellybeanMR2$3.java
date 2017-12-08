package android.support.v4.media;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.KeyEvent;

class TransportMediatorJellybeanMR2$3
  extends BroadcastReceiver
{
  TransportMediatorJellybeanMR2$3(TransportMediatorJellybeanMR2 paramTransportMediatorJellybeanMR2) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      paramContext = (KeyEvent)paramIntent.getParcelableExtra("android.intent.extra.KEY_EVENT");
      this.this$0.mTransportCallback.handleKey(paramContext);
      return;
    }
    catch (ClassCastException paramContext)
    {
      for (;;)
      {
        Log.w("TransportController", paramContext);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/android/support/v4/media/TransportMediatorJellybeanMR2$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */