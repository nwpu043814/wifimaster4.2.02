package com.wifipay.wallet.cashier.a;

import com.wifipay.framework.api.BackgroundExecutor.a;
import com.wifipay.wallet.common.rpc.RpcService;
import com.wifipay.wallet.prod.core.model.StartPayParams;
import com.wifipay.wallet.prod.deposit.DepositService;
import java.util.HashMap;

class n
  extends BackgroundExecutor.a
{
  n(m paramm) {}
  
  public void a()
  {
    DepositService localDepositService = (DepositService)RpcService.getRpcProxy(DepositService.class);
    m.a(this.a, localDepositService.depositOrderCreate((String)this.a.b.additionalParams.get("amount"), this.a.a, "1", (String)this.a.b.additionalParams.get("agreementNo"), (String)this.a.b.additionalParams.get("cardNo")));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/cashier/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */