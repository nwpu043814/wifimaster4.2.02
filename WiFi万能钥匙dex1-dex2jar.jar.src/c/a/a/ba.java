package c.a.a;

import c.a.a.a.b;
import c.a.a.a.c;

public final class ba
  extends bt
{
  private static final c k = new c("0123456789ABCDEFGHIJKLMNOPQRSTUV=");
  private int a;
  private int b;
  private int c;
  private byte[] d;
  private byte[] e;
  private cu f;
  
  final bt a()
  {
    return new ba();
  }
  
  final void a(q paramq)
  {
    this.a = paramq.g();
    this.b = paramq.g();
    this.c = paramq.h();
    int i = paramq.g();
    if (i > 0) {}
    for (this.d = paramq.d(i);; this.d = null)
    {
      this.e = paramq.d(paramq.g());
      this.f = new cu(paramq);
      return;
    }
  }
  
  final void a(s params, l paraml, boolean paramBoolean)
  {
    params.b(this.a);
    params.b(this.b);
    params.c(this.c);
    if (this.d != null)
    {
      params.b(this.d.length);
      params.a(this.d);
    }
    for (;;)
    {
      params.b(this.e.length);
      params.a(this.e);
      this.f.a(params);
      return;
      params.b(0);
    }
  }
  
  final String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.a);
    localStringBuffer.append(' ');
    localStringBuffer.append(this.b);
    localStringBuffer.append(' ');
    localStringBuffer.append(this.c);
    localStringBuffer.append(' ');
    if (this.d == null) {
      localStringBuffer.append('-');
    }
    for (;;)
    {
      localStringBuffer.append(' ');
      localStringBuffer.append(k.a(this.e));
      if (!this.f.a())
      {
        localStringBuffer.append(' ');
        localStringBuffer.append(this.f.toString());
      }
      return localStringBuffer.toString();
      localStringBuffer.append(b.a(this.d));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */