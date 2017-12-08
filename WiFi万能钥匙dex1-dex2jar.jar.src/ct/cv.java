package ct;

import com.tencent.map.geolocation.TencentDistanceAnalysis;

public final class cv
  implements TencentDistanceAnalysis
{
  private double a;
  private int b;
  private int c;
  
  public final void a(double paramDouble)
  {
    this.a = paramDouble;
  }
  
  public final void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public final void b(int paramInt)
  {
    this.c = paramInt;
  }
  
  public final double getConfidence()
  {
    return this.a;
  }
  
  public final int getGpsCount()
  {
    return this.b;
  }
  
  public final int getNetworkCount()
  {
    return this.c;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/cv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */