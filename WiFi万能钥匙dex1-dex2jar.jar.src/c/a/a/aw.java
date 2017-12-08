package c.a.a;

public final class aw
  extends bt
{
  private int a;
  private int b;
  private byte[] c;
  private byte[] d;
  private byte[] e;
  private bg f;
  
  final bt a()
  {
    return new aw();
  }
  
  final void a(q paramq)
  {
    this.a = paramq.h();
    this.b = paramq.h();
    this.c = paramq.k();
    this.d = paramq.k();
    this.e = paramq.k();
    this.f = new bg(paramq);
  }
  
  final void a(s params, l paraml, boolean paramBoolean)
  {
    params.c(this.a);
    params.c(this.b);
    params.b(this.c);
    params.b(this.d);
    params.b(this.e);
    this.f.a(params, null, paramBoolean);
  }
  
  final String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.a);
    localStringBuffer.append(" ");
    localStringBuffer.append(this.b);
    localStringBuffer.append(" ");
    localStringBuffer.append(a(this.c, true));
    localStringBuffer.append(" ");
    localStringBuffer.append(a(this.d, true));
    localStringBuffer.append(" ");
    localStringBuffer.append(a(this.e, true));
    localStringBuffer.append(" ");
    localStringBuffer.append(this.f);
    return localStringBuffer.toString();
  }
  
  public final bg c()
  {
    return this.f;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */