package ct;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationUtils;
import java.util.LinkedList;
import java.util.ListIterator;

public final class ch
{
  private int a = 10;
  private int b = 4;
  private LinkedList<a> c = new LinkedList();
  private bu d = new bu();
  
  private boolean a(a parama, bi parambi)
  {
    boolean bool;
    if (parambi == null)
    {
      bool = true;
      return bool;
    }
    label266:
    label269:
    label272:
    for (;;)
    {
      try
      {
        if (parama.d == 1)
        {
          if ((this.c == null) || ((this.c != null) && (this.c.size() == 0)) || ((!dh.a(parambi)) && (!dh.b(parambi))))
          {
            bool = true;
            break;
          }
          if (parama.c - ((a)this.c.getLast()).c < 120000L)
          {
            bool = false;
            break;
          }
        }
        if (this.c.size() >= this.b)
        {
          i = 1;
          if (i == 0) {
            continue;
          }
          i = 0;
          parambi = this.c.listIterator(this.c.size());
          int j = 0;
          if (!parambi.hasPrevious()) {
            break label266;
          }
          a locala = (a)parambi.previous();
          if (b.a.a(locala.a, locala.b, parama.a, parama.b) / ((Math.abs(locala.c - parama.c) + 1L) / 1000.0D) <= 40.0D) {
            continue;
          }
          k = 0;
          if (k != 0) {
            break label272;
          }
          i++;
          j++;
          k = this.b;
          if (j <= k) {
            break label269;
          }
          if (i <= 1) {
            continue;
          }
          bool = false;
          break;
        }
        int i = 0;
        continue;
        int k = 1;
        continue;
        bool = true;
        break;
      }
      finally {}
      continue;
    }
  }
  
  public final void a()
  {
    try
    {
      this.c.clear();
      bu localbu = this.d;
      localbu.c = -1.0D;
      localbu.d = -1.0D;
      localbu.e = -1.0D;
      localbu.a = -1.0F;
      localbu.b = -1L;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void a(TencentLocation paramTencentLocation)
  {
    try
    {
      this.c.add(a.a(paramTencentLocation));
      if (this.c.size() > this.a) {
        this.c.removeFirst();
      }
      return;
    }
    finally
    {
      paramTencentLocation = finally;
      throw paramTencentLocation;
    }
  }
  
  public final void a(da paramda)
  {
    try
    {
      double d1;
      bu localbu;
      double d3;
      double d4;
      double d2;
      long l3;
      if (paramda.getProvider().equalsIgnoreCase("gps"))
      {
        d1 = paramda.getSpeed();
        localbu = this.d;
        d3 = paramda.getLatitude();
        d4 = paramda.getLongitude();
        d2 = paramda.getAccuracy();
        l3 = paramda.getTime();
        if (d2 >= 1.0D) {
          break label375;
        }
        d2 = 1.0D;
      }
      for (;;)
      {
        localbu.a = ((float)d1);
        if (localbu.e < 0.0D)
        {
          localbu.b = l3;
          localbu.c = d3;
          localbu.d = d4;
        }
        for (localbu.e = (d2 * d2);; localbu.e = ((1.0D - d1) * localbu.e))
        {
          paramda.a(this.d.c, this.d.d);
          do
          {
            return;
          } while ((this.c == null) || ((this.c != null) && (this.c.size() == 0)));
          d1 = b.a.a(((a)this.c.getLast()).a, ((a)this.c.getLast()).b, paramda.getLatitude(), paramda.getLongitude()) / ((Math.abs(paramda.getTime() - ((a)this.c.getLast()).c) + 1L) / 1000.0D);
          break;
          long l2 = l3 - localbu.b;
          long l1 = l2;
          if (l2 < 1L) {
            l1 = 1L;
          }
          if (l1 > 0L)
          {
            d1 = localbu.e;
            localbu.e = ((float)l1 * localbu.a + d1);
            localbu.b = l3;
          }
          d1 = 1.03D * localbu.e / (d2 * d2 + localbu.e * 1.03D);
          localbu.c += (d3 - localbu.c) * d1;
          localbu.d += (d4 - localbu.d) * d1;
        }
      }
    }
    finally {}
  }
  
  public final boolean a(TencentLocation paramTencentLocation, bi parambi)
  {
    try
    {
      boolean bool = a(a.a(paramTencentLocation), parambi);
      return bool;
    }
    finally
    {
      paramTencentLocation = finally;
      throw paramTencentLocation;
    }
  }
  
  static final class a
  {
    double a;
    double b;
    long c;
    int d;
    
    static a a(TencentLocation paramTencentLocation)
    {
      int i = 2;
      a locala = new a();
      locala.a = paramTencentLocation.getLatitude();
      locala.b = paramTencentLocation.getLongitude();
      locala.c = paramTencentLocation.getTime();
      paramTencentLocation.getSpeed();
      if (TencentLocationUtils.isFromGps(paramTencentLocation))
      {
        if (paramTencentLocation.getAccuracy() < 100.0F) {
          i = 3;
        }
        locala.d = i;
        return locala;
      }
      if (paramTencentLocation.getAccuracy() < 500.0F) {}
      for (;;)
      {
        locala.d = i;
        break;
        i = 1;
      }
    }
    
    public final String toString()
    {
      return "[" + this.a + "," + this.b + "]";
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/ch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */