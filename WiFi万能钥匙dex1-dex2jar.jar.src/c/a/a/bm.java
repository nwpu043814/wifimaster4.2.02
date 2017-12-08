package c.a.a;

public final class bm
  extends bt
{
  private int a;
  private bg b;
  private bg c;
  
  final bt a()
  {
    return new bm();
  }
  
  final void a(q paramq)
  {
    this.a = paramq.h();
    this.b = new bg(paramq);
    this.c = new bg(paramq);
  }
  
  final void a(s params, l paraml, boolean paramBoolean)
  {
    params.c(this.a);
    this.b.a(params, null, paramBoolean);
    this.c.a(params, null, paramBoolean);
  }
  
  final String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.a);
    localStringBuffer.append(" ");
    localStringBuffer.append(this.b);
    localStringBuffer.append(" ");
    localStringBuffer.append(this.c);
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */