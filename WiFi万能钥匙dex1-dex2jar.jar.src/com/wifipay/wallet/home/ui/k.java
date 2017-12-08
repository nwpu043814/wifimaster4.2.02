package com.wifipay.wallet.home.ui;

import com.wifipay.framework.api.BackgroundExecutor.a;
import com.wifipay.wallet.home.a.a;
import com.wifipay.wallet.home.bean.SubApp;
import java.util.ArrayList;

class k
  extends BackgroundExecutor.a
{
  k(HomeActivity paramHomeActivity, ArrayList paramArrayList) {}
  
  public void a()
  {
    HomeActivity.b(this.b).a(((SubApp)this.a.get(HomeActivity.a(this.b))).downloadUrl, ((SubApp)this.a.get(HomeActivity.a(this.b))).id);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/ui/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */