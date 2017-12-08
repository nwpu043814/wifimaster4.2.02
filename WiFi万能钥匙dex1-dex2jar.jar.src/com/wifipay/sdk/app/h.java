package com.wifipay.sdk.app;

import com.wifipay.sdk.a.a.a;
import com.wifipay.sdk.util.a;
import com.wifipay.sdk.util.f;
import java.util.Map;

class h
  implements Runnable
{
  h(WifiPayActivity paramWifiPayActivity, Map paramMap, String paramString) {}
  
  public void run()
  {
    this.a.put("drawingRequestTime", f.a(System.currentTimeMillis()));
    WifiPayActivity.a(this.c, a.a.k, this.b);
    this.a.put("drawingResposeTime", f.a(System.currentTimeMillis()));
    this.a.put("merchantOrderNo", WifiPayActivity.a(this.c));
    a.a(this.c.getApplicationContext(), "cashier_h5", this.a);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/sdk/app/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */