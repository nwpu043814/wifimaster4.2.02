package com.lantern.core.b;

public final class b
{
  protected static boolean a(byte[] paramArrayOfByte)
  {
    if (c(paramArrayOfByte)) {
      paramArrayOfByte = new String[] { new String(a(paramArrayOfByte, 0, 13)), new String(a(paramArrayOfByte, 14, d(paramArrayOfByte))) };
    }
    while (paramArrayOfByte != null)
    {
      byte b = paramArrayOfByte[0];
      String str;
      for (;;)
      {
        if (b.startsWith("0"))
        {
          str = b.substring(1, b.length());
          continue;
          paramArrayOfByte = null;
          break;
        }
      }
      long l2 = Long.valueOf(str).longValue();
      long l1 = Long.valueOf(paramArrayOfByte[1]).longValue();
      if (System.currentTimeMillis() <= l2 + l1 * 1000L) {
        break;
      }
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramInt2 - paramInt1;
    if (i < 0) {
      throw new IllegalArgumentException(String.format("%d > %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, Math.min(paramArrayOfByte.length - paramInt1, i));
    return arrayOfByte;
  }
  
  protected static byte[] b(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (c(paramArrayOfByte)) {
      arrayOfByte = a(paramArrayOfByte, d(paramArrayOfByte) + 1, paramArrayOfByte.length);
    }
    return arrayOfByte;
  }
  
  private static boolean c(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 15) && (paramArrayOfByte[13] == 45) && (d(paramArrayOfByte) > 14)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private static int d(byte[] paramArrayOfByte)
  {
    int i = 0;
    if (i < paramArrayOfByte.length) {
      if (paramArrayOfByte[i] != 32) {}
    }
    for (;;)
    {
      return i;
      i++;
      break;
      i = -1;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */