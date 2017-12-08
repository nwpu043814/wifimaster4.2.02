package com.alipay.c.a.a.a.a;

public final class a
{
  private static char[] a = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  private static byte[] b = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1 };
  
  public static byte[] a(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    paramString = paramString.getBytes("US-ASCII");
    int k = paramString.length;
    int i = 0;
    if (i < k) {}
    for (int j = i;; j = i)
    {
      byte[] arrayOfByte = b;
      i = j + 1;
      int n = arrayOfByte[paramString[j]];
      if ((i >= k) || (n != -1))
      {
        if (n != -1) {}
        for (j = i;; j = i)
        {
          arrayOfByte = b;
          i = j + 1;
          int m = arrayOfByte[paramString[j]];
          if ((i >= k) || (m != -1))
          {
            if (m != -1) {
              localStringBuffer.append((char)(n << 2 | (m & 0x30) >>> 4));
            }
            for (j = i;; j = i)
            {
              i = j + 1;
              j = paramString[j];
              if (j == 61)
              {
                paramString = localStringBuffer.toString().getBytes("iso8859-1");
                label144:
                return paramString;
              }
              n = b[j];
              if ((i >= k) || (n != -1))
              {
                if (n != -1) {
                  localStringBuffer.append((char)((m & 0xF) << 4 | (n & 0x3C) >>> 2));
                }
                for (j = i;; j = i)
                {
                  i = j + 1;
                  j = paramString[j];
                  if (j == 61)
                  {
                    paramString = localStringBuffer.toString().getBytes("iso8859-1");
                    break label144;
                  }
                  j = b[j];
                  if ((i >= k) || (j != -1))
                  {
                    if (j != -1)
                    {
                      localStringBuffer.append((char)(j | (n & 0x3) << 6));
                      break;
                    }
                    paramString = localStringBuffer.toString().getBytes("iso8859-1");
                    break label144;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/c/a/a/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */