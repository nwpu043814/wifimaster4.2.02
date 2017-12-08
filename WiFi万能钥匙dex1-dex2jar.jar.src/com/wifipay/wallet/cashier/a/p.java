package com.wifipay.wallet.cashier.a;

import com.wifipay.framework.api.BackgroundExecutor.a;
import com.wifipay.wallet.common.rpc.RpcService;
import com.wifipay.wallet.prod.pay.PayService;

class p
  extends BackgroundExecutor.a
{
  p(o paramo) {}
  
  public void a()
  {
    o.a(this.a, (PayService)RpcService.getRpcProxy(PayService.class));
    this.a.a(this.a.b());
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/cashier/a/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */