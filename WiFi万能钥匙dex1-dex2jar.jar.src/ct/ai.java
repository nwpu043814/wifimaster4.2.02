package ct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class ai
  extends bf
{
  private static ArrayList k;
  private static Map l;
  private String a = "";
  private String b = "";
  private ArrayList c = null;
  private String d = "";
  private String e = "";
  private int f = 0;
  private int g = 0;
  private int h = 0;
  private String i = "";
  private Map j = null;
  
  public ai() {}
  
  public ai(String paramString1, String paramString2, ArrayList paramArrayList, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3, String paramString5, Map paramMap)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramArrayList;
    this.d = paramString3;
    this.e = paramString4;
    this.f = paramInt1;
    this.g = paramInt2;
    this.h = paramInt3;
    this.i = paramString5;
    this.j = paramMap;
  }
  
  public final void a(bd parambd)
  {
    this.a = parambd.a(0, true);
    this.b = parambd.a(1, true);
    if (k == null)
    {
      k = new ArrayList();
      k.add("");
    }
    this.c = ((ArrayList)parambd.a(k, 2, true));
    this.d = parambd.a(3, false);
    this.e = parambd.a(4, false);
    this.f = parambd.a(this.f, 5, false);
    this.g = parambd.a(this.g, 6, false);
    this.h = parambd.a(this.h, 7, false);
    this.i = parambd.a(8, false);
    if (l == null)
    {
      l = new HashMap();
      l.put("", "");
    }
    this.j = ((Map)parambd.a(l, 9, false));
  }
  
  public final void a(be parambe)
  {
    parambe.a(this.a, 0);
    parambe.a(this.b, 1);
    parambe.a(this.c, 2);
    if (this.d != null) {
      parambe.a(this.d, 3);
    }
    if (this.e != null) {
      parambe.a(this.e, 4);
    }
    parambe.a(this.f, 5);
    parambe.a(this.g, 6);
    parambe.a(this.h, 7);
    if (this.i != null) {
      parambe.a(this.i, 8);
    }
    if (this.j != null) {
      parambe.a(this.j, 9);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */