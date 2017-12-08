package com.wifipay.wallet.home.ui;

import com.wifipay.wallet.common.utils.f;
import com.wifipay.wallet.home.net.dto.HomeInfoResp;
import com.wifipay.wallet.home.net.dto.HomeInfoResp.ResultObject;
import java.util.ArrayList;

class h
  implements Runnable
{
  h(g paramg) {}
  
  public void run()
  {
    if ((f.a(this.a.a.resultObject.subapps)) && (this.a.a.resultObject.subapps.size() > 0)) {
      HomeActivity.a(this.a.b, this.a.a.resultObject.subapps);
    }
    this.a.b.a(this.a.a);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/ui/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */