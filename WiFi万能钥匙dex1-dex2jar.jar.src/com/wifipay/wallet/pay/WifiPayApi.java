package com.wifipay.wallet.pay;

import com.wifipay.wallet.prod.pay.WifiPayReq;

public abstract interface WifiPayApi
{
  public abstract SPayResp sendReq(WifiPayReq paramWifiPayReq);
  
  public abstract SPayResp sendReq(String paramString);
  
  public abstract SPayResp sendReqAct(WifiPayReq paramWifiPayReq);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/pay/WifiPayApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */