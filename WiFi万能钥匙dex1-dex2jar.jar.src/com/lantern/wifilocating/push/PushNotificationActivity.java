package com.lantern.wifilocating.push;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.lantern.wifilocating.push.util.j;
import com.qihoo.util.StubApp1053578832;

public class PushNotificationActivity
  extends Activity
{
  static
  {
    StubApp1053578832.interface11(62);
  }
  
  public static final void a(Context paramContext, Intent paramIntent)
  {
    Intent localIntent = new Intent(paramContext, PushNotificationActivity.class);
    localIntent.putExtra("TARGET", paramIntent);
    localIntent.addFlags(268435456);
    j.a(paramContext, localIntent, 0);
  }
  
  protected native void onCreate(Bundle paramBundle);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/PushNotificationActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */