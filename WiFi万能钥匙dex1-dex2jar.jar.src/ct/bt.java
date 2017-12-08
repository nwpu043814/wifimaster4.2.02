package ct;

import android.net.wifi.ScanResult;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.eclipse.jdt.annotation.Nullable;

final class bt
{
  private static final Comparator<ScanResult> a = new bt.1();
  private ArrayList<ScanResult> b;
  private long c;
  private long d;
  
  bt()
  {
    this.b = new ArrayList();
    this.c = 0L;
  }
  
  private bt(List<ScanResult> paramList, long paramLong1, long paramLong2)
  {
    this.b = new ArrayList(paramList);
    Collections.sort(this.b, a);
    this.c = paramLong1;
    this.d = paramLong2;
  }
  
  public final bt a(@Nullable bt parambt)
  {
    int i;
    if ((parambt == null) || (parambt.b.size() == 0))
    {
      i = 1;
      if (i == 0) {
        break label47;
      }
    }
    label47:
    bt localbt;
    label132:
    label230:
    label232:
    for (parambt = new bt(this.b, this.c, this.d);; parambt = localbt)
    {
      return parambt;
      i = 0;
      break;
      Object localObject2;
      Object localObject1;
      ArrayList localArrayList;
      Iterator localIterator;
      if (this.d > parambt.d)
      {
        localObject2 = parambt.b;
        localObject1 = this.b;
        localbt = new bt();
        localArrayList = localbt.b;
        localbt.c = Math.max(this.c, parambt.c);
        localbt.d = Math.max(this.d, parambt.d);
        localArrayList.addAll((Collection)localObject1);
        localIterator = ((ArrayList)localObject2).iterator();
      }
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label232;
        }
        parambt = (ScanResult)localIterator.next();
        localObject2 = parambt.BSSID;
        localObject1 = localbt.b.iterator();
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
        } while (!((ScanResult)((Iterator)localObject1).next()).BSSID.equals(localObject2));
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label230;
          }
          localArrayList.add(parambt);
          break label132;
          localObject2 = this.b;
          localObject1 = parambt.b;
          break;
        }
      }
    }
  }
  
  public final ArrayList<ScanResult> a()
  {
    return this.b;
  }
  
  public final void a(long paramLong)
  {
    this.c = paramLong;
  }
  
  public final void a(List<ScanResult> paramList)
  {
    this.b.clear();
    this.b.addAll(paramList);
    Collections.sort(this.b, a);
  }
  
  public final void b()
  {
    this.b.clear();
  }
  
  public final void b(long paramLong)
  {
    this.d = paramLong;
  }
  
  public final int c()
  {
    return this.b.size();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */