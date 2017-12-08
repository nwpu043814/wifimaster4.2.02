package com.lantern.wifiseccheck.vpn.net;

import java.io.Serializable;

public class SignAppInfo
  implements Serializable
{
  private static final long serialVersionUID = 6316981355806838873L;
  private String cate;
  private String packageName;
  private String signNumber;
  
  public String getCate()
  {
    return this.cate;
  }
  
  public String getPackageName()
  {
    return this.packageName;
  }
  
  public String getSignNumber()
  {
    return this.signNumber;
  }
  
  public void setCate(String paramString)
  {
    this.cate = paramString;
  }
  
  public void setPackageName(String paramString)
  {
    this.packageName = paramString;
  }
  
  public void setSignNumber(String paramString)
  {
    this.signNumber = paramString;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/vpn/net/SignAppInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */