package com.wifipay.sdk.rpc;

import com.wifipay.sdk.a.a.a;
import com.wifipay.sdk.modelpay.PayReq;
import com.wifipay.sdk.modelrpc.QueryOrderInfo;
import com.wifipay.sdk.modelrpc.UnionOrder;
import com.wifipay.sdk.util.f;

public final class RpcClient
{
  public static QueryOrderInfo queryOrderInfo(String paramString1, String paramString2)
  {
    RpcPayService localRpcPayService = (RpcPayService)RpcService.getRpcProxy(RpcPayService.class);
    String str = String.valueOf(System.currentTimeMillis());
    return localRpcPayService.queryOrderInfo(str, f.b(str + a.a.d), paramString1, paramString2);
  }
  
  public static UnionOrder unionOrder(PayReq paramPayReq)
  {
    RpcPayService localRpcPayService = (RpcPayService)RpcService.getRpcProxy(RpcPayService.class);
    String str = String.valueOf(System.currentTimeMillis());
    return localRpcPayService.unionOrder(str, f.b(str + a.a.d), paramPayReq.appId, paramPayReq.appName, paramPayReq.openId, paramPayReq.uhId, paramPayReq.telNo, paramPayReq.merchantNo, paramPayReq.merchantOrderNo, paramPayReq.orderAmount, f.a(), paramPayReq.notifyUrl, paramPayReq.goodsName, paramPayReq.goodsDesc, paramPayReq.sign, paramPayReq.wifi_version, paramPayReq.wifi_pub_channel, paramPayReq.wifi_token);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/sdk/rpc/RpcClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */