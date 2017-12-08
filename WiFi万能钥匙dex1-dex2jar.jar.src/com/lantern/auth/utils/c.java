package com.lantern.auth.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class c
  extends BroadcastReceiver
{
  c(b paramb) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((!paramIntent.getAction().equals("SENT_SMS_ACTION")) || (b.a(this.a) == 2)) {}
    for (;;)
    {
      return;
      b.a(this.a, 1);
      switch (getResultCode())
      {
      default: 
        b.a(this.a, 0, "send sms failed");
        break;
      case -1: 
        b.a(this.a, 1, "send sms successfully");
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/utils/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */