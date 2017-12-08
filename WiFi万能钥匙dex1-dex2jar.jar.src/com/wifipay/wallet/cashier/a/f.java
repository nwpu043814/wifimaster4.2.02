package com.wifipay.wallet.cashier.a;

import com.wifipay.wallet.cashier.CashierType;
import com.wifipay.wallet.cashier.PayListener;
import com.wifipay.wallet.paypassword.common.PreRetrievePP.onListener;
import com.wifipay.wallet.prod.core.model.StartPayParams;

class f
  implements PreRetrievePP.onListener
{
  f(a parama) {}
  
  public void afterCheck()
  {
    if (!this.a.b.type.equals(CashierType.CALLAPPPAY.getType())) {
      this.a.a(0, null);
    }
    for (;;)
    {
      return;
      if (com.wifipay.wallet.common.utils.f.a(this.a.d)) {
        this.a.d.rePay();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/cashier/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */