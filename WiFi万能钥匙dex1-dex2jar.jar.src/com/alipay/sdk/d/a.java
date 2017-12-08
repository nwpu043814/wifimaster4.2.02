package com.alipay.sdk.d;

public final class a
{
  private static final byte[] a;
  private static final char[] b;
  
  static
  {
    int k = 0;
    a = new byte[''];
    b = new char[64];
    for (int i = 0; i < 128; i++) {
      a[i] = -1;
    }
    for (i = 90; i >= 65; i--) {
      a[i] = ((byte)(i - 65));
    }
    for (i = 122; i >= 97; i--) {
      a[i] = ((byte)(i - 97 + 26));
    }
    for (i = 57; i >= 48; i--) {
      a[i] = ((byte)(i - 48 + 52));
    }
    a[43] = 62;
    a[47] = 63;
    for (i = 0; i <= 25; i++) {
      b[i] = ((char)(i + 65));
    }
    i = 26;
    for (int j = 0; i <= 51; j++)
    {
      b[i] = ((char)(j + 97));
      i++;
    }
    i = 52;
    for (j = k; i <= 61; j++)
    {
      b[i] = ((char)(j + 48));
      i++;
    }
    b[62] = '+';
    b[63] = '/';
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    int k = 0;
    if (paramArrayOfByte == null) {}
    int i;
    for (paramArrayOfByte = null;; paramArrayOfByte = "")
    {
      return paramArrayOfByte;
      i = paramArrayOfByte.length * 8;
      if (i != 0) {
        break;
      }
    }
    int i2 = i % 24;
    int i1 = i / 24;
    char[] arrayOfChar;
    label59:
    int i3;
    int i5;
    int i4;
    int i6;
    if (i2 != 0)
    {
      i = i1 + 1;
      arrayOfChar = new char[i * 4];
      j = 0;
      i = 0;
      if (j >= i1) {
        break label278;
      }
      m = k + 1;
      k = paramArrayOfByte[k];
      i3 = m + 1;
      m = paramArrayOfByte[m];
      i5 = paramArrayOfByte[i3];
      i4 = (byte)(m & 0xF);
      i6 = (byte)(k & 0x3);
      if ((k & 0xFFFFFF80) != 0) {
        break label237;
      }
      k = (byte)(k >> 2);
      label118:
      if ((m & 0xFFFFFF80) != 0) {
        break label249;
      }
      m = (byte)(m >> 4);
      label133:
      if ((i5 & 0xFFFFFF80) != 0) {
        break label263;
      }
    }
    label237:
    label249:
    label263:
    for (int n = (byte)(i5 >> 6);; n = (byte)(i5 >> 6 ^ 0xFC))
    {
      int i7 = i + 1;
      arrayOfChar[i] = b[k];
      i = i7 + 1;
      arrayOfChar[i7] = b[(m | i6 << 4)];
      k = i + 1;
      arrayOfChar[i] = b[(n | i4 << 2)];
      arrayOfChar[k] = b[(i5 & 0x3F)];
      j++;
      i = k + 1;
      k = i3 + 1;
      break label59;
      i = i1;
      break;
      k = (byte)(k >> 2 ^ 0xC0);
      break label118;
      m = (byte)(m >> 4 ^ 0xF0);
      break label133;
    }
    label278:
    if (i2 == 8)
    {
      j = paramArrayOfByte[k];
      k = (byte)(j & 0x3);
      if ((j & 0xFFFFFF80) == 0)
      {
        j = (byte)(j >> 2);
        m = i + 1;
        arrayOfChar[i] = b[j];
        i = m + 1;
        arrayOfChar[m] = b[(k << 4)];
        arrayOfChar[i] = '=';
        arrayOfChar[(i + 1)] = '=';
      }
    }
    while (i2 != 16) {
      for (;;)
      {
        paramArrayOfByte = new String(arrayOfChar);
        break;
        j = (byte)(j >> 2 ^ 0xC0);
      }
    }
    int j = paramArrayOfByte[k];
    k = paramArrayOfByte[(k + 1)];
    int m = (byte)(k & 0xF);
    n = (byte)(j & 0x3);
    if ((j & 0xFFFFFF80) == 0)
    {
      j = (byte)(j >> 2);
      label418:
      if ((k & 0xFFFFFF80) != 0) {
        break label499;
      }
    }
    label499:
    for (k = (byte)(k >> 4);; k = (byte)(k >> 4 ^ 0xF0))
    {
      i1 = i + 1;
      arrayOfChar[i] = b[j];
      i = i1 + 1;
      arrayOfChar[i1] = b[(k | n << 4)];
      arrayOfChar[i] = b[(m << 2)];
      arrayOfChar[(i + 1)] = '=';
      break;
      j = (byte)(j >> 2 ^ 0xC0);
      break label418;
    }
  }
  
  private static boolean a(char paramChar)
  {
    if (paramChar == '=') {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static byte[] a(String paramString)
  {
    if (paramString == null)
    {
      paramString = null;
      return paramString;
    }
    Object localObject = paramString.toCharArray();
    int k;
    if (localObject == null) {
      k = 0;
    }
    int m;
    int j;
    int i;
    for (;;)
    {
      if (k % 4 != 0)
      {
        paramString = null;
        break;
        m = localObject.length;
        j = 0;
        i = 0;
        label45:
        k = i;
        if (j < m)
        {
          k = localObject[j];
          if ((k == 32) || (k == 13) || (k == 10) || (k == 9))
          {
            k = 1;
            label94:
            if (k != 0) {
              break label688;
            }
            k = i + 1;
            localObject[i] = localObject[j];
            i = k;
          }
        }
      }
    }
    label257:
    label357:
    label688:
    for (;;)
    {
      j++;
      break label45;
      k = 0;
      break label94;
      m = k / 4;
      if (m == 0)
      {
        paramString = new byte[0];
        break;
      }
      paramString = new byte[m * 3];
      k = 0;
      i = 0;
      for (j = 0;; j++)
      {
        if (j >= m - 1) {
          break label357;
        }
        n = k + 1;
        c1 = localObject[k];
        char c4;
        char c3;
        if (b(c1))
        {
          k = n + 1;
          c2 = localObject[n];
          if (b(c2))
          {
            n = k + 1;
            c4 = localObject[k];
            if (b(c4))
            {
              k = n + 1;
              c3 = localObject[n];
              if (b(c3)) {
                break label257;
              }
            }
          }
        }
        paramString = null;
        break;
        int i4 = a[c1];
        int i2 = a[c2];
        n = a[c4];
        i1 = a[c3];
        int i3 = i + 1;
        paramString[i] = ((byte)(i4 << 2 | i2 >> 4));
        i4 = i3 + 1;
        paramString[i3] = ((byte)((i2 & 0xF) << 4 | n >> 2 & 0xF));
        i = i4 + 1;
        paramString[i4] = ((byte)(n << 6 | i1));
      }
      m = k + 1;
      char c2 = localObject[k];
      if (b(c2))
      {
        n = m + 1;
        c1 = localObject[m];
        if (b(c1)) {}
      }
      else
      {
        paramString = null;
        break;
      }
      m = a[c2];
      k = a[c1];
      c2 = localObject[n];
      char c1 = localObject[(n + 1)];
      if ((!b(c2)) || (!b(c1)))
      {
        if ((a(c2)) && (a(c1)))
        {
          if ((k & 0xF) != 0)
          {
            paramString = null;
            break;
          }
          localObject = new byte[j * 3 + 1];
          System.arraycopy(paramString, 0, localObject, 0, j * 3);
          localObject[i] = ((byte)(m << 2 | k >> 4));
          paramString = (String)localObject;
          break;
        }
        if ((!a(c2)) && (a(c1)))
        {
          n = a[c2];
          if ((n & 0x3) != 0)
          {
            paramString = null;
            break;
          }
          localObject = new byte[j * 3 + 2];
          System.arraycopy(paramString, 0, localObject, 0, j * 3);
          localObject[i] = ((byte)(m << 2 | k >> 4));
          localObject[(i + 1)] = ((byte)((k & 0xF) << 4 | n >> 2 & 0xF));
          paramString = (String)localObject;
          break;
        }
        paramString = null;
        break;
      }
      j = a[c2];
      int i1 = a[c1];
      int n = i + 1;
      paramString[i] = ((byte)(m << 2 | k >> 4));
      paramString[n] = ((byte)((k & 0xF) << 4 | j >> 2 & 0xF));
      paramString[(n + 1)] = ((byte)(i1 | j << 6));
      break;
    }
  }
  
  private static boolean b(char paramChar)
  {
    if ((paramChar < '') && (a[paramChar] != -1)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/sdk/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */