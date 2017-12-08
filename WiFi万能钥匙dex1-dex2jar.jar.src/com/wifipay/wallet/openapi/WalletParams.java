package com.wifipay.wallet.openapi;

import java.io.Serializable;

public class WalletParams
  implements Serializable
{
  public String lati;
  public String longi;
  public String mapSP;
  public String uhid;
  public String userToken;
  
  public WalletParams() {}
  
  public WalletParams(String paramString1, String paramString2)
  {
    this.userToken = paramString1;
    this.uhid = paramString2;
  }
  
  public String getLati()
  {
    return this.lati;
  }
  
  public String getLongi()
  {
    return this.longi;
  }
  
  public String getMapSP()
  {
    return this.mapSP;
  }
  
  public String getUhid()
  {
    return this.uhid;
  }
  
  public String getUserToken()
  {
    return this.userToken;
  }
  
  public void setLati(String paramString)
  {
    this.lati = paramString;
  }
  
  public void setLongi(String paramString)
  {
    this.longi = paramString;
  }
  
  public void setMapSP(String paramString)
  {
    this.mapSP = paramString;
  }
  
  public void setUhid(String paramString)
  {
    this.uhid = paramString;
  }
  
  public void setUserToken(String paramString)
  {
    this.userToken = paramString;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/openapi/WalletParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */