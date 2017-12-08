package com.wifipay.wallet.common.rpc;

import com.wifipay.common.net.RpcFactory;

public class RpcService
{
  public static <T> T getBgRpcProxy(Class<T> paramClass)
  {
    return (T)RpcFactory.create(paramClass, WPRpcInvocationHandler.class, true);
  }
  
  public static <T> T getRpcProxy(Class<T> paramClass)
  {
    return (T)RpcFactory.create(paramClass, WPRpcInvocationHandler.class, false);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/common/rpc/RpcService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */