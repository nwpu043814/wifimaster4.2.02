package com.lantern.core.h;

import com.bluefay.b.h;
import com.lantern.core.c;
import com.lantern.core.o;
import com.lantern.d.a;

public final class b
{
  public static int a(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte[0] & 0xFF) << 24 | (paramArrayOfByte[1] & 0xFF) << 16 | (paramArrayOfByte[2] & 0xFF) << 8 | paramArrayOfByte[3] & 0xFF;
  }
  
  private static byte[] a(int paramInt)
  {
    return new byte[] { (byte)(paramInt >> 24 & 0xFF), (byte)(paramInt >> 16 & 0xFF), (byte)(paramInt >> 8 & 0xFF), (byte)(paramInt & 0xFF) };
  }
  
  public static byte[] a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte1 = c.getServer().a(paramBoolean1, paramString1);
    byte[] arrayOfByte2 = c.getServer().u();
    byte[][] arrayOfByte = new byte[1][];
    arrayOfByte[0] = paramArrayOfByte;
    int i = arrayOfByte2.length + 5 + 0;
    for (int j = 0; j <= 0; j++) {
      i += arrayOfByte[0].length + 8;
    }
    paramArrayOfByte = new byte[i];
    paramArrayOfByte[0] = 2;
    System.arraycopy(a(arrayOfByte2.length), 0, paramArrayOfByte, 1, 4);
    System.arraycopy(arrayOfByte2, 0, paramArrayOfByte, 5, arrayOfByte2.length);
    j = arrayOfByte2.length + 5;
    for (i = 0; i <= 0; i++)
    {
      System.arraycopy(a(Integer.parseInt(new String[] { paramString2 }[0])), 0, paramArrayOfByte, j, 4);
      j += 4;
      System.arraycopy(a(arrayOfByte[0].length), 0, paramArrayOfByte, j, 4);
      j += 4;
      System.arraycopy(arrayOfByte[0], 0, paramArrayOfByte, j, arrayOfByte[0].length);
    }
    paramString2 = b(paramArrayOfByte);
    paramString1 = c.getServer().a(paramString2, paramString1, paramBoolean2, paramBoolean1);
    paramString2 = new byte[arrayOfByte1.length + 5 + paramString1.length];
    paramString2[0] = 0;
    System.arraycopy(a(arrayOfByte1.length), 0, paramString2, 1, 4);
    System.arraycopy(arrayOfByte1, 0, paramString2, 5, arrayOfByte1.length);
    System.arraycopy(paramString1, 0, paramString2, arrayOfByte1.length + 5, paramString1.length);
    return paramString2;
  }
  
  private static byte[] b(byte[] paramArrayOfByte)
  {
    try
    {
      byte[] arrayOfByte = a.a(paramArrayOfByte);
      paramArrayOfByte = arrayOfByte;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.a(localException);
      }
    }
    return paramArrayOfByte;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/h/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */