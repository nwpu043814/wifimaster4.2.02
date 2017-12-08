package com.lantern.wifiseccheck.protocol;

import java.util.Map;

public class WifiSecInfoReq
{
  private AppBaseAttr appBaseAttr;
  private Integer[] dnsArray;
  private Integer gateway;
  private GpsCoordinate gpsCoordinate;
  private NearbyAp[] nearByAp;
  private Integer netmask;
  private Integer protocolVer;
  private int source;
  private Map<String, String> wifiMap;
  
  public AppBaseAttr getAppBaseAttr()
  {
    return this.appBaseAttr;
  }
  
  public Integer[] getDnsArray()
  {
    return this.dnsArray;
  }
  
  public Integer getGateway()
  {
    return this.gateway;
  }
  
  public GpsCoordinate getGpsCoordinate()
  {
    return this.gpsCoordinate;
  }
  
  public NearbyAp[] getNearByAp()
  {
    return this.nearByAp;
  }
  
  public Integer getNetmask()
  {
    return this.netmask;
  }
  
  public Integer getProtocolVer()
  {
    return this.protocolVer;
  }
  
  public int getSource()
  {
    return this.source;
  }
  
  public Map<String, String> getWifiMap()
  {
    return this.wifiMap;
  }
  
  public void setAppBaseAttr(AppBaseAttr paramAppBaseAttr)
  {
    this.appBaseAttr = paramAppBaseAttr;
  }
  
  public void setDnsArray(Integer[] paramArrayOfInteger)
  {
    this.dnsArray = paramArrayOfInteger;
  }
  
  public void setGateway(Integer paramInteger)
  {
    this.gateway = paramInteger;
  }
  
  public void setGpsCoordinate(GpsCoordinate paramGpsCoordinate)
  {
    this.gpsCoordinate = paramGpsCoordinate;
  }
  
  public void setNearByAp(NearbyAp[] paramArrayOfNearbyAp)
  {
    this.nearByAp = paramArrayOfNearbyAp;
  }
  
  public void setNetmask(Integer paramInteger)
  {
    this.netmask = paramInteger;
  }
  
  public void setProtocolVer(Integer paramInteger)
  {
    this.protocolVer = paramInteger;
  }
  
  public void setSource(int paramInt)
  {
    this.source = paramInt;
  }
  
  public void setWifiMap(Map<String, String> paramMap)
  {
    this.wifiMap = paramMap;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/protocol/WifiSecInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */