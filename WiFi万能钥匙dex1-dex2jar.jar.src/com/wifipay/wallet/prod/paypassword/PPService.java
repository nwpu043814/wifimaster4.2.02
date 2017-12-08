package com.wifipay.wallet.prod.paypassword;

import com.wifipay.common.net.annotations.Host;
import com.wifipay.common.net.annotations.OperationType;
import com.wifipay.common.net.annotations.Param;

@Host("https://spmwgw.shengpay.com/spm-wallet-gw")
public abstract interface PPService
{
  @OperationType("/payPwd/modifyPwd2.htm")
  public abstract ModifyPPResp modifyPayPwd(@Param("oldPayPwd") String paramString1, @Param("newPayPwd") String paramString2, @Param("payRePwd") String paramString3, @Param("extJson") String paramString4);
  
  @OperationType("/payPwd/isSetDigitPwd.htm")
  public abstract QueryDigitPwdResp queryDigitPwd(@Param("reqTime") String paramString);
  
  @OperationType("/payPwd/confirmResetPwd.htm")
  public abstract ResetPPConfirmResp resetPPConfirm(@Param("requestNo") String paramString1, @Param("payPwd") String paramString2);
  
  @OperationType("/payPwd/confirmResetPwd2.htm")
  public abstract ResetPPConfirmResp resetPPConfirmSecond(@Param("requestNo") String paramString1, @Param("payPwd") String paramString2, @Param("payRePwd") String paramString3);
  
  @OperationType("/payPwd/resetPwdPreCheck.htm")
  public abstract ResetPPPreResp resetPPPre(@Param("agreementNo") String paramString1, @Param("certNo") String paramString2, @Param("cardNo") String paramString3, @Param("cvv2") String paramString4, @Param("validDate") String paramString5, @Param("mobile") String paramString6);
  
  @OperationType("/payPwd/resetPayPwdSendSms.htm")
  public abstract ResetPPSmsResp resetPPSendSms(@Param("reqTime") String paramString);
  
  @OperationType("/payPwd/resetPwdCheckValidCode.htm")
  public abstract ResetPPSmsResp resetPPVerifyCode(@Param("requestNo") String paramString1, @Param("mobile") String paramString2, @Param("validCode") String paramString3);
  
  @OperationType("/payPwd/resetPayPwdVerifySms.htm")
  public abstract ResetPPSmsResp resetPPVerifySms(@Param("requestNo") String paramString1, @Param("validCode") String paramString2);
  
  @OperationType("/hps/setPayPwd.htm")
  public abstract SetPwdResp setPayPwd(@Param("requestNo") String paramString1, @Param("payPwd") String paramString2);
  
  @OperationType("/hps/setPayPwd2.htm")
  public abstract SetPwdResp setPayPwdSecond(@Param("requestNo") String paramString1, @Param("payPwd") String paramString2, @Param("payRePwd") String paramString3);
  
  @OperationType("/payPwd/checkPwd.htm")
  public abstract VerifyPayPwdResp verifyPayPwd(@Param("payPwd") String paramString);
  
  @OperationType("/payPwd/checkPwd.htm")
  public abstract VerifyPayPwdResp verifyPayPwd(@Param("payPwd") String paramString1, @Param("extJson") String paramString2);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/prod/paypassword/PPService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */