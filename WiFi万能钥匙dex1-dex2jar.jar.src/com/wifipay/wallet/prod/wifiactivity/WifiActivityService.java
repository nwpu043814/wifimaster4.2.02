package com.wifipay.wallet.prod.wifiactivity;

import com.wifipay.common.net.annotations.Host;
import com.wifipay.common.net.annotations.OperationType;
import com.wifipay.common.net.annotations.Param;

@Host("https://spmwgw.shengpay.com/spm-wallet-gw")
public abstract interface WifiActivityService
{
  @OperationType("/wifi/h5AppReg.htm")
  public abstract WifiActivityCheckResp wifiActivityCheck(@Param("trueName") String paramString1, @Param("identityNo") String paramString2, @Param("cardNo") String paramString3, @Param("mobileNo") String paramString4, @Param("merchantNo") String paramString5, @Param("merchantOrderNo") String paramString6, @Param("validDate") String paramString7, @Param("cvv2") String paramString8, @Param("bankCode") String paramString9, @Param("cardType") String paramString10, @Param("imei") String paramString11);
  
  @OperationType("/payment/payAndReceiveNoPwd.htm")
  public abstract WifiActivityPayResp wifiActivityPay(@Param("payerMemberId") String paramString1, @Param("merchantNo") String paramString2, @Param("merchantOrederNo") String paramString3, @Param("amount") String paramString4, @Param("verifyCode") String paramString5, @Param("requestNo") String paramString6, @Param("realName") String paramString7, @Param("idCard") String paramString8, @Param("paymentType") String paramString9, @Param("notifyUrl") String paramString10, @Param("mobileNo") String paramString11);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/prod/wifiactivity/WifiActivityService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */