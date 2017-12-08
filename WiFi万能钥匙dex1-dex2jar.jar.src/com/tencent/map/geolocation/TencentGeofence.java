package com.tencent.map.geolocation;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.Locale;

public class TencentGeofence
{
  private final double a;
  private final double b;
  private final float c;
  private final long d;
  private final String e;
  private final long f;
  
  private TencentGeofence(double paramDouble1, double paramDouble2, float paramFloat, long paramLong, String paramString)
  {
    this.a = paramDouble1;
    this.b = paramDouble2;
    this.c = paramFloat;
    this.f = paramLong;
    this.d = (SystemClock.elapsedRealtime() + paramLong);
    this.e = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {}
    for (;;)
    {
      return bool;
      if (paramObject == null)
      {
        bool = false;
      }
      else if (getClass() != paramObject.getClass())
      {
        bool = false;
      }
      else
      {
        paramObject = (TencentGeofence)paramObject;
        if (Double.doubleToLongBits(this.a) != Double.doubleToLongBits(((TencentGeofence)paramObject).a)) {
          bool = false;
        } else if (Double.doubleToLongBits(this.b) != Double.doubleToLongBits(((TencentGeofence)paramObject).b)) {
          bool = false;
        } else if (this.e == null)
        {
          if (((TencentGeofence)paramObject).e != null) {
            bool = false;
          }
        }
        else if (!this.e.equals(((TencentGeofence)paramObject).e)) {
          bool = false;
        }
      }
    }
  }
  
  public long getDuration()
  {
    return this.f;
  }
  
  public long getExpireAt()
  {
    return this.d;
  }
  
  public double getLatitude()
  {
    return this.a;
  }
  
  public double getLongitude()
  {
    return this.b;
  }
  
  public float getRadius()
  {
    return this.c;
  }
  
  public String getTag()
  {
    return this.e;
  }
  
  public int hashCode()
  {
    long l = Double.doubleToLongBits(this.a);
    int k = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.b);
    int j = (int)(l ^ l >>> 32);
    if (this.e == null) {}
    for (int i = 0;; i = this.e.hashCode()) {
      return i + ((k + 31) * 31 + j) * 31;
    }
  }
  
  public String toString()
  {
    return String.format(Locale.US, "TencentGeofence[tag=%s, type=%s, loc=(%.6f, %.6f), radius=%.2fm life=%.2fs]", new Object[] { this.e, "CIRCLE", Double.valueOf(this.a), Double.valueOf(this.b), Float.valueOf(this.c), Double.valueOf((this.d - SystemClock.elapsedRealtime()) / 1000.0D) });
  }
  
  public static class Builder
  {
    private double a;
    private double b;
    private float c;
    private long d;
    private String e;
    
    public TencentGeofence build()
    {
      return new TencentGeofence(this.a, this.b, this.c, this.d, this.e, (byte)0);
    }
    
    public Builder setCircularRegion(double paramDouble1, double paramDouble2, float paramFloat)
    {
      if (paramFloat <= 0.0F) {
        throw new IllegalArgumentException("invalid radius: " + paramFloat);
      }
      if ((paramDouble1 > 90.0D) || (paramDouble1 < -90.0D)) {
        throw new IllegalArgumentException("invalid latitude: " + paramDouble1);
      }
      if ((paramDouble2 > 180.0D) || (paramDouble2 < -180.0D)) {
        throw new IllegalArgumentException("invalid longitude: " + paramDouble2);
      }
      this.a = paramDouble1;
      this.b = paramDouble2;
      this.c = paramFloat;
      return this;
    }
    
    public Builder setExpirationDuration(long paramLong)
    {
      if (paramLong < 0L) {
        throw new IllegalArgumentException("invalid duration: " + paramLong);
      }
      this.d = paramLong;
      return this;
    }
    
    public Builder setTag(String paramString)
    {
      if (TextUtils.isEmpty(paramString)) {
        throw new NullPointerException();
      }
      this.e = paramString;
      return this;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/map/geolocation/TencentGeofence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */