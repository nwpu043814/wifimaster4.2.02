package com.wifipay.wallet.paypassword.ui;

import com.wifipay.framework.widget.WPAlertDialog.onPositiveListener;

class c
  implements WPAlertDialog.onPositiveListener
{
  c(ModifyOldPPActivity paramModifyOldPPActivity) {}
  
  public void onPositive()
  {
    this.a.runOnUiThread(new d(this));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/paypassword/ui/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */