package com.wifipay.wallet.pay.activity;

import com.wifipay.framework.app.a;
import com.wifipay.framework.widget.WPAlertDialog.onPositiveListener;

class d
  implements WPAlertDialog.onPositiveListener
{
  d(WifiPayEntryActivity paramWifiPayEntryActivity) {}
  
  public void onPositive()
  {
    if (WifiPayEntryActivity.a(this.a) != 0) {
      a.b();
    }
    this.a.finish();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/pay/activity/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */