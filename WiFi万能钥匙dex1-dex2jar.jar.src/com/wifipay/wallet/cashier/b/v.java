package com.wifipay.wallet.cashier.b;

import com.wifipay.framework.api.BackgroundExecutor.a;
import com.wifipay.wallet.prod.core.model.StartPayParams;
import com.wifipay.wallet.prod.withdraw.WithdrawService;
import java.util.HashMap;

class v
  extends BackgroundExecutor.a
{
  v(s params, WithdrawService paramWithdrawService, String paramString) {}
  
  public void a()
  {
    s.a(this.c, this.a.confirmWithdraw(this.b, (String)this.c.c.additionalParams.get("amount"), s.a(this.c)));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/cashier/b/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */