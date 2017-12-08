package com.wifipay.sdk.openapi;

import android.content.Context;

public class APIFactory
{
  public static PayAPI createAPI(Context paramContext)
  {
    return new PayAPI(paramContext);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/sdk/openapi/APIFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */