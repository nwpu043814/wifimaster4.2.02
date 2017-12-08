package com.wifipay.wallet.cashier.b;

import com.wifipay.framework.api.BackgroundExecutor;
import com.wifipay.framework.widget.WPAlertDialog.onNegativeListener;

class c
  implements WPAlertDialog.onNegativeListener
{
  c(a parama) {}
  
  public void onNegative()
  {
    BackgroundExecutor.a(new d(this));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/cashier/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */