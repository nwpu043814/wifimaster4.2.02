package com.lantern.wifiseccheck.protocol;

public class GpsCoordinate
{
  private float latitude;
  private float longitude;
  
  public float getLatitude()
  {
    return this.latitude;
  }
  
  public float getLongitude()
  {
    return this.longitude;
  }
  
  public void setLatitude(float paramFloat)
  {
    this.latitude = paramFloat;
  }
  
  public void setLongitude(float paramFloat)
  {
    this.longitude = paramFloat;
  }
  
  public String toString()
  {
    return this.longitude + ":" + this.latitude;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/protocol/GpsCoordinate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */