package com.wifipay.wallet.paypassword.ui;

import com.wifipay.wallet.paypassword.widget.WPSafeKeyboard;

class i
  implements Runnable
{
  i(ResetPPActivity paramResetPPActivity) {}
  
  public void run()
  {
    ResetPPActivity.a(this.a).deletePassword(true);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/paypassword/ui/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */