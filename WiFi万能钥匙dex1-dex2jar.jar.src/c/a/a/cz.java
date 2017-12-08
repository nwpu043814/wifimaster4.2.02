package c.a.a;

public final class cz
  extends bt
{
  private int a;
  private int b;
  private byte[] c = new byte[0];
  
  final bt a()
  {
    return new cz();
  }
  
  final void a(q paramq)
  {
    this.a = paramq.h();
    this.b = paramq.h();
    this.c = paramq.k();
  }
  
  final void a(s params, l paraml, boolean paramBoolean)
  {
    params.c(this.a);
    params.c(this.b);
    params.b(this.c);
  }
  
  final String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.a + " ");
    localStringBuffer.append(this.b + " ");
    localStringBuffer.append(a(this.c, true));
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/cz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */