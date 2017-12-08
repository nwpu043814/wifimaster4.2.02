package com.wifipay.wallet.prod.cert;

import com.wifipay.common.net.annotations.Host;
import com.wifipay.common.net.annotations.OperationType;
import com.wifipay.common.net.annotations.Param;

@Host("https://spmwgw.shengpay.com/spm-wallet-gw")
public abstract interface CertService
{
  @OperationType("/getKey.htm")
  public abstract RSARes getRSACert(@Param("skipTime") String paramString);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/prod/cert/CertService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */