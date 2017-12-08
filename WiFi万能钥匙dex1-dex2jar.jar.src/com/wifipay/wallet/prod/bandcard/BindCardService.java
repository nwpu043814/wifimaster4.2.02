package com.wifipay.wallet.prod.bandcard;

import com.wifipay.common.net.annotations.Host;
import com.wifipay.common.net.annotations.OperationType;
import com.wifipay.common.net.annotations.Param;
import com.wifipay.wallet.prod.bandcard.dto.BindCardCancelSignResp;
import com.wifipay.wallet.prod.bandcard.dto.BindCardCheckBinResp;
import com.wifipay.wallet.prod.bandcard.dto.BindCardDoSignResp;
import com.wifipay.wallet.prod.bandcard.dto.BindCardPreSignResp;

@Host("https://spmwgw.shengpay.com/spm-wallet-gw")
public abstract interface BindCardService
{
  @OperationType("/hps/cancelSign.htm")
  public abstract BindCardCancelSignResp cancelSign(@Param("agreementNo") String paramString1, @Param("payPwd") String paramString2);
  
  @OperationType("/hps/checkCardBin.htm")
  public abstract BindCardCheckBinResp checkBin(@Param("cardNo") String paramString);
  
  @OperationType("/hps/checkCardBinNotLogin.htm")
  public abstract BindCardCheckBinResp checkNotLogin(@Param("cardNo") String paramString);
  
  @OperationType("/hps/doSign.htm")
  public abstract BindCardDoSignResp doSign(@Param("requestNo") String paramString1, @Param("validCode") String paramString2, @Param("trueName") String paramString3, @Param("certNo") String paramString4, @Param("needSetPayPwd") String paramString5);
  
  @OperationType("/hps/preSign.htm")
  public abstract BindCardPreSignResp preSign(@Param("bankCode") String paramString1, @Param("cardNo") String paramString2, @Param("cardType") String paramString3, @Param("trueName") String paramString4, @Param("certNo") String paramString5, @Param("cvv2") String paramString6, @Param("validDate") String paramString7, @Param("mobile") String paramString8);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/prod/bandcard/BindCardService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */