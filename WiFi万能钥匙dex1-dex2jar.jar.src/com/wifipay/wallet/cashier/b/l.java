package com.wifipay.wallet.cashier.b;

import com.wifipay.framework.api.BackgroundExecutor.a;
import com.wifipay.wallet.common.rpc.RpcService;
import com.wifipay.wallet.prod.core.model.StartPayParams;
import com.wifipay.wallet.prod.pay.PayResultResp;
import com.wifipay.wallet.prod.pay.PayResultResp.ResultObject;
import com.wifipay.wallet.prod.pay.PayService;
import java.util.HashMap;

class l
  extends BackgroundExecutor.a
{
  l(i parami, PayResultResp paramPayResultResp) {}
  
  public void a()
  {
    PayService localPayService = (PayService)RpcService.getRpcProxy(PayService.class);
    this.b.a(localPayService.preCheck(this.a.resultObject.orderId, (String)this.b.c.additionalParams.get("payPwd"), (String)this.b.c.additionalParams.get("agreementNo"), (String)this.b.c.additionalParams.get("memberId"), null, null, null, null, null, null, null, null));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/cashier/b/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */