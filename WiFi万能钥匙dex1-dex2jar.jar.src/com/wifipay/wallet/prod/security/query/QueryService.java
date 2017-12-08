package com.wifipay.wallet.prod.security.query;

import com.wifipay.common.net.annotations.Host;
import com.wifipay.common.net.annotations.OperationType;
import com.wifipay.common.net.annotations.Param;
import com.wifipay.wallet.prod.deposit.QueryRemindResp;

@Host("https://spmwgw.shengpay.com/spm-wallet-gw")
public abstract interface QueryService
{
  @OperationType("/query/queryMemberCategory.htm")
  public abstract QueryCategoryResp queryCategory(@Param("reqTime") String paramString);
  
  @OperationType("/aml/moneyCheck.htm")
  public abstract QueryRemindResp queryCheckRemind(@Param("checkType") String paramString1, @Param("amount") String paramString2);
  
  @OperationType("/aml/queryCredit.htm")
  public abstract CreditLevelResp queryCreditLevel(@Param("reqTime") String paramString);
  
  @OperationType("/deposit/queryHpsCard.htm")
  public abstract QueryHpsCardResp queryHpsCard(@Param("reqTime") String paramString);
  
  @OperationType("/query/queryPaymentToolCache.htm")
  public abstract QueryPaymentResp queryPaymentByBiz(@Param("merchantNo") String paramString1, @Param("bizCode") String paramString2, @Param("paymentType") String paramString3);
  
  @OperationType("/wallet/queryBalance.htm")
  public abstract WalletBalanceResp queryWalletBalance(@Param("reqTime") String paramString);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/prod/security/query/QueryService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */