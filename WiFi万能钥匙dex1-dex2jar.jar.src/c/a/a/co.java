package c.a.a;

import c.a.a.a.d;
import java.util.Date;

public final class co
  extends bt
{
  private bg a;
  private Date b;
  private int c;
  private byte[] d;
  private int e;
  private int f;
  private byte[] k;
  
  co() {}
  
  public co(bg parambg1, bg parambg2, Date paramDate, int paramInt1, byte[] paramArrayOfByte1, int paramInt2, int paramInt3, byte[] paramArrayOfByte2)
  {
    super(parambg1, 250, 255);
    this.a = a(parambg2);
    this.b = paramDate;
    this.c = a("fudge", paramInt1);
    this.d = paramArrayOfByte1;
    this.e = a("originalID", paramInt2);
    this.f = a("error", paramInt3);
    this.k = paramArrayOfByte2;
  }
  
  final bt a()
  {
    return new co();
  }
  
  final void a(q paramq)
  {
    this.a = new bg(paramq);
    this.b = new Date(((paramq.h() << 32) + paramq.i()) * 1000L);
    this.c = paramq.h();
    this.d = paramq.d(paramq.h());
    this.e = paramq.h();
    this.f = paramq.h();
    int i = paramq.h();
    if (i > 0) {}
    for (this.k = paramq.d(i);; this.k = null) {
      return;
    }
  }
  
  final void a(s params, l paraml, boolean paramBoolean)
  {
    this.a.a(params, null, paramBoolean);
    long l = this.b.getTime() / 1000L;
    params.c((int)(l >> 32));
    params.a(l & 0xFFFFFFFF);
    params.c(this.c);
    params.c(this.d.length);
    params.a(this.d);
    params.c(this.e);
    params.c(this.f);
    if (this.k != null)
    {
      params.c(this.k.length);
      params.a(this.k);
    }
    for (;;)
    {
      return;
      params.c(0);
    }
  }
  
  final String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.a);
    localStringBuffer.append(" ");
    if (bk.a("multiline")) {
      localStringBuffer.append("(\n\t");
    }
    localStringBuffer.append(this.b.getTime() / 1000L);
    localStringBuffer.append(" ");
    localStringBuffer.append(this.c);
    localStringBuffer.append(" ");
    localStringBuffer.append(this.d.length);
    if (bk.a("multiline"))
    {
      localStringBuffer.append("\n");
      localStringBuffer.append(d.a(this.d, "\t", false));
      localStringBuffer.append(" ");
      localStringBuffer.append(bs.b(this.f));
      localStringBuffer.append(" ");
      if (this.k != null) {
        break label218;
      }
      localStringBuffer.append(0);
    }
    for (;;)
    {
      if (bk.a("multiline")) {
        localStringBuffer.append(" )");
      }
      return localStringBuffer.toString();
      localStringBuffer.append(" ");
      localStringBuffer.append(d.a(this.d));
      break;
      label218:
      localStringBuffer.append(this.k.length);
      if (bk.a("multiline")) {
        localStringBuffer.append("\n\n\n\t");
      }
      for (;;)
      {
        if (this.f == 18)
        {
          if (this.k.length != 6)
          {
            localStringBuffer.append("<invalid BADTIME other data>");
            break;
            localStringBuffer.append(" ");
            continue;
          }
          long l3 = this.k[0] & 0xFF;
          long l6 = this.k[1] & 0xFF;
          long l5 = (this.k[2] & 0xFF) << 24;
          long l2 = (this.k[3] & 0xFF) << 16;
          long l1 = (this.k[4] & 0xFF) << 8;
          long l4 = this.k[5] & 0xFF;
          localStringBuffer.append("<server time: ");
          localStringBuffer.append(new Date(((l3 << 40) + (l6 << 32) + l5 + l2 + l1 + l4) * 1000L));
          localStringBuffer.append(">");
          break;
        }
      }
      localStringBuffer.append("<");
      localStringBuffer.append(d.a(this.k));
      localStringBuffer.append(">");
    }
  }
  
  public final bg d()
  {
    return this.a;
  }
  
  public final Date e()
  {
    return this.b;
  }
  
  public final int l()
  {
    return this.c;
  }
  
  public final byte[] m()
  {
    return this.d;
  }
  
  public final int n()
  {
    return this.f;
  }
  
  public final byte[] o()
  {
    return this.k;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/co.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */