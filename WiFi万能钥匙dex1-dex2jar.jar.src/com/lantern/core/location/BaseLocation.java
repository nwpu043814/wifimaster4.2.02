package com.lantern.core.location;

public abstract class BaseLocation
{
  public abstract void addLocationCallBack(LocationCallBack paramLocationCallBack);
  
  public abstract LocationBean getLocationBean();
  
  public abstract LocationType getLocationType();
  
  public abstract void removeLocationCallBack(LocationCallBack paramLocationCallBack);
  
  public abstract void startLocation(LocationCallBack paramLocationCallBack);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/location/BaseLocation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */