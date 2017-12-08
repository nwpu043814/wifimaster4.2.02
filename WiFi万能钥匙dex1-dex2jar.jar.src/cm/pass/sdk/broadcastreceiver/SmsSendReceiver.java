package cm.pass.sdk.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import cm.pass.sdk.utils.d;
import cm.pass.sdk.utils.j;
import cm.pass.sdk.utils.o;
import cm.pass.sdk.utils.p;

public class SmsSendReceiver
  extends BroadcastReceiver
{
  private static final String TAG = "SmsSendReceiver:";
  private Context mContext;
  
  public SmsSendReceiver(Context paramContext)
  {
    this.mContext = paramContext.getApplicationContext();
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    switch (getResultCode())
    {
    default: 
      j.a("SmsSendReceiver:", "SendSms is Failure");
      d.b(this.mContext);
    }
    for (;;)
    {
      return;
      j.d("SmsSendReceiver:", "SendSms is Successful");
      o.a().b(this.mContext, "KEY_IMSI" + p.a, p.a);
      o.a().b(this.mContext, "KEY_IMSI_TIME" + p.a, System.currentTimeMillis());
      d.b(this.mContext);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/broadcastreceiver/SmsSendReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */