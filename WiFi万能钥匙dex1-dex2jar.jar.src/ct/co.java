package ct;

import android.net.wifi.ScanResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class co
  extends cn
{
  public static final co a = new co(Collections.emptyList(), 0L);
  private final List<ScanResult> b;
  private final long c;
  
  public co(List<ScanResult> paramList, long paramLong)
  {
    this.c = paramLong;
    this.b = new ArrayList(paramList);
  }
  
  public final List<ScanResult> a()
  {
    return Collections.unmodifiableList(this.b);
  }
  
  public final boolean a(long paramLong1, long paramLong2)
  {
    if (paramLong1 - this.c < paramLong2) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final boolean a(co paramco)
  {
    boolean bool2 = false;
    List localList = paramco.b;
    paramco = this.b;
    boolean bool1 = bool2;
    if (localList != null)
    {
      if (paramco != null) {
        break label28;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      label28:
      bool1 = bool2;
      if (localList.size() != 0)
      {
        bool1 = bool2;
        if (paramco.size() != 0)
        {
          bool1 = bool2;
          if (!b.a.a(localList, paramco)) {
            bool1 = true;
          }
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/co.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */