package ct;

import java.util.HashMap;
import java.util.Map;

public final class am
  extends bf
{
  private static Map c;
  public Map a = null;
  public int b = 0;
  
  public final void a(bd parambd)
  {
    if (c == null)
    {
      c = new HashMap();
      c.put(Integer.valueOf(0), Byte.valueOf((byte)0));
    }
    this.a = ((Map)parambd.a(c, 0, true));
    this.b = parambd.a(this.b, 1, true);
  }
  
  public final void a(be parambe)
  {
    parambe.a(this.a, 0);
    parambe.a(this.b, 1);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */