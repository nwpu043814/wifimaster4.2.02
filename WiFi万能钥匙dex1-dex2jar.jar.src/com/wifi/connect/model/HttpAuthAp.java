package com.wifi.connect.model;

import com.lantern.core.model.WkAccessPoint;

public class HttpAuthAp
  extends WkAccessPoint
{
  private int e;
  private int f;
  
  public HttpAuthAp(WkAccessPoint paramWkAccessPoint, int paramInt)
  {
    super(paramWkAccessPoint);
    this.e = paramInt;
  }
  
  public final void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public final void b(int paramInt)
  {
    this.f = paramInt;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/model/HttpAuthAp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */