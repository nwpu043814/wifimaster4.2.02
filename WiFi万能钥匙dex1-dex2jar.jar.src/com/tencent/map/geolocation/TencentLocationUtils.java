package com.tencent.map.geolocation;

import android.content.Context;
import ct.b.a;
import ct.df;

public class TencentLocationUtils
{
  private TencentLocationUtils()
  {
    throw new UnsupportedOperationException();
  }
  
  public static boolean contains(TencentLocation paramTencentLocation1, double paramDouble, TencentLocation paramTencentLocation2)
  {
    if ((paramTencentLocation1 == null) || (paramTencentLocation2 == null)) {
      throw new NullPointerException();
    }
    if (distanceBetween(paramTencentLocation1, paramTencentLocation2) <= paramDouble) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static double distanceBetween(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    return b.a.a(paramDouble1, paramDouble2, paramDouble3, paramDouble4);
  }
  
  public static double distanceBetween(TencentLocation paramTencentLocation1, TencentLocation paramTencentLocation2)
  {
    if ((paramTencentLocation1 == null) || (paramTencentLocation2 == null)) {
      throw new NullPointerException();
    }
    return b.a.a(paramTencentLocation1.getLatitude(), paramTencentLocation1.getLongitude(), paramTencentLocation2.getLatitude(), paramTencentLocation2.getLongitude());
  }
  
  public static boolean isFromGps(TencentLocation paramTencentLocation)
  {
    if (paramTencentLocation == null) {}
    for (boolean bool = false;; bool = "gps".equals(paramTencentLocation.getProvider())) {
      return bool;
    }
  }
  
  public static boolean isFromNetwork(TencentLocation paramTencentLocation)
  {
    if (paramTencentLocation == null) {}
    for (boolean bool = false;; bool = "network".equals(paramTencentLocation.getProvider())) {
      return bool;
    }
  }
  
  public static boolean isSupportGps(Context paramContext)
  {
    if (paramContext == null) {
      throw new NullPointerException();
    }
    df.a();
    if ((df.a(paramContext) & 0x10) == 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/map/geolocation/TencentLocationUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */