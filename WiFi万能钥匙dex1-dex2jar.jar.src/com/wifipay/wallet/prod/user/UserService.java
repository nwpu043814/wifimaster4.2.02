package com.wifipay.wallet.prod.user;

import com.wifipay.common.net.annotations.Host;
import com.wifipay.common.net.annotations.OperationType;
import com.wifipay.common.net.annotations.Param;
import com.wifipay.wallet.home.setting.option.dto.FeedBackResp;

@Host("https://spmwgw.shengpay.com/spm-wallet-gw")
public abstract interface UserService
{
  @OperationType("/member/getIcon.htm")
  public abstract HeadimgResp getHeadImg(@Param("loginName") String paramString);
  
  @OperationType("/member/insertFeedBack.htm")
  public abstract FeedBackResp sendSuggest(@Param("contactWay") String paramString1, @Param("content") String paramString2, @Param("mobile") String paramString3, @Param("appVersion") String paramString4, @Param("mobileModle") String paramString5);
  
  @OperationType("/thirdLogin.htm")
  public abstract ThirdLoginResp thirdLogin(@Param("outToken") String paramString1, @Param("uhId") String paramString2);
  
  @OperationType("/aml/certSubmit.htm")
  public abstract UploadResp uploadPhotoCopy(@Param("picData1") String paramString1, @Param("picData2") String paramString2, @Param("picSuffix") String paramString3, @Param("expiredTimeStart") String paramString4, @Param("expiredTime") String paramString5);
  
  @OperationType("/aml/certSubmitStep1.htm")
  public abstract UploadResp uploadPhotoOne(@Param("picData1") String paramString1, @Param("picSuffix") String paramString2, @Param("expiredTimeStart") String paramString3, @Param("expiredTime") String paramString4);
  
  @OperationType("/aml/certSubmitStep2.htm")
  public abstract UploadResp uploadPhotoTwo(@Param("picData2") String paramString1, @Param("picSuffix") String paramString2, @Param("expiredTimeStart") String paramString3, @Param("expiredTime") String paramString4);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/prod/user/UserService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */