package com.wifipay.wallet.cashier.a;

import com.wifipay.framework.api.BackgroundExecutor.a;
import com.wifipay.wallet.common.rpc.RpcService;
import com.wifipay.wallet.prod.core.model.StartPayParams;
import com.wifipay.wallet.prod.transfer.TransferService;
import java.util.HashMap;

class y
  extends BackgroundExecutor.a
{
  y(x paramx) {}
  
  public void a()
  {
    TransferService localTransferService = (TransferService)RpcService.getRpcProxy(TransferService.class);
    x.a(this.a, localTransferService.newOrderCreateTrans((String)this.a.b.additionalParams.get("payeeLoginName"), (String)this.a.b.additionalParams.get("amount"), (String)this.a.b.additionalParams.get("agreementNo"), this.a.a, (String)this.a.b.additionalParams.get("paymentType"), "UT001"));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/cashier/a/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */