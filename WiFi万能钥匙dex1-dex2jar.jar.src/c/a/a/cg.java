package c.a.a;

import java.util.ArrayList;
import java.util.List;

public final class cg
{
  private static final cg a = new cg(0);
  private static final cg b = new cg(1);
  private static final cg c = new cg(2);
  private int d;
  private Object e;
  
  private cg() {}
  
  cg(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 6)) {
      throw new IllegalArgumentException("invalid type");
    }
    this.d = paramInt;
    this.e = null;
  }
  
  cg(int paramInt, bq parambq)
  {
    if ((paramInt < 0) || (paramInt > 6)) {
      throw new IllegalArgumentException("invalid type");
    }
    this.d = paramInt;
    this.e = parambq;
  }
  
  static cg a(int paramInt)
  {
    cg localcg;
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("invalid type");
    case 0: 
      localcg = a;
    }
    for (;;)
    {
      return localcg;
      localcg = b;
      continue;
      localcg = c;
      continue;
      localcg = new cg();
      localcg.d = paramInt;
      localcg.e = null;
    }
  }
  
  final void a(bq parambq)
  {
    if (this.e == null) {
      this.e = new ArrayList();
    }
    ((List)this.e).add(parambq);
  }
  
  public final boolean a()
  {
    boolean bool = true;
    if (this.d == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public final boolean b()
  {
    if (this.d == 2) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final boolean c()
  {
    if (this.d == 3) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final boolean d()
  {
    if (this.d == 4) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final boolean e()
  {
    if (this.d == 5) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final boolean f()
  {
    if (this.d == 6) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final bq[] g()
  {
    if (this.d != 6) {}
    for (Object localObject = null;; localObject = (bq[])((List)localObject).toArray(new bq[((List)localObject).size()]))
    {
      return (bq[])localObject;
      localObject = (List)this.e;
    }
  }
  
  public final h h()
  {
    return (h)((bq)this.e).e();
  }
  
  public final p i()
  {
    return (p)((bq)this.e).e();
  }
  
  public final String toString()
  {
    String str;
    switch (this.d)
    {
    default: 
      throw new IllegalStateException();
    case 0: 
      str = "unknown";
    }
    for (;;)
    {
      return str;
      str = "NXDOMAIN";
      continue;
      str = "NXRRSET";
      continue;
      str = "delegation: " + this.e;
      continue;
      str = "CNAME: " + this.e;
      continue;
      str = "DNAME: " + this.e;
      continue;
      str = "successful";
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/cg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */