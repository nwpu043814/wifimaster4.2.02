package com.tencent.wxop.stat.b;

import android.util.Base64;

public final class g
{
  private static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int m = 0;
    int[] arrayOfInt1 = new int['Ā'];
    int[] arrayOfInt2 = new int['Ā'];
    int j = paramArrayOfByte2.length;
    if ((j <= 0) || (j > 256)) {
      throw new IllegalArgumentException("key must be between 1 and 256 bytes");
    }
    for (int i = 0; i < 256; i++)
    {
      arrayOfInt1[i] = i;
      arrayOfInt2[i] = paramArrayOfByte2[(i % j)];
    }
    j = 0;
    for (i = 0; i < 256; i++)
    {
      j = j + arrayOfInt1[i] + arrayOfInt2[i] & 0xFF;
      k = arrayOfInt1[i];
      arrayOfInt1[i] = arrayOfInt1[j];
      arrayOfInt1[j] = k;
    }
    paramArrayOfByte2 = new byte[paramArrayOfByte1.length];
    int k = 0;
    i = 0;
    for (j = m; j < paramArrayOfByte1.length; j++)
    {
      k = k + 1 & 0xFF;
      i = i + arrayOfInt1[k] & 0xFF;
      m = arrayOfInt1[k];
      arrayOfInt1[k] = arrayOfInt1[i];
      arrayOfInt1[i] = m;
      paramArrayOfByte2[j] = ((byte)(arrayOfInt1[(arrayOfInt1[k] + arrayOfInt1[i] & 0xFF)] ^ paramArrayOfByte1[j]));
    }
    return paramArrayOfByte2;
  }
  
  public static byte[] b(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, Base64.decode("MDNhOTc2NTExZTJjYmUzYTdmMjY4MDhmYjdhZjNjMDU=", 0));
  }
  
  public static byte[] c(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, Base64.decode("MDNhOTc2NTExZTJjYmUzYTdmMjY4MDhmYjdhZjNjMDU=", 0));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/wxop/stat/b/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */