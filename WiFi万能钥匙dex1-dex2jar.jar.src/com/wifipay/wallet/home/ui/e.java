package com.wifipay.wallet.home.ui;

import com.wifipay.framework.api.BackgroundExecutor.a;
import com.wifipay.wallet.home.b.b;

class e
  extends BackgroundExecutor.a
{
  e(HomeActivity paramHomeActivity) {}
  
  public void a()
  {
    this.a.i = b.a().a("https://spmwgw.shengpay.com/spm-wallet-gw/app/info.htm");
    this.a.runOnUiThread(new f(this));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/ui/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */