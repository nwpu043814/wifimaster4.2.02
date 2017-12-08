package c.a.a;

public final class ae
  extends bt
{
  private byte[] a;
  private byte[] b;
  
  final bt a()
  {
    return new ae();
  }
  
  final void a(q paramq)
  {
    this.a = paramq.k();
    if (paramq.b() > 0) {
      this.b = paramq.k();
    }
  }
  
  final void a(s params, l paraml, boolean paramBoolean)
  {
    params.b(this.a);
    if (this.b != null) {
      params.b(this.b);
    }
  }
  
  final String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(a(this.a, true));
    if (this.b != null)
    {
      localStringBuffer.append(" ");
      localStringBuffer.append(a(this.b, true));
    }
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */