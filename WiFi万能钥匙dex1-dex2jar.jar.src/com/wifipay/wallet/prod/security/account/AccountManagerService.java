package com.wifipay.wallet.prod.security.account;

import com.wifipay.common.net.annotations.Header;
import com.wifipay.common.net.annotations.Host;
import com.wifipay.common.net.annotations.OperationType;
import com.wifipay.common.net.annotations.Param;
import com.wifipay.wallet.home.net.dto.HomeCztInfoResp;
import com.wifipay.wallet.prod.security.account.dto.CheckTokenResp;
import com.wifipay.wallet.prod.security.account.dto.QueryRNInfoResp;

@Host("https://spmwgw.shengpay.com/spm-wallet-gw")
public abstract interface AccountManagerService
{
  @OperationType("/login/checkToken.htm")
  public abstract CheckTokenResp checkToken(@Header("app_access_token") String paramString1, @Param("reqTime") String paramString2);
  
  @OperationType("/query/queryInfos.htm")
  public abstract HomeCztInfoResp queryHomeCztInfo();
  
  @OperationType("/realname/queryInfo.htm")
  public abstract QueryRNInfoResp queryRealName(@Param("reqTime") String paramString);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/prod/security/account/AccountManagerService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */