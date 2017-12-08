package com.b.b;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;

public abstract class e
  implements Serializable, Iterable<Byte>
{
  public static final e a;
  private static final c c;
  private int d = 0;
  
  static
  {
    int i = 1;
    boolean bool;
    if (!e.class.desiredAssertionStatus()) {
      bool = true;
    }
    for (;;)
    {
      b = bool;
      a = new g(n.c);
      try
      {
        Class.forName("android.content.Context");
        if (i != 0)
        {
          h localh = new h((byte)0);
          c = localh;
          return;
          bool = false;
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        for (;;)
        {
          i = 0;
          continue;
          a locala = new a((byte)0);
        }
      }
    }
  }
  
  static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt2 - paramInt1;
    if ((paramInt1 | paramInt2 | i | paramInt3 - paramInt2) < 0)
    {
      if (paramInt1 < 0) {
        throw new IndexOutOfBoundsException("Beginning index: " + paramInt1 + " < 0");
      }
      if (paramInt2 < paramInt1) {
        throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + paramInt1 + ", " + paramInt2);
      }
      throw new IndexOutOfBoundsException("End index: " + paramInt2 + " >= " + paramInt3);
    }
    return i;
  }
  
  public static e a(String paramString)
  {
    return new g(paramString.getBytes(n.a));
  }
  
  static e a(byte[] paramArrayOfByte)
  {
    return new g(paramArrayOfByte);
  }
  
  public static e a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new g(c.a(paramArrayOfByte, paramInt1, paramInt2));
  }
  
  static e b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new b(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  static e c(int paramInt)
  {
    return new e(paramInt, (byte)0);
  }
  
  public abstract byte a(int paramInt);
  
  protected abstract int a(int paramInt1, int paramInt2);
  
  public final d a()
  {
    return new f(this);
  }
  
  abstract void a(d paramd);
  
  public abstract int b();
  
  public abstract e b(int paramInt);
  
  public abstract g c();
  
  protected final int d()
  {
    return this.d;
  }
  
  public abstract boolean equals(Object paramObject);
  
  public final int hashCode()
  {
    int j = this.d;
    int i = j;
    if (j == 0)
    {
      i = b();
      j = a(i, i);
      i = j;
      if (j == 0) {
        i = 1;
      }
      this.d = i;
    }
    return i;
  }
  
  public final String toString()
  {
    return String.format("<ByteString@%s size=%d>", new Object[] { Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(b()) });
  }
  
  private static final class a
    implements e.c
  {
    public final byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      return Arrays.copyOfRange(paramArrayOfByte, paramInt1, paramInt1 + paramInt2);
    }
  }
  
  private static final class b
    extends e.g
  {
    private final int d;
    private final int e;
    
    b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      super();
      a(paramInt1, paramInt1 + paramInt2, paramArrayOfByte.length);
      this.d = paramInt1;
      this.e = paramInt2;
    }
    
    public final byte a(int paramInt)
    {
      int i = this.e;
      if ((i - (paramInt + 1) | paramInt) < 0)
      {
        if (paramInt < 0) {
          throw new ArrayIndexOutOfBoundsException("Index < 0: " + paramInt);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + paramInt + ", " + i);
      }
      return this.c[(this.d + paramInt)];
    }
    
    public final int b()
    {
      return this.e;
    }
    
    protected final int e()
    {
      return this.d;
    }
  }
  
  private static abstract interface c
  {
    public abstract byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  }
  
  public static abstract interface d
    extends Iterator<Byte>
  {}
  
  static final class e
  {
    private final h a;
    private final byte[] b;
    
    private e(int paramInt)
    {
      this.b = new byte[paramInt];
      this.a = h.a(this.b);
    }
    
    public final e a()
    {
      this.a.i();
      return new e.g(this.b);
    }
    
    public final h b()
    {
      return this.a;
    }
  }
  
  static abstract class f
    extends e
  {}
  
  private static class g
    extends e.f
  {
    protected final byte[] c;
    
    g(byte[] paramArrayOfByte)
    {
      this.c = paramArrayOfByte;
    }
    
    public byte a(int paramInt)
    {
      return this.c[paramInt];
    }
    
    protected final int a(int paramInt1, int paramInt2)
    {
      return n.a(paramInt1, this.c, e() + 0, paramInt2);
    }
    
    final void a(d paramd)
    {
      paramd.a(this.c, e(), b());
    }
    
    public int b()
    {
      return this.c.length;
    }
    
    public final e b(int paramInt)
    {
      paramInt = a(0, paramInt, b());
      if (paramInt == 0) {}
      for (Object localObject = e.a;; localObject = new e.b(this.c, e() + 0, paramInt)) {
        return (e)localObject;
      }
    }
    
    public final g c()
    {
      return g.a(this.c, e(), b(), true);
    }
    
    protected int e()
    {
      return 0;
    }
    
    public final boolean equals(Object paramObject)
    {
      boolean bool;
      if (paramObject == this) {
        bool = true;
      }
      for (;;)
      {
        return bool;
        if (!(paramObject instanceof e))
        {
          bool = false;
        }
        else if (b() != ((e)paramObject).b())
        {
          bool = false;
        }
        else if (b() == 0)
        {
          bool = true;
        }
        else if ((paramObject instanceof g))
        {
          Object localObject = (g)paramObject;
          int j = d();
          int i = ((g)localObject).d();
          if ((j != 0) && (i != 0) && (j != i))
          {
            bool = false;
          }
          else
          {
            paramObject = (g)paramObject;
            int k = b();
            if (k > ((e)paramObject).b()) {
              throw new IllegalArgumentException("Length too large: " + k + b());
            }
            if (k + 0 > ((e)paramObject).b()) {
              throw new IllegalArgumentException("Ran off end of other: 0, " + k + ", " + ((e)paramObject).b());
            }
            if ((paramObject instanceof g))
            {
              g localg = (g)paramObject;
              paramObject = this.c;
              localObject = localg.c;
              int m = e();
              i = e();
              for (j = localg.e() + 0;; j++)
              {
                if (i >= m + k) {
                  break label278;
                }
                if (paramObject[i] != localObject[j])
                {
                  bool = false;
                  break;
                }
                i++;
              }
              label278:
              bool = true;
            }
            else
            {
              bool = ((e)paramObject).b(k + 0).equals(b(k));
            }
          }
        }
        else
        {
          bool = paramObject.equals(this);
        }
      }
    }
  }
  
  private static final class h
    implements e.c
  {
    public final byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      byte[] arrayOfByte = new byte[paramInt2];
      System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
      return arrayOfByte;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */