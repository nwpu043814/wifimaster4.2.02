package com.wifipay.common.net.entitybase;

public class Base64
{
  private static final int BASELENGTH = 128;
  private static final int FOURBYTE = 4;
  private static final int LOOKUPLENGTH = 64;
  private static final char PAD = '=';
  private static final byte[] base64Alphabet;
  private static final char[] lookUpBase64Alphabet;
  
  static
  {
    int k = 0;
    base64Alphabet = new byte[''];
    lookUpBase64Alphabet = new char[64];
    for (int i = 0; i < 128; i++) {
      base64Alphabet[i] = -1;
    }
    for (i = 90; i >= 65; i--) {
      base64Alphabet[i] = ((byte)(i - 65));
    }
    for (i = 122; i >= 97; i--) {
      base64Alphabet[i] = ((byte)(i - 97 + 26));
    }
    for (i = 57; i >= 48; i--) {
      base64Alphabet[i] = ((byte)(i - 48 + 52));
    }
    base64Alphabet[43] = 62;
    base64Alphabet[47] = 63;
    for (i = 0; i <= 25; i++) {
      lookUpBase64Alphabet[i] = ((char)(i + 65));
    }
    i = 26;
    for (int j = 0; i <= 51; j++)
    {
      lookUpBase64Alphabet[i] = ((char)(j + 97));
      i++;
    }
    j = 52;
    for (i = k; j <= 61; i++)
    {
      lookUpBase64Alphabet[j] = ((char)(i + 48));
      j++;
    }
    lookUpBase64Alphabet[62] = '+';
    lookUpBase64Alphabet[63] = '/';
  }
  
  public static byte[] decode(String paramString)
  {
    Object localObject = null;
    if (paramString == null) {
      paramString = (String)localObject;
    }
    for (;;)
    {
      return paramString;
      char[] arrayOfChar = paramString.toCharArray();
      int i = removeWhiteSpace(arrayOfChar);
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
            char c3 = arrayOfChar[k];
            paramString = (String)localObject;
            if (!isData(c3)) {
              break;
            }
            k = n + 1;
            char c4 = arrayOfChar[n];
            paramString = (String)localObject;
            if (!isData(c4)) {
              break;
            }
            n = k + 1;
            c1 = arrayOfChar[k];
            paramString = (String)localObject;
            if (!isData(c1)) {
              break;
            }
            k = n + 1;
            c2 = arrayOfChar[n];
            paramString = (String)localObject;
            if (!isData(c2)) {
              break;
            }
            int i4 = base64Alphabet[c3];
            int i3 = base64Alphabet[c4];
            i1 = base64Alphabet[c1];
            n = base64Alphabet[c2];
            int i2 = i + 1;
            arrayOfByte[i] = ((byte)(i4 << 2 | i3 >> 4));
            i4 = i2 + 1;
            arrayOfByte[i2] = ((byte)((i3 & 0xF) << 4 | i1 >> 2 & 0xF));
            i = i4 + 1;
            arrayOfByte[i4] = ((byte)(i1 << 6 | n));
          }
          label272:
          m = k + 1;
          char c2 = arrayOfChar[k];
          paramString = (String)localObject;
          if (isData(c2))
          {
            n = m + 1;
            c1 = arrayOfChar[m];
            paramString = (String)localObject;
            if (isData(c1))
            {
              m = base64Alphabet[c2];
              k = base64Alphabet[c1];
              c1 = arrayOfChar[n];
              c2 = arrayOfChar[(n + 1)];
              if ((!isData(c1)) || (!isData(c2)))
              {
                if ((isPad(c1)) && (isPad(c2)))
                {
                  paramString = (String)localObject;
                  if ((k & 0xF) == 0)
                  {
                    paramString = new byte[j * 3 + 1];
                    System.arraycopy(arrayOfByte, 0, paramString, 0, j * 3);
                    paramString[i] = ((byte)(m << 2 | k >> 4));
                  }
                }
                else
                {
                  paramString = (String)localObject;
                  if (!isPad(c1))
                  {
                    paramString = (String)localObject;
                    if (isPad(c2))
                    {
                      n = base64Alphabet[c1];
                      paramString = (String)localObject;
                      if ((n & 0x3) == 0)
                      {
                        paramString = new byte[j * 3 + 2];
                        System.arraycopy(arrayOfByte, 0, paramString, 0, j * 3);
                        paramString[i] = ((byte)(m << 2 | k >> 4));
                        paramString[(i + 1)] = ((byte)((k & 0xF) << 4 | n >> 2 & 0xF));
                      }
                    }
                  }
                }
              }
              else
              {
                i1 = base64Alphabet[c1];
                j = base64Alphabet[c2];
                n = i + 1;
                arrayOfByte[i] = ((byte)(m << 2 | k >> 4));
                arrayOfByte[n] = ((byte)((k & 0xF) << 4 | i1 >> 2 & 0xF));
                arrayOfByte[(n + 1)] = ((byte)(i1 << 6 | j));
                paramString = arrayOfByte;
              }
            }
          }
        }
      }
    }
  }
  
  private static boolean isData(char paramChar)
  {
    if ((paramChar < '') && (base64Alphabet[paramChar] != -1)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static boolean isPad(char paramChar)
  {
    if (paramChar == '=') {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static boolean isWhiteSpace(char paramChar)
  {
    if ((paramChar == ' ') || (paramChar == '\r') || (paramChar == '\n') || (paramChar == '\t')) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static int removeWhiteSpace(char[] paramArrayOfChar)
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
    if (!isWhiteSpace(paramArrayOfChar[j]))
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
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/common/net/entitybase/Base64.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */