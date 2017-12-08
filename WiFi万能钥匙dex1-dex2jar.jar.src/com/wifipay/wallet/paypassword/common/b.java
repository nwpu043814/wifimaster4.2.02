package com.wifipay.wallet.paypassword.common;

import com.wifipay.framework.api.BackgroundExecutor.a;
import com.wifipay.wallet.common.rpc.RpcService;
import com.wifipay.wallet.prod.paypassword.PPService;

class b
  extends BackgroundExecutor.a
{
  b(a parama) {}
  
  public void a()
  {
    PPService localPPService = (PPService)RpcService.getRpcProxy(PPService.class);
    a.a(this.a, localPPService.queryDigitPwd(String.valueOf(System.currentTimeMillis())));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/paypassword/common/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */