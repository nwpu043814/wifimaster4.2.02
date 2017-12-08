package com.b.b;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class h
  extends d
{
  private static final Logger a = Logger.getLogger(h.class.getName());
  private static final boolean b = ah.a();
  private static final long c = ah.c();
  
  public static int a()
  {
    return 4;
  }
  
  public static int a(q paramq)
  {
    int i = paramq.b();
    return i + i(i);
  }
  
  public static h a(byte[] paramArrayOfByte)
  {
    return new a(paramArrayOfByte, paramArrayOfByte.length);
  }
  
  public static int b()
  {
    return 4;
  }
  
  public static int b(int paramInt, u paramu)
  {
    return g(paramInt) + b(paramu);
  }
  
  public static int b(int paramInt, String paramString)
  {
    return g(paramInt) + b(paramString);
  }
  
  public static int b(e parame)
  {
    int i = parame.b();
    return i + i(i);
  }
  
  public static int b(u paramu)
  {
    int i = paramu.k();
    return i + i(i);
  }
  
  public static int b(String paramString)
  {
    try
    {
      i = aj.a(paramString);
      return i + i(i);
    }
    catch (aj.c localc)
    {
      for (;;)
      {
        int i = paramString.getBytes(n.a).length;
      }
    }
  }
  
  public static int b(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    return i + i(i);
  }
  
  public static int c()
  {
    return 8;
  }
  
  public static int c(long paramLong)
  {
    return d(paramLong);
  }
  
  @Deprecated
  public static int c(u paramu)
  {
    return paramu.k();
  }
  
  public static int d()
  {
    return 8;
  }
  
  public static int d(int paramInt1, int paramInt2)
  {
    return g(paramInt1) + i(m(paramInt2));
  }
  
  public static int d(long paramLong)
  {
    if ((0xFFFFFFFFFFFFFF80 & paramLong) == 0L) {}
    for (int i = 1;; i = 10)
    {
      return i;
      if (paramLong >= 0L) {
        break;
      }
    }
    i = 2;
    if ((0xFFFFFFF800000000 & paramLong) != 0L)
    {
      i = 6;
      paramLong >>>= 28;
    }
    for (;;)
    {
      int j = i;
      long l = paramLong;
      if ((0xFFFFFFFFFFE00000 & paramLong) != 0L)
      {
        j = i + 2;
        l = paramLong >>> 14;
      }
      i = j;
      if ((l & 0xFFFFFFFFFFFFC000) == 0L) {
        break;
      }
      i = j + 1;
      break;
    }
  }
  
  public static int e()
  {
    return 4;
  }
  
  public static int e(int paramInt)
  {
    return g(9) + h(paramInt);
  }
  
  public static int e(long paramLong)
  {
    return d(f(paramLong));
  }
  
  public static int f()
  {
    return 8;
  }
  
  public static int f(int paramInt)
  {
    return g(paramInt) + 1;
  }
  
  public static long f(long paramLong)
  {
    return paramLong << 1 ^ paramLong >> 63;
  }
  
  public static int g()
  {
    return 1;
  }
  
  public static int g(int paramInt)
  {
    return i(ak.a(paramInt, 0));
  }
  
  public static int h(int paramInt)
  {
    if (paramInt >= 0) {}
    for (paramInt = i(paramInt);; paramInt = 10) {
      return paramInt;
    }
  }
  
  public static int i(int paramInt)
  {
    if ((paramInt & 0xFFFFFF80) == 0) {
      paramInt = 1;
    }
    for (;;)
    {
      return paramInt;
      if ((paramInt & 0xC000) == 0) {
        paramInt = 2;
      } else if ((0xFFE00000 & paramInt) == 0) {
        paramInt = 3;
      } else if ((0xF0000000 & paramInt) == 0) {
        paramInt = 4;
      } else {
        paramInt = 5;
      }
    }
  }
  
  public static int j(int paramInt)
  {
    return i(m(paramInt));
  }
  
  public static int k(int paramInt)
  {
    return h(paramInt);
  }
  
  static int l(int paramInt)
  {
    return i(paramInt) + paramInt;
  }
  
  public static int m(int paramInt)
  {
    return paramInt << 1 ^ paramInt >> 31;
  }
  
  public abstract void a(byte paramByte);
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt1, int paramInt2);
  
  public abstract void a(int paramInt, u paramu);
  
  public abstract void a(int paramInt, String paramString);
  
  public abstract void a(int paramInt, boolean paramBoolean);
  
  public abstract void a(long paramLong);
  
  public abstract void a(e parame);
  
  public abstract void a(u paramu);
  
  public abstract void a(String paramString);
  
  final void a(String paramString, aj.c paramc)
  {
    a.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", paramc);
    paramString = paramString.getBytes(n.a);
    try
    {
      c(paramString.length);
      a(paramString, 0, paramString.length);
      return;
    }
    catch (IndexOutOfBoundsException paramString)
    {
      throw new b(paramString);
    }
    catch (b paramString)
    {
      throw paramString;
    }
  }
  
  abstract void a(byte[] paramArrayOfByte, int paramInt);
  
  public abstract void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract void b(int paramInt);
  
  public abstract void b(int paramInt1, int paramInt2);
  
  public abstract void b(long paramLong);
  
  public abstract void c(int paramInt);
  
  public final void c(int paramInt1, int paramInt2)
  {
    b(paramInt1, m(paramInt2));
  }
  
  public abstract void d(int paramInt);
  
  public abstract int h();
  
  public final void i()
  {
    if (h() != 0) {
      throw new IllegalStateException("Did not write as much data as expected.");
    }
  }
  
  private static final class a
    extends h
  {
    private final byte[] a;
    private final int b;
    private final int c;
    private int d;
    
    a(byte[] paramArrayOfByte, int paramInt)
    {
      super();
      if (paramArrayOfByte == null) {
        throw new NullPointerException("buffer");
      }
      if ((paramInt | 0x0 | paramArrayOfByte.length - (paramInt + 0)) < 0) {
        throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(0), Integer.valueOf(paramInt) }));
      }
      this.a = paramArrayOfByte;
      this.b = 0;
      this.d = 0;
      this.c = (paramInt + 0);
    }
    
    private void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      try
      {
        System.arraycopy(paramArrayOfByte, paramInt1, this.a, this.d, paramInt2);
        this.d += paramInt2;
        return;
      }
      catch (IndexOutOfBoundsException paramArrayOfByte)
      {
        throw new h.b(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.d), Integer.valueOf(this.c), Integer.valueOf(paramInt2) }), paramArrayOfByte);
      }
    }
    
    public final void a(byte paramByte)
    {
      try
      {
        byte[] arrayOfByte = this.a;
        int i = this.d;
        this.d = (i + 1);
        arrayOfByte[i] = paramByte;
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        throw new h.b(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.d), Integer.valueOf(this.c), Integer.valueOf(1) }), localIndexOutOfBoundsException);
      }
    }
    
    public final void a(int paramInt)
    {
      a(9, 0);
      b(paramInt);
    }
    
    public final void a(int paramInt1, int paramInt2)
    {
      c(ak.a(paramInt1, paramInt2));
    }
    
    public final void a(int paramInt, u paramu)
    {
      a(paramInt, 2);
      a(paramu);
    }
    
    public final void a(int paramInt, String paramString)
    {
      a(paramInt, 2);
      a(paramString);
    }
    
    public final void a(int paramInt, boolean paramBoolean)
    {
      int i = 0;
      a(paramInt, 0);
      paramInt = i;
      if (paramBoolean) {
        paramInt = 1;
      }
      a((byte)paramInt);
    }
    
    public final void a(long paramLong)
    {
      long l1 = paramLong;
      if (h.j())
      {
        l1 = paramLong;
        if (h() >= 10)
        {
          long l2 = h.k() + this.d;
          l1 = paramLong;
          paramLong = l2;
          if ((l1 & 0xFFFFFFFFFFFFFF80) == 0L)
          {
            ah.a(this.a, paramLong, (byte)(int)l1);
            this.d += 1;
          }
        }
      }
      for (;;)
      {
        return;
        ah.a(this.a, paramLong, (byte)((int)l1 & 0x7F | 0x80));
        this.d += 1;
        l1 >>>= 7;
        paramLong = 1L + paramLong;
        break;
        try
        {
          do
          {
            arrayOfByte = this.a;
            i = this.d;
            this.d = (i + 1);
            arrayOfByte[i] = ((byte)((int)l1 & 0x7F | 0x80));
            l1 >>>= 7;
          } while ((l1 & 0xFFFFFFFFFFFFFF80) != 0L);
          byte[] arrayOfByte = this.a;
          int i = this.d;
          this.d = (i + 1);
          arrayOfByte[i] = ((byte)(int)l1);
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
        {
          throw new h.b(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.d), Integer.valueOf(this.c), Integer.valueOf(1) }), localIndexOutOfBoundsException);
        }
      }
    }
    
    public final void a(e parame)
    {
      c(parame.b());
      parame.a(this);
    }
    
    public final void a(u paramu)
    {
      c(paramu.k());
      paramu.a(this);
    }
    
    public final void a(String paramString)
    {
      i = this.d;
      for (;;)
      {
        try
        {
          int k = i(paramString.length() * 3);
          int j = i(paramString.length());
          if (j == k)
          {
            this.d = (i + j);
            k = aj.a(paramString, this.a, this.d, h());
            this.d = i;
            c(k - i - j);
            this.d = k;
            return;
          }
        }
        catch (aj.c localc)
        {
          this.d = i;
          a(paramString, localc);
          continue;
        }
        catch (IndexOutOfBoundsException paramString)
        {
          throw new h.b(paramString);
        }
        c(aj.a(paramString));
        this.d = aj.a(paramString, this.a, this.d, h());
      }
    }
    
    public final void a(byte[] paramArrayOfByte, int paramInt)
    {
      c(paramInt);
      b(paramArrayOfByte, 0, paramInt);
    }
    
    public final void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      b(paramArrayOfByte, paramInt1, paramInt2);
    }
    
    public final void b(int paramInt)
    {
      if (paramInt >= 0) {
        c(paramInt);
      }
      for (;;)
      {
        return;
        a(paramInt);
      }
    }
    
    public final void b(int paramInt1, int paramInt2)
    {
      a(paramInt1, 0);
      c(paramInt2);
    }
    
    public final void b(long paramLong)
    {
      try
      {
        byte[] arrayOfByte = this.a;
        int i = this.d;
        this.d = (i + 1);
        arrayOfByte[i] = ((byte)((int)paramLong & 0xFF));
        arrayOfByte = this.a;
        i = this.d;
        this.d = (i + 1);
        arrayOfByte[i] = ((byte)((int)(paramLong >> 8) & 0xFF));
        arrayOfByte = this.a;
        i = this.d;
        this.d = (i + 1);
        arrayOfByte[i] = ((byte)((int)(paramLong >> 16) & 0xFF));
        arrayOfByte = this.a;
        i = this.d;
        this.d = (i + 1);
        arrayOfByte[i] = ((byte)((int)(paramLong >> 24) & 0xFF));
        arrayOfByte = this.a;
        i = this.d;
        this.d = (i + 1);
        arrayOfByte[i] = ((byte)((int)(paramLong >> 32) & 0xFF));
        arrayOfByte = this.a;
        i = this.d;
        this.d = (i + 1);
        arrayOfByte[i] = ((byte)((int)(paramLong >> 40) & 0xFF));
        arrayOfByte = this.a;
        i = this.d;
        this.d = (i + 1);
        arrayOfByte[i] = ((byte)((int)(paramLong >> 48) & 0xFF));
        arrayOfByte = this.a;
        i = this.d;
        this.d = (i + 1);
        arrayOfByte[i] = ((byte)((int)(paramLong >> 56) & 0xFF));
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        throw new h.b(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.d), Integer.valueOf(this.c), Integer.valueOf(1) }), localIndexOutOfBoundsException);
      }
    }
    
    public final void c(int paramInt)
    {
      int i = paramInt;
      long l;
      if (h.j())
      {
        i = paramInt;
        if (h() >= 10)
        {
          l = h.k() + this.d;
          if ((paramInt & 0xFFFFFF80) == 0)
          {
            ah.a(this.a, l, (byte)paramInt);
            this.d += 1;
          }
        }
      }
      for (;;)
      {
        return;
        ah.a(this.a, l, (byte)(paramInt & 0x7F | 0x80));
        this.d += 1;
        paramInt >>>= 7;
        l = 1L + l;
        break;
        try
        {
          do
          {
            arrayOfByte = this.a;
            paramInt = this.d;
            this.d = (paramInt + 1);
            arrayOfByte[paramInt] = ((byte)(i & 0x7F | 0x80));
            i >>>= 7;
          } while ((i & 0xFFFFFF80) != 0);
          byte[] arrayOfByte = this.a;
          paramInt = this.d;
          this.d = (paramInt + 1);
          arrayOfByte[paramInt] = ((byte)i);
        }
        catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
        {
          throw new h.b(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.d), Integer.valueOf(this.c), Integer.valueOf(1) }), localIndexOutOfBoundsException);
        }
      }
    }
    
    public final void d(int paramInt)
    {
      try
      {
        byte[] arrayOfByte = this.a;
        int i = this.d;
        this.d = (i + 1);
        arrayOfByte[i] = ((byte)(paramInt & 0xFF));
        arrayOfByte = this.a;
        i = this.d;
        this.d = (i + 1);
        arrayOfByte[i] = ((byte)(paramInt >> 8 & 0xFF));
        arrayOfByte = this.a;
        i = this.d;
        this.d = (i + 1);
        arrayOfByte[i] = ((byte)(paramInt >> 16 & 0xFF));
        arrayOfByte = this.a;
        i = this.d;
        this.d = (i + 1);
        arrayOfByte[i] = ((byte)(paramInt >> 24 & 0xFF));
        return;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        throw new h.b(String.format("Pos: %d, limit: %d, len: %d", new Object[] { Integer.valueOf(this.d), Integer.valueOf(this.c), Integer.valueOf(1) }), localIndexOutOfBoundsException);
      }
    }
    
    public final int h()
    {
      return this.c - this.d;
    }
  }
  
  public static final class b
    extends IOException
  {
    b()
    {
      super();
    }
    
    b(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
    
    b(Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/b/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */