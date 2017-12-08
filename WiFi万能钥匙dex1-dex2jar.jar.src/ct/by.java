package ct;

import android.location.Location;
import java.util.LinkedList;

public final class by
{
  private static by a = new by();
  private a b = a.a;
  private LinkedList<cl> c = new LinkedList();
  
  public static by a()
  {
    return a;
  }
  
  public final int a(cl paramcl)
  {
    if (paramcl != null)
    {
      try
      {
        while (this.c.size() > 9) {
          this.c.remove(0);
        }
        if (this.c.size() <= 0) {
          break label136;
        }
      }
      finally {}
      for (;;)
      {
        localcl = (cl)this.c.getFirst();
        long l1 = paramcl.b;
        long l2 = localcl.b;
        double d = b.a.a(localcl.a.getLatitude(), localcl.a.getLongitude(), paramcl.a.getLatitude(), paramcl.a.getLongitude());
        if ((l1 - l2 <= 180000L) || (d <= 500.0D)) {
          break;
        }
        this.c.remove(0);
      }
      label136:
      cl localcl = new ct/cl;
      localcl.<init>(paramcl);
      this.c.add(localcl);
    }
    int i = this.c.size();
    return i;
  }
  
  public final long b()
  {
    for (;;)
    {
      double d1;
      long l;
      double d2;
      try
      {
        int i;
        Object localObject3;
        if (this.c.size() < 2)
        {
          d1 = 0.0D;
          if (this.c.size() < 2) {
            continue;
          }
          int j = this.c.size();
          l = 0L;
          d2 = 0.0D;
          i = 1;
          if (i < j)
          {
            localObject3 = (cl)this.c.get(i);
            localObject1 = (cl)this.c.get(i - 1);
            double d3 = b.a.a(((cl)localObject1).a.getLatitude(), ((cl)localObject1).a.getLongitude(), ((cl)localObject3).a.getLatitude(), ((cl)localObject3).a.getLongitude());
            l = ((cl)localObject3).b - ((cl)localObject1).b + l;
            d2 += d3;
            i++;
            continue;
          }
        }
        else
        {
          i = this.c.size() - 1;
          localObject1 = (cl)this.c.get(i);
          localObject3 = (cl)this.c.get(i - 1);
          if (((cl)localObject1).b == ((cl)localObject3).b) {
            break label474;
          }
          l = ((cl)localObject1).b - ((cl)localObject3).b;
          d1 = b.a.a(((cl)localObject3).a.getLatitude(), ((cl)localObject3).a.getLongitude(), ((cl)localObject1).a.getLatitude(), ((cl)localObject1).a.getLongitude()) / l * 1000.0D;
          continue;
        }
        if (l > 0L)
        {
          d2 = d2 / l * 1000.0D;
          if (this.c.size() < 2)
          {
            l = 0L;
            i = this.c.size();
            if (i >= 2) {
              continue;
            }
            this.b = a.a;
            localObject1 = this.b;
            localObject3 = a.c;
            if (localObject1 != localObject3) {
              break label466;
            }
            l = 180000L;
            return l;
          }
        }
        else
        {
          d2 = 0.0D;
          continue;
        }
        Object localObject1 = (cl)this.c.getFirst();
        l = ((cl)this.c.getLast()).b - ((cl)localObject1).b;
        continue;
        if ((i > 6) && (d1 < 3.0D) && (d2 < 6.0D))
        {
          this.b = a.c;
          continue;
        }
        if (l <= 60000L) {
          break label456;
        }
      }
      finally {}
      if ((d1 < 3.0D) && (d2 < 3.0D))
      {
        this.b = a.c;
      }
      else
      {
        label456:
        this.b = a.b;
        continue;
        label466:
        l = 60000L;
        continue;
        label474:
        l = 500L;
      }
    }
  }
  
  static enum a
  {
    static
    {
      a locala = a;
      locala = b;
      locala = c;
    }
    
    private a() {}
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/by.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */