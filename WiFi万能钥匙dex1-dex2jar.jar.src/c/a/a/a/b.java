package c.a.a.a;

import java.io.ByteArrayOutputStream;

public final class b
{
  public static String a(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    for (int i = 0; i < paramArrayOfByte.length; i++)
    {
      int k = (short)(paramArrayOfByte[i] & 0xFF);
      int j = (byte)(k >> 4);
      k = (byte)(k & 0xF);
      localByteArrayOutputStream.write("0123456789ABCDEF".charAt(j));
      localByteArrayOutputStream.write("0123456789ABCDEF".charAt(k));
    }
    return new String(localByteArrayOutputStream.toByteArray());
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/c/a/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */