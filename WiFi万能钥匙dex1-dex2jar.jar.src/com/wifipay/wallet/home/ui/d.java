package com.wifipay.wallet.home.ui;

import android.webkit.WebView;

class d
  implements Runnable
{
  d(AccountWebActivity paramAccountWebActivity, String paramString1, String paramString2) {}
  
  public void run()
  {
    AccountWebActivity.b(this.c).loadUrl("javascript:showUserLevel(\"" + this.a + "\",\"" + this.b + "\")");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/ui/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */