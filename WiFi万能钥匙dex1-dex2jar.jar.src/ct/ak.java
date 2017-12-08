package ct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class ak
  extends bf
{
  private static ArrayList e;
  private static Map f;
  public ArrayList a = null;
  public String b = "";
  private int c = 0;
  private Map d = null;
  
  public final void a(bd parambd)
  {
    this.c = parambd.a(this.c, 0, true);
    if (e == null)
    {
      e = new ArrayList();
      e.add("");
    }
    this.a = ((ArrayList)parambd.a(e, 1, true));
    this.b = parambd.a(2, false);
    if (f == null)
    {
      f = new HashMap();
      f.put("", "");
    }
    this.d = ((Map)parambd.a(f, 3, false));
  }
  
  public final void a(be parambe)
  {
    parambe.a(this.c, 0);
    parambe.a(this.a, 1);
    if (this.b != null) {
      parambe.a(this.b, 2);
    }
    if (this.d != null) {
      parambe.a(this.d, 3);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */