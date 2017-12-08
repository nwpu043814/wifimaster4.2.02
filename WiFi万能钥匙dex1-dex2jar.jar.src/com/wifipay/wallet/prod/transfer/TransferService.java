package com.wifipay.wallet.prod.transfer;

import com.wifipay.common.net.annotations.Host;
import com.wifipay.common.net.annotations.OperationType;
import com.wifipay.common.net.annotations.Param;
import com.wifipay.common.net.entitybase.BaseResp;

@Host("https://spmwgw.shengpay.com/spm-wallet-gw")
public abstract interface TransferService
{
  @OperationType("/trans/doTrans3.htm")
  public abstract TransConfirm3Resp confirmTrans3(@Param("amount") String paramString1, @Param("payeeLoginName") String paramString2, @Param("payPwd") String paramString3, @Param("paymentType") String paramString4, @Param("bizType") String paramString5, @Param("memo") String paramString6, @Param("agreementNo") String paramString7, @Param("cardNo") String paramString8);
  
  @OperationType("/trans/doCardTrans3.htm")
  public abstract TransConfirm3Resp confirmTrans3WithSms(@Param("orderId") String paramString1, @Param("validCode") String paramString2, @Param("isSign") String paramString3);
  
  @OperationType("/trans/doCardTransSign.htm")
  public abstract TransConfirm3Resp newOrderConfirmTrans(@Param("orderId") String paramString1, @Param("validCode") String paramString2, @Param("certNo") String paramString3, @Param("trueName") String paramString4, @Param("requestNo") String paramString5, @Param("mobile") String paramString6, @Param("payPwd") String paramString7, @Param("payeeLoginName") String paramString8);
  
  @OperationType("/trans/cardTrans.htm")
  public abstract TransConfirm3Resp newOrderCreateTrans(@Param("payeeLoginName") String paramString1, @Param("amount") String paramString2, @Param("agreementNo") String paramString3, @Param("payPwd") String paramString4, @Param("paymentType") String paramString5, @Param("bizType") String paramString6);
  
  @OperationType("/trans/queryContacts.htm")
  public abstract TransQueryContactsResp queryContacts(@Param("reqTime") String paramString);
  
  @OperationType("/trans/queryPayee.htm")
  public abstract TransQueryPayeeResp queryPayee(@Param("payeeLoginName") String paramString);
  
  @OperationType("/trans/queryPayee.htm")
  public abstract TransQueryPayeeResp queryPayee2(@Param("payeeLoginName") String paramString);
  
  @OperationType("/trans/sendSms3.htm")
  public abstract BaseResp trans3SendSms(@Param("orderId") String paramString1, @Param("agreementNo") String paramString2, @Param("bankCode") String paramString3, @Param("cardType") String paramString4, @Param("cardNo") String paramString5, @Param("trueName") String paramString6, @Param("certNo") String paramString7, @Param("mobile") String paramString8);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/prod/transfer/TransferService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */