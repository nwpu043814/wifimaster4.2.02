package com.wifipay.wallet.prod.withdraw;

import com.wifipay.common.net.annotations.Host;
import com.wifipay.common.net.annotations.OperationType;
import com.wifipay.common.net.annotations.Param;

@Host("https://spmwgw.shengpay.com/spm-wallet-gw")
public abstract interface WithdrawService
{
  @OperationType("/withdraw/doWithdraw.htm")
  public abstract WithdrawConfirmResp confirmWithdraw(@Param("bankAccountId") String paramString1, @Param("amount") String paramString2, @Param("payPwd") String paramString3);
  
  @OperationType("/withdraw/doWithdrawT0.htm")
  public abstract WithdrawConfirmResp confirmWithdrawT0(@Param("bankAccountId") String paramString1, @Param("amount") String paramString2, @Param("payPwd") String paramString3);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/prod/withdraw/WithdrawService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */