package com.wifipay.wallet.cashier.ui;

import com.wifipay.framework.widget.WPAlertDialog.onNegativeListener;

class h
  implements WPAlertDialog.onNegativeListener
{
  h(PasswordSingleVerifyActivity paramPasswordSingleVerifyActivity) {}
  
  public void onNegative()
  {
    PasswordSingleVerifyActivity.a(this.a);
    PasswordSingleVerifyActivity.b(this.a);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/cashier/ui/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */