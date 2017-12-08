package c.a.a;

public final class cb
  extends bt
{
  private bg a;
  private bg b;
  private long c;
  private long d;
  private long e;
  private long f;
  private long k;
  
  cb() {}
  
  public cb(bg parambg1, int paramInt, bg parambg2, bg parambg3, long paramLong)
  {
    super(parambg1, 6, paramInt);
    this.a = a(parambg2);
    this.b = a(parambg3);
    this.c = a("serial", paramLong);
    this.d = a("refresh", 0L);
    this.e = a("retry", 0L);
    this.f = a("expire", 0L);
    this.k = a("minimum", 0L);
  }
  
  final bt a()
  {
    return new cb();
  }
  
  final void a(q paramq)
  {
    this.a = new bg(paramq);
    this.b = new bg(paramq);
    this.c = paramq.i();
    this.d = paramq.i();
    this.e = paramq.i();
    this.f = paramq.i();
    this.k = paramq.i();
  }
  
  final void a(s params, l paraml, boolean paramBoolean)
  {
    this.a.a(params, paraml, paramBoolean);
    this.b.a(params, paraml, paramBoolean);
    params.a(this.c);
    params.a(this.d);
    params.a(this.e);
    params.a(this.f);
    params.a(this.k);
  }
  
  final String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.a);
    localStringBuffer.append(" ");
    localStringBuffer.append(this.b);
    if (bk.a("multiline"))
    {
      localStringBuffer.append(" (\n\t\t\t\t\t");
      localStringBuffer.append(this.c);
      localStringBuffer.append("\t; serial\n\t\t\t\t\t");
      localStringBuffer.append(this.d);
      localStringBuffer.append("\t; refresh\n\t\t\t\t\t");
      localStringBuffer.append(this.e);
      localStringBuffer.append("\t; retry\n\t\t\t\t\t");
      localStringBuffer.append(this.f);
      localStringBuffer.append("\t; expire\n\t\t\t\t\t");
      localStringBuffer.append(this.k);
      localStringBuffer.append(" )\t; minimum");
    }
    for (;;)
    {
      return localStringBuffer.toString();
      localStringBuffer.append(" ");
      localStringBuffer.append(this.c);
      localStringBuffer.append(" ");
      localStringBuffer.append(this.d);
      localStringBuffer.append(" ");
      localStringBuffer.append(this.e);
      localStringBuffer.append(" ");
      localStringBuffer.append(this.f);
      localStringBuffer.append(" ");
      localStringBuffer.append(this.k);
    }
  }
  
  public final long d()
  {
    return this.c;
  }
  
  public final long e()
  {
    return this.k;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/cb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */