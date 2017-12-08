package com.wifipay.wallet.prod.logout;

import com.wifipay.common.net.annotations.Host;
import com.wifipay.common.net.annotations.OperationType;
import com.wifipay.common.net.entitybase.BaseResp;

@Host("https://spmwgw.shengpay.com/spm-wallet-gw")
public abstract interface LogoutService
{
  @OperationType("/thirdLogin/deleteToken.htm")
  public abstract BaseResp deleteToken();
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/prod/logout/LogoutService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */