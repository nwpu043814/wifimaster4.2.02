package com.wifipay.wallet.cashier.a;

import com.wifipay.framework.api.BackgroundExecutor.a;
import com.wifipay.wallet.prod.core.model.PayCard;
import com.wifipay.wallet.prod.core.model.StartPayParams;
import com.wifipay.wallet.prod.withdraw.WithdrawService;
import java.util.HashMap;

class ab
  extends BackgroundExecutor.a
{
  ab(z paramz, WithdrawService paramWithdrawService) {}
  
  public void a()
  {
    z.a(this.b, this.a.confirmWithdraw(this.b.b.chosenCard.agreementNo, (String)this.b.b.additionalParams.get("amount"), this.b.a));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/cashier/a/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */