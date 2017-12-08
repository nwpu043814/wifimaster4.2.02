package com.wifipay.wallet.card.ui;

import com.wifipay.framework.widget.WPAlertDialog.onNegativeListener;

class d
  implements WPAlertDialog.onNegativeListener
{
  d(UnBindCardActivity paramUnBindCardActivity) {}
  
  public void onNegative()
  {
    this.a.runOnUiThread(new e(this));
    UnBindCardActivity.b(this.a);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/card/ui/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */