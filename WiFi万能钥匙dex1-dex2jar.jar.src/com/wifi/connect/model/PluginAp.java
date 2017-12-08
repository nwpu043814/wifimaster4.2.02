package com.wifi.connect.model;

import com.lantern.core.model.WkAccessPoint;

public class PluginAp
  extends WkAccessPoint
{
  @Deprecated
  public long e;
  @Deprecated
  public int f;
  public int g;
  public int h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m = "";
  public String n;
  
  public PluginAp()
  {
    this.h = 10;
  }
  
  public PluginAp(WkAccessPoint paramWkAccessPoint, int paramInt)
  {
    super(paramWkAccessPoint);
    this.h = paramInt;
  }
  
  public String toString()
  {
    return super.toString() + " sign:" + this.l + " url:" + this.i + " version:" + this.g;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/model/PluginAp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */