package ct;

import java.util.HashMap;
import java.util.Map;

public final class aj
  extends bf
{
  private static Map h;
  private static al i;
  private static ah j;
  private static Map k;
  private static Map l;
  public Map a = null;
  public al b = null;
  public ah c = null;
  private String d = "";
  private int e = 0;
  private Map f = null;
  private Map g = null;
  
  public final void a(bd parambd)
  {
    this.d = parambd.a(0, true);
    this.e = parambd.a(this.e, 1, true);
    Object localObject;
    if (h == null)
    {
      h = new HashMap();
      localObject = new ak();
      h.put("", localObject);
    }
    this.a = ((Map)parambd.a(h, 2, true));
    if (i == null) {
      i = new al();
    }
    this.b = ((al)parambd.a(i, 3, false));
    if (j == null) {
      j = new ah();
    }
    this.c = ((ah)parambd.a(j, 4, false));
    if (k == null)
    {
      k = new HashMap();
      k.put("", "");
    }
    this.f = ((Map)parambd.a(k, 5, false));
    if (l == null)
    {
      l = new HashMap();
      localObject = (byte[])new byte[1];
      ((byte[])localObject)[0] = 0;
      l.put("", localObject);
    }
    this.g = ((Map)parambd.a(l, 6, false));
  }
  
  public final void a(be parambe)
  {
    parambe.a(this.d, 0);
    parambe.a(this.e, 1);
    parambe.a(this.a, 2);
    if (this.b != null) {
      parambe.a(this.b, 3);
    }
    if (this.c != null) {
      parambe.a(this.c, 4);
    }
    if (this.f != null) {
      parambe.a(this.f, 5);
    }
    if (this.g != null) {
      parambe.a(this.g, 6);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */