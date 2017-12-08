package com.wifipay.wallet.cashier.b;

import com.wifipay.framework.api.BackgroundExecutor.a;
import com.wifipay.wallet.common.rpc.RpcService;
import com.wifipay.wallet.prod.core.model.StartPayParams;
import com.wifipay.wallet.prod.pay.PayService;
import java.util.HashMap;

class k
  extends BackgroundExecutor.a
{
  k(i parami, String paramString) {}
  
  public void a()
  {
    PayService localPayService = (PayService)RpcService.getRpcProxy(PayService.class);
    this.b.a(localPayService.orderCreate((String)this.b.c.additionalParams.get("orderName"), (String)this.b.c.additionalParams.get("merchantNo"), (String)this.b.c.additionalParams.get("merchantOrderNo"), (String)this.b.c.additionalParams.get("memberId"), (String)this.b.c.additionalParams.get("loginName"), this.a, "CONVENIENCE", (String)this.b.c.additionalParams.get("amount"), "true", (String)this.b.c.additionalParams.get("notifyUrl")));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/cashier/b/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */