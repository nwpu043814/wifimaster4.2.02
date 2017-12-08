package com.lantern.wifilocating.push.util;

import android.content.Context;
import android.content.Intent;

final class f
  extends Thread
{
  f(Context paramContext, String paramString) {}
  
  public final void run()
  {
    try
    {
      j.k(this.a);
      Intent localIntent = new android/content/Intent;
      localIntent.<init>("com.lantern.wifilocating.push.action.GET_PUSH_ID");
      localIntent.setPackage(this.a.getPackageName());
      localIntent.putExtra("push_client_id", this.b);
      j.a(this.a, localIntent, 2);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.a(localException);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/util/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */