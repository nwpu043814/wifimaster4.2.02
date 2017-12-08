package com.wifipay.sdk.app;

import com.wifipay.sdk.modelpay.PayResp;
import com.wifipay.sdk.openapi.a;

class j
  implements com.wifipay.sdk.c.a.d
{
  j(WifiPayActivity paramWifiPayActivity) {}
  
  public void a()
  {
    PayResp localPayResp = new PayResp();
    localPayResp.errCode = -3;
    localPayResp.errMsg = com.wifipay.sdk.a.a.d.w;
    a.a(this.a, localPayResp);
    this.a.finish();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/sdk/app/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */