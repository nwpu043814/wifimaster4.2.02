package c.a.a;

import c.a.a.a.d;

public final class g
  extends bt
{
  private int a;
  private int b;
  private int c;
  private byte[] d;
  
  final bt a()
  {
    return new g();
  }
  
  final void a(q paramq)
  {
    this.a = paramq.h();
    this.b = paramq.h();
    this.c = paramq.g();
    this.d = paramq.j();
  }
  
  final void a(s params, l paraml, boolean paramBoolean)
  {
    params.c(this.a);
    params.c(this.b);
    params.b(this.c);
    params.a(this.d);
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
      if (!bk.a("multiline")) {
        break label91;
      }
      localStringBuffer.append(" (\n");
      localStringBuffer.append(d.a(this.d, "\t", true));
    }
    for (;;)
    {
      return localStringBuffer.toString();
      label91:
      localStringBuffer.append(" ");
      localStringBuffer.append(d.a(this.d));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */