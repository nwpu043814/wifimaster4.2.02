package com.lantern.wifiseccheck.protocol;

import java.util.LinkedList;
import java.util.List;

public class ApInfoFromClient
{
  public static final Integer PROTOCOL_VER = Integer.valueOf(5);
  private AppBaseAttr appBaseAttr;
  private String appID;
  private boolean arpAbnormal;
  private CertificationRobust certificationRobust;
  private String channel;
  private int clientColletorTime;
  private Integer currentNumberOfUsers;
  private String dhid;
  private Integer[] dnsArray;
  private List<DomainResult> domainResults;
  private Integer extraParamsVer;
  private Integer gateway;
  private GpsCoordinate gpsCoordinate;
  private boolean isVpnOpened;
  private String mac;
  private List<NearbyAp> nearbyAps;
  private List<Neighbour> neighbourLits;
  private Integer neighbourPercent;
  private Integer netWorkSpeed;
  private Integer netmask;
  private String outerNetIp;
  private Boolean portalDetected;
  private Integer protocolVer;
  private List<String> runningSoftware;
  private int source;
  private String ssid;
  private List<SslCertResult> sslCertResults;
  private Integer suggestAcceptRating;
  private List<WebMd5Result> webMd5Results;
  
  public void addDomainResult(DomainResult paramDomainResult)
  {
    if (this.domainResults == null) {
      this.domainResults = new LinkedList();
    }
    this.domainResults.add(paramDomainResult);
  }
  
  public void addSslCertReuslt(SslCertResult paramSslCertResult)
  {
    if (this.sslCertResults == null) {
      this.sslCertResults = new LinkedList();
    }
    this.sslCertResults.add(paramSslCertResult);
  }
  
  public void addWebMd5Result(WebMd5Result paramWebMd5Result)
  {
    if (this.webMd5Results == null) {
      this.webMd5Results = new LinkedList();
    }
    this.webMd5Results.add(paramWebMd5Result);
  }
  
  public AppBaseAttr getAppBaseAttr()
  {
    return this.appBaseAttr;
  }
  
  public String getAppID()
  {
    return this.appID;
  }
  
  public CertificationRobust getCertificationRobust()
  {
    return this.certificationRobust;
  }
  
  public String getChannel()
  {
    return this.channel;
  }
  
  public int getClientColletorTime()
  {
    return this.clientColletorTime;
  }
  
  public Integer getCurrentNumberOfUsers()
  {
    return this.currentNumberOfUsers;
  }
  
  public String getDhid()
  {
    return this.dhid;
  }
  
  public Integer[] getDnsArray()
  {
    return this.dnsArray;
  }
  
  public List<DomainResult> getDomainResults()
  {
    return this.domainResults;
  }
  
  public Integer getExtraParamsVer()
  {
    return this.extraParamsVer;
  }
  
  public Integer getGateway()
  {
    return this.gateway;
  }
  
  public GpsCoordinate getGpsCoordinate()
  {
    return this.gpsCoordinate;
  }
  
  public String getMac()
  {
    return this.mac;
  }
  
  public List<NearbyAp> getNearbyAps()
  {
    return this.nearbyAps;
  }
  
  public List<Neighbour> getNeighbourLits()
  {
    return this.neighbourLits;
  }
  
  public Integer getNeighbourPercent()
  {
    return this.neighbourPercent;
  }
  
  public Integer getNetWorkSpeed()
  {
    return this.netWorkSpeed;
  }
  
  public Integer getNetmask()
  {
    return this.netmask;
  }
  
  public String getOuterNetIp()
  {
    return this.outerNetIp;
  }
  
  public Boolean getPortalDetected()
  {
    return this.portalDetected;
  }
  
  public Integer getProtocolVer()
  {
    return this.protocolVer;
  }
  
  public List<String> getRunningSoftware()
  {
    return this.runningSoftware;
  }
  
  public int getSource()
  {
    return this.source;
  }
  
  public String getSsid()
  {
    return this.ssid;
  }
  
  public List<SslCertResult> getSslCertResults()
  {
    return this.sslCertResults;
  }
  
  public Integer getSuggestAcceptRating()
  {
    return this.suggestAcceptRating;
  }
  
  public List<WebMd5Result> getWebMd5Results()
  {
    return this.webMd5Results;
  }
  
  public boolean isArpAbnormal()
  {
    return this.arpAbnormal;
  }
  
  public boolean isVpnOpened()
  {
    return this.isVpnOpened;
  }
  
  public void setAppBaseAttr(AppBaseAttr paramAppBaseAttr)
  {
    this.appBaseAttr = paramAppBaseAttr;
  }
  
  public void setAppID(String paramString)
  {
    this.appID = paramString;
  }
  
  public void setArpAbnormal(boolean paramBoolean)
  {
    this.arpAbnormal = paramBoolean;
  }
  
  public void setCertificationRobust(CertificationRobust paramCertificationRobust)
  {
    this.certificationRobust = paramCertificationRobust;
  }
  
  public void setChannel(String paramString)
  {
    this.channel = paramString;
  }
  
  public void setClientColletorTime(int paramInt)
  {
    this.clientColletorTime = paramInt;
  }
  
  public void setCurrentNumberOfUsers(Integer paramInteger)
  {
    this.currentNumberOfUsers = paramInteger;
  }
  
  public void setDhid(String paramString)
  {
    this.dhid = paramString;
  }
  
  public void setDnsArray(Integer[] paramArrayOfInteger)
  {
    this.dnsArray = paramArrayOfInteger;
  }
  
  public void setDomainResults(List<DomainResult> paramList)
  {
    this.domainResults = paramList;
  }
  
  public void setExtraParamsVer(Integer paramInteger)
  {
    this.extraParamsVer = paramInteger;
  }
  
  public void setGateway(Integer paramInteger)
  {
    this.gateway = paramInteger;
  }
  
  public void setGpsCoordinate(GpsCoordinate paramGpsCoordinate)
  {
    this.gpsCoordinate = paramGpsCoordinate;
  }
  
  public void setMac(String paramString)
  {
    this.mac = paramString;
  }
  
  public void setNearbyAps(List<NearbyAp> paramList)
  {
    this.nearbyAps = paramList;
  }
  
  public void setNeighbourLits(List<Neighbour> paramList)
  {
    this.neighbourLits = paramList;
  }
  
  public void setNeighbourPercent(Integer paramInteger)
  {
    this.neighbourPercent = paramInteger;
  }
  
  public void setNetWorkSpeed(Integer paramInteger)
  {
    this.netWorkSpeed = paramInteger;
  }
  
  public void setNetmask(Integer paramInteger)
  {
    this.netmask = paramInteger;
  }
  
  public void setOuterNetIp(String paramString)
  {
    this.outerNetIp = paramString;
  }
  
  public void setPortalDetected(Boolean paramBoolean)
  {
    this.portalDetected = paramBoolean;
  }
  
  public void setProtocolVer(Integer paramInteger)
  {
    this.protocolVer = paramInteger;
  }
  
  public void setRunningSoftware(List<String> paramList)
  {
    this.runningSoftware = paramList;
  }
  
  public void setSource(int paramInt)
  {
    this.source = paramInt;
  }
  
  public void setSsid(String paramString)
  {
    this.ssid = paramString;
  }
  
  public void setSslCertResults(List<SslCertResult> paramList)
  {
    this.sslCertResults = paramList;
  }
  
  public void setSuggestAcceptRating(Integer paramInteger)
  {
    this.suggestAcceptRating = paramInteger;
  }
  
  public void setVpnOpened(boolean paramBoolean)
  {
    this.isVpnOpened = paramBoolean;
  }
  
  public void setWebMd5Results(List<WebMd5Result> paramList)
  {
    this.webMd5Results = paramList;
  }
  
  public static enum CertificationRobust
  {
    OPEN,  WEP,  WPAPSK_WPA2PSK,  WPA_WPA2;
    
    private CertificationRobust() {}
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/protocol/ApInfoFromClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */