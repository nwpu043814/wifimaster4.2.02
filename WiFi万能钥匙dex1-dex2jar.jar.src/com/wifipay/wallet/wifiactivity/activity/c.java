package com.wifipay.wallet.wifiactivity.activity;

import android.view.View;
import com.wifipay.framework.widget.WPAlertDialog.onPositiveListener;

class c
  implements WPAlertDialog.onPositiveListener
{
  c(WifiActivitySMS paramWifiActivitySMS) {}
  
  public void onPositive()
  {
    WifiActivitySMS.c(this.a).startAnimation(WifiActivitySMS.b(this.a));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/wifiactivity/activity/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */