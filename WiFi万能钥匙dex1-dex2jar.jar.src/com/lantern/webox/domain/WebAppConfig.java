package com.lantern.webox.domain;

import java.util.List;

public class WebAppConfig
{
  private boolean disabled = false;
  private String domain;
  private List<String> downloadBlackList = null;
  private boolean downloadEnabled = false;
  private List<String> downloadWhiteList = null;
  private long expiredTime = 0L;
  private int securityLevel = 0;
  
  public String getDomain()
  {
    return this.domain;
  }
  
  public List<String> getDownloadBlackList()
  {
    return this.downloadBlackList;
  }
  
  public List<String> getDownloadWhiteList()
  {
    return this.downloadWhiteList;
  }
  
  public long getExpiredTime()
  {
    return this.expiredTime;
  }
  
  public int getSecurityLevel()
  {
    return this.securityLevel;
  }
  
  public boolean isDisabled()
  {
    return this.disabled;
  }
  
  public boolean isDownloadEnabled()
  {
    return this.downloadEnabled;
  }
  
  public void setDisabled(boolean paramBoolean)
  {
    this.disabled = paramBoolean;
  }
  
  public void setDomain(String paramString)
  {
    this.domain = paramString;
  }
  
  public void setDownloadBlackList(List<String> paramList)
  {
    this.downloadBlackList = paramList;
  }
  
  public void setDownloadEnabled(boolean paramBoolean)
  {
    this.downloadEnabled = paramBoolean;
  }
  
  public void setDownloadWhiteList(List<String> paramList)
  {
    this.downloadWhiteList = paramList;
  }
  
  public void setExpiredTime(long paramLong)
  {
    this.expiredTime = paramLong;
  }
  
  public void setSecurityLevel(int paramInt)
  {
    this.securityLevel = paramInt;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/domain/WebAppConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */