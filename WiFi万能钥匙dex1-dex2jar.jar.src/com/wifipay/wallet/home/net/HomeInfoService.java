package com.wifipay.wallet.home.net;

import com.wifipay.common.net.annotations.Host;
import com.wifipay.common.net.annotations.OperationType;
import com.wifipay.common.net.annotations.Param;
import com.wifipay.wallet.home.net.dto.HomeInfoResp;

@Host("https://spmwgw.shengpay.com/spm-wallet-gw")
public abstract interface HomeInfoService
{
  @OperationType("/app/info.htm")
  public abstract HomeInfoResp queryHomeInfo(@Param("appId") String paramString1, @Param("appVersion") String paramString2);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/net/HomeInfoService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */