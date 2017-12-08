package com.wifipay.sdk.util;

public final class b
{
  private static char a;
  private static byte[] b;
  private static char[] c;
  
  static
  {
    int k = 0;
    a = '=';
    b = new byte[''];
    c = new char[64];
    for (int i = 0; i < 128; i++) {
      b[i] = -1;
    }
    for (i = 90; i >= 65; i--) {
      b[i] = ((byte)(i - 65));
    }
    for (i = 122; i >= 97; i--) {
      b[i] = ((byte)(i - 97 + 26));
    }
    for (i = 57; i >= 48; i--) {
      b[i] = ((byte)(i - 48 + 52));
    }
    b[43] = 62;
    b[47] = 63;
    for (i = 0; i <= 25; i++) {
      c[i] = ((char)(i + 65));
    }
    i = 26;
    for (int j = 0; i <= 51; j++)
    {
      c[i] = ((char)(j + 97));
      i++;
    }
    j = 52;
    for (i = k; j <= 61; i++)
    {
      c[j] = ((char)(i + 48));
      j++;
    }
    c[62] = '+';
    c[63] = '/';
  }
  
  private static int a(char[] paramArrayOfChar)
  {
    int i = 0;
    int k = 0;
    if (paramArrayOfChar == null) {}
    int m;
    int j;
    do
    {
      return k;
      m = paramArrayOfChar.length;
      j = 0;
      k = i;
    } while (j >= m);
    if (!a(paramArrayOfChar[j]))
    {
      k = i + 1;
      paramArrayOfChar[i] = paramArrayOfChar[j];
      i = k;
    }
    for (;;)
    {
      j++;
      break;
    }
  }
  
  private static boolean a(char paramChar)
  {
    if ((paramChar == ' ') || (paramChar == '\r') || (paramChar == '\n') || (paramChar == '\t')) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static byte[] a(String paramString)
  {
    Object localObject = null;
    if (paramString == null) {
      paramString = (String)localObject;
    }
    for (;;)
    {
      return paramString;
      char[] arrayOfChar = paramString.toCharArray();
      int i = a(arrayOfChar);
      paramString = (String)localObject;
      if (i % 4 == 0)
      {
        int m = i / 4;
        if (m == 0)
        {
          paramString = new byte[0];
        }
        else
        {
          byte[] arrayOfByte = new byte[m * 3];
          int k = 0;
          i = 0;
          int n;
          char c1;
          int i1;
          for (int j = 0;; j++)
          {
            if (j >= m - 1) {
              break label272;
            }
            n = k + 1;
            char c4 = arrayOfChar[k];
            paramString = (String)localObject;
            if (!c(c4)) {
              break;
            }
            k = n + 1;
            char c3 = arrayOfChar[n];
            paramString = (String)localObject;
            if (!c(c3)) {
              break;
            }
            n = k + 1;
            c1 = arrayOfChar[k];
            paramString = (String)localObject;
            if (!c(c1)) {
              break;
            }
            k = n + 1;
            c2 = arrayOfChar[n];
            paramString = (String)localObject;
            if (!c(c2)) {
              break;
            }
            int i4 = b[c4];
            int i2 = b[c3];
            i1 = b[c1];
            n = b[c2];
            int i3 = i + 1;
            arrayOfByte[i] = ((byte)(i4 << 2 | i2 >> 4));
            i4 = i3 + 1;
            arrayOfByte[i3] = ((byte)((i2 & 0xF) << 4 | i1 >> 2 & 0xF));
            i = i4 + 1;
            arrayOfByte[i4] = ((byte)(i1 << 6 | n));
          }
          label272:
          m = k + 1;
          char c2 = arrayOfChar[k];
          paramString = (String)localObject;
          if (c(c2))
          {
            n = m + 1;
            c1 = arrayOfChar[m];
            paramString = (String)localObject;
            if (c(c1))
            {
              k = b[c2];
              m = b[c1];
              c2 = arrayOfChar[n];
              c1 = arrayOfChar[(n + 1)];
              if ((!c(c2)) || (!c(c1)))
              {
                if ((b(c2)) && (b(c1)))
                {
                  paramString = (String)localObject;
                  if ((m & 0xF) == 0)
                  {
                    paramString = new byte[j * 3 + 1];
                    System.arraycopy(arrayOfByte, 0, paramString, 0, j * 3);
                    paramString[i] = ((byte)(k << 2 | m >> 4));
                  }
                }
                else
                {
                  paramString = (String)localObject;
                  if (!b(c2))
                  {
                    paramString = (String)localObject;
                    if (b(c1))
                    {
                      n = b[c2];
                      paramString = (String)localObject;
                      if ((n & 0x3) == 0)
                      {
                        paramString = new byte[j * 3 + 2];
                        System.arraycopy(arrayOfByte, 0, paramString, 0, j * 3);
                        paramString[i] = ((byte)(k << 2 | m >> 4));
                        paramString[(i + 1)] = ((byte)((m & 0xF) << 4 | n >> 2 & 0xF));
                      }
                    }
                  }
                }
              }
              else
              {
                j = b[c2];
                i1 = b[c1];
                n = i + 1;
                arrayOfByte[i] = ((byte)(k << 2 | m >> 4));
                arrayOfByte[n] = ((byte)((m & 0xF) << 4 | j >> 2 & 0xF));
                arrayOfByte[(n + 1)] = ((byte)(j << 6 | i1));
                paramString = arrayOfByte;
              }
            }
          }
        }
      }
    }
  }
  
  private static boolean b(char paramChar)
  {
    if (paramChar == a) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static boolean c(char paramChar)
  {
    if ((paramChar < '') && (b[paramChar] != -1)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/sdk/util/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */