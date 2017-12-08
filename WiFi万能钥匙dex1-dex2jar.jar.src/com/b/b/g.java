package com.b.b;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class g
{
  private final byte[] a;
  private final boolean b;
  private int c;
  private int d;
  private int e;
  private final InputStream f;
  private int g;
  private boolean h = false;
  private int i;
  private int j = Integer.MAX_VALUE;
  private int k;
  private int l = 100;
  private int m = 67108864;
  private a n = null;
  
  private g(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.a = paramArrayOfByte;
    this.c = (paramInt1 + paramInt2);
    this.e = paramInt1;
    this.i = (-paramInt1);
    this.f = null;
    this.b = paramBoolean;
  }
  
  public static g a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length, false);
  }
  
  static g a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramArrayOfByte = new g(paramArrayOfByte, paramInt1, paramInt2, paramBoolean);
    try
    {
      paramArrayOfByte.c(paramInt2);
      return paramArrayOfByte;
    }
    catch (o paramArrayOfByte)
    {
      throw new IllegalArgumentException(paramArrayOfByte);
    }
  }
  
  private void e(int paramInt)
  {
    if (!f(paramInt)) {
      throw o.a();
    }
  }
  
  private boolean f(int paramInt)
  {
    boolean bool2 = false;
    if (this.e + paramInt <= this.c) {
      throw new IllegalStateException("refillBuffer() called when " + paramInt + " bytes were already available in buffer");
    }
    boolean bool1;
    if (this.i + this.e + paramInt > this.j) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (this.f != null)
      {
        int i1 = this.e;
        if (i1 > 0)
        {
          if (this.c > i1) {
            System.arraycopy(this.a, i1, this.a, 0, this.c - i1);
          }
          this.i += i1;
          this.c -= i1;
          this.e = 0;
        }
        i1 = this.f.read(this.a, this.c, this.a.length - this.c);
        if ((i1 == 0) || (i1 < -1) || (i1 > this.a.length)) {
          throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + i1 + "\nThe InputStream implementation is buggy.");
        }
        bool1 = bool2;
        if (i1 > 0)
        {
          this.c = (i1 + this.c);
          if (this.i + paramInt - this.m > 0) {
            throw o.h();
          }
          x();
          if (this.c < paramInt) {
            break;
          }
          bool1 = true;
        }
      }
    }
  }
  
  private byte[] g(int paramInt)
  {
    byte[] arrayOfByte1;
    if (paramInt <= 0) {
      if (paramInt == 0) {
        arrayOfByte1 = n.c;
      }
    }
    for (;;)
    {
      return arrayOfByte1;
      throw o.b();
      int i1 = this.i + this.e + paramInt;
      if (i1 > this.m) {
        throw o.h();
      }
      if (i1 > this.j)
      {
        h(this.j - this.i - this.e);
        throw o.a();
      }
      if (this.f == null) {
        throw o.a();
      }
      int i4 = this.e;
      i1 = this.c - this.e;
      this.i += this.c;
      this.e = 0;
      this.c = 0;
      int i2 = paramInt - i1;
      if ((i2 < 4096) || (i2 <= this.f.available()))
      {
        arrayOfByte1 = new byte[paramInt];
        System.arraycopy(this.a, i4, arrayOfByte1, 0, i1);
        while (i1 < arrayOfByte1.length)
        {
          i2 = this.f.read(arrayOfByte1, i1, paramInt - i1);
          if (i2 == -1) {
            throw o.a();
          }
          this.i += i2;
          i1 += i2;
        }
      }
      else
      {
        Object localObject = new ArrayList();
        while (i2 > 0)
        {
          arrayOfByte1 = new byte[Math.min(i2, 4096)];
          int i3 = 0;
          while (i3 < arrayOfByte1.length)
          {
            int i5 = this.f.read(arrayOfByte1, i3, arrayOfByte1.length - i3);
            if (i5 == -1) {
              throw o.a();
            }
            this.i += i5;
            i3 += i5;
          }
          i3 = arrayOfByte1.length;
          ((List)localObject).add(arrayOfByte1);
          i2 -= i3;
        }
        arrayOfByte1 = new byte[paramInt];
        System.arraycopy(this.a, i4, arrayOfByte1, 0, i1);
        localObject = ((List)localObject).iterator();
        byte[] arrayOfByte2;
        for (paramInt = i1; ((Iterator)localObject).hasNext(); paramInt = arrayOfByte2.length + paramInt)
        {
          arrayOfByte2 = (byte[])((Iterator)localObject).next();
          System.arraycopy(arrayOfByte2, 0, arrayOfByte1, paramInt, arrayOfByte2.length);
        }
      }
    }
  }
  
  private void h(int paramInt)
  {
    if ((paramInt <= this.c - this.e) && (paramInt >= 0)) {}
    int i1;
    for (this.e += paramInt;; this.e = (paramInt - i1))
    {
      return;
      if (paramInt < 0) {
        throw o.b();
      }
      if (this.i + this.e + paramInt > this.j)
      {
        h(this.j - this.i - this.e);
        throw o.a();
      }
      i1 = this.c - this.e;
      this.e = this.c;
      e(1);
      while (paramInt - i1 > this.c)
      {
        i1 += this.c;
        this.e = this.c;
        e(1);
      }
    }
  }
  
  private long t()
  {
    int i1 = this.e;
    byte[] arrayOfByte;
    int i2;
    int i3;
    long l1;
    if (this.c != i1)
    {
      arrayOfByte = this.a;
      i2 = i1 + 1;
      i3 = arrayOfByte[i1];
      if (i3 >= 0)
      {
        this.e = i2;
        l1 = i3;
        return l1;
      }
      if (this.c - i2 >= 9)
      {
        i1 = i2 + 1;
        i3 ^= arrayOfByte[i2] << 7;
        if (i3 < 0) {
          l1 = i3 ^ 0xFFFFFF80;
        }
      }
    }
    for (;;)
    {
      this.e = i1;
      break;
      i2 = i1 + 1;
      i3 ^= arrayOfByte[i1] << 14;
      if (i3 >= 0)
      {
        l1 = i3 ^ 0x3F80;
        i1 = i2;
      }
      else
      {
        i1 = i2 + 1;
        i2 = i3 ^ arrayOfByte[i2] << 21;
        if (i2 < 0)
        {
          l1 = i2 ^ 0xFFE03F80;
        }
        else
        {
          l1 = i2;
          i2 = i1 + 1;
          l1 ^= arrayOfByte[i1] << 28;
          if (l1 >= 0L)
          {
            l1 ^= 0xFE03F80;
            i1 = i2;
          }
          else
          {
            i1 = i2 + 1;
            l1 ^= arrayOfByte[i2] << 35;
            if (l1 < 0L)
            {
              l1 ^= 0xFFFFFFF80FE03F80;
            }
            else
            {
              i2 = i1 + 1;
              l1 ^= arrayOfByte[i1] << 42;
              if (l1 >= 0L)
              {
                l1 ^= 0x3F80FE03F80;
                i1 = i2;
              }
              else
              {
                i1 = i2 + 1;
                l1 ^= arrayOfByte[i2] << 49;
                if (l1 < 0L)
                {
                  l1 ^= 0xFFFE03F80FE03F80;
                }
                else
                {
                  i2 = i1 + 1;
                  l1 = l1 ^ arrayOfByte[i1] << 56 ^ 0xFE03F80FE03F80;
                  if (l1 < 0L)
                  {
                    i1 = i2 + 1;
                    if (arrayOfByte[i2] >= 0L) {
                      continue;
                    }
                    l1 = u();
                    break;
                  }
                  i1 = i2;
                }
              }
            }
          }
        }
      }
    }
  }
  
  private long u()
  {
    long l1 = 0L;
    for (int i1 = 0; i1 < 64; i1 += 7)
    {
      int i2 = y();
      l1 |= (i2 & 0x7F) << i1;
      if ((i2 & 0x80) == 0) {
        return l1;
      }
    }
    throw o.c();
  }
  
  private int v()
  {
    int i2 = this.e;
    int i1 = i2;
    if (this.c - i2 < 4)
    {
      e(4);
      i1 = this.e;
    }
    byte[] arrayOfByte = this.a;
    this.e = (i1 + 4);
    int i4 = arrayOfByte[i1];
    i2 = arrayOfByte[(i1 + 1)];
    int i3 = arrayOfByte[(i1 + 2)];
    return (arrayOfByte[(i1 + 3)] & 0xFF) << 24 | i4 & 0xFF | (i2 & 0xFF) << 8 | (i3 & 0xFF) << 16;
  }
  
  private long w()
  {
    int i2 = this.e;
    int i1 = i2;
    if (this.c - i2 < 8)
    {
      e(8);
      i1 = this.e;
    }
    byte[] arrayOfByte = this.a;
    this.e = (i1 + 8);
    long l2 = arrayOfByte[i1];
    long l7 = arrayOfByte[(i1 + 1)];
    long l5 = arrayOfByte[(i1 + 2)];
    long l1 = arrayOfByte[(i1 + 3)];
    long l4 = arrayOfByte[(i1 + 4)];
    long l3 = arrayOfByte[(i1 + 5)];
    long l6 = arrayOfByte[(i1 + 6)];
    return (arrayOfByte[(i1 + 7)] & 0xFF) << 56 | l2 & 0xFF | (l7 & 0xFF) << 8 | (l5 & 0xFF) << 16 | (l1 & 0xFF) << 24 | (l4 & 0xFF) << 32 | (l3 & 0xFF) << 40 | (l6 & 0xFF) << 48;
  }
  
  private void x()
  {
    this.c += this.d;
    int i1 = this.i + this.c;
    if (i1 > this.j)
    {
      this.d = (i1 - this.j);
      this.c -= this.d;
    }
    for (;;)
    {
      return;
      this.d = 0;
    }
  }
  
  private byte y()
  {
    if (this.e == this.c) {
      e(1);
    }
    byte[] arrayOfByte = this.a;
    int i1 = this.e;
    this.e = (i1 + 1);
    return arrayOfByte[i1];
  }
  
  public final int a()
  {
    int i1 = 1;
    int i2 = 0;
    if ((this.e == this.c) && (!f(1)))
    {
      if (i1 == 0) {
        break label41;
      }
      this.g = 0;
    }
    for (i1 = i2;; i1 = this.g)
    {
      return i1;
      i1 = 0;
      break;
      label41:
      this.g = s();
      if (ak.b(this.g) == 0) {
        throw o.d();
      }
    }
  }
  
  public final <T extends u> T a(x<T> paramx, j paramj)
  {
    int i1 = s();
    if (this.k >= this.l) {
      throw o.g();
    }
    i1 = c(i1);
    this.k += 1;
    paramx = (u)paramx.a(this, paramj);
    a(0);
    this.k -= 1;
    d(i1);
    return paramx;
  }
  
  public final void a(int paramInt)
  {
    if (this.g != paramInt) {
      throw o.e();
    }
  }
  
  public final void a(u.a parama, j paramj)
  {
    int i1 = s();
    if (this.k >= this.l) {
      throw o.g();
    }
    i1 = c(i1);
    this.k += 1;
    parama.b(this, paramj);
    a(0);
    this.k -= 1;
    d(i1);
  }
  
  public final double b()
  {
    return Double.longBitsToDouble(w());
  }
  
  public final boolean b(int paramInt)
  {
    int i3 = 0;
    boolean bool2 = true;
    int i2;
    int i1;
    boolean bool1;
    switch (ak.a(paramInt))
    {
    default: 
      throw o.f();
    case 0: 
      i2 = i3;
      if (this.c - this.e >= 10)
      {
        byte[] arrayOfByte = this.a;
        paramInt = this.e;
        i1 = 0;
        i2 = i3;
        if (i1 < 10)
        {
          i2 = paramInt + 1;
          if (arrayOfByte[paramInt] >= 0)
          {
            this.e = i2;
            bool1 = bool2;
          }
        }
      }
      break;
    }
    for (;;)
    {
      return bool1;
      i1++;
      paramInt = i2;
      break;
      for (;;)
      {
        if (i2 >= 10) {
          break label145;
        }
        bool1 = bool2;
        if (y() >= 0) {
          break;
        }
        i2++;
      }
      label145:
      throw o.c();
      h(8);
      bool1 = bool2;
      continue;
      h(s());
      bool1 = bool2;
      continue;
      do
      {
        i1 = a();
      } while ((i1 != 0) && (b(i1)));
      a(ak.a(ak.b(paramInt), 4));
      bool1 = bool2;
      continue;
      bool1 = false;
      continue;
      h(4);
      bool1 = bool2;
    }
  }
  
  public final float c()
  {
    return Float.intBitsToFloat(v());
  }
  
  public final int c(int paramInt)
  {
    if (paramInt < 0) {
      throw o.b();
    }
    int i1 = this.i + this.e + paramInt;
    paramInt = this.j;
    if (i1 > paramInt) {
      throw o.a();
    }
    this.j = i1;
    x();
    return paramInt;
  }
  
  public final long d()
  {
    return t();
  }
  
  public final void d(int paramInt)
  {
    this.j = paramInt;
    x();
  }
  
  public final long e()
  {
    return t();
  }
  
  public final int f()
  {
    return s();
  }
  
  public final long g()
  {
    return w();
  }
  
  public final int h()
  {
    return v();
  }
  
  public final boolean i()
  {
    if (t() != 0L) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final String j()
  {
    int i1 = s();
    String str;
    if ((i1 <= this.c - this.e) && (i1 > 0))
    {
      str = new String(this.a, this.e, i1, n.a);
      this.e = (i1 + this.e);
    }
    for (;;)
    {
      return str;
      if (i1 == 0)
      {
        str = "";
      }
      else if (i1 <= this.c)
      {
        e(i1);
        str = new String(this.a, this.e, i1, n.a);
        this.e = (i1 + this.e);
      }
      else
      {
        str = new String(g(i1), n.a);
      }
    }
  }
  
  public final String k()
  {
    int i2 = s();
    int i1 = this.e;
    if ((i2 <= this.c - i1) && (i2 > 0))
    {
      localObject = this.a;
      this.e = (i1 + i2);
      if (!aj.a((byte[])localObject, i1, i1 + i2)) {
        throw o.i();
      }
    }
    else if (i2 != 0) {}
    for (Object localObject = "";; localObject = new String((byte[])localObject, i1, i2, n.a))
    {
      return (String)localObject;
      if (i2 <= this.c)
      {
        e(i2);
        localObject = this.a;
        this.e = (i2 + 0);
        i1 = 0;
        break;
      }
      localObject = g(i2);
      i1 = 0;
      break;
    }
  }
  
  public final e l()
  {
    int i1 = s();
    e locale;
    if ((i1 <= this.c - this.e) && (i1 > 0)) {
      if ((this.b) && (this.h))
      {
        locale = e.b(this.a, this.e, i1);
        this.e = (i1 + this.e);
      }
    }
    for (;;)
    {
      return locale;
      locale = e.a(this.a, this.e, i1);
      break;
      if (i1 == 0) {
        locale = e.a;
      } else {
        locale = e.a(g(i1));
      }
    }
  }
  
  public final int m()
  {
    return s();
  }
  
  public final int n()
  {
    return s();
  }
  
  public final int o()
  {
    return v();
  }
  
  public final long p()
  {
    return w();
  }
  
  public final int q()
  {
    int i1 = s();
    return -(i1 & 0x1) ^ i1 >>> 1;
  }
  
  public final long r()
  {
    long l1 = t();
    return -(l1 & 1L) ^ l1 >>> 1;
  }
  
  public final int s()
  {
    int i1 = this.e;
    byte[] arrayOfByte;
    int i3;
    int i2;
    if (this.c != i1)
    {
      arrayOfByte = this.a;
      i3 = i1 + 1;
      i2 = arrayOfByte[i1];
      if (i2 >= 0)
      {
        this.e = i3;
        return i2;
      }
      if (this.c - i3 >= 9)
      {
        i1 = i3 + 1;
        i3 = i2 ^ arrayOfByte[i3] << 7;
        if (i3 < 0) {
          i2 = i3 ^ 0xFFFFFF80;
        }
      }
    }
    for (;;)
    {
      this.e = i1;
      break;
      i2 = i1 + 1;
      i3 ^= arrayOfByte[i1] << 14;
      if (i3 >= 0)
      {
        i3 ^= 0x3F80;
        i1 = i2;
        i2 = i3;
      }
      else
      {
        i1 = i2 + 1;
        i3 ^= arrayOfByte[i2] << 21;
        if (i3 < 0)
        {
          i2 = i3 ^ 0xFFE03F80;
        }
        else
        {
          int i4 = i1 + 1;
          i2 = arrayOfByte[i1];
          i3 = i3 ^ i2 << 28 ^ 0xFE03F80;
          i1 = i4;
          if (i2 < 0)
          {
            int i5 = i4 + 1;
            i2 = i3;
            i1 = i5;
            if (arrayOfByte[i4] >= 0) {
              continue;
            }
            i4 = i5 + 1;
            i1 = i4;
            if (arrayOfByte[i5] < 0)
            {
              i5 = i4 + 1;
              i2 = i3;
              i1 = i5;
              if (arrayOfByte[i4] >= 0) {
                continue;
              }
              i4 = i5 + 1;
              i1 = i4;
              if (arrayOfByte[i5] < 0)
              {
                i1 = i4 + 1;
                i2 = i3;
                if (arrayOfByte[i4] >= 0) {
                  continue;
                }
                i2 = (int)u();
                break;
              }
            }
          }
          i2 = i3;
        }
      }
    }
  }
  
  private static abstract interface a {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/b/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */