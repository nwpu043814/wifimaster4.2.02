package com.lantern.wifilocating.push.service;

import android.app.IntentService;
import android.content.Intent;
import com.lantern.wifilocating.push.f.e;
import com.qihoo.util.StubApp1053578832;

public class SubPushService
  extends IntentService
{
  static
  {
    StubApp1053578832.interface11(65);
  }
  
  public SubPushService()
  {
    super("Sub_Push_Service");
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    if (!e.a().b()) {
      e.a().a(getApplicationContext(), null);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/service/SubPushService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */