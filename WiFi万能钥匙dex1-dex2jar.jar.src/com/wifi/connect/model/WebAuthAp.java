package com.wifi.connect.model;

import com.lantern.core.model.WkAccessPoint;

public class WebAuthAp
  extends WkAccessPoint
{
  public String e = "";
  public String f;
  
  public String toString()
  {
    return super.toString() + " extra:" + this.f;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/model/WebAuthAp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */