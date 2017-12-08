package com.wifipay.sdk.rpc;

import com.wifipay.common.net.annotations.Header;
import com.wifipay.common.net.annotations.Host;
import com.wifipay.common.net.annotations.OperationType;
import com.wifipay.common.net.annotations.Param;
import com.wifipay.sdk.modelrpc.QueryOrderInfo;
import com.wifipay.sdk.modelrpc.UnionOrder;

@Host("https://wifipay.shengpay.com/")
public abstract interface RpcPayService
{
  @OperationType("wifipay/generatePayReqInfo.htm")
  public abstract QueryOrderInfo queryOrderInfo(@Header("app_access_time") String paramString1, @Header("app_access_sign") String paramString2, @Header("cookie") String paramString3, @Param("paymentType") String paramString4);
  
  @OperationType("wifipay/receiveOrder.htm")
  public abstract UnionOrder unionOrder(@Header("app_access_time") String paramString1, @Header("app_access_sign") String paramString2, @Param("appId") String paramString3, @Param("appName") String paramString4, @Param("openId") String paramString5, @Param("uhid") String paramString6, @Param("telNo") String paramString7, @Param("merchantNo") String paramString8, @Param("merchantOrderNo") String paramString9, @Param("orderAmount") String paramString10, @Param("clientIP") String paramString11, @Param("notifyUrl") String paramString12, @Param("goodsName") String paramString13, @Param("goodsDesc") String paramString14, @Param("sign") String paramString15, @Param("wifiVersion") String paramString16, @Param("wifiPubChannel") String paramString17, @Param("wifiToken") String paramString18);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/sdk/rpc/RpcPayService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */