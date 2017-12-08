package c.a.a;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.PrintStream;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class am
{
  private static final bg[] C = new bg[0];
  private static bw a;
  private static bg[] b;
  private static Map c;
  private static int d;
  private boolean A;
  private boolean B;
  private bw e;
  private bg[] f;
  private i g;
  private boolean h;
  private int i;
  private bg j;
  private int k;
  private int l;
  private boolean m;
  private int n;
  private boolean o;
  private boolean p;
  private boolean q;
  private List r;
  private bt[] s;
  private int t;
  private String u;
  private boolean v;
  private boolean w;
  private String x;
  private boolean y;
  private boolean z;
  
  static
  {
    c();
  }
  
  private am(bg parambg, int paramInt)
  {
    ct.a(paramInt);
    m.a(1);
    if ((!ct.d(paramInt)) && (paramInt != 255)) {
      throw new IllegalArgumentException("Cannot query for meta-types other than ANY");
    }
    this.j = parambg;
    this.k = paramInt;
    this.l = 1;
    try
    {
      this.e = d();
      this.f = f();
      this.g = e();
      this.i = 3;
      this.m = bk.a("verbose");
      this.t = -1;
      return;
    }
    finally {}
  }
  
  public am(String paramString, int paramInt)
  {
    this(bg.a(paramString), paramInt);
  }
  
  private void a(bg parambg)
  {
    Object localObject1 = this.g.a(parambg, this.k, this.i);
    if (this.m)
    {
      System.err.println("lookup " + parambg + " " + ct.b(this.k));
      System.err.println(localObject1);
    }
    a(parambg, (cg)localObject1);
    if ((this.p) || (this.q)) {}
    for (;;)
    {
      return;
      localObject1 = au.a(bt.a(parambg, this.k, this.l));
      Object localObject2;
      try
      {
        localObject2 = this.e.a((au)localObject1);
        int i1 = ((au)localObject2).a().c();
        if ((i1 == 0) || (i1 == 3)) {
          break label175;
        }
        this.w = true;
        this.x = bs.a(i1);
      }
      catch (IOException parambg)
      {
        if ((parambg instanceof InterruptedIOException))
        {
          this.z = true;
          continue;
        }
        this.y = true;
      }
      continue;
      label175:
      if (!((au)localObject1).b().equals(((au)localObject2).b()))
      {
        this.w = true;
        this.x = "response does not match query";
      }
      else
      {
        localObject2 = this.g.a((au)localObject2);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = this.g.a(parambg, this.k, this.i);
        }
        if (this.m)
        {
          System.err.println("queried " + parambg + " " + ct.b(this.k));
          System.err.println(localObject1);
        }
        a(parambg, (cg)localObject1);
      }
    }
  }
  
  private void a(bg parambg1, bg parambg2)
  {
    this.o = true;
    this.w = false;
    this.y = false;
    this.z = false;
    this.v = false;
    this.B = false;
    this.n += 1;
    if ((this.n >= 6) || (parambg1.equals(parambg2)))
    {
      this.t = 1;
      this.u = "CNAME loop";
      this.p = true;
    }
    for (;;)
    {
      return;
      if (this.r == null) {
        this.r = new ArrayList();
      }
      this.r.add(parambg2);
      a(parambg1);
    }
  }
  
  private void a(bg parambg, cg paramcg)
  {
    if (paramcg.f())
    {
      bq[] arrayOfbq = paramcg.g();
      paramcg = new ArrayList();
      for (int i1 = 0; i1 < arrayOfbq.length; i1++)
      {
        parambg = arrayOfbq[i1].c();
        while (parambg.hasNext()) {
          paramcg.add(parambg.next());
        }
      }
      this.t = 0;
      this.s = ((bt[])paramcg.toArray(new bt[paramcg.size()]));
      this.p = true;
    }
    for (;;)
    {
      return;
      if (paramcg.a())
      {
        this.v = true;
        this.q = true;
        if (this.n > 0)
        {
          this.t = 3;
          this.p = true;
        }
      }
      else if (paramcg.b())
      {
        this.t = 4;
        this.s = null;
        this.p = true;
      }
      else if (paramcg.d())
      {
        a(paramcg.h().x_(), parambg);
      }
      else if (paramcg.e())
      {
        paramcg = paramcg.i();
        try
        {
          a(parambg.a(paramcg), parambg);
        }
        catch (bh parambg)
        {
          this.t = 1;
          this.u = "Invalid DNAME target";
          this.p = true;
        }
      }
      else if (paramcg.c())
      {
        this.B = true;
      }
    }
  }
  
  private void b(bg parambg1, bg parambg2)
  {
    this.q = false;
    bg localbg = parambg1;
    if (parambg2 != null) {}
    try
    {
      localbg = bg.a(parambg1, parambg2);
      a(localbg);
      return;
    }
    catch (bh parambg1)
    {
      for (;;)
      {
        this.A = true;
      }
    }
  }
  
  private static void c()
  {
    try
    {
      Object localObject1 = new c/a/a/w;
      ((w)localObject1).<init>();
      a = (bw)localObject1;
      b = bx.e().c();
      localObject1 = new java/util/HashMap;
      ((HashMap)localObject1).<init>();
      c = (Map)localObject1;
      d = bx.e().d();
      return;
    }
    catch (UnknownHostException localUnknownHostException)
    {
      RuntimeException localRuntimeException = new java/lang/RuntimeException;
      localRuntimeException.<init>("Failed to initialize resolver");
      throw localRuntimeException;
    }
    finally {}
  }
  
  private static bw d()
  {
    try
    {
      bw localbw = a;
      return localbw;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private static i e()
  {
    try
    {
      m.a(1);
      i locali2 = (i)c.get(av.c(1));
      i locali1 = locali2;
      if (locali2 == null)
      {
        locali1 = new c/a/a/i;
        locali1.<init>();
        c.put(av.c(1), locali1);
      }
      return locali1;
    }
    finally {}
  }
  
  private static bg[] f()
  {
    try
    {
      bg[] arrayOfbg = b;
      return arrayOfbg;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final bt[] a()
  {
    int i1 = 0;
    if (this.p)
    {
      this.n = 0;
      this.o = false;
      this.p = false;
      this.q = false;
      this.r = null;
      this.s = null;
      this.t = -1;
      this.u = null;
      this.v = false;
      this.w = false;
      this.x = null;
      this.y = false;
      this.z = false;
      this.A = false;
      this.B = false;
      if (this.h) {
        this.g.a();
      }
    }
    if (this.j.a())
    {
      b(this.j, null);
      break label216;
      label117:
      if (!this.p)
      {
        if (!this.w) {
          break label264;
        }
        this.t = 2;
        this.u = this.x;
        this.p = true;
      }
    }
    for (;;)
    {
      bt[] arrayOfbt = this.s;
      for (;;)
      {
        return arrayOfbt;
        if (this.f == null)
        {
          b(this.j, bg.a);
          break label117;
        }
        if (this.j.c() > d) {
          b(this.j, bg.a);
        }
        if (this.p)
        {
          arrayOfbt = this.s;
          continue;
          label216:
          if (this.o) {
            break label117;
          }
          i1++;
        }
        if (i1 >= this.f.length) {
          break label117;
        }
        b(this.j, this.f[i1]);
        if (!this.p) {
          break;
        }
        arrayOfbt = this.s;
      }
      label264:
      if (this.z)
      {
        this.t = 2;
        this.u = "timed out";
        this.p = true;
      }
      else if (this.y)
      {
        this.t = 2;
        this.u = "network error";
        this.p = true;
      }
      else if (this.v)
      {
        this.t = 3;
        this.p = true;
      }
      else if (this.B)
      {
        this.t = 1;
        this.u = "referral";
        this.p = true;
      }
      else if (this.A)
      {
        this.t = 1;
        this.u = "name too long";
        this.p = true;
      }
    }
  }
  
  public final int b()
  {
    if ((!this.p) || (this.t == -1))
    {
      StringBuffer localStringBuffer = new StringBuffer("Lookup of " + this.j + " ");
      if (this.l != 1) {
        localStringBuffer.append(m.b(this.l) + " ");
      }
      localStringBuffer.append(ct.b(this.k) + " isn't done");
      throw new IllegalStateException(localStringBuffer.toString());
    }
    return this.t;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */