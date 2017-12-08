package c.a.a;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public final class al
  extends bt
{
  private static NumberFormat a;
  private static NumberFormat b;
  private long c;
  private long d;
  private long e;
  private long f;
  private long k;
  private long l;
  
  static
  {
    DecimalFormat localDecimalFormat = new DecimalFormat();
    a = localDecimalFormat;
    localDecimalFormat.setMinimumIntegerDigits(2);
    localDecimalFormat = new DecimalFormat();
    b = localDecimalFormat;
    localDecimalFormat.setMinimumIntegerDigits(3);
  }
  
  private static long a(int paramInt)
  {
    long l1 = paramInt >> 4;
    int i = paramInt & 0xF;
    if (l1 <= 9L)
    {
      paramInt = i;
      if (i <= 9) {}
    }
    else
    {
      throw new db("Invalid LOC Encoding");
    }
    while (paramInt > 0)
    {
      l1 *= 10L;
      paramInt--;
    }
    return l1;
  }
  
  private static String a(long paramLong, char paramChar1, char paramChar2)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    paramLong -= 2147483648L;
    if (paramLong < 0L)
    {
      paramLong = -paramLong;
      paramChar1 = paramChar2;
    }
    for (;;)
    {
      localStringBuffer.append(paramLong / 3600000L);
      paramLong %= 3600000L;
      localStringBuffer.append(" ");
      localStringBuffer.append(paramLong / 60000L);
      localStringBuffer.append(" ");
      a(localStringBuffer, b, paramLong % 60000L, 1000L);
      localStringBuffer.append(" ");
      localStringBuffer.append(paramChar1);
      return localStringBuffer.toString();
    }
  }
  
  private static void a(StringBuffer paramStringBuffer, NumberFormat paramNumberFormat, long paramLong1, long paramLong2)
  {
    paramStringBuffer.append(paramLong1 / paramLong2);
    paramLong1 %= paramLong2;
    if (paramLong1 != 0L)
    {
      paramStringBuffer.append(".");
      paramStringBuffer.append(paramNumberFormat.format(paramLong1));
    }
  }
  
  private static int b(long paramLong)
  {
    int i = 0;
    while (paramLong > 9L)
    {
      i = (byte)(i + 1);
      paramLong /= 10L;
    }
    return (int)((paramLong << 4) + i);
  }
  
  final bt a()
  {
    return new al();
  }
  
  final void a(q paramq)
  {
    if (paramq.g() != 0) {
      throw new db("Invalid LOC version");
    }
    this.c = a(paramq.g());
    this.d = a(paramq.g());
    this.e = a(paramq.g());
    this.f = paramq.i();
    this.k = paramq.i();
    this.l = paramq.i();
  }
  
  final void a(s params, l paraml, boolean paramBoolean)
  {
    params.b(0);
    params.b(b(this.c));
    params.b(b(this.d));
    params.b(b(this.e));
    params.a(this.f);
    params.a(this.k);
    params.a(this.l);
  }
  
  final String b()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(a(this.f, 'N', 'S'));
    localStringBuffer.append(" ");
    localStringBuffer.append(a(this.k, 'E', 'W'));
    localStringBuffer.append(" ");
    a(localStringBuffer, a, this.l - 10000000L, 100L);
    localStringBuffer.append("m ");
    a(localStringBuffer, a, this.c, 100L);
    localStringBuffer.append("m ");
    a(localStringBuffer, a, this.d, 100L);
    localStringBuffer.append("m ");
    a(localStringBuffer, a, this.e, 100L);
    localStringBuffer.append("m");
    return localStringBuffer.toString();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */