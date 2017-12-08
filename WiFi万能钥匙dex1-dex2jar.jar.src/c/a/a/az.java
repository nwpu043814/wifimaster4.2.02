package c.a.a;

import c.a.a.a.b;

public final class az
  extends bt
{
  private int a;
  private int b;
  private int c;
  private byte[] d;
  
  final bt a()
  {
    return new az();
  }
  
  final void a(q paramq)
  {
    this.a = paramq.g();
    this.b = paramq.g();
    this.c = paramq.h();
    int i = paramq.g();
    if (i > 0) {}
    for (this.d = paramq.d(i);; this.d = null) {
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
      return localStringBuffer.toString();
      localStringBuffer.append(b.a(this.d));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */