package com.lantern.wifiseccheck.protocol;

public class ApMarkResult
{
  public static final int CRITICAL_ARP = 8;
  public static final int CRITICAL_DNS = 1;
  public static final int CRITICAL_NORMAL = 0;
  public static final int CRITICAL_SSL = 2;
  public static final int CRITICAL_WEBMD5 = 4;
  private boolean criticalPassed = false;
  private int critical_abnormal;
  private ApMarkerResultDescription description = new ApMarkerResultDescription();
  private SecCheckExtraParams extraParams;
  private ApNeighbourRes neighbourRes;
  private int netState;
  private TreatmentRecommendations recommend;
  private Integer score = Integer.valueOf(0);
  private boolean vpnSuggested = false;
  
  public int getCritical_abnormal()
  {
    return this.critical_abnormal;
  }
  
  public ApMarkerResultDescription getDescription()
  {
    return this.description;
  }
  
  public SecCheckExtraParams getExtraParams()
  {
    return this.extraParams;
  }
  
  public ApNeighbourRes getNeighbourRes()
  {
    return this.neighbourRes;
  }
  
  public int getNetState()
  {
    return this.netState;
  }
  
  public TreatmentRecommendations getRecommend()
  {
    return this.recommend;
  }
  
  public Integer getScore()
  {
    return this.score;
  }
  
  public boolean isCriticalPassed()
  {
    return this.criticalPassed;
  }
  
  public boolean isVpnSuggested()
  {
    return this.vpnSuggested;
  }
  
  public void setCriticalPassed(boolean paramBoolean)
  {
    this.criticalPassed = paramBoolean;
  }
  
  public void setCritical_abnormal(int paramInt)
  {
    this.critical_abnormal = paramInt;
  }
  
  public void setDescription(ApMarkerResultDescription paramApMarkerResultDescription)
  {
    this.description = paramApMarkerResultDescription;
  }
  
  public void setExtraParams(SecCheckExtraParams paramSecCheckExtraParams)
  {
    this.extraParams = paramSecCheckExtraParams;
  }
  
  public void setNeighbourRes(ApNeighbourRes paramApNeighbourRes)
  {
    this.neighbourRes = paramApNeighbourRes;
  }
  
  public void setNetState(int paramInt)
  {
    this.netState = paramInt;
  }
  
  public void setRecommend(TreatmentRecommendations paramTreatmentRecommendations)
  {
    this.recommend = paramTreatmentRecommendations;
  }
  
  public void setScore(Integer paramInteger)
  {
    this.score = paramInteger;
  }
  
  public void setVpnSuggested(boolean paramBoolean)
  {
    this.vpnSuggested = paramBoolean;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/protocol/ApMarkResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */