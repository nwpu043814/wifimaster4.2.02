package com.b.b;

final class aj
{
  private static final a a;
  
  static
  {
    int i;
    if ((ah.a()) && (ah.b()))
    {
      i = 1;
      if (i == 0) {
        break label36;
      }
    }
    label36:
    for (Object localObject = new d();; localObject = new b())
    {
      a = (a)localObject;
      return;
      i = 0;
      break;
    }
  }
  
  static int a(CharSequence paramCharSequence)
  {
    int k = 0;
    int n = paramCharSequence.length();
    for (int j = 0; (j < n) && (paramCharSequence.charAt(j) < ''); j++) {}
    for (;;)
    {
      int i;
      if (j < n)
      {
        int m = paramCharSequence.charAt(j);
        if (m < 2048)
        {
          i += (127 - m >>> 31);
          j++;
        }
        else
        {
          int i2 = paramCharSequence.length();
          if (j < i2)
          {
            int i3 = paramCharSequence.charAt(j);
            if (i3 < 2048)
            {
              k += (127 - i3 >>> 31);
              m = j;
            }
            for (;;)
            {
              j = m + 1;
              break;
              int i1 = k + 2;
              k = i1;
              m = j;
              if (55296 <= i3)
              {
                k = i1;
                m = j;
                if (i3 <= 57343)
                {
                  if (Character.codePointAt(paramCharSequence, j) < 65536) {
                    throw new c(j, i2);
                  }
                  m = j + 1;
                  k = i1;
                }
              }
            }
          }
          i = k + i;
        }
      }
      else
      {
        for (;;)
        {
          if (i < n) {
            throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i + 4294967296L));
          }
          return i;
        }
        i = n;
      }
    }
  }
  
  static int a(CharSequence paramCharSequence, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return a.a(paramCharSequence, paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (a.a(paramArrayOfByte, paramInt1, paramInt2) == 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static int b(int paramInt)
  {
    int i = paramInt;
    if (paramInt > -12) {
      i = -1;
    }
    return i;
  }
  
  private static int b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > -12) || (paramInt2 > -65)) {}
    for (paramInt1 = -1;; paramInt1 = paramInt2 << 8 ^ paramInt1) {
      return paramInt1;
    }
  }
  
  private static int b(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 > -12) || (paramInt2 > -65) || (paramInt3 > -65)) {}
    for (paramInt1 = -1;; paramInt1 = paramInt2 << 8 ^ paramInt1 ^ paramInt3 << 16) {
      return paramInt1;
    }
  }
  
  static abstract class a
  {
    abstract int a(CharSequence paramCharSequence, byte[] paramArrayOfByte, int paramInt1, int paramInt2);
    
    abstract int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  }
  
  static final class b
    extends aj.a
  {
    final int a(CharSequence paramCharSequence, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      int k = paramCharSequence.length();
      int j = 0;
      int m = paramInt1 + paramInt2;
      for (paramInt2 = j; (paramInt2 < k) && (paramInt2 + paramInt1 < m); paramInt2++)
      {
        j = paramCharSequence.charAt(paramInt2);
        if (j >= 128) {
          break;
        }
        paramArrayOfByte[(paramInt1 + paramInt2)] = ((byte)j);
      }
      if (paramInt2 == k) {
        paramInt1 += k;
      }
      for (;;)
      {
        return paramInt1;
        paramInt1 += paramInt2;
        if (paramInt2 < k)
        {
          int i = paramCharSequence.charAt(paramInt2);
          if ((i < 128) && (paramInt1 < m))
          {
            j = paramInt1 + 1;
            paramArrayOfByte[paramInt1] = ((byte)i);
            paramInt1 = j;
          }
          for (;;)
          {
            paramInt2++;
            break;
            if ((i < 2048) && (paramInt1 <= m - 2))
            {
              j = paramInt1 + 1;
              paramArrayOfByte[paramInt1] = ((byte)(i >>> 6 | 0x3C0));
              paramInt1 = j + 1;
              paramArrayOfByte[j] = ((byte)(i & 0x3F | 0x80));
            }
            else
            {
              int n;
              if (((i < 55296) || (57343 < i)) && (paramInt1 <= m - 3))
              {
                j = paramInt1 + 1;
                paramArrayOfByte[paramInt1] = ((byte)(i >>> 12 | 0x1E0));
                n = j + 1;
                paramArrayOfByte[j] = ((byte)(i >>> 6 & 0x3F | 0x80));
                paramInt1 = n + 1;
                paramArrayOfByte[n] = ((byte)(i & 0x3F | 0x80));
              }
              else
              {
                if (paramInt1 > m - 4) {
                  break label439;
                }
                j = paramInt2;
                char c;
                if (paramInt2 + 1 != paramCharSequence.length())
                {
                  paramInt2++;
                  c = paramCharSequence.charAt(paramInt2);
                  if (!Character.isSurrogatePair(i, c)) {
                    j = paramInt2;
                  }
                }
                else
                {
                  throw new aj.c(j - 1, k);
                }
                j = Character.toCodePoint(i, c);
                n = paramInt1 + 1;
                paramArrayOfByte[paramInt1] = ((byte)(j >>> 18 | 0xF0));
                paramInt1 = n + 1;
                paramArrayOfByte[n] = ((byte)(j >>> 12 & 0x3F | 0x80));
                n = paramInt1 + 1;
                paramArrayOfByte[paramInt1] = ((byte)(j >>> 6 & 0x3F | 0x80));
                paramInt1 = n + 1;
                paramArrayOfByte[n] = ((byte)(j & 0x3F | 0x80));
              }
            }
          }
          label439:
          if ((55296 <= i) && (i <= 57343) && ((paramInt2 + 1 == paramCharSequence.length()) || (!Character.isSurrogatePair(i, paramCharSequence.charAt(paramInt2 + 1))))) {
            throw new aj.c(paramInt2, k);
          }
          throw new ArrayIndexOutOfBoundsException("Failed writing " + i + " at index " + paramInt1);
        }
      }
    }
    
    final int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      for (int i = paramInt1; (i < paramInt2) && (paramArrayOfByte[i] >= 0); i++) {}
      paramInt1 = i;
      if (i >= paramInt2) {
        paramInt1 = 0;
      }
      for (;;)
      {
        return paramInt1;
        label35:
        paramInt1 = i;
        label100:
        label105:
        label188:
        label193:
        do
        {
          int j;
          int k;
          do
          {
            do
            {
              if (paramInt1 >= paramInt2)
              {
                paramInt1 = 0;
                break;
              }
              i = paramInt1 + 1;
              j = paramArrayOfByte[paramInt1];
              if (j >= 0) {
                break label35;
              }
              if (j >= -32) {
                break label105;
              }
              paramInt1 = j;
              if (i >= paramInt2) {
                break;
              }
              if (j < -62) {
                break label100;
              }
              paramInt1 = i + 1;
            } while (paramArrayOfByte[i] <= -65);
            paramInt1 = -1;
            break;
            if (j >= -16) {
              break label193;
            }
            if (i >= paramInt2 - 1)
            {
              paramInt1 = aj.b(paramArrayOfByte, i, paramInt2);
              break;
            }
            k = i + 1;
            paramInt1 = paramArrayOfByte[i];
            if ((paramInt1 > -65) || ((j == -32) && (paramInt1 < -96)) || ((j == -19) && (paramInt1 >= -96))) {
              break label188;
            }
            paramInt1 = k + 1;
          } while (paramArrayOfByte[k] <= -65);
          paramInt1 = -1;
          break;
          if (i >= paramInt2 - 2)
          {
            paramInt1 = aj.b(paramArrayOfByte, i, paramInt2);
            break;
          }
          paramInt1 = i + 1;
          i = paramArrayOfByte[i];
          if ((i > -65) || ((j << 28) + (i + 112) >> 30 != 0)) {
            break label274;
          }
          i = paramInt1 + 1;
          if (paramArrayOfByte[paramInt1] > -65) {
            break label274;
          }
          paramInt1 = i + 1;
        } while (paramArrayOfByte[i] <= -65);
        label274:
        paramInt1 = -1;
      }
    }
  }
  
  static final class c
    extends IllegalArgumentException
  {
    c(int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  static final class d
    extends aj.a
  {
    private static int a(byte[] paramArrayOfByte, int paramInt1, long paramLong, int paramInt2)
    {
      switch (paramInt2)
      {
      default: 
        throw new AssertionError();
      case 0: 
        paramInt1 = aj.a(paramInt1);
      }
      for (;;)
      {
        return paramInt1;
        paramInt1 = aj.a(paramInt1, ah.a(paramArrayOfByte, paramLong));
        continue;
        paramInt1 = aj.a(paramInt1, ah.a(paramArrayOfByte, paramLong), ah.a(paramArrayOfByte, 1L + paramLong));
      }
    }
    
    private static int a(byte[] paramArrayOfByte, long paramLong, int paramInt)
    {
      int i;
      if (paramInt < 16) {
        i = 0;
      }
      long l1;
      int j;
      for (;;)
      {
        l1 = i;
        paramInt -= i;
        paramLong = l1 + paramLong;
        i = 0;
        j = paramInt;
        for (;;)
        {
          if (j <= 0) {
            break label421;
          }
          l1 = paramLong + 1L;
          paramInt = ah.a(paramArrayOfByte, paramLong);
          if (paramInt < 0) {
            break;
          }
          j--;
          paramLong = l1;
          i = paramInt;
        }
        j = (int)paramLong & 0x7;
        i = j;
        for (l1 = paramLong;; l1 = 1L + l1)
        {
          if (i <= 0) {
            break label112;
          }
          if (ah.a(paramArrayOfByte, l1) < 0)
          {
            i = j - i;
            break;
          }
          i--;
        }
        label112:
        for (i = paramInt - j; (i >= 8) && ((ah.b(paramArrayOfByte, l1) & 0x8080808080808080) == 0L); i -= 8) {
          l1 += 8L;
        }
        i = paramInt - i;
      }
      for (;;)
      {
        if (j == 0) {
          paramInt = 0;
        }
        for (;;)
        {
          return paramInt;
          i = j - 1;
          if (paramInt < -32)
          {
            if (i == 0) {
              continue;
            }
            i--;
            if (paramInt >= -62)
            {
              paramLong = 1L + l1;
              paramInt = i;
              if (ah.a(paramArrayOfByte, l1) <= -65) {
                break;
              }
            }
            paramInt = -1;
            continue;
          }
          if (paramInt < -16)
          {
            if (i < 2)
            {
              paramInt = a(paramArrayOfByte, paramInt, l1, i);
              continue;
            }
            i -= 2;
            long l2 = 1L + l1;
            j = ah.a(paramArrayOfByte, l1);
            if ((j <= -65) && ((paramInt != -32) || (j >= -96)) && ((paramInt != -19) || (j < -96)))
            {
              paramLong = 1L + l2;
              paramInt = i;
              if (ah.a(paramArrayOfByte, l2) <= -65) {
                break;
              }
            }
            paramInt = -1;
            continue;
          }
          if (i < 3)
          {
            paramInt = a(paramArrayOfByte, paramInt, l1, i);
          }
          else
          {
            i -= 3;
            paramLong = 1L + l1;
            j = ah.a(paramArrayOfByte, l1);
            if ((j <= -65) && ((paramInt << 28) + (j + 112) >> 30 == 0))
            {
              l1 = paramLong + 1L;
              if (ah.a(paramArrayOfByte, paramLong) <= -65)
              {
                paramLong = 1L + l1;
                paramInt = i;
                if (ah.a(paramArrayOfByte, l1) <= -65) {
                  break;
                }
              }
            }
            paramInt = -1;
          }
        }
        label421:
        paramInt = i;
        l1 = paramLong;
      }
    }
    
    final int a(CharSequence paramCharSequence, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      long l1 = ah.c() + paramInt1;
      long l2 = l1 + paramInt2;
      int j = paramCharSequence.length();
      if ((j > paramInt2) || (paramArrayOfByte.length - paramInt2 < paramInt1)) {
        throw new ArrayIndexOutOfBoundsException("Failed writing " + paramCharSequence.charAt(j - 1) + " at index " + (paramInt1 + paramInt2));
      }
      paramInt1 = 0;
      while (paramInt1 < j)
      {
        paramInt2 = paramCharSequence.charAt(paramInt1);
        if (paramInt2 >= 128) {
          break;
        }
        ah.a(paramArrayOfByte, l1, (byte)paramInt2);
        paramInt1++;
        l1 = 1L + l1;
      }
      if (paramInt1 == j)
      {
        paramInt1 = (int)(l1 - ah.c());
        return paramInt1;
      }
      for (;;)
      {
        if (paramInt1 < j)
        {
          int i = paramCharSequence.charAt(paramInt1);
          if ((i < 128) && (l1 < l2))
          {
            ah.a(paramArrayOfByte, l1, (byte)i);
            l1 = 1L + l1;
          }
          for (;;)
          {
            paramInt1++;
            break;
            long l3;
            if ((i < 2048) && (l1 <= l2 - 2L))
            {
              l3 = l1 + 1L;
              ah.a(paramArrayOfByte, l1, (byte)(i >>> 6 | 0x3C0));
              ah.a(paramArrayOfByte, l3, (byte)(i & 0x3F | 0x80));
              l1 = 1L + l3;
            }
            else if (((i < 55296) || (57343 < i)) && (l1 <= l2 - 3L))
            {
              l3 = 1L + l1;
              ah.a(paramArrayOfByte, l1, (byte)(i >>> 12 | 0x1E0));
              l1 = 1L + l3;
              ah.a(paramArrayOfByte, l3, (byte)(i >>> 6 & 0x3F | 0x80));
              ah.a(paramArrayOfByte, l1, (byte)(i & 0x3F | 0x80));
              l1 = 1L + l1;
            }
            else
            {
              if (l1 > l2 - 4L) {
                break label532;
              }
              paramInt2 = paramInt1;
              char c;
              if (paramInt1 + 1 != j)
              {
                paramInt1++;
                c = paramCharSequence.charAt(paramInt1);
                if (!Character.isSurrogatePair(i, c)) {
                  paramInt2 = paramInt1;
                }
              }
              else
              {
                throw new aj.c(paramInt2 - 1, j);
              }
              paramInt2 = Character.toCodePoint(i, c);
              l3 = 1L + l1;
              ah.a(paramArrayOfByte, l1, (byte)(paramInt2 >>> 18 | 0xF0));
              l1 = 1L + l3;
              ah.a(paramArrayOfByte, l3, (byte)(paramInt2 >>> 12 & 0x3F | 0x80));
              l3 = l1 + 1L;
              ah.a(paramArrayOfByte, l1, (byte)(paramInt2 >>> 6 & 0x3F | 0x80));
              ah.a(paramArrayOfByte, l3, (byte)(paramInt2 & 0x3F | 0x80));
              l1 = 1L + l3;
            }
          }
          label532:
          if ((55296 <= i) && (i <= 57343) && ((paramInt1 + 1 == j) || (!Character.isSurrogatePair(i, paramCharSequence.charAt(paramInt1 + 1))))) {
            throw new aj.c(paramInt1, j);
          }
          throw new ArrayIndexOutOfBoundsException("Failed writing " + i + " at index " + l1);
        }
        paramInt1 = (int)(l1 - ah.c());
        break;
      }
    }
    
    final int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      if ((paramInt1 | paramInt2 | paramArrayOfByte.length - paramInt2) < 0) {
        throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      }
      long l = ah.c() + paramInt1;
      return a(paramArrayOfByte, l, (int)(ah.c() + paramInt2 - l));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/b/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */