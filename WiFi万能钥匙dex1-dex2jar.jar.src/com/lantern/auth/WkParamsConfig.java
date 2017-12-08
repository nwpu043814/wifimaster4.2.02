package com.lantern.auth;

import java.io.Serializable;

public class WkParamsConfig
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public String mAppIcon;
  public String mAppName;
  public String mPackageName;
  public String mScope;
  public String mThirdAppId;
  public double mVersionCode;
  
  public WkParamsConfig() {}
  
  public WkParamsConfig(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.mThirdAppId = paramString1;
    this.mScope = paramString2;
    this.mAppName = paramString3;
    this.mAppIcon = paramString4;
  }
  
  public void setParams(double paramDouble, String paramString)
  {
    this.mVersionCode = paramDouble;
    this.mPackageName = paramString;
  }
  
  public void setParams(String paramString1, String paramString2)
  {
    this.mThirdAppId = paramString1;
    this.mScope = paramString2;
  }
  
  public void setParams(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.mThirdAppId = paramString1;
    this.mScope = paramString2;
    this.mAppName = paramString3;
    this.mAppIcon = paramString4;
  }
  
  public String toString()
  {
    return String.format("[thirdAppId:%s, scope:%s, appName:%s, appIcon:%s]", new Object[] { this.mThirdAppId, this.mScope, this.mAppName, this.mAppIcon });
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/WkParamsConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */