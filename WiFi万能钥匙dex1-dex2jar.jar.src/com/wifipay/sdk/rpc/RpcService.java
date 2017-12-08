package com.wifipay.sdk.rpc;

import com.wifipay.common.net.RpcFactory;

public class RpcService
{
  public static Object getRpcProxy(Class paramClass)
  {
    return RpcFactory.create(paramClass, null, false);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/sdk/rpc/RpcService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */