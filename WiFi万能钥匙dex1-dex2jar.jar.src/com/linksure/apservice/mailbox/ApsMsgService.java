package com.linksure.apservice.mailbox;

import android.app.IntentService;
import android.content.Intent;
import com.linksure.apservice.a.i;
import com.qihoo.util.StubApp1053578832;

public class ApsMsgService
  extends IntentService
{
  static
  {
    StubApp1053578832.interface11(72);
  }
  
  public ApsMsgService()
  {
    super("APS MAILBOX SERVICE");
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if ("com.linksure.aps.action.PUSH_MSG".equals(str))
    {
      paramIntent = paramIntent.getStringExtra("push_msg");
      i.b(this).a(paramIntent);
    }
    for (;;)
    {
      return;
      if ("com.linksure.action.LOGOUT".equals(str)) {
        com.linksure.apservice.a.b.f.a(this);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/mailbox/ApsMsgService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */