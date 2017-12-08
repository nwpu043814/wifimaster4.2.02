package c.a.a;

public final class cd
  extends bt
{
  private int a;
  private int b;
  private int c;
  private bg d;
  
  final bt a()
  {
    return new cd();
  }
  
  final void a(q paramq)
  {
    this.a = paramq.h();
    this.b = paramq.h();
    this.c = paramq.h();
    this.d = new bg(paramq);
  }
  
  final void a(s params, l paraml, boolean paramBoolean)
  {
    params.c(this.a);
    params.c(this.b);
    params.c(this.c);
    this.d.a(params, null, paramBoolean);
  }
  
  final String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.a + " ");
    localStringBuffer.append(this.b + " ");
    localStringBuffer.append(this.c + " ");
    localStringBuffer.append(this.d);
    return localStringBuffer.toString();
  }
  
  public final bg c()
  {
    return this.d;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */