package cm.pass.sdk.account;

import java.io.Serializable;

public class UserInfo
  implements Serializable
{
  private String authToken;
  private String authType;
  private String imei;
  private String imsi;
  private String machineCode;
  private String passid;
  private String timeStamp;
  private String tokenNonce;
  private String userName;
  
  public String getAuthToken()
  {
    return this.authToken;
  }
  
  public String getAuthType()
  {
    return this.authType;
  }
  
  public String getImei()
  {
    return this.imei;
  }
  
  public String getImsi()
  {
    return this.imsi;
  }
  
  public String getMachineCode()
  {
    return this.machineCode;
  }
  
  public String getPassid()
  {
    return this.passid;
  }
  
  public String getTimeStamp()
  {
    return this.timeStamp;
  }
  
  public String getTokenNonce()
  {
    return this.tokenNonce;
  }
  
  public String getUserName()
  {
    return this.userName;
  }
  
  public void setAuthToken(String paramString)
  {
    this.authToken = paramString;
  }
  
  public void setAuthType(String paramString)
  {
    this.authType = paramString;
  }
  
  public void setImei(String paramString)
  {
    this.imei = paramString;
  }
  
  public void setImsi(String paramString)
  {
    this.imsi = paramString;
  }
  
  public void setMachineCode(String paramString)
  {
    this.machineCode = paramString;
  }
  
  public void setPassid(String paramString)
  {
    this.passid = paramString;
  }
  
  public void setTimeStamp(String paramString)
  {
    this.timeStamp = paramString;
  }
  
  public void setTokenNonce(String paramString)
  {
    this.tokenNonce = paramString;
  }
  
  public void setUserName(String paramString)
  {
    this.userName = paramString;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/account/UserInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */