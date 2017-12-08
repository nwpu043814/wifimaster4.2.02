package ct;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ab
{
  public boolean a = false;
  public boolean b = true;
  public String c = null;
  public String d = null;
  public int[] e = null;
  public String f = "";
  public String g = null;
  public boolean h = true;
  public boolean i = true;
  public Map j = new HashMap();
  public byte[] k = null;
  public long l = 0L;
  public int m = 32768;
  public int n = 20000;
  public int o = 30000;
  public int p = 40000;
  public int q = 3;
  public boolean r = true;
  public String s = "";
  private List t = new ArrayList();
  private volatile boolean u = false;
  
  public ab(String paramString, int[] paramArrayOfInt)
  {
    this.c = paramString;
    this.e = paramArrayOfInt;
    if ((this.e != null) && (this.e[0] != -1)) {}
    for (this.f = (this.c + ":" + this.e[0]);; this.f = this.c)
    {
      this.s = bc.b(this.c);
      return;
    }
  }
  
  public final void a()
  {
    this.m = 32768;
  }
  
  public final void a(int paramInt)
  {
    if ((paramInt > 6000) && (paramInt < 60000)) {
      this.n = paramInt;
    }
  }
  
  public final void a(ad paramad)
  {
    this.t.add(paramad);
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    for (;;)
    {
      return;
      this.j.put(paramString1, paramString2);
    }
  }
  
  public final void b()
  {
    this.q = 1;
  }
  
  public final void b(int paramInt)
  {
    if ((paramInt > 6000) && (paramInt < 60000)) {
      this.o = paramInt;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */