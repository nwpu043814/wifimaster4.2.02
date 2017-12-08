package c.a.a;

public final class z
  extends bt
{
  private byte[] a;
  private byte[] b;
  private byte[] c;
  
  final bt a()
  {
    return new z();
  }
  
  final void a(q paramq)
  {
    this.b = paramq.k();
    this.a = paramq.k();
    this.c = paramq.k();
    double d2;
    StringBuilder localStringBuilder;
    try
    {
      double d1 = Double.parseDouble(a(this.b, false));
      d2 = Double.parseDouble(a(this.a, false));
      if ((d1 < -90.0D) || (d1 > 90.0D))
      {
        paramq = new java/lang/IllegalArgumentException;
        localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>("illegal longitude ");
        paramq.<init>(d1);
        throw paramq;
      }
    }
    catch (IllegalArgumentException paramq)
    {
      throw new db(paramq.getMessage());
    }
    if ((d2 < -180.0D) || (d2 > 180.0D))
    {
      paramq = new java/lang/IllegalArgumentException;
      localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>("illegal latitude ");
      paramq.<init>(d2);
      throw paramq;
    }
  }
  
  final void a(s params, l paraml, boolean paramBoolean)
  {
    params.b(this.b);
    params.b(this.a);
    params.b(this.c);
  }
  
  final String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(a(this.b, true));
    localStringBuffer.append(" ");
    localStringBuffer.append(a(this.a, true));
    localStringBuffer.append(" ");
    localStringBuffer.append(a(this.c, true));
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */