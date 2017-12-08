package com.wifipay.wallet.cashier.a;

import com.wifipay.framework.api.BackgroundExecutor.a;
import com.wifipay.wallet.common.rpc.RpcService;
import com.wifipay.wallet.prod.paypassword.PPService;

class j
  extends BackgroundExecutor.a
{
  j(i parami, String paramString) {}
  
  public void a()
  {
    PPService localPPService = (PPService)RpcService.getRpcProxy(PPService.class);
    i.a(this.b, localPPService.verifyPayPwd(this.a));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/cashier/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */