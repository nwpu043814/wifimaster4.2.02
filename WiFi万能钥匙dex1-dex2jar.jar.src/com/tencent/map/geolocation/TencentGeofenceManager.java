package com.tencent.map.geolocation;

import android.app.PendingIntent;
import android.content.Context;
import ct.bq;

public class TencentGeofenceManager
{
  private bq a;
  
  public TencentGeofenceManager(Context paramContext)
  {
    this.a = new bq(paramContext);
  }
  
  public void addFence(TencentGeofence paramTencentGeofence, PendingIntent paramPendingIntent)
  {
    this.a.a(paramTencentGeofence, paramPendingIntent);
  }
  
  public void destroy()
  {
    this.a.a();
  }
  
  public void removeAllFences()
  {
    this.a.b();
  }
  
  public void removeFence(TencentGeofence paramTencentGeofence)
  {
    this.a.a(paramTencentGeofence);
  }
  
  public void removeFence(String paramString)
  {
    this.a.a(paramString);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/map/geolocation/TencentGeofenceManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */