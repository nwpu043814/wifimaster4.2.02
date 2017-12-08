package com.wifipay.wallet.cashier.b;

import com.wifipay.framework.api.BackgroundExecutor.a;
import com.wifipay.wallet.common.rpc.RpcService;
import com.wifipay.wallet.prod.core.model.StartPayParams;
import com.wifipay.wallet.prod.deposit.DepositService;
import java.util.HashMap;

class o
  extends BackgroundExecutor.a
{
  o(m paramm, String paramString1, String paramString2) {}
  
  public void a()
  {
    DepositService localDepositService = (DepositService)RpcService.getRpcProxy(DepositService.class);
    m.a(this.c, localDepositService.depositOrderCreate((String)this.c.c.additionalParams.get("amount"), this.a, "1", this.b, null));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/cashier/b/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */