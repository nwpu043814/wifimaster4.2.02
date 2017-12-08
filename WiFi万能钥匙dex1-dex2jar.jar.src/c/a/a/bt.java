package c.a.a;

import c.a.a.a.b;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Arrays;

public abstract class bt
  implements Serializable, Cloneable, Comparable
{
  private static final DecimalFormat a;
  protected bg g;
  protected int h;
  protected int i;
  protected long j;
  
  static
  {
    DecimalFormat localDecimalFormat = new DecimalFormat();
    a = localDecimalFormat;
    localDecimalFormat.setMinimumIntegerDigits(3);
  }
  
  protected bt() {}
  
  bt(bg parambg, int paramInt1, int paramInt2)
  {
    if (!parambg.a()) {
      throw new bu(parambg);
    }
    ct.a(paramInt1);
    m.a(paramInt2);
    cp.a(0L);
    this.g = parambg;
    this.h = paramInt1;
    this.i = paramInt2;
    this.j = 0L;
  }
  
  static int a(String paramString, int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 65535)) {
      throw new IllegalArgumentException("\"" + paramString + "\" " + paramInt + " must be an unsigned 16 bit value");
    }
    return paramInt;
  }
  
  static long a(String paramString, long paramLong)
  {
    if ((paramLong < 0L) || (paramLong > 4294967295L)) {
      throw new IllegalArgumentException("\"" + paramString + "\" " + paramLong + " must be an unsigned 32 bit value");
    }
    return paramLong;
  }
  
  static bg a(bg parambg)
  {
    if (!parambg.a()) {
      throw new bu(parambg);
    }
    return parambg;
  }
  
  public static bt a(bg parambg, int paramInt1, int paramInt2)
  {
    return a(parambg, paramInt1, paramInt2, 0L);
  }
  
  private static bt a(bg parambg, int paramInt1, int paramInt2, long paramLong)
  {
    if (!parambg.a()) {
      throw new bu(parambg);
    }
    ct.a(paramInt1);
    m.a(paramInt2);
    cp.a(paramLong);
    return a(parambg, paramInt1, paramInt2, paramLong, false);
  }
  
  private static final bt a(bg parambg, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      localObject = ct.c(paramInt1);
      if (localObject != null) {
        localObject = ((bt)localObject).a();
      }
    }
    for (;;)
    {
      ((bt)localObject).g = parambg;
      ((bt)localObject).h = paramInt1;
      ((bt)localObject).i = paramInt2;
      ((bt)localObject).j = paramLong;
      return (bt)localObject;
      localObject = new cy();
      continue;
      localObject = new v();
    }
  }
  
  static bt a(q paramq, int paramInt, boolean paramBoolean)
  {
    boolean bool = true;
    Object localObject = new bg(paramq);
    int n = paramq.h();
    int m = paramq.h();
    if (paramInt == 0) {
      localObject = a((bg)localObject, n, m, 0L);
    }
    for (;;)
    {
      return (bt)localObject;
      long l = paramq.i();
      int k = paramq.h();
      if ((k == 0) && (paramBoolean) && ((paramInt == 1) || (paramInt == 2)))
      {
        localObject = a((bg)localObject, n, m, l);
      }
      else
      {
        if (paramq != null) {}
        bt localbt;
        for (paramBoolean = bool;; paramBoolean = false)
        {
          localbt = a((bg)localObject, n, m, l, paramBoolean);
          localObject = localbt;
          if (paramq == null) {
            break;
          }
          if (paramq.b() >= k) {
            break label141;
          }
          throw new db("truncated record");
        }
        label141:
        paramq.a(k);
        localbt.a(paramq);
        if (paramq.b() > 0) {
          throw new db("invalid record length");
        }
        paramq.c();
        localObject = localbt;
      }
    }
  }
  
  protected static String a(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("\\# ");
    localStringBuffer.append(paramArrayOfByte.length);
    localStringBuffer.append(" ");
    localStringBuffer.append(b.a(paramArrayOfByte));
    return localStringBuffer.toString();
  }
  
  protected static String a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramBoolean) {
      localStringBuffer.append('"');
    }
    int k = 0;
    if (k < paramArrayOfByte.length)
    {
      int m = paramArrayOfByte[k] & 0xFF;
      if ((m < 32) || (m >= 127))
      {
        localStringBuffer.append('\\');
        localStringBuffer.append(a.format(m));
      }
      for (;;)
      {
        k++;
        break;
        if ((m == 34) || (m == 92))
        {
          localStringBuffer.append('\\');
          localStringBuffer.append((char)m);
        }
        else
        {
          localStringBuffer.append((char)m);
        }
      }
    }
    if (paramBoolean) {
      localStringBuffer.append('"');
    }
    return localStringBuffer.toString();
  }
  
  private byte[] d()
  {
    s locals = new s((byte)0);
    a(locals, null, true);
    return locals.b();
  }
  
  abstract bt a();
  
  final void a(long paramLong)
  {
    this.j = paramLong;
  }
  
  abstract void a(q paramq);
  
  final void a(s params, int paramInt, l paraml)
  {
    this.g.a(params, paraml);
    params.c(this.h);
    params.c(this.i);
    if (paramInt == 0) {}
    for (;;)
    {
      return;
      params.a(this.j);
      paramInt = params.a();
      params.c(0);
      a(params, paraml, false);
      params.a(params.a() - paramInt - 2, paramInt);
    }
  }
  
  abstract void a(s params, l paraml, boolean paramBoolean);
  
  public final boolean a(bt parambt)
  {
    if ((h() == parambt.h()) && (this.i == parambt.i) && (this.g.equals(parambt.g))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  abstract String b();
  
  public bg c()
  {
    return null;
  }
  
  public int compareTo(Object paramObject)
  {
    int k = 0;
    int m = 0;
    Object localObject = (bt)paramObject;
    if (this == localObject) {
      k = m;
    }
    for (;;)
    {
      return k;
      m = this.g.compareTo(((bt)localObject).g);
      if (m != 0)
      {
        k = m;
      }
      else
      {
        m = this.i - ((bt)localObject).i;
        if (m != 0)
        {
          k = m;
        }
        else
        {
          m = this.h - ((bt)localObject).h;
          if (m != 0)
          {
            k = m;
          }
          else
          {
            paramObject = d();
            localObject = ((bt)localObject).d();
            for (;;)
            {
              if ((k >= paramObject.length) || (k >= localObject.length)) {
                break label139;
              }
              m = (paramObject[k] & 0xFF) - (localObject[k] & 0xFF);
              if (m != 0)
              {
                k = m;
                break;
              }
              k++;
            }
            label139:
            k = paramObject.length - localObject.length;
          }
        }
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null)
    {
      if ((paramObject instanceof bt)) {
        break label19;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      label19:
      paramObject = (bt)paramObject;
      bool1 = bool2;
      if (this.h == ((bt)paramObject).h)
      {
        bool1 = bool2;
        if (this.i == ((bt)paramObject).i)
        {
          bool1 = bool2;
          if (this.g.equals(((bt)paramObject).g)) {
            bool1 = Arrays.equals(d(), ((bt)paramObject).d());
          }
        }
      }
    }
  }
  
  public final bg f()
  {
    return this.g;
  }
  
  public final int g()
  {
    return this.h;
  }
  
  public final int h()
  {
    if (this.h == 46) {}
    for (int k = ((bp)this).d();; k = this.h) {
      return k;
    }
  }
  
  public int hashCode()
  {
    int k = 0;
    Object localObject = new s((byte)0);
    this.g.a((s)localObject);
    ((s)localObject).c(this.h);
    ((s)localObject).c(this.i);
    ((s)localObject).a(0L);
    int m = ((s)localObject).a();
    ((s)localObject).c(0);
    a((s)localObject, null, true);
    ((s)localObject).a(((s)localObject).a() - m - 2, m);
    localObject = ((s)localObject).b();
    m = 0;
    while (k < localObject.length)
    {
      m += (m << 3) + (localObject[k] & 0xFF);
      k++;
    }
    return m;
  }
  
  public final int i()
  {
    return this.i;
  }
  
  public final long j()
  {
    return this.j;
  }
  
  final bt k()
  {
    try
    {
      bt localbt = (bt)clone();
      return localbt;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new IllegalStateException();
    }
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.g);
    if (localStringBuffer.length() < 8) {
      localStringBuffer.append("\t");
    }
    if (localStringBuffer.length() < 16) {
      localStringBuffer.append("\t");
    }
    localStringBuffer.append("\t");
    Object localObject;
    if (bk.a("BINDTTL"))
    {
      long l2 = this.j;
      cp.a(l2);
      localObject = new StringBuffer();
      long l1 = l2 % 60L;
      long l3 = l2 / 60L;
      l2 = l3 % 60L;
      long l4 = l3 / 60L;
      l3 = l4 % 24L;
      long l5 = l4 / 24L;
      l4 = l5 % 7L;
      l5 /= 7L;
      if (l5 > 0L) {
        ((StringBuffer)localObject).append(l5 + "W");
      }
      if (l4 > 0L) {
        ((StringBuffer)localObject).append(l4 + "D");
      }
      if (l3 > 0L) {
        ((StringBuffer)localObject).append(l3 + "H");
      }
      if (l2 > 0L) {
        ((StringBuffer)localObject).append(l2 + "M");
      }
      if ((l1 > 0L) || ((l5 == 0L) && (l4 == 0L) && (l3 == 0L) && (l2 == 0L))) {
        ((StringBuffer)localObject).append(l1 + "S");
      }
      localStringBuffer.append(((StringBuffer)localObject).toString());
    }
    for (;;)
    {
      localStringBuffer.append("\t");
      if ((this.i != 1) || (!bk.a("noPrintIN")))
      {
        localStringBuffer.append(m.b(this.i));
        localStringBuffer.append("\t");
      }
      localStringBuffer.append(ct.b(this.h));
      localObject = b();
      if (!((String)localObject).equals(""))
      {
        localStringBuffer.append("\t");
        localStringBuffer.append((String)localObject);
      }
      return localStringBuffer.toString();
      localStringBuffer.append(this.j);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */