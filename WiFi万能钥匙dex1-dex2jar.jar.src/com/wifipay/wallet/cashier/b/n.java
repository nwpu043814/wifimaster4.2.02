package com.wifipay.wallet.cashier.b;

import com.wifipay.framework.api.BackgroundExecutor.a;
import com.wifipay.framework.app.ui.SuperActivity;
import com.wifipay.wallet.common.rpc.ResponseCode;
import com.wifipay.wallet.common.rpc.RpcService;
import com.wifipay.wallet.prod.core.model.StartPayParams;
import com.wifipay.wallet.prod.deposit.QueryRemindResp;
import com.wifipay.wallet.prod.security.query.QueryService;
import java.util.HashMap;

class n
  extends BackgroundExecutor.a
{
  n(m paramm) {}
  
  public void a()
  {
    QueryRemindResp localQueryRemindResp = ((QueryService)RpcService.getRpcProxy(QueryService.class)).queryCheckRemind(this.a.c.type, (String)this.a.c.additionalParams.get("amount"));
    if (localQueryRemindResp != null)
    {
      if (!ResponseCode.SUCCESS.getCode().equals(localQueryRemindResp.resultCode)) {
        break label70;
      }
      this.a.e();
    }
    for (;;)
    {
      return;
      label70:
      if (ResponseCode.DEPOSIT_LEVEL_A.getCode().equals(localQueryRemindResp.resultCode))
      {
        this.a.b.d();
        this.a.a(localQueryRemindResp.resultMessage, 2);
      }
      else
      {
        this.a.b.d();
        this.a.b.b(localQueryRemindResp.resultMessage);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/cashier/b/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */