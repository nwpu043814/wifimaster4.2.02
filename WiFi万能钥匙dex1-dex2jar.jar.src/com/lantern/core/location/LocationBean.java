package com.lantern.core.location;

public class LocationBean
{
  private String mAddress;
  private double mLat;
  private double mLon;
  private LocationType mType;
  
  public String getAddress()
  {
    return this.mAddress;
  }
  
  public double getLat()
  {
    return this.mLat;
  }
  
  public double getLon()
  {
    return this.mLon;
  }
  
  public LocationType getType()
  {
    return this.mType;
  }
  
  public void setAddress(String paramString)
  {
    this.mAddress = paramString;
  }
  
  public void setLat(double paramDouble)
  {
    this.mLat = paramDouble;
  }
  
  public void setLon(double paramDouble)
  {
    this.mLon = paramDouble;
  }
  
  public void setType(LocationType paramLocationType)
  {
    this.mType = paramLocationType;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/location/LocationBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */