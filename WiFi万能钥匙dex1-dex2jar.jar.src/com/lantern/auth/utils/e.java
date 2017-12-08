package com.lantern.auth.utils;

import android.app.PendingIntent;
import android.os.Handler;
import android.telephony.SmsManager;

final class e
  implements Runnable
{
  e(b paramb, SmsManager paramSmsManager, String paramString1, String paramString2, PendingIntent paramPendingIntent) {}
  
  public final void run()
  {
    this.a.sendTextMessage(this.b, null, this.c, this.d, null);
    b.b(this.e).sendEmptyMessageDelayed(1, 10000L);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/utils/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */