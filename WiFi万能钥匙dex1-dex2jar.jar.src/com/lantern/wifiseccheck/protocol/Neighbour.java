package com.lantern.wifiseccheck.protocol;

public class Neighbour
{
  private int ip;
  private String mac;
  private String vendor;
  
  public int getIp()
  {
    return this.ip;
  }
  
  public String getMac()
  {
    return this.mac;
  }
  
  public String getVendor()
  {
    return this.vendor;
  }
  
  public void setIp(int paramInt)
  {
    this.ip = paramInt;
  }
  
  public void setMac(String paramString)
  {
    this.mac = paramString;
  }
  
  public void setVendor(String paramString)
  {
    this.vendor = paramString;
  }
  
  public String toString()
  {
    return this.mac + "|||" + this.vendor + "|||" + this.ip + ";";
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/protocol/Neighbour.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */