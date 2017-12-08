package com.wifipay.wallet.home.bill.net;

import com.wifipay.common.net.annotations.Host;
import com.wifipay.common.net.annotations.OperationType;
import com.wifipay.common.net.annotations.Param;
import com.wifipay.wallet.home.bill.net.dto.BillDetails;

@Host("https://spmwgw.shengpay.com/spm-wallet-gw")
public abstract interface BillDetailsService
{
  @OperationType("/query/queryTradeInfo.htm")
  public abstract BillDetails getBills(@Param("regTime") String paramString1, @Param("startTime") String paramString2, @Param("endTime") String paramString3);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/bill/net/BillDetailsService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */