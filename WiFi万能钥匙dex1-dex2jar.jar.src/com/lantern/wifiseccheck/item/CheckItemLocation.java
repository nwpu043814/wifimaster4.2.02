package com.lantern.wifiseccheck.item;

import com.lantern.wifiseccheck.protocol.GpsCoordinate;

public class CheckItemLocation
  extends ICheckItem
{
  private GpsCoordinate coordinate;
  
  public GpsCoordinate getLocation()
  {
    return this.coordinate;
  }
  
  public int getType()
  {
    return 6;
  }
  
  public void initDefaultData()
  {
    this.coordinate = null;
  }
  
  public boolean isTimeOutType()
  {
    return false;
  }
  
  public void setLocation(GpsCoordinate paramGpsCoordinate)
  {
    if (this.coordinate == null) {
      this.coordinate = new GpsCoordinate();
    }
    this.coordinate.setLatitude(paramGpsCoordinate.getLatitude());
    this.coordinate.setLongitude(paramGpsCoordinate.getLongitude());
    setFinish(true);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/item/CheckItemLocation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */