package com.wifipay.wallet.home.bill.ui;

import com.wifipay.framework.api.BackgroundExecutor.a;
import java.util.List;

class a
  extends BackgroundExecutor.a
{
  a(WalletBillActivity paramWalletBillActivity) {}
  
  public void a()
  {
    List localList = com.wifipay.wallet.home.bill.b.a.a(this.a).a(WalletBillActivity.a(this.a));
    this.a.runOnUiThread(new b(this, localList));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/bill/ui/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */