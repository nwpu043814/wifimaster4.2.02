package com.wifipay.wallet.cashier.a;

import com.wifipay.framework.api.BackgroundExecutor.a;
import com.wifipay.wallet.common.rpc.RpcService;
import com.wifipay.wallet.prod.bandcard.BindCardService;
import com.wifipay.wallet.prod.core.model.StartPayParams;
import java.util.HashMap;

class t
  extends BackgroundExecutor.a
{
  t(r paramr) {}
  
  public void a()
  {
    BindCardService localBindCardService = (BindCardService)RpcService.getRpcProxy(BindCardService.class);
    this.a.a(localBindCardService.preSign((String)this.a.b.additionalParams.get("bankCode"), (String)this.a.b.additionalParams.get("cardNo"), (String)this.a.b.additionalParams.get("cardType"), (String)this.a.b.additionalParams.get("trueName"), (String)this.a.b.additionalParams.get("certNo"), (String)this.a.b.additionalParams.get("cvv2"), (String)this.a.b.additionalParams.get("validDate"), (String)this.a.b.additionalParams.get("mobile")));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/cashier/a/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */