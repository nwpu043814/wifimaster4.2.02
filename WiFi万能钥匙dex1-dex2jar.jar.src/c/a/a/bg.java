package c.a.a;

import java.io.PrintStream;
import java.io.Serializable;
import java.text.DecimalFormat;

public final class bg
  implements Serializable, Comparable
{
  public static final bg a;
  public static final bg b;
  private static final byte[] f = { 0 };
  private static final byte[] g = { 1, 42 };
  private static final DecimalFormat h = new DecimalFormat();
  private static final byte[] i = new byte['Ā'];
  private static final bg j;
  private byte[] c;
  private long d;
  private int e;
  
  static
  {
    h.setMinimumIntegerDigits(3);
    int k = 0;
    if (k < i.length)
    {
      if ((k < 65) || (k > 90)) {
        i[k] = ((byte)k);
      }
      for (;;)
      {
        k++;
        break;
        i[k] = ((byte)(k - 65 + 97));
      }
    }
    bg localbg = new bg();
    a = localbg;
    localbg.a(f);
    localbg = new bg();
    b = localbg;
    localbg.c = new byte[0];
    localbg = new bg();
    j = localbg;
    localbg.a(g);
  }
  
  private bg() {}
  
  public bg(bg parambg, int paramInt)
  {
    int m = parambg.d();
    if (paramInt > m) {
      throw new IllegalArgumentException("attempted to remove too many labels");
    }
    this.c = parambg.c;
    b(m - paramInt);
    for (int k = 0; (k < 7) && (k < m - paramInt); k++) {
      a(k, parambg.a(k + paramInt));
    }
  }
  
  public bg(q paramq)
  {
    byte[] arrayOfByte = new byte[64];
    int m = 0;
    int k = 0;
    while (k == 0)
    {
      int n = paramq.g();
      switch (n & 0xC0)
      {
      default: 
        throw new db("bad label type");
      case 0: 
        if (d() >= 128) {
          throw new db("too many labels");
        }
        if (n == 0)
        {
          a(f, 0, 1);
          k = 1;
        }
        else
        {
          arrayOfByte[0] = ((byte)n);
          paramq.a(arrayOfByte, 1, n);
          a(arrayOfByte, 0, 1);
        }
        break;
      case 192: 
        int i1 = ((n & 0xFF3F) << 8) + paramq.g();
        if (bk.a("verbosecompression")) {
          System.err.println("currently " + paramq.a() + ", pointer to " + i1);
        }
        if (i1 >= paramq.a() - 2) {
          throw new db("bad compression");
        }
        n = m;
        if (m == 0)
        {
          paramq.e();
          n = 1;
        }
        paramq.c(i1);
        m = n;
        if (bk.a("verbosecompression"))
        {
          System.err.println("current name '" + this + "', seeking to " + i1);
          m = n;
        }
        break;
      }
    }
    if (m != 0) {
      paramq.f();
    }
  }
  
  private bg(String paramString, bg parambg)
  {
    if (paramString.equals("")) {
      throw a(paramString, "empty name");
    }
    if (paramString.equals("@")) {
      if (parambg == null) {
        b(b, this);
      }
    }
    for (;;)
    {
      return;
      b(parambg, this);
      continue;
      if (!paramString.equals(".")) {
        break;
      }
      b(a, this);
    }
    int i2 = -1;
    int i4 = 1;
    byte[] arrayOfByte = new byte[64];
    int i5 = 0;
    int i1 = 0;
    int m = 0;
    int i3 = 0;
    int k;
    int n;
    if (i3 < paramString.length())
    {
      k = (byte)paramString.charAt(i3);
      if (i5 != 0) {
        if ((k >= 48) && (k <= 57) && (i1 < 3))
        {
          int i6 = i1 + 1;
          int i7 = m * 10 + (k - 48);
          if (i7 > 255) {
            throw a(paramString, "bad escape");
          }
          m = i7;
          i1 = i6;
          n = i4;
          if (i6 < 3) {
            break label246;
          }
          k = (byte)i7;
          i1 = i6;
          m = i7;
        }
      }
    }
    for (;;)
    {
      if (i4 > 63)
      {
        throw a(paramString, "label too long");
        if ((i1 > 0) && (i1 < 3)) {
          throw a(paramString, "bad escape");
        }
      }
      else
      {
        arrayOfByte[i4] = k;
        i5 = 0;
        i2 = i4;
        n = i4 + 1;
        for (;;)
        {
          label246:
          i3++;
          i4 = n;
          break;
          if (k == 92)
          {
            i5 = 1;
            i1 = 0;
            m = 0;
            n = i4;
          }
          else
          {
            if (k != 46) {
              break label324;
            }
            if (i2 == -1) {
              throw a(paramString, "invalid empty label");
            }
            arrayOfByte[0] = ((byte)(i4 - 1));
            a(paramString, arrayOfByte, 0, 1);
            i2 = -1;
            n = 1;
          }
        }
        label324:
        if (i2 == -1) {}
        for (n = i3;; n = i2)
        {
          if (i4 > 63) {
            throw a(paramString, "label too long");
          }
          arrayOfByte[i4] = k;
          i4++;
          i2 = n;
          n = i4;
          break label246;
          if ((i1 > 0) && (i1 < 3)) {
            throw a(paramString, "bad escape");
          }
          if (i5 != 0) {
            throw a(paramString, "bad escape");
          }
          if (i2 == -1) {
            a(paramString, f, 0, 1);
          }
          for (m = 1;; m = 0)
          {
            if ((parambg == null) || (m != 0)) {
              break label469;
            }
            a(paramString, parambg.c, parambg.a(0), parambg.d());
            break;
            arrayOfByte[0] = ((byte)(i4 - 1));
            a(paramString, arrayOfByte, 0, 1);
          }
          label469:
          break;
        }
      }
    }
  }
  
  private final int a(int paramInt)
  {
    if ((paramInt == 0) && (d() == 0)) {}
    for (int m = 0;; m = (int)(this.d >>> (7 - paramInt) * 8) & 0xFF)
    {
      return m;
      if ((paramInt < 0) || (paramInt >= d())) {
        throw new IllegalArgumentException("label out of range");
      }
      if (paramInt >= 7) {
        break;
      }
    }
    int k = a(6);
    int n = 6;
    for (;;)
    {
      m = k;
      if (n >= paramInt) {
        break;
      }
      m = this.c[k];
      n++;
      k = m + 1 + k;
    }
  }
  
  public static bg a(bg parambg1, bg parambg2)
  {
    if (parambg1.a()) {}
    for (;;)
    {
      return parambg1;
      bg localbg = new bg();
      b(parambg1, localbg);
      localbg.a(parambg2.c, parambg2.a(0), parambg2.d());
      parambg1 = localbg;
    }
  }
  
  public static bg a(String paramString)
  {
    return a(paramString, null);
  }
  
  public static bg a(String paramString, bg parambg)
  {
    if ((paramString.equals("@")) && (parambg != null)) {}
    for (;;)
    {
      return parambg;
      if (paramString.equals(".")) {
        parambg = a;
      } else {
        parambg = new bg(paramString, parambg);
      }
    }
  }
  
  private static cs a(String paramString1, String paramString2)
  {
    return new cs("'" + paramString1 + "': " + paramString2);
  }
  
  private static String a(byte[] paramArrayOfByte, int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int k = paramInt + 1;
    int m = paramArrayOfByte[paramInt];
    paramInt = k;
    if (paramInt < k + m)
    {
      int n = paramArrayOfByte[paramInt] & 0xFF;
      if ((n <= 32) || (n >= 127))
      {
        localStringBuffer.append('\\');
        localStringBuffer.append(h.format(n));
      }
      for (;;)
      {
        paramInt++;
        break;
        if ((n == 34) || (n == 40) || (n == 41) || (n == 46) || (n == 59) || (n == 92) || (n == 64) || (n == 36))
        {
          localStringBuffer.append('\\');
          localStringBuffer.append((char)n);
        }
        else
        {
          localStringBuffer.append((char)n);
        }
      }
    }
    return localStringBuffer.toString();
  }
  
  private final void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 7) {}
    for (;;)
    {
      return;
      paramInt1 = (7 - paramInt1) * 8;
      this.d &= (255L << paramInt1 ^ 0xFFFFFFFFFFFFFFFF);
      this.d |= paramInt2 << paramInt1;
    }
  }
  
  private final void a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      a(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    catch (bh paramArrayOfByte)
    {
      throw a(paramString, "Name too long");
    }
  }
  
  private final void a(byte[] paramArrayOfByte)
  {
    try
    {
      a(paramArrayOfByte, 0, 1);
      return;
    }
    catch (bh paramArrayOfByte)
    {
      for (;;) {}
    }
  }
  
  private final void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i2 = 0;
    int k;
    int m;
    if (this.c == null)
    {
      k = 0;
      i1 = paramInt1;
      n = 0;
      m = 0;
    }
    for (;;)
    {
      if (n >= paramInt2) {
        break label90;
      }
      i3 = paramArrayOfByte[i1];
      if (i3 > 63)
      {
        throw new IllegalStateException("invalid label");
        k = this.c.length - a(0);
        break;
      }
      i3++;
      i1 += i3;
      m += i3;
      n++;
    }
    label90:
    int i3 = k + m;
    if (i3 > 255) {
      throw new bh();
    }
    int n = d();
    int i1 = n + paramInt2;
    if (i1 > 128) {
      throw new IllegalStateException("too many labels");
    }
    byte[] arrayOfByte = new byte[i3];
    if (k != 0) {
      System.arraycopy(this.c, a(0), arrayOfByte, 0, k);
    }
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, k, m);
    this.c = arrayOfByte;
    for (paramInt1 = i2; paramInt1 < paramInt2; paramInt1++)
    {
      a(n + paramInt1, k);
      k += arrayOfByte[k] + 1;
    }
    b(i1);
  }
  
  public static bg b(String paramString)
  {
    try
    {
      bg localbg = a(paramString, null);
      return localbg;
    }
    catch (cs localcs)
    {
      throw new IllegalArgumentException("Invalid name '" + paramString + "'");
    }
  }
  
  private final void b(int paramInt)
  {
    this.d &= 0xFFFFFFFFFFFFFF00;
    this.d |= paramInt;
  }
  
  private static final void b(bg parambg1, bg parambg2)
  {
    int k = 0;
    if (parambg1.a(0) == 0)
    {
      parambg2.c = parambg1.c;
      parambg2.d = parambg1.d;
    }
    for (;;)
    {
      return;
      int m = parambg1.a(0);
      int i1 = parambg1.c.length - m;
      int n = parambg1.d();
      parambg2.c = new byte[i1];
      System.arraycopy(parambg1.c, m, parambg2.c, 0, i1);
      while ((k < n) && (k < 7))
      {
        parambg2.a(k, parambg1.a(k) - m);
        k++;
      }
      parambg2.b(n);
    }
  }
  
  private final boolean b(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool2 = false;
    int i1 = d();
    int n = a(0);
    int m = 0;
    int k = paramInt;
    paramInt = n;
    boolean bool1;
    if (m < i1) {
      if (this.c[paramInt] != paramArrayOfByte[k]) {
        bool1 = bool2;
      }
    }
    for (;;)
    {
      return bool1;
      int i2 = this.c[paramInt];
      if (i2 > 63) {
        throw new IllegalStateException("invalid label");
      }
      k++;
      paramInt++;
      n = 0;
      for (;;)
      {
        if (n >= i2) {
          break label135;
        }
        bool1 = bool2;
        if (i[(this.c[paramInt] & 0xFF)] != i[(paramArrayOfByte[k] & 0xFF)]) {
          break;
        }
        n++;
        k++;
        paramInt++;
      }
      label135:
      m++;
      break;
      bool1 = true;
    }
  }
  
  private final int d()
  {
    return (int)(this.d & 0xFF);
  }
  
  public final bg a(p paramp)
  {
    int m = 0;
    bg localbg = paramp.f();
    paramp = paramp.y_();
    if (!a(localbg))
    {
      paramp = null;
      return paramp;
    }
    int n = d() - localbg.d();
    int i3 = b() - localbg.b();
    int i2 = a(0);
    int i1 = paramp.d();
    int k = paramp.b();
    if (i3 + k > 255) {
      throw new bh();
    }
    localbg = new bg();
    localbg.b(n + i1);
    localbg.c = new byte[i3 + k];
    System.arraycopy(this.c, i2, localbg.c, 0, i3);
    System.arraycopy(paramp.c, 0, localbg.c, i3, k);
    for (k = 0;; k++)
    {
      paramp = localbg;
      if (k >= 7) {
        break;
      }
      paramp = localbg;
      if (k >= n + i1) {
        break;
      }
      localbg.a(k, m);
      m += localbg.c[m] + 1;
    }
  }
  
  public final void a(s params)
  {
    int i2 = d();
    Object localObject;
    if (i2 == 0)
    {
      localObject = new byte[0];
      params.a((byte[])localObject);
      return;
    }
    byte[] arrayOfByte = new byte[this.c.length - a(0)];
    int k = a(0);
    int m = 0;
    for (int n = 0;; n++)
    {
      localObject = arrayOfByte;
      if (n >= i2) {
        break;
      }
      int i3 = this.c[k];
      if (i3 > 63) {
        throw new IllegalStateException("invalid label");
      }
      arrayOfByte[m] = this.c[k];
      k++;
      m++;
      int i1 = 0;
      while (i1 < i3)
      {
        arrayOfByte[m] = i[(this.c[k] & 0xFF)];
        i1++;
        m++;
        k++;
      }
    }
  }
  
  public final void a(s params, l paraml)
  {
    if (!a()) {
      throw new IllegalArgumentException("toWire() called on non-absolute name");
    }
    int n = d();
    int k = 0;
    bg localbg;
    label41:
    int m;
    if (k < n - 1) {
      if (k == 0)
      {
        localbg = this;
        m = -1;
        if (paraml != null) {
          m = paraml.a(localbg);
        }
        if (m < 0) {
          break label86;
        }
        params.c(m | 0xC000);
      }
    }
    for (;;)
    {
      return;
      localbg = new bg(this, k);
      break label41;
      label86:
      if (paraml != null) {
        paraml.a(params.a(), localbg);
      }
      m = a(k);
      params.a(this.c, m, this.c[m] + 1);
      k++;
      break;
      params.b(0);
    }
  }
  
  public final void a(s params, l paraml, boolean paramBoolean)
  {
    if (paramBoolean) {
      a(params);
    }
    for (;;)
    {
      return;
      a(params, paraml);
    }
  }
  
  public final boolean a()
  {
    boolean bool = false;
    int k = d();
    if (k == 0) {}
    for (;;)
    {
      return bool;
      if (this.c[a(k - 1)] == 0) {
        bool = true;
      }
    }
  }
  
  public final boolean a(bg parambg)
  {
    int k = d();
    int m = parambg.d();
    boolean bool;
    if (m > k) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      if (m == k) {
        bool = equals(parambg);
      } else {
        bool = parambg.b(this.c, a(k - m));
      }
    }
  }
  
  public final short b()
  {
    short s = 0;
    if (d() == 0) {}
    for (;;)
    {
      return s;
      s = (short)(this.c.length - a(0));
    }
  }
  
  public final int c()
  {
    return d();
  }
  
  public final int compareTo(Object paramObject)
  {
    paramObject = (bg)paramObject;
    int k;
    if (this == paramObject) {
      k = 0;
    }
    for (;;)
    {
      return k;
      int i2 = d();
      int i1 = ((bg)paramObject).d();
      if (i2 > i1) {
        k = i1;
      }
      label36:
      for (int m = 1;; m++)
      {
        if (m > k) {
          break label186;
        }
        int i5 = a(i2 - m);
        int i7 = ((bg)paramObject).a(i1 - m);
        int i6 = this.c[i5];
        int i4 = paramObject.c[i7];
        for (int n = 0;; n++)
        {
          if ((n >= i6) || (n >= i4)) {
            break label164;
          }
          int i3 = i[(this.c[(n + i5 + 1)] & 0xFF)] - i[(paramObject.c[(n + i7 + 1)] & 0xFF)];
          if (i3 != 0)
          {
            k = i3;
            break;
            k = i2;
            break label36;
          }
        }
        label164:
        if (i6 != i4)
        {
          k = i6 - i4;
          break;
        }
      }
      label186:
      k = i2 - i1;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (paramObject != null)
      {
        bool1 = bool2;
        if ((paramObject instanceof bg))
        {
          paramObject = (bg)paramObject;
          if (((bg)paramObject).e == 0) {
            ((bg)paramObject).hashCode();
          }
          if (this.e == 0) {
            hashCode();
          }
          bool1 = bool2;
          if (((bg)paramObject).e == this.e)
          {
            bool1 = bool2;
            if (((bg)paramObject).d() == d()) {
              bool1 = b(((bg)paramObject).c, ((bg)paramObject).a(0));
            }
          }
        }
      }
    }
  }
  
  public final int hashCode()
  {
    int k = 0;
    if (this.e != 0) {}
    for (k = this.e;; k = this.e)
    {
      return k;
      for (int m = a(0); m < this.c.length; m++) {
        k += (k << 3) + i[(this.c[m] & 0xFF)];
      }
      this.e = k;
    }
  }
  
  public final String toString()
  {
    int k = 0;
    int n = d();
    if (n == 0) {}
    for (Object localObject = "@";; localObject = ".")
    {
      return (String)localObject;
      if ((n != 1) || (this.c[a(0)] != 0)) {
        break;
      }
    }
    localObject = new StringBuffer();
    int m = a(0);
    for (;;)
    {
      int i1;
      if (k < n)
      {
        i1 = this.c[m];
        if (i1 > 63) {
          throw new IllegalStateException("invalid label");
        }
        if (i1 == 0) {
          ((StringBuffer)localObject).append('.');
        }
      }
      else
      {
        localObject = ((StringBuffer)localObject).toString();
        break;
      }
      if (k > 0) {
        ((StringBuffer)localObject).append('.');
      }
      ((StringBuffer)localObject).append(a(this.c, m));
      m += i1 + 1;
      k++;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */