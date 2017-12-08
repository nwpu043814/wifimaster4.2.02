package com.wifipay.wallet.home.setting.option;

import com.wifipay.common.net.annotations.Host;
import com.wifipay.common.net.annotations.OperationType;
import com.wifipay.common.net.annotations.Param;
import com.wifipay.wallet.home.setting.option.dto.FeedBackResp;

@Host("https://spmwgw.shengpay.com/spm-wallet-gw")
public abstract interface FeedBackService
{
  @OperationType("/member/insertFeedBack.htm")
  public abstract FeedBackResp sendSuggest(@Param("contactWay") String paramString1, @Param("content") String paramString2, @Param("mobile") String paramString3, @Param("appVersion") String paramString4, @Param("mobileModle") String paramString5);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/setting/option/FeedBackService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */