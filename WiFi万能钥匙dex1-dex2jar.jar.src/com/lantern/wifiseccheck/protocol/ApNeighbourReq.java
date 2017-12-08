package com.lantern.wifiseccheck.protocol;

import java.util.List;

public class ApNeighbourReq
{
  private AppBaseAttr baseAttr;
  private GpsCoordinate gpsCoordinate;
  private List<Neighbour> macList;
  private Integer protocolVer;
  
  public AppBaseAttr getBaseAttr()
  {
    return this.baseAttr;
  }
  
  public GpsCoordinate getGpsCoordinate()
  {
    return this.gpsCoordinate;
  }
  
  public List<Neighbour> getMacList()
  {
    return this.macList;
  }
  
  public Integer getProtocolVer()
  {
    return this.protocolVer;
  }
  
  public void setBaseAttr(AppBaseAttr paramAppBaseAttr)
  {
    this.baseAttr = paramAppBaseAttr;
  }
  
  public void setGpsCoordinate(GpsCoordinate paramGpsCoordinate)
  {
    this.gpsCoordinate = paramGpsCoordinate;
  }
  
  public void setMacList(List<Neighbour> paramList)
  {
    this.macList = paramList;
  }
  
  public void setProtocolVer(Integer paramInteger)
  {
    this.protocolVer = paramInteger;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/protocol/ApNeighbourReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */