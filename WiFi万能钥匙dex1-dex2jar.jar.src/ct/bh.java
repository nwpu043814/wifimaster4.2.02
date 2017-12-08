package ct;

import java.util.HashMap;
import java.util.Map;

public final class bh
  extends bf
{
  private static byte[] k = null;
  private static Map l = null;
  public short a = 3;
  public int b = 0;
  public String c = null;
  public String d = null;
  public byte[] e;
  private byte f = 0;
  private int g = 0;
  private int h = 0;
  private Map i;
  private Map j;
  
  public final void a(bd parambd)
  {
    try
    {
      this.a = parambd.a(this.a, 1, true);
      this.f = parambd.a(this.f, 2, true);
      this.g = parambd.a(this.g, 3, true);
      this.b = parambd.a(this.b, 4, true);
      this.c = parambd.a(5, true);
      this.d = parambd.a(6, true);
      if (k == null) {
        k = new byte[] { 0 };
      }
      this.e = ((byte[])parambd.b(7, true));
      this.h = parambd.a(this.h, 8, true);
      HashMap localHashMap;
      if (l == null)
      {
        localHashMap = new java/util/HashMap;
        localHashMap.<init>();
        l = localHashMap;
        localHashMap.put("", "");
      }
      this.i = ((Map)parambd.a(l, 9, true));
      if (l == null)
      {
        localHashMap = new java/util/HashMap;
        localHashMap.<init>();
        l = localHashMap;
        localHashMap.put("", "");
      }
      this.j = ((Map)parambd.a(l, 10, true));
      return;
    }
    catch (Exception parambd)
    {
      parambd.printStackTrace();
      throw new RuntimeException(parambd);
    }
  }
  
  public final void a(be parambe)
  {
    parambe.a(this.a, 1);
    parambe.a(this.f, 2);
    parambe.a(this.g, 3);
    parambe.a(this.b, 4);
    parambe.a(this.c, 5);
    parambe.a(this.d, 6);
    parambe.a(this.e, 7);
    parambe.a(this.h, 8);
    parambe.a(this.i, 9);
    parambe.a(this.j, 10);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */