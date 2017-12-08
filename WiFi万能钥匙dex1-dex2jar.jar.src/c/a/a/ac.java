package c.a.a;

import java.util.Random;

public final class ac
  implements Cloneable
{
  private static Random d = new Random();
  private int a;
  private int b;
  private int[] c;
  
  public ac()
  {
    h();
  }
  
  public ac(int paramInt)
  {
    h();
    if ((paramInt < 0) || (paramInt > 65535)) {
      throw new IllegalArgumentException("DNS message ID " + paramInt + " is out of range");
    }
    this.a = paramInt;
  }
  
  ac(q paramq)
  {
    this(paramq.h());
    this.b = paramq.h();
    for (int i = 0; i < this.c.length; i++) {
      this.c[i] = paramq.h();
    }
  }
  
  static int a(int paramInt1, int paramInt2)
  {
    g(paramInt2);
    return 1 << 15 - paramInt2 | paramInt1;
  }
  
  private static boolean f(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 15) && (x.b(paramInt))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static void g(int paramInt)
  {
    if (!f(paramInt)) {
      throw new IllegalArgumentException("invalid flag bit " + paramInt);
    }
  }
  
  private void h()
  {
    this.c = new int[4];
    this.b = 0;
    this.a = -1;
  }
  
  private String i()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    for (int i = 0; i < 16; i++) {
      if ((f(i)) && (b(i)))
      {
        localStringBuffer.append(x.a(i));
        localStringBuffer.append(" ");
      }
    }
    return localStringBuffer.toString();
  }
  
  public final void a(int paramInt)
  {
    g(paramInt);
    this.b = a(this.b, paramInt);
  }
  
  final void a(s params)
  {
    params.c(b());
    params.c(this.b);
    for (int i = 0; i < this.c.length; i++) {
      params.c(this.c[i]);
    }
  }
  
  public final byte[] a()
  {
    s locals = new s((byte)0);
    a(locals);
    return locals.b();
  }
  
  public final int b()
  {
    int i;
    if (this.a >= 0) {
      i = this.a;
    }
    for (;;)
    {
      return i;
      try
      {
        if (this.a < 0) {
          this.a = d.nextInt(65535);
        }
        i = this.a;
      }
      finally {}
    }
  }
  
  public final boolean b(int paramInt)
  {
    boolean bool = true;
    g(paramInt);
    if ((this.b & 1 << 15 - paramInt) != 0) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public final int c()
  {
    return this.b & 0xF;
  }
  
  final void c(int paramInt)
  {
    if (this.c[paramInt] == 65535) {
      throw new IllegalStateException("DNS section count cannot be incremented");
    }
    int[] arrayOfInt = this.c;
    arrayOfInt[paramInt] += 1;
  }
  
  public final Object clone()
  {
    ac localac = new ac();
    localac.a = this.a;
    localac.b = this.b;
    System.arraycopy(this.c, 0, localac.c, 0, this.c.length);
    return localac;
  }
  
  public final int d(int paramInt)
  {
    return this.c[paramInt];
  }
  
  public final void d()
  {
    this.b &= 0x87FF;
    this.b |= 0x0;
  }
  
  public final int e()
  {
    return this.b >> 11 & 0xF;
  }
  
  final String e(int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(";; ->>HEADER<<- ");
    localStringBuffer.append("opcode: " + bj.a(e()));
    localStringBuffer.append(", status: " + bs.a(paramInt));
    localStringBuffer.append(", id: " + b());
    localStringBuffer.append("\n");
    localStringBuffer.append(";; flags: " + i());
    localStringBuffer.append("; ");
    for (paramInt = 0; paramInt < 4; paramInt++) {
      localStringBuffer.append(cf.a(paramInt) + ": " + this.c[paramInt] + " ");
    }
    return localStringBuffer.toString();
  }
  
  final void f()
  {
    if (this.c[3] == 0) {
      throw new IllegalStateException("DNS section count cannot be decremented");
    }
    int[] arrayOfInt = this.c;
    arrayOfInt[3] -= 1;
  }
  
  final int g()
  {
    return this.b;
  }
  
  public final String toString()
  {
    return e(this.b & 0xF);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */