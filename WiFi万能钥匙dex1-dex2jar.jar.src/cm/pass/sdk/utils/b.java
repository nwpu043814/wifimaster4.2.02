package cm.pass.sdk.utils;

import java.io.UnsupportedEncodingException;

public class b
{
  private static final byte[] b;
  private static final byte[] c;
  
  static
  {
    int i = 0;
    if (!b.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      b = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
      c = new byte[''];
      while (i < 128)
      {
        c[i] = -1;
        i++;
      }
    }
    for (i = 65; i <= 90; i++) {
      c[i] = ((byte)(i - 65));
    }
    for (i = 97; i <= 122; i++) {
      c[i] = ((byte)(i - 97 + 26));
    }
    for (i = 48; i <= 57; i++) {
      c[i] = ((byte)(i - 48 + 52));
    }
    c[43] = 62;
    c[47] = 63;
  }
  
  private static boolean a(byte paramByte)
  {
    boolean bool = true;
    if (paramByte == 61) {}
    for (;;)
    {
      return bool;
      if ((paramByte < 0) || (paramByte >= 128)) {
        bool = false;
      } else if (c[paramByte] == -1) {
        bool = false;
      }
    }
  }
  
  public static byte[] a(String paramString)
  {
    int j = 0;
    String str = b(paramString);
    if (str.charAt(str.length() - 2) == '=') {
      paramString = new byte[(str.length() / 4 - 1) * 3 + 1];
    }
    int i;
    int k;
    int m;
    for (;;)
    {
      i = 0;
      while (i < str.length() - 4)
      {
        int n = c[str.charAt(i)];
        k = c[str.charAt(i + 1)];
        int i1 = c[str.charAt(i + 2)];
        m = c[str.charAt(i + 3)];
        paramString[j] = ((byte)(n << 2 | k >> 4));
        paramString[(j + 1)] = ((byte)(k << 4 | i1 >> 2));
        paramString[(j + 2)] = ((byte)(i1 << 6 | m));
        i += 4;
        j += 3;
      }
      if (str.charAt(str.length() - 1) == '=') {
        paramString = new byte[(str.length() / 4 - 1) * 3 + 2];
      } else {
        paramString = new byte[str.length() / 4 * 3];
      }
    }
    if (str.charAt(str.length() - 2) == '=')
    {
      j = c[str.charAt(str.length() - 4)];
      i = c[str.charAt(str.length() - 3)];
      paramString[(paramString.length - 1)] = ((byte)(j << 2 | i >> 4));
    }
    for (;;)
    {
      return paramString;
      if (str.charAt(str.length() - 1) == '=')
      {
        k = c[str.charAt(str.length() - 4)];
        i = c[str.charAt(str.length() - 3)];
        j = c[str.charAt(str.length() - 2)];
        paramString[(paramString.length - 2)] = ((byte)(k << 2 | i >> 4));
        paramString[(paramString.length - 1)] = ((byte)(i << 4 | j >> 2));
      }
      else
      {
        i = c[str.charAt(str.length() - 4)];
        j = c[str.charAt(str.length() - 3)];
        m = c[str.charAt(str.length() - 2)];
        k = c[str.charAt(str.length() - 1)];
        paramString[(paramString.length - 3)] = ((byte)(i << 2 | j >> 4));
        paramString[(paramString.length - 2)] = ((byte)(j << 4 | m >> 2));
        paramString[(paramString.length - 1)] = ((byte)(m << 6 | k));
      }
    }
  }
  
  public static byte[] a(String paramString, int paramInt)
  {
    return a(paramString.getBytes(), paramInt);
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    int i = 0;
    int k = paramArrayOfByte.length % 3;
    if (k == 0) {}
    int j;
    for (byte[] arrayOfByte = new byte[paramArrayOfByte.length * 4 / 3];; arrayOfByte = new byte[(paramArrayOfByte.length / 3 + 1) * 4])
    {
      int m = paramArrayOfByte.length;
      j = 0;
      while (j < m - k)
      {
        int i1 = paramArrayOfByte[j] & 0xFF;
        int n = paramArrayOfByte[(j + 1)] & 0xFF;
        int i2 = paramArrayOfByte[(j + 2)] & 0xFF;
        arrayOfByte[i] = b[(i1 >>> 2 & 0x3F)];
        arrayOfByte[(i + 1)] = b[((i1 << 4 | n >>> 4) & 0x3F)];
        arrayOfByte[(i + 2)] = b[((n << 2 | i2 >>> 6) & 0x3F)];
        arrayOfByte[(i + 3)] = b[(i2 & 0x3F)];
        j += 3;
        i += 4;
      }
    }
    switch (k)
    {
    }
    for (;;)
    {
      return arrayOfByte;
      i = paramArrayOfByte[(paramArrayOfByte.length - 1)] & 0xFF;
      arrayOfByte[(arrayOfByte.length - 4)] = b[(i >>> 2 & 0x3F)];
      arrayOfByte[(arrayOfByte.length - 3)] = b[(i << 4 & 0x3F)];
      arrayOfByte[(arrayOfByte.length - 2)] = 61;
      arrayOfByte[(arrayOfByte.length - 1)] = 61;
      continue;
      i = paramArrayOfByte[(paramArrayOfByte.length - 2)] & 0xFF;
      j = paramArrayOfByte[(paramArrayOfByte.length - 1)] & 0xFF;
      arrayOfByte[(arrayOfByte.length - 4)] = b[(i >>> 2 & 0x3F)];
      arrayOfByte[(arrayOfByte.length - 3)] = b[((i << 4 | j >>> 4) & 0x3F)];
      arrayOfByte[(arrayOfByte.length - 2)] = b[(j << 2 & 0x3F)];
      arrayOfByte[(arrayOfByte.length - 1)] = 61;
    }
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    b localb = new b(paramInt3, new byte[paramInt2 * 3 / 4]);
    if (!localb.a(paramArrayOfByte, paramInt1, paramInt2, true)) {
      throw new IllegalArgumentException("bad base-64");
    }
    if (localb.b == localb.a.length) {
      paramArrayOfByte = localb.a;
    }
    for (;;)
    {
      return paramArrayOfByte;
      paramArrayOfByte = new byte[localb.b];
      System.arraycopy(localb.a, 0, paramArrayOfByte, 0, localb.b);
    }
  }
  
  private static String b(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int j = paramString.length();
    for (int i = 0; i < j; i++) {
      if (a((byte)paramString.charAt(i))) {
        localStringBuffer.append(paramString.charAt(i));
      }
    }
    return localStringBuffer.toString();
  }
  
  public static String b(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      paramArrayOfByte = new String(c(paramArrayOfByte, paramInt), "US-ASCII");
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      throw new AssertionError(paramArrayOfByte);
    }
  }
  
  public static byte[] b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    c localc = new c(paramInt3, null);
    int i = paramInt2 / 3 * 4;
    int j;
    if (localc.d)
    {
      paramInt3 = i;
      if (paramInt2 % 3 > 0) {
        paramInt3 = i + 4;
      }
      i = paramInt3;
      if (localc.e)
      {
        i = paramInt3;
        if (paramInt2 > 0)
        {
          j = (paramInt2 - 1) / 57;
          if (!localc.f) {
            break label186;
          }
        }
      }
    }
    label186:
    for (i = 2;; i = 1)
    {
      i = paramInt3 + i * (j + 1);
      localc.a = new byte[i];
      localc.a(paramArrayOfByte, paramInt1, paramInt2, true);
      if ((a) || (localc.b == i)) {
        break label192;
      }
      throw new AssertionError();
      paramInt3 = i;
      switch (paramInt2 % 3)
      {
      case 0: 
      default: 
        paramInt3 = i;
        break;
      case 1: 
        paramInt3 = i + 2;
        break;
      case 2: 
        paramInt3 = i + 3;
        break;
      }
    }
    label192:
    return localc.a;
  }
  
  public static byte[] c(byte[] paramArrayOfByte, int paramInt)
  {
    return b(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
  }
  
  static abstract class a
  {
    public byte[] a;
    public int b;
  }
  
  static class b
    extends b.a
  {
    private static final int[] c = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
    private static final int[] d = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
    private int e;
    private int f;
    private final int[] g;
    
    public b(int paramInt, byte[] paramArrayOfByte)
    {
      this.a = paramArrayOfByte;
      if ((paramInt & 0x8) == 0) {}
      for (paramArrayOfByte = c;; paramArrayOfByte = d)
      {
        this.g = paramArrayOfByte;
        this.e = 0;
        this.f = 0;
        return;
      }
    }
    
    public boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      if (this.e == 6) {
        paramBoolean = false;
      }
      for (;;)
      {
        return paramBoolean;
        int i1 = paramInt2 + paramInt1;
        paramInt2 = this.e;
        int i = this.f;
        int j = 0;
        byte[] arrayOfByte = this.a;
        int[] arrayOfInt = this.g;
        label46:
        int k = j;
        int n = i;
        if (paramInt1 < i1)
        {
          k = j;
          int m = i;
          n = paramInt1;
          if (paramInt2 == 0)
          {
            m = paramInt1;
            for (paramInt1 = i; m + 4 <= i1; paramInt1 = i)
            {
              i = arrayOfInt[(paramArrayOfByte[m] & 0xFF)] << 18 | arrayOfInt[(paramArrayOfByte[(m + 1)] & 0xFF)] << 12 | arrayOfInt[(paramArrayOfByte[(m + 2)] & 0xFF)] << 6 | arrayOfInt[(paramArrayOfByte[(m + 3)] & 0xFF)];
              paramInt1 = i;
              if (i < 0) {
                break;
              }
              arrayOfByte[(j + 2)] = ((byte)i);
              arrayOfByte[(j + 1)] = ((byte)(i >> 8));
              arrayOfByte[j] = ((byte)(i >> 16));
              j += 3;
              m += 4;
            }
            k = j;
            n = paramInt1;
            if (m < i1)
            {
              n = m;
              m = paramInt1;
              k = j;
            }
          }
          else
          {
            paramInt1 = n + 1;
            i = arrayOfInt[(paramArrayOfByte[n] & 0xFF)];
            switch (paramInt2)
            {
            }
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        j = k;
                        i = m;
                        break;
                        if (i >= 0)
                        {
                          paramInt2++;
                          j = k;
                          break;
                        }
                      } while (i == -1);
                      this.e = 6;
                      paramBoolean = false;
                      break;
                      if (i >= 0)
                      {
                        i = m << 6 | i;
                        paramInt2++;
                        j = k;
                        break label46;
                      }
                    } while (i == -1);
                    this.e = 6;
                    paramBoolean = false;
                    break;
                    if (i >= 0)
                    {
                      i = m << 6 | i;
                      paramInt2++;
                      j = k;
                      break label46;
                    }
                    if (i == -2)
                    {
                      arrayOfByte[k] = ((byte)(m >> 4));
                      paramInt2 = 4;
                      j = k + 1;
                      i = m;
                      break label46;
                    }
                  } while (i == -1);
                  this.e = 6;
                  paramBoolean = false;
                  break;
                  if (i >= 0)
                  {
                    i = m << 6 | i;
                    arrayOfByte[(k + 2)] = ((byte)i);
                    arrayOfByte[(k + 1)] = ((byte)(i >> 8));
                    arrayOfByte[k] = ((byte)(i >> 16));
                    j = k + 3;
                    paramInt2 = 0;
                    break label46;
                  }
                  if (i == -2)
                  {
                    arrayOfByte[(k + 1)] = ((byte)(m >> 2));
                    arrayOfByte[k] = ((byte)(m >> 10));
                    j = k + 2;
                    paramInt2 = 5;
                    i = m;
                    break label46;
                  }
                } while (i == -1);
                this.e = 6;
                paramBoolean = false;
                break;
                if (i == -2)
                {
                  paramInt2++;
                  j = k;
                  i = m;
                  break label46;
                }
              } while (i == -1);
              this.e = 6;
              paramBoolean = false;
              break;
            } while (i == -1);
            this.e = 6;
            paramBoolean = false;
            continue;
          }
        }
        if (!paramBoolean)
        {
          this.e = paramInt2;
          this.f = n;
          this.b = k;
          paramBoolean = true;
        }
        else
        {
          paramInt1 = k;
          switch (paramInt2)
          {
          default: 
            paramInt1 = k;
          case 0: 
          case 1: 
          case 2: 
          case 3: 
            for (;;)
            {
              this.e = paramInt2;
              this.b = paramInt1;
              paramBoolean = true;
              break;
              this.e = 6;
              paramBoolean = false;
              break;
              arrayOfByte[k] = ((byte)(n >> 4));
              paramInt1 = k + 1;
              continue;
              i = k + 1;
              arrayOfByte[k] = ((byte)(n >> 10));
              paramInt1 = i + 1;
              arrayOfByte[i] = ((byte)(n >> 2));
            }
          }
          this.e = 6;
          paramBoolean = false;
        }
      }
    }
  }
  
  static class c
    extends b.a
  {
    private static final byte[] h;
    private static final byte[] i;
    int c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    private final byte[] j;
    private int k;
    private final byte[] l;
    
    static
    {
      if (!b.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        g = bool;
        h = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
        i = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
        return;
      }
    }
    
    public c(int paramInt, byte[] paramArrayOfByte)
    {
      this.a = paramArrayOfByte;
      boolean bool1;
      if ((paramInt & 0x1) == 0)
      {
        bool1 = true;
        this.d = bool1;
        if ((paramInt & 0x2) != 0) {
          break label101;
        }
        bool1 = true;
        label33:
        this.e = bool1;
        if ((paramInt & 0x4) == 0) {
          break label106;
        }
        bool1 = bool2;
        label47:
        this.f = bool1;
        if ((paramInt & 0x8) != 0) {
          break label111;
        }
        paramArrayOfByte = h;
        label63:
        this.l = paramArrayOfByte;
        this.j = new byte[2];
        this.c = 0;
        if (!this.e) {
          break label118;
        }
      }
      label101:
      label106:
      label111:
      label118:
      for (paramInt = 19;; paramInt = -1)
      {
        this.k = paramInt;
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label33;
        bool1 = false;
        break label47;
        paramArrayOfByte = i;
        break label63;
      }
    }
    
    public boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      byte[] arrayOfByte2 = this.l;
      byte[] arrayOfByte1 = this.a;
      int n = 0;
      int m = this.k;
      int i3 = paramInt2 + paramInt1;
      int i1;
      switch (this.c)
      {
      default: 
        i1 = -1;
        paramInt2 = paramInt1;
        paramInt1 = i1;
        label64:
        if (paramInt1 != -1)
        {
          arrayOfByte1[0] = arrayOfByte2[(paramInt1 >> 18 & 0x3F)];
          arrayOfByte1[1] = arrayOfByte2[(paramInt1 >> 12 & 0x3F)];
          arrayOfByte1[2] = arrayOfByte2[(paramInt1 >> 6 & 0x3F)];
          n = 4;
          arrayOfByte1[3] = arrayOfByte2[(paramInt1 & 0x3F)];
          m--;
          if (m == 0)
          {
            paramInt1 = n;
            if (this.f)
            {
              paramInt1 = 5;
              arrayOfByte1[4] = 13;
            }
            n = paramInt1 + 1;
            arrayOfByte1[paramInt1] = 10;
            m = 19;
            paramInt1 = n;
          }
        }
        break;
      }
      for (;;)
      {
        label169:
        if (paramInt2 + 3 <= i3)
        {
          n = (paramArrayOfByte[paramInt2] & 0xFF) << 16 | (paramArrayOfByte[(paramInt2 + 1)] & 0xFF) << 8 | paramArrayOfByte[(paramInt2 + 2)] & 0xFF;
          arrayOfByte1[paramInt1] = arrayOfByte2[(n >> 18 & 0x3F)];
          arrayOfByte1[(paramInt1 + 1)] = arrayOfByte2[(n >> 12 & 0x3F)];
          arrayOfByte1[(paramInt1 + 2)] = arrayOfByte2[(n >> 6 & 0x3F)];
          arrayOfByte1[(paramInt1 + 3)] = arrayOfByte2[(n & 0x3F)];
          paramInt2 += 3;
          paramInt1 += 4;
          m--;
          if (m != 0) {
            break label1169;
          }
          if (!this.f) {
            break label1166;
          }
          m = paramInt1 + 1;
          arrayOfByte1[paramInt1] = 13;
          paramInt1 = m;
        }
        label726:
        label745:
        label918:
        label1085:
        label1163:
        label1166:
        for (;;)
        {
          m = paramInt1 + 1;
          arrayOfByte1[paramInt1] = 10;
          n = 19;
          paramInt1 = m;
          m = n;
          break label169;
          i1 = -1;
          paramInt2 = paramInt1;
          paramInt1 = i1;
          break label64;
          if (paramInt1 + 2 > i3) {
            break;
          }
          i1 = this.j[0];
          paramInt2 = paramInt1 + 1;
          int i2 = paramArrayOfByte[paramInt1];
          paramInt1 = paramArrayOfByte[paramInt2];
          this.c = 0;
          paramInt1 = (i1 & 0xFF) << 16 | (i2 & 0xFF) << 8 | paramInt1 & 0xFF;
          paramInt2++;
          break label64;
          if (paramInt1 + 1 > i3) {
            break;
          }
          i1 = this.j[0];
          i2 = this.j[1];
          paramInt2 = paramInt1 + 1;
          paramInt1 = paramArrayOfByte[paramInt1];
          this.c = 0;
          paramInt1 = (i1 & 0xFF) << 16 | (i2 & 0xFF) << 8 | paramInt1 & 0xFF;
          break label64;
          if (paramBoolean)
          {
            if (paramInt2 - this.c == i3 - 1)
            {
              if (this.c > 0)
              {
                paramArrayOfByte = this.j;
                n = 1;
                i1 = paramArrayOfByte[0];
              }
              for (;;)
              {
                i1 = (i1 & 0xFF) << 4;
                this.c -= n;
                i2 = paramInt1 + 1;
                arrayOfByte1[paramInt1] = arrayOfByte2[(i1 >> 6 & 0x3F)];
                n = i2 + 1;
                arrayOfByte1[i2] = arrayOfByte2[(i1 & 0x3F)];
                paramInt1 = n;
                if (this.d)
                {
                  i1 = n + 1;
                  arrayOfByte1[n] = 61;
                  paramInt1 = i1 + 1;
                  arrayOfByte1[i1] = 61;
                }
                n = paramInt1;
                if (this.e)
                {
                  n = paramInt1;
                  if (this.f)
                  {
                    arrayOfByte1[paramInt1] = 13;
                    n = paramInt1 + 1;
                  }
                  arrayOfByte1[n] = 10;
                  n++;
                }
                i1 = paramInt2;
                if ((g) || (this.c == 0)) {
                  break;
                }
                throw new AssertionError();
                i1 = paramArrayOfByte[paramInt2];
                paramInt2++;
                n = 0;
              }
            }
            if (paramInt2 - this.c == i3 - 2) {
              if (this.c > 1)
              {
                byte[] arrayOfByte3 = this.j;
                n = 1;
                i1 = arrayOfByte3[0];
                if (this.c <= 0) {
                  break label918;
                }
                i2 = this.j[n];
                n++;
                i1 = (i2 & 0xFF) << 2 | (i1 & 0xFF) << 10;
                this.c -= n;
                i2 = paramInt1 + 1;
                arrayOfByte1[paramInt1] = arrayOfByte2[(i1 >> 12 & 0x3F)];
                n = i2 + 1;
                arrayOfByte1[i2] = arrayOfByte2[(i1 >> 6 & 0x3F)];
                paramInt1 = n + 1;
                arrayOfByte1[n] = arrayOfByte2[(i1 & 0x3F)];
                if (!this.d) {
                  break label1163;
                }
                n = paramInt1 + 1;
                arrayOfByte1[paramInt1] = 61;
                paramInt1 = n;
              }
            }
          }
          for (;;)
          {
            n = paramInt1;
            if (this.e)
            {
              n = paramInt1;
              if (this.f)
              {
                arrayOfByte1[paramInt1] = 13;
                n = paramInt1 + 1;
              }
              arrayOfByte1[n] = 10;
              n++;
            }
            i1 = paramInt2;
            break;
            i1 = paramArrayOfByte[paramInt2];
            paramInt2++;
            n = 0;
            break label726;
            i2 = paramArrayOfByte[paramInt2];
            paramInt2++;
            break label745;
            i1 = paramInt2;
            n = paramInt1;
            if (!this.e) {
              break;
            }
            i1 = paramInt2;
            n = paramInt1;
            if (paramInt1 <= 0) {
              break;
            }
            i1 = paramInt2;
            n = paramInt1;
            if (m == 19) {
              break;
            }
            if (this.f)
            {
              n = paramInt1 + 1;
              arrayOfByte1[paramInt1] = 13;
              paramInt1 = n;
            }
            for (;;)
            {
              n = paramInt1 + 1;
              arrayOfByte1[paramInt1] = 10;
              i1 = paramInt2;
              break;
              i2 = n;
              if (!g)
              {
                i2 = n;
                if (i1 != i3)
                {
                  throw new AssertionError();
                  if (paramInt2 != i3 - 1) {
                    break label1085;
                  }
                  arrayOfByte1 = this.j;
                  n = this.c;
                  this.c = (n + 1);
                  arrayOfByte1[n] = paramArrayOfByte[paramInt2];
                  i2 = paramInt1;
                }
              }
              for (;;)
              {
                this.b = i2;
                this.k = m;
                return true;
                i2 = paramInt1;
                if (paramInt2 == i3 - 2)
                {
                  arrayOfByte1 = this.j;
                  n = this.c;
                  this.c = (n + 1);
                  arrayOfByte1[n] = paramArrayOfByte[paramInt2];
                  arrayOfByte1 = this.j;
                  n = this.c;
                  this.c = (n + 1);
                  arrayOfByte1[n] = paramArrayOfByte[(paramInt2 + 1)];
                  i2 = paramInt1;
                }
              }
            }
          }
        }
        label1169:
        continue;
        paramInt1 = 4;
        continue;
        paramInt1 = n;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/utils/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */