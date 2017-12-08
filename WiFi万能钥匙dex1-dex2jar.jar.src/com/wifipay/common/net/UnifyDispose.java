package com.wifipay.common.net;

import com.wifipay.common.net.entitybase.BaseResp;

public class UnifyDispose
{
  private BaseResp a;
  private String b;
  
  public UnifyDispose(BaseResp paramBaseResp, String paramString)
  {
    this.a = paramBaseResp;
    this.b = paramString;
  }
  
  public BaseResp getResponse()
  {
    return this.a;
  }
  
  public String getUrltag()
  {
    return this.b;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/common/net/UnifyDispose.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */