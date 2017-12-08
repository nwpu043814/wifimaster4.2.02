package c.a.a;

import c.a.a.a.d;
import java.util.Date;

abstract class bz
  extends bt
{
  protected int a;
  protected int b;
  protected int c;
  protected long d;
  protected Date e;
  protected Date f;
  protected int k;
  protected bg l;
  protected byte[] m;
  
  final void a(q paramq)
  {
    this.a = paramq.h();
    this.b = paramq.g();
    this.c = paramq.g();
    this.d = paramq.i();
    this.e = new Date(paramq.i() * 1000L);
    this.f = new Date(paramq.i() * 1000L);
    this.k = paramq.h();
    this.l = new bg(paramq);
    this.m = paramq.j();
  }
  
  final void a(s params, l paraml, boolean paramBoolean)
  {
    params.c(this.a);
    params.b(this.b);
    params.b(this.c);
    params.a(this.d);
    params.a(this.e.getTime() / 1000L);
    params.a(this.f.getTime() / 1000L);
    params.c(this.k);
    this.l.a(params, null, paramBoolean);
    params.a(this.m);
  }
  
  final String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(ct.b(this.a));
    localStringBuffer.append(" ");
    localStringBuffer.append(this.b);
    localStringBuffer.append(" ");
    localStringBuffer.append(this.c);
    localStringBuffer.append(" ");
    localStringBuffer.append(this.d);
    localStringBuffer.append(" ");
    if (bk.a("multiline")) {
      localStringBuffer.append("(\n\t");
    }
    localStringBuffer.append(y.a(this.e));
    localStringBuffer.append(" ");
    localStringBuffer.append(y.a(this.f));
    localStringBuffer.append(" ");
    localStringBuffer.append(this.k);
    localStringBuffer.append(" ");
    localStringBuffer.append(this.l);
    if (bk.a("multiline"))
    {
      localStringBuffer.append("\n");
      localStringBuffer.append(d.a(this.m, "\t", true));
    }
    for (;;)
    {
      return localStringBuffer.toString();
      localStringBuffer.append(" ");
      localStringBuffer.append(d.a(this.m));
    }
  }
  
  public int d()
  {
    return this.a;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/bz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */