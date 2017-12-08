package ct;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

final class bx
  implements SensorEventListener
{
  private static volatile bx e;
  private final SensorManager a;
  private final boolean b;
  private boolean c;
  private double d;
  
  private bx(Context paramContext)
  {
    this.a = ((SensorManager)paramContext.getSystemService("sensor"));
    if (this.a != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.b = bool;
      return;
    }
  }
  
  public static bx a(Context paramContext)
  {
    if (e == null) {
      e = new bx(paramContext);
    }
    return e;
  }
  
  public final void a()
  {
    if (!this.b) {}
    for (;;)
    {
      return;
      if (!this.c)
      {
        Sensor localSensor = this.a.getDefaultSensor(3);
        if (localSensor != null)
        {
          this.a.registerListener(this, localSensor, 3);
          this.c = true;
        }
      }
    }
  }
  
  public final void b()
  {
    if (!this.b) {}
    for (;;)
    {
      return;
      if (this.c)
      {
        this.c = false;
        this.d = NaN.0D;
        this.a.unregisterListener(this);
      }
    }
  }
  
  public final double c()
  {
    if (this.c) {}
    for (;;)
    {
      try
      {
        d1 = this.d;
        return d1;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
      double d1 = NaN.0D;
    }
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    double d1 = paramSensorEvent.values[0];
    try
    {
      this.d = d1;
      return;
    }
    finally
    {
      paramSensorEvent = finally;
      throw paramSensorEvent;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/bx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */