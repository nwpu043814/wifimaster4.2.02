package ct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class al
  extends bf
{
  private static Map c;
  public Map a = null;
  public long b = 0L;
  
  public final void a(bd parambd)
  {
    if (c == null)
    {
      c = new HashMap();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add("");
      c.put(Integer.valueOf(0), localArrayList);
    }
    this.a = ((Map)parambd.a(c, 0, false));
    this.b = parambd.a(this.b, 1, false);
  }
  
  public final void a(be parambe)
  {
    if (this.a != null) {
      parambe.a(this.a, 0);
    }
    parambe.a(this.b, 1);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */