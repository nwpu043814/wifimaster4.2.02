package com.wifipay.wallet.cashier.a;

import com.wifipay.framework.widget.WPAlertDialog.onPositiveListener;
import com.wifipay.wallet.cashier.PayListener;
import com.wifipay.wallet.common.utils.f;

class e
  implements WPAlertDialog.onPositiveListener
{
  e(a parama) {}
  
  public void onPositive()
  {
    if (f.a(this.a.d)) {
      this.a.d.rePay();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/cashier/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */