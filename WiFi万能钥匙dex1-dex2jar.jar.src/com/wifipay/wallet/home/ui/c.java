package com.wifipay.wallet.home.ui;

import android.webkit.WebView;

class c
  implements Runnable
{
  c(AccountWebActivity paramAccountWebActivity, String paramString) {}
  
  public void run()
  {
    AccountWebActivity.b(this.b).loadUrl("javascript:showUserInfo(\"\",\"" + this.a + "\")");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/ui/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */