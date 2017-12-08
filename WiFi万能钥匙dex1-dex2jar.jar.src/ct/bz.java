package ct;

import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.GpsStatus.Listener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.qihoo.util.StubApp1053578832;
import java.util.Arrays;
import java.util.Iterator;

final class bz
  implements GpsStatus.Listener, LocationListener
{
  private long a = 0L;
  private final bi b;
  private int c = 1024;
  private boolean d = false;
  private boolean e = false;
  private int f = 0;
  private int g = 0;
  private volatile boolean h;
  private boolean i;
  private bs j;
  private GpsStatus k;
  private final double[] l = new double[2];
  
  public bz(bi parambi)
  {
    this.b = parambi;
    this.j = bs.a();
  }
  
  private static void a(Location paramLocation, double paramDouble1, double paramDouble2)
  {
    Bundle localBundle2 = paramLocation.getExtras();
    Bundle localBundle1 = localBundle2;
    if (localBundle2 == null) {
      localBundle1 = new Bundle();
    }
    localBundle1.putDouble("lat", paramDouble1);
    localBundle1.putDouble("lng", paramDouble2);
    paramLocation.setExtras(localBundle1);
  }
  
  private boolean a(Location paramLocation)
  {
    boolean bool2 = false;
    boolean bool1;
    if (!cp.a) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      try
      {
        if (!this.b.c().isProviderEnabled("gps"))
        {
          bool1 = true;
        }
        else
        {
          bool1 = bool2;
          if (Build.VERSION.SDK_INT >= 18)
          {
            boolean bool3 = paramLocation.isFromMockProvider();
            bool1 = bool2;
            if (bool3) {
              bool1 = true;
            }
          }
        }
      }
      catch (NoSuchMethodError paramLocation)
      {
        bool1 = bool2;
      }
      catch (Exception paramLocation)
      {
        bool1 = bool2;
      }
    }
  }
  
  private void d()
  {
    int m;
    if (this.c == 4) {
      m = 1;
    }
    for (;;)
    {
      Message localMessage = new Message();
      localMessage.what = 12999;
      localMessage.arg1 = 12002;
      localMessage.arg2 = m;
      this.b.c(localMessage);
      return;
      if (this.c == 0) {
        m = 0;
      } else {
        m = -1;
      }
    }
  }
  
  private void e()
  {
    this.g = 0;
    this.f = 0;
    Object localObject = this.b.c().getGpsStatus(null);
    if (localObject == null) {}
    for (;;)
    {
      return;
      int m = ((GpsStatus)localObject).getMaxSatellites();
      localObject = ((GpsStatus)localObject).getSatellites().iterator();
      if (localObject != null) {
        while ((((Iterator)localObject).hasNext()) && (this.f <= m))
        {
          this.f += 1;
          if (((GpsSatellite)((Iterator)localObject).next()).usedInFix()) {
            this.g += 1;
          }
        }
      }
    }
  }
  
  private int f()
  {
    int n = -1;
    Object localObject = this.b.c().getGpsStatus(null);
    if (localObject == null) {}
    int i1;
    do
    {
      return n;
      i1 = ((GpsStatus)localObject).getMaxSatellites();
      localObject = ((GpsStatus)localObject).getSatellites().iterator();
    } while (localObject == null);
    for (int m = 0;; m++)
    {
      n = m;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      n = m;
      if (m > i1) {
        break;
      }
      ((Iterator)localObject).next();
    }
  }
  
  private int g()
  {
    int n = -1;
    Object localObject = this.b.c().getGpsStatus(null);
    if (localObject == null) {}
    int i1;
    do
    {
      return n;
      i1 = ((GpsStatus)localObject).getMaxSatellites();
      localObject = ((GpsStatus)localObject).getSatellites().iterator();
    } while (localObject == null);
    int m = 0;
    for (;;)
    {
      n = m;
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      n = m;
      if (m > i1) {
        break;
      }
      if (((GpsSatellite)((Iterator)localObject).next()).usedInFix()) {
        m++;
      }
    }
  }
  
  public final void a()
  {
    if (!this.h) {}
    for (;;)
    {
      return;
      this.h = false;
      this.a = 0L;
      this.c = 1024;
      this.d = false;
      this.e = false;
      this.f = 0;
      this.g = 0;
      this.i = false;
      Arrays.fill(this.l, 0.0D);
      this.b.b(this);
      LocationManager localLocationManager = this.b.c();
      try
      {
        localLocationManager.removeGpsStatusListener(this);
      }
      catch (Exception localException2)
      {
        try
        {
          for (;;)
          {
            localLocationManager.removeUpdates(this);
            b.a.a("TxGpsProvider", "shutdown: state=[shutdown]");
            break;
            localException2 = localException2;
          }
        }
        catch (Exception localException1)
        {
          for (;;) {}
        }
      }
    }
  }
  
  public final void a(Handler paramHandler, long paramLong)
  {
    if (this.h) {}
    for (;;)
    {
      return;
      this.h = true;
      this.b.a(this);
      paramLong = Math.max(paramLong, 1000L);
      LocationManager localLocationManager = this.b.c();
      try
      {
        localLocationManager.addGpsStatusListener(this);
        localLocationManager.requestLocationUpdates("gps", paramLong, 0.0F, this, paramHandler.getLooper());
        if (c())
        {
          this.c = 4;
          d();
        }
        b.a.a("TxGpsProvider", "startup: state=[start]");
      }
      catch (Exception paramHandler)
      {
        for (;;)
        {
          db.a = true;
          b.a.a("TxGpsProvider", "startup: can not add location listener", paramHandler);
        }
      }
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public final boolean b()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((this.c & 0x2) == 2)
    {
      bool1 = bool2;
      if (System.currentTimeMillis() - this.a < by.a().b()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final boolean c()
  {
    boolean bool1 = false;
    LocationManager localLocationManager = this.b.c();
    try
    {
      boolean bool2 = localLocationManager.isProviderEnabled("gps");
      bool1 = bool2;
    }
    catch (Error localError)
    {
      for (;;) {}
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return bool1;
  }
  
  public final void onDeflectedEvent(Location paramLocation)
  {
    if (paramLocation == bw.b)
    {
      paramLocation = new cl(paramLocation, 0L, 0, 0, 0);
      this.b.c(paramLocation);
    }
    for (;;)
    {
      return;
      paramLocation = new cl(paramLocation, this.a, this.f, this.g, this.c);
      this.b.c(paramLocation);
    }
  }
  
  public final void onGpsStatusChanged(int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
      for (;;)
      {
        e();
        int m = f();
        paramInt = g();
        if (m > 0) {
          this.e = true;
        }
        if (paramInt > 0) {
          this.d = true;
        }
        return;
        this.c |= 0x1;
        continue;
        this.c = 0;
        continue;
        this.c |= 0x2;
      }
    }
    Object localObject = this.b.c();
    if (this.k == null)
    {
      this.k = ((LocationManager)localObject).getGpsStatus(null);
      label125:
      if (this.k == null) {
        break label211;
      }
    }
    label211:
    for (boolean bool = this.j.a(this.k);; bool = true)
    {
      if (bool) {}
      for (paramInt = 3;; paramInt = 4)
      {
        localObject = new Message();
        ((Message)localObject).what = 12999;
        ((Message)localObject).arg1 = 12004;
        ((Message)localObject).arg2 = paramInt;
        this.b.c(localObject);
        break;
        ((LocationManager)localObject).getGpsStatus(this.k);
        break label125;
      }
    }
  }
  
  public final void onLocationChanged(Location paramLocation)
  {
    StubApp1053578832.mark(paramLocation);
    if ((paramLocation == null) || (!"gps".equals(paramLocation.getProvider()))) {}
    double d2;
    double d1;
    int m;
    label52:
    do
    {
      return;
      d2 = paramLocation.getLatitude();
      d1 = paramLocation.getLongitude();
      if ((d2 != 29.999998211860657D) && (d1 != 103.99999916553497D)) {
        break;
      }
      m = 0;
      if (m == 0) {
        break label254;
      }
      e();
      this.c |= 0x2;
    } while (a(paramLocation));
    this.a = System.currentTimeMillis();
    if (this.i)
    {
      b.a.a(paramLocation, this.l);
      a(paramLocation, this.l[0], this.l[1]);
    }
    for (;;)
    {
      paramLocation = new cl(paramLocation, this.a, this.f, this.g, this.c);
      this.b.c(paramLocation);
      break;
      if ((Math.abs(d2) >= 1.0E-8D) && (Math.abs(d1) >= 1.0E-8D))
      {
        if ((Math.abs(d2 - 1.0D) < 1.0E-8D) || (Math.abs(d1 - 1.0D) < 1.0E-8D))
        {
          m = 0;
          break label52;
        }
        if ((d2 < -90.0D) || (d2 > 90.0D) || (d1 < -180.0D) || (d1 > 180.0D))
        {
          m = 0;
          break label52;
        }
      }
      m = 1;
      break label52;
      label254:
      break;
      a(paramLocation, paramLocation.getLatitude(), paramLocation.getLongitude());
    }
  }
  
  public final void onProviderDisabled(String paramString)
  {
    if ("gps".equals(paramString))
    {
      b.a.a("TxGpsProvider", "onProviderDisabled: gps is disabled");
      this.g = 0;
      this.f = 0;
      this.c = 0;
      this.d = false;
      this.a = 0L;
      d();
    }
  }
  
  public final void onProviderEnabled(String paramString)
  {
    if ("gps".equals(paramString))
    {
      b.a.a("TxGpsProvider", "onProviderEnabled: gps is enabled");
      this.c = 4;
      d();
    }
  }
  
  public final void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/bz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */