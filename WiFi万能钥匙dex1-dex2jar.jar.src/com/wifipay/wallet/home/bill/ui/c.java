package com.wifipay.wallet.home.bill.ui;

import com.wifipay.framework.api.BackgroundExecutor.a;
import com.wifipay.wallet.common.rpc.RpcService;
import com.wifipay.wallet.home.bill.b;
import com.wifipay.wallet.home.bill.net.BillDetailsService;
import com.wifipay.wallet.home.bill.net.dto.BillDetails.Bills;
import java.util.List;

class c
  extends BackgroundExecutor.a
{
  c(WalletBillActivity paramWalletBillActivity) {}
  
  public void a()
  {
    if (WalletBillActivity.b(this.a))
    {
      WalletBillActivity.a(this.a, false);
      WalletBillActivity.a(this.a, 0);
      String str = b.a(System.currentTimeMillis());
      WalletBillActivity.a(this.a, "0");
      if ((WalletBillActivity.c(this.a) != null) && (WalletBillActivity.c(this.a).size() > 0)) {
        WalletBillActivity.a(this.a, ((BillDetails.Bills)WalletBillActivity.c(this.a).get(0)).tradeTime);
      }
      ((BillDetailsService)RpcService.getBgRpcProxy(BillDetailsService.class)).getBills(str, WalletBillActivity.d(this.a), "");
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/bill/ui/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */