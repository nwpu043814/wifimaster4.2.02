package com.tencent.map.geolocation;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import ct.b.a;
import ct.bi;
import ct.bj;
import ct.ca;

public final class TencentLocationManager
{
  public static final String BUILD = "";
  public static final int COORDINATE_TYPE_GCJ02 = 1;
  public static final int COORDINATE_TYPE_WGS84 = 0;
  public static final String VERSION = "";
  private static TencentLocationManager d;
  private final byte[] a = new byte[0];
  private final bi b;
  private final ca c;
  
  private TencentLocationManager(Context paramContext)
  {
    this.b = bi.a(paramContext);
    this.c = new ca(this.b);
  }
  
  public static TencentLocationManager getInstance(Context paramContext)
  {
    if (paramContext == null) {
      try
      {
        paramContext = new java/lang/NullPointerException;
        paramContext.<init>("context is null");
        throw paramContext;
      }
      finally {}
    }
    if (paramContext.getApplicationContext() == null)
    {
      paramContext = new java/lang/NullPointerException;
      paramContext.<init>("application context is null");
      throw paramContext;
    }
    if (d == null)
    {
      TencentLocationManager localTencentLocationManager = new com/tencent/map/geolocation/TencentLocationManager;
      localTencentLocationManager.<init>(paramContext.getApplicationContext());
      d = localTencentLocationManager;
    }
    paramContext = d;
    return paramContext;
  }
  
  public static boolean isAllowGps(TencentLocationRequest paramTencentLocationRequest)
  {
    boolean bool = true;
    if (paramTencentLocationRequest == null) {}
    for (;;)
    {
      return bool;
      bool = paramTencentLocationRequest.getExtras().getBoolean("allow_gps", true);
    }
  }
  
  public static TencentLocationRequest setAllowGps(TencentLocationRequest paramTencentLocationRequest, boolean paramBoolean)
  {
    if (paramTencentLocationRequest != null) {
      paramTencentLocationRequest.getExtras().putBoolean("allow_gps", paramBoolean);
    }
    return paramTencentLocationRequest;
  }
  
  public final void feedback(String paramString1, String paramString2, Object... paramVarArgs) {}
  
  public final String getBuild()
  {
    Object localObject = this.b.i();
    if (localObject != null) {}
    for (localObject = ((bj)localObject).e();; localObject = "None") {
      return (String)localObject;
    }
  }
  
  public final int getCoordinateType()
  {
    return this.c.d();
  }
  
  public final String getKey()
  {
    return b.a.b(this.b.h().h);
  }
  
  public final TencentLocation getLastKnownLocation()
  {
    return this.c.a();
  }
  
  public final String getVersion()
  {
    Object localObject = this.b.i();
    if (localObject != null) {}
    for (localObject = ((bj)localObject).d();; localObject = "None") {
      return (String)localObject;
    }
  }
  
  public final void removeUpdates(TencentLocationListener arg1)
  {
    synchronized (this.a)
    {
      this.c.c();
      return;
    }
  }
  
  public final int requestLocationUpdates(TencentLocationRequest paramTencentLocationRequest, TencentLocationListener paramTencentLocationListener)
  {
    return requestLocationUpdates(paramTencentLocationRequest, paramTencentLocationListener, Looper.myLooper());
  }
  
  public final int requestLocationUpdates(TencentLocationRequest paramTencentLocationRequest, TencentLocationListener paramTencentLocationListener, Looper paramLooper)
  {
    if (paramTencentLocationRequest == null) {
      throw new NullPointerException("request is null");
    }
    if (paramTencentLocationListener == null) {
      throw new NullPointerException("listener is null");
    }
    if (paramLooper == null) {
      throw new NullPointerException("looper is null");
    }
    synchronized (this.a)
    {
      int i = this.c.a(paramTencentLocationRequest, paramTencentLocationListener, paramLooper);
      return i;
    }
  }
  
  public final void setCoordinateType(int paramInt)
  {
    if ((paramInt == 1) || (paramInt == 0)) {
      synchronized (this.a)
      {
        this.c.a(paramInt);
        return;
      }
    }
    throw new IllegalArgumentException("unknown coordinate type: " + paramInt);
  }
  
  public final void setKey(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      throw new IllegalArgumentException("bad key: " + paramString);
    }
    this.b.h().h = paramString;
  }
  
  public final int startDistanceCalculate(TencentDistanceListener paramTencentDistanceListener)
  {
    if (paramTencentDistanceListener == null) {
      throw new NullPointerException("listener is null");
    }
    synchronized (this.a)
    {
      int i = this.c.a(paramTencentDistanceListener);
      return i;
    }
  }
  
  public final TencentDistanceAnalysis stopDistanceCalculate(TencentDistanceListener arg1)
  {
    synchronized (this.a)
    {
      TencentDistanceAnalysis localTencentDistanceAnalysis = this.c.b();
      return localTencentDistanceAnalysis;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/map/geolocation/TencentLocationManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */