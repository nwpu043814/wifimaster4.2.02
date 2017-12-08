package com.wifipay.wallet.home.ui;

import com.wifipay.framework.api.BackgroundExecutor.a;
import com.wifipay.wallet.home.b.a;
import com.wifipay.wallet.home.net.dto.HomeInfoResp;

class g
  extends BackgroundExecutor.a
{
  g(HomeActivity paramHomeActivity, HomeInfoResp paramHomeInfoResp) {}
  
  public void a()
  {
    if (a.a().a("https://spmwgw.shengpay.com/spm-wallet-gw/app/info.htm", this.a)) {
      this.b.runOnUiThread(new h(this));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/ui/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */