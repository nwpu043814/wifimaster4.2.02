package com.wifipay.wallet.cashier.b;

import com.wifipay.framework.api.BackgroundExecutor.a;
import com.wifipay.wallet.common.rpc.RpcService;
import com.wifipay.wallet.prod.core.model.StartPayParams;
import com.wifipay.wallet.prod.deposit.DepositService;
import java.util.HashMap;

class p
  extends BackgroundExecutor.a
{
  p(m paramm) {}
  
  public void a()
  {
    DepositService localDepositService = (DepositService)RpcService.getRpcProxy(DepositService.class);
    m.a(this.a, localDepositService.depositOrderSendCode((String)this.a.c.additionalParams.get("depositId"), (String)this.a.c.additionalParams.get("agreementNo"), (String)this.a.c.additionalParams.get("bankCode"), (String)this.a.c.additionalParams.get("cardType"), (String)this.a.c.additionalParams.get("cardNo"), (String)this.a.c.additionalParams.get("trueName"), (String)this.a.c.additionalParams.get("certNo"), (String)this.a.c.additionalParams.get("mobile")));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/cashier/b/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */