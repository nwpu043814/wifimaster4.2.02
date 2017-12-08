package com.lantern.wifilocating.push.d;

public final class a
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  private static int a(char paramChar)
  {
    if ((paramChar >= '0') && (paramChar <= '9')) {
      paramChar -= 48;
    }
    for (;;)
    {
      return paramChar;
      if ((paramChar >= 'A') && (paramChar <= 'F')) {
        paramChar = paramChar - 'A' + 10;
      } else if ((paramChar >= 'a') && (paramChar <= 'f')) {
        paramChar = paramChar - 'a' + 10;
      } else {
        paramChar = '\000';
      }
    }
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    int j = 0;
    if (paramArrayOfByte == null) {}
    char[] arrayOfChar;
    for (paramArrayOfByte = "";; paramArrayOfByte = new String(arrayOfChar))
    {
      return paramArrayOfByte;
      int k = paramArrayOfByte.length;
      arrayOfChar = new char[k * 2];
      int i = 0;
      while (j < k + 0)
      {
        int n = paramArrayOfByte[j];
        int m = i + 1;
        arrayOfChar[i] = a[(n >>> 4 & 0xF)];
        i = m + 1;
        arrayOfChar[m] = a[(n & 0xF)];
        j++;
      }
    }
  }
  
  public static byte[] a(String paramString)
  {
    int i = paramString.length();
    byte[] arrayOfByte = new byte[i / 2];
    int j = i / 2;
    for (i = 0; i < j * 2; i += 2) {
      arrayOfByte[(i / 2)] = ((byte)(a(paramString.charAt(i)) << 4 | a(paramString.charAt(i + 1))));
    }
    return arrayOfByte;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */