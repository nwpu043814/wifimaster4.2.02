package com.lantern.wifiseccheck;

import com.lantern.wifiseccheck.protocol.ApMarkResult;
import com.lantern.wifiseccheck.protocol.ApNeighbourRes;
import com.lantern.wifiseccheck.protocol.GpsCoordinate;

class WifiSecCheckImpl$7
  extends WifiSecCheckManager.WifiCheckListener
{
  WifiSecCheckImpl$7(WifiSecCheckImpl paramWifiSecCheckImpl, WifiSecCheckImpl.CheckModel paramCheckModel)
  {
    super(paramCheckModel);
  }
  
  public void detectCount(int paramInt1, int paramInt2, int paramInt3) {}
  
  public String getAppId()
  {
    return null;
  }
  
  public String getConnChanid()
  {
    return null;
  }
  
  public String getDhid()
  {
    return null;
  }
  
  public GpsCoordinate getLocation()
  {
    return null;
  }
  
  public Integer getNetWorkSpeed()
  {
    return null;
  }
  
  public void onCheckError(int paramInt) {}
  
  public void onCheckFinish(ApMarkResult paramApMarkResult, ExtraInfo paramExtraInfo) {}
  
  public void onLoadCallback(ApNeighbourRes paramApNeighbourRes) {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/WifiSecCheckImpl$7.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */