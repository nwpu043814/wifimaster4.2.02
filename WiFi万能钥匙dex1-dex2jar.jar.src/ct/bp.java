package ct;

import android.app.PendingIntent;
import android.location.Location;
import com.tencent.map.geolocation.TencentGeofence;
import java.util.Locale;

final class bp
{
  public final TencentGeofence a;
  final Location b;
  public final long c;
  public final PendingIntent d;
  int e = 0;
  double f = Double.MAX_VALUE;
  Object g;
  
  public bp(TencentGeofence paramTencentGeofence, long paramLong, PendingIntent paramPendingIntent)
  {
    this.a = paramTencentGeofence;
    this.c = paramLong;
    this.d = paramPendingIntent;
    this.b = new Location("");
    this.b.setLatitude(paramTencentGeofence.getLatitude());
    this.b.setLongitude(paramTencentGeofence.getLongitude());
    this.b.setTime(0L);
    this.b.setSpeed(-0.001F);
  }
  
  public final float a()
  {
    float f2 = -0.001F;
    float f1 = this.b.getSpeed();
    if (f1 <= -0.001F) {
      f1 = f2;
    }
    for (;;)
    {
      return f1;
      if (f1 > 25.0F) {
        f1 = 25.0F;
      } else if (f1 < 1.0F) {
        f1 = 1.0F;
      }
    }
  }
  
  public final String toString()
  {
    String str;
    switch (this.e)
    {
    default: 
      str = "?";
    }
    for (;;)
    {
      return String.format(Locale.US, "%s dist=%5gm speed=%.2fm/s state=%s", new Object[] { this.a.toString(), Double.valueOf(this.f), Float.valueOf(a()), str });
      str = "IN";
      continue;
      str = "OUT";
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */