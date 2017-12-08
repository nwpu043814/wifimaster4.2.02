package com.wifipay.wallet.wifilogin.receiver;

import com.wifipay.framework.api.BackgroundExecutor.a;
import com.wifipay.wallet.common.rpc.RpcService;
import com.wifipay.wallet.prod.logout.LogoutService;

class a
  extends BackgroundExecutor.a
{
  a(WiFiLogoutReceiver paramWiFiLogoutReceiver) {}
  
  public void a()
  {
    LogoutService localLogoutService = (LogoutService)RpcService.getRpcProxy(LogoutService.class);
    WiFiLogoutReceiver.a(this.a, localLogoutService.deleteToken());
    com.wifipay.wallet.wifilogin.a.a.a();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/wifilogin/receiver/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */