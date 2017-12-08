package ct;

import android.location.Location;
import android.os.Bundle;
import android.util.Pair;
import android.util.SparseArray;

final class bn
  extends bm
{
  private SparseArray<Pair<Double, Double>> a = new SparseArray();
  
  public bn(String paramString)
  {
    super(paramString, "check cell");
  }
  
  public final void a()
  {
    super.a();
    this.a.clear();
  }
  
  protected final boolean a(Bundle paramBundle)
  {
    int j = paramBundle.getInt("lac");
    int i = paramBundle.getInt("cid");
    paramBundle = (Location)paramBundle.getParcelable("location");
    boolean bool;
    if ((j == 0) || (i == 0)) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      i = j << i + 16;
      Pair localPair = (Pair)this.a.get(i);
      if (localPair == null)
      {
        paramBundle = Pair.create(Double.valueOf(paramBundle.getLatitude()), Double.valueOf(paramBundle.getLongitude()));
        this.a.put(i, paramBundle);
        if (this.a.size() > 320) {
          this.a.delete(this.a.keyAt(0));
        }
        bool = true;
      }
      else if (b.a.a(paramBundle.getLatitude(), paramBundle.getLongitude(), ((Double)localPair.first).doubleValue(), ((Double)localPair.second).doubleValue()) < 6000.0D)
      {
        bool = true;
      }
      else
      {
        bool = false;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/bn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */