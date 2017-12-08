package com.wifipay.wallet.wifilogin.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.qihoo.util.StubApp1053578832;
import com.wifipay.common.logging.Logger;
import com.wifipay.common.net.entitybase.BaseResp;
import com.wifipay.framework.api.BackgroundExecutor;

public class WiFiLogoutReceiver
  extends BroadcastReceiver
{
  static
  {
    StubApp1053578832.interface11(141);
  }
  
  private void a()
  {
    BackgroundExecutor.a(new a(this));
  }
  
  private void a(BaseResp paramBaseResp)
  {
    if (paramBaseResp != null)
    {
      Logger.i("WiFiLogoutReceiver == %s", new Object[] { "resultCode = " + paramBaseResp.resultCode });
      Logger.i("WiFiLogoutReceiver == %s", new Object[] { "resultMessage = " + paramBaseResp.resultMessage });
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Logger.i("WiFiLogoutReceiver == %s", new Object[] { "action = " + paramIntent.getAction() });
    if ((paramIntent.getAction().equals("wifi.intent.action.LOGINOUT")) && (com.wifipay.wallet.common.a.b)) {
      a();
    }
    com.wifipay.wallet.common.a.b = true;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/wifilogin/receiver/WiFiLogoutReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */