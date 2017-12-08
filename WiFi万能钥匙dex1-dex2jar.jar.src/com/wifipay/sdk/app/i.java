package com.wifipay.sdk.app;

import android.webkit.WebView;
import com.wifipay.sdk.a.a.a;
import com.wifipay.sdk.util.a;
import com.wifipay.sdk.util.f;
import com.wifipay.sdk.util.h;
import java.util.Map;

class i
  implements Runnable
{
  i(WifiPayActivity paramWifiPayActivity, Map paramMap, String paramString) {}
  
  public void run()
  {
    WifiPayActivity.b(this.c).clearCache(true);
    WifiPayActivity.c(this.c).a();
    this.a.put("drawingRequestTime", f.a(System.currentTimeMillis()));
    WifiPayActivity.a(this.c, this.b);
    h.a(WifiPayActivity.b(this.c), a.a.k, this.b);
    this.a.put("drawingResposeTime", f.a(System.currentTimeMillis()));
    this.a.put("merchantOrderNo", WifiPayActivity.a(this.c));
    a.a(this.c.getApplicationContext(), "cashier_h5", this.a);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/sdk/app/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */