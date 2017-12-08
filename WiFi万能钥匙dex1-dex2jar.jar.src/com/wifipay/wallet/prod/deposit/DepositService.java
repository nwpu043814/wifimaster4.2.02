package com.wifipay.wallet.prod.deposit;

import com.wifipay.common.net.annotations.Host;
import com.wifipay.common.net.annotations.OperationType;
import com.wifipay.common.net.annotations.Param;
import com.wifipay.wallet.prod.security.query.CreditLevelResp;
import com.wifipay.wallet.prod.security.query.QueryPaymentResp;

@Host("https://spmwgw.shengpay.com/spm-wallet-gw")
public abstract interface DepositService
{
  @OperationType("/deposit/expressConfirmDeposit.htm")
  public abstract DepositOrderConfirmResp depositOrderConfirm(@Param("depositId") String paramString1, @Param("isSign") String paramString2, @Param("validCode") String paramString3);
  
  @OperationType("/deposit/receiveOrder.htm")
  public abstract DepositOrderCreateResp depositOrderCreate(@Param("amount") String paramString1, @Param("payPwd") String paramString2, @Param("transtype") String paramString3, @Param("agreementNo") String paramString4, @Param("cardNo") String paramString5);
  
  @OperationType("/deposit/expressPreDeposit.htm")
  public abstract DepositOrderSendCodeResp depositOrderSendCode(@Param("depositId") String paramString1, @Param("agreementNo") String paramString2, @Param("bankCode") String paramString3, @Param("cardType") String paramString4, @Param("cardNo") String paramString5, @Param("trueName") String paramString6, @Param("certNo") String paramString7, @Param("mobile") String paramString8);
  
  @OperationType("/deposit/signDeposit.htm")
  public abstract DepositOrderCreateResp newDepositConfirm(@Param("depositId") String paramString1, @Param("requestNo") String paramString2, @Param("validCode") String paramString3, @Param("certNo") String paramString4, @Param("trueName") String paramString5, @Param("mobile") String paramString6, @Param("payPwd") String paramString7);
  
  @OperationType("/aml/queryCredit.htm")
  public abstract CreditLevelResp queryCreditLevel(@Param("reqTime") String paramString);
  
  @OperationType("/query/queryPaymentToolCache.htm")
  public abstract QueryPaymentResp queryPaymentByBiz(@Param("merchantNo") String paramString1, @Param("bizCode") String paramString2, @Param("paymentType") String paramString3);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/prod/deposit/DepositService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */