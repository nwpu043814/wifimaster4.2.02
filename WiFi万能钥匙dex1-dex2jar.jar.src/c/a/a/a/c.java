package c.a.a.a;

import java.io.ByteArrayOutputStream;

public final class c
{
  private String a;
  private boolean b;
  private boolean c;
  
  public c(String paramString)
  {
    this.a = paramString;
    this.b = false;
    this.c = false;
  }
  
  public final String a(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    for (int j = 0; j < (paramArrayOfByte.length + 4) / 5; j++)
    {
      short[] arrayOfShort = new short[5];
      int i = 0;
      int k = 5;
      if (i < 5)
      {
        if (j * 5 + i < paramArrayOfByte.length) {
          arrayOfShort[i] = ((short)(paramArrayOfByte[(j * 5 + i)] & 0xFF));
        }
        for (;;)
        {
          i++;
          break;
          arrayOfShort[i] = 0;
          k--;
        }
      }
      switch (k)
      {
      default: 
        i = -1;
      }
      for (;;)
      {
        int i1 = (byte)(arrayOfShort[0] >> 3 & 0x1F);
        int i3 = (byte)((arrayOfShort[0] & 0x7) << 2 | arrayOfShort[1] >> 6 & 0x3);
        int n = (byte)(arrayOfShort[1] >> 1 & 0x1F);
        int i5 = (byte)((arrayOfShort[1] & 0x1) << 4 | arrayOfShort[2] >> 4 & 0xF);
        int m = (byte)((arrayOfShort[2] & 0xF) << 1 | arrayOfShort[3] >> 7 & 0x1);
        int i6 = (byte)(arrayOfShort[3] >> 2 & 0x1F);
        int i4 = (byte)((arrayOfShort[3] & 0x3) << 3 | arrayOfShort[4] >> 5 & 0x7);
        int i2 = (byte)(arrayOfShort[4] & 0x1F);
        for (k = 0; k < 8 - i; k++)
        {
          char c1 = this.a.charAt(new int[] { i1, i3, n, i5, m, i6, i4, i2 }[k]);
          char c2 = c1;
          if (this.c) {
            c2 = Character.toLowerCase(c1);
          }
          localByteArrayOutputStream.write(c2);
        }
        i = 6;
        continue;
        i = 4;
        continue;
        i = 3;
        continue;
        i = 1;
        continue;
        i = 0;
      }
      if (this.b) {
        for (i = 8 - i; i < 8; i++) {
          localByteArrayOutputStream.write(61);
        }
      }
    }
    return new String(localByteArrayOutputStream.toByteArray());
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */