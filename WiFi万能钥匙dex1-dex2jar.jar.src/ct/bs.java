package ct;

import android.location.GpsSatellite;
import android.location.GpsStatus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class bs
{
  private static bs g = null;
  private ArrayList<Float> a = new ArrayList();
  private float b = 0.0F;
  private float c = 0.0F;
  private float d = 100.0F;
  private boolean e = false;
  private boolean f = false;
  
  public static bs a()
  {
    if (g == null) {}
    try
    {
      if (g == null)
      {
        bs localbs = new ct/bs;
        localbs.<init>();
        g = localbs;
      }
      return g;
    }
    finally {}
  }
  
  public final boolean a(GpsStatus paramGpsStatus)
  {
    int j = paramGpsStatus.getMaxSatellites();
    Object localObject2 = paramGpsStatus.getSatellites().iterator();
    this.a.clear();
    paramGpsStatus = new StringBuilder();
    int i = 0;
    Object localObject1;
    while ((((Iterator)localObject2).hasNext()) && (i <= j))
    {
      localObject1 = (GpsSatellite)((Iterator)localObject2).next();
      i++;
      this.a.add(Float.valueOf(((GpsSatellite)localObject1).getSnr()));
    }
    paramGpsStatus.append(i + "颗卫星,");
    float f1;
    if (this.a.size() >= 5)
    {
      localObject1 = new float[this.a.size()];
      for (i = 0; i < localObject1.length; i++) {
        localObject1[i] = ((Float)this.a.get(i)).floatValue();
      }
      Arrays.sort((float[])localObject1);
      localObject2 = new float[5];
      f1 = 0.0F;
      for (i = 0; i < 5; i++)
      {
        localObject2[i] = localObject1[(localObject1.length - 1 - i)];
        f1 += localObject2[i];
      }
      f1 /= 5.0F;
      paramGpsStatus.append("\n");
      paramGpsStatus.append("绝对判断：");
      if (localObject2[0] <= 35.0F) {
        break label559;
      }
      this.e = true;
      paramGpsStatus.append("室外|");
      if (f1 < 22.0F)
      {
        paramGpsStatus.append("室内|");
        this.e = false;
      }
      paramGpsStatus.append("avg" + f1);
      paramGpsStatus.append("avg'" + (f1 - this.b));
      paramGpsStatus.append("avgMax" + this.c);
      paramGpsStatus.append("avgMin" + this.d);
      paramGpsStatus.append(this.e);
      paramGpsStatus.append("\n");
      if (this.c < f1) {
        this.c = f1;
      }
      if (this.d > f1) {
        this.d = f1;
      }
      this.b = f1;
      paramGpsStatus.append("相对判断：");
      if (f1 - this.b > 3.0F) {
        paramGpsStatus.append("信号增强");
      }
      if (this.b - f1 > 2.0F)
      {
        paramGpsStatus.append("信号衰弱");
        this.f = false;
      }
      if (f1 <= (this.c + this.d) / 2.0F) {
        break label581;
      }
      this.f = true;
    }
    for (;;)
    {
      if (this.e != this.f) {
        paramGpsStatus.append("\n冲突" + this.e + "|" + this.f);
      }
      paramGpsStatus.append("\n最终结果" + this.f);
      return this.f;
      label559:
      if (f1 <= 30.0F) {
        break;
      }
      this.e = true;
      paramGpsStatus.append("室外|");
      break;
      label581:
      if (f1 < 22.0F) {
        this.f = false;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/bs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */