package c.a.a;

public final class ab
  extends bt
{
  private byte[] a;
  private byte[] b;
  
  final bt a()
  {
    return new ab();
  }
  
  final void a(q paramq)
  {
    this.a = paramq.k();
    this.b = paramq.k();
  }
  
  final void a(s params, l paraml, boolean paramBoolean)
  {
    params.b(this.a);
    params.b(this.b);
  }
  
  final String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(a(this.a, true));
    localStringBuffer.append(" ");
    localStringBuffer.append(a(this.b, true));
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */