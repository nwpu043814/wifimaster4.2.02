package com.wifipay.sdk.openapi;

import com.wifipay.sdk.modelpay.PayResp;

public class b
{
  public static PayResp a()
  {
    return a(null);
  }
  
  public static PayResp a(String paramString)
  {
    PayResp localPayResp = new PayResp();
    localPayResp.errCode = -2;
    if (paramString != null) {}
    for (;;)
    {
      localPayResp.errMsg = paramString;
      return localPayResp;
      paramString = "unknown error";
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/sdk/openapi/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */