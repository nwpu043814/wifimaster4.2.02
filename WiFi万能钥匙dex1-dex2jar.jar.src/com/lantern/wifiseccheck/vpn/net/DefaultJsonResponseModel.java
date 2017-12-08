package com.lantern.wifiseccheck.vpn.net;

public class DefaultJsonResponseModel
  implements IJsonResponseModel
{
  private String retCd = "0";
  private String retMsg;
  private String retSn;
  
  public String getRetCd()
  {
    return this.retCd;
  }
  
  public String getRetMsg()
  {
    return this.retMsg;
  }
  
  public String getRetSn()
  {
    return this.retSn;
  }
  
  public void setRetCd(String paramString)
  {
    this.retCd = paramString;
  }
  
  public void setRetMsg(String paramString)
  {
    this.retMsg = paramString;
  }
  
  public void setRetSn(String paramString)
  {
    this.retSn = paramString;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/vpn/net/DefaultJsonResponseModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */