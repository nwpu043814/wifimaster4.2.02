package c.a.a;

public final class bb
  extends bt
{
  private bg a;
  private cu b;
  
  final bt a()
  {
    return new bb();
  }
  
  final void a(q paramq)
  {
    this.a = new bg(paramq);
    this.b = new cu(paramq);
  }
  
  final void a(s params, l paraml, boolean paramBoolean)
  {
    this.a.a(params, null, false);
    this.b.a(params);
  }
  
  final String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.a);
    if (!this.b.a())
    {
      localStringBuffer.append(' ');
      localStringBuffer.append(this.b.toString());
    }
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */