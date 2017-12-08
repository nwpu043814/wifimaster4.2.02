package com.wifipay.wallet.pay.activity;

import com.wifipay.framework.widget.WPAlertDialog.onPositiveListener;

class e
  implements WPAlertDialog.onPositiveListener
{
  e(WifiPayEntryActivity paramWifiPayEntryActivity) {}
  
  public void onPositive()
  {
    WifiPayEntryActivity.c(this.a);
    this.a.finish();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/pay/activity/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */