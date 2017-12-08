package c.a.a;

import c.a.a.a.b;

public final class t
  extends bt
{
  private int a;
  private int b;
  private int c;
  private byte[] d;
  
  final bt a()
  {
    return new t();
  }
  
  final void a(q paramq)
  {
    this.a = paramq.h();
    this.b = paramq.g();
    this.c = paramq.g();
    this.d = paramq.j();
  }
  
  final void a(s params, l paraml, boolean paramBoolean)
  {
    params.c(this.a);
    params.b(this.b);
    params.b(this.c);
    if (this.d != null) {
      params.a(this.d);
    }
  }
  
  final String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.a);
    localStringBuffer.append(" ");
    localStringBuffer.append(this.b);
    localStringBuffer.append(" ");
    localStringBuffer.append(this.c);
    if (this.d != null)
    {
      localStringBuffer.append(" ");
      localStringBuffer.append(b.a(this.d));
    }
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */