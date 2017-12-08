package com.wifipay.wallet.prod.pay;

import com.wifipay.common.net.annotations.Host;
import com.wifipay.common.net.annotations.OperationType;
import com.wifipay.common.net.annotations.Param;
import com.wifipay.common.net.entitybase.BaseResp;

@Host("https://spmwgw.shengpay.com/spm-wallet-gw")
public abstract interface PayService
{
  @OperationType("/payment/receiveOrder.htm")
  public abstract NewResultResp newOrderCreate(@Param("payerMemberId") String paramString1, @Param("amount") String paramString2, @Param("agreementNo") String paramString3, @Param("paymentType") String paramString4, @Param("notifyUrl") String paramString5, @Param("merchantOrederNo") String paramString6, @Param("orderName") String paramString7, @Param("merchantNo") String paramString8, @Param("merchantName") String paramString9, @Param("payPwd") String paramString10);
  
  @OperationType("/payment/signPayment.htm")
  public abstract NewResultResp newOrderPay(@Param("payerMemberId") String paramString1, @Param("merchantNo") String paramString2, @Param("merchantOrederNo") String paramString3, @Param("amount") String paramString4, @Param("verifyCode") String paramString5, @Param("requestNo") String paramString6, @Param("realName") String paramString7, @Param("idCard") String paramString8, @Param("paymentType") String paramString9, @Param("notifyUrl") String paramString10, @Param("payPwd") String paramString11, @Param("orderId") String paramString12, @Param("mobileNo") String paramString13);
  
  @OperationType("/payment/pay.htm")
  public abstract PayResultResp orderCreate(@Param("orderName") String paramString1, @Param("merchantNo") String paramString2, @Param("merchantOrederNo") String paramString3, @Param("payerMemberId") String paramString4, @Param("payerLoginName") String paramString5, @Param("payPwd") String paramString6, @Param("paymentType") String paramString7, @Param("amount") String paramString8, @Param("isSign") String paramString9, @Param("notifyUrl") String paramString10);
  
  @OperationType("/payment/confirmPay.htm")
  public abstract PayResultResp orderPay(@Param("agreementNo") String paramString1, @Param("orderId") String paramString2, @Param("paymentType") String paramString3, @Param("payPwd") String paramString4, @Param("verifyCode") String paramString5, @Param("payerMemberId") String paramString6, @Param("payerLoginName") String paramString7);
  
  @OperationType("/payment/paySendSms.htm")
  public abstract BaseResp preCheck(@Param("orderId") String paramString1, @Param("payPwd") String paramString2, @Param("agreementNo") String paramString3, @Param("payerMemberId") String paramString4, @Param("bankCode") String paramString5, @Param("bankCardType") String paramString6, @Param("bankCardNo") String paramString7, @Param("realName") String paramString8, @Param("idCard") String paramString9, @Param("mobileNo") String paramString10, @Param("cvv2") String paramString11, @Param("validThru") String paramString12);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/prod/pay/PayService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */