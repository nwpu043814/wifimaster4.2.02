package com.wifipay.wallet.home.bill.ui;

import com.wifipay.framework.api.BackgroundExecutor.a;
import com.wifipay.wallet.home.bill.b;
import com.wifipay.wallet.home.bill.net.dto.BillDetails.Bills;
import java.util.List;

class f
  extends BackgroundExecutor.a
{
  f(e parame) {}
  
  public void a()
  {
    b.a(System.currentTimeMillis());
    WalletBillDetailActivity.a(this.a.b, "0");
    if ((this.a.a != null) && (this.a.a.size() > 0)) {
      WalletBillDetailActivity.a(this.a.b, ((BillDetails.Bills)this.a.a.get(0)).tradeTime);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/bill/ui/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */