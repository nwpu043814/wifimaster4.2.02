package com.wifipay.wallet;

import com.wifipay.framework.api.BackgroundExecutor.a;
import com.wifipay.framework.app.ui.SuperActivity;
import com.wifipay.wallet.common.rpc.RpcService;
import com.wifipay.wallet.prod.user.ThirdLoginResp;
import com.wifipay.wallet.prod.user.UserService;

class a
  extends BackgroundExecutor.a
{
  a(SecondLogin paramSecondLogin, String paramString1, String paramString2) {}
  
  public void a()
  {
    SecondLogin.a(this.c).c("");
    ThirdLoginResp localThirdLoginResp = ((UserService)RpcService.getRpcProxy(UserService.class)).thirdLogin(this.a, this.b);
    SecondLogin.a(this.c).d();
    SecondLogin.a(this.c).runOnUiThread(new b(this, localThirdLoginResp));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */